##############################################################
################## LIBRARY ###################################
##############################################################

from bottle import request, response, run, route, HTTPResponse
import uuid
import json
import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import sys
from elasticsearch import Elasticsearch

##############################################################

##############################################################
################## CONSTANTS #################################
##############################################################

###### LOAD CSV ##############################################

## Step 1: Read CSV File
df = pd.read_csv("movie_dataset.csv")
# print df.columns

###### SET FEATURES ##########################################

## Step 2: Select Features
features = ['keywords','cast','genres','director']

###### STOCK ALL MOVIES ######################################

movies_matching = []

###### ELASTICSEARCH CONFIG ##################################

## Host URL Elasticsearch
HOST_URLS = ["http://127.0.0.1:9200"]

## Instance of Elasticsearch
es_conn = Elasticsearch(HOST_URLS)
# print("Cluster Name : ", es_conn.cluster.state(metric=["cluster_name"])['cluster_name'])

## Create Index for Elasticsearch
INDEX_NAME = "mymovies-service"

## Create Doc Type for Elasticsearch
DOC_TYPE = "ranushan"

##############################################################
################## FUNCTIONS #################################
##############################################################

###### GET TITLE BY INDEX OF MOVIE ###########################

def get_title_from_index(index):
	return df[df.index == index]["title"].values[0]

###### GET INDEX BY TITLE OF MOVIES ##########################

def get_index_from_title(title):
	return df[df.title == title]["index"].values[0]

###### GET INDEX BY TITLE OF MOVIES ##########################

def get_id_from_title(title):
	return df[df.title == title]["id"].values[0]

###### COMBINE ALL FEATURES ##################################

def combine_features(row):
	try:
		return row['keywords'] + " " + row['cast'] + " " + row["genres"] + " " + row["director"]
	except:
		print("Error:", row)

###### MATCHING PROCESS  #####################################

def matching_process(nameOfMovie, nb_matches):

    listOfIdsMovies = []
    listOfMovies = []

    try:
        ## Step 3: Create a column in DF which combines all selected features
        for feature in features:
            df[feature] = df[feature].fillna('')

        df["combined_features"] = df.apply(combine_features,axis=1)

        # print "Combined Features:", df["combined_features"].head()

        ## Step 4: Create count matrix from this new combined column
        cv = CountVectorizer()

        count_matrix = cv.fit_transform(df["combined_features"])

        ## Step 5: Compute the Cosine Similarity based on the count_matrix
        cosine_sim = cosine_similarity(count_matrix) 
        movie_user_likes = nameOfMovie

        ## Step 6: Get index of this movie from its title
        movie_index = get_index_from_title(movie_user_likes)

        similar_movies = list(enumerate(cosine_sim[movie_index]))

        ## Step 7: Get a list of similar movies in descending order of similarity score
        sorted_similar_movies = sorted(similar_movies,key=lambda x:x[1],reverse=True)

        ## Step 8: Print titles of first n movies
        i=0
        for element in sorted_similar_movies:
                listOfIdsMovies.append(get_id_from_title(get_title_from_index(element[0])))
                listOfMovies.append(get_title_from_index(element[0]))
                #print(get_title_from_index(element[0]))
                i=i+1
                if i>nb_matches:
                    break
    except:
        print("Unexpected error: ", sys.exc_info()[0])
    
    return listOfIdsMovies, listOfMovies

def sendDataToElasticSearch(id, movie_name, nb_matches, list_of_ids_movies, movies_matching):
    data = { "id": id, "movie_name": movie_name, "nb_matches": nb_matches, "list_of_ids_movies": list_of_ids_movies, "movies_matching": movies_matching }
    res = es_conn.create(index=INDEX_NAME, doc_type=DOC_TYPE, body=data, id=id, refresh=True)

##############################################################
################## CONTROLLERS ###############################
##############################################################

###### TEST MY API ###########################################

@route('/test', method='GET')
def test():
    return HTTPResponse(
        status=200,
        body=json.dumps({'body': 'Hello world!'})
    )

###### START MATCHING ########################################

@route('/start_matching', method='POST')
def start_matching():
    """
    Starts the matching process for movies

    :return: HTTP/1.1 200 OK, body: Movie object
    """

    getMovie_Name = request.forms.get('movie_name')
    getNb_Matches = request.forms.get('nb_matches')
    
    if not getMovie_Name:
        return HTTPResponse(
            status=200,
            body="movie_name field is empty"
        )

    if not getNb_Matches:
        return HTTPResponse(
            status=200,
            body="nb_matches field is empty"
        )

    job_id = str(uuid.uuid4())
    movie_name = str(getMovie_Name)
    nb_matches = int(getNb_Matches)

    movies_id_matching, movies_matching = matching_process(movie_name, nb_matches)
    #print(movies_id_matching)
    #print(movies_matching)

    if not movies_matching or not movies_id_matching:
        return HTTPResponse(
            status=200,
            body="No Matching found for" + " " + "\"" + movie_name + "\"" + " " + "Movie."
        )

    list_of_ids_movies = []

    for listOfIds in movies_id_matching:
        # print(list_of_ids_movies)
        list_of_ids_movies.append(str(listOfIds))

    # Creating the MovieMatching object
    resultMovie_Matching = json.dumps({
        'id': job_id,
        'movies_matching': movies_matching,
        'list_of_ids_movies': list_of_ids_movies
    })

    sendDataToElasticSearch(job_id, movie_name, nb_matches, list_of_ids_movies, movies_matching)

    return HTTPResponse(
        status=200,
        body=resultMovie_Matching
    )

##############################################################
################## MAIN FUNCTION #############################
##############################################################

###### MAIN ##################################################

if __name__ == '__main__':
    run(host='0.0.0.0', port=6060, server='paste')

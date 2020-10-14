# Microservice DataMining
## Machine Learning for MovieDB

### CLONE PROJECT

`git clone https://github.com/ranushan/microservice-my-movies.git`

`cd datamining-movie-service`

### CREATE VIRTUAL MACHINE WITH VAGRANT

UP your virtual machine : `vagrant up`

Connect with ssh on your virtual machine : `vagrant ssh`

### RUN ELASTICSEARCH

`./elasticsearch-7.9.2/bin/elasticsearch`

Verify : `curl localhost:9200`

### RUN KIBANA

`./kibana-7.9.2-linux-x86_64/bin/kibana`

Verify : `curl localhost:5601`

### RUN MACHINE LEARNING PROGRAMME

`python3 movie-recommendation.py`

### POSTMAN

Set on Headers :
- Key : `Content-Type` Value : `application/json`
- Key : `Content-Type` Value : `application/json`

Set on Body (form-data) :
- Key : `movie_name` Value : `Avatar`
- Key : `nb_matches` Value : `5`

SEND !!!

### VISUALIZE

Normally Kibana force to create a document

On Kibana : 
- Kibana Model : Select => Visualize
- Click : Create Visualization
- Visualize Type : Select => Area
- Source : Select => mymovies-service
- Data : 
    - Metrics :
        - Y-axis :
            - Aggregation : Count
            - Custom label : Numbers of Times
    - Buckets :
        - Y-axis :
            - Aggregation : Terms
            - Field : movies_matching.keyword
            - Order by : Alphabetical
            - Order : Descending
            - Size : 20
            - Custom label : Movies

Save your Visualization

### DELETE DOCUMENT

`curl -XDELETE 'localhost:9200/mymovies-service/`

### DELETE SPECIFIC DOCUMENT

`curl -XDELETE 'localhost:9200/mymovies-service/{id}`
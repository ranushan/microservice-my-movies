from elasticsearch import Elasticsearch

HOST_URLS = ["http://127.0.0.1:9200"]

es_conn = Elasticsearch(HOST_URLS)

print("Cluster Name : ", es_conn.cluster.state(metric=["cluster_name"])['cluster_name'])

INDEX_NAME = "mymovies-service"

TYPE_NAME_USER = "ranushan"

res = es_conn.indices.create(index=INDEX_NAME, ignore=400)

data = { "id": "1234-azert-567-yui-890", "movies_matching": ["Avatar", "Galaxy", "Aliens"] }

res = es_conn.create(index=INDEX_NAME, doc_type=TYPE_NAME_USER, body=data, id=1, refresh=True)
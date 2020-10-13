# Install Python 3 Pip

sudo apt-get install python3-pip -y

# Install sklearn library for Python 3

pip3 install sklearn

# Install pandas library for Python 3

pip3 install pandas

# Install bottle library for Python 3

pip3 install bottle

# Install paste library for Python 3

pip3 install paste

# Install OpenJDK 8

sudo apt-get install openjdk-8-jdk -y

# Get ElasticSearch

wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.9.2-linux-x86_64.tar.gz

# Unarchive ElasticSearch

tar -xzf elasticsearch-7.9.2-linux-x86_64.tar.gz

# Change config set http.host: 0.0.0.0

sed -i 's/#network.host: 192.168.0.1/#network.host: 192.168.0.1\nhttp.host: 0.0.0.0/' ~/elasticsearch-7.9.2/config/elasticsearch.yml

# Install elasticsearch library for Python 3

pip3 install elasticsearch

# Get Kibana

wget https://artifacts.elastic.co/downloads/kibana/kibana-7.9.2-linux-x86_64.tar.gz

# Unarchive Kibana

tar -xzf kibana-7.9.2-linux-x86_64.tar.gz

# Change config set http.host: 0.0.0.0

sed -i 's/#server.host: "localhost"/server.host: "0.0.0.0"/' ~/kibana-7.9.2-linux-x86_64/config/kibana.yml

# RUN ELASTICSEARCH : ./elasticsearch-7.9.2/bin/elasticsearch
# RUN KIBANA        : ./kibana-7.9.2-linux-x86_64/bin/kibana
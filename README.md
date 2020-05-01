#Basic Commands

###Deploy the application: `$ docker-compose up`

###Teardown the applicaiton: `$ docker-compose down`

##

###Containerized migrations

####Find out the network your application is deployed on: `$docker network ls`

####Build the dockerfile: `$ docker build -t migration .`

####Run the migration image in the network of the application container: `$ docker run --network=<'network'> migration`


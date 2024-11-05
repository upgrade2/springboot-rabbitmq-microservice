Please Make sure you have Rabbit MQ is Downloaded from Docker and run
Follow commands if you have docker install on your system:


# To download rabbitmq from docker
docker pull rabbitmq:3.10.5-management

# To run rabbitmq from docker
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.10.5-management

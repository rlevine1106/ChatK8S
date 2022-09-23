# RabbitMQ Setup

## Install the RabbitMQ Cluster Operator

```
$ kubectl apply -f "https://github.com/rabbitmq/cluster-operator/releases/latest/download/cluster-operator.yml"
```

## Deploy Rabbit MQ with your app specific settings

```
$ kubectl apply -f rabbitmq.yml
$ kubectl apply -f allow-rabbitmq-traffic.yml
```

## Starting the RabbitMQ dashboard
```
 $ kubectl port-forward "service/stomp-messagebroker" 15672
```

* Navigate in your browser to [http://localhost:15672](http://localhost:15672)
* You can get the username and password from the kurbernetes dashboard / secrets / stomp-messagebroker-default-user


### Quick start guide 

* [RabbitMQ Cluster Kubernetes Operator Quickstart](https://www.rabbitmq.com/kubernetes/operator/quickstart-operator.html)



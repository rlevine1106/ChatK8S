# ChatK8S

## Overview
* [Assignment](./Exercise.md)

## Infrastructure Diagram

[<img src="Infrastructure.png" width="50%"/>](Infrastructure.png)

## Prerequisites
* Docker
* Minikube
* kubectl
* helm
* java jdk 11 
* maven

## Installation

* [Postgres](./message/README.md)
* [RabbitMQ](./RabbitMQSetup/README.md)
* [Logging](./grafana/README.md)
* [websocket-sender](./websocket-sender/README.md)
* [websocket-receiver](./websocket-receiver/README.md)

## How to run

```
$ minikube service websocket-receiver-service
```

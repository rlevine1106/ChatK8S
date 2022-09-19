# message 

## Overview

Kubernetes service to save and deliver messages from a postgres database

## Setup postgres database

* kubectl apply -f postgres-secrets.yml
* kubectl apply -f postgres-volume.yml
* kubectl apply -f postgres-claim.yml
* kubectl apply -f postgres-service.yml
* kubectl apply -f postgres-deployment.yml
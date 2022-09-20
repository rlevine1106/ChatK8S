# message 

## Overview

Kubernetes service to save and deliver messages from a postgres database

## Setup postgres database

* ```kubectl apply -f postgres-secrets.yml```
* ```kubectl apply -f pv-volume.yml```
* ```kubectl apply -f pv-claim.yml```
* ```kubectl apply -f postgres-service.yml```
* ```kubectl apply -f postgres-deployment.yml```

## Start postgres command prompt

* ```kubectl get pods```
* ```winpty kubectl exec -it pod-name -- psql -U postgres```

## Create messages database

* ```CREATE DATABASE messages;```
* ```CREATE TABLE user_messages (dte DATE PRIMARY KEY NOT NULL, usr TEXT NOT NULL, msg TEXT NOT NULL);```

Verify table was created by running:
* ```\d```


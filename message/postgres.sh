#!/bin/bash

export POD_NAME=`kubectl get pods | grep post | awk '{ printf $1 }'`
winpty kubectl exec -it ${POD_NAME} -- psql -U postgres

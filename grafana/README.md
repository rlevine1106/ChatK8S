
## Setup Logs with Grafana/Loki

The following is a list of instructions you can use to complete the setup. More in-depth instructions can be found [here](https://medium.com/codex/setup-grafana-loki-on-local-k8s-cluster-minikube-90450e9896a8). 

$ ```minikube start```

$```minikube addons enable ingress```

$```helm repo add loki https://grafana.github.io/loki/charts```

$```helm repo update```

$```helm upgrade --install loki --namespace=default grafana/loki-stack```

$```helm repo add grafana https://grafana.github.io/helm-charts```

$```helm repo update```

$```helm upgrade --install grafana --namespace default -f grafana-values.yml grafana/grafana```

$```kubectl get secret --namespace default grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo```

## Grafana Dashboard

The following command will launch a grafana webpage where you can use username: admin and the password from the last command. 

$```minikube service grafana```

Navigate Settings tab on the left > select Data Sources > select Loki
  Under URL input box enter: http://loki:3100 and click SAVE & TEST buttom on the bottom.
  
### Explore Logs

Navigate to Explore tab on the left > under Labels choose what you want to see logs for ie. app, pod > then select specific instance to see logs for

Clink Run Query button on the top right corner.

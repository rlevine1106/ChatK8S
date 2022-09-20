# websocket-sender

## Building

```
$ mvn clean install
$ docker build -t <<docker id>>/websocket-sender .
$ docker push <<docker id>>/websocket-sender
```

## Running locally

docker run -d -p 8090:8090 -t <<docker id>>/websocket-sender

### Misc

Open web: http://localhost:8091/

Send message to:
```
curl --location --request POST 'http://localhost:8090/submit' \
--header 'Content-Type: text/plain' \
--data-raw 'ok'
```

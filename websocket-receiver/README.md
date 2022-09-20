# websocket-receiver

## Building

```
$ mvn clean install
$ docker build -t <<docker id>>/websocket-receiver .
$ docker push <<docker id>>/websocket-receiver
```

## Running locally

docker run -d -p 8091:8091 -t <<docker id>>/websocket-receiver

### Misc 

Open web: http://localhost:8091/

Send message to:
```
curl --location --request POST 'http://localhost:8090/submit' \
--header 'Content-Type: text/plain' \
--data-raw 'ok'
```

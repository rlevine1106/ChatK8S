var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
        $("#username").prop( "disabled", true );
    }
    else {
        $("#conversation").hide();
        $("#username").prop( "disabled", false );
    }
    $("#messages").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected to: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            console.log('received: ' + message.body);
            showMessage(message.body);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	var chatRequest = {
            chatUser: $("#username").val(),
            message: $("#name").val()
        };
    stompClient.send("/app/hello", {}, JSON.stringify(chatRequest));
}

function showMessage(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
websocket = {
    stompClient: null,
    setConnected: function (connected) {
        $('#connect').prop('disabled', connected);
        $('#disconnect').prop('disabled', !connected);
        if (connected) {
            $('#conversation').show();
            $('#chat').show();
        } else {
            $('#conversation').hide();
            $('#chat').hide();
        }
        $('#greetings').html('');
    },
    connect: function () {
        if (!$('#name').val()) {
            return;
        }
        let socket = new SockJS('/chat');
        this.stompClient = Stomp.over(socket);
        this.stompClient.connect(
            {},
            function (frame) {
                this.setConnected(true);
                this.stompClient.subscribe(
                    '/topic/greetings',
                    function (greeting) {
                        this.showGreeting(JSON.parse(greeting.body));
                    }
                );
            }
        );
    },
    disconnect: function () {
        if (this.stompClient != null) {
            this.stompClient.disconnect();
        }
        this.setConnected(false);
    },
    sendName: function () {
        this.stompClient.send(
            '/app/hello',
            {},
            JSON.stringify(
            {
                    'name': $('#name').val(),
                    'content': $('#content').val()
                    }
            )
        );
    },
    showGreeting: function (message) {
        $('#greetings').append('<div>' + message.name + ':' + message.content + '</div>')
    }
}


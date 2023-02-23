//package com.javatechie.spring.ws.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandler;
//import org.springframework.web.socket.WebSocketHttpHeaders;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//
//@Configuration
//public class WebSocketClientConfig {
//
//    @Bean
//    public WebSocketStompClient stompClient() {
//        return new WebSocketStompClient(new StandardWebSocketClient());
//    }
//
//    @Bean
//    public StompSession stompSession(WebSocketStompClient stompClient) throws Exception {
//        StompSessionHandler sessionHandler = new MyStompSessionHandler(); // custom handler for incoming STOMP messages
//        return stompClient.connect("ws://localhost:8081/web", new WebSocketHttpHeaders(), sessionHandler).get();
//    }
//
//    // ... other configuration ...
//}

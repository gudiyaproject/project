package com.devops;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) {
                try {

                    String response = "Hello from DevOps Project";

                    byte[] responseBytes = response.getBytes();

                    exchange.sendResponseHeaders(200, responseBytes.length);

                    OutputStream os = exchange.getResponseBody();
                    os.write(responseBytes);
                    os.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        server.start();

        System.out.println("Server started on port 8080");
    }
}

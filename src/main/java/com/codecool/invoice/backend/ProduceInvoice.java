package com.codecool.invoice.backend;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class ProduceInvoice implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String line;
        String response = "";

        try {
            File html = new File("/home/jonatan/codecool/module3/TW2/invoice/src/main/java/com/codecool/invoice/frontend/invoice.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(html)));

            while ((line = bufferedReader.readLine()) != null) {
                response += line;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendResponse(exchange, response);
    }

    public void sendResponse(HttpExchange exchange, String response) {
        byte[] bytes = response.getBytes();
        try {
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.codecool.invoice;

import com.codecool.invoice.backend.InvoiceCreation;
import com.codecool.invoice.backend.MainPage;
import com.codecool.invoice.backend.ProduceInvoice;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);

            server.createContext("/", new MainPage());
            server.createContext("/create", new InvoiceCreation());
            server.createContext("/invoice", new ProduceInvoice());

            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

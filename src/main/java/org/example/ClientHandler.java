package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{

    private StoreCar store;
    private Socket clientSocket;

    private InetAddress inetAddress;

    public ClientHandler(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
        store = new StoreCar();
        store.buildList();
        inetAddress = this.clientSocket.getInetAddress();
    }


    private boolean manage()
    {
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }

        System.out.println("Connected from: " +inetAddress);
        out.println("Benvenuto Client: "+inetAddress);

        Gson g = new Gson();
        String s ="";

        while (true) {
            out.println("Inserisci la tua richiesta (premi exit per uscire): ");
            try {
                s = in.readLine();
                if (s == null) {
                    System.out.println("Exit from: " + inetAddress);
                    clientSocket.close();
                    return false;
                } else if (s.equalsIgnoreCase("exit")) {
                    System.out.println("Exit from: " + inetAddress);
                    clientSocket.close();
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            out.println("Working on...");
            out.println("Answer: ");
            String result = executeCommand(s);
            out.println(result);
        }
    }

    private String executeCommand(String s)
    {
        if(s.equals("all"))
        {
            return store.getListAsJSON();
        }
        else if(s.equals("all_sorted"))
        {
            return store.getListAsJSON(store.carSort());
        }
        else if(s.equals("more_expensive"))
        {
            return store.getListAsJSON(store.moreExpensive());
        }

        return "Error command not recognized";
    }
    @Override
    public void run() {
        manage();
    }
}

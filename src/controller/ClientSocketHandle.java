
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author admin
 */
public class ClientSocketHandle implements Runnable {

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    
    public ClientSocketHandle (Socket socket) throws UnknownHostException {
        this.socket = socket;
    }
    
    public void write(String message) {
        writer.println(message);
        writer.flush();
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                

                String receivedMessage = reader.readLine();
                String[] msg = receivedMessage.trim().split(" ");
                String res = msg[0];
                
               
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

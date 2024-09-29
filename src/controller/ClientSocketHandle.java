
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ClientSocketHandle implements Runnable {

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    
    public ClientSocketHandle (Socket socket) {
        try {
            this.socket = socket;
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void write(String message) {
        writer.println(message);
        writer.flush();
    }
    
    @Override
    public void run() {
        write("hello");
        try {
            while (true) {
                String receivedMessage = reader.readLine();
                String[] msg = receivedMessage.trim().split(" ");
                String res = msg[0];
                
                System.out.println(res);
                
//                if (res[0].equals("")) {
//                    
//                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

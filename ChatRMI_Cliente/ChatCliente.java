/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.chatrmi.cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pj.chatrmi.servidor.ChatServerIF;

/**
 *
 * @author Acer
 */
public class ChatCliente extends UnicastRemoteObject implements ChatClientIF, Runnable {
    
    private ChatServerIF chatServer;
    private String name = null;
    
    protected ChatCliente(String name,  ChatServerIF chatServer) throws RemoteException{
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerChatCliente(this);
    }
    
    @Override
    public synchronized void registerChatCliente(String msg)throws RemoteException{
        System.out.println(msg);
    }
    
    @Override
    public void run(){
        Scanner ler = new Scanner(System.in);
        
        String msg;
        
        while (true) {            
            msg = ler.nextLine();
            try {
                chatServer.broadcastMensagem(name + ":" + msg);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}

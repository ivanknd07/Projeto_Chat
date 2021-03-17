/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.chatrmi.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import pj.chatrmi.servidor.ChatServerIF;


/**
 *
 * @author Acer
 */
public class ChatDriverCliente {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
       String chatServerURL = "rmi://localhost/RMIChatServidor";
       
       ChatServerIF chatServer = (ChatServerIF)Naming.lookup(chatServerURL);
       new Thread(new ChatCliente(args[0], chatServer)).start();
    }
}

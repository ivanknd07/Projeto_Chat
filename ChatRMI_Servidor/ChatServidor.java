/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.chatrmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pj.chatrmi.cliente.ChatClientIF;
/**
 *
 * @author Acer
 */
public class ChatServidor extends UnicastRemoteObject implements ChatServerIF{
    
    private static final long serialVersionUID = 1L;
    private ArrayList<ChatClientIF> chatClientes;
    
    protected ChatServidor() throws RemoteException{
        chatClientes = new ArrayList<ChatClientIF>();
    }
    
    @Override
    public synchronized void registerChatCliente(ChatClientIF chatCliente)throws RemoteException{
        this.chatClientes.add(chatCliente);
    }
    
    @Override
    public synchronized void broadcastMensagem(String msg)throws RemoteException{
        int i = 0;
         while(i < chatClientes.size()){
             chatClientes.get(i++).registerChatCliente(msg);
         }
    }
}

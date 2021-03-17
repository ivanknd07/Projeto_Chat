/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.chatrmi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pj.chatrmi.cliente.ChatClientIF;

/**
 *
 * @author Acer
 */
public interface ChatServerIF extends Remote{
    void registerChatCliente(ChatClientIF msgCliente)  throws RemoteException;
    void broadcastMensagem(String msg) throws RemoteException;
}

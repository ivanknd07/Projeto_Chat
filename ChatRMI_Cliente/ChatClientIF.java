/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.chatrmi.cliente;

import java.rmi.RemoteException;

/**
 *
 * @author Acer
 */
public interface ChatClientIF {
    void registerChatCliente(String msg)  throws RemoteException;
    //void broadcastMensagem() throws RemoteException;
}

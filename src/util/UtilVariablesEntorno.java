/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author wilmer
 */
public class UtilVariablesEntorno {

    public String ip() {
        String ip = "";
        InetAddress iaLocalAddress = null;
        try {
            iaLocalAddress = InetAddress.getLocalHost();
            String address[]=iaLocalAddress.toString().split("/");
            ip = address[1];
        } catch (UnknownHostException ex) {
            System.out.println(ex.toString());
        }
        
        return ip;
    }

}

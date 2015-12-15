/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nieruchomosci.biuro;

import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import com.nieruchomosci.biuro.biuroniruchomoscitest.Constrant;
import java.awt.Color;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomasz
 */
public class classCheck extends Thread{
    BazaBiura _server;
    private float R=1f;
    private float G=1f;
    StatusServera _status;
    boolean connectioLose = false;
    
    classCheck(BazaBiura server, StatusServera status){
        _status=status;
        _server=server;
    } 
    
            
    @Override
     public void run() {
         
        while(true) {
            try {
                Registry rs = LocateRegistry.getRegistry("localhost", Constrant.PORT);
                BazaBiura sc = (BazaBiura) rs.lookup(Constrant.RMI_ID);
                //if(_server != null && _server.isOnline()){
                    _status.Status.setBackground(new Color(0f,G,0f));
                    if(G<=1f && G==0.7f){
                        G=(G-0.1f)%1;
                    }else{
                        G=0.7f;
                    }
                    if(connectioLose){
                        JOptionPane.showMessageDialog(null, "Po³¹czenie zosta³o odzyskane!"
                                + "Aby móc dalej pracowaæ, nale¿y zalogowaæ siê ponownie.");
                        connectioLose = false;
                    }
                //}
            } catch (Exception ex) {
                    
               _status.Status.setBackground(new Color(R,0f,0f));
                if(R<=1f && R==0.7f){
                    R=(R-0.1f)%1;
                }else{
                    R=0.7f;
                }
                if (!connectioLose){
                    connectioLose = true;
                    JOptionPane.showMessageDialog(null, "Po³¹czenie zosta³o zerwane! Proszê zabezpiecz danê, aby nie zosta³y one utracone!");
                }
            }
            try {
                //usypiamy wÄ…tek na 100 milisekund
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

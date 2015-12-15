
package nieruchomosci.biuro;

import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import com.nieruchomosci.biuro.biuroniruchomoscitest.Constrant;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ReturnConnection extends Thread{
    
    private BiuroNieruchomosci bn;
    private boolean connLose = false;
    
    public ReturnConnection(BiuroNieruchomosci bn) {
        this.bn = bn;
    }

    @Override
    public void run() {
        try {
            Registry rs = LocateRegistry.getRegistry("localhost", Constrant.PORT);
            BazaBiura sc;
            //while(true){
                try{
                    sc = (BazaBiura) rs.lookup(Constrant.RMI_ID);
                } catch (RemoteException | NotBoundException e){
                    JOptionPane.showMessageDialog(bn, "Po��czenie zosta�o zerwane! Prosz� zabezpiecz dan�, aby nie zosta�y one utracone!");
                    System.out.println("nie t�dy droga");
                }
           // }
        } catch (RemoteException ex) {
            Logger.getLogger(ReturnConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}

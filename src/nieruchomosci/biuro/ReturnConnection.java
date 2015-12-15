
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
                    JOptionPane.showMessageDialog(bn, "Po³¹czenie zosta³o zerwane! Proszê zabezpiecz danê, aby nie zosta³y one utracone!");
                    System.out.println("nie têdy droga");
                }
           // }
        } catch (RemoteException ex) {
            Logger.getLogger(ReturnConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}

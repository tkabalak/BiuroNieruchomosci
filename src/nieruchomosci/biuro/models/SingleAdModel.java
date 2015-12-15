
package nieruchomosci.biuro.models;

import nieruchomosci.biuro.view.ShowSingleAd;
import nieruchomosci.biuro.entity.Oferta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import nieruchomosci.biuro.classDB;


public class SingleAdModel {
    private final EntityManager em;    
    private final Oferta o;
    private ShowSingleAd jpanel;
    private JFrame frame;
    private final Map<Integer, SingleAdModel> windows;
    private final int idOnMap;
    private static final Logger logger = Logger.getLogger(SingleAdModel.class.getName());
    private final classDB db;
    
    public SingleAdModel(EntityManager em, Oferta o, Map<Integer, SingleAdModel> windows, int idOnMap, classDB db) {
        this.em = em;
        this.o = o;
        this.windows = windows;
        this.idOnMap = idOnMap;
        this.db = db;
    }
    
    public void start(){
        java.awt.EventQueue.invokeLater(() -> {
            frame = new JFrame("Szczegó³y og³oszenia");
            jpanel = new ShowSingleAd();
            db.setValues(jpanel.getLabalList(), em, o);
            frame.add(jpanel);
            frame.pack();
            frame.setVisible(true);
            
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    windows.remove(idOnMap);
                    System.out.println("1234");
                }
            });
        });
    }
    
    public boolean isMin(){
        if (frame != null) 
            return frame.isMinimumSizeSet();
        return false;
    }
    
    public void setMaxSizeWindow() {
        frame.setState(JFrame.NORMAL);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.em);
        hash = 97 * hash + Objects.hashCode(this.o);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleAdModel other = (SingleAdModel) obj;
        if (!Objects.equals(this.em, other.em)) {
            return false;
        }
        return Objects.equals(this.o, other.o);
    }
}
    
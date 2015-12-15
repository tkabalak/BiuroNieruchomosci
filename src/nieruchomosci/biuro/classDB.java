
package nieruchomosci.biuro;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nieruchomosci.biuro.entity.Adres;
import nieruchomosci.biuro.entity.Oferta;
import nieruchomosci.biuro.entity.ProfilUzytkownika;
import nieruchomosci.biuro.entity.Szczegoly;
import nieruchomosci.biuro.entity.Wojewodztwo;

/**
 *
 * @author Tomasz
 */
public class classDB implements BazaBiura{
    String url = "jdbc:mysql://lamp.ii.us.edu.pl:3306/ii284244";
    String user = "ii284244";
    String password = "a23061992A.";

    Settings settings;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    private boolean connectionStatus; // zmianna przechowująca informacje o tym czy zostało nawiązane połączenia ze zdalną bazą 
    
    public classDB() throws SQLException{
        
            try {
                settings = SettingFile.readFile();
                if (settings != null){
                    con = (Connection) DriverManager.getConnection(settings.getURL(), settings.getUSER(), settings.getPASSWORD());
                    connectionStatus = false;
                } else {
                    System.out.println("null w settings");
                    throw new SQLException();
                }
            } catch (Exception ex ) {
                JOptionPane.showMessageDialog(null, "Prosz� uruchomi� lokalna baz� danych!");
            }
        
    }
   public boolean getStatus(){
       return connectionStatus;
   }
   
   public boolean Is_connect() throws SQLException{
       try{
           if(con!=null){
           con = (Connection) DriverManager.getConnection(url, user, password);
           }
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from Uzytkownik limit 1");
            while(rs.next()){
                return true;
            }
       }catch (SQLException e) {
   // TODO : log the exception ...
            return false;
        }
        finally {
            if (st != null) st.close();
            if (rs != null) rs.close();
        } 
       //}
        return false;
   }
    
    @Override
    public boolean Is_userIhaslo(String login,String haslo){
        boolean flaga=false;
        if(con!=null){
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from Uzytkownik");

            while(rs.next()){
                if(rs.getString("Login").equals(login) && rs.getString("Haslo").equals(haslo)){
                    flaga=true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 123");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        }
        return flaga;
    }
    
    @Override
     public boolean Is_user(String login){
        boolean flaga=false;
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from Uzytkownik");

            while(rs.next()){
                if(rs.getString("Login").equals(login)){
                    flaga=true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    
    public boolean Add_user(String login,String haslo){
        boolean flaga=false;
        try {
            
            if(!Is_user(login)){
            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO Uzytkownik (ID,Login,Haslo,Data_utworzenia)" +
                "VALUES (null,?,?,NOW());";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
prepStmt.setString(1, login);
prepStmt.setString(2, haslo);
prepStmt.executeUpdate();

           flaga=true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    
     public boolean Add_profilUser(String imie,String nazwisko,int ID){
        boolean flaga=false;
        try {
            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO ProfilUzytkownika (ID,ID_uzytkownika,Imie,Nazwisko)" +
                "VALUES (null,?,?,?);";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
prepStmt.setInt(1, ID);
prepStmt.setString(2, imie);
prepStmt.setString(3, nazwisko);

prepStmt.execute();

           flaga=true;
            

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    @Override
    public boolean Add_oferta(int ID_user,String Transakcja,double czynsz,double m2,int pietro,int max_pieter,int rok){
        boolean flaga=false;
        try {

            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO Oferta (ID,ID_profil,Transakcja,Czynsz,PowM2,Pietro,Ilosc_pieter,Rok_budowy,Widoczny,Data_utworzenia)" +
                "VALUES (null,?,?,?,?,?,?,?,0,NOW());";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
                prepStmt.setInt(1, ID_user);
                prepStmt.setString(2, Transakcja);
                prepStmt.setDouble(3, czynsz);
                prepStmt.setDouble(4, m2);
                prepStmt.setInt(5, pietro);
                prepStmt.setInt(6, max_pieter);
                prepStmt.setInt(7, rok);
                prepStmt.execute();
                flaga=true;

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    @Override
    public boolean Add_adres(String panstwo,String Wojewodztwo,String dzielnica,String ulica){
        boolean flaga=false;
        int ID_oferta=getOfertaID_dodaj();
        int ID_wojewodztwa=getWojwodztwoID(Wojewodztwo);
        try {
            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO Adres (ID,ID_oferty,Panstwo,ID_wojewodztwa,Dzielnica_wies,Ulica)" +
                "VALUES (null,?,?,?,?,?);";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
                prepStmt.setInt(1, ID_oferta);
                prepStmt.setString(2, panstwo);
                prepStmt.setInt(3, ID_wojewodztwa);
                prepStmt.setString(4, dzielnica);
                prepStmt.setString(5, ulica);
                prepStmt.execute();
                flaga=true;

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    
    @Override
    public boolean Add_szczegoly(String rodzaj,String stan,String okna,String ogrzewanie,String lazienka,
                                 String WC,boolean kuchnia,boolean garaz,boolean piwnica,boolean parking,
                                 boolean umeblowanie,boolean winda,boolean balkon,boolean zsyp,boolean woda)
    {
        int _kuchnia=zwrotInt(kuchnia);
        int _garaz=zwrotInt(garaz);
        int _piwnica=zwrotInt(piwnica);
        int _parking=zwrotInt(parking);
        int _umeblowanie=zwrotInt(umeblowanie);
        int _winda=zwrotInt(winda);
        int _balkon=zwrotInt(balkon);
        int _zsyp=zwrotInt(zsyp);
        int _woda=zwrotInt(woda);
        int ID_oferta=getOfertaID_dodaj();
        boolean flaga=false;
        try {

            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO Szczegoly (ID,ID_oferty,Rodzaj_wlasnosci,Okna,Ogrzewanie,Ciepla_woda,Lazienka,WC,Kuchnia,Garaz,Miejsce_parkingowe,Piwnica,Balkon,Winda,Zsyp,Umeblowanie)" +
                "VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setInt(1, ID_oferta);
            prepStmt.setString(2, rodzaj);
            prepStmt.setString(3, okna);
            prepStmt.setString(4, ogrzewanie);
            prepStmt.setInt(5, _woda);
            prepStmt.setString(6, lazienka);
            prepStmt.setString(7, WC);
            prepStmt.setInt(8, _kuchnia);
            prepStmt.setInt(9, _garaz);
            prepStmt.setInt(10, _parking);
            prepStmt.setInt(11, _piwnica);
            prepStmt.setInt(12, _balkon);
            prepStmt.setInt(13, _winda);
            prepStmt.setInt(14, _zsyp);
            prepStmt.setInt(15, _umeblowanie);
            prepStmt.execute();

           flaga=true;
            

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    
    @Override
    public boolean Add_toKalendarz(int user,String date,String text){
        boolean flaga=false;
        try {
            st = (Statement) con.createStatement();
            String selectStatement = "INSERT INTO Kalendarz (ID,ID_user,Data,tresc)" +
                "VALUES (null,?,?,?);";
            java.sql.PreparedStatement prepStmt = con.prepareStatement(selectStatement);
                prepStmt.setInt(1, user);
                prepStmt.setString(2, date);
                prepStmt.setString(3, text);
                prepStmt.execute();
                flaga=true;

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return flaga;
    }
    
    @Override
    public int getUserID(String login){
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select ID from Uzytkownik Where Login like '"+login.toString()+"'");

            while(rs.next()){
                int temp= rs.getInt("ID");
                    return temp;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return 0;
    }
    @Override
    public int getOfertaID_dodaj(){
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select ID from Oferta order by ID desc limit 1");

            while(rs.next()){
                int temp= rs.getInt("ID");
                    return temp;
                
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return 0;
    }
    @Override
    public int getWojwodztwoID(String nazwa){
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select ID from Wojewodztwo where Wojewodztwo like '"+nazwa+"'");

            while(rs.next()){
                int temp= rs.getInt("ID");
                    return temp;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        return 0;
    }
    
    @Override
    public String[] getKalendarzMiesieczny(int id,int miesiac,int rok,int iloscDni){
        String [] tresc= new String[iloscDni];
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select Data,tresc from Kalendarz Where ID_user = "+id+" && Data like '??-"+miesiac+"-??' order by Data  ");
            //int i=1;
            while(rs.next()){
                for(int i=0;i<miesiac;i++){
                String day= ((i+1<=9)?"0"+(i+1):(i+1)+"");
                if(rs.getString("tresc")== day+"-"+miesiac+"-"+rok){
                tresc[i]= rs.getString("tresc");    
                }else{
                tresc[i]= "brak";    
                }
                }
            }
            return tresc;
        } catch (SQLException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
               Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        //return null;
        return null;
    }
    @Override
    public String getKalendarzDzien(int id,int Dni,int miesiac,int rok){
        String tresc="brak";
        String day= ((Dni<=9)?"0"+(Dni):(Dni)+"");
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select tresc from Kalendarz Where ID_user = "+id+" && Data like '"+day+"-"+miesiac+"-"+rok+"' ");
            //int i=1;
            while(rs.next()){

                tresc= rs.getString("tresc");    

            }
            return tresc;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }


            } catch (SQLException ex) {
                Logger.getLogger(classDB.class.getName()).log(Level.WARNING, "error 124");
            }
        }
        
        //return null;
        return "brak";
    }
    @Override
    public void close() throws SQLException{
        if (con != null) {
            con.close();
        }
    }
    private int zwrotInt(boolean flaga){
        if(flaga){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    
    /*część dla modułu wyswietlania szczegółów oferty*/
    public void setValues(List<JLabel> lista, EntityManager em, Oferta o){
        int counter = 0;
        
        // pobranie danych osobowych(bez adresu)
        TypedQuery<ProfilUzytkownika> puQuery = em.createQuery("SELECT p FROM ProfilUzytkownika p WHERE p.id=" 
                + o.getIDprofil(), ProfilUzytkownika.class);
        
        ProfilUzytkownika pu = getSingleResult(puQuery);
        
        if (pu != null){
            lista.get(counter++).setText(pu.getImie());
            lista.get(counter++).setText(pu.getNazwisko());
        } else {
            counter += 2;
        }
        
        // pobranie adresu do danych osobowych
        TypedQuery<Adres> aQuery = em.createQuery("SELECT a FROM Adres a WHERE a.iDoferty=" 
                + o.getId(), Adres.class);
        Adres a = getSingleResult(aQuery);
        if (a != null){ 
            lista.get(counter++).setText(a.getPanstwo());
            lista.get(counter++).setText(a.getDzielnicawies());
        
            // pobranie wojewodztwa 
            TypedQuery<Wojewodztwo> wQuery = em.createQuery("SELECT w FROM Wojewodztwo w WHERE w.id=" 
                    + a.getIDwojewodztwa(), Wojewodztwo.class);
            List<Wojewodztwo> w = wQuery.getResultList();
            StringBuilder sb = new StringBuilder();
            for (Wojewodztwo w1 : w) {
                sb.append(w1.getWojewodztwo());
            }
            lista.get(counter++).setText(sb.toString());
        } else {
            counter += 3;
        }
        
        // przepisanie informacji z obiektu aktualnie wyświetlanej oferty do labelków na planie 
        lista.get(counter++).setText(o.getTransakcja());
        lista.get(counter++).setText(Long.toString(o.getCzynsz()));
        lista.get(counter++).setText(String.valueOf(o.getPowM2()));
        lista.get(counter++).setText(String.valueOf(o.getPietro()));
        lista.get(counter++).setText(String.valueOf(o.getIloscpieter()));
        lista.get(counter++).setText(String.valueOf(o.getRokbudowy()));
        
        
        // pobranie informacji szczegółowych na temat danej oferty
        TypedQuery<Szczegoly> sQuery = em.createQuery("SELECT s FROM Szczegoly s WHERE s.iDoferty=" + o.getId(), Szczegoly.class);
        Szczegoly s = getSingleResult(sQuery);
        if (s != null) {
            lista.get(counter++).setText(s.getRodzajwlasnosci());
            lista.get(counter++).setText("brak");
            lista.get(counter++).setText(s.getOkna());
            lista.get(counter++).setText(s.getOgrzewanie());
            lista.get(counter++).setText(takCzyNie(s.getCieplawoda()));
            lista.get(counter++).setText(s.getLazienka());
            lista.get(counter++).setText(s.getWc());
            lista.get(counter++).setText(takCzyNie(s.getKuchnia()));
            lista.get(counter++).setText(takCzyNie(s.getGaraz()));
            lista.get(counter++).setText(takCzyNie(s.getMiejsceparkingowe()));
            lista.get(counter++).setText(takCzyNie(s.getPiwnica()));
            lista.get(counter++).setText(takCzyNie(s.getBalkon()));
            lista.get(counter++).setText(takCzyNie(s.getWinda()));
            lista.get(counter++).setText(takCzyNie(s.getZsyp()));
            lista.get(counter++).setText(takCzyNie(s.getUmeblowanie()));
        }
        
    }
    
    private <T> T getSingleResult(TypedQuery<T> query){
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(classDB.class.getName()).log(Level.WARNING, query.toString());
        }
        return null;
    }
    
    private String takCzyNie(short i){
        return i == 0 ? "brak" : "jest";
    }
    
    private ResultListJPA<Oferta> toReturn;
    
    public ResultListJPA<Oferta> getResultListJPA(Query getRowsCount, Query getRowsQuery){
        if (toReturn != null)
            return toReturn;
        else
            return new ResultListJPA<>(getRowsCount, getRowsQuery);

    }

    @Override
    public boolean isOnline() {
        return true;
    }

    @Override
    public boolean Add_user(String login, String haslo, String imie, String nazwisko) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /* klasa zagnieżdrzona dla modułu wyswietlania listy ofert */
    
    public class ResultListJPA<T> extends AbstractList<T> implements List<T> {

    private Query rowCountQuery;
    private Query getRowsQuery;
    private int startPosition;
    private List<T> cache = null;
    private final int elementsOnList;
    private boolean queryChanged;
    
    public ResultListJPA(Query rowCountQuery, Query getRowsQuery) {
        this.rowCountQuery = rowCountQuery;
        this.getRowsQuery = getRowsQuery;
        this.startPosition = 0;
        this.elementsOnList = 1;
        this.queryChanged = false;
        this.cache = getItems(startPosition, startPosition + elementsOnList);
    }
    @Override
    public int size() {
        return ((Long) rowCountQuery.getSingleResult()).intValue();
    }
    @Override
    public T get(int rowIndex) {
        if (!queryChanged && (rowIndex >= startPosition) && (rowIndex < (startPosition + elementsOnList))) {
        } else {
            this.cache = getItems(rowIndex, rowIndex + elementsOnList);
            this.startPosition = rowIndex;
            this.queryChanged = false;
        }
        T c = null;
        try {
            c = cache.get(rowIndex - startPosition);
        } catch (Exception e) {
            Logger.getLogger(ResultListJPA.class.getName()).log(Level.SEVERE, null, e.toString());
        }
        return c;
    }

    public List<T> getItems(int from, int to) {
        Query query = getRowsQuery.setMaxResults(to - from).setFirstResult(from);
        List<T> resultList = query.getResultList();
        return resultList;
    }
    public void setQueries(Query q1 , Query q2){
        this.rowCountQuery = q1;
        this.getRowsQuery = q2;
        this.queryChanged = true;
    }
}

}

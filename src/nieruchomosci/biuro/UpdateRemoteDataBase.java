
package nieruchomosci.biuro;

import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UpdateRemoteDataBase {
    private BazaBiura bb;

    public UpdateRemoteDataBase(BazaBiura bb) {
        this.bb = bb;
    }
    
    public void updateRemoteDatabase(){
        
    }
    
    private String createInsert(String tableName) throws SQLException, IOException{
        StringBuilder sb;
        try (Connection conn = DriverManager.getConnection(SettingFile.readFile().getURL(), 
                SettingFile.readFile().getUSER(),
                SettingFile.readFile().getPASSWORD());
                ResultSet rs = conn.createStatement().executeQuery("select * from " + tableName + " limit 1")) {
            
            ResultSetMetaData rsmd = rs.getMetaData();
            sb = new StringBuilder("INSERT INTO " + rsmd.getTableName(1) + " (");
            for (int i = 2; i < rsmd.getColumnCount(); i++) {
                sb.append(rsmd.getColumnName(i)).append(i == rsmd.getColumnCount()-1 ? "" : ", ");
            }   sb.append(") ").append(" values(");
            while(rs.next()){
                for (int i = 2; i < rsmd.getColumnCount(); i++) {
                    String str = rs.getObject(i).toString();
                    sb.append(str).append(i == rsmd.getColumnCount()-1 ? "" : ", ");
                }
                sb.append(")");
            }
        }
        return sb.toString();
    }
    private int count() throws SQLException, IOException{
        int count;
        try (Connection conn = DriverManager.getConnection(SettingFile.readFile().getURL(), 
                SettingFile.readFile().getUSER(),
                SettingFile.readFile().getPASSWORD());
                ResultSet rs = conn.createStatement().executeQuery("select count(*) from oferta ")){
            rs.next();
            count = rs.getInt(1);
        }
        return count;
    }
}

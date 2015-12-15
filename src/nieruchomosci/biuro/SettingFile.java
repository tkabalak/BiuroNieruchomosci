package nieruchomosci.biuro;

import com.mysql.jdbc.Connection;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class SettingFile {
    private static final Logger logger = Logger.getLogger(SettingFile.class.getName());
    private static final  String filename = "settings.ini";
    
    public static Settings readFile(){
        try {
            List<String> set = Files.readAllLines(Paths.get(filename));
            Optional<String> hasHost = set.stream().filter(s -> s.contains("HOST")).findFirst();
            Optional<String> hasPort = set.stream().filter(s -> s.contains("PORT")).findFirst();
            Optional<String> hasDbName = set.stream().filter(s -> s.contains("DB_NAME")).findFirst();
            Optional<String> hasUser = set.stream().filter(s -> s.contains("USER")).findFirst();
            Optional<String> hasPass = set.stream().filter(s -> s.contains("PASSWORD")).findFirst();
            
            
//            Stream.of("HOST", "PORT", "DB_NAME", "USER", "PASSWORD").(e -> {
//                set.stream().filter(s -> s.contains(e)).findFirst();
//            });
            Settings settings = null;
            
            if(hasHost.isPresent() && hasPort.isPresent() && hasDbName.isPresent() && hasUser.isPresent() && hasPass.isPresent()){
                settings = new Settings();
                settings.setHOST(hasHost.get().split(":")[1]);
                settings.setPORT(hasPort.get().split(":")[1]);
                settings.setDATABASE_NAME(hasDbName.get().split(":")[1]);
                settings.setUSER(hasUser.get().split(":")[1]);
                settings.setPASSWORD(hasPass.get().split(":")[1]);
                    
            } else {
            }
            return settings;
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Nie mo¿na zapisaæ do pliku!");
            logger.log(Level.WARNING, "read from file goes wrong");
        }
        return null;
    }
    
    public static boolean saveFile(Settings set){
        boolean flag = false;
        if (set != null){
            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filename))){
                Stream.of("HOST", "PORT", "DB_NAME", "USER", "PASSWORD")
                    .forEach(e -> {
                        try {
                            bw.write(e + ":" + set.valueOf(e));
                            bw.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Nie mo¿na zapisaæ do pliku!");
                            logger.log(Level.WARNING, "write to file goes wrong");
                        }
                });
                flag = true;
            } catch (IOException ex) {
                logger.log(Level.WARNING, "write to file goes wrong");
            }
        } else {
            System.out.println("save file ma nulla");
        }
        return flag;
    }

    public static void testConnection(Settings set){
        if(set != null){
            try (Connection con = (Connection) DriverManager.getConnection(set.getURL(), set.getUSER(), set.getPASSWORD())){
                JOptionPane.showMessageDialog(null, "Po³¹czenie powiod³o siê!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Po³¹czenie nie powiod³o siê!");
                logger.log(Level.WARNING, "connection test failed");
            }
        }
    }
}

package nieruchomosci.biuro;

public class Settings {
    private String URL;
    private String HOST;
    private String PORT;
    private String DB_NAME;
    private String USER;
    private String PASSWORD;

    public Settings(String HOST, String PORT, String DATABASE_NAME, String USER, String PASSWORD) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.DB_NAME = DATABASE_NAME;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public Settings() {
    }

    public String valueOf(String val){
        String toRtn = null;
        switch(val){
            case "HOST":
                toRtn = HOST;
                break;
            case "PORT":
                toRtn = PORT;
                break;
            case "DB_NAME":
                toRtn = DB_NAME;
                break;
            case "USER":
                toRtn = USER;
                break;
            case "PASSWORD":
                toRtn = PASSWORD;
                break;
        }
        return toRtn;
    }
    public String getFullURL(){
        return makeURL();
    }
    
    private String makeURL(){
        StringBuilder build = new StringBuilder("jdbc:mysql://");
        build.append(HOST);
        build.append(":").append(PORT);
        build.append("/").append(DB_NAME);
        build.append("?USER=").append(USER);
        build.append("&PASSWORD=").append(PASSWORD);
        
        return build.toString();
    }
    // getters / setters
    public String getURL() {
        return new StringBuilder("jdbc:mysql://")
                .append(HOST)
                .append(":")
                .append(PORT)
                .append("/")
                .append(DB_NAME)
                .toString();
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    public void setURL(String HOST, String PORT, String DB_NAME) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.DB_NAME = DB_NAME;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public String getPORT() {
        return PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getDATABASE_NAME() {
        return DB_NAME;
    }

    public void setDATABASE_NAME(String DATABASE_NAME) {
        this.DB_NAME = DATABASE_NAME;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
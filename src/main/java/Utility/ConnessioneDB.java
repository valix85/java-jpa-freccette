package Utility;

import java.sql.*;

    public class ConnessioneDB {

        private String driver;
        private String url;
        private String user;
        private String password;
        private Connection conn;

        private static ConnessioneDB istanza;

        public ConnessioneDB(){
        }

        public static ConnessioneDB getInstance(){
            if(istanza == null){
                istanza = new ConnessioneDB();
            }
            return istanza;
        }

        public Connection getConnessione(){

            if (conn!=null){
                return conn;
            }

            try{
                Class.forName(getDriver());
                conn = DriverManager.getConnection(getUrl(), getUser(), getPassword());
                System.out.println("Connessione avvenuta");
                return conn;
            }catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
            return conn;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Connection getConn() {
            return conn;
        }

        public void setConn(Connection conn) {
            this.conn = conn;
        }

        public static ConnessioneDB getIstanza() {
            return istanza;
        }

        public static void setIstanza(ConnessioneDB istanza) {
            ConnessioneDB.istanza = istanza;
        }
    }

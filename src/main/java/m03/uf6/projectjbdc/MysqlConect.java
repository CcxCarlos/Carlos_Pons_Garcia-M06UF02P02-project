package m03.uf6.projectjbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class MysqlConect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public String URL;
    public String ip;
    public String port;
    public String bbdd;
    public String USER;
    public String PASS;
    Connection con = null;

    public MysqlConect(String ip, String port, String user, String pass) {
        URL = "jdbc:mysql://";
        this.ip = ip;
        this.port = port;
        this.USER=user;
        this.PASS=pass;
        URL += this.ip+":"+this.port;
    }
    
    public Connection conectar(){
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(URL,USER,PASS);
      
        }catch(ClassNotFoundException | SQLException e){
            con = null;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return con;
    }
    
    public Connection conectar(String bbdd){
        try{
            if (bbdd==null || bbdd.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Introdueix una base de dades correcta", 
                        "Error", JOptionPane.ERROR_MESSAGE );
                return null;
            }
            this.bbdd = bbdd;
            StringBuilder urlBBDD = new StringBuilder(URL).append('/').append(this.bbdd);
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(urlBBDD.toString(),USER,PASS);

        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            return null;
        }
    }
    public Connection getConnection(){
        return con;
    }
}


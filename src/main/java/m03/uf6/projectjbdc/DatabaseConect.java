package m03.uf6.projectjbdc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DatabaseConect extends UtilidadesMysql{
    
    public DatabaseConect(Connection con){
        super(con);
    }
    
    public void createDatabase(String bbdd){
        
        try {
            sql = "CREATE DATABASE "+ bbdd;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Creada amb èxit");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void removeDatabase(String bbdd){
        try {
            sql = "DROP DATABASE " + bbdd;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Esborrada amb èxit");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}

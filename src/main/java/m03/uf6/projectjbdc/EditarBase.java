package m03.uf6.projectjbdc;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class EditarBase {
        private String columnaFila;
        private String fila ="";
        private Vector<Vector> vectorTabla;
        private int sizeVector=0;
        private int nColumn;
        private final Statement stmt;
        private String sql="";
    public EditarBase(DataBaseObj db) {
        this.stmt = db.getStmt();
    }

    public void createTable(String tabla, DefaultTableModel tm){
         try{
            sql =  "CREATE TABLE "+tabla+" ("+"\n";
            vectorTabla = tm.getDataVector();
            sizeVector=vectorTabla.size();
            nColumn=tm.getColumnCount();
            
            for (int i = 0; i < sizeVector; i++) {
                for (int j = 0; j < nColumn; j++) {
                    columnaFila=vectorTabla.get(i).get(j).toString();
                    if (!columnaFila.isEmpty()) {
                        fila+=columnaFila+" ";
                    }
                }
                if (i==(sizeVector-1)) {
                    sql+=fila+")";
                }else{
                    sql+=fila+",\n";
                    fila ="";
                }
            }
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Tabla creada");
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }    
    }
     public void dropTable(String tabla){
         try{
            sql =  "DROP TABLE "+tabla;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Tabla borrada");
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }    
    }
}

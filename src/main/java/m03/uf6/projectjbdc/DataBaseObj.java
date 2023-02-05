package m03.uf6.projectjbdc;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DataBaseObj extends UtilidadesMysql{
    private final EditarBase editarBBDD;
    private final static char splitter = ',';
    private ArrayList<Films> films = new ArrayList<>();
    private ArrayList<Director> directors = new ArrayList<>();
    private HashMap<String, Director> directorsByName = new HashMap<>();
    private final String[] tableNames = {"Films", "Director", "Film_Peli"};
    private final String[] columnsFilm = {"idFilm", "Titol", "Data_Estrena", "PAIS"};
    private final String[] columnsDirector = {"idDirector", "Nom", "Any_Naixament", "PAIS"};

    private final int nTables = tableNames.length;
   

    
    public DataBaseObj(Connection con, String dataBaseName){
        super(con);
        this.editarBBDD = new EditarBase(this);
    }

    public ArrayList<String[]> getData() {
        updateContent();

        sql = "SELECT f.*, d.idDirector, d.Nom, d.Any_Naixament, "
                + "d.PAIS FROM Films f INNER JOIN Film_Peli fp ON "
                + "f.idFilm = fp.idFilm INNER JOIN Director d ON "
                + "fp.idDirector = d.idDirector ORDER BY idFilm";
        
        return obtenerDatos(sql);
   }
   
    private ArrayList<String[]> obtenerDatos(String sentenciaSql){
        ArrayList<String[]> datos = new ArrayList<>();
        Director d;
        Films f;
        try {
            this.resultQuery = stmt.executeQuery(sentenciaSql);
            while(resultQuery.next()){
                d = new Director(resultQuery.getInt(columnsDirector[0]), 
                        resultQuery.getString(columnsDirector[1]), 
                        resultQuery.getInt(columnsDirector[2]), 
                        resultQuery.getString(columnsDirector[3]));
                
                if (!directors.contains(d)) addObject(d);
                
                f = new Films(resultQuery.getInt(columnsFilm[0]),
                        resultQuery.getString(columnsFilm[1]), 
                        resultQuery.getDate(columnsFilm[2]),
                        resultQuery.getString(columnsFilm[3]), d);
                
                addObject(f);
                datos.add(f.getData());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return datos;
    }
    
    private void addObject(ObjetosBBDD o) {
        if (o instanceof Films) {
            films.add((Films) o);
        }else{
            Director d = (Director)o;
            directors.add(d);
            directorsByName.put(d.getNom(), d);
        }
    }
    
    public int getMinAny(){
        sql = "SELECT min(year(Data_Estrena)) FROM Films";
        try {
            this.resultQuery = stmt.executeQuery(sql);
            if (resultQuery.next()) return Integer.parseInt(resultQuery.getString(1));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    
    public int getMaxAny(){
        sql = "SELECT max(year(Data_Estrena)) FROM Films";
        try {
            this.resultQuery = stmt.executeQuery(sql);
            
            if (resultQuery.next()) return Integer.parseInt(resultQuery.getString(1));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    
    public void close(){
        try {
            this.stmt.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public EditarBase edit(){
        return this.editarBBDD;
    }
    
    public void add(Object o){
        StringBuilder sb = new StringBuilder();
        String tabla = o.getClass().getSimpleName();
        String[] columns;
        String queryGetId = "";
        
        if (o instanceof Films) {
            Films f = (Films) o;
            columns = new String[]{"Titol", "Data_Estrena", "PAIS"};
            queryGetId = "SELECT idFilm FROM Films WHERE Titol=" + '"' + f.getTitol() + '"';
            films.add(f);
        }else{
            Director d = (Director) o;
            String nameDirector = d.getNom();
            columns = new String[]{"Nom", "Any_Naixament", "PAIS"};
            queryGetId = "SELECT idDirector FROM Director WHERE Nom=" + '"' + nameDirector + '"';
            directorsByName.put(nameDirector, d);
            directors.add(d);
        }
        sb.append("INSERT INTO ").append(tabla).append('(');
        sb.append(columns[0]).append(splitter).append(columns[1]).append(splitter).append(columns[2]);
        sb.append(')').append("VALUES(").append(o).append(')');
        sql = sb.toString();
        try {
            stmt.executeUpdate(sql);
            if (!queryGetId.isEmpty()) {
                this.resultQuery = stmt.executeQuery(queryGetId);
                resultQuery.next();
                ((ObjetosBBDD) o).setId(resultQuery.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
    }
    public void delete(int idFilm){
        try {
            sql =  "delete from Films where idFilm=" + idFilm;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
    }
    public void delete(ArrayList<Integer> idFilms ) {
        try {
            for (int idFilm : idFilms) {
                sql =  "delete from Films where idFilm=" + idFilm;
                stmt.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
    }

    public ArrayList<String> getDirectorsNames(){
        ArrayList<String> directorsNames = new ArrayList<>();
        for (Director d : directors){
            directorsNames.add(d.getNom());
        }
        return directorsNames;
    }
    public Director getDirector(String nameDirector) {
        return directorsByName.get(nameDirector);
    }


    boolean containsFilm(String filmName) {
        return films.contains(new Films(filmName));
    }
    boolean containsDirector(String directorName) {
        return directors.contains(new Director(directorName));
    }

    public void createRelation(int idFilm, int idDirector) {
        StringBuilder sb = new StringBuilder();
        String[] columns = new String[]{"idFilm", "idDirector"};
        String tabla = "Film_Peli";
        sb.append("INSERT INTO ").append(tabla).append('(');
        sb.append(columns[0]).append(splitter).append(columns[1]);
        sb.append(')').append("VALUES(").append(idFilm).append(splitter)
                .append(idDirector).append(')');
        sql = sb.toString();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean comprobarEstructuraBBDD() {
        ArrayList<String> tablas = new ArrayList<>();
        try {
            sql = "SHOW TABLES";
            resultQuery = stmt.executeQuery(sql);
            while (resultQuery.next()) {
               tablas.add(resultQuery.getString(1));
            }
            if (tablas.isEmpty()) {
                return false;
            }else{
                for (String tabla : tableNames){
                    if (!tablas.contains(tabla)) return false; 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseObj.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    boolean comprobarDatos() {
            try{
                for (int i = 0; i < nTables; i++) {
                   sql = "SELECT COUNT(*) AS count FROM " + tableNames[i];
                   resultQuery = stmt.executeQuery(sql);
                   if (resultQuery.next()) if(resultQuery.getInt("count")==0) return false;
                }
                
            }catch (SQLException ex) {
                Logger.getLogger(DataBaseObj.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        return true;
    }

    private void updateContent() {
        if (!films.isEmpty()) films.clear();
        if (!directors.isEmpty())directors.clear();
        if (!directorsByName.isEmpty()) directorsByName.clear();
    }
}

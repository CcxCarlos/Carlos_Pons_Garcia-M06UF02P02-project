//package m03.uf6.projectjbdc;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author PC
// * Tiene la misma función que "DataBaseObj", pero no usa objetos
// */
//public class DataBaseObj extends UtilidadesMysql{
//    private final String dataBaseName;
//    private int nColumnes;
//    private ArrayList<Integer> idFilms;
//    private boolean isFilm = false;
//    private final EditarBase editarBBDD;
//    private final static char splitter = ',';
//    private ArrayList<String> filmsNames = new ArrayList<>();
//    private ArrayList<String> directorsNames = new ArrayList<>();
//    private HashMap<String, Director> directorsMAP = new HashMap<>();
//    private final String[] tableNames = {"Films", "Director", "Film_Peli"};
//    private final int nTables = tableNames.length;
//
//    
//    public DataBaseObj(Connection con, String dataBaseName){
//        super(con);
//        this.dataBaseName = dataBaseName;
//        this.editarBBDD = new EditarBase(this);
//    }
//
//    public ArrayList<String[]> getData() {
//        ArrayList<String[]> datos = new ArrayList<>();
//        isFilm = false;
//        this.idFilms = new ArrayList<>();
//        this.directorsNames = generateDirectors();
//        this.filmsNames = generateFilmNames();
//        try{
//            sql = "SELECT idDirector, Nom FROM Director";
//            var directors = obtenerDatos(sql);
//
//            sql = "SELECT * FROM Film_Peli";
//            var relaciones = obtenerDatos(sql);
//
//            sql = "SELECT * FROM Films";
//            isFilm = true;
//            var films = obtenerDatos(sql);
//
//            idFilms.stream().map(idFilm -> {
//                String[] valores = new String[nColumnes + 1];
//                int idDirector = Integer.parseInt(relaciones.get(idFilm)[1]);
//                var film = films.get(idFilm);
//                System.arraycopy(film, 0, valores, 0, film.length);
//                valores[4] = directors.get(idDirector)[1];
//                 return valores;
//             }).forEachOrdered(valores -> {
//                 datos.add(valores);
//             }); 
//        }catch(NullPointerException ex){
//            Logger.getLogger(DataBaseObj.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return datos;
//   }
//    public ArrayList<String[]> getData(String tablaName){
//        return null;
//    }
//   
//    public int getMinAny(){
//        sql = "SELECT min(year(Data_Estrena)) FROM Films";
//        try {
//            this.resultQuery = stmt.executeQuery(sql);
//            if (resultQuery.next()) return Integer.parseInt(resultQuery.getString(1));
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return -1;
//    }
//    
//    public int getMaxAny(){
//        sql = "SELECT max(year(Data_Estrena)) FROM Films";
//        try {
//            this.resultQuery = stmt.executeQuery(sql);
//            
//            if (resultQuery.next()) return Integer.parseInt(resultQuery.getString(1));
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return -1;
//    }
//    
//    
//    private HashMap<Integer, String[]> obtenerDatos(String sentenciaSql){
//        HashMap<Integer, String[]> hashMap = new HashMap();
//        try {
//            this.resultQuery = stmt.executeQuery(sentenciaSql);
//            nColumnes = resultQuery.getMetaData().getColumnCount();
//            while(resultQuery.next()){
//                String[] vector = new String[nColumnes];
//                for (int i = 0; i < nColumnes; i++) {
//                    vector[i] = this.resultQuery.getString(i+1);
//                }
//                hashMap.put(Integer.valueOf(vector[0]), vector);
//                if(isFilm) idFilms.add(Integer.valueOf(vector[0]));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return hashMap;
//    }
//    
//    public void close(){
//        try {
//            this.stmt.close();
//            con.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex, "Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public EditarBase edit(){
//        return this.editarBBDD;
//    }
//    
//    public void add(Object o){
//        StringBuilder sb = new StringBuilder();
//        String tabla = o.getClass().getSimpleName();
//        String[] columns;
//        String queryGetId = "";
//        
//        if (o instanceof Films) {
//            String titol = ((Films) o).getTitol();
//            columns = new String[]{"Titol", "Data_Estrena", "PAIS"};
//            queryGetId = "SELECT idFilm FROM Films WHERE Titol=" + '"' + titol + '"';
//            filmsNames.add(titol);
//        }else{
//            Director director = (Director) o;
//            String nameDirector = director.getNom();
//            columns = new String[]{"Nom", "Any_Naixament", "PAIS"};
//            queryGetId = "SELECT idDirector FROM Director WHERE Nom=" + '"' + ((Director) o).getNom() + '"';
//            directorsMAP.put(nameDirector, director);
//            directorsNames.add(nameDirector);
//        }
//        sb.append("INSERT INTO ").append(tabla).append('(');
//        sb.append(columns[0]).append(splitter).append(columns[1]).append(splitter).append(columns[2]);
//        sb.append(')').append("VALUES(").append(o).append(')');
//        sql = sb.toString();
//        try {
//            stmt.executeUpdate(sql);
//            if (!queryGetId.isEmpty()) {
//                this.resultQuery = stmt.executeQuery(queryGetId);
//                resultQuery.next();
//                ((ObjetosBBDD) o).setId(resultQuery.getInt(1));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
//        }
//    }
//    public void delete(int idFilm){
//        try {
//            sql =  "delete from Films where idFilm=" + idFilm;
//            stmt.executeUpdate(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex, "Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    public void delete(ArrayList<Integer> idFilms ) {
//        try {
//            for (int idFilm : idFilms) {
//                sql =  "delete from Films where idFilm=" + idFilm;
//                stmt.executeUpdate(sql);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex, "Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public ArrayList<String> getDirectorsNames(){
//        return directorsNames;
//    }
//    public Director getDirector(String nameDirector) {
//        return directorsMAP.get(nameDirector);
//    }
//
//    private ArrayList<String> generateDirectors() {
//        ArrayList<String> names = new ArrayList<>();
//        sql = "SELECT * FROM Director";
//        try{
//            this.resultQuery = stmt.executeQuery(sql);
//            while(resultQuery.next()){
//                String[] directorValues = {resultQuery.getString(1), 
//                    resultQuery.getString(2), resultQuery.getString(3), resultQuery.getString(4)};
//                names.add(directorValues[1]);
//                directorsMAP.put(directorValues[1], new Director(
//                        Integer.parseInt(directorValues[0]), directorValues[1],
//                        Integer.parseInt(directorValues[2]), directorValues[3]));
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return names;
//    }
//
//    private ArrayList<String> generateFilmNames() {
//        ArrayList<String> names = new ArrayList<>();
//        sql = "SELECT Titol FROM Films";
//        try{
//            this.resultQuery = stmt.executeQuery(sql);
//            while(resultQuery.next()){
//                names.add(resultQuery.getString(1).toLowerCase());
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return names;
//    }
//
//    boolean containsFilm(String filmName) {
//        return filmsNames.contains(filmName.toLowerCase());
//    }
//    boolean containsDirector(String directorName) {
//        for (String name : directorsNames){
//            if (name.equalsIgnoreCase(directorName)) return true;
//        }
//        return false;
//    }
//
//    public void createRelation(long idFilm, long idDirector) {
//        StringBuilder sb = new StringBuilder();
//        String[] columns = new String[]{"idFilm", "idDirector"};
//        String tabla = "Film_Peli";
//        sb.append("INSERT INTO ").append(tabla).append('(');
//        sb.append(columns[0]).append(splitter).append(columns[1]);
//        sb.append(')').append("VALUES(").append(idFilm).append(splitter).append(idDirector).append(')');
//        sql = sb.toString();
//        try {
//            stmt.executeUpdate(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
//
//    public boolean comprobarEstructuraBBDD() {
//        ArrayList<String> tablas = new ArrayList<>();
//        try {
//            sql = "SHOW TABLES";
//            resultQuery = stmt.executeQuery(sql);
//            while (resultQuery.next()) {
//               tablas.add(resultQuery.getString(1));
//            }
//            if (tablas.isEmpty()) {
//                return false;
//            }else{
//                for (String tabla : tableNames){
//                    if (!tablas.contains(tabla)) return false; 
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DataBaseObj.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//        return true;
//    }
//
//    boolean comprobarDatos() {
//            try{
//                for (int i = 0; i < nTables; i++) {
//                   sql = "SELECT COUNT(*) AS count FROM " + tableNames[i];
//                   resultQuery = stmt.executeQuery(sql);
//                   if (resultQuery.next()) if(resultQuery.getInt("count")==0) return false;
//                }
//                
//            }catch (SQLException ex) {
//                Logger.getLogger(DataBaseObj.class.getName()).log(Level.SEVERE, null, ex);
//                return false;
//            }
//
//        return true;
//    }
//}

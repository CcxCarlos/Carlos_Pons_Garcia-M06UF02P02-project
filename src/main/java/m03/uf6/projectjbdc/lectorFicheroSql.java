package m03.uf6.projectjbdc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class lectorFicheroSql extends UtilidadesMysql{
    private final String[] comments;
    private BufferedReader br;
    private final String finalQuery = ";";
    private ArrayList<String> querys;
    private final HashMap<String, Integer> lineQuery;
    private int nLine;

    public lectorFicheroSql(Connection con) {
        super(con);
        comments = new String[]{"--", "/*", "*/"};
        querys = new ArrayList<>();
        lineQuery = new HashMap<>();
    }
    
    public void leerArchivoSql(File file){
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine())!=null){
                nLine++;
                if (!line.trim().isEmpty()) {
                     if (skipComments(line)) {
                         sql = obtenerQuery(line);
                         querys.add(sql);
                         lineQuery.put(sql, nLine);
                     }
                }
               
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex, 
                    "Error", JOptionPane.ERROR_MESSAGE );
        }
        executeQuerys();
    }

    private boolean skipComments(String line) {
        if (line.contains(comments[0])) return false;
        else if (line.contains(comments[1])) {
            while(!line.contains(comments[2])){
                try {
                    line = br.readLine();
                    nLine++;
                } catch (IOException ex) {
                    Logger.getLogger(lectorFicheroSql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }
        return true;
    }

    private String obtenerQuery(String line) {
        StringBuilder sb = new StringBuilder(line);
        while(!sb.toString().contains(finalQuery)){
            try {
                sb.append(br.readLine());
            } catch (IOException ex) {
                Logger.getLogger(lectorFicheroSql.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return sb.substring(0, sb.length()-1);
    }

    private void executeQuerys() {
        for(String query : querys){
            try {
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                String error = ex.toString();
                char char1 = error.charAt(error.length()-1);
                String num = String.valueOf(getLine(query));
                if (Character.isDigit(char1)) {
                    JOptionPane.showMessageDialog(null,
                        error.replace(char1, (char)0) + " " + num, "Syntax Error", 
                        JOptionPane.ERROR_MESSAGE );
                }else {
                    JOptionPane.showMessageDialog(null,
                        error, "Syntax Error", 
                        JOptionPane.ERROR_MESSAGE );
                }
                break;
            }
        }
    }

    private int getLine(String s) {
        return lineQuery.get(s);
    }
    
    
}

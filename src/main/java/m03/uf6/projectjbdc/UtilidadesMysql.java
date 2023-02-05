package m03.uf6.projectjbdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class UtilidadesMysql {
    protected Statement stmt;
    protected Connection con;
    protected String sql="";
    protected ResultSet resultQuery;
   
    public UtilidadesMysql(Connection con) {
        this.con=con;
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UtilidadesMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ResultSet getResultQuery() {
        return resultQuery;
    }

    public void setResultQuery(ResultSet resultQuery) {
        this.resultQuery = resultQuery;
    }
    
    
}

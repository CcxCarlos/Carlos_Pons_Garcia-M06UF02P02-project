package m03.uf6.projectjbdc;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Films extends ObjetosBBDD{
    private final String titol;
    private Date dataEstrena;
    private String pais;
    private Director director;


    public Films(String titol){
        this.titol = titol;
    }
    public Films(int id, String titol, Date dataEstrena, String pais, Director director) {
        super(id);
        this.titol = titol;
        this.dataEstrena = dataEstrena;
        this.pais = pais;
        this.director = director;
    }
    public Films(String titol, Date dataEstrena, String pais, Director director) {
        this.titol = titol;
        this.dataEstrena = dataEstrena;
        this.pais = pais;
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public String getTitol() {
        return titol;
    }
    
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(x).append(titol).append(x).append(splitter);
        sb.append(x).append(dataEstrena).append(x).append(splitter);
        sb.append(x).append(pais).append(x);
        return sb.toString();
    }

    public String[] getData() {
        return new String[]{String.valueOf(id), titol, dataEstrena.toString(), pais, director.getNom()};
    }

    public Date getDataEstrena() {
        return dataEstrena;
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
        	return true;
    	}
    	if (obj == null) {
        	return false;
    	}
    	return this.titol.equalsIgnoreCase(((Films)obj).getTitol());
    }

    @Override
    public int hashCode() {
        return titol.hashCode();
    }
     

    
    
}

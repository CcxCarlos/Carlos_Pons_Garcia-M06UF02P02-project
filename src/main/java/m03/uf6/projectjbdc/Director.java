package m03.uf6.projectjbdc;

/**
 *
 * @author PC
 */
public class Director extends ObjetosBBDD{
    private final String nom;
    private int anyNaixement;
    private String pais;

    public Director(String nom){
        this.nom = nom;
    }
    
    public Director(int id, String nom, int anyNaixement, String pais) {
        super(id);
        this.nom = nom;
        this.anyNaixement = anyNaixement;
        this.pais = pais;
            
    }
    
    public Director(String nom, int anyNaixement, String pais) {
        this.nom = nom;
        this.anyNaixement = anyNaixement;
        this.pais = pais;   
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(x).append(nom).append(x).append(splitter);
        sb.append(x).append(anyNaixement).append(x).append(splitter);
        sb.append(x).append(pais).append(x);
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
        	return true;
    	}
    	if (obj == null) {
        	return false;
    	}
    	return this.nom.equalsIgnoreCase(((Director)obj).getNom());
    }
     
    @Override
    public int hashCode() {
        return nom.hashCode();
    }

}

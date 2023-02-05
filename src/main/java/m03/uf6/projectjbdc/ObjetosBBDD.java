package m03.uf6.projectjbdc;

/**
 *
 * @author PC
 */
public class ObjetosBBDD {
    protected int id = 0;
    protected final char splitter = ',';
    protected final char x = '"';

    public ObjetosBBDD() {
    }
     
    public ObjetosBBDD(int id) {
        this.id = id;
    }
    
    
    public void setId(int id){
        this.id = id;
    };

    public int getId() {
        return id;
    }
    
}

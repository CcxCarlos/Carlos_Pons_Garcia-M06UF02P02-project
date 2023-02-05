package m03.uf6.projectjbdc;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class AddFilm extends javax.swing.JFrame {
    //start-Interfaz
    private javax.swing.JButton addDirector;
    private javax.swing.JButton addFilm;
    private javax.swing.JButton close;
    private java.awt.Label columnName;
    private java.awt.Label dataNull;
    private java.awt.Label datatype;
    private javax.swing.JLabel formatDate;
    private java.awt.TextField inputDate;
    private java.awt.Choice inputDirector;
    private java.awt.TextField inputName;
    private java.awt.TextField inputPais;
    private java.awt.Label tablaName;
    //end-Interfaz
    private final MainInterfaz mi;
    private final DataBaseObj db;
    private Director newDirector;

    public AddFilm(MainInterfaz mi, DataBaseObj db) {
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.mi = mi;
        this.db = db;
        this.generaEstructura();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        addDirector = new javax.swing.JButton();
        tablaName = new java.awt.Label();
        inputName = new java.awt.TextField();
        columnName = new java.awt.Label();
        inputDate = new java.awt.TextField();
        datatype = new java.awt.Label();
        inputPais = new java.awt.TextField();
        dataNull = new java.awt.Label();
        inputDirector = new java.awt.Choice();
        addFilm = new javax.swing.JButton();
        close = new javax.swing.JButton();
        formatDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addDirector.setText("Add Director");
        addDirector.addActionListener(evt -> addDirectorActionPerformed(evt));

        tablaName.setText("Film Name *");

        columnName.setName("");
        columnName.setText("Data Estrena *");

        datatype.setText("Pais *");

        dataNull.setText("Director *");

        addFilm.setText("Add Film");
        addFilm.addActionListener(evt -> addFilmActionPerformed(evt));

        close.setText("Close");
        close.addActionListener(evt -> closeActionPerformed(evt));

        formatDate.setText("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(columnName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datatype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dataNull, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tablaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formatDate)
                                    .addComponent(addDirector)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addFilm)))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tablaName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(columnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatDate, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datatype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dataNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addDirector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFilm)
                    .addComponent(close))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>

    private void addDirectorActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            new AddDirector(this, db).setVisible(true);
        });
    }

    private void addFilmActionPerformed(java.awt.event.ActionEvent evt) {
        Films film;
        String[] filmValues = {inputName.getText(), inputDate.getText(), 
            inputPais.getText(), inputDirector.getSelectedItem()};
        if (comprobarInputs(filmValues)) {
            if (!filmExists(filmValues[0])) {
                Date date = parseDate(filmValues[1]);
                if (date!=null) {
                    film = new Films(filmValues[0], date, filmValues[2],
                        getDirector(filmValues[3]));
                    db.add(film);
                    db.createRelation(film.getId(), film.getDirector().getId());
                    mi.updateContent(film, newDirector);
                    this.setVisible(false);
                    this.dispose();
                }  
            }else{
                 JOptionPane.showMessageDialog(null,
                     "La pel·lícula ja existeix",
                     "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,
                     "Omple tots els camps",
                     "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        this.dispose();
    }

    private void generaEstructura() {
        generaOptionsDirectors();
    }

    private void generaOptionsDirectors() {
        try{
            getDirectors().forEach(item -> {
            inputDirector.addItem(item);
        });
        }catch(NullPointerException ex){
            
        }
    }

     private ArrayList<String> getDirectors() {
        return db.getDirectorsNames();
    }

    public void setNewDirector(Director newDirector) {
        this.newDirector = newDirector;
        inputDirector.addItem(newDirector.getNom());
    }
     
    
    private Director getDirector(String nameDirector) {
        return db.getDirector(nameDirector);
    }
     
     private Date parseDate(String dateString){
         Date date = null;
         try{
             date = Date.valueOf(dateString);
         }catch(IllegalArgumentException ex){
             JOptionPane.showMessageDialog(null,
                     "Format de data no vàlid. Introdueix una data en el següent format yyyy-MM-dd.",
                     "Error", JOptionPane.ERROR_MESSAGE);
         }
         
         return date;
     }
     
     private boolean comprobarInputs(String[] filmInputsValues) {
        for (String s : filmInputsValues){
            if (s==null || s.isEmpty()) return false;
        }
        return true;
    }

    private boolean filmExists(String filmName) {
        return db.containsFilm(filmName);
    }
}
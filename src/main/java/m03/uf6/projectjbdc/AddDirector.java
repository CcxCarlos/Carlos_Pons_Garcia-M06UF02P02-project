package m03.uf6.projectjbdc;

import javax.swing.*;

/**
 *
 * @author PC
 */
public class AddDirector extends javax.swing.JFrame {
    //start-Interfaz
    private javax.swing.JButton addDirector;
    private javax.swing.JButton close;
    private java.awt.Label columnName;
    private java.awt.Label datatype;
    private java.awt.TextField inputBornYear;
    private java.awt.TextField inputName;
    private java.awt.TextField inputPais;
    private java.awt.Label tablaName;
    //end-Interfaz
    private final AddFilm af;
    private final DataBaseObj db;

   
    public AddDirector(AddFilm af, DataBaseObj db) {
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.af = af;
        this.db = db;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        tablaName = new java.awt.Label();
        inputName = new java.awt.TextField();
        columnName = new java.awt.Label();
        inputBornYear = new java.awt.TextField();
        datatype = new java.awt.Label();
        inputPais = new java.awt.TextField();
        addDirector = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaName.setText("Nom *");

        columnName.setName("");
        columnName.setText("Any_Naixament *");

        datatype.setText("Pais *");

        addDirector.setText("Add Director");
        addDirector.addActionListener(evt -> addDirectorActionPerformed(evt));

        close.setText("Close");
        close.addActionListener(evt -> closeActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addDirector)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(columnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tablaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datatype, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPais, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputBornYear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tablaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(columnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputBornYear, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datatype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDirector)
                    .addComponent(close))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        columnName.getAccessibleContext().setAccessibleName("Any naixement *");
        inputBornYear.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>

    private void addDirectorActionPerformed(java.awt.event.ActionEvent evt) {
        String[] directorValues = {inputName.getText(), inputBornYear.getText(), 
            inputPais.getText()};
        if (comprobarInputs(directorValues)) {
            if (!directorExists(directorValues[0])) {
                try{
                    Director d = new Director(directorValues[0], Integer.parseInt(directorValues[1]),
                    directorValues[2]);
                    af.setNewDirector(d);
                    this.setVisible(false);
                    db.add(d);
                    this.dispose();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,
                     "Format no vàlid " + "'" + directorValues[1] + "'" + ". Introdueix un número correcte.",
                     "Error", JOptionPane.ERROR_MESSAGE);
                }
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
   
    private boolean comprobarInputs(String[] directorInputsValues) {
        for (String s : directorInputsValues){
            if (s==null || s.isEmpty()) return false;
        }
        return true;
    }
    
    private boolean directorExists(String directorName) {
        return db.containsDirector(directorName);
    }
}

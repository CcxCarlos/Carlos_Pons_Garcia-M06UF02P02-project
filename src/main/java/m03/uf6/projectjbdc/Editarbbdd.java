package m03.uf6.projectjbdc;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Editarbbdd extends javax.swing.JFrame {
    //start-Interfaz
    private javax.swing.JButton closeBBDD;
    private javax.swing.JButton createTable;
    private javax.swing.JButton dropTable;
    private javax.swing.JButton selectFile;
    private javax.swing.JButton verDatos;
    //end-Interfaz
    private DataBaseObj db;
    private ConectorBBDD c;

    public Editarbbdd(ConectorBBDD c, DataBaseObj db) {
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.db = db;
        this.c = c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        createTable = new javax.swing.JButton();
        dropTable = new javax.swing.JButton();
        closeBBDD = new javax.swing.JButton();
        verDatos = new javax.swing.JButton();
        selectFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createTable.setText("Create Table");
        createTable.addActionListener((java.awt.event.ActionEvent evt) -> {
            createTableActionPerformed(evt);
        });

        dropTable.setText("Drop Table");
        dropTable.addActionListener((java.awt.event.ActionEvent evt) -> {
            dropTableActionPerformed(evt);
        });

        closeBBDD.setText("Close BBDD");
        closeBBDD.addActionListener((java.awt.event.ActionEvent evt) -> {
            closeBBDDActionPerformed(evt);
        });

        verDatos.setText("Ver Datos");
        verDatos.addActionListener((java.awt.event.ActionEvent evt) -> {
            verDatosActionPerformed(evt);
        });

        selectFile.setText("Execute Sql file");
        selectFile.addActionListener((java.awt.event.ActionEvent evt) -> {
            selectFileActionPerformed(evt);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeBBDD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(verDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createTable)
                    .addComponent(verDatos))
                .addGap(18, 18, 18)
                .addComponent(dropTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(closeBBDD)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>

    private void createTableActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new CreateTable(this,db).setVisible(true);
        });
        this.dispose();
    }

    private void dropTableActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new DropTable(this,db).setVisible(true);
        });
        this.dispose();
    }

    private void closeBBDDActionPerformed(java.awt.event.ActionEvent evt) {
        db.close();
        JOptionPane.showMessageDialog(null, "Conexión cerrada con éxito");
        this.setVisible(false);
        c.setVisible(true);
        this.dispose();
    }

    private void verDatosActionPerformed(java.awt.event.ActionEvent evt) {
        if (db.comprobarEstructuraBBDD()) java.awt.EventQueue.invokeLater(() -> {
            new MainInterfaz(this, db).setVisible(true);
            this.setVisible(false);
            this.dispose();});
        
        else JOptionPane.showMessageDialog(null, "Porfavor " +
                "crea las tablas necesarias con la estructura correcta: Films, "
                + "Director, Film_Peli.");
        
    }

    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file!=null) (new lectorFicheroSql(db.getCon())).leerArchivoSql(file);
            else  JOptionPane.showMessageDialog(null,"Intentalo otra vez", 
                    "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
}

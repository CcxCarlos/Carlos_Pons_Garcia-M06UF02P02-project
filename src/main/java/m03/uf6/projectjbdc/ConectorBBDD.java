    package m03.uf6.projectjbdc;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ConectorBBDD extends javax.swing.JFrame {
    //start-Interfaz
    private java.awt.Label bbdd;
    private javax.swing.JButton closeMysqlCon;
    private javax.swing.JButton conectar;
    private javax.swing.JButton createDB;
    private javax.swing.JButton dropDB;
    private java.awt.TextField textBbdd;
    //end-Interfaz
    private Connection con;
    private DatabaseConect dc;
    private ConectorMysql c;

    public ConectorBBDD(ConectorMysql c, Connection con) {
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.c = c;
        this.con = con;
        this.dc = new DatabaseConect(con);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        conectar = new javax.swing.JButton();
        textBbdd = new java.awt.TextField();
        bbdd = new java.awt.Label();
        createDB = new javax.swing.JButton();
        closeMysqlCon = new javax.swing.JButton();
        dropDB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conectar.setText("Conectar");
        conectar.addActionListener(evt -> conectarActionPerformed(evt));

        bbdd.setText("BBDD");

        createDB.setText("Crear");
        createDB.addActionListener(evt -> createDBActionPerformed(evt));

        closeMysqlCon.setText("Cerrar conexión");
        closeMysqlCon.addActionListener(evt -> closeMysqlConActionPerformed(evt));

        dropDB.setText("Borrar");
        dropDB.addActionListener(evt -> dropDBActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(closeMysqlCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(conectar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bbdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBbdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(createDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dropDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bbdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBbdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(createDB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dropDB)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conectar)
                    .addComponent(closeMysqlCon))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {
        String dataBaseName = textBbdd.getText();
        con = c.getMysql().conectar(dataBaseName);
        if (!(con==null)) {
            JOptionPane.showMessageDialog(null, "Conexión establecida con éxito");
             java.awt.EventQueue.invokeLater(() -> {
            new Editarbbdd(this,new DataBaseObj(con, dataBaseName)).setVisible(true);
            this.setVisible(false);
            this.dispose();
        });
        }
    }
    private void createDBActionPerformed(java.awt.event.ActionEvent evt) {
        String bbdds = textBbdd.getText();
        dc.createDatabase(bbdds);
    }

    private void closeMysqlConActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            c.getMysql().getConnection().close();
            JOptionPane.showMessageDialog(null, "Conexión cerrada con éxito");
            c.setVisible(true);
            this.setVisible(false);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Editarbbdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException ex) {
            Logger.getLogger(ConectorBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dropDBActionPerformed(java.awt.event.ActionEvent evt) {
        String bbdds = textBbdd.getText();
        dc.removeDatabase(bbdds);
    }
}

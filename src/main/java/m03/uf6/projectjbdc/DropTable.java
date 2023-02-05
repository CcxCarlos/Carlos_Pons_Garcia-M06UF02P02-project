package m03.uf6.projectjbdc;

/**
 *
 * @author PC
 */
public class DropTable extends javax.swing.JFrame {
    //start-Interfaz
    private javax.swing.JButton back;
    private javax.swing.JButton dropTable;
    private java.awt.Label table;
    private java.awt.TextField textTable;
    //end-Interfaz
    private final Editarbbdd e;
    private final DataBaseObj db;
  
    public DropTable(Editarbbdd e, DataBaseObj db) {
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.e = e;
        this.db = db;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        textTable = new java.awt.TextField();
        table = new java.awt.Label();
        back = new javax.swing.JButton();
        dropTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setText("Table name");

        back.setText("Back");
        back.addActionListener(evt -> backActionPerformed(evt));

        dropTable.setText("Drop Table");
        dropTable.addActionListener(evt -> dropTableActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(dropTable)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(dropTable))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        this.dispose();
        e.setVisible(true);
    }

    private void dropTableActionPerformed(java.awt.event.ActionEvent evt) {
        db.edit().dropTable(textTable.getText());
    }
}

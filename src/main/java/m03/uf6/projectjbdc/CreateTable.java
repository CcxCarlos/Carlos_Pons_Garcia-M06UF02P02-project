package m03.uf6.projectjbdc;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class CreateTable extends javax.swing.JFrame {
    //start-Interfaz
    private java.awt.Label Extra;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bEliminarTodo;
    private javax.swing.JButton bInsert;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton back;
    private java.awt.Label columnName;
    private java.awt.TextField columnText;
    private javax.swing.JButton createTable;
    private java.awt.Label dataDefault1;
    private java.awt.Label dataKey;
    private java.awt.Label dataNull;
    private java.awt.TextField dataTypeText;
    private java.awt.Label datatype;
    private java.awt.TextField datoText;
    private java.awt.TextField defaultText;
    private java.awt.TextField extraText;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private java.awt.Choice keyText;
    private javax.swing.JSpinner nColumna;
    private javax.swing.JSpinner nFila;
    private java.awt.Choice nullText;
    private javax.swing.JTable tabla;
    private java.awt.Label tablaName;
    private java.awt.Label tablaName1;
    private java.awt.Label tablaName2;
    private java.awt.Label tablaName3;
    private java.awt.TextField tablaText;
    //end-Interfaz
    private final Editarbbdd e;
    private final DataBaseObj db;
    private final DefaultTableModel tm;
    private final String [] datos;
    private int fila;
    private String txtDato;
    private String txtTabla;

    public CreateTable(Editarbbdd e, DataBaseObj db) {
        this.datos = new String[6];
        this.tm = new DefaultTableModel();
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.e = e;
        this.db = db;
        tm.addColumn("Field");
        tm.addColumn("Type");
        tm.addColumn("Null");
        tm.addColumn("Key");
        tm.addColumn("Default");
        tm.addColumn("Extra");
        nullText.add("null");
        nullText.add("not null");
        keyText.add("ninguna");
        keyText.add("primary key");
        keyText.add("foreign key");
        this.tabla.setModel(tm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        tablaText = new java.awt.TextField();
        tablaName = new java.awt.Label();
        back = new javax.swing.JButton();
        createTable = new javax.swing.JButton();
        columnName = new java.awt.Label();
        columnText = new java.awt.TextField();
        datatype = new java.awt.Label();
        dataTypeText = new java.awt.TextField();
        dataNull = new java.awt.Label();
        dataKey = new java.awt.Label();
        Extra = new java.awt.Label();
        dataDefault1 = new java.awt.Label();
        extraText = new java.awt.TextField();
        nullText = new java.awt.Choice();
        keyText = new java.awt.Choice();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bInsert = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bEliminarTodo = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        tablaName1 = new java.awt.Label();
        tablaName2 = new java.awt.Label();
        tablaName3 = new java.awt.Label();
        datoText = new java.awt.TextField();
        jSeparator2 = new javax.swing.JSeparator();
        defaultText = new java.awt.TextField();
        nColumna = new javax.swing.JSpinner();
        nFila = new javax.swing.JSpinner();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        tablaName.setText("Table name *");

        back.setText("Back");
        back.addActionListener(evt -> backActionPerformed(evt));

        createTable.setText("Create Table");
        createTable.addActionListener(evt -> createTableActionPerformed(evt));

        columnName.setText("Column name *");

        datatype.setText("DataType *");

        dataNull.setText("Null");

        dataKey.setText("Key");

        Extra.setText("Extra");

        dataDefault1.setText("Default");

        keyText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        bInsert.setText("Insertar");
        bInsert.addActionListener((java.awt.event.ActionEvent evt) -> {
            bInsertActionPerformed(evt);
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            bEliminarActionPerformed(evt);
        });

        bEliminarTodo.setText("Eliminar Todo");
        bEliminarTodo.addActionListener((java.awt.event.ActionEvent evt) -> {
            bEliminarTodoActionPerformed(evt);
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener((java.awt.event.ActionEvent evt) -> {
            bModificarActionPerformed(evt);
        });

        tablaName1.setText("Nuevo Dato");

        tablaName2.setText("Fila");

        tablaName3.setText("Columna");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createTable)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tablaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(tablaText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(bEliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(columnName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(datatype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dataNull, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(columnText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dataTypeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nullText, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(dataKey, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(dataDefault1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Extra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(keyText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(defaultText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(extraText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(29, 29, 29)))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tablaName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tablaName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tablaName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(datoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(nColumna, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nFila, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))
                                    .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tablaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(columnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(columnText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datatype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataDefault1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defaultText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dataNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nullText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Extra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(extraText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bEliminarTodo)
                                .addComponent(bEliminar))
                            .addComponent(bInsert)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tablaName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tablaName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(datoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tablaName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bModificar))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back)
                            .addComponent(createTable))))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        e.setVisible(true);
        this.dispose();
    }

    private void createTableActionPerformed(java.awt.event.ActionEvent evt) {
        txtTabla=tablaText.getText();
        if (!txtTabla.isEmpty()) {
            db.edit().createTable(txtTabla,tm);
            this.eliminarTodo();
            this.vaciar3();
        }else{
             JOptionPane.showMessageDialog(null,"Omple el camp 'Table Name'");
        }
        
    }

    private void bInsertActionPerformed(java.awt.event.ActionEvent evt) {
        datos[0]= columnText.getText();
        datos[1]= dataTypeText.getText();
        datos[2]= nullText.getSelectedItem();
        datos[3]= keyText.getSelectedItem();
        datos[4]= defaultText.getText();
        datos[5]= extraText.getText();
        if (datos[3].equalsIgnoreCase("ninguna")) {
            datos[3]="";
        }
        if (datos[0].isEmpty()  || datos[1].isEmpty()) {
              JOptionPane.showMessageDialog(null,"Omple els camps obligatoris ' * '");
        }else{
            tm.addRow(datos);
            this.vaciar();
        }
        nFila.setModel(new javax.swing.SpinnerNumberModel(0, 0, numeroFilas(), 1));

    }

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        fila = tabla.getSelectedRow();
        if (fila>=0) {
            tm.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona una fila");
        }
    }

    private void bEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {
        this.eliminarTodo();
    }

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {
        txtDato=datoText.getText();
        if (!txtDato.isEmpty()) {
            tm.setValueAt(txtDato, (int)nFila.getValue(), (int)nColumna.getValue());
            this.vaciar2();
        }else{
            JOptionPane.showMessageDialog(null,"Introdueix la nova dada");
        }
    }

    private void eliminarTodo() {           
        fila = tabla.getRowCount();
        for (int i = fila-1; i >=0; i--) {
            tm.removeRow(i);
        }
    } 
    
    private void vaciar() {
        columnText.setText(null );
        dataTypeText.setText(null);
        defaultText.setText(null);
        extraText.setText(null);
        nullText.select(0);
        keyText.select(0);
    } 
    private void vaciar2() {
        datoText.setText(null);
        nFila.setModel(new javax.swing.SpinnerNumberModel(0, 0, numeroFilas(), 1));
        nColumna.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

    } 
    private void vaciar3() {
        this.vaciar();
        this.vaciar2();
        datoText.setText(null);
    } 
    private int numeroFilas(){
        int rowsCount = tabla.getRowCount();
        return ((rowsCount==0) ?  rowsCount : (rowsCount-1));
    }
}

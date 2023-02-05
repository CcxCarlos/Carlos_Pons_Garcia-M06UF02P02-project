package m03.uf6.projectjbdc;

import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PC
 */
public class MainInterfaz extends javax.swing.JFrame {
    //start-Interfaz
    private javax.swing.JButton addFilm;
    private javax.swing.JButton back;
    private java.awt.Choice byOption;
    private javax.swing.JComboBox<String> directorNameOption;
    private javax.swing.JButton esborrarFilm;
    private java.awt.Choice esborrarOption;
    private javax.swing.JButton filtrar;
    private java.awt.Choice filtreOption;
    private javax.swing.JTextField inputDeleteByString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label labelA;
    private java.awt.Label labelDe;
    private javax.swing.JSpinner maxDate;
    private javax.swing.JSpinner minDate;
    private javax.swing.JSpinner nId;
    private javax.swing.JTable tabla;
    //end-Interfaz
    private final Editarbbdd e;
    private final DataBaseObj db;
    private DefaultTableModel tm;
    private final String itemOrderByAny;
    private final String itemOrderByDirector;
    private boolean hayDatos;
    private int minAny;
    private int maxAny;

    public MainInterfaz(Editarbbdd e, DataBaseObj db){
        this.itemOrderByAny = "Entre fechas";
        this.itemOrderByDirector = "From";
        initComponents();
        setLocation(CenterJframe.getPoint(getWidth(), getHeight()));
        this.e = e;
        this.db = db;
        this.hayDatos = db.comprobarDatos();
        this.generaEstructura();
        this.esborrarOption.addItemListener((ie) -> {
            setOptionRemoveSelected();
        });
        this.filtreOption.addItemListener((ie) -> {
            setOptionFilterSelected();
            this.setOptionFilterBySelected();
        });
        this.byOption.addItemListener((ie) -> {
            this.setOptionFilterBySelected();
        });
        this.maxDate.addChangeListener((ie)->{
            int minValue = (int) minDate.getValue();
            int maxValue = (int) maxDate.getValue();
            ((SpinnerNumberModel)minDate.getModel()).setMaximum(maxValue);
            if (minValue > maxValue) {
                minDate.setValue(maxValue);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        filtreOption = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        byOption = new java.awt.Choice();
        addFilm = new javax.swing.JButton();
        esborrarFilm = new javax.swing.JButton();
        esborrarOption = new java.awt.Choice();
        inputDeleteByString = new javax.swing.JTextField();
        nId = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        labelDe = new java.awt.Label();
        labelA = new java.awt.Label();
        minDate = new javax.swing.JSpinner();
        maxDate = new javax.swing.JSpinner();
        filtrar = new javax.swing.JButton();
        directorNameOption = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.tm = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Name", "Any Estrena", "Pais", "Director"
            }) 
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(tm);
        tabla.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        filtreOption.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Filtre");

        byOption.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addFilm.setText("Add Film");
        addFilm.addActionListener(evt -> addFilmActionPerformed(evt));

        esborrarFilm.setText("Esborrar Film");
        esborrarFilm.addActionListener(evt -> esborrarFilmActionPerformed(evt));

        esborrarOption.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Esborra Per");

        back.setText("Back");
        back.addActionListener(evt -> backActionPerformed(evt));

        labelDe.setText("de");

        labelA.setText("a");

        filtrar.setText("Filtrar");
        filtrar.addActionListener(evt -> filtrarActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtreOption, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(byOption, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directorNameOption, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtrar)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(esborrarOption, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDeleteByString, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(esborrarFilm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addFilm)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(filtreOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(byOption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(minDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(directorNameOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputDeleteByString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(esborrarFilm)
                                .addComponent(nId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addFilm)
                                .addComponent(back))
                            .addComponent(esborrarOption, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void addFilmActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            new AddFilm(this, db).setVisible(true);
        });
    }

    private void esborrarFilmActionPerformed(java.awt.event.ActionEvent evt) {
        switch (this.esborrarOption.getSelectedIndex()) {
            case 1://id
                if (esborrarPeli((int) nId.getValue())) {
                    nId.setValue(1);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un ID correcte");
                }
                break;
            case 2://selecció
                if (!esborrarPeli()) {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila");
                }

                break;
            case 3://any
                if (!esborrarPeli(inputDeleteByString.getText(), 2)) {
                    JOptionPane.showMessageDialog(null, "No s'ha trobat ninguna pel·lícula");
                }

                break;
            case 4://pais
                if (!esborrarPeli(inputDeleteByString.getText(), 3)) {
                    JOptionPane.showMessageDialog(null, "No s'ha trobat ninguna pel·lícula");
                }

                break;
            case 5://director
                if (!esborrarPeli(inputDeleteByString.getText(), 4)) {
                    JOptionPane.showMessageDialog(null, "No s'ha trobat ninguna pel·lícula");
                }

                break;
            default://nom
                if (esborrarPeli(inputDeleteByString.getText(), 1)) {
                    inputDeleteByString.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "No s'ha trobat ninguna pel·lícula");
                }
        }
        if (tm.getRowCount()==0) hayDatos = false;
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        e.setVisible(true);
        this.dispose();
    }

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (hayDatos) filtrarFilms();
    }

    private void generaEstructura() {
        int maxId = 1;
        if (hayDatos) {
            afagirDades(db.getData());
            setDateValues();
            try{
                 maxId = Integer.parseInt(tm.getValueAt(tm.getRowCount() - 1, 0).toString());
                 generaOptionsDirectors();
            }catch(ArrayIndexOutOfBoundsException ex){
            }
            minAny = getMinData();
            maxAny = getMaxData();
        }
        
        String[] items = {"Per ID", "Per nom", "Per any", "Per país", "Per director"};
        String[] orderBy = getDefaultOrder();
        generaFiltre(items, orderBy);
        setOptionFilterBySelected();
        String[] opcionsRemove = {"Per nom", "Per ID", "Per selecció", "Per any", "Per país", "Per director"};
        generarOpcioRemove(opcionsRemove);
        nId.setModel(new javax.swing.SpinnerNumberModel(1, 1, maxId, 1));
        setOptionRemoveSelected();
        
        this.minDate.setModel(new javax.swing.SpinnerNumberModel(minAny, minAny, minAny, 1));
        this.maxDate.setModel(new javax.swing.SpinnerNumberModel(minAny, minAny, maxAny, 1));
    }

    private void afagirDades(ArrayList<String[]> data) {
        data.forEach(s -> {
            tm.addRow(s);
        });
    }

    private void generaFiltre(String[] items, String[] orderBy) {
        for (String item : items) {
            this.filtreOption.add(item);
        }
        for (String item2 : orderBy) {
            this.byOption.add(item2);
        }
    }

    private void generarOpcioRemove(String[] items) {
        for (String item : items) {
            this.esborrarOption.add(item);
        }
    }

    private void setOptionRemoveSelected() {
        switch (this.esborrarOption.getSelectedIndex()) {
            case 1:
                this.inputDeleteByString.setEnabled(false);
                this.inputDeleteByString.setVisible(false);
                if (!nId.isVisible()) {
                    nId.setEnabled(true);
                    nId.setVisible(true);
                }
                break;
            case 2:
                if (inputDeleteByString.isVisible()) {
                    inputDeleteByString.setEnabled(false);
                    inputDeleteByString.setVisible(false);

                }
                if (nId.isVisible()) {
                    nId.setEnabled(false);
                    nId.setVisible(false);
                }
                break;
            default:
                nId.setEnabled(false);
                nId.setVisible(false);
                if (!inputDeleteByString.isVisible()) {
                    inputDeleteByString.setEnabled(true);
                    inputDeleteByString.setVisible(true);
                }
        }
    }

    private void setOptionFilterSelected() {
        switch (this.filtreOption.getSelectedIndex()) {
            case 2:
                addItems(this.getAnyOrder());
                break;
            case 4:
                addItems(this.getDirectorOrder());
                break;
            default:
                addItems(this.getDefaultOrder());
        }
    }

    private void addItems(String[] items) {
        this.byOption.removeAll();
        for (String item : items) {
            this.byOption.addItem(item);
        }
    }

    private void setOptionFilterBySelected() {
        boolean condition = this.byOption.getSelectedIndex() == 2;
        boolean condition2 = this.filtreOption.getSelectedIndex() == 2;
        if (condition) {
            if (condition2) {
                changeStateFilter(!condition2, condition2);
            } else {
                changeStateFilter(!condition2, condition2);
            }
        } else {
            changeStateFilter(condition, condition);
        }
    }

    //Por selección
    private boolean esborrarPeli() {
        int nFila = tabla.getSelectedRow();
        if (nFila < 0) {
            return false;
        }
        int idFilm = Integer.parseInt(String.valueOf(tm.getValueAt(nFila, 0)));
        tm.removeRow(nFila);
        db.delete(idFilm);
        return true;
    }

    //Por una cadena
    private boolean esborrarPeli(String s, int column) {
        int posPeli;
        int idFilm;
        boolean noEntra = true;
        if (s==null || s.isEmpty()) return false;
        while((posPeli = getIndexPeli(s, column))!=-1){/**
             * Bucle, porque puede haber varias pelis con la misma cadena.
             * Ejemplo el país o nombres de pelis que empiecen por A...
             */
            
            idFilm = Integer.parseInt(String.valueOf(tm.getValueAt(posPeli, 0)));
            tm.removeRow(posPeli);
            db.delete(idFilm);
            noEntra = false;
        }
        return !noEntra;
    }

    //Por id
    private boolean esborrarPeli(int idPeli) {
        int posPeli = getIndexPeli(idPeli);
        if (posPeli == -1) return false;
        tm.removeRow(posPeli);
        db.delete(idPeli);
        return true;
    }

    private int getIndexPeli(String s, int column) {
        for (int i = 0; i < tm.getRowCount(); i++) {
            if (tm.getValueAt(i, column).toString().toLowerCase().contains(s.toLowerCase())) 
                return i;
        }
        return -1;
    }

    private int getIndexPeli(int idPeli) {
        for (int i = 0; i < tm.getRowCount(); i++) {
            if (Integer.parseInt(tm.getValueAt(i, 0).toString()) == idPeli) 
                return i;
        }
        return -1;
    }

    private int getMinData() {
        return db.getMinAny();
    }

    private int getMaxData() {
        return db.getMaxAny();
    }

    private ArrayList<String> getDirectors() {
        return db.getDirectorsNames();
    }

    private String[] getDefaultOrder() {
        return new String[]{"ASC", "DSC"};
    }

    private String[] getAnyOrder() {
        var defaultOrder = getDefaultOrder();
        int defaultOrderSize = defaultOrder.length;
        var ordeNou = new String[defaultOrderSize + 1];
        System.arraycopy(defaultOrder, 0, ordeNou, 0, defaultOrderSize);
        ordeNou[defaultOrderSize] = this.itemOrderByAny;

        return ordeNou;
    }

    private String[] getDirectorOrder() {
        var defaultOrder = getDefaultOrder();
        int defaultOrderSize = defaultOrder.length;
        var ordeNou = new String[defaultOrderSize + 1];
        System.arraycopy(defaultOrder, 0, ordeNou, 0, defaultOrderSize);
        ordeNou[defaultOrderSize] = this.itemOrderByDirector;

        return ordeNou;
    }
    private void generaOptionsDirectors() {
        getDirectors().forEach(item -> {
            directorNameOption.addItem(item);
        });

    }
    
    private void filtrarFilms() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm);
        ArrayList<RowSorter.SortKey> sortKeys;
        ArrayList<RowFilter<Object, Object>> filters;
        CustomComparatorStringDate comparator = new CustomComparatorStringDate();
        switch (byOption.getSelectedIndex()) {
            case 0:
                sortKeys = new ArrayList<>();
                sorter.setComparator(filtreOption.getSelectedIndex(), comparator);
                sortKeys.add(new RowSorter.SortKey(
                        filtreOption.getSelectedIndex(),
                         SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                break;
            case 1:
                sortKeys = new ArrayList<>();
                sorter.setComparator(filtreOption.getSelectedIndex(), comparator);
                sortKeys.add(new RowSorter.SortKey(
                        filtreOption.getSelectedIndex(),
                         SortOrder.DESCENDING));
                sorter.setSortKeys(sortKeys);
                break;
            default:
                if (filtreOption.getSelectedIndex() == 2) {
                    filters = new ArrayList<>();

                    Date startDate = Date.valueOf( new StringBuilder(checkYear(minDate.getValue()))
                                .append('-').append(1).append('-').append(1).toString());
                    Date endDate = Date.valueOf(new StringBuilder(checkYear(maxDate.getValue()))
                                .append('-').append(12).append('-').append(31).toString());

                    filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, startDate));
                    filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, endDate));
                    sorter.setRowFilter(RowFilter.andFilter(filters));

                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(
                            String.valueOf(directorNameOption.getSelectedItem()),
                             4));
                }
                break;
        }
        tabla.setRowSorter(sorter);    
    }
    
    private void setDateValues(){
        for (int i = 0; i < tm.getRowCount(); i++) {
            tm.setValueAt(Date.valueOf(String.valueOf(tm.getValueAt(i, 2))), i, 2);
        }
    }
    private void setDateValues(int id){
        int posRow = getIndexPeli(id);
        tm.setValueAt(Date.valueOf(String.valueOf(tm.getValueAt(posRow, 2))), posRow, 2);
        
    }

//    private Date changeStringValueToDate(String value) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            return dateFormat.parse(value);
//        } catch (ParseException ex) {
//            Logger.getLogger(MainInterfaz.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    public void updateContent(Films film, Director newDirector) {
        tm.addRow(film.getData());
        setDateValues(film.getId());
        SpinnerNumberModel minDateModel = (SpinnerNumberModel)this.minDate.getModel();
        SpinnerNumberModel maxDateModel = (SpinnerNumberModel)this.maxDate.getModel();
        SpinnerNumberModel idSpinner = (SpinnerNumberModel)nId.getModel();
        if (newDirector!=null) directorNameOption.addItem(newDirector.getNom());
        int yearFilm = Integer.parseInt(film.getDataEstrena().toString().substring(0, 4));
        idSpinner.setMaximum(film.getId());
        
        if (!hayDatos) {
            maxDateModel.setMinimum(yearFilm);
            minDateModel.setMinimum(yearFilm);
            maxDateModel.setMaximum(yearFilm);
            minDateModel.setValue(yearFilm);
            maxDateModel.setValue(yearFilm);
            minAny = yearFilm;
            maxAny = yearFilm;
            hayDatos = true;
        }else{
            if (minAny > yearFilm) {
                minDateModel.setMinimum(yearFilm);
                maxDateModel.setMinimum(yearFilm);
                minAny = yearFilm;
            }else if(maxAny < yearFilm){
                maxDateModel.setMaximum(yearFilm);
                maxAny = yearFilm;
            }
        }
       
        filtrarFilms();
    }

    private void changeStateFilter(boolean b, boolean b0) {
        this.directorNameOption.setVisible(b);
                this.directorNameOption.setEnabled(b);
                this.labelA.setVisible(b0);
                this.labelA.setEnabled(b0);
                this.labelDe.setVisible(b0);
                this.labelDe.setEnabled(b0);
                this.minDate.setVisible(b0);
                this.minDate.setEnabled(b0);
                this.maxDate.setVisible(b0);
                this.maxDate.setEnabled(b0);
    }
    
    private void addColumns(String[] columnas) {
        for (String columna : columnas) {
             tm.addColumn(columna);   
        }
    }
    private String checkYear(Object year) {
        String yearString = String.valueOf(year);
        StringBuilder sb = new StringBuilder();
        for (int i = yearString.length(); i < 4; i++) {
            sb.append("0");
        }
        return sb.append(year).toString();
    }
}
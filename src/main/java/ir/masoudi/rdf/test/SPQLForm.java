/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.masoudi.rdf.test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * @author Rasoul Masoudi
 */
public class SPQLForm extends javax.swing.JFrame {

    private final RDFHandler rdfHandler = new RDFHandlerImpl();

    public SPQLForm() {
        initComponents();
        lstSamples.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        lstResults.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        txtQuery = new javax.swing.JTextArea();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jLabel1.setText("کوئری:");

        jLabel2.setText("نمونه کوئری ها:");
        JScrollPane jScrollPane2 = new JScrollPane();
        lstSamples = new javax.swing.JList<>();
        JLabel jLabel3 = new JLabel();
        JScrollPane jScrollPane3 = new JScrollPane();
        lstResults = new javax.swing.JList<>();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RDF Test");
        setResizable(false);

        txtQuery.setColumns(20);
        txtQuery.setRows(5);
        txtQuery.setText("PREFIX wd: <http://www.wikidata.org/entity/>\nPREFIX wds: <http://www.wikidata.org/entity/statement/>\nPREFIX wdv: <http://www.wikidata.org/value/>\nPREFIX wdt: <http://www.wikidata.org/prop/direct/>\nPREFIX wikibase: <http://wikiba.se/ontology#>\nPREFIX p: <http://www.wikidata.org/prop/>\nPREFIX ps: <http://www.wikidata.org/prop/statement/>\nPREFIX pq: <http://www.wikidata.org/prop/qualifier/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX bd: <http://www.bigdata.com/rdf#>\nSELECT ?food \nWHERE { \n    ?food wdt:P495 wd:Q794 .\n}");
        jScrollPane1.setViewportView(txtQuery);

        lstSamples.setModel(new javax.swing.AbstractListModel<String>() {
            final String[] strings = {"غذاهای اصالتا ایرانی", "غذاهای خورشتی", "دسرها"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        lstSamples.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSamples.setSelectedIndex(0);
        lstSamples.addListSelectionListener(evt -> jList1ValueChanged());
        jScrollPane2.setViewportView(lstSamples);

        jLabel3.setText("نتایج:");

        jScrollPane3.setViewportView(lstResults);

        jButton1.setText("اجرا");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("انتخاب فایل دامپ");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jLabel1))
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        runSelectedQuery();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File file = fc.getSelectedFile();
        if (file == null) {
            return;
        }
        try {
            rdfHandler.openDump(file);
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void runSelectedQuery() {
        if (!rdfHandler.hasDump()) {
            JOptionPane.showMessageDialog(null, "ابتدا باید فایل دامپ را انتخاب کنید.");
            return;
        }
        String query = txtQuery.getText();
        final List<String> result = rdfHandler.runQuery(query);
        lstResults.setModel(new javax.swing.AbstractListModel<String>() {
            final String[] values = result.toArray(new String[0]);

            @Override
            public int getSize() {
                return values.length;
            }

            @Override
            public String getElementAt(int i) {
                return values[i];
            }
        });
    }

    private void jList1ValueChanged() {
        int selectedIndex = lstSamples.getSelectedIndex();
        String query = "";
        switch (selectedIndex) {
            case 0:
                query = Constants.PREFIX_LIST + "SELECT ?food \n"
                        + "WHERE { \n"
                        + "    ?food wdt:P495 wd:Q794 .\n"
                        + "}";
                break;
            case 1:
                query = Constants.PREFIX_LIST + "SELECT ?food \n"
                        + "WHERE { \n"
                        + "    ?food wdt:P279 wd:Q2920963 .\n"
                        + "}";
                break;
            case 2:
                query = Constants.PREFIX_LIST + "SELECT ?food \n"
                        + "WHERE { \n"
                        + "    ?food wdt:P279 wd:Q182940 .\n"
                        + "}";
                break;
        }
        txtQuery.setText(query);
        runSelectedQuery();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new SPQLForm();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private javax.swing.JList<String> lstSamples;
    private javax.swing.JList<String> lstResults;
    private javax.swing.JTextArea txtQuery;
}

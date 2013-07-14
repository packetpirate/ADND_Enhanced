package adndframework.windows;

import adndframework.windows.tools.InformationTable;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

/**
 * Displays an information table on a JPanel.
 * 
 * @author Darin Beaudreau
 */
public class InformationTableWindow extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private adndframework.framework.Framework framework = null;
    private javax.swing.JPanel displayPanel = null;
    private JTable table = null;
    private String [][] tablesListNames = null;
    
    public InformationTableWindow(adndframework.framework.Framework framework, String filename, String [][] tablesListNames) {
        this.framework = framework;
        this.tablesListNames = tablesListNames;
        
        {
            String [] listNames = new String[this.tablesListNames.length];
            for(int i = 0; i < this.tablesListNames.length; i++) listNames[i] = this.tablesListNames[i][0];
            javax.swing.JLabel tablesLabel = new javax.swing.JLabel("Tables: ");
            javax.swing.JComboBox tablesList = new javax.swing.JComboBox(listNames);
            tablesList.setSelectedIndex(0);
            tablesList.addActionListener(this);
            this.displayPanel = new javax.swing.JPanel();
            this.displayPanel.setLayout(new java.awt.BorderLayout());
            changeTable(filename);
            
            this.setLayout(new java.awt.BorderLayout());
            this.add(tablesLabel, java.awt.BorderLayout.PAGE_START);
            this.add(tablesList, java.awt.BorderLayout.CENTER);
            this.add(this.displayPanel, java.awt.BorderLayout.PAGE_END);
        }
        
        setPreferredSize(new java.awt.Dimension(640, 480));
        setFocusable(true);
        requestFocus();
    }
    
    private void changeTable(String filename) {
        this.table = new InformationTable(filename).getTable();
        this.displayPanel.removeAll();
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(this.table);
        this.table.setFillsViewportHeight(true);
        this.displayPanel.add(this.table.getTableHeader(), java.awt.BorderLayout.PAGE_START);
        this.displayPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        this.displayPanel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle selecting new elements in the tables list.
        javax.swing.JComboBox cb = (javax.swing.JComboBox)e.getSource();
        String source = (String)cb.getSelectedItem();
        for(int i = 0; i < this.tablesListNames.length; i++) {
            if(this.tablesListNames[i][0].equals(source)) {
                changeTable(this.tablesListNames[i][1]);
                break;
            }
        }
    }
}


package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.EquipSpecificationBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nada El-Gammal
 */

public class EqSpecificationPanel extends javax.swing.JPanel {
  @SuppressWarnings({ "compatibility:5169086565475610956",
      "oracle.jdeveloper.java.serialversionuid-stale" })
  private static final long serialVersionUID = 1L;

  // identify object of EquipSpecificationBao
private static EquipSpecificationBao business ;
private static UserDto user_data;

    //method to set the table and allocate its columns and content
    private void setTableModel(List<EquipSpecificationDto> eq_specif){
        int size=0;
        if(eq_specif != null && !eq_specif.isEmpty()){
            size = eq_specif.size();
            }
        Object [][] eqSpArr = new Object [size][3];
        for(int i =0;i<size;i++){
            eqSpArr[i][0] = eq_specif.get(i).getId();
            eqSpArr[i][1] = eq_specif.get(i).getName();
           eqSpArr[i][2] = eq_specif.get(i).getValue();
        }
        EqSpecificationTable.setModel(new javax.swing.table.DefaultTableModel(eqSpArr,
            new String [] {
                "ID", "Name", "Value"
            }
        ));


    //change header color
    EqSpecificationTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
    {

      @Override
      public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus, int row,
        int column)
      {

        JLabel l =
          (JLabel) super.getTableCellRendererComponent(table, value,
          isSelected, hasFocus, row, column);
        l.setBackground(Color.decode("#0081D3"));
        // l.setBorder(new EtchedBorder());

        l.setForeground(Color.white);

        return l;
      }
    });

    //label under tabel show types count viewed in table
    no_of_rows.setText("Table result: "+
      Integer.toString(EqSpecificationTable.getRowCount())+"  specifications");
    }

    /** Creates new form EqSpecificationJPanel */
    public EqSpecificationPanel(UserDto user) {
        try {
            //create object from EquipmentSpecificationBaoImpl
                   business = new BaoFactory().createEquipmentSpecificationBao();

                    initComponents();
                    user_data = user ;
                    viewonly(user_data);
            
                   //call setTableModel method and pass viewAll method to it as a parameter
                   setTableModel(business.listAll());            
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
        }


  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Equipment Specification");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  private void initComponents()//GEN-BEGIN:initComponents
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    EqSpecificationTable = new javax.swing.JTable();
    searchText = new javax.swing.JTextField();
    no_of_rows = new java.awt.Label();
    EditPanel = new javax.swing.JPanel();
    IdLabel = new javax.swing.JLabel();
    CodeLabel = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    IdText = new javax.swing.JTextField();
    nameText = new javax.swing.JTextField();
    valueText = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    savePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    deletePanel = new javax.swing.JPanel();
    deleteButton = new javax.swing.JButton();
    clearPanel = new javax.swing.JPanel();
    clear = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    refreshPanel = new javax.swing.JPanel();
    refreshButton = new javax.swing.JButton();
    searchPanel = new javax.swing.JPanel();
    searchButton = new javax.swing.JButton();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    EqSpecificationTable.setAutoCreateRowSorter(true);
    EqSpecificationTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EqSpecificationTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
      },
      new String []
      {
        "ID", "Name", "Value"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean []
      {
        false, false, false
      };

      public Class getColumnClass(int columnIndex)
      {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return canEdit [columnIndex];
      }
    });
    EqSpecificationTable.setFillsViewportHeight(true);
    EqSpecificationTable.setRowHeight(25);
    EqSpecificationTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    EqSpecificationTable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        EqSpecificationTableMouseClicked(evt);
      }
    });
    EqSpecificationTable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        EqSpecificationTableKeyPressed(evt);
      }
    });
    jScrollPane1.setViewportView(EqSpecificationTable);
    if (EqSpecificationTable.getColumnModel().getColumnCount() > 0)
    {
      EqSpecificationTable.getColumnModel().getColumn(0).setHeaderValue("ID");
      EqSpecificationTable.getColumnModel().getColumn(1).setHeaderValue("Name");
      EqSpecificationTable.getColumnModel().getColumn(2).setHeaderValue("Value");
    }

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 96, 710, 770));

    searchText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    searchText.setText("Enter Text to Search");
    searchText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    searchText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        searchTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        searchTextFocusLost(evt);
      }
    });
    searchText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        searchTextActionPerformed(evt);
      }
    });
    add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 27, 620, 50));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 860, 200, 40));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    IdLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdLabel.setForeground(new java.awt.Color(0, 51, 204));
    IdLabel.setText("ID");
    EditPanel.add(IdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 30, 40));

    CodeLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    CodeLabel.setForeground(new java.awt.Color(0, 51, 204));
    CodeLabel.setText("Name");
    EditPanel.add(CodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 296, -1, 30));

    jLabel3.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 51, 204));
    jLabel3.setText("Value");
    EditPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 386, -1, 30));

    IdText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    IdText.setText("Enter ID");
    IdText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    IdText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        IdTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        IdTextFocusLost(evt);
      }
    });
    IdText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        IdTextActionPerformed(evt);
      }
    });
    EditPanel.add(IdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 230, 580, 50));

    nameText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    nameText.setText("Enter Specification Name");
    nameText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    nameText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        nameTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        nameTextFocusLost(evt);
      }
    });
    nameText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        nameTextActionPerformed(evt);
      }
    });
    EditPanel.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 580, 50));

    valueText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    valueText.setText("Enter Specification Value");
    valueText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    valueText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        valueTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        valueTextFocusLost(evt);
      }
    });
    EditPanel.add(valueText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 580, 50));

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_maintenance_128px.png"))); // NOI18N
    EditPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

    savePanel.setBackground(new java.awt.Color(0, 129, 211));

    Save.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    Save.setForeground(new java.awt.Color(255, 255, 255));
    Save.setText("Save");
    Save.setBorderPainted(false);
    Save.setContentAreaFilled(false);
    Save.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        SaveMouseMoved(evt);
      }
    });
    Save.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        SaveMouseExited(evt);
      }
    });
    Save.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        SaveActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout savePanelLayout = new javax.swing.GroupLayout(savePanel);
    savePanel.setLayout(savePanelLayout);
    savePanelLayout.setHorizontalGroup(
      savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
    );
    savePanelLayout.setVerticalGroup(
      savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(savePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 110, -1));

    deletePanel.setBackground(new java.awt.Color(0, 129, 211));

    deleteButton.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    deleteButton.setForeground(new java.awt.Color(255, 255, 255));
    deleteButton.setText("Delete");
    deleteButton.setBorderPainted(false);
    deleteButton.setContentAreaFilled(false);
    deleteButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        deleteButtonMouseMoved(evt);
      }
    });
    deleteButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        deleteButtonMouseExited(evt);
      }
    });
    deleteButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        deleteButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
    deletePanel.setLayout(deletePanelLayout);
    deletePanelLayout.setHorizontalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
    );
    deletePanelLayout.setVerticalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

    clearPanel.setBackground(new java.awt.Color(0, 129, 211));

    clear.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    clear.setForeground(new java.awt.Color(255, 255, 255));
    clear.setText("Clear");
    clear.setBorderPainted(false);
    clear.setContentAreaFilled(false);
    clear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        clearMouseMoved(evt);
      }
    });
    clear.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        clearMouseExited(evt);
      }
    });
    clear.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        clearActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout clearPanelLayout = new javax.swing.GroupLayout(clearPanel);
    clearPanel.setLayout(clearPanelLayout);
    clearPanelLayout.setHorizontalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    clearPanelLayout.setVerticalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(clearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 100, -1));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 610, 750));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Equipment specification");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 460, 90));
    add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, 620, 20));

    refreshPanel.setBackground(new java.awt.Color(0, 129, 211));

    refreshButton.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    refreshButton.setForeground(new java.awt.Color(255, 255, 255));
    refreshButton.setText("Refresh ");
    refreshButton.setBorderPainted(false);
    refreshButton.setContentAreaFilled(false);
    refreshButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        refreshButtonMouseMoved(evt);
      }
    });
    refreshButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        refreshButtonMouseExited(evt);
      }
    });
    refreshButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        refreshButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout refreshPanelLayout = new javax.swing.GroupLayout(refreshPanel);
    refreshPanel.setLayout(refreshPanelLayout);
    refreshPanelLayout.setHorizontalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(refreshPanelLayout.createSequentialGroup()
        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    refreshPanelLayout.setVerticalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 880, 110, 50));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));

    searchButton.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    searchButton.setForeground(new java.awt.Color(255, 255, 255));
    searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_search_26px.png"))); // NOI18N
    searchButton.setBorderPainted(false);
    searchButton.setContentAreaFilled(false);
    searchButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        searchButtonMouseMoved(evt);
      }
    });
    searchButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        searchButtonMouseExited(evt);
      }
    });
    searchButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        searchButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
    searchPanel.setLayout(searchPanelLayout);
    searchPanelLayout.setHorizontalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
    );
    searchPanelLayout.setVerticalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 80, -1));
  }//GEN-END:initComponents

// create object from EquipSpecificationDto
        EquipSpecificationDto eq_spec = new EquipSpecificationDto();

    private void searchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusGained

    // delete text from textfield when textfield is selected 
    if (searchText.getText().equalsIgnoreCase("Enter Text to Search"))
        searchText.setText("");

    searchText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_searchTextFocusGained

    private void searchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusLost
   
    // reset text of textfield to its default when its focus is lost
    if (searchText.getText().trim().equalsIgnoreCase(""))
        searchText.setText("Enter Text to Search");

    searchText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_searchTextFocusLost

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained

    // delete text from textfield when textfield is selected 
    if (IdText.getText().equalsIgnoreCase("Enter ID"))
        IdText.setText("");

    IdText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_IdTextFocusGained

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost

    // reset text of textfield to its default when its focus is lost
    if (IdText.getText().trim().equalsIgnoreCase(""))
        IdText.setText("Enter ID");

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_IdTextFocusLost

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
    //implementation of search button
    try
      {

        // check that user has entered text in textfield
        String search = searchText.getText();
        if(!(search.equals("Enter Text to Search")))
          {
            List<EquipSpecificationDto> search_list = null;
            eq_spec.setSearch(searchText.getText());

            //pass the text of searchtextfield to the dto object
            search_list = business.searchFor(eq_spec);
            if(search_list!=null)
              {

                // reset and repaint the table with the returned search list
                setTableModel(search_list);
                EqSpecificationTable.repaint();
              }
            else
              { // show message when no equipment found then reset and repaint table to default

                JOptionPane.showMessageDialog(this,
                  "Specification Not Found");

              }
          }
        else
          JOptionPane.showMessageDialog(this,
            "Please Enter Text To Search For");
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
            
    }//GEN-LAST:event_searchTextActionPerformed

    private void nameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusGained

    // delete text from textfield when textfield is selected 
    if (nameText.getText().equalsIgnoreCase("Enter Specification Name"))
        nameText.setText("");

    nameText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_nameTextFocusGained

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost

    // reset text of textfield to its default when its focus is lost
    if (nameText.getText().trim().equalsIgnoreCase(""))
        nameText.setText("Enter Specification Name");

    nameText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_nameTextFocusLost

    private void valueTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueTextFocusGained
    
    // delete text from textfield when textfield is selected 
    if (valueText.getText().equalsIgnoreCase("Enter Specification Value"))
        valueText.setText("");

    valueText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_valueTextFocusGained

    private void valueTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueTextFocusLost
   
    // reset text of textfield to its default when its focus is lost
    if (valueText.getText().trim().equalsIgnoreCase(""))
        valueText.setText("Enter Specification Value");

    valueText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_valueTextFocusLost

    private void EqSpecificationTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EqSpecificationTableKeyPressed
   
    // set text of textfields by the data of the keypressed row in table 
    if( evt.getExtendedKeyCode()==KeyEvent.VK_UP || evt.getExtendedKeyCode()==KeyEvent.VK_DOWN ){
        int row = EqSpecificationTable.getSelectedRow();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_UP)
            row--;      //for up key decrement
        else if(evt.getExtendedKeyCode() == KeyEvent.VK_DOWN)
            row++;      // down key increment
        IdText.setEnabled(false);
        Save.setText("Update");
        IdText.setText(EqSpecificationTable.getModel().getValueAt(row,0).toString());
        nameText.setText(EqSpecificationTable.getModel().getValueAt(row,1).toString());
        valueText.setText(EqSpecificationTable.getModel().getValueAt(row,2).toString());
    }
    }//GEN-LAST:event_EqSpecificationTableKeyPressed

    private void EqSpecificationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EqSpecificationTableMouseClicked
   
    // set text of textfields by the data of the mouse clicked row in table 
    int row = EqSpecificationTable.getSelectedRow();
      IdText.setEnabled(false);
      Save.setText("Update");

    IdText.setText(EqSpecificationTable.getModel().getValueAt(row,0).toString());
    nameText.setText(EqSpecificationTable.getModel().getValueAt(row,1).toString());
    valueText.setText(EqSpecificationTable.getModel().getValueAt(row,2).toString());
    }//GEN-LAST:event_EqSpecificationTableMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
    // new button implementation
      
    if(Save.getText().equalsIgnoreCase("Update"))
      update();

    else{
        try{
            
            //check validity of data enterd by user using checkValidity method 
            if(checkValidity()){
                
      //pass data from textfields to dto object properties 
               eq_spec.setId(Integer.parseInt(IdText.getText()));
               eq_spec.setName(nameText.getText());
               eq_spec.setValue(valueText.getText());
               
     //call insert method from bao and pass the dto object as parameter
               if(business.insert(eq_spec , user_data)){
                   
     //show message when method terminated successfully
                   JOptionPane.showMessageDialog(this, "Specification Inserted Successfully");
                   
      // reset and repaint the table after adding equipment
                    setTableModel(business.listAll());
                    EqSpecificationTable.repaint();
                    IdText.setEnabled(false);
                    Save.setText("Update");
                    
               }
               else{
                 int reply =
                   JOptionPane.showConfirmDialog(null,
                     "This specification is already exist!\n\n"+
                     "Do you want update it?", "Warning",
                     JOptionPane.YES_NO_OPTION);

                 //update object if user choose yes
                 if(reply==JOptionPane.YES_OPTION)
                   {
                     update();
                     Save.setText("Update");
                     IdText.setEnabled(false);                 
                   }}
          
            }
       
        }
        catch(Exception e){
            e.printStackTrace();
        }}
        
    }//GEN-LAST:event_SaveActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    // implementation of delete button 
        try{
    // get the select row count from table
            int r = EqSpecificationTable.getSelectedRow();
            
     // get data from the selected row and store it to the dto object fields 
            eq_spec.setId(Integer.parseInt(EqSpecificationTable.getModel().getValueAt(r,0).toString()));
            eq_spec.setName(EqSpecificationTable.getModel().getValueAt(r,1).toString());
            eq_spec.setValue(EqSpecificationTable.getModel().getValueAt(r,2).toString());
           
     // call delete method from bao and pass the dto object to it as parameter to delete it
            if(business.delete(eq_spec)){
                
    //show message when process terminated successfully
                JOptionPane.showMessageDialog(this, "Equipment Deleted Successfully");
               
    //set the table with the newest list in database and repaint it using listAll method in bao
                IdText.setEnabled(true);
                Save.setText("Save");
                setTableModel(business.listAll());
                EqSpecificationTable.repaint();
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e){
            
                // show message if no row is selected from table 

            JOptionPane.showMessageDialog(this, "Please select row from table to delete");
            }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
    //implementation of refresh button

        try {
            // reset and repaint the table then set text of textfields to its default when panel is opened
            setTableModel(business.listAll());
            EqSpecificationTable.repaint();
        IdText.setEnabled(true);
        Save.setText("Save");
        IdText.setText("Enter ID");
        nameText.setText("Enter Specification Name");
        valueText.setText("Enter Specification Value");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
      
    //implementation of search button
        try{
            
            // check that user has entered text in textfield
            String search = searchText.getText();
            if( ! (search.equals("Enter Text to Search")) ){
            List<EquipSpecificationDto> search_list = null;
             eq_spec.setSearch(searchText.getText());
             
    //pass the text of searchtextfield to the dto object
            search_list = business.searchFor(eq_spec);
            if(search_list != null){
                
     // reset and repaint the table with the returned search list
                setTableModel(search_list);
                EqSpecificationTable.repaint();
            }
            else{   // show message when no equipment found then reset and repaint table to default

                JOptionPane.showMessageDialog(this,"Specification Not Found");
               
            }}
            else
                JOptionPane.showMessageDialog(this,"Please Enter Text To Search For");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_searchButtonActionPerformed

  private void clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearActionPerformed
  {//GEN-HEADEREND:event_clearActionPerformed
    // TODO add your handling code here:

    IdText.setEnabled(true);
    Save.setText("Save");
    IdText.setText("Enter ID");
    nameText.setText("Enter Specification Name");
    valueText.setText("Enter Specification Value");

  }//GEN-LAST:event_clearActionPerformed

  private void searchButtonMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchButtonMouseExited
  {//GEN-HEADEREND:event_searchButtonMouseExited
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_searchButtonMouseExited

  private void refreshButtonMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_refreshButtonMouseExited
  {//GEN-HEADEREND:event_refreshButtonMouseExited
    // TODO add your handling code here:

    refreshPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_refreshButtonMouseExited

  private void SaveMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseExited
  {//GEN-HEADEREND:event_SaveMouseExited
    // TODO add your handling code here:

    savePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_SaveMouseExited

  private void deleteButtonMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_deleteButtonMouseExited
  {//GEN-HEADEREND:event_deleteButtonMouseExited
    // TODO add your handling code here:
    deletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_deleteButtonMouseExited

  private void clearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseExited
  {//GEN-HEADEREND:event_clearMouseExited
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_clearMouseExited

  private void SaveMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseMoved
  {//GEN-HEADEREND:event_SaveMouseMoved
    // TODO add your handling code here:
    savePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_SaveMouseMoved

  private void deleteButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_deleteButtonMouseMoved
  {//GEN-HEADEREND:event_deleteButtonMouseMoved
    // TODO add your handling code here:
    deletePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_deleteButtonMouseMoved

  private void clearMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseMoved
  {//GEN-HEADEREND:event_clearMouseMoved
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_clearMouseMoved

  private void searchButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchButtonMouseMoved
  {//GEN-HEADEREND:event_searchButtonMouseMoved
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_searchButtonMouseMoved

  private void refreshButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_refreshButtonMouseMoved
  {//GEN-HEADEREND:event_refreshButtonMouseMoved
    // TODO add your handling code here:
    refreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_refreshButtonMouseMoved

    // method to check the validity of user input in each text field 
    private boolean checkValidity(){

        try{
            if(IdText.getText().equalsIgnoreCase("Enter ID")){
                JOptionPane.showMessageDialog(this, "Please, enter id number","",JOptionPane.ERROR_MESSAGE);
                return false;            
            }
            Integer.parseInt(IdText.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "ID is invalid! \n (please enter a number)");
            return false;
        }
        try{
            if(nameText.getText().equalsIgnoreCase("Enter Specification Name")){
                JOptionPane.showMessageDialog(this, "Please, Enter Specification Name");
                return false;
            }
                Integer.parseInt(nameText.getText());
                JOptionPane.showMessageDialog(this, "Specification Name is invalid! \n (please enter a string)");
                return false;
            }catch (NumberFormatException e){
                
        try{
            if(valueText.getText().equalsIgnoreCase("Enter Specification Value")){
                JOptionPane.showMessageDialog(this, "Please, Enter Specification Value");
                return false;
            }
                return true;
            }catch (NumberFormatException es){
        return true;
    }}}
    
/**Upate an existing equipment specification*/
private void update()
{
  // implementation of update button
    try
      {
        // check the data validity enterd by user using the defined checkValidity method
        if(checkValidity())
          {

            // store data entered by user in dto object attributes
            eq_spec.setId(Integer.parseInt(IdText.getText()));
            eq_spec.setName(nameText.getText());
            eq_spec.setValue(valueText.getText());

            /* call update method from bao then show message if the process terminated successfully
   and repaint the table with the lateset updates */
            if(business.update(eq_spec, user_data))
              {

                //show message when process terminated successfully the reset and repaint data with lateset updates
                JOptionPane.showMessageDialog(this,
                  "Specification Updated Successfully");
                setTableModel(business.listAll());
                EqSpecificationTable.repaint();
              }
            else
              {
                JOptionPane.showMessageDialog(this,
                  "This specification doesn't exist", "Done", 0);
              }

          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel CodeLabel;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JTable EqSpecificationTable;
  private javax.swing.JLabel IdLabel;
  private javax.swing.JTextField IdText;
  private javax.swing.JButton Save;
  private javax.swing.JButton clear;
  private javax.swing.JPanel clearPanel;
  private javax.swing.JButton deleteButton;
  private javax.swing.JPanel deletePanel;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JTextField nameText;
  private java.awt.Label no_of_rows;
  private javax.swing.JButton refreshButton;
  private javax.swing.JPanel refreshPanel;
  private javax.swing.JPanel savePanel;
  private javax.swing.JButton searchButton;
  private javax.swing.JPanel searchPanel;
  private javax.swing.JTextField searchText;
  private javax.swing.JTextField valueText;
  // End of variables declaration//GEN-END:variables

}

package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.FloorBao;
import com.fym.lta.BAO.RoleScreenBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.RoleDao;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DAO.RoleScreenDaoImpl;
import com.fym.lta.DAO.ScreenDao;

import com.fym.lta.DTO.FloorDto;
import com.fym.lta.DTO.RoleDto;
import com.fym.lta.DTO.RoleScreenDto;
import com.fym.lta.DTO.ScreenDto;


import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.Component;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;


import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author Islam
 */
public class RoleScreenPanel extends javax.swing.JPanel {
  @SuppressWarnings({ "compatibility:-9119701677440911405",
      "oracle.jdeveloper.java.serialversionuid-stale" })
  private static final long serialVersionUID = 1L;
  
 private static  UserDto user = new UserDto();

  /** Creates new form RollScreen */
  @SuppressWarnings("deprecation")
  public RoleScreenPanel(UserDto userdto) {
        initComponents();
        groupButton();
        defaultdata();
        user =userdto;
        viewonly(user);
        RoleScreenDao dao= new  RoleScreenDaoImpl(); //create LT bao object
        setTableModel(dao.viewAll());
        
    }

  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Role Screens");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }
  
  
    private void setTableModel(List<RoleScreenDto> types){
        
       int s=0;
       if(types!=null && !types.isEmpty())
       {   s= types.size();
       
       }      
              
       Object [][] TypeArr = new Object [s][4];       
            for(int i =0;i<s;i++){
            TypeArr[i][0] = types.get(i).getRole_name();            
            TypeArr[i][1] = types.get(i).getScreen_name();
            TypeArr[i][2] = (types.get(i).isFull_access())? "Yes":"No";
            TypeArr[i][3] = (types.get(i).isView_only())? "Yes":"No";
        }
            
        roleScreenTable.setModel(new javax.swing.table.DefaultTableModel(TypeArr,
            new String [] { "Name Role" , "Name Screen","Full Access","View Only"}
        ));

    //change header color
    roleScreenTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
      Integer.toString(roleScreenTable.getRowCount()));
    
    
    }
    
    
    private void groupButton(){

    ButtonGroup bg1 = new ButtonGroup();
    bg1.add(FullAcc);
    bg1.add(ViewOnly);
    bg1.clearSelection();
    
    
    }

    private void defaultdata(){
      
        try{

            Save.setText("Save");

            RoleDao role_dao = new DaoFactory().createRoleDao();
            List<RoleDto> role_list = role_dao.viewAll();
          
            RoleComboBox.removeAllItems();
          
            if(role_list != null && !role_list.isEmpty())
            {for (int i=0 ; i < role_list.size() ; i++ ) {
                RoleComboBox.addItem(role_list.get(i).getName());
            }}

       
          
            ScreenDao screen_dao = new DaoFactory().createScreenDao();
            List<ScreenDto> screen_list = screen_dao.viewAll();


            RoleSearchCombo.removeAllItems();
            RoleSearchCombo.addItem("Select Role");

            if(role_list!=null&&!role_list.isEmpty())
            {
               for(int i = 0; i<role_list.size(); i++)
              {
                RoleSearchCombo.addItem(role_list.get(i).getName());
              }
            }
          
          
            ScreenComboBox.removeAllItems();
          
            if(screen_list != null && !screen_list.isEmpty())
            {for (int i=0 ; i < screen_list.size() ; i++ ) {
                ScreenComboBox.addItem(screen_list.get(i).getName());
            }}
          
            RoleComboBox.setSelectedIndex(-1);
            RoleSearchCombo.setSelectedIndex(0);
            ScreenComboBox.setSelectedIndex(-1);
          
            groupButton();

          
          
        }catch(Exception e){
            e.printStackTrace();
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
    roleScreenTable = new javax.swing.JTable();
    EditPanel = new javax.swing.JPanel();
    IdScreen = new javax.swing.JLabel();
    PrivilegeLabel = new javax.swing.JLabel();
    IdRole = new javax.swing.JLabel();
    RoleComboBox = new javax.swing.JComboBox<>();
    ScreenComboBox = new javax.swing.JComboBox<>();
    FullAcc = new javax.swing.JRadioButton();
    ViewOnly = new javax.swing.JRadioButton();
    jLabel15 = new javax.swing.JLabel();
    savePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    deletePanel = new javax.swing.JPanel();
    Delete = new javax.swing.JButton();
    clearPanel = new javax.swing.JPanel();
    Clear = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    no_of_rows = new java.awt.Label();
    refreshPanel = new javax.swing.JPanel();
    Refresh = new javax.swing.JButton();
    searchPanel = new javax.swing.JPanel();
    search = new javax.swing.JButton();
    RoleSearchCombo = new javax.swing.JComboBox<>();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        jScrollPane1FocusGained(evt);
      }
    });

    roleScreenTable.setAutoCreateRowSorter(true);
    roleScreenTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    roleScreenTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {

      },
      new String []
      {
        "Id", "Code", "Color", "Description"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean []
      {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex)
      {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return false;
      }
    });
    roleScreenTable.setFillsViewportHeight(true);
    roleScreenTable.setRowHeight(25);
    roleScreenTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    roleScreenTable.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        roleScreenTableFocusGained(evt);
      }
    });
    roleScreenTable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        roleScreenTableMouseClicked(evt);
      }
    });
    roleScreenTable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        roleScreenTableKeyPressed(evt);
      }
    });
    jScrollPane1.setViewportView(roleScreenTable);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 730, 780));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    IdScreen.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdScreen.setForeground(new java.awt.Color(0, 51, 204));
    IdScreen.setText("Screen ");
    EditPanel.add(IdScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 96, 36));

    PrivilegeLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    PrivilegeLabel.setForeground(new java.awt.Color(0, 51, 204));
    PrivilegeLabel.setText("Privilege:");
    EditPanel.add(PrivilegeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

    IdRole.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdRole.setForeground(new java.awt.Color(0, 51, 204));
    IdRole.setText("Role ");
    EditPanel.add(IdRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 180, 90, 36));

    RoleComboBox.setBackground(new java.awt.Color(255, 255, 255));
    RoleComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    RoleComboBox.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        RoleComboBoxFocusGained(evt);
      }
    });
    EditPanel.add(RoleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 210, 530, 50));

    ScreenComboBox.setBackground(new java.awt.Color(255, 255, 255));
    ScreenComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    ScreenComboBox.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        ScreenComboBoxFocusGained(evt);
      }
    });
    ScreenComboBox.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ScreenComboBoxActionPerformed(evt);
      }
    });
    EditPanel.add(ScreenComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 530, 50));

    FullAcc.setBackground(new java.awt.Color(245, 245, 245));
    FullAcc.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    FullAcc.setText("Full Access");
    FullAcc.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        FullAccActionPerformed(evt);
      }
    });
    EditPanel.add(FullAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

    ViewOnly.setBackground(new java.awt.Color(245, 245, 245));
    ViewOnly.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    ViewOnly.setText("View Only");
    EditPanel.add(ViewOnly, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

    jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_user_group_man_woman_128px.png"))); // NOI18N
    EditPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

    savePanel.setBackground(new java.awt.Color(0, 129, 211));

    Save.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
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

    EditPanel.add(savePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 110, 50));

    deletePanel.setBackground(new java.awt.Color(0, 129, 211));

    Delete.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Delete.setForeground(new java.awt.Color(255, 255, 255));
    Delete.setText("Delete ");
    Delete.setBorderPainted(false);
    Delete.setContentAreaFilled(false);
    Delete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        DeleteMouseMoved(evt);
      }
    });
    Delete.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        DeleteMouseExited(evt);
      }
    });
    Delete.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        DeleteActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
    deletePanel.setLayout(deletePanelLayout);
    deletePanelLayout.setHorizontalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
    );
    deletePanelLayout.setVerticalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 110, 50));

    clearPanel.setBackground(new java.awt.Color(0, 129, 211));

    Clear.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Clear.setForeground(new java.awt.Color(255, 255, 255));
    Clear.setText("Clear");
    Clear.setBorderPainted(false);
    Clear.setContentAreaFilled(false);
    Clear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        ClearMouseMoved(evt);
      }
    });
    Clear.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        ClearMouseExited(evt);
      }
    });
    Clear.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ClearActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout clearPanelLayout = new javax.swing.GroupLayout(clearPanel);
    clearPanel.setLayout(clearPanelLayout);
    clearPanelLayout.setHorizontalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    clearPanelLayout.setVerticalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clearPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(clearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 100, 50));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 630, 750));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Role screen");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 240, 80));
    add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 620, 20));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 880, 170, 30));

    refreshPanel.setBackground(new java.awt.Color(0, 129, 211));

    Refresh.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Refresh.setForeground(new java.awt.Color(255, 255, 255));
    Refresh.setText("Refresh ");
    Refresh.setBorderPainted(false);
    Refresh.setContentAreaFilled(false);
    Refresh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        RefreshMouseMoved(evt);
      }
    });
    Refresh.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        RefreshMouseExited(evt);
      }
    });
    Refresh.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        RefreshActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout refreshPanelLayout = new javax.swing.GroupLayout(refreshPanel);
    refreshPanel.setLayout(refreshPanelLayout);
    refreshPanelLayout.setHorizontalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
    );
    refreshPanelLayout.setVerticalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 890, -1, 50));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));

    search.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    search.setForeground(new java.awt.Color(255, 255, 255));
    search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_search_26px.png"))); // NOI18N
    search.setBorderPainted(false);
    search.setContentAreaFilled(false);
    search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        searchMouseMoved(evt);
      }
    });
    search.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        searchMouseExited(evt);
      }
    });
    search.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        searchActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
    searchPanel.setLayout(searchPanelLayout);
    searchPanelLayout.setHorizontalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
    );
    searchPanelLayout.setVerticalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 30, 80, 50));

    RoleSearchCombo.setBackground(new java.awt.Color(255, 255, 255));
    RoleSearchCombo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    RoleSearchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role" }));
    RoleSearchCombo.addItemListener(new java.awt.event.ItemListener()
    {
      public void itemStateChanged(java.awt.event.ItemEvent evt)
      {
        RoleSearchComboItemStateChanged(evt);
      }
    });
    RoleSearchCombo.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        RoleSearchComboFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        RoleSearchComboFocusLost(evt);
      }
    });
    RoleSearchCombo.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        RoleSearchComboMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt)
      {
        RoleSearchComboMouseEntered(evt);
      }
    });
    RoleSearchCombo.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        RoleSearchComboActionPerformed(evt);
      }
    });
    add(RoleSearchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 620, 50));
  }//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    try
      {


        // Check if the Search field is empty
        if(RoleSearchCombo.getSelectedItem().toString().equalsIgnoreCase("Select Role"))
          {
            //Show message tell user that Search Field is empty
            JOptionPane.showMessageDialog(null, "Please, Select Role.",
              "", JOptionPane.ERROR_MESSAGE);
            //throw exception
            throw new IllegalArgumentException("no role selected");
          }


        RoleScreenDto role_screen = new RoleScreenDto(); //create dto object
        List<RoleScreenDto> role_screens = null; //list for searsh result set
        RoleScreenBao bao =
          new BaoFactory().createRoleScreenBao(); //create  bao object

        //get search text
        role_screen.setSearch(RoleSearchCombo.getSelectedItem().toString());

        role_screens =
          bao.searchFor(role_screen); //search for this text using search bao method

        if(role_screens!=null)
          { //if their is result show it in table
            setTableModel(role_screens);
            roleScreenTable.repaint();
          }
        else
          { //if no show message to tell user that
            JOptionPane.showMessageDialog(null,
              "There is no assigned screens for this role.", "Invalid search", 1);
          }

      }
    catch(Exception e)
      {
        e.printStackTrace();
      }

    }//GEN-LAST:event_searchActionPerformed

    private void roleScreenTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roleScreenTableFocusGained

    }//GEN-LAST:event_roleScreenTableFocusGained

    private void roleScreenTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleScreenTableMouseClicked
  
  
    int i = roleScreenTable.getSelectedRow();

    try
      {
        //unable to edit id for selected item

        Save.setText("Update");

        //get values from table to edit space


        //select location type in location type combobox
        String role = roleScreenTable.getValueAt(i, 0).toString();
        for(int j = 0; j<RoleComboBox.getItemCount(); j++)
          {
            if(RoleComboBox.getItemAt(j).equalsIgnoreCase(role))
              RoleComboBox.setSelectedIndex(j);
          }

        //select builing in building combobox
        String screen = roleScreenTable.getValueAt(i, 1).toString();
        for(int j = 0; j<ScreenComboBox.getItemCount(); j++)
          {
            if(ScreenComboBox.getItemAt(j).equalsIgnoreCase(screen))
              ScreenComboBox.setSelectedIndex(j);
          }

        if(roleScreenTable.getValueAt(i,
            2).toString().equalsIgnoreCase("Yes"))
          FullAcc.setSelected(true);
        else
          ViewOnly.setSelected(true);

      }
    catch(java.lang.ArrayIndexOutOfBoundsException e)
      {
        e.printStackTrace();
      }

    }//GEN-LAST:event_roleScreenTableMouseClicked

    private void roleScreenTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roleScreenTableKeyPressed
  
  
    int i = roleScreenTable.getSelectedRow();

    //Because "roleScreenTable.getSelectedRow()" doesn't give the correct selected row
    if(evt.getExtendedKeyCode()==KeyEvent.VK_UP)
      i--; //for up key decrement
    else if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN)
      i++; // for down key increment
    try
      {
        //unable to edit id for selected item
       
        Save.setText("Update");

        //get values from table to edit space

       

        //select location type in location type combobox
        String role = roleScreenTable.getValueAt(i, 0).toString();
        for(int j = 0; j<RoleComboBox.getItemCount(); j++)
          {
            if(RoleComboBox.getItemAt(j).equalsIgnoreCase(role))
              RoleComboBox.setSelectedIndex(j);
          }

        //select builing in building combobox
        String screen = roleScreenTable.getValueAt(i, 1).toString();
        for(int j = 0; j<ScreenComboBox.getItemCount(); j++)
          {
            if(ScreenComboBox.getItemAt(j).equalsIgnoreCase(screen))
              ScreenComboBox.setSelectedIndex(j);
          }

        if(roleScreenTable.getValueAt(i, 2).toString().equalsIgnoreCase("Yes"))
          FullAcc.setSelected(true);
        else 
          ViewOnly.setSelected(true);

      }
    catch(java.lang.ArrayIndexOutOfBoundsException e)
      {
        e.printStackTrace();
      }
    
      if (evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
      {

        //Show confirm message
        int reply =
          JOptionPane.showConfirmDialog(null,
            "Are you sure to delete this privilege?\n", "Warning",
            JOptionPane.YES_NO_OPTION);

        //delete object if user choose yes
        if(reply==JOptionPane.YES_OPTION)
          {

            try
              {
                if(roleScreenTable.getSelectedRowCount()==1)
                  {
                    RoleScreenDto dto = new RoleScreenDto();
                    RoleScreenBao bao =
                      new BaoFactory().createRoleScreenBao();
                    dto.setRole_name(roleScreenTable.getValueAt(roleScreenTable.getSelectedRow(),
                      0).toString());
                    dto.setScreen_name(roleScreenTable.getValueAt(roleScreenTable.getSelectedRow(),
                      1).toString());
                    
                    //go to business layer
                    boolean flag = bao.delete(dto);

                    /*if object has deleted successfully
                * show message to tell user this
                * repait the table
                * */
                    if(flag==true)
                      {
                        JOptionPane.showMessageDialog(null,
                          "Privilege has deleted successfully!", "Done", 1);

                        //refresh table
                        setTableModel(bao.viewAll());
                        roleScreenTable.repaint();
                        Save.setText("Save");

                      }

                    //else show message to ask user select a raw from table
                  }
                else
                  JOptionPane.showMessageDialog(null,
                    "Please select from table!", "Error",
                    JOptionPane.ERROR_MESSAGE);
              }
            catch(Exception e)
              {
                // TODO: Add catch code
                e.printStackTrace();
                //for non expected error
                JOptionPane.showMessageDialog(null,
                  "Some Thing went wrong!\nPlease check your entered data. ",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);

              }
          }
        
        
      }

    }//GEN-LAST:event_roleScreenTableKeyPressed

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained

    }//GEN-LAST:event_jScrollPane1FocusGained

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed

        //set default text for text boxes
        defaultdata();
        RoleScreenBao bao = new BaoFactory().createRoleScreenBao();
        // view all data again
        List<RoleScreenDto> types = bao.viewAll();
        setTableModel(types); 
    }//GEN-LAST:event_RefreshActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        //Show confirm message
        int reply =  JOptionPane.showConfirmDialog(null,
            "Are you sure to delete this privilege?\n" ,
            "Warning",JOptionPane.YES_NO_OPTION);

        //delete object if user choose yes
        if (reply == JOptionPane.YES_OPTION) {

            try
            {
              
                RoleScreenDto dto = new RoleScreenDto();
                RoleScreenBao bao = new BaoFactory().createRoleScreenBao();
              
                dto.setRole_name(RoleComboBox.getSelectedItem().toString());
                dto.setScreen_name(ScreenComboBox.getSelectedItem().toString());
              

                /*if object has deleted successfully
                * show message to tell user this
                * repait the table
                * */
                if (bao.delete(dto))
                {
                  
                  JOptionPane.showMessageDialog(null, "Privilege has deleted successfully!","Done",1);

                    //refresh table
                    setTableModel(bao.viewAll());
                    roleScreenTable.repaint();
                    Save.setText("Save");
                }

                else
                  JOptionPane.showMessageDialog(null, "This Privilege doesn't exist!","Error",0);

            }
            catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
                //for non expected error
                JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",JOptionPane.ERROR_MESSAGE);

            }}
    }//GEN-LAST:event_DeleteActionPerformed

    private void FullAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullAccActionPerformed

    private void RoleComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RoleComboBoxFocusGained
        // TODO add your handling code here:
     
    }//GEN-LAST:event_RoleComboBoxFocusGained

    private void ScreenComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ScreenComboBoxFocusGained
        // TODO add your handling code here:
      
    }//GEN-LAST:event_ScreenComboBoxFocusGained

  private void ScreenComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ScreenComboBoxActionPerformed
  {//GEN-HEADEREND:event_ScreenComboBoxActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ScreenComboBoxActionPerformed

  private void searchMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseExited
  {//GEN-HEADEREND:event_searchMouseExited
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_searchMouseExited

  private void RefreshMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseExited
  {//GEN-HEADEREND:event_RefreshMouseExited
    // TODO add your handling code here:

    refreshPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_RefreshMouseExited

  private void DeleteMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseExited
  {//GEN-HEADEREND:event_DeleteMouseExited
    // TODO add your handling code here:
    deletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_DeleteMouseExited

  private void DeleteMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseMoved
  {//GEN-HEADEREND:event_DeleteMouseMoved
    // TODO add your handling code here:
    deletePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_DeleteMouseMoved

  private void RefreshMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseMoved
  {//GEN-HEADEREND:event_RefreshMouseMoved
    // TODO add your handling code here:
    refreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_RefreshMouseMoved

  private void searchMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseMoved
  {//GEN-HEADEREND:event_searchMouseMoved
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_searchMouseMoved

  private void RoleSearchComboFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_RoleSearchComboFocusGained
  {//GEN-HEADEREND:event_RoleSearchComboFocusGained
    // TODO add your handling code here:
  


  }//GEN-LAST:event_RoleSearchComboFocusGained

  private void SaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SaveActionPerformed
  {//GEN-HEADEREND:event_SaveActionPerformed


    try
    {

      RoleScreenDto dto = new RoleScreenDto(); //create location type dto object
      RoleScreenBao bao = new BaoFactory().createRoleScreenBao(); //create location type bao object

      //set attributes values for Role Screen object
      dto.setRole_name(RoleComboBox.getSelectedItem().toString()); //get role name
      dto.setScreen_name(ScreenComboBox.getSelectedItem().toString());  //get screen name

      System.out.print(dto.getRole_name() + "0  0" +dto.getScreen_name());
      if(!FullAcc.isSelected() && !ViewOnly.isSelected())
            {
              JOptionPane.showMessageDialog(null, "Please choose Privilege!","Invalid Input",1);
              throw new IllegalArgumentException("Privilege isn't selected");
            }
      
      
      if(FullAcc.isSelected())
      {
        dto.setFull_access(true);
      }
      else if (ViewOnly.isSelected())
      {
        dto.setView_only(true);
      }


      if (Save.getText().equalsIgnoreCase("Update"))
      
      {
        
        boolean flag;
        flag = bao.update(dto); //try update it it

        //if location inserted successfully
        if (flag==true)
        {

          //show message tell user that
          JOptionPane.showMessageDialog(null, "Privilege has updated successfully!","Done",1);

          // refresh tabel
          setTableModel(bao.viewAll());
          roleScreenTable.repaint();
          
        } else
        {
          //if not it mean object already exist so show message  to tell user that
          JOptionPane.showMessageDialog(null, "This privilege does'nt exist exist!","Invalid Input",1);

        }
        }
        
      else{
        
      boolean flag;
      flag = bao.add(dto); //try add it

      //if location inserted successfully
      if (flag==true)
      {

        //show message tell user that
        JOptionPane.showMessageDialog(null, "Privilege has inserted successfully!","Done",1);

        // refresh tabel
        setTableModel(bao.viewAll());
        roleScreenTable.repaint();
        Save.setText("Update");
        
      } 
      
      else{
              int reply =
                JOptionPane.showConfirmDialog(null,
                "This Privilege is already exist!\n\n"+
                "Do you want to update it?", "Warning",
                JOptionPane.YES_NO_OPTION);

              //update object if user choose yes
              if(reply==JOptionPane.YES_OPTION)
                {
                   
                    flag = bao.update(dto); //try update it

                   
                    if(flag==true)
                      {

                        //show message tell user that
                        JOptionPane.showMessageDialog(null,
                          "Privilege has updated successfully!", "Done", 1);

                        // refresh tabel
                        setTableModel(bao.viewAll());
                        roleScreenTable.repaint();

                      }
                    else
                      {
                        //if not it mean object already exist so show message  to tell user that
                        JOptionPane.showMessageDialog(null,
                          "This privilege does'nt exist exist!",
                          "Invalid Input", 1);

                      }
                    
                    
                    Save.setText("Update");
                    
                }
            }
    }}

    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
  }//GEN-LAST:event_SaveActionPerformed

  private void SaveMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseExited
  {//GEN-HEADEREND:event_SaveMouseExited
    // TODO add your handling code here:
    savePanel.setBackground(Color.decode("#0081D3"));
  }//GEN-LAST:event_SaveMouseExited

  private void SaveMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseMoved
  {//GEN-HEADEREND:event_SaveMouseMoved
    // TODO add your handling code here:
    savePanel.setBackground(Color.decode("#0051D2"));
  }//GEN-LAST:event_SaveMouseMoved

  private void ClearMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ClearMouseMoved
  {//GEN-HEADEREND:event_ClearMouseMoved
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_ClearMouseMoved

  private void ClearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ClearMouseExited
  {//GEN-HEADEREND:event_ClearMouseExited
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_ClearMouseExited

  private void ClearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ClearActionPerformed
  {//GEN-HEADEREND:event_ClearActionPerformed
    // TODO add your handling code here:
    defaultdata();
  }//GEN-LAST:event_ClearActionPerformed

  private void RoleSearchComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RoleSearchComboActionPerformed
  {//GEN-HEADEREND:event_RoleSearchComboActionPerformed
    // TODO add your handling code here:
    
    
    if(RoleSearchCombo.getSelectedIndex()!=0)
      {
        try
          {

            RoleScreenDto role_screen =
              new RoleScreenDto();        //create dto object
            List<RoleScreenDto> role_screens =
              null;             //list for searsh result set
            RoleScreenBao bao =
              new BaoFactory().createRoleScreenBao(); //create  bao object

            //get search text
            role_screen.setSearch(RoleSearchCombo.getSelectedItem().toString());

            role_screens =
              bao.searchFor(role_screen); //search for this text using search bao method

            if(role_screens!=null)
              { //if their is result show it in table
                setTableModel(role_screens);
                roleScreenTable.repaint();
              }
            else
              { //if no show message to tell user that
                JOptionPane.showMessageDialog(null,
                  "There is no assigned screens for this role.",
                  "Invalid search", 1);
              }

          }
        catch(Exception e)
          {
            e.printStackTrace();
          }
      }

  }//GEN-LAST:event_RoleSearchComboActionPerformed

  private void RoleSearchComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_RoleSearchComboItemStateChanged
  {//GEN-HEADEREND:event_RoleSearchComboItemStateChanged
    // TODO add your handling code here:
 
  }//GEN-LAST:event_RoleSearchComboItemStateChanged

  private void RoleSearchComboFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_RoleSearchComboFocusLost
  {//GEN-HEADEREND:event_RoleSearchComboFocusLost
    // TODO add your handling code here:
    
 

  }//GEN-LAST:event_RoleSearchComboFocusLost

  private void RoleSearchComboMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RoleSearchComboMouseEntered
  {//GEN-HEADEREND:event_RoleSearchComboMouseEntered
    // TODO add your handling code here:
    
  }//GEN-LAST:event_RoleSearchComboMouseEntered

  private void RoleSearchComboMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RoleSearchComboMouseClicked
  {//GEN-HEADEREND:event_RoleSearchComboMouseClicked
    // TODO add your handling code here:
    
  
  }//GEN-LAST:event_RoleSearchComboMouseClicked




  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Clear;
  private javax.swing.JButton Delete;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JRadioButton FullAcc;
  private javax.swing.JLabel IdRole;
  private javax.swing.JLabel IdScreen;
  private javax.swing.JLabel PrivilegeLabel;
  private javax.swing.JButton Refresh;
  private javax.swing.JComboBox<String> RoleComboBox;
  private javax.swing.JComboBox<String> RoleSearchCombo;
  private javax.swing.JButton Save;
  private javax.swing.JComboBox<String> ScreenComboBox;
  private javax.swing.JRadioButton ViewOnly;
  private javax.swing.JPanel clearPanel;
  private javax.swing.JPanel deletePanel;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator2;
  private java.awt.Label no_of_rows;
  private javax.swing.JPanel refreshPanel;
  private javax.swing.JTable roleScreenTable;
  private javax.swing.JPanel savePanel;
  private javax.swing.JButton search;
  private javax.swing.JPanel searchPanel;
  // End of variables declaration//GEN-END:variables

}

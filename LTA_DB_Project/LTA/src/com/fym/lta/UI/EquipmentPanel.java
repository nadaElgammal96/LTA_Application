package com.fym.lta.UI;

import javax.swing.JOptionPane;
import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.EquipmentBao;
import com.fym.lta.BAO.EquipmentTypeBao;
import com.fym.lta.BAO.LocationBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentDao;
import com.fym.lta.DAO.EquipmentTypeDao;
import com.fym.lta.DAO.LocationDao;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;
import com.fym.lta.DTO.LocationDto;

import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import javax.xml.stream.Location;

/**
 *
 * @author Nada El-Gammal
 */

public class EquipmentPanel extends javax.swing.JPanel {
  @SuppressWarnings("oracle.jdeveloper.java.serialversionuid-stale")
  private static final long serialVersionUID = 1L;

  // identify object of EquipmentBao  
    private static  EquipmentBao business;
    private static UserDto user_data;
    
    //method to set the table and allocate its columns and content
    private void setTableModel(List<EquipmentDto> equips){
            int size = 0;
            if(equips != null && !equips.isEmpty())
                size = equips.size();
            
            Object [][] equipsArr = new Object [size][5];
            for(int i =0;i<size;i++){
                equipsArr[i][0] = equips.get(i).getId();
                equipsArr[i][1] = equips.get(i).getCode();
                equipsArr[i][2] = equips.get(i).getType().getName();
                equipsArr[i][3] = equips.get(i).getCountry();
                equipsArr[i][4] = equips.get(i).getLocation().getName();


            }
            EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(equipsArr,
                new String [] {
                    "Id", "Code", "Type" , "Country" , "Location"
                }
            ));

    //change header color
    EquipmentTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
      Integer.toString(EquipmentTable.getRowCount())+"  equipment");
        }


  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Equipment");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }
  
  
    /** Creates new form Equipment_panel */    
    public EquipmentPanel(UserDto user) {
       initComponents();
      
        try {
                   business = new BaoFactory().createEquipmnetBao();
                   user_data=user;
                   viewonly(user_data);

        //set the comboBox items by equipment types names of equipments
        try
          {
            EquipmentTypeBao eq_type_bao =
              new BaoFactory().createEquipmentTypeBao();
            List<EquipmentTypeDto> eq_type_list = eq_type_bao.viewAll();
            eqTypeCombo.removeAllItems();
            if(eq_type_list!=null&&!eq_type_list.isEmpty())
              for(int i = 0; i<eq_type_list.size(); i++)
                {
                  eqTypeCombo.addItem(eq_type_list.get(i).getName());
                }
          }
        catch(Exception e)
          {
            e.printStackTrace();
          }



        //set comboBox items by locations names of equipments
        try
          {
            LocationBao location_bao = new BaoFactory().createLocationBao();
            List<LocationDto> location_list = location_bao.ListAll();
            locationCombo.removeAllItems();
            if(location_list!=null&&!location_list.isEmpty())
              for(int i = 0; i<location_list.size(); i++)
                {
                  locationCombo.addItem(location_list.get(i).getName());
                }
          }
        catch(Exception e)
          {
            e.printStackTrace();
          }
               
                 locationCombo.setSelectedIndex(-1);
                 eqTypeCombo.setSelectedIndex(-1);
          

            
            //call setTableModel method and pass listAll method to it as a parameter
                   setTableModel(business.listAll());            
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
    }
    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  private void initComponents()//GEN-BEGIN:initComponents
  {

    searchTextField = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    EquipmentTable = new javax.swing.JTable();
    EditPanel = new javax.swing.JPanel();
    IdText = new javax.swing.JTextField();
    CodeText = new javax.swing.JTextField();
    eqTypeCombo = new javax.swing.JComboBox<>();
    CountryText = new javax.swing.JTextField();
    locationCombo = new javax.swing.JComboBox<>();
    idLabel = new javax.swing.JLabel();
    codeLabel = new javax.swing.JLabel();
    typeIdLabel = new javax.swing.JLabel();
    countryLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    savePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    deletePanel = new javax.swing.JPanel();
    DeleteButton = new javax.swing.JButton();
    clearPanel = new javax.swing.JPanel();
    clear = new javax.swing.JButton();
    no_of_rows = new java.awt.Label();
    jLabel8 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    refreshPanel = new javax.swing.JPanel();
    refreshButton = new javax.swing.JButton();
    searchPanel = new javax.swing.JPanel();
    searchButton = new javax.swing.JButton();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    searchTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    searchTextField.setText("Enter text to search");
    searchTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    searchTextField.setPreferredSize(new java.awt.Dimension(74, 19));
    searchTextField.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        searchTextFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        searchTextFieldFocusLost(evt);
      }
    });
    searchTextField.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        searchTextFieldActionPerformed(evt);
      }
    });
    add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 30, 610, 50));

    EquipmentTable.setAutoCreateRowSorter(true);
    EquipmentTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String []
      {
        "ID", "Code", "Equipment Type Name", "Country", "Location Name"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean []
      {
        false, false, false, false, false
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
    EquipmentTable.setFillsViewportHeight(true);
    EquipmentTable.setRowHeight(25);
    EquipmentTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    EquipmentTable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        EquipmentTableMouseClicked(evt);
      }
    });
    EquipmentTable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        EquipmentTableKeyPressed(evt);
      }
    });
    jScrollPane1.setViewportView(EquipmentTable);
    if (EquipmentTable.getColumnModel().getColumnCount() > 0)
    {
      EquipmentTable.getColumnModel().getColumn(0).setHeaderValue("ID");
      EquipmentTable.getColumnModel().getColumn(1).setHeaderValue("Code");
      EquipmentTable.getColumnModel().getColumn(2).setHeaderValue("Equipment Type Name");
      EquipmentTable.getColumnModel().getColumn(3).setHeaderValue("Country");
      EquipmentTable.getColumnModel().getColumn(4).setHeaderValue("Location Name");
    }

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 97, 700, 780));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
    EditPanel.add(IdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 550, 50));

    CodeText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    CodeText.setText("Enter Code");
    CodeText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    CodeText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        CodeTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        CodeTextFocusLost(evt);
      }
    });
    CodeText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        CodeTextActionPerformed(evt);
      }
    });
    EditPanel.add(CodeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 270, 550, 50));

    eqTypeCombo.setBackground(new java.awt.Color(255, 255, 255));
    eqTypeCombo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    eqTypeCombo.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        eqTypeComboFocusGained(evt);
      }
    });
    eqTypeCombo.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        eqTypeComboActionPerformed(evt);
      }
    });
    EditPanel.add(eqTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 550, 50));

    CountryText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    CountryText.setText("Enter made country of the equipment");
    CountryText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    CountryText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        CountryTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        CountryTextFocusLost(evt);
      }
    });
    CountryText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        CountryTextActionPerformed(evt);
      }
    });
    EditPanel.add(CountryText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 550, 50));

    locationCombo.setBackground(new java.awt.Color(255, 255, 255));
    locationCombo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    locationCombo.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        locationComboFocusGained(evt);
      }
    });
    EditPanel.add(locationCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 540, 550, 50));

    idLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    idLabel.setForeground(new java.awt.Color(0, 51, 204));
    idLabel.setText("ID");
    EditPanel.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

    codeLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    codeLabel.setForeground(new java.awt.Color(0, 51, 204));
    codeLabel.setText("Code");
    EditPanel.add(codeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 50, 40));

    typeIdLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    typeIdLabel.setForeground(new java.awt.Color(0, 51, 204));
    typeIdLabel.setText(" Type");
    EditPanel.add(typeIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 326, 60, 40));

    countryLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    countryLabel.setForeground(new java.awt.Color(0, 51, 204));
    countryLabel.setText("Country");
    EditPanel.add(countryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 30));

    jLabel1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 51, 204));
    jLabel1.setText("Location Name");
    EditPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, 40));

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_maintenance_128px.png"))); // NOI18N
    EditPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, savePanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(savePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 110, -1));

    deletePanel.setBackground(new java.awt.Color(0, 129, 211));

    DeleteButton.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
    DeleteButton.setText("Delete");
    DeleteButton.setBorderPainted(false);
    DeleteButton.setContentAreaFilled(false);
    DeleteButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        DeleteButtonMouseMoved(evt);
      }
    });
    DeleteButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        DeleteButtonMouseExited(evt);
      }
    });
    DeleteButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        DeleteButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
    deletePanel.setLayout(deletePanelLayout);
    deletePanelLayout.setHorizontalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
    );
    deletePanelLayout.setVerticalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, -1, 50));

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
      .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
    );
    clearPanelLayout.setVerticalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clearPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(clearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 640, 110, 50));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 620, 770));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 870, 190, 30));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Equipment");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 240, 90));
    add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 620, 20));

    refreshPanel.setBackground(new java.awt.Color(0, 129, 211));

    refreshButton.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
    refreshButton.setForeground(new java.awt.Color(255, 255, 255));
    refreshButton.setText("Refresh");
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
      .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
    );
    refreshPanelLayout.setVerticalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 890, -1, 50));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));
    searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
    searchPanel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 50));

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 80, 50));
  }//GEN-END:initComponents
   
   //create object of EquipmentDto
    EquipmentDto eq = new EquipmentDto();

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
    try
      {
        // check that user has entered text in textfield
        String search = searchTextField.getText();
        if(!(search.equals("Enter text to search")))
          {
            EquipmentBao equip = new BaoFactory().createEquipmnetBao();
            List<EquipmentDto> search_list = null;

            //pass the text of searchtextfield to the dto object
            eq.setSearch(searchTextField.getText());

            //call serchFor method from bao and pass dto object as parameter
            search_list = equip.searchFor(eq);
            if(search_list!=null)
              {
                // reset and repaint the table with the returned search list
                setTableModel(search_list);
                EquipmentTable.repaint();
              }
            else
              { // show message when no equipment found then reset and repaint table to default
                JOptionPane.showMessageDialog(this, "Equipmnet Not Found");

              }
          }
        else
          {
            JOptionPane.showMessageDialog(this,
              "Please Enter Text To Search For");
          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
      // implementation of delete button 
        try{
            
            // get the select row count from table
             int row = EquipmentTable.getSelectedRow();
            // get data from the selected row and store it to the dto object fields 
             eq.setId(Integer.parseInt(EquipmentTable.getModel().getValueAt(row,0).toString()));
             eq.setCode(EquipmentTable.getModel().getValueAt(row,1).toString());
            
            // call delete method from bao and pass the dto object to it as parameter to delete it
             if(business.delete(eq)){
                 //show message when process terminated successfully
                        JOptionPane.showMessageDialog(this, "Equipment Deleted Successfully");
                 
    // call countEquips method to count the latest number of Equipments of specific type after delete process       
                 business.countEquips(new EquipmentTypeDto(EquipmentTable.getModel().getValueAt(row,2).toString()));
                        
    //set the table with the newest list in database and repaint it using listAll method in bao
                        setTableModel(business.listAll());            
                        EquipmentTable.repaint();
            Save.setText("Save");
            IdText.setEnabled(true);
             }else{
            JOptionPane.showMessageDialog(this,
              "can't delete this equipment","Error",0);
          }
            }
        catch(java.lang.ArrayIndexOutOfBoundsException e){
            
            // show message if no row is selected from table 
            JOptionPane.showMessageDialog(this, "Please select row from table to delete");
            }
        catch(Exception e){
                e.printStackTrace();
            }
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextActionPerformed

    private void CodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeTextActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        //implementation of refresh button
        try{
            // reset and repaint the table then set text of textfields to its default when panel is opened
                EquipmentDao e = new DaoFactory().createEquipmentDao();
                setTableModel(e.viewAll());            
                EquipmentTable.repaint();
        IdText.setEnabled(true);
        Save.setText("Save");
        IdText.setText("Enter ID");
        CodeText.setText("Enter Code");
        CountryText.setText("Enter made country of the equipment");
        eqTypeCombo.setSelectedIndex(-1);
        locationCombo.setSelectedIndex(-1);
          
          
            }
        
        catch(Exception e)
        { e.printStackTrace();}
        
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
    if(Save.getText().equalsIgnoreCase("Update"))
      update();

    else{
            try{ 
            //check validity of data enterd by user 
            if(checkValidity()){
                
                //pass data from textfields and comboBoxes to dto object properties 
        eq.setId(Integer.parseInt(IdText.getText()));
        eq.setCode(CodeText.getText());
        eq.setCountry(CountryText.getText());
        eq.setType(new EquipmentTypeDto(eqTypeCombo.getSelectedItem().toString()));    
        eq.setLocation(new LocationDto(locationCombo.getSelectedItem().toString()));
        
        //call insert method from bao and pass the dto object as parameter
        if(business.insert(eq ,user_data)){
            
            //show message when method terminated successfully
                        JOptionPane.showMessageDialog(this, "Equipment Inserted Successfully");
                        business.countEquips(new EquipmentTypeDto(eqTypeCombo.getSelectedItem().toString()));
                        
            // reset and repaint the table after adding equipment
                        setTableModel(business.listAll());            
                        EquipmentTable.repaint();
                        
                        
                        IdText.setEnabled(false);
                        Save.setText("Update");
        }
        
        else{
            int reply =
              JOptionPane.showConfirmDialog(null,
                "This equipment is already exist!\n\n"+
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

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained
       
       // delete text from textfield when textfield is selected 
        if (IdText.getText().equalsIgnoreCase("Enter ID"))
            IdText.setText("");


    IdText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_IdTextFocusGained

    private void CodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusLost
    
    // reset text of textfield to its default when its focus is lost
    if (CodeText.getText().trim().equalsIgnoreCase(""))
        CodeText.setText("Enter Code");

    CodeText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_CodeTextFocusLost

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost
    
    //reset text of textfield to its default when its focus is lost
    if (IdText.getText().trim().equalsIgnoreCase(""))
        IdText.setText("Enter ID");

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_IdTextFocusLost

    private void CodeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusGained
    
    // delete text from textfield when textfield is selected 
        if (CodeText.getText().equalsIgnoreCase("Enter Code"))
            CodeText.setText("");

    CodeText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_CodeTextFocusGained

    private void CountryTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CountryTextFocusGained
    
    // delete text from textfield when textfield is selected 
        if( CountryText.getText().equalsIgnoreCase("Enter made country of the equipment") ) 
            CountryText.setText("");

    CountryText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_CountryTextFocusGained

    private void CountryTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CountryTextFocusLost
 
    //reset text of textfield to its default when its focus is lost
    if( CountryText.getText().trim().equalsIgnoreCase(""))
        CountryText.setText("Enter made country of the equipment");

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    
    }//GEN-LAST:event_CountryTextFocusLost

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
    
    // delete text from textfield when textfield is selected 
    if(searchTextField.getText().equalsIgnoreCase("Enter text to search")){
        searchTextField.setText("");
    }

    searchTextField.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
   
    //reset text of textfield to its default when its focus is lost
    if(searchTextField.getText().trim().equalsIgnoreCase("")){
        searchTextField.setText("Enter text to search");
    }

    searchTextField.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       
       //implementation of search button
        try{
            // check that user has entered text in textfield
            String search = searchTextField.getText();
            if(!(search.equals("Enter text to search"))){
            EquipmentBao equip = new BaoFactory().createEquipmnetBao();
                List<EquipmentDto> search_list = null;
                
                //pass the text of searchtextfield to the dto object
            eq.setSearch(searchTextField.getText());
            
            //call serchFor method from bao and pass dto object as parameter
                search_list = equip.searchFor(eq);
            if( search_list !=null )
            {
                // reset and repaint the table with the returned search list
                setTableModel(search_list);  
                EquipmentTable.repaint();
            }
            else 
            {   // show message when no equipment found then reset and repaint table to default
                JOptionPane.showMessageDialog(this, "Equipmnet Not Found");
                
            }
            }
            else{
                JOptionPane.showMessageDialog(this, "Please Enter Text To Search For");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void CountryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CountryTextActionPerformed

    private void EquipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentTableMouseClicked
        
    // set text of textfields by the data of the mouse clicked row in table 
        int row = EquipmentTable.getSelectedRow();
        IdText.setEnabled(false);
        Save.setText("Update");

       IdText.setText(EquipmentTable.getValueAt(row, 0).toString());
        CodeText.setText(EquipmentTable.getValueAt(row, 1).toString());
        CountryText.setText(EquipmentTable.getValueAt(row, 3).toString());
        
        
        //select type
        for(int i=0; i<eqTypeCombo.getItemCount() ; i++)
        {
          if (eqTypeCombo.getItemAt(i).equalsIgnoreCase(EquipmentTable.getValueAt(row,
              2).toString()))  
            eqTypeCombo.setSelectedIndex(i);
        }


    //select location 
    for(int i = 0; i<locationCombo.getItemCount(); i++)
      {
        if(locationCombo.getItemAt(i).equalsIgnoreCase(EquipmentTable.getValueAt(row,
              4).toString()))
          locationCombo.setSelectedIndex(i);
      }
    }//GEN-LAST:event_EquipmentTableMouseClicked

    private void EquipmentTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EquipmentTableKeyPressed
       
    // set text of textfields by the data of the keypressed row in table 
        if( evt.getExtendedKeyCode()==KeyEvent.VK_UP || evt.getExtendedKeyCode()==KeyEvent.VK_DOWN ){
            int row = EquipmentTable.getSelectedRow();
            if(evt.getExtendedKeyCode() == KeyEvent.VK_UP)
                row--;      //for up key decrement
            else if(evt.getExtendedKeyCode() == KeyEvent.VK_DOWN)
                row++;      // down key increment
        IdText.setEnabled(false);
        Save.setText("Update");

        IdText.setText(EquipmentTable.getValueAt(row, 0).toString());
            CodeText.setText(EquipmentTable.getValueAt(row, 1).toString());
            CountryText.setText(EquipmentTable.getValueAt(row, 3).toString());

        //select type
        for(int i = 0; i<eqTypeCombo.getItemCount(); i++)
          {
            if(eqTypeCombo.getItemAt(i).equalsIgnoreCase(EquipmentTable.getValueAt(row,
                  2).toString()))
              eqTypeCombo.setSelectedIndex(i);
          }


        //select location
        for(int i = 0; i<locationCombo.getItemCount(); i++)
          {
            if(locationCombo.getItemAt(i).equalsIgnoreCase(EquipmentTable.getValueAt(row,
                  4).toString()))
              locationCombo.setSelectedIndex(i);
          }
        
        
        }
    }//GEN-LAST:event_EquipmentTableKeyPressed

    private void eqTypeComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eqTypeComboFocusGained

    }//GEN-LAST:event_eqTypeComboFocusGained

    private void eqTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eqTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eqTypeComboActionPerformed

    private void locationComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationComboFocusGained

    }//GEN-LAST:event_locationComboFocusGained

  private void clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearActionPerformed
  {//GEN-HEADEREND:event_clearActionPerformed
    // TODO add your handling code here:

    IdText.setEnabled(true);
    Save.setText("Save");
    IdText.setText("Enter ID");
    CodeText.setText("Enter Code");
    CountryText.setText("Enter made country of the equipment");
    eqTypeCombo.setSelectedIndex(-1);
    locationCombo.setSelectedIndex(-1);
    
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

  private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteButtonMouseExited
  {//GEN-HEADEREND:event_DeleteButtonMouseExited
    // TODO add your handling code here:

    deletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_DeleteButtonMouseExited

  private void clearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseExited
  {//GEN-HEADEREND:event_clearMouseExited
    // TODO add your handling code here:

    clearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_clearMouseExited

  private void clearMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseMoved
  {//GEN-HEADEREND:event_clearMouseMoved
    // TODO add your handling code here:

    clearPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_clearMouseMoved

  private void DeleteButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteButtonMouseMoved
  {//GEN-HEADEREND:event_DeleteButtonMouseMoved
    // TODO add your handling code here:

    deletePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_DeleteButtonMouseMoved

  private void SaveMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseMoved
  {//GEN-HEADEREND:event_SaveMouseMoved
    // TODO add your handling code here:
    savePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_SaveMouseMoved

  private void refreshButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_refreshButtonMouseMoved
  {//GEN-HEADEREND:event_refreshButtonMouseMoved
    // TODO add your handling code here:
    refreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_refreshButtonMouseMoved

  private void searchButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchButtonMouseMoved
  {//GEN-HEADEREND:event_searchButtonMouseMoved
    // TODO add your handling code here:
    
    searchPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_searchButtonMouseMoved

// check input validity for each textfield  
    private boolean checkValidity(){
            try{
                if(IdText.getText().equalsIgnoreCase("Enter ID")){
                    JOptionPane.showMessageDialog(this, "Please, enter id number","",JOptionPane.ERROR_MESSAGE);
                    return false;            
                }
                Integer.parseInt(IdText.getText());
               // return true;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "ID is invalid! \n (please enter a number)");
                         // own implemented dialog
                return false;
            }
            
            try{
                if(CodeText.getText().equalsIgnoreCase("Enter Code")){
                    JOptionPane.showMessageDialog(this, "Please, enter code");
                    return false;
                }
                    Integer.parseInt(CodeText.getText().substring(0,1));
                    JOptionPane.showMessageDialog(this, "Code is invalid! \n It should begin with character");
                    return false;
                }catch (NumberFormatException e){
                             // own implemented dialog
                    
            try{
                if(CountryText.getText().equalsIgnoreCase("Enter made country of the equipment")){
                    JOptionPane.showMessageDialog(this, "Please, enter string");
                    return false;
                }
                    Integer.parseInt(CountryText.getText());
                    JOptionPane.showMessageDialog(this, "String is invalid! \n (please enter a string)");
                    return false;
                }catch (NumberFormatException es){
                 
             if(eqTypeCombo.getSelectedIndex()==-1)
             {
                JOptionPane.showMessageDialog(this,
                  "please, select equipment type.","Error",0);
                return false;
              }

             
            return true;
            }}
        }
    
    
    /**UPDATE UN EXISTING EQUIPMENT*/
    private void  update()
    
    { 
      try
    {
    // check the data validity enterd by user
        if(checkValidity()){
            
    // store data entered by user in dto object attributes
        eq.setId(Integer.parseInt(IdText.getText()));
        eq.setCode(CodeText.getText());
        eq.setType(new EquipmentTypeDto(eqTypeCombo.getSelectedItem().toString()));
        eq.setCountry(CountryText.getText());
        eq.setLocation(new LocationDto(locationCombo.getSelectedItem().toString()));
        
    /* call update method from bao then show message if the process terminated successfully
    and repaint the table with the lateset updates */
        if(business.update(eq ,user_data)){
                   JOptionPane.showMessageDialog(this, "Equipment Updated Successfully");

            business.countEquips(new EquipmentTypeDto(eqTypeCombo.getSelectedItem().toString()));
                   setTableModel(business.listAll());            
                   EquipmentTable.repaint();
        }else
          JOptionPane.showMessageDialog(this,
            "Equipment does'nt exist","Error",0);
      }
    
    
    }
    catch(Exception e){
        e.printStackTrace();
    }}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField CodeText;
  private javax.swing.JTextField CountryText;
  private javax.swing.JButton DeleteButton;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JTable EquipmentTable;
  private javax.swing.JTextField IdText;
  private javax.swing.JButton Save;
  private javax.swing.JButton clear;
  private javax.swing.JPanel clearPanel;
  private javax.swing.JLabel codeLabel;
  private javax.swing.JLabel countryLabel;
  private javax.swing.JPanel deletePanel;
  private javax.swing.JComboBox<String> eqTypeCombo;
  private javax.swing.JLabel idLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JComboBox<String> locationCombo;
  private java.awt.Label no_of_rows;
  private javax.swing.JButton refreshButton;
  private javax.swing.JPanel refreshPanel;
  private javax.swing.JPanel savePanel;
  private javax.swing.JButton searchButton;
  private javax.swing.JPanel searchPanel;
  private javax.swing.JTextField searchTextField;
  private javax.swing.JLabel typeIdLabel;
  // End of variables declaration//GEN-END:variables

}

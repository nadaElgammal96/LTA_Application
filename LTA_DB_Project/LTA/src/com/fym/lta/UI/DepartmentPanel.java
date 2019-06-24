
package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.BuildingBao;
import com.fym.lta.BAO.DepartmentBao;


import com.fym.lta.BAO.LocationBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.DepartmentDto;

import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mai-AbdEltwab
 */


public class DepartmentPanel extends javax.swing.JPanel {
    @SuppressWarnings({ "compatibility:-5743342370269248875",
      "oracle.jdeveloper.java.serialversionuid-stale" })
    private static final long serialVersionUID = 1L;


    /** Creates new form DepartmentPanel */

        private static UserDto user_data; 

    public DepartmentPanel(UserDto user) {
        
        try {

            DepartmentBao bao;
            bao= new  BaoFactory().createDepartmentBao();
            user_data=user;
            initComponents();
  
           // get department data using view all method in bao
            
            List<DepartmentDto> departs= new ArrayList<DepartmentDto>();
            if(!bao.viewAll().isEmpty() && bao.viewAll()!=null)
                departs = bao.viewAll();
            
            // paint department table for the result data
                setTableModel(departs);
       
            viewonly(user_data);
       
        }
           catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
                               }
       
    }


    /** set department table model*/

        private void setTableModel(List<DepartmentDto> departs){
            
           Object [][] departArr = new Object [departs.size()][4];
            
            for(int i =0;i<departs.size();i++){
                
                departArr[i][0] = departs.get(i).getId();
                departArr[i][1] = departs.get(i).getCode();
                departArr[i][2] = departs.get(i).getName();
                
                    //for buildings
                    String s = "";  //buffer string
                  
                    //view buildings in table
                    if(departs.get(i).getBuildings()!=null && !departs.get(i).getBuildings().isEmpty())
                    { for (int j = 0; j < departs.get(i).getBuildings().size(); j++) {

                        if (j == departs.get(i).getBuildings().size() - 1)
                            s += departs.get(i).getBuildings().get(j).getCode();
                        else
                            s += departs.get(i).getBuildings().get(j).getCode() + ", ";
                    }}
                
                    departArr[i][3] = s;
                    
                }

                
            departTable.setModel(new javax.swing.table.DefaultTableModel(departArr,
                new String [] {
                    "Id", "Code","Name","Building"
                }
            ));

    //change header color
    departTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
            Integer.toString(departTable.getRowCount())+"  departments");
            
            
        }


  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Department");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }

  /**check Validity of entered data
   * @return: True if data is entered correctly (as expected)
   * False when one or more of them entered uncorrectly
   * */
  
 private boolean checkValidity()
 {


   try{
     
     //check for empty entered data
    if(IdText.getText().contentEquals("Enter department ID")) //for id 
      {
        JOptionPane.showMessageDialog(null, "Please, enter department id",
          "Invalid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("id text is empry");
      }
    else if(CodeText.getText().equalsIgnoreCase("Enter department code")) //for code 

      {
        JOptionPane.showMessageDialog(null, "Please, enter department code",
          "Invalid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("code text is empty");
      }
    else if(NameText.getText().contentEquals("Enter department name ")) //for name 
      {
        JOptionPane.showMessageDialog(null, "Please, enter department name",
          "Invalid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("name text is empty");
      }
    
     else if(buildingBox.getItemCount()==0 || buildingBox.getSelectedIndex()==-1) //for building 
          {
            JOptionPane.showMessageDialog(null,
              "Please, select at least one building\n\n", "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("thetre is no selected building.");
          }
     
    //Check for the entered id is a positive number
    int id = Integer.parseInt(IdText.getText());
    if(id<1)
      {
        JOptionPane.showMessageDialog(null, "ID is only Positive Numbers",
          "Invalid Input", 1);
        throw new IllegalArgumentException("ID is only Positive Numbers");
      }


        //check validity of code

        //code can't start with number or symbol
        if(!Character.isAlphabetic(CodeText.getText().charAt(0)))
          {
            JOptionPane.showMessageDialog(null,
              "Invalid code format\n\n(code can't start with number or symbol)",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("code can't start with number or symbol");

          }
        //check for all chars
        for(int i = 1; i<CodeText.getText().length(); i++)
          {

            //code contain only letters/numbers ane '_'
            if(!Character.isLetterOrDigit(CodeText.getText().charAt(i))&&
              CodeText.getText().charAt(i)!='_')
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid code format\n\n(code can only be a sequence of Unicode letters and digits separated by underscore)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("code can't contain stranger symbols");

              }
          }


        //check validity of name

        //name can't start with number or symbol
        if(!Character.isAlphabetic(NameText.getText().charAt(0)))
          {
            JOptionPane.showMessageDialog(null,
              "Invalid Name format\n\n(Name can't start with number or symbol)",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Name can't start with number or symbol");

          }

        //check for all chars
        for(int i = 1; i<NameText.getText().length(); i++)
          {

            //code contain only letters/numbers ane '_'
            if(!Character.isLetterOrDigit(NameText.getText().charAt(i))&&
              NameText.getText().charAt(i)!='_'  && NameText.getText().charAt(i)!=' ')
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid Name format\n\n(Name can only be a sequence of Unicode letters and digits separated by underscore)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Name can't contain stranger symbols");

              }
          }
     
     
     
      return true; //data is valid
   
   }

  catch (java.lang.NumberFormatException e2) {
      e2.printStackTrace();
      JOptionPane.showMessageDialog(null, "Please enter number for ID",
                                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
      return false;
  }
  
  catch (IllegalArgumentException e1) {

      e1.printStackTrace();
      return false;
  }
  
   catch (Exception e) {
      // TODO: Add catch code
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",JOptionPane.ERROR_MESSAGE);
     return false;
  }
   
   
}




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  private void initComponents()//GEN-BEGIN:initComponents
  {

    c = new javax.swing.JComboBox<>();
    jComboBox1 = new javax.swing.JComboBox<>();
    buildingtext = new javax.swing.JTextField();
    SearchText = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    departTable = new javax.swing.JTable();
    no_of_rows = new java.awt.Label();
    EditPanel = new javax.swing.JPanel();
    NameLabel1 = new javax.swing.JLabel();
    IdLabel1 = new javax.swing.JLabel();
    CodeLabel1 = new javax.swing.JLabel();
    IdLabel5 = new javax.swing.JLabel();
    IdText = new javax.swing.JTextField();
    CodeText = new javax.swing.JTextField();
    NameText = new javax.swing.JTextField();
    buildingBox = new javax.swing.JComboBox<>();
    jLabel6 = new javax.swing.JLabel();
    SavePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    DeletePanel = new java.awt.Panel();
    Delete = new javax.swing.JButton();
    ClearPanel = new javax.swing.JPanel();
    clear = new javax.swing.JButton();
    ChangePanel = new javax.swing.JPanel();
    Change = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    searchPanel = new javax.swing.JPanel();
    search = new javax.swing.JButton();
    RefreshPanel = new javax.swing.JPanel();
    Refresh = new javax.swing.JButton();

    c.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    buildingtext.setText("department located building/s");
    buildingtext.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        buildingtextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        buildingtextFocusLost(evt);
      }
    });
    buildingtext.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        buildingtextActionPerformed(evt);
      }
    });

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    SearchText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    SearchText.setText("Enter what do you want to search for");
    SearchText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    SearchText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        SearchTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        SearchTextFocusLost(evt);
      }
    });
    SearchText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        SearchTextActionPerformed(evt);
      }
    });
    SearchText.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        SearchTextKeyPressed(evt);
      }
    });
    add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 640, 50));

    departTable.setAutoCreateRowSorter(true);
    departTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    departTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String []
      {
        "Id", "Code", "Name", "Building"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        return canEdit [columnIndex];
      }
    });
    departTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    departTable.setFillsViewportHeight(true);
    departTable.setRowHeight(21);
    departTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    departTable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        departTableMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt)
      {
        departTableMouseEntered(evt);
      }
    });
    departTable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        departTableKeyPressed(evt);
      }
    });
    jScrollPane1.setViewportView(departTable);
    if (departTable.getColumnModel().getColumnCount() > 0)
    {
      departTable.getColumnModel().getColumn(0).setHeaderValue("Id");
      departTable.getColumnModel().getColumn(1).setHeaderValue("Code");
      departTable.getColumnModel().getColumn(2).setHeaderValue("Name");
      departTable.getColumnModel().getColumn(3).setHeaderValue("Building");
      departTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
    }

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 730, 750));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 860, 200, 20));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    NameLabel1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    NameLabel1.setForeground(new java.awt.Color(0, 51, 204));
    NameLabel1.setText("Name");
    EditPanel.add(NameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 80, 40));

    IdLabel1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdLabel1.setForeground(new java.awt.Color(0, 51, 204));
    IdLabel1.setText("Id");
    EditPanel.add(IdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 35, 40));

    CodeLabel1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    CodeLabel1.setForeground(new java.awt.Color(0, 51, 204));
    CodeLabel1.setText("Code");
    EditPanel.add(CodeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 40));

    IdLabel5.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdLabel5.setForeground(new java.awt.Color(0, 51, 204));
    IdLabel5.setText("Building");
    EditPanel.add(IdLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 76, 50));

    IdText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    IdText.setText("Enter department ID");
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
    EditPanel.add(IdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 580, 60));

    CodeText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    CodeText.setText("Enter department code");
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
    EditPanel.add(CodeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 580, 60));

    NameText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    NameText.setText("Enter department name ");
    NameText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    NameText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        NameTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        NameTextFocusLost(evt);
      }
    });
    NameText.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        NameTextActionPerformed(evt);
      }
    });
    EditPanel.add(NameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 580, 60));

    buildingBox.setBackground(new java.awt.Color(255, 255, 255));
    buildingBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EditPanel.add(buildingBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 450, 60));

    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_org_unit_128px.png"))); // NOI18N
    EditPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

    SavePanel.setBackground(new java.awt.Color(0, 129, 211));

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

    javax.swing.GroupLayout SavePanelLayout = new javax.swing.GroupLayout(SavePanel);
    SavePanel.setLayout(SavePanelLayout);
    SavePanelLayout.setHorizontalGroup(
      SavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    SavePanelLayout.setVerticalGroup(
      SavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SavePanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(SavePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 100, 50));

    DeletePanel.setBackground(new java.awt.Color(0, 129, 211));

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

    javax.swing.GroupLayout DeletePanelLayout = new javax.swing.GroupLayout(DeletePanel);
    DeletePanel.setLayout(DeletePanelLayout);
    DeletePanelLayout.setHorizontalGroup(
      DeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    DeletePanelLayout.setVerticalGroup(
      DeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeletePanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(DeletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 100, 50));

    ClearPanel.setBackground(new java.awt.Color(0, 129, 211));

    clear.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
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

    javax.swing.GroupLayout ClearPanelLayout = new javax.swing.GroupLayout(ClearPanel);
    ClearPanel.setLayout(ClearPanelLayout);
    ClearPanelLayout.setHorizontalGroup(
      ClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    ClearPanelLayout.setVerticalGroup(
      ClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClearPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    EditPanel.add(ClearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 100, 50));

    ChangePanel.setBackground(new java.awt.Color(0, 129, 211));

    Change.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Change.setForeground(new java.awt.Color(255, 255, 255));
    Change.setText("Change");
    Change.setBorderPainted(false);
    Change.setContentAreaFilled(false);
    Change.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        ChangeMouseMoved(evt);
      }
    });
    Change.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        ChangeMouseExited(evt);
      }
    });
    Change.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ChangeActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout ChangePanelLayout = new javax.swing.GroupLayout(ChangePanel);
    ChangePanel.setLayout(ChangePanelLayout);
    ChangePanelLayout.setHorizontalGroup(
      ChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Change, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    ChangePanelLayout.setVerticalGroup(
      ChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Change, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(ChangePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 100, 50));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 650, 750));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Department ");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 240, 70));
    add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 610, 20));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));

    search.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
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
      .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
    );
    searchPanelLayout.setVerticalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(searchPanelLayout.createSequentialGroup()
        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 80, 50));

    RefreshPanel.setBackground(new java.awt.Color(0, 129, 211));

    Refresh.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Refresh.setForeground(new java.awt.Color(255, 255, 255));
    Refresh.setText("Refresh");
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

    javax.swing.GroupLayout RefreshPanelLayout = new javax.swing.GroupLayout(RefreshPanel);
    RefreshPanel.setLayout(RefreshPanelLayout);
    RefreshPanelLayout.setHorizontalGroup(
      RefreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
    );
    RefreshPanelLayout.setVerticalGroup(
      RefreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RefreshPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(RefreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 870, 120, 50));
  }//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
 
    if(Save.getText().equalsIgnoreCase("Update"))
      update();
    
    else {
      if(checkValidity()){  // if data is valid do this
      try
      {
          
          DepartmentDto dto = new DepartmentDto();
          BuildingDto Bdto = new BuildingDto();
          DepartmentBao bao = new BaoFactory().createDepartmentBao();
          
        
          // check and pick up which buildings have be selected
          List<BuildingDto> builds =new ArrayList<BuildingDto>();

          for (int i=0 ; i<buildingBox.getItemCount() ; i++)
          {
              Bdto = new BuildingDto();
              Bdto.setCode(buildingBox.getItemAt(i));
              builds.add(Bdto);
              Bdto = null;
          }

            //set attributes values for department object
            dto.setId(Integer.parseInt(IdText.getText()));
            dto.setCode(CodeText.getText());
            dto.setName(NameText.getText());
            dto.setBuildings(builds);
          
          //go to business layer
          boolean flag = bao.create(dto,user_data);
          
          if (flag==true)
          { JOptionPane.showMessageDialog(null, "Department has inserted successfully!","Done",1);
              
          setTableModel(bao.viewAll());
             departTable.repaint();
             Save.setText("Update");
             IdText.setEnabled(false);


                  }
          
          
                else
                  {

                    int reply =
                      JOptionPane.showConfirmDialog(null,
                        "This Department is already exist!\n\n"+
                        "Do you want update it?", "Warning",
                        JOptionPane.YES_NO_OPTION);

                    //update object if user choose yes
                    if(reply==JOptionPane.YES_OPTION)
                      {
                        update();
                        Save.setText("Update");
                        IdText.setEnabled(false);
                      }
                  }
               
      }


      
         catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",JOptionPane.ERROR_MESSAGE);

        }}}
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       
       
        //Show confirm message
       int reply =  JOptionPane.showConfirmDialog(null,
                                      "Are you sure to delete this department?\n" +
                                      "All things depend on it will be deleted!",
                                      "Warning",JOptionPane.YES_NO_OPTION );
       
       //delete object if user choose yes
        if (reply == JOptionPane.YES_OPTION) {

        try
        {
             DepartmentDto dto = new DepartmentDto();   
             DepartmentBao bao = new BaoFactory().createDepartmentBao();
            
            //get building id fron text box and set it to the dto object
            dto.setId(Integer.parseInt(IdText.getText()));
            
            //go to business layer
            boolean flag = bao.delete(dto);
            
            
            /*if object has deleted successfully
             * show message to tell user this
             * repait the table
             * make id text box enabled
             * */
            if (flag==true)
            {
                JOptionPane.showMessageDialog(null, "Department has deleted successfully!","Done",JOptionPane.INFORMATION_MESSAGE);
                setTableModel(bao.viewAll());
                departTable.repaint();
                IdText.setEnabled(true);
                Save.setText("Save");

              } 
            //else show message to tell user that this object does't exist in database
            else
                JOptionPane.showMessageDialog(null,
                                              "Department doesn't exist!",
                                              "Not Found", JOptionPane.ERROR_MESSAGE);
                    
        }
        catch (Exception e) {
              // TODO: Add catch code
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",JOptionPane.ERROR_MESSAGE);

          }}
    }//GEN-LAST:event_DeleteActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed

        //enable id text box again
        IdText.setEnabled(true);
        Save.setText("Save");

        //set default text for text boxes
        IdText.setText("Enter department ID");
        CodeText.setText("Enter department code");
        NameText.setText("Enter department name ");

        //clear selection Buildings in building combobox
        buildingBox.removeAllItems();
        
        DepartmentBao bao = new BaoFactory().createDepartmentBao();
        // view all data again in table
        List<DepartmentDto> departs = bao.viewAll();
        setTableModel(departs);
    }//GEN-LAST:event_RefreshActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
        try{
            
        DepartmentDto dto = new DepartmentDto();   
        DepartmentBao bao = new BaoFactory().createDepartmentBao();
        dto=new DepartmentDto();
            
        // Check if the Search field is empty
        if (SearchText.getText().equalsIgnoreCase("Enter what do you want to search for"))
        {  
            //Show message tell user that Search Field is empty
            JOptionPane.showMessageDialog(null,
                                              "Search field is empty",
                                              "Invalid Input!", JOptionPane.ERROR_MESSAGE);
            //throw exception
            throw new IllegalArgumentException("Search field is empty");}
        
        //take search text int dto object
        dto.setSearch(SearchText.getText());
            
        //Pick up result set from database through search bao method
        List<DepartmentDto> result = bao.searchFor(dto);   
            
        //if search results are found, Show result set in table 
        if(result != null && !result.isEmpty())
            setTableModel(result);
            
        //if there is no result show message tell user that their is no search for this text
        else
            JOptionPane.showMessageDialog(null, "There is no search result for: "+SearchText.getText(),"Invalid search",1);

        } catch (IllegalArgumentException e1) {

            e1.printStackTrace();
        }
        catch(Exception e){
            // TODO: Add catch code
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       
        //enable id text box again
        IdText.setEnabled(true);
        Save.setText("Save");
        //set default text for text boxes
        IdText.setText("Enter department ID");
        CodeText.setText("Enter department code");
        NameText.setText("Enter department name ");
        
        //clear selection Buildings in building combobox
            buildingBox.removeAllItems();
   
        
    }//GEN-LAST:event_clearActionPerformed

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void departTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departTableMouseClicked
        
        //unable id text box,as user cant't update it(PK)
        IdText.setEnabled(false);
        Save.setText("Update");


        //get number of selected row in table
        int i = departTable.getSelectedRow();

        //get buildings from table
        String builds = departTable.getValueAt(i, 3).toString();
        String[] buildsCombo = null;

        if (builds.contains(",")) {

            //split builds text to get each building code
            buildsCombo = builds.split(", ");

            //remove all existing items in buildings combobox
            buildingBox.removeAllItems();

            if (buildsCombo != null && buildsCombo.length != 0) //for non empty buildings

            //add existing buildings into building combobox
            {
                for (int j = 0; j < buildsCombo.length; j++) {
                    buildingBox.addItem(buildsCombo[j]);
                }
            }
        }

        // for one value
        else {
            buildingBox.removeAllItems();
            buildingBox.addItem(builds);
        }

        //set the others attributes of selected row to text boxes
        IdText.setText(departTable.getValueAt(i, 0).toString());
        CodeText.setText(departTable.getValueAt(i, 1).toString());
        NameText.setText(departTable.getValueAt(i, 2).toString());
        
 
    }//GEN-LAST:event_departTableMouseClicked

    private void departTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_departTableKeyPressed
        
        
        //get number of selected row in table
        int i = departTable.getSelectedRow();
        
        //Because "departTable.getSelectedRow()" doesn't give the correct selected row
        if(evt.getExtendedKeyCode() == KeyEvent.VK_UP)
            i--;      //for up key decrement
        else if(evt.getExtendedKeyCode() == KeyEvent.VK_DOWN)
            i++;      // for down key increment
        
        try{
        //unable id text box,as user cant't update it(PK)
        IdText.setEnabled(false);
        Save.setText("Update");


        if (evt.getExtendedKeyCode() == KeyEvent.VK_UP ||
            evt.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            
            //get buildings from table
            String builds = departTable.getValueAt(i,3).toString();
            String[] buildsCombo = null;
            
            if(builds.contains(",")) {
                
                //split builds text to get each building code 
                buildsCombo = builds.split(", ");
            
            //remove all existing items in buildings combobox
            buildingBox.removeAllItems();
            
           if(buildsCombo != null && buildsCombo.length!=0) //for non empty buildings 
            //add existing buildings into building combobox
            {  for (int j = 0; j < buildsCombo.length ; j++) {
                buildingBox.addItem(buildsCombo[j]);
            }} }
            
           // for one value 
            else {
                        buildingBox.removeAllItems();
                        buildingBox.addItem(builds);
                    }

            //set the others attributes of selected row to text boxes
            IdText.setText(departTable.getValueAt(i, 0).toString());
            CodeText.setText(departTable.getValueAt(i, 1).toString());
            NameText.setText(departTable.getValueAt(i, 2).toString());
            

           
            }}
        
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
          e.printStackTrace();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }

    //delete selected object when press delete
    if(evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
      {
        try
          {
            //For one selected row in table
            if(departTable.getSelectedRowCount()==1)
              { //Show confirm message
                int reply =
                  JOptionPane.showConfirmDialog(null,
                    "Are you sure to delete this department?\n"+
                    "All things depend on it will be deleted!", "Warning",
                    JOptionPane.YES_NO_OPTION);

                //delete object if user choose yes
                if(reply==JOptionPane.YES_OPTION)
                  {
                    DepartmentDto department =
                      new DepartmentDto(); //create dto Department object
                    DepartmentBao bao =
                      new BaoFactory().createDepartmentBao(); //create object Department bao

                    //get selected Department id from table
                    int s =
                      Integer.parseInt(departTable.getValueAt(departTable.getSelectedRow(),
                          0).toString());
                    department.setId(s); //set it to Department object

                    //delete it using bao delete method
                    if(bao.delete(department)) //if it deleted sucessfilly show message to tell user that
                      {
                        JOptionPane.showMessageDialog(this,
                          "Department Deleted Successfully");
                        setTableModel(bao.viewAll());
                        departTable.repaint();
                        Save.setText("Save");
                        IdText.setEnabled(true);

                      }

                    else
                      //if bao method return false (location not be deleted)
                      JOptionPane.showMessageDialog(this,
                        "Can't delete object", "Error",
                        JOptionPane.ERROR_MESSAGE);
                  }

              }
            else if(departTable.getSelectedRowCount()==0)
              {
                // if there is no selected row show message to ask user to select a row
                JOptionPane.showMessageDialog(this,
                  "There is no selected row in the table\n\n", "Error",
                  JOptionPane.WARNING_MESSAGE);
              }
            else
              {
                // if there are more than one row selected show message to ask user to select one row
                JOptionPane.showMessageDialog(this,
                  "Please, Select only one row\n\n", "Error",
                  JOptionPane.WARNING_MESSAGE);
              }
          }
        catch(Exception e)
          {
            e.printStackTrace();
          }
      }
        
    }//GEN-LAST:event_departTableKeyPressed

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained
        if (IdText.getText().equalsIgnoreCase("Enter department ID"))
            IdText.setText("");
        
    IdText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_IdTextFocusGained

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost
        if (IdText.getText().trim().equalsIgnoreCase(""))
            IdText.setText("Enter department ID");

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_IdTextFocusLost

    private void CodeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusGained
        if (CodeText.getText().equalsIgnoreCase("Enter department code"))
            CodeText.setText("");

    CodeText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_CodeTextFocusGained

    private void CodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusLost
        if (CodeText.getText().trim().equalsIgnoreCase(""))
            CodeText.setText("Enter department code");

    CodeText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_CodeTextFocusLost

    private void NameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusGained
        if (NameText.getText().equalsIgnoreCase("Enter department name "))
            NameText.setText("");

    NameText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_NameTextFocusGained

    private void NameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusLost
        if (NameText.getText().trim().equalsIgnoreCase(""))
            NameText.setText("Enter department name ");

    NameText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_NameTextFocusLost

    private void SearchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusGained
        if (SearchText.getText().equalsIgnoreCase("Enter what do you want to search for"))
            SearchText.setText("");

    SearchText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_SearchTextFocusGained

    private void SearchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusLost
        if (SearchText.getText().equalsIgnoreCase(""))
            SearchText.setText("Enter what do you want to search for");

    SearchText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_SearchTextFocusLost

    private void SearchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextKeyPressed
    
    if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {

        try{
            
        DepartmentDto dto = new DepartmentDto();   
        DepartmentBao bao = new BaoFactory().createDepartmentBao();
        dto=new DepartmentDto();
        
        //get the input search text into search attribute in departemt dto object
        dto.setSearch(SearchText.getText());
        
        // get the result set from bao
        List<DepartmentDto> result = bao.searchFor(dto);
            
        //if there is a result set show them in the department table
        if(result != null && !result.isEmpty())
            setTableModel(result);
        else
            //if there is no result set show message to tell user that
            JOptionPane.showMessageDialog(null, "There is no search result for: "+SearchText.getText(),"Invalid search",1);

        }

        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();

        }}
    }//GEN-LAST:event_SearchTextKeyPressed

    private void ChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeActionPerformed
       
        // Create new frame and panel
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.getContentPane().setLayout(null);


        //Declare new buttom named "add" and set its bounds
        JButton add = new JButton("add");
        add.setBounds(100, 270, 72, 35);
        
        //Declare new buttom named "add" and set its bounds
        JButton save = new JButton("save");
        save.setBounds(200, 270, 72 , 35);

        //Declare new buttom named "remove" and set its bounds
        JButton remove = new JButton("remove");
        remove.setBounds(300, 270, 72, 35);
        
        // declare two lists and their models 
        DefaultListModel<Object> model_list1 = new DefaultListModel<Object>();
        DefaultListModel<Object> model_list2 = new DefaultListModel<Object>();
        JList<Object> list1 = new JList<Object>();
        JList<Object> list2 = new JList<Object>();

        // set models to lists 
        list1.setModel(model_list1);
        list2.setModel(model_list2);
    
       // set lists bounds
        list1.setBounds(17, 41, 174, 194);
        list2.setBounds(262, 41, 174, 194);

      // create scrollpane for list1 set its location,bounds,layout and add it to the frame 
        JScrollPane listScroller = new JScrollPane();
        listScroller.setLocation(45, 43);
        listScroller.setSize(174, 194);
        listScroller.setViewportView(list1);
        list1.setLayoutOrientation(JList.VERTICAL);
        frame.getContentPane().add(listScroller);
        
        // create scrollpane for list2 set its location,bounds,layout and add it to the frame
        JScrollPane listScroller1 = new JScrollPane();
        listScroller1.setLocation(262, 43);
        listScroller1.setSize(174, 194);
        listScroller1.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        frame.getContentPane().add(listScroller1);
        
        //set labels for two lists,set bounds,size,add to frame
        JLabel labelList1 = new JLabel();
        JLabel labelList2 = new JLabel();
        labelList1.setText("Available buildings:");
        labelList2.setText("Selected buildings:");
        labelList1.setSize(150,19);
        labelList2.setSize(150,19);
        labelList1.setLocation(48, 20);
        labelList2.setLocation(265, 20);
        frame.getContentPane().add(labelList1);
        frame.getContentPane().add(labelList2);
        
        //get all existing buildings from data base 
        BuildingBao bBao = new BaoFactory().createBuildingBao();
        List<BuildingDto> builds = new ArrayList<BuildingDto>();
        builds = bBao.ListAll();
        
        // set all existing buildings' code to the first list 
        for (int i = 0; i < builds.size(); i++) {
            model_list1.addElement(builds.get(i).getCode());
        }


        /*get existing buildings' code from combobox (if exist)
         * add them to second list
         * remove them from first list
         * */
        for (int i = 0; i < buildingBox.getItemCount(); i++) {
            
            model_list2.addElement(buildingBox.getItemAt(i));
            model_list1.removeElement(buildingBox.getItemAt(i));
            
        }
        
        
        
        // move all selected element to the secode list and remove it from first list
        // when user click on add button
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list1.getSelectedValuesList().stream().forEach((data) -> {
                    model_list2.addElement(data);
                    model_list1.removeElement(data);
                });
            }
        });


        // remove all selected element from the secode list and add it to first list
        // when user click on remove button
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list2.getSelectedValuesList().stream().forEach((data) -> {
                    model_list1.addElement(data);
                    model_list2.removeElement(data);
                });
            }
        });
        
        
        // Action when user click on save button 
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //clear building combobox
                buildingBox.removeAllItems();
                
                //Save selected building into building combobox
                for (int i = 0; i < model_list2.size(); i++) {
                                    buildingBox.addItem(model_list2.get(i).toString());
                                }
                             
                
                //close frame 
                frame.dispose();
            }
        });

       
        //add the panel into the frame and set the frame size/title

        frame.getContentPane().add(add);
        frame.getContentPane().add(save);
        frame.getContentPane().add(remove);
        frame.setLocationRelativeTo(null); //to make frame in screen center
        frame.setTitle("Choose department's Building");
        frame.setSize(490, 400);
        frame.setResizable(false);


        //veiw the frame when user click on the change button
        frame.setVisible(true);
    }//GEN-LAST:event_ChangeActionPerformed

    private void buildingtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buildingtextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_buildingtextFocusGained

    private void buildingtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buildingtextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_buildingtextFocusLost

    private void buildingtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildingtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildingtextActionPerformed

  private void SearchTextActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SearchTextActionPerformed
  {//GEN-HEADEREND:event_SearchTextActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_SearchTextActionPerformed

  private void departTableMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_departTableMouseEntered
  {//GEN-HEADEREND:event_departTableMouseEntered
    // TODO add your handling code here:

  }//GEN-LAST:event_departTableMouseEntered

  private void searchMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseMoved
  {//GEN-HEADEREND:event_searchMouseMoved
    // TODO add your handling code here:

    searchPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_searchMouseMoved

  private void SaveMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseMoved
  {//GEN-HEADEREND:event_SaveMouseMoved
    // TODO add your handling code here:

    SavePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_SaveMouseMoved

  private void DeleteMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseMoved
  {//GEN-HEADEREND:event_DeleteMouseMoved
    // TODO add your handling code here:

    DeletePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_DeleteMouseMoved

  private void clearMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseMoved
  {//GEN-HEADEREND:event_clearMouseMoved
    // TODO add your handling code here:
    ClearPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_clearMouseMoved

  private void ChangeMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ChangeMouseMoved
  {//GEN-HEADEREND:event_ChangeMouseMoved
    // TODO add your handling code here:

    ChangePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_ChangeMouseMoved

  private void RefreshMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseMoved
  {//GEN-HEADEREND:event_RefreshMouseMoved
    // TODO add your handling code here:
    RefreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_RefreshMouseMoved

  private void clearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseExited
  {//GEN-HEADEREND:event_clearMouseExited
    // TODO add your handling code here:
    ClearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_clearMouseExited

  private void DeleteMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseExited
  {//GEN-HEADEREND:event_DeleteMouseExited
    // TODO add your handling code here:
    DeletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_DeleteMouseExited

  private void SaveMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseExited
  {//GEN-HEADEREND:event_SaveMouseExited
    // TODO add your handling code here:
    SavePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_SaveMouseExited

  private void ChangeMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ChangeMouseExited
  {//GEN-HEADEREND:event_ChangeMouseExited
    // TODO add your handling code here:
    ChangePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_ChangeMouseExited

  private void RefreshMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseExited
  {//GEN-HEADEREND:event_RefreshMouseExited
    // TODO add your handling code here:
    RefreshPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_RefreshMouseExited

  private void searchMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseExited
  {//GEN-HEADEREND:event_searchMouseExited
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_searchMouseExited


/**This method for update an existing department*/
private void update(){
      if(checkValidity()){
        try
        {
            
            DepartmentDto dto = new DepartmentDto();   
            DepartmentBao bao = new BaoFactory().createDepartmentBao();
            BuildingDto Bdto = new BuildingDto();

          
            // check and pick up which buildings have be selected
            List<BuildingDto> builds = new ArrayList<BuildingDto>();

            for (int i = 0; i < buildingBox.getItemCount(); i++) {
              
                Bdto = new BuildingDto();
                Bdto.setCode(buildingBox.getItemAt(i));
                builds.add(Bdto);
                Bdto = null;
            }
            
            //set department dto object attributes 
            dto.setId(Integer.parseInt(IdText.getText()));
            dto.setCode(CodeText.getText());
            dto.setName(NameText.getText());
            dto.setBuildings(builds);
            
            
            //go to business layer
            boolean flag = bao.update(dto,user_data);

            /*if object has updated successfully
             * show message to tell user this
             * repait the table
             * */
            if (flag==true)
            {
                JOptionPane.showMessageDialog(null, "Department has updated successfully!","Done",1);
                setTableModel(bao.viewAll());
                departTable.repaint();
            }
            
            //else show message to tell user that this object does't exist in database
            else
                JOptionPane.showMessageDialog(null,
                                              "Department doesn't exist!",
                                              "Not Found",
                                              JOptionPane.ERROR_MESSAGE);
        }
             
           catch (Exception e) {
              // TODO: Add catch code
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Some Thing went wrong!/nPlease check your entered data. ","Invalid Input",
                                          JOptionPane.ERROR_MESSAGE);

          }}
}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Change;
  private javax.swing.JPanel ChangePanel;
  private javax.swing.JPanel ClearPanel;
  private javax.swing.JLabel CodeLabel1;
  private javax.swing.JTextField CodeText;
  private javax.swing.JButton Delete;
  private java.awt.Panel DeletePanel;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JLabel IdLabel1;
  private javax.swing.JLabel IdLabel5;
  private javax.swing.JTextField IdText;
  private javax.swing.JLabel NameLabel1;
  private javax.swing.JTextField NameText;
  private javax.swing.JButton Refresh;
  private javax.swing.JPanel RefreshPanel;
  private javax.swing.JButton Save;
  private javax.swing.JPanel SavePanel;
  private javax.swing.JTextField SearchText;
  private javax.swing.JComboBox<String> buildingBox;
  private javax.swing.JTextField buildingtext;
  private javax.swing.JComboBox<String> c;
  private javax.swing.JButton clear;
  private javax.swing.JTable departTable;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private java.awt.Label no_of_rows;
  private javax.swing.JButton search;
  private javax.swing.JPanel searchPanel;
  // End of variables declaration//GEN-END:variables

}

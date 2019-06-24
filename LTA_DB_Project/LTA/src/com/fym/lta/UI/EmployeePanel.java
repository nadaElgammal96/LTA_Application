
package com.fym.lta.UI;
import com.fym.lta.BAO.BaoFactory;

import com.fym.lta.BAO.EmployeeBao;
import com.fym.lta.BAO.StaffBao;
import com.fym.lta.DAO.EmployeeDao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.EmployeeDto;

import com.fym.lta.DTO.StaffDto;
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
 * @author Mustafa Zalat
 */
public class EmployeePanel extends javax.swing.JPanel {
  @SuppressWarnings("compatibility:1071024738053911202")
  private static final long serialVersionUID = -513603827684253176L;

  private static  UserDto user_data;
  private static EmployeeBao business;

    /** Creates new form EmployeeJPanel */

    
    private void setTableModel(List<EmployeeDto> employees){
        int size=0;
        if(employees != null && !employees.isEmpty()){
            size = employees.size();
            }
        Object [][] empArr = new Object [size][3];
        for(int i =0;i<size;i++){
            empArr[i][0] = employees.get(i).getId();
            empArr[i][1] = employees.get(i).getName();
           empArr[i][2] = employees.get(i).getJob();
        }
        employeestable.setModel(new javax.swing.table.DefaultTableModel(empArr,
            new String [] {
                "ID", "Name", "Job"
            }
        ));


    //change header color
    employeestable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
      Integer.toString(employeestable.getRowCount())+"  employees");
    }
    
    private void setNewTable(UserDto user){
            //int size = 0;
            //if(user != null /* && !user.isEmpty()*/ )
              //  size = user.size();
            
            Object [][] userArr = new Object [1][4];
            //for(int i =0;i<size;i++){
            userArr[0][0] = user.getId();
            userArr[0][1] = user.getUsername();
            userArr[0][2] = user.getEmail();
            userArr[0][3] = user.getRole().getId();
            //}
           employeestable.setModel(new javax.swing.table.DefaultTableModel(userArr,
                new String [] {
                   "ID","User Name" ,"Email", "Role ID" 
                }
            ));

    //change header color
    employeestable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
           
           }


  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Employee");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }


  public EmployeePanel(UserDto user) {
        try{
        initComponents();
        business = new BaoFactory().createEmployeeBao();
          user_data=user;
          viewonly(user_data);
        setTableModel(business.listAll());  
        }catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }

    }
    
    static EmployeeDto  emp = new EmployeeDto();

  
  
  
  /**Update an existing employee*/
    private void update()
  {
    if(checkValidity())
      {
        try
          {

            {
              EmployeeDao bdao = new DaoFactory().createEmployeeDao();
              emp.setId(Integer.parseInt(IdText.getText()));
              emp.setName(NameText.getText());
              emp.setJob(JobText.getText());
              if(business.update(emp, user_data))
                {
                  JOptionPane.showMessageDialog(this,
                    "Employee updated Successfully");
                  setTableModel(bdao.viewAll());
                  employeestable.repaint();
                }
              else
                {
                  JOptionPane.showMessageDialog(this,
                    "The Employee is not exist");

                }
            }

          }
        catch(Exception e)
          {
            e.printStackTrace();
          }
      }}
  
  
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  private void initComponents()//GEN-BEGIN:initComponents
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    employeestable = new javax.swing.JTable();
    SearchText = new javax.swing.JTextField();
    EditPanel = new javax.swing.JPanel();
    IdLabel = new javax.swing.JLabel();
    IdText = new javax.swing.JTextField();
    NameText = new javax.swing.JTextField();
    CodeLabel = new javax.swing.JLabel();
    NameLabel = new javax.swing.JLabel();
    JobText = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    SavePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    deletePanel = new javax.swing.JPanel();
    Delete = new javax.swing.JButton();
    clearPanel = new javax.swing.JPanel();
    clear = new javax.swing.JButton();
    no_of_rows = new java.awt.Label();
    jLabel8 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    viewUserButton = new javax.swing.JButton();
    searchPanel = new javax.swing.JPanel();
    search = new javax.swing.JButton();
    refreshPanel = new javax.swing.JPanel();
    Refresh = new javax.swing.JButton();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    employeestable.setAutoCreateRowSorter(true);
    employeestable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    employeestable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {

      },
      new String []
      {
        "ID", "Name", "Job"
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
    employeestable.setFillsViewportHeight(true);
    employeestable.setRowHeight(25);
    employeestable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    employeestable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        employeestableMouseClicked(evt);
      }
    });
    employeestable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        employeestableKeyPressed(evt);
      }
    });
    jScrollPane1.setViewportView(employeestable);
    if (employeestable.getColumnModel().getColumnCount() > 0)
    {
      employeestable.getColumnModel().getColumn(0).setHeaderValue("ID");
      employeestable.getColumnModel().getColumn(1).setHeaderValue("Name");
      employeestable.getColumnModel().getColumn(2).setHeaderValue("Job");
    }

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 720, 780));

    SearchText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    SearchText.setText("Enter text to search");
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
    add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 620, 50));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    IdLabel.setBackground(new java.awt.Color(0, 51, 204));
    IdLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    IdLabel.setForeground(new java.awt.Color(0, 51, 204));
    IdLabel.setText("ID");
    EditPanel.add(IdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 186, -1, 30));

    IdText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    IdText.setText("Enter Employee ID");
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
    EditPanel.add(IdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 210, 600, 60));

    NameText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    NameText.setText("Enter Employee Name");
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
    EditPanel.add(NameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 600, 60));

    CodeLabel.setBackground(new java.awt.Color(0, 51, 204));
    CodeLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    CodeLabel.setForeground(new java.awt.Color(0, 51, 204));
    CodeLabel.setText("Name");
    EditPanel.add(CodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 40));

    NameLabel.setBackground(new java.awt.Color(0, 51, 204));
    NameLabel.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    NameLabel.setForeground(new java.awt.Color(0, 51, 204));
    NameLabel.setText("Job");
    EditPanel.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 40));

    JobText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    JobText.setText("Enter Employee Job");
    JobText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    JobText.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        JobTextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        JobTextFocusLost(evt);
      }
    });
    EditPanel.add(JobText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 600, 60));

    jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_user_group_man_woman_128px.png"))); // NOI18N
    EditPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

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
      .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
    );
    SavePanelLayout.setVerticalGroup(
      SavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(SavePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, 50));

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
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
    );
    deletePanelLayout.setVerticalGroup(
      deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, 50));

    clearPanel.setBackground(new java.awt.Color(0, 129, 211));

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

    javax.swing.GroupLayout clearPanelLayout = new javax.swing.GroupLayout(clearPanel);
    clearPanel.setLayout(clearPanelLayout);
    clearPanelLayout.setHorizontalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
    );
    clearPanelLayout.setVerticalGroup(
      clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(clearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, -1, 50));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 660, 770));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 880, 180, 30));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Employee");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 240, 80));
    add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 620, 20));

    viewUserButton.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    viewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_user_male_circle_60px.png"))); // NOI18N
    viewUserButton.setToolTipText("Employee's account");
    viewUserButton.setBorderPainted(false);
    viewUserButton.setContentAreaFilled(false);
    viewUserButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        viewUserButtonMouseMoved(evt);
      }
    });
    viewUserButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        viewUserButtonMouseExited(evt);
      }
    });
    viewUserButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        viewUserButtonActionPerformed(evt);
      }
    });
    add(viewUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 890, 80, 50));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));

    search.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
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
      .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
    );
    searchPanelLayout.setVerticalGroup(
      searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 50));

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
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
    );
    refreshPanelLayout.setVerticalGroup(
      refreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshPanelLayout.createSequentialGroup()
        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 890, 130, 50));
  }//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    try
      {
        //Show confirm message
        int reply =
          JOptionPane.showConfirmDialog(null,
            "Are you sure to delete this employee?\n"+
            "All things depend on it will be deleted!", "Warning",
            JOptionPane.YES_NO_OPTION);

        //delete object if user choose yes
        if(reply==JOptionPane.YES_OPTION)
          {
            
            EmployeeDto emp = new EmployeeDto();
            
            emp.setId(Integer.parseInt(IdText.getText()));
            if(business.delete(emp))
              {
                JOptionPane.showMessageDialog(this,
                  "Employee Deleted Successfully.", "Done", 1);
                setTableModel(business.listAll());
                employeestable.repaint();
                IdText.setEnabled(true);
                Save.setText("Save");

              }

          }
        else
          {
            JOptionPane.showMessageDialog(this, "Employee does'nt exist! ",
              "Error", 0);
          }


      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    }//GEN-LAST:event_DeleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        try{
            List<EmployeeDto> emps = null;
            EmployeeDao empdao = new DaoFactory().createEmployeeDao();
            emp.setSearch(SearchText.getText());
            emps = business.searchFor(emp);

            if(emps!=null){
              
                setTableModel(emps);
                employeestable.repaint();
            }else{
                JOptionPane.showMessageDialog(this, "Employee is not Exist");
                setTableModel(empdao.viewAll());
                employeestable.repaint();
            }
            SearchText.setText("Enter text to search");
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        if(Save.getText().equalsIgnoreCase("Update"))
          update();

        else{
          
        try{
          
            if(checkValidity()){
            EmployeeDao empdao = new DaoFactory().createEmployeeDao();
            emp.setId(Integer.parseInt(IdText.getText()));
            emp.setName((NameText.getText()));
            emp.setJob(JobText.getText());
            
            if(business.add(emp,user_data)){
                JOptionPane.showMessageDialog(this, "Employee Inserted Successfully","Done",1);
                setTableModel(empdao.viewAll());
                employeestable.repaint();
                IdText.setEnabled(false);
                Save.setText("Update");
            }
            else{
              int reply =
                JOptionPane.showConfirmDialog(null,
                  "This Employee is already exist!\n\n"+
                  "Do you want update it?", "Warning",
                  JOptionPane.YES_NO_OPTION);

              //update object if user choose yes
              if(reply==JOptionPane.YES_OPTION)
                {
                  update();
                  Save.setText("Update");
                  IdText.setEnabled(false);                 
                }}
              
        }}
        catch(Exception e){
            e.printStackTrace();
        }}
    
    }//GEN-LAST:event_SaveActionPerformed
    
    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
        // TODO add your handling code here:                                                                    
    }//GEN-LAST:event_IdTextActionPerformed

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
         try{
            EmployeeDao employee;
            employee = new DaoFactory().createEmployeeDao();
            setTableModel(employee.viewAll());
            employeestable.repaint();
        IdText.setEnabled(true);
        Save.setText("Save");

        IdText.setText("Enter Employee ID");
        NameText.setText("Enter Employee Name");
        JobText.setText("Enter Employee Job");
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
    try
      {
        List<EmployeeDto> emps = null;
        EmployeeDao empdao = new DaoFactory().createEmployeeDao();
        emp.setSearch(SearchText.getText());
        emps = business.searchFor(emp);

        if(emps!=null)
          {
           
            setTableModel(emps);
            employeestable.repaint();
          }
        else
          {
            JOptionPane.showMessageDialog(this, "Employee is not Exist");
            setTableModel(empdao.viewAll());
            employeestable.repaint();
          }
        SearchText.setText("Enter text to search");
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }                                                          
    }//GEN-LAST:event_SearchTextActionPerformed

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained
    if(IdText.getText().equalsIgnoreCase("Enter Employee ID")){
        IdText.setText("");}

    IdText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_IdTextFocusGained

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost
    if(IdText.getText().trim().equalsIgnoreCase("")){
        IdText.setText("Enter Employee ID");
    }

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_IdTextFocusLost

    private void NameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusGained
    if(NameText.getText().equalsIgnoreCase("Enter Employee Name")){
        NameText.setText("");}

    NameText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_NameTextFocusGained

    private void NameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusLost
    if(NameText.getText().trim().equalsIgnoreCase("")){
        NameText.setText("Enter Employee Name");}

    NameText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_NameTextFocusLost

    private void JobTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JobTextFocusGained
    if(JobText.getText().equalsIgnoreCase("Enter Employee Job")){
        JobText.setText("");}

    JobText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_JobTextFocusGained

    private void JobTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JobTextFocusLost
    if(JobText.getText().trim().equalsIgnoreCase("")){
        JobText.setText("Enter Employee Job");}

    JobText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_JobTextFocusLost

    private void SearchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusGained
    if(SearchText.getText().equalsIgnoreCase("Enter text to search")){
        SearchText.setText("");}

    SearchText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_SearchTextFocusGained

    private void SearchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusLost
    if(SearchText.getText().trim().equalsIgnoreCase("")){
        SearchText.setText("Enter text to search");}

    SearchText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_SearchTextFocusLost

    private void viewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserButtonActionPerformed

        try{
            //identify object of user dto
            UserDto u = null;
            int row = employeestable.getSelectedRow();
            // get data of equipment type from the selected row and pass it to the dto object
            emp.setId(Integer.parseInt(employeestable.getModel().getValueAt(row,0).toString()));

            // call loadAllEquips method from bao
            u=business.viewUser(emp);
            if( u!=null){

                // reset and repaint the table with equipments details (if found)
                setNewTable(u);
                employeestable.repaint();
                //tableLabel.setText("User of Selected Employee");
            }
        }

        catch(java.lang.ArrayIndexOutOfBoundsException e){

            //show message if now type is selected
            JOptionPane.showMessageDialog(this, "Please select staff from table to show his/her user");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewUserButtonActionPerformed

    private void employeestableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeestableMouseClicked

    IdText.setEnabled(false);
    Save.setText("Update");

    int row = employeestable.getSelectedRow();
    IdText.setText(employeestable.getValueAt(row, 0).toString());
    NameText.setText(employeestable.getValueAt(row, 1).toString());
    JobText.setText(employeestable.getValueAt(row, 2).toString());

    }//GEN-LAST:event_employeestableMouseClicked

    private void employeestableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeestableKeyPressed
    if( evt.getExtendedKeyCode()==KeyEvent.VK_UP || evt.getExtendedKeyCode()==KeyEvent.VK_DOWN ){
        int row = employeestable.getSelectedRow();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_UP)
            row--;      //for up key decrement
        else if(evt.getExtendedKeyCode() == KeyEvent.VK_DOWN)
            row++;      // down key increment

        IdText.setEnabled(false);
        Save.setText("Update");
        IdText.setText(employeestable.getValueAt(row, 0).toString());
        NameText.setText(employeestable.getValueAt(row, 1).toString());
        JobText.setText(employeestable.getValueAt(row, 2).toString());
    }

    //delete selected object when press delete
    if(evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
      {

        try
          {

            //For one selected row in table

            if(employeestable.getSelectedRowCount()==1)
              { //Show confirm message
                int reply =
                  JOptionPane.showConfirmDialog(null,
                    "Are you sure to delete this employee?\n"+
                    "All things depend on it will be deleted!", "Warning",
                    JOptionPane.YES_NO_OPTION);

                //delete object if user choose yes
                if(reply==JOptionPane.YES_OPTION)
                  {

                    //get selected staff id from table
                    int s =
                      Integer.parseInt(employeestable.getValueAt(employeestable.getSelectedRow(),
                          0).toString());
                    EmployeeDto employee = new EmployeeDto();
                    employee.setId(s); //set it to employee object

                    //delete it using bao delete method
                    if(business.delete(employee)) //if it deleted sucessfilly show message to tell user that
                      {
                        JOptionPane.showMessageDialog(this,
                          "Staff Deleted Successfully", "Done", 1);
                        setTableModel(business.listAll());
                        employeestable.repaint();
                        Save.setText("Save");
                        IdText.setEnabled(true);
                      }

                    else
                      //if bao method return false (employee not be deleted)
                      JOptionPane.showMessageDialog(this,
                        "Can't delete object", "Error",
                        JOptionPane.ERROR_MESSAGE);
                  }

              }
            else if(employeestable.getSelectedRowCount()==0)
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
    }//GEN-LAST:event_employeestableKeyPressed

  private void clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearActionPerformed
  {//GEN-HEADEREND:event_clearActionPerformed
    // TODO add your handling code here:
    
    IdText.setEnabled(true);
    Save.setText("Save");
    IdText.setText("Enter Employee ID");
    NameText.setText("Enter Employee Name");
    JobText.setText("Enter Employee Job");
    
  }//GEN-LAST:event_clearActionPerformed

  private void viewUserButtonMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_viewUserButtonMouseExited
  {//GEN-HEADEREND:event_viewUserButtonMouseExited
    // TODO add your handling code here:

    viewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_user_male_circle_60px.png"))); // NOI18N

  }//GEN-LAST:event_viewUserButtonMouseExited

  private void viewUserButtonMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_viewUserButtonMouseMoved
  {//GEN-HEADEREND:event_viewUserButtonMouseMoved
    // TODO add your handling code here:
    viewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_user_male_circle_60px_1.png"))); // NOI18N

  }//GEN-LAST:event_viewUserButtonMouseMoved

  private void RefreshMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseExited
  {//GEN-HEADEREND:event_RefreshMouseExited
    // TODO add your handling code here:
    refreshPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_RefreshMouseExited

  private void clearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseExited
  {//GEN-HEADEREND:event_clearMouseExited
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_clearMouseExited

  private void DeleteMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseExited
  {//GEN-HEADEREND:event_DeleteMouseExited
    // TODO add your handling code here:
    deletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_DeleteMouseExited

  private void SaveMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseExited
  {//GEN-HEADEREND:event_SaveMouseExited
    // TODO add your handling code here:
    SavePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_SaveMouseExited

  private void searchMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseExited
  {//GEN-HEADEREND:event_searchMouseExited
    // TODO add your handling code here:
    searchPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_searchMouseExited

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
    deletePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_DeleteMouseMoved

  private void clearMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseMoved
  {//GEN-HEADEREND:event_clearMouseMoved
    // TODO add your handling code here:
    clearPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_clearMouseMoved

  private void RefreshMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseMoved
  {//GEN-HEADEREND:event_RefreshMouseMoved
    // TODO add your handling code here:
    refreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_RefreshMouseMoved

    private boolean checkValidity(){
      
      try{   
        
    //check for empty entered data
    if(IdText.getText().equalsIgnoreCase("Enter Employee ID"))
      {
        JOptionPane.showMessageDialog(null, "Please, enter employee id",
          "Invaid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("id text is empry");
      }
    
    else if(JobText.getText().equalsIgnoreCase("Enter Employee Job"))

      {
        JOptionPane.showMessageDialog(null, "Please, Enter Employee Job",
          "Invaid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("job text is empty");
      }
    else if(NameText.getText().equalsIgnoreCase("Enter Employee Name"))
      {
        JOptionPane.showMessageDialog(null, "Please, Enter Employee Name",
          "Invaid Input", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("name text is empty");

      }


        //Check validity of id
        try
          {
            int id = Integer.parseInt(IdText.getText());
            //Check for the entered id is a positive number
            if(id<1)
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid Id \n\n(ID is only Positive Numbers)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("ID is only Positive Numbers");
              }
          }
        catch(java.lang.NumberFormatException e2)
          {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null,
              "Please enter number for location ID", "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
            return false;
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
              NameText.getText().charAt(i)!='_'&&
              NameText.getText().charAt(i)!=' ')
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid Name format\n\n(Name can only be a sequence of Unicode letters and digits separated by underscore)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Name can't contain stranger symbols");

              }
          }


        //check validity of job

        //name can't start with number or symbol
        if(!Character.isAlphabetic(JobText.getText().charAt(0)))
          {
            JOptionPane.showMessageDialog(null,
              "Invalid Job name format\n\n(Job name can't start with number or symbol)",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Job name can't start with number or symbol");

          }

        //check for all chars
        for(int i = 1; i<JobText.getText().length(); i++)
          {

            //code contain only letters/numbers ane '_'
            if(!Character.isLetterOrDigit(JobText.getText().charAt(i))&&
              JobText.getText().charAt(i)!='_'&&
              JobText.getText().charAt(i)!=' ')
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid Job name format\n\n(Job name can only be a sequence of Unicode letters and digits separated by underscore)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Job name can't contain stranger symbols");

              }
          }


        return true; //all data correct


      }

  catch(IllegalArgumentException e1)
  {

  e1.printStackTrace();
  return false;
  }

  catch(Exception e)
  {
  // TODO: Add catch code
  e.printStackTrace();

  //if there is any other non expecting error
  JOptionPane.showMessageDialog(null,
    "Some Thing went wrong!\n\nPlease check your entered data. ",
    "Invalid Input", JOptionPane.ERROR_MESSAGE);
  return false;
  }
    
 
    
}

    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel CodeLabel;
  private javax.swing.JButton Delete;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JLabel IdLabel;
  private javax.swing.JTextField IdText;
  private javax.swing.JTextField JobText;
  private javax.swing.JLabel NameLabel;
  private javax.swing.JTextField NameText;
  private javax.swing.JButton Refresh;
  private javax.swing.JButton Save;
  private javax.swing.JPanel SavePanel;
  private javax.swing.JTextField SearchText;
  private javax.swing.JButton clear;
  private javax.swing.JPanel clearPanel;
  private javax.swing.JPanel deletePanel;
  private javax.swing.JTable employeestable;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator2;
  private java.awt.Label no_of_rows;
  private javax.swing.JPanel refreshPanel;
  private javax.swing.JButton search;
  private javax.swing.JPanel searchPanel;
  private javax.swing.JButton viewUserButton;
  // End of variables declaration//GEN-END:variables
    
}


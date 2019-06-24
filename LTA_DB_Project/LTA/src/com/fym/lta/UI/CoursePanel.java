
package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.BuildingBao;
import com.fym.lta.BAO.CourseBao;
import com.fym.lta.BAO.DepartmentBao;
import com.fym.lta.BAO.LocationBao;
import com.fym.lta.BAO.LocationTypeBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.CourseDao;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.LocationTypeDto;

import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mustafa Zalat
 */
public class CoursePanel extends javax.swing.JPanel {
  @SuppressWarnings({ "compatibility:-4093812132744169411",
      "oracle.jdeveloper.java.serialversionuid-stale" })
  private static final long serialVersionUID = 1L;
  
    private static CourseBao business;  

    private static UserDto user_data;

      /** Creates new form Course_panel */    
      public CoursePanel(UserDto user) {
          try {
                     business = new BaoFactory().createCourseBao(); //create bao object
                     user_data=user;  // for logged in user
                     initComponents();
                      defaultdata(); //set default data for edit space
                     setTableModel(business.listAll());    //view all existing course 
                     viewonly(user_data);
                     
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
      }
      
      
      /**set course table model*/
      
          private void setTableModel(List<CourseDto> courses){
                  int size = 0;
                  if(courses != null && !courses.isEmpty())
                      size = courses.size();
                  
                  Object [][] coursesArr = new Object [size][7];
                  for(int i =0;i<size;i++){
                  coursesArr[i][0] = courses.get(i).getId();
                  coursesArr[i][1] = courses.get(i).getCode();
                  coursesArr[i][2] = courses.get(i).getName();
                  coursesArr[i][3] = courses.get(i).getNo_of_hrs();
                  coursesArr[i][4] = courses.get(i).getPlt_lecture().getCode();
                  coursesArr[i][5] = courses.get(i).getPlt_section().getCode();

        //for departments
        String s = ""; //buffer string

        //view departments in table
        if(courses.get(i).getDeparts()!=null&&
          !courses.get(i).getDeparts().isEmpty())
          {
            for(int j = 0; j<courses.get(i).getDeparts().size(); j++)
              {

                if(j==courses.get(i).getDeparts().size()-1)
                  s += courses.get(i).getDeparts().get(j).getCode();
                else
                  s += courses.get(i).getDeparts().get(j).getCode()+", ";
              }
          }

        coursesArr[i][6] = s; //set them in table

                  }
                 courseTable.setModel(new javax.swing.table.DefaultTableModel(coursesArr,
                      new String [] {
                          "Id" ,"Code","Name","lec time" ,"PLT lec","PLT sec","Department"
                      }
                  ));


    //change header color
    courseTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
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
                         Integer.toString(courseTable.getRowCount())+"  courses");
                 }


  /**For view only user access */
  private void viewonly(UserDto u)
  {

    u.setScreen_name("Course");

    RoleScreenDao dao = new DaoFactory().createRoleScreenDao();
    if(dao.viewonly(u))
      {
        EditPanel.setVisible(false);
        System.out.println(" \n done panel");
      }
  }
  

  /** to set default data for edit space panel
   */
  private void defaultdata()
  {

    //enable text boxe again
    IdText.setEnabled(true);
    Save.setText("Save");
    //set default text for text boxes
    IdText.setText("Enter course ID");
    CodeText.setText("Enter course code");
    no_of_hourstext.setText("Enter number of hours of the course");
    NameText.setText("Enter course name");
    plt_lecBox.removeAllItems();

    LocationTypeBao loc_Bao =
      new BaoFactory().createLocationTypeBao(); //create location type bao object
    List<LocationTypeDto> loc_list =
      loc_Bao.viewAll(); //get all location types
    
    
    //Set all existing location type to plt_lec combobox
    try
      {

        plt_lecBox.removeAllItems(); //remove all existing data in  plt_lec combobox

        //set location type codes to the plt_lec combobox
        if(loc_list!=null&&!loc_list.isEmpty())
          {
            for(int i = 0; i<loc_list.size(); i++)
              {
                plt_lecBox.addItem(loc_list.get(i).getCode());
              }
             plt_lecBox.setSelectedIndex(-1); //select no thing in this combo

          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }


    //Set all existing location type to plt_sec combobox
    try
      {
        plt_secBox.removeAllItems(); //remove all existing data in  plt_sec combobox

        //set location type codes to the plt_sec combobox
        if(loc_list!=null&&!loc_list.isEmpty())
          {
            for(int i = 0; i<loc_list.size(); i++)
              {
                plt_secBox.addItem(loc_list.get(i).getCode());
              }
            plt_secBox.setSelectedIndex(-1); //select no thing in this combo

          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }

    departCombo.removeAllItems();
   
  }
  
  /**update an existing course*/
  
  private void update()
  {

    if(checkValidity())
      {
        try
          {

            CourseDto course = new CourseDto();
            CourseBao bao = new BaoFactory().createCourseBao();

            //set attributes values for course object
            course.setId(Integer.parseInt(IdText.getText()));
            course.setCode(CodeText.getText());
            course.setName(NameText.getText());
            course.setNo_of_hrs(Float.parseFloat(no_of_hourstext.getText()));

            //for PLT
            //lecture
            course.setPlt_lecture(new LocationTypeDto());
            course.getPlt_lecture().setCode(plt_lecBox.getItemAt(plt_lecBox.getSelectedIndex()));
            //section
            course.setPlt_section(new LocationTypeDto());
            course.getPlt_section().setCode(plt_secBox.getItemAt(plt_secBox.getSelectedIndex()));


            // check and pick up which departments have been selected
            DepartmentDto depart = new DepartmentDto();
            List<DepartmentDto> departments =
              new ArrayList<DepartmentDto>();

            for(int i = 0; i<departCombo.getItemCount(); i++)
              {
                depart = new DepartmentDto();
                depart.setCode(departCombo.getItemAt(i));
                departments.add(depart);
                depart = null;
              }

            course.setDeparts(departments);


            boolean flag = bao.update(course, user_data);

            if(flag==true)
              {
                JOptionPane.showMessageDialog(null,
                  "Course has updated successfully!", "Done", 1);
                setTableModel(bao.listAll());
                courseTable.repaint();
              }

            else
              JOptionPane.showMessageDialog(null, "Course doesn't exist!",
                "Not Found", JOptionPane.ERROR_MESSAGE);

          }

        catch(Exception e)
          {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
              "Some Thing went wrong!\nPlease check your entered data. ",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);

          }
    } 
    
   }


  /**check Validity of entered data
   * @return: True if data is entered correctly (as expected)
   * False when one or more of them entered uncorrectly
   * */
  private boolean checkValidity()
  {
    try
      {

        //check for empty entered data
        if(IdText.getText().equalsIgnoreCase("Enter course ID"))
          {
            JOptionPane.showMessageDialog(null, "Please, enter Course id",
              "Invaid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("id text is empry");
          }
        else if(CodeText.getText().equalsIgnoreCase("Enter course code"))

          {
            JOptionPane.showMessageDialog(null, "Please, enter Course code",
              "Invaid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("code text is empty");
          }
        else if(NameText.getText().equalsIgnoreCase("Enter course name"))
          {
            JOptionPane.showMessageDialog(null, "Please, enter Course name",
              "Invaid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("name text is empty");

          }
        else if(no_of_hourstext.getText().equalsIgnoreCase("Enter number of hours of the course"))
          {
            JOptionPane.showMessageDialog(null,
              "Please enter, number of hours", "Invaid Input",
              JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("no_of_hourstext is empty");
          }
        //check for plt_lec is not selected
        else if(plt_lecBox.getSelectedIndex()==-1) 
          {
            JOptionPane.showMessageDialog(null,
              "Please, Choose Preferred location type for lecture ", "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Plt_lec is not selected");
          }
        //check for plt_sec is not selected
        else if(plt_secBox.getSelectedIndex()==-1)
          {
            JOptionPane.showMessageDialog(null,
              "Please, Choose Preferred location type for section ",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Plt_sec is not selected");
          }
      else if(departCombo.getSelectedIndex()==-1)
          {
            JOptionPane.showMessageDialog(null,
              "Please, Choose course department/s ",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("no selected department");
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
              NameText.getText().charAt(i)!='_' && NameText.getText().charAt(i)!=' ')
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid Name format\n\n(Name can only be a sequence of Unicode letters and digits separated by underscore)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Name can't contain stranger symbols");

              }
          }


        //Check validity of number of hours
        try
          {
            float hours = Float.parseFloat(no_of_hourstext.getText());
            //Check for the entered number of hours is a positive number
            if(hours<1)
              {
                JOptionPane.showMessageDialog(null,
                  "Invalid number of hours \n\n(number of hours is only Positive Number)",
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("number of hours is only Positive Number");
              }
          }
        catch(java.lang.NumberFormatException e2)
          {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null,
              "Please, enter number for number of hours", "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
            return false;
          }



        //check for location type is not selected for plt_lec comboBox
        if(plt_lecBox.getSelectedIndex()==-1) 
          {
            JOptionPane.showMessageDialog(null,
              "Please, Choose preferred location type for lecture", "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("preferred location type for lecture is empty");
          }


        //check for location type is not selected for plt_sec comboBox
        if(plt_lecBox.getSelectedIndex()==-1)
          {
            JOptionPane.showMessageDialog(null,
              "Please, Choose preferred location type for section",
              "Invalid Input", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("preferred location type for section is empty");
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


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  private void initComponents()//GEN-BEGIN:initComponents
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    courseTable = new javax.swing.JTable();
    SearchText = new javax.swing.JTextField();
    no_of_rows = new java.awt.Label();
    EditPanel = new javax.swing.JPanel();
    id = new javax.swing.JLabel();
    no_of_hours = new javax.swing.JLabel();
    CodeText = new javax.swing.JTextField();
    IdText = new javax.swing.JTextField();
    no_of_hourstext = new javax.swing.JTextField();
    code = new javax.swing.JLabel();
    name = new javax.swing.JLabel();
    NameText = new javax.swing.JTextField();
    plt = new javax.swing.JLabel();
    plt_lecBox = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    plt_sec = new javax.swing.JLabel();
    plt_secBox = new javax.swing.JComboBox<>();
    jSeparator1 = new javax.swing.JSeparator();
    departCombo = new javax.swing.JComboBox<>();
    plt_sec1 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel7 = new javax.swing.JLabel();
    SavePanel = new javax.swing.JPanel();
    Save = new javax.swing.JButton();
    DeletePanel = new javax.swing.JPanel();
    Delete = new javax.swing.JButton();
    ClearPanel = new javax.swing.JPanel();
    clear = new javax.swing.JButton();
    ChangePanel = new javax.swing.JPanel();
    Change3 = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    jSeparator3 = new javax.swing.JSeparator();
    RefreshPanel = new javax.swing.JPanel();
    Refresh = new javax.swing.JButton();
    searchPanel = new javax.swing.JPanel();
    search = new javax.swing.JButton();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    courseTable.setAutoCreateRowSorter(true);
    courseTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    courseTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {

      },
      new String []
      {
        "ID", "code", "name", "lecture time", "plt section", "plt lecture", "department"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
      };

      public Class getColumnClass(int columnIndex)
      {
        return types [columnIndex];
      }
    });
    courseTable.setFillsViewportHeight(true);
    courseTable.setRowHeight(25);
    courseTable.setRowMargin(2);
    courseTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    courseTable.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        courseTableMouseClicked(evt);
      }
    });
    courseTable.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        courseTableKeyPressed(evt);
      }
      public void keyReleased(java.awt.event.KeyEvent evt)
      {
        courseTableKeyReleased(evt);
      }
    });
    jScrollPane1.setViewportView(courseTable);
    if (courseTable.getColumnModel().getColumnCount() > 0)
    {
      courseTable.getColumnModel().getColumn(0).setHeaderValue("ID");
      courseTable.getColumnModel().getColumn(1).setHeaderValue("code");
      courseTable.getColumnModel().getColumn(2).setHeaderValue("name");
      courseTable.getColumnModel().getColumn(3).setHeaderValue("lecture time");
      courseTable.getColumnModel().getColumn(4).setHeaderValue("plt section");
      courseTable.getColumnModel().getColumn(5).setHeaderValue("plt lecture");
      courseTable.getColumnModel().getColumn(6).setHeaderValue("department");
    }

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 760, 750));

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
    add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 670, 50));

    no_of_rows.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    no_of_rows.setForeground(new java.awt.Color(135, 135, 135));
    no_of_rows.setText("no of rows");
    add(no_of_rows, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 860, 180, 20));

    EditPanel.setBackground(new java.awt.Color(245, 245, 245));
    EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    id.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    id.setForeground(new java.awt.Color(0, 51, 204));
    id.setText("ID");
    EditPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 50, 50));

    no_of_hours.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    no_of_hours.setForeground(new java.awt.Color(0, 51, 204));
    no_of_hours.setText("N.of hours");
    EditPanel.add(no_of_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 20));

    CodeText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    CodeText.setText("Enter course code");
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
    EditPanel.add(CodeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 510, 50));

    IdText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    IdText.setText("Enter course ID");
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
    EditPanel.add(IdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 510, 50));

    no_of_hourstext.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    no_of_hourstext.setText("Enter number of hours of the course");
    no_of_hourstext.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    no_of_hourstext.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        no_of_hourstextFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        no_of_hourstextFocusLost(evt);
      }
    });
    no_of_hourstext.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        no_of_hourstextActionPerformed(evt);
      }
    });
    EditPanel.add(no_of_hourstext, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 510, 50));

    code.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    code.setForeground(new java.awt.Color(0, 51, 204));
    code.setText("Code");
    EditPanel.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 61, 60));

    name.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    name.setForeground(new java.awt.Color(0, 51, 204));
    name.setText("Name");
    EditPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 48, 60));

    NameText.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    NameText.setText("Enter course name");
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
    EditPanel.add(NameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 510, 50));

    plt.setBackground(new java.awt.Color(231, 78, 123));
    plt.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    plt.setForeground(new java.awt.Color(231, 78, 123));
    plt.setText("Preferred location type:");
    EditPanel.add(plt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 20));

    plt_lecBox.setBackground(new java.awt.Color(255, 255, 255));
    plt_lecBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EditPanel.add(plt_lecBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 180, 50));

    jLabel1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 51, 204));
    jLabel1.setText("lecture");
    EditPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

    plt_sec.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    plt_sec.setForeground(new java.awt.Color(0, 51, 204));
    plt_sec.setText("Section");
    EditPanel.add(plt_sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, -1));

    plt_secBox.setBackground(new java.awt.Color(255, 255, 255));
    plt_secBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EditPanel.add(plt_secBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 200, 50));
    EditPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 600, 13));

    departCombo.setBackground(new java.awt.Color(255, 255, 255));
    departCombo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    EditPanel.add(departCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 261, 50));

    plt_sec1.setFont(new java.awt.Font("VIP Rawy Regular", 0, 18)); // NOI18N
    plt_sec1.setForeground(new java.awt.Color(0, 51, 204));
    plt_sec1.setText("Department");
    EditPanel.add(plt_sec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));
    EditPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 600, 40));

    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_org_unit_128px.png"))); // NOI18N
    EditPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

    SavePanel.setBackground(new java.awt.Color(0, 129, 211));

    Save.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Save.setForeground(new java.awt.Color(255, 255, 255));
    Save.setText("Save");
    Save.setBorderPainted(false);
    Save.setContentAreaFilled(false);
    Save.setFocusPainted(false);
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
      .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(SavePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

    DeletePanel.setBackground(new java.awt.Color(0, 129, 211));

    Delete.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Delete.setForeground(new java.awt.Color(255, 255, 255));
    Delete.setText("Delete ");
    Delete.setBorderPainted(false);
    Delete.setContentAreaFilled(false);
    Delete.setFocusPainted(false);
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
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    DeletePanelLayout.setVerticalGroup(
      DeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(DeletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, -1, 50));

    ClearPanel.setBackground(new java.awt.Color(0, 129, 211));

    clear.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    clear.setForeground(new java.awt.Color(255, 255, 255));
    clear.setText("Clear");
    clear.setBorderPainted(false);
    clear.setContentAreaFilled(false);
    clear.setFocusPainted(false);
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
      .addGroup(ClearPanelLayout.createSequentialGroup()
        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        .addContainerGap())
    );
    ClearPanelLayout.setVerticalGroup(
      ClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(ClearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 100, -1));

    ChangePanel.setBackground(new java.awt.Color(0, 129, 211));

    Change3.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Change3.setForeground(new java.awt.Color(255, 255, 255));
    Change3.setText("Change");
    Change3.setBorderPainted(false);
    Change3.setContentAreaFilled(false);
    Change3.setFocusPainted(false);
    Change3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
    {
      public void mouseMoved(java.awt.event.MouseEvent evt)
      {
        Change3MouseMoved(evt);
      }
    });
    Change3.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseExited(java.awt.event.MouseEvent evt)
      {
        Change3MouseExited(evt);
      }
    });
    Change3.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        Change3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout ChangePanelLayout = new javax.swing.GroupLayout(ChangePanel);
    ChangePanel.setLayout(ChangePanelLayout);
    ChangePanelLayout.setHorizontalGroup(
      ChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Change3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    ChangePanelLayout.setVerticalGroup(
      ChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Change3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    EditPanel.add(ChangePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, -1, 50));

    add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 650, 780));

    jLabel8.setBackground(new java.awt.Color(231, 78, 123));
    jLabel8.setFont(new java.awt.Font("VIP Rawy Regular", 0, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(231, 78, 123));
    jLabel8.setText("Course");
    add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 240, 80));
    add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 610, 40));

    RefreshPanel.setBackground(new java.awt.Color(0, 129, 211));

    Refresh.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    Refresh.setForeground(new java.awt.Color(255, 255, 255));
    Refresh.setText("Refresh ");
    Refresh.setBorderPainted(false);
    Refresh.setContentAreaFilled(false);
    Refresh.setFocusPainted(false);
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
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
    );
    RefreshPanelLayout.setVerticalGroup(
      RefreshPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
    );

    add(RefreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 870, 130, 50));

    searchPanel.setBackground(new java.awt.Color(0, 129, 211));

    search.setFont(new java.awt.Font("VIP Rawy Regular", 0, 20)); // NOI18N
    search.setForeground(new java.awt.Color(255, 255, 255));
    search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_search_26px.png"))); // NOI18N
    search.setBorderPainted(false);
    search.setContentAreaFilled(false);
    search.setFocusPainted(false);
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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 80, 50));
  }//GEN-END:initComponents
  //  CourseDto c = new CourseDto();
    private void CodeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusGained
        if(CodeText.getText().equalsIgnoreCase("Enter course code")){
            CodeText.setText("");}

    CodeText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_CodeTextFocusGained

    private void CodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusLost
        if(CodeText.getText().trim().equalsIgnoreCase("")){
            CodeText.setText("Enter course code");

        CodeText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

      }
    }//GEN-LAST:event_CodeTextFocusLost

    private void CodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeTextActionPerformed

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained
        if(IdText.getText().equalsIgnoreCase("Enter Course Id")){
            IdText.setText("");}

    IdText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_IdTextFocusGained

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost
        if(IdText.getText().trim().equalsIgnoreCase("")){
            IdText.setText("Enter Course Id");}

    IdText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_IdTextFocusLost

    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextActionPerformed

    private void no_of_hourstextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_no_of_hourstextFocusGained
        if(no_of_hourstext.getText().equalsIgnoreCase("Enter number of hours of the course")){
            no_of_hourstext.setText("");}

    no_of_hourstext.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_no_of_hourstextFocusGained

    private void no_of_hourstextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_no_of_hourstextFocusLost
        if(no_of_hourstext.getText().trim().equalsIgnoreCase("")){
            no_of_hourstext.setText("Enter number of hours of the course");}

    no_of_hourstext.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_no_of_hourstextFocusLost

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

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
    try
      {

        CourseDto dto = new CourseDto();
        CourseBao bao = new BaoFactory().createCourseBao();

        dto.setSearch(SearchText.getText());
        List<CourseDto> result = new ArrayList<CourseDto>();

        result = bao.searchFor(dto);

        if(result!=null&&!result.isEmpty())
          {
            setTableModel(result);
            courseTable.repaint();
          }

        else
          JOptionPane.showMessageDialog(null,
            "There is no search result for: "+SearchText.getText(),
            "Invalid search", 1);

      }

    catch(Exception e)
      {
        // TODO: Add catch code
        e.printStackTrace();

      }
    }//GEN-LAST:event_SearchTextActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        try {

            CourseDto dto = new CourseDto();
            CourseBao bao = new BaoFactory().createCourseBao();

            dto.setSearch(SearchText.getText());
            List<CourseDto> result = new ArrayList<CourseDto>();
            
            result = bao.searchFor(dto);
          
            if (result != null && !result.isEmpty())                
            { setTableModel(result);
              courseTable.repaint();}
                
            else
                JOptionPane.showMessageDialog(null,
                                              "There is no search result for: " +
                                              SearchText.getText(),
                                              "Invalid search", 1);

        }

        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();

        }
    }//GEN-LAST:event_searchActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:

    if(Save.getText().equalsIgnoreCase("Update"))
      update();

    else{
      if(checkValidity())
      {
        try {

            CourseDto course = new CourseDto();
            CourseBao bao = new BaoFactory().createCourseBao();
           
            //set attributes values for cousre object
            course.setId(Integer.parseInt(IdText.getText()));
            course.setCode(CodeText.getText());
            course.setName(NameText.getText());
            course.setNo_of_hrs(Float.parseFloat(no_of_hourstext.getText()));

            //for PLT
            //lecture
            course.setPlt_lecture(new LocationTypeDto());
            course.getPlt_lecture().setCode(plt_lecBox.getItemAt(plt_lecBox.getSelectedIndex()));
            //section
            course.setPlt_section(new LocationTypeDto());
            course.getPlt_section().setCode(plt_secBox.getItemAt(plt_secBox.getSelectedIndex()));


            // check and pick up which departments have been selected
            DepartmentDto depart = new DepartmentDto();
            List<DepartmentDto> departments = new ArrayList<DepartmentDto>();

            for(int i = 0; i<departCombo.getItemCount(); i++)
              {
                depart = new DepartmentDto();
                depart.setCode(departCombo.getItemAt(i));
                departments.add(depart);
                depart = null;
              }
          
            course.setDeparts(departments);
          
            
            boolean flag;
            flag = bao.add(course,user_data);

            if (flag == true) {
                JOptionPane.showMessageDialog(null,
                                              "Course has inserted successfully!",
                                              "Done", 1);
                setTableModel(bao.listAll());
                courseTable.repaint();
                Save.setText("Update");
                IdText.setEnabled(false);
                
                
                  } else {
                    int reply =
                      JOptionPane.showConfirmDialog(null,
                        "This Course is already exist!\n\n"+
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
            JOptionPane.showMessageDialog(null,
                                          "Some Thing went wrong!\n\nPlease check your entered data. ",
                                          "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
      }
    }

    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try
        {
          
          //Show confirm message
          int reply =  JOptionPane.showConfirmDialog(null,
                             "Are you sure to delete this course?\n" +
                             "All things depend on it will be deleted!",
                             "Warning",JOptionPane.YES_NO_OPTION);

          //delete object if user choose yes
          if (reply == JOptionPane.YES_OPTION){
            CourseDto course = new CourseDto();
            CourseBao bao = new BaoFactory().createCourseBao();

            course.setId(Integer.parseInt(IdText.getText()));

            //go to business layer
            boolean flag = bao.delete(course);

            if (flag==true)
            {
              JOptionPane.showMessageDialog(null, "Course has deleted successfully!","Done",1);
              setTableModel(bao.listAll());
               courseTable.repaint();
                IdText.setEnabled(true);
                Save.setText("Save");
            }
            else
                JOptionPane.showMessageDialog(null,"Course doesn't exist!","Not Found",JOptionPane.ERROR_MESSAGE);
          }}
        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",1);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void NameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusGained
        // TODO add your handling code here:
        if(NameText.getText().equalsIgnoreCase("Enter course Name")){
            NameText.setText("");}

    NameText.setBorder(new LineBorder(Color.decode("#0081D3"), 2));

    }//GEN-LAST:event_NameTextFocusGained

    private void NameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusLost
        // TODO add your handling code here:
        if(NameText.getText().trim().equalsIgnoreCase("")){
           NameText.setText("Enter course Name");}

    NameText.setBorder(new LineBorder(Color.decode("#CCCCCC"), 2));

    }//GEN-LAST:event_NameTextFocusLost

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void no_of_hourstextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_of_hourstextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_of_hourstextActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
      
        defaultdata(); //set default data to edit space
        
        CourseBao bao = new BaoFactory().createCourseBao();
        // view all data again
        List<CourseDto> courses = bao.listAll();
        setTableModel(courses);
    }//GEN-LAST:event_RefreshActionPerformed

    private void courseTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courseTableKeyPressed
    
     //get number of selected row in table
    int i = courseTable.getSelectedRow();
    
    //Because "courseTable.getSelectedRow()" doesn't give the correct selected row
    if (evt.getExtendedKeyCode() == KeyEvent.VK_UP)
      i--; //for up key decrement
    else if (evt.getExtendedKeyCode() == KeyEvent.VK_DOWN)
      i++; // for down key increment
       
    try{

        IdText.setEnabled(false);
        Save.setText("Update");

        IdText.setText(courseTable.getValueAt(i, 0).toString());
        CodeText.setText(courseTable.getValueAt(i, 1).toString());
        NameText.setText(courseTable.getValueAt(i, 2).toString());
        no_of_hourstext.setText(courseTable.getValueAt(i, 3).toString());

        //get plt lecture from table
        String plt_lec = courseTable.getValueAt(i, 4).toString();
        for(int j = 0; j<plt_lecBox.getItemCount(); j++)
          {
            if(plt_lecBox.getItemAt(j).equalsIgnoreCase(plt_lec))
              plt_lecBox.setSelectedIndex(j);
          }
        //get plt section from table
        String plt_sec = courseTable.getValueAt(i, 5).toString();
        for(int j = 0; j<plt_secBox.getItemCount(); j++)
          {
            if(plt_secBox.getItemAt(j).equalsIgnoreCase(plt_sec))
              plt_secBox.setSelectedIndex(j);
          }

        //get departments from table
        String departs = courseTable.getValueAt(i, 6).toString();
        String[] departsCombo = null;

        if(departs.contains(","))
          {

            //split departs text to get each department code
            departsCombo = departs.split(", ");

            //remove all existing items in departments combobox
            departCombo.removeAllItems();

            if(departsCombo!=null&&departsCombo.length!=0) //for non empty department


              //add existing departments into department combobox
              {
                for(int j = 0; j<departsCombo.length; j++)
                  {
                    departCombo.addItem(departsCombo[j]);
                  }
              }
          }

        // for one value
        else
          {
            departCombo.removeAllItems();
            departCombo.addItem(departs);
          }
      
      }
    catch (java.lang.ArrayIndexOutOfBoundsException e)
    {
      e.printStackTrace();
    }
    
    catch(Exception e){
     
     e.printStackTrace();
    }

    //delete selected object when press delete
    if(evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
      {

        try
          {

            //For one selected row in table

            if(courseTable.getSelectedRowCount()==1)
              { //Show confirm message
                int reply =
                  JOptionPane.showConfirmDialog(null,
                    "Are you sure to delete this course?\n"+
                    "All things depend on it will be deleted!", "Warning",
                    JOptionPane.YES_NO_OPTION);

                //delete object if user choose yes
                if(reply==JOptionPane.YES_OPTION)
                  {
                    CourseDto course =
                      new CourseDto(); //create dto course object
                    CourseBao bao =
                      new BaoFactory().createCourseBao(); //create object Course bao

                    //get selected Course id from table
                    int s =
                      Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(),
                          0).toString());
                    course.setId(s); //set it to Course object

                    //delete it using bao delete method
                    if(bao.delete(course)) //if it deleted sucessfilly show message to tell user that
                      {
                        JOptionPane.showMessageDialog(this,
                          "Location Deleted Successfully");
                        setTableModel(bao.listAll());
                        courseTable.repaint();
                        IdText.setEnabled(true);
                        Save.setText("Save");

                      }

                    else
                      //if bao method return false (Course not be deleted)
                      JOptionPane.showMessageDialog(this,
                        "Can't delete object", "Error",
                        JOptionPane.ERROR_MESSAGE);
                  }

              }
            else if(courseTable.getSelectedRowCount()==0)
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
        
    }//GEN-LAST:event_courseTableKeyPressed

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        try{       
          
        //get number of selected row in table
        int i = courseTable.getSelectedRow();
        
        IdText.setEnabled(false);
        Save.setText("Update");

        IdText.setText(courseTable.getValueAt(i, 0).toString());
        CodeText.setText(courseTable.getValueAt(i, 1).toString());
        NameText.setText(courseTable.getValueAt(i, 2).toString());
        no_of_hourstext.setText(courseTable.getValueAt(i, 3).toString());
        
        //get plt lecture from table
        String plt_lec = courseTable.getValueAt(i,4).toString();
        for(int j = 0; j<plt_lecBox.getItemCount(); j++)
          {
            if(plt_lecBox.getItemAt(j).equalsIgnoreCase(plt_lec))
              plt_lecBox.setSelectedIndex(j);
          }
        //get plt section from table
        String plt_sec = courseTable.getValueAt(i, 5).toString();
        for(int j = 0; j<plt_secBox.getItemCount(); j++)
          {
            if(plt_secBox.getItemAt(j).equalsIgnoreCase(plt_sec))
              plt_secBox.setSelectedIndex(j);
          }

        //get departments from table
        String departs = courseTable.getValueAt(i, 6).toString();
        String[] departsCombo = null;

        if(departs.contains(","))
          {

            //split departs text to get each department code
            departsCombo = departs.split(", ");

            //remove all existing items in departments combobox
            departCombo.removeAllItems();

            if(departsCombo!=null&&departsCombo.length!=0) //for non empty department

              //add existing departments into department combobox
              {
                for(int j = 0; j<departsCombo.length; j++)
                  {
                    departCombo.addItem(departsCombo[j]);
                  }
              }
          }

        // for one value
        else
          {
            departCombo.removeAllItems();
            departCombo.addItem(departs);
          }
          
        }
      catch (Exception e) {
                e.printStackTrace();
                
            }
            
    }//GEN-LAST:event_courseTableMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       
        defaultdata();  //set default data to edit space 
        
    }//GEN-LAST:event_clearActionPerformed

    private void courseTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courseTableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTableKeyReleased

  private void Change3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_Change3ActionPerformed
  {//GEN-HEADEREND:event_Change3ActionPerformed

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
    labelList1.setText("Available departments:");
    labelList2.setText("Selected departments:");
    labelList1.setSize(150,19);
    labelList2.setSize(150,19);
    labelList1.setLocation(48, 20);
    labelList2.setLocation(265, 20);
    frame.getContentPane().add(labelList1);
    frame.getContentPane().add(labelList2);

    //get all existing departments from data base
    DepartmentBao departBao = new BaoFactory().createDepartmentBao();
    List<DepartmentDto> departs = new ArrayList<DepartmentDto>();
    departs = departBao.viewAll();

    // set all existing Departments' code to the first list
    for (int i = 0; i < departs.size(); i++)
    {
      model_list1.addElement(departs.get(i).getCode());
    }

    /*get existing departments' code from combobox (if exist)
    * add them to second list
    * remove them from first list 
    * */
    for (int i = 0; i < departCombo.getItemCount(); i++)
    {

      model_list2.addElement(departCombo.getItemAt(i));
      model_list1.removeElement(departCombo.getItemAt(i));

    }

    // move all selected element to the secode list and remove it from first list
    // when user click on add button
    add.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        list1.getSelectedValuesList().stream().forEach((data) ->
        {
          model_list2.addElement(data);
          model_list1.removeElement(data);
        });
      }
    });

    // remove all selected element from the secode list and add it to first list
    // when user click on remove button
    remove.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        list2.getSelectedValuesList().stream().forEach((data) ->
        {
          model_list1.addElement(data);
          model_list2.removeElement(data);
        });
      }
    });

    // Action when user click on save button
    save.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

        //clear building combobox
        departCombo.removeAllItems();

        //Save selected building into building combobox
        for (int i = 0; i < model_list2.size(); i++)
        {
          departCombo.addItem(model_list2.get(i).toString());
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
    frame.setTitle("Choose course department/s");
    frame.setSize(490, 400);
    frame.setResizable(false);

    //veiw the frame when user click on the change buttom
    frame.setVisible(true);
  }//GEN-LAST:event_Change3ActionPerformed

  private void searchMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseMoved
  {//GEN-HEADEREND:event_searchMouseMoved
    // TODO add your handling code here:

    searchPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_searchMouseMoved

  private void RefreshMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseMoved
  {//GEN-HEADEREND:event_RefreshMouseMoved
    // TODO add your handling code here:

    RefreshPanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_RefreshMouseMoved

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

  private void Change3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_Change3MouseMoved
  {//GEN-HEADEREND:event_Change3MouseMoved
    // TODO add your handling code here:

    ChangePanel.setBackground(Color.decode("#0051D2"));

  }//GEN-LAST:event_Change3MouseMoved

  private void RefreshMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_RefreshMouseExited
  {//GEN-HEADEREND:event_RefreshMouseExited
    // TODO add your handling code here:

    RefreshPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_RefreshMouseExited

  private void SaveMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveMouseExited
  {//GEN-HEADEREND:event_SaveMouseExited
    // TODO add your handling code here:
    SavePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_SaveMouseExited

  private void DeleteMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteMouseExited
  {//GEN-HEADEREND:event_DeleteMouseExited
    // TODO add your handling code here:

    DeletePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_DeleteMouseExited

  private void clearMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearMouseExited
  {//GEN-HEADEREND:event_clearMouseExited
    // TODO add your handling code here:

    ClearPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_clearMouseExited

  private void Change3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_Change3MouseExited
  {//GEN-HEADEREND:event_Change3MouseExited
    // TODO add your handling code here:

    ChangePanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_Change3MouseExited

  private void searchMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchMouseExited
  {//GEN-HEADEREND:event_searchMouseExited
    // TODO add your handling code here:

    searchPanel.setBackground(Color.decode("#0081D3"));

  }//GEN-LAST:event_searchMouseExited

  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Change3;
  private javax.swing.JPanel ChangePanel;
  private javax.swing.JPanel ClearPanel;
  private javax.swing.JTextField CodeText;
  private javax.swing.JButton Delete;
  private javax.swing.JPanel DeletePanel;
  private javax.swing.JPanel EditPanel;
  private javax.swing.JTextField IdText;
  private javax.swing.JTextField NameText;
  private javax.swing.JButton Refresh;
  private javax.swing.JPanel RefreshPanel;
  private javax.swing.JButton Save;
  private javax.swing.JPanel SavePanel;
  private javax.swing.JTextField SearchText;
  private javax.swing.JButton clear;
  private javax.swing.JLabel code;
  private javax.swing.JTable courseTable;
  private javax.swing.JComboBox<String> departCombo;
  private javax.swing.JLabel id;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JLabel name;
  private javax.swing.JLabel no_of_hours;
  private javax.swing.JTextField no_of_hourstext;
  private java.awt.Label no_of_rows;
  private javax.swing.JLabel plt;
  private javax.swing.JComboBox<String> plt_lecBox;
  private javax.swing.JLabel plt_sec;
  private javax.swing.JLabel plt_sec1;
  private javax.swing.JComboBox<String> plt_secBox;
  private javax.swing.JButton search;
  private javax.swing.JPanel searchPanel;
  // End of variables declaration//GEN-END:variables

  }

package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.DepartmentBao;
import com.fym.lta.BAO.ScheduleBao;
import com.fym.lta.BAO.SlotBao;
import com.fym.lta.BAO.StageBao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.LocationDao;
import com.fym.lta.DAO.ScheduleDao;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.ScheduleDto;
import com.fym.lta.DTO.SlotDto;
import com.fym.lta.DTO.StageDto;
import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mai-AbdEltwab
 */

public class SchedulePanel extends javax.swing.JPanel
{
  @SuppressWarnings("compatibility:-1041221552983012859")
  private static final long serialVersionUID = 1L;

  private static SlotBao slotbao = new BaoFactory().createSLotBao();

  static UserDto user = new UserDto();

  /** Creates new form AutoAssignPanel */
  public SchedulePanel(UserDto u)
  {
    user = u;
    initComponents();
    defaultdata();
  }


  /**
   * method to set the table model by data of slots
   * */
  private void setTableModel(List<SlotDto> slots)
  {

    int size = 0;
    if(slots!=null&&!slots.isEmpty())
      size = slots.size();

    Object[][] slotsArr = new Object[25][9];

    // set days to table cells
    slotsArr[0][0] = "Sunday";
    slotsArr[5][0] = "Monday";
    slotsArr[10][0] = "Tuesday";
    slotsArr[15][0] = "Wednesday";
    slotsArr[20][0] = "Thursday";

    // loop for days' rows of schedule
    for(int r = 0; r<5; r++)
      {
        r = r*5;

        // loop for slots' columns of schedule
        for(int c = 0; c<4; c++)
          {
            int cell = c*2;

            // loop to get slot of indexed day and time slot
            for(int i = 0; i<size; i++)
              {
                if((slots.get(i).getNum()==(c+1)&&
                  (slots.get(i).getDay().equals(slotsArr[r][0]))))
                  {

                    // set course name and code od slot
                    slotsArr[r][cell+1] =
                      slots.get(i).getCourse().getName();
                    slotsArr[r][cell+2] =
                      slots.get(i).getCourse().getCode();

                    // set type of slot
                    slotsArr[r+2][cell+1] = slots.get(i).getSlot_type();

                    // set location of slot
                    slotsArr[r+3][cell+1] =
                      slots.get(i).getLocation().getName();


                    // check slot type then set plt of slot
                    if(slots.get(i).getSlot_type().equals("LECTURE"))
                      {
                        slotsArr[r+3][cell+2] =
                          slots.get(i).getCourse().getPlt_lecture().getCode();
                        System.out.println("plt"+
                          slots.get(i).getCourse().getPlt_lecture().getCode());
                      }
                    if(slots.get(i).getSlot_type().equals("SECTION"))
                      {
                        slotsArr[r+3][cell+2] =
                          slots.get(i).getCourse().getPlt_lecture().getCode();
                        System.out.println("plt"+
                          slots.get(i).getCourse().getPlt_lecture().getCode());
                      }

                    // set student number of slot
                    slotsArr[r+4][cell+1] = "STUDENT NUMBER";
                    slotsArr[r+4][cell+2] =
                      slots.get(i).getStudent_number();

                    /*
             * set staff of slot then check if members > 1 then concatenate all members' names
             * and set to cell */
                    String staff =
                      slots.get(i).getStaff().get(0).getPosition()+"/"+
                      slots.get(i).getStaff().get(0).getName();

                    System.out.println("staff size"+
                      slots.get(i).getStaff().size());
                    System.out.println("user size"+
                      slots.get(i).getUser().size());

                    if(slots.get(i).getStaff().size()>1)
                      {
                        for(int j = 1; j<slots.get(i).getStaff().size();
                          j++)
                          {
                            staff =
                              staff+" # "+
                              slots.get(i).getStaff().get(j).getPosition()+
                              "/"+slots.get(i).getStaff().get(j).getName();
                          }
                      }
                    slotsArr[r+1][cell+1] = staff;

                    /*
             * set user email of slot then check if users > 1 then concatenate all users' email
             * and set to cell */
                    String[] email =
                      slots.get(i).getUser().get(0).getEmail().split("@",
                        2);
                    String user = email[0];
                    if(slots.get(i).getUser().size()>1)
                      {
                        for(int k = 0; k<slots.get(i).getUser().size(); k++)
                          {
                            String[] _email =
                              slots.get(i).getUser().get(k).getEmail().split("@",
                                2);
                            user = user+" # "+_email[0];
                          }
                      }
                    slotsArr[r+1][cell+2] = user;
                  }
              }
          }
      }
    scheduleTable.setModel(new javax.swing.table.DefaultTableModel(slotsArr,
        new String[] { "Time Slot", "First", " ", "Second", " ", "Third",
        " ", "Fourth", " " }));

  }

  private void defaultdata()
  {
    //set all existing Departments in db to department combobox
    try
      {

        StageBao stage_bao =
          new BaoFactory().createStageBao(); //create building bao object
        List<StageDto> stage_list =
          stage_bao.viewAll(); //get all building from DB

        stageComboBox.removeAllItems(); //remove all item from building combobox

        if(stage_list!=null&&!stage_list.isEmpty())
          {
            for(int i = 0; i<stage_list.size(); i++)
              {
                stageComboBox.addItem(stage_list.get(i).getNumber());
              }

            stageComboBox.setSelectedIndex(-1); //select no thing in this combo
          }


        DepartmentBao depart_bao = new BaoFactory().createDepartmentBao();
        List<DepartmentDto> depart_list = depart_bao.viewAll();
        DepartComboBox.removeAllItems();

        if(depart_list!=null&&!depart_list.isEmpty())
          {
            for(int i = 0; i<depart_list.size(); i++)
              {
                DepartComboBox.addItem(depart_list.get(i).getName());
              }
            DepartComboBox.setSelectedIndex(-1);
          }


      }

    catch(Exception e)
      {
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

    jButton1 = new javax.swing.JButton();
    DepartComboBox = new javax.swing.JComboBox<>();
    stageComboBox = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    selectDepartmentLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    scheduleTable = new javax.swing.JTable();
    viewScheduleButton = new javax.swing.JButton();

    setBackground(new java.awt.Color(245, 245, 245));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });
    add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

    DepartComboBox.setBackground(new java.awt.Color(255, 255, 255));
    DepartComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    DepartComboBox.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        DepartComboBoxActionPerformed(evt);
      }
    });
    add(DepartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, 50));

    stageComboBox.setBackground(new java.awt.Color(255, 255, 255));
    stageComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    stageComboBox.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        stageComboBoxActionPerformed(evt);
      }
    });
    add(stageComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 310, 50));

    jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    jLabel1.setText("Select Stage:");
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 137, 37));

    selectDepartmentLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    selectDepartmentLabel.setText("Select Department:");
    add(selectDepartmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 135, 36));

    scheduleTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null}
      },
      new String []
      {
        "Time Slot", "First", "", "Second", "", "Third", "", "Fourth", ""
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean []
      {
        false, false, false, false, false, false, true, true, true
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
    scheduleTable.setCellSelectionEnabled(true);
    scheduleTable.setFillsViewportHeight(true);
    scheduleTable.setGridColor(new java.awt.Color(102, 102, 102));
    scheduleTable.setIntercellSpacing(new java.awt.Dimension(2, 0));
    scheduleTable.setRowHeight(24);
    scheduleTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
    scheduleTable.setShowHorizontalLines(false);
    scheduleTable.setShowVerticalLines(false);
    jScrollPane1.setViewportView(scheduleTable);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 1112, 492));

    viewScheduleButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
    viewScheduleButton.setText("View Schedule");
    viewScheduleButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        viewScheduleButtonActionPerformed(evt);
      }
    });
    add(viewScheduleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 185, 37));
  }//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
  {//GEN-HEADEREND:event_jButton1ActionPerformed
    // TODO add your handling code here:
    
    ScheduleDto s = new ScheduleDto();
    DepartmentDto department = new DepartmentDto();
    department.setName("mm");
    s.setDepartment(department);
    StageDto stage = new StageDto();
    stage.setNumber("first");
    s.setStage(stage);

    ScheduleBao sch_dao = new BaoFactory().createScheduleBao();
    List<SlotDto> slots = sch_dao.autoAssignment(s, user);
    
    if(slots==null)
      System.out.println("Success!");
  }//GEN-LAST:event_jButton1ActionPerformed

  private void DepartComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DepartComboBoxActionPerformed
  {//GEN-HEADEREND:event_DepartComboBoxActionPerformed
    // TODO add your handling code here:

  }//GEN-LAST:event_DepartComboBoxActionPerformed

  private void stageComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stageComboBoxActionPerformed
  {//GEN-HEADEREND:event_stageComboBoxActionPerformed
    // TODO add your handling code here:

  }//GEN-LAST:event_stageComboBoxActionPerformed

  private void viewScheduleButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewScheduleButtonActionPerformed
  {//GEN-HEADEREND:event_viewScheduleButtonActionPerformed
    try
    {

      // identify department dto object
      DepartmentDto depart = new DepartmentDto();

      // set department name by the selected from comboBox by user
      depart.setName(DepartComboBox.getSelectedItem().toString());

      // identify stage dto object
      StageDto stage = new StageDto();

      // set stage number by the selected from combo box by user
      stage.setNumber(stageComboBox.getSelectedItem().toString());

      /* identify list of slots dto then set to it slots of schedule
      * by calling viewSlotsOfSchedule bao method */
      List<SlotDto> slots = new ArrayList<>();
      slots = slotbao.viewSlotsOfSchedule(stage, depart);

      // set table by slots data then repaint
      setTableModel(slots);
      scheduleTable.repaint();;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.out.println("error in viewSchedules panel");
    }

  }//GEN-LAST:event_viewScheduleButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> DepartComboBox;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable scheduleTable;
  private javax.swing.JLabel selectDepartmentLabel;
  private javax.swing.JComboBox<String> stageComboBox;
  private javax.swing.JButton viewScheduleButton;
  // End of variables declaration//GEN-END:variables

}

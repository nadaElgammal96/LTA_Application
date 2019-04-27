
package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.LocationTypeBao;

import com.fym.lta.DTO.LocationTypeDto;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.IllegalFormatException;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 *
 * @author Mai-AbdEltwab
 */

public class LocationTypePanel extends java.awt.Panel {
    @SuppressWarnings("compatibility:-2513401534424086084")
    private static final long serialVersionUID = 1L;

    /** Creates new form LocationTypePanel */
    public LocationTypePanel() {

        initComponents();
        LocationTypeBao bao;
        bao= new  BaoFactory().createLocationTypeBao();
        List<LocationTypeDto> types = new ArrayList<LocationTypeDto>();
        types = bao.viewAll();
        setTableModel(types);
    }
    
    

 
    
    private void setTableModel(List<LocationTypeDto> types){
        
       int s=0;
       if(types!=null && !types.isEmpty())
       {   s= types.size();
       
       }      
              
       Object [][] TypeArr = new Object [s][4];       
            for(int i =0;i<s;i++){
            
            TypeArr[i][0] = types.get(i).getId();
            TypeArr[i][1] = types.get(i).getCode();
            TypeArr[i][2] = types.get(i).getColor();
            TypeArr[i][3] = types.get(i).getDescription();
        }
            
        LTTable.setModel(new javax.swing.table.DefaultTableModel(TypeArr,
            new String [] {"Id", "Code","Color","Description:"}
        )); 
        
   }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        Refresh = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        search = new javax.swing.JButton();
        IdLabel = new javax.swing.JLabel();
        SearchText = new javax.swing.JTextField();
        CodeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LTTable = new javax.swing.JTable();
        NameLabel = new javax.swing.JLabel();
        IdText = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        CodeText = new javax.swing.JTextField();
        BuildingLabel = new javax.swing.JLabel();
        ColorText = new javax.swing.JTextField();
        Nwe = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        DesText = new javax.swing.JTextField();
        ChangeColor = new javax.swing.JButton();

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        IdLabel.setText("Id:");

        SearchText.setText("Enter what do you want to search for");
        SearchText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTextFocusLost(evt);
            }
        });
        SearchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextKeyPressed(evt);
            }
        });

        CodeLabel.setText("Code:");

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
        });

        LTTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code", "Color", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        LTTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LTTableFocusGained(evt);
            }
        });
        LTTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LTTableMouseClicked(evt);
            }
        });
        LTTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LTTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(LTTable);

        NameLabel.setText("Color");

        IdText.setText("Enter Location type ID");
        IdText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IdTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                IdTextFocusLost(evt);
            }
        });
        IdText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdTextMouseClicked(evt);
            }
        });
        IdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        CodeText.setText("Enter Location type code");
        CodeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CodeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CodeTextFocusLost(evt);
            }
        });

        BuildingLabel.setText("Description:");

        ColorText.setText("Enter Location type color (Hex)");
        ColorText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ColorTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ColorTextFocusLost(evt);
            }
        });
        ColorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorTextActionPerformed(evt);
            }
        });

        Nwe.setText("New");
        Nwe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NweActionPerformed(evt);
            }
        });

        Delete.setText("Delete ");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        DesText.setText("Enter Location type Description");
        DesText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DesTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DesTextFocusLost(evt);
            }
        });
        DesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesTextActionPerformed(evt);
            }
        });

        ChangeColor.setText("Change");
        ChangeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IdLabel)
                                            .addComponent(NameLabel))
                                        .addGap(50, 50, 50))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BuildingLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nwe, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(IdText, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ColorText)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ChangeColor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(CodeText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DesText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Refresh)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(IdLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(IdText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodeLabel)
                    .addComponent(CodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(ChangeColor)
                    .addComponent(ColorText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuildingLabel)
                    .addComponent(DesText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nwe)
                    .addComponent(Update)
                    .addComponent(Delete)
                    .addComponent(clear))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
  
        // for text boxes
        //enable text boxes again
        IdText.setEnabled(true);
        CodeText.setEnabled(true);

        //set default text for text boxes
        IdText.setText("Enter Location type ID");
        CodeText.setText("Enter Location type code");
        ColorText.setText("Enter Location type color (Hex)");
        DesText.setText("Enter Location type Description");
        
        LocationTypeBao bao = new BaoFactory().createLocationTypeBao();
        // view all data again
        List<LocationTypeDto> types = bao.viewAll();
        setTableModel(types);
    }//GEN-LAST:event_RefreshActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:

        try
        {
            LocationTypeDto dto = new LocationTypeDto();
            LocationTypeBao bao = new BaoFactory().createLocationTypeBao();;

            //check validity of input color
            String color = ColorText.getText();
            Character[] hexa = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
                'd', 'e', 'f'
            };
            for (int i = 0; i < color.length(); i++) {
                int j = 0;
                for (j = 0; j < hexa.length; j++) {
                    if (color.charAt(i) == hexa[j])
                        break;
                }

                if ((hexa[j] == 'f' && color.charAt(i) != 'f') ||
                    color.length() > 6) {
                    JOptionPane.showMessageDialog(null, "Invalid color code",
                                                  "Invalid Input", 1);
                    throw new IllegalArgumentException("Invaild color code");
                }
            }
            
            dto.setId(Integer.parseInt(IdText.getText()));
            dto.setCode(CodeText.getText());
            dto.setColor(ColorText.getText());
            dto.setDescription(DesText.getText());

            boolean flag = bao.update(dto);

            if (flag==true)
            {JOptionPane.showMessageDialog(null, "Location Type has updated successfully!","Done",1);
                setTableModel(bao.viewAll());
                LTTable.repaint();
            }

        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        }
        
        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some Thing went wrong!\nPlease check your entered data. ","Invalid Input",1);

        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        try{

            LocationTypeDto dto = new  LocationTypeDto();
            LocationTypeBao bao = new BaoFactory().createLocationTypeBao();
           
            dto.setSearch(SearchText.getText());
            List<LocationTypeDto> result = new ArrayList<LocationTypeDto>();
            result = bao.searchFor(dto);
            if(result != null && !result.isEmpty())
                setTableModel(result);
            else
                JOptionPane.showMessageDialog(null,
                                              "There is no search result for: " +
                                              SearchText.getText(),
                                              "Invalid search", 1);

        }

        catch(Exception e){
            // TODO: Add catch code
            e.printStackTrace();

        }

    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        
        //enable text boxes again
        IdText.setEnabled(true);
        CodeText.setEnabled(true);
        
        //set default text for text boxes 
        IdText.setText("Enter Location type ID");
        CodeText.setText("Enter Location type code");
        ColorText.setText("Enter Location type color (Hex)");
        DesText.setText("Enter Location type Description");

    }//GEN-LAST:event_clearActionPerformed

    private void ColorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColorTextActionPerformed

    private void NweActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NweActionPerformed

        try
        {
            
            LocationTypeDto dto = new LocationTypeDto();
            LocationTypeBao bao = new BaoFactory().createLocationTypeBao();
            
            //check for empty entered data
            if(IdText.getText().isEmpty())
            { JOptionPane.showMessageDialog(null, "Please enter location type id","Done",1);
                throw new IllegalArgumentException("id text is empry");}
            else if(CodeText.getText().isEmpty())
            
            { JOptionPane.showMessageDialog(null, "Please enter location type code","Done",1);
                throw new IllegalArgumentException("code text is empty");}
            else if(ColorText.getText().isEmpty())  
            { JOptionPane.showMessageDialog(null, "Please enter location type color","Done",1);
                throw new IllegalArgumentException("color text is empty");}
            
            //Check for the entered id is a positive number 
            int id = Integer.parseInt(IdText.getText());
            if(id<1)
            {   JOptionPane.showMessageDialog(null, "ID is only Positive Numbers","Invalid Input",1);
                throw new IllegalArgumentException("ID is only Positive Numbers");}
            
            
            //check validity of input color
            String color = ColorText.getText();
            Character[] hexa = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            for(int i=0 ; i<color.length() ; i++) {
            int j=0; 
                for(j=0 ; j<hexa.length ; j++)
                {
                     if(color.charAt(i)==hexa[j])
                     break;
                } 
                
                if((hexa[j]=='f'&&color.charAt(i)!='f') || color.length()>6) {
                    JOptionPane.showMessageDialog(null,"Invalid color code","Invalid Input",1);
                   throw new IllegalArgumentException("Invaild color code");} }
            
            
            //set attributes values for location type object 
            dto.setId(id);
            dto.setCode(CodeText.getText());
            dto.setColor(color);
            dto.setDescription(DesText.getText());

            boolean flag;
             flag = bao.add(dto);

            if (flag==true){
            JOptionPane.showMessageDialog(null, "Location type has inserted successfully!","Done",1);
             setTableModel(bao.viewAll());
                LTTable.repaint();
            }
            else{
            JOptionPane.showMessageDialog(null, "This Location Type is already exist!","Invalid Input",1);
            setTableModel(bao.viewAll());
               LTTable.repaint();
        }
        }
        
        catch(java.lang.NumberFormatException e2)
        {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please enter number for ID","Invalid Input",1);

        }
        
        catch (java.lang.ArrayIndexOutOfBoundsException e3) {
            
            e3.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid color code","Invalid Input",1);

        }
        catch (IllegalArgumentException e1) {
            
            e1.printStackTrace();
        }
        
        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some Thing went wrong!\n\nPlease check your entered data. ","Invalid Input",1);
        }


    }//GEN-LAST:event_NweActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:

        try
        {
            LocationTypeDto dto = new LocationTypeDto();
            LocationTypeBao bao = new BaoFactory().createLocationTypeBao();

            dto.setId(Integer.parseInt(IdText.getText()));

            //go to business layer
            boolean flag = bao.delete(dto);

            if (flag==true)
            {JOptionPane.showMessageDialog(null, "Location Type has deleted successfully!","Done",1);
              setTableModel(bao.viewAll());
               LTTable.repaint();}
            else
                JOptionPane.showMessageDialog(null,"Location Type doesn't exist!","Not Found",1);
        }
        catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some Thing went wrong!/nPlease check your entered data. ","Invalid Input",1);

        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void DesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesTextActionPerformed

    private void ChangeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeColorActionPerformed
      
        // define new color chooser 
        JColorChooser Change = new JColorChooser();

        // HIDE ALL DEFAULT PANELS AND SHOW RGB AND SWATCHES PANELS ONLY
        AbstractColorChooserPanel[] panels=Change.getChooserPanels();
                for(AbstractColorChooserPanel p:panels){
                    String displayName=p.getDisplayName();
                    switch (displayName) {
                        case "HSV":
                            Change.removeChooserPanel(p);
                            break;
                        case "HSL":
                            Change.removeChooserPanel(p);
                            break;
                        case "CMYK":
                            Change.removeChooserPanel(p);
                            break;
                        case "Swatches":
                            Change.removeChooserPanel(p);
                    }}
                
        //Declare new buttom named "save" and set its bounds
        JButton SaveColor = new JButton("Save");
        SaveColor.setBounds(50,100,60,30); 
        
        // Create new frame and panel
        JFrame chooseColorFrame = new JFrame();
        JPanel panel = new JPanel();
        
        /*Close the choose color frame 
         * pickup the cooched color to the color tect 
         * when click on save*/
        
        SaveColor.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            //Pick up the RGB color choosed by user
            String getcolor =Integer.toHexString(Change.getColor().getRGB());
            char[] setcolor = {'1','2','3','4','5','6'};
            for(int i=2 ; i<8 ; i++)
                setcolor[i-2] = getcolor.charAt(i);
            String s = new String(setcolor);
            ColorText.setText(s);
                   chooseColorFrame.dispose();  
        }} );
        
        // add the color chooser and sace buttom on the panel
        panel.setLayout(new FlowLayout());
        panel.add(Change);
        panel.add(SaveColor);
        
        //add the panel into the frame and set the frame size/title
        chooseColorFrame.add(panel);
        chooseColorFrame.setTitle("Choose Location type color");
        chooseColorFrame.setSize(680, 450);
        chooseColorFrame.setResizable(false);
        
        //veiw the frame when user click on the change buttom
        chooseColorFrame.setVisible(true);
    }//GEN-LAST:event_ChangeColorActionPerformed

    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
     
    }//GEN-LAST:event_IdTextActionPerformed

    private void IdTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IdTextMouseClicked
      
    }//GEN-LAST:event_IdTextMouseClicked

    private void IdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusGained
        if(IdText.getText().equalsIgnoreCase("Enter Location type ID"))
            IdText.setText("");
    }//GEN-LAST:event_IdTextFocusGained

    private void IdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdTextFocusLost
    if(IdText.getText().trim().equalsIgnoreCase(""))
        IdText.setText("Enter Location type ID");
    }//GEN-LAST:event_IdTextFocusLost

    private void CodeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusGained
        if(CodeText.getText().equalsIgnoreCase("Enter Location type code"))
            CodeText.setText("");
    }//GEN-LAST:event_CodeTextFocusGained

    private void CodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodeTextFocusLost
      if(CodeText.getText().trim().equalsIgnoreCase(""))
           CodeText.setText("Enter Location type code");
    }//GEN-LAST:event_CodeTextFocusLost

    private void ColorTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ColorTextFocusLost
       if(ColorText.getText().equalsIgnoreCase(""))
          ColorText.setText("Enter Location type color (Hex)");
    }//GEN-LAST:event_ColorTextFocusLost

    private void ColorTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ColorTextFocusGained
        if(ColorText.getText().equalsIgnoreCase("Enter Location type color (Hex)"))
            ColorText.setText("");
    }//GEN-LAST:event_ColorTextFocusGained

    private void DesTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesTextFocusGained
      if(DesText.getText().equalsIgnoreCase("Enter Location type Description"))
        DesText.setText("");
    }//GEN-LAST:event_DesTextFocusGained

    private void DesTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesTextFocusLost
        if(DesText.getText().equalsIgnoreCase(""))
           DesText.setText("Enter Location type Description");
    }//GEN-LAST:event_DesTextFocusLost

    private void SearchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusGained
        if(SearchText.getText().equalsIgnoreCase("Enter what do you want to search for"))
          SearchText.setText("");
    }//GEN-LAST:event_SearchTextFocusGained

    private void SearchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFocusLost
        if(SearchText.getText().equalsIgnoreCase(""))
            SearchText.setText("Enter what do you want to search for");
    }//GEN-LAST:event_SearchTextFocusLost

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
        
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void LTTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LTTableFocusGained
        
        
    }//GEN-LAST:event_LTTableFocusGained

    private void LTTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LTTableMouseClicked
        int i = LTTable.getSelectedRow();
        //unable to edit code and id for selected item
        IdText.setEnabled(false);
        CodeText.setEnabled(false);
        //get values from table to text boxes 
        IdText.setText(LTTable.getValueAt(i,0).toString());
        CodeText.setText(LTTable.getValueAt(i,1).toString());
        ColorText.setText(LTTable.getValueAt(i,2).toString());
        DesText.setText(LTTable.getValueAt(i,3).toString());
    }//GEN-LAST:event_LTTableMouseClicked

    private void LTTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LTTableKeyPressed
        
        
        if(evt.getExtendedKeyCode()==KeyEvent.VK_UP||evt.getExtendedKeyCode()==KeyEvent.VK_DOWN)
        {
            int i = LTTable.getSelectedRow();
            IdText.setText(LTTable.getValueAt(i,0).toString());
            CodeText.setText(LTTable.getValueAt(i,1).toString());
            ColorText.setText(LTTable.getValueAt(i,2).toString());
            DesText.setText(LTTable.getValueAt(i,3).toString());
        }
        
    }//GEN-LAST:event_LTTableKeyPressed

    private void SearchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {

            try {

                LocationTypeDto dto = new LocationTypeDto();
                LocationTypeBao bao = new BaoFactory().createLocationTypeBao();

                dto.setSearch(SearchText.getText());
                List<LocationTypeDto> result = new ArrayList<LocationTypeDto>();
                result = bao.searchFor(dto);
                if (result != null && !result.isEmpty())
                    setTableModel(result);
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
        }
        
    }//GEN-LAST:event_SearchTextKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuildingLabel;
    private javax.swing.JButton ChangeColor;
    private javax.swing.JLabel CodeLabel;
    private javax.swing.JTextField CodeText;
    private javax.swing.JTextField ColorText;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField DesText;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JTextField IdText;
    private javax.swing.JTable LTTable;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton Nwe;
    private javax.swing.JButton Refresh;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton Update;
    private javax.swing.JButton clear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables

}



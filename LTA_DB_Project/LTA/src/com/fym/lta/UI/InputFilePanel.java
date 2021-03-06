
package com.fym.lta.UI;

import com.fym.lta.DTO.UserDto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nada El-Gammal
 */
public class InputFilePanel extends javax.swing.JPanel {
  @SuppressWarnings({ "compatibility:-1969849904029131601",
      "oracle.jdeveloper.java.serialversionuid-stale" })
  private static final long serialVersionUID = 9187913759479331188L;

  private static UserDto user;
    /** Creates new form InputFileJPanel */
    public InputFilePanel(UserDto u) {
        user=u;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        selectFileButton = new javax.swing.JButton();
        uploadFileButton = new javax.swing.JButton();
        filePathTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        selectFileButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        selectFileButton.setText("Select File");
        selectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileButtonActionPerformed(evt);
            }
        });

        uploadFileButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        uploadFileButton.setText("Save and auto assign");
        uploadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileButtonActionPerformed(evt);
            }
        });

        filePathTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        filePathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Selected File:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 188, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(uploadFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(uploadFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void uploadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFileButtonActionPerformed
    try{
        ReadExcelClass read = new ReadExcelClass();
        if( read.checkSchedule(filePathTextField.getText()) ){
            
            if(read.getScheduleData(filePathTextField.getText(), user )){
        read.getSlots(filePathTextField.getText(), user );
        read.setStageStudentNumber(user);
        JOptionPane.showMessageDialog(null, "Done Successfully ISA");
        }
        else{
            JOptionPane.showMessageDialog(null, "Schedule Already Exists");
        }}
        else{
            JOptionPane.showMessageDialog(null, "The uploaded file in incorrect");  
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_uploadFileButtonActionPerformed

    private void selectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileButtonActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter1 = new FileNameExtensionFilter("xls" ,"Excel File");
        fileChooser.addChoosableFileFilter(filter1);
        FileFilter filter2 = new FileNameExtensionFilter("xlsx","Excel File");
        fileChooser.addChoosableFileFilter(filter2);
        FileFilter filter3 = new FileNameExtensionFilter("XLS","Excel File");
        fileChooser.addChoosableFileFilter(filter3);
        FileFilter filter4 = new FileNameExtensionFilter("XLSX" , "Excel File");
        fileChooser.addChoosableFileFilter(filter4);
        fileChooser.setAcceptAllFileFilterUsed(true);
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            try{
                FileReader reader = new FileReader(filePath);
                BufferedReader br = new BufferedReader(reader);
                filePathTextField.setText(filePath);
                br.close();
                filePathTextField.requestFocus();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
        }
        
    }//GEN-LAST:event_selectFileButtonActionPerformed

    private void filePathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton selectFileButton;
    private javax.swing.JButton uploadFileButton;
    // End of variables declaration//GEN-END:variables

}

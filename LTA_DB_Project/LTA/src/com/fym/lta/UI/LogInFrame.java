
package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.UserBao;
import com.fym.lta.DTO.UserDto;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LogInFrame extends javax.swing.JFrame {
    @SuppressWarnings({ "compatibility:8982616528391956958",
      "oracle.jdeveloper.java.serialversionuid-stale" })
    private static final long serialVersionUID = 1L;

   static boolean run = true;   //when run true this frame will set visible, 
                                //false main frame will set visible
   
   static UserDto user = null;  //create user object 
     
    
     /** Creates new form LogInFrame */
    public LogInFrame() {
        
        initComponents();
        
        //Set frame to the max size of screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setTitle("LTA - LogIn"); //frame tilte
        this.setBackground(Color.white);
     
      
    }
    
    /**if user choose to remember his login
     *set run false (this frame wouldn't be opened)
     *and main frame will open (give it the user)
     *(look to main method)
     * */
    static private void keeplogin()
    {
      
    UserBao user_bao = new BaoFactory().createUserBao();  //create bao object
    
    user = user_bao.Keeplogin(); //check for if previous user keeped his login through keeplogin bao method
    
    System.out.println(Integer.toString(user.getId()));
  
    if(user!=null)  
    {
      if(user.getKeep_login()==1)  //if user keeped his login
      
        run=false;  //set run false
      
    }
      
    }
    

    /** for user logout
     * take user object back from main frame to login frame again
     * */
    public void logout(UserDto user)
    {
      //view user name/pass again
      email_username.setText(user.getUsername());  
      Password.setText(user.getPassword());

      
      //and view his previous choose for keep his login
      if(user.getKeep_login()==1)
        KeepUserLogin.setSelected(true);
      else
        KeepUserLogin.setSelected(false);
      
      //delete user from "keep_user_login" (history)
      user=null; //set user to null
      UserBao user_bao = new BaoFactory().createUserBao();  //user bao object
      user_bao.savelogin(user);
      
      //view login frame
      this.setVisible(true);
    }

    /**login method
     * check if entered user data true or not
     * if user is exist in database open main frame to this user role
     * */
    private void login ()
    {
        try {
          
            // get entered email or user name from  email_username text field
            String email_name = email_username.getText();

            /// String p = Password.getPassword().toString();

            //get entered password
        @SuppressWarnings("deprecation")
        String password = Password.getText();
            //Create dto user object
            user = new UserDto();
          
            //get email or user name
            user.setEmail(email_name);   
            user.setUsername(email_name);
           
            user.setPassword(password);  //get password

            //Check if entered data is existed or not
            UserBao user_bao = new BaoFactory().createUserBao();
            UserDto user_result = new UserDto();
            user_result = user_bao.login(user);  //retured user from bao
          
          
            // if there is a result (usename/email and password correct)
            if (user_result != null) {
              
               //check if user select to keep his login or not
                if(KeepUserLogin.isSelected())
                   user_result.setKeep_login(1);
                else
                   user_result.setKeep_login(0);
                
                user_bao.savelogin(user_result);  //save this user in history
                
                //open main frame (application) for this user role
                Main main_frame = new Main(user_result);
                this.dispose();  //close this frame 
                main_frame.setVisible(true);  //set main frame visible
            }

            // if not show message tell user there is something wrong
            else {

                if (email_name.contains("@")) //if user enter an email address
                    JOptionPane.showMessageDialog(this,
                                                  "The email and password you entered do not match our records",
                                                  "Invalid input",
                                                  JOptionPane.ERROR_MESSAGE);

                else //if user enter a username
                    JOptionPane.showMessageDialog(this,
                                                  "The username and password you entered do not match our records",
                                                  "Invalid input",
                                                  JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}
        
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  private void initComponents()//GEN-BEGIN:initComponents
  {

    jPanel1 = new javax.swing.JPanel();
    login_panel = new javax.swing.JPanel();
    email_username = new javax.swing.JTextField();
    Password = new javax.swing.JPasswordField();
    KeepUserLogin = new javax.swing.JCheckBox();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    logInButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("LTA - login");
    setBackground(new java.awt.Color(255, 255, 255));
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    login_panel.setBackground(new java.awt.Color(255, 255, 255));
    login_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("VIP Rawy Regular", 0, 18))); // NOI18N
    login_panel.setAutoscrolls(true);
    login_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    email_username.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    email_username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    email_username.setText("Email address or username");
    email_username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    email_username.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        email_usernameFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        email_usernameFocusLost(evt);
      }
    });
    email_username.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        email_usernameActionPerformed(evt);
      }
    });
    email_username.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        email_usernameKeyPressed(evt);
      }
    });
    login_panel.add(email_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 475, 30));

    Password.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    Password.setText("Password");
    Password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    Password.addFocusListener(new java.awt.event.FocusAdapter()
    {
      public void focusGained(java.awt.event.FocusEvent evt)
      {
        PasswordFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt)
      {
        PasswordFocusLost(evt);
      }
    });
    Password.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        PasswordActionPerformed(evt);
      }
    });
    Password.addKeyListener(new java.awt.event.KeyAdapter()
    {
      public void keyPressed(java.awt.event.KeyEvent evt)
      {
        PasswordKeyPressed(evt);
      }
    });
    login_panel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 390, 40));

    KeepUserLogin.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    KeepUserLogin.setText("Remember me ");
    KeepUserLogin.setContentAreaFilled(false);
    KeepUserLogin.setFocusPainted(false);
    login_panel.add(KeepUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 154, -1));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_lock_52px.png"))); // NOI18N
    login_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 60, 60));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_visible_24px.png"))); // NOI18N
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        jLabel2MouseClicked(evt);
      }
    });
    login_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, 30));
    login_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 459, 20));
    login_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 459, 10));

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fym/lta/Images/icons8_contacts_64px.png"))); // NOI18N
    login_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 70, 50));

    logInButton1.setBackground(new java.awt.Color(25, 66, 188));
    logInButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    logInButton1.setForeground(new java.awt.Color(255, 255, 255));
    logInButton1.setText("Login");
    logInButton1.setToolTipText("");
    logInButton1.setBorder(null);
    logInButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        logInButton1ActionPerformed(evt);
      }
    });
    login_panel.add(logInButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 160, 48));

    jPanel1.add(login_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 660, 510));

    getContentPane().add(jPanel1);

    getAccessibleContext().setAccessibleName("LTA - LogIn");
    getAccessibleContext().setAccessibleDescription("");

    setSize(new java.awt.Dimension(1935, 854));
    setLocationRelativeTo(null);
  }//GEN-END:initComponents

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        // delete text from textfield when textfield is selected
        
        //if password text contains default text "password" remove it when user focus on it
        if (Password.getText().equalsIgnoreCase("Password")) 
        Password.setText("");
    }//GEN-LAST:event_PasswordFocusGained

    private void email_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_usernameActionPerformed

    }//GEN-LAST:event_email_usernameActionPerformed

    private void email_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_usernameFocusLost
       
       //if email/username field empty and user get focus out on it set default text
       if (email_username.getText().trim().equalsIgnoreCase(""))
        email_username.setText("Email address or username");
    }//GEN-LAST:event_email_usernameFocusLost

    private void email_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_usernameFocusGained
        // delete text from textfield when textfield is selected
        if (email_username.getText().equalsIgnoreCase("Email address or username"))
        email_username.setText("");
    }//GEN-LAST:event_email_usernameFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
    //if password field empty and user get focus out on it set default text "password"
        if (Password.getText().trim().equalsIgnoreCase(""))
         Password.setText("Password");
          
    }//GEN-LAST:event_PasswordFocusLost

    private void email_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email_usernameKeyPressed
       
       //login in when user press enter
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            //Call login Method
            login();
            
        }
        
    }//GEN-LAST:event_email_usernameKeyPressed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
       //login in when user press enter
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            //Call login Method
            login();
        }
    }//GEN-LAST:event_PasswordKeyPressed

  private void PasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_PasswordActionPerformed
  {//GEN-HEADEREND:event_PasswordActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_PasswordActionPerformed

  private void logInButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_logInButton1ActionPerformed
  {//GEN-HEADEREND:event_logInButton1ActionPerformed
    login();
  }//GEN-LAST:event_logInButton1ActionPerformed

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MouseClicked
  {//GEN-HEADEREND:event_jLabel2MouseClicked
    //show password if user select "show password check box"
    if(Password.echoCharIsSet())
      {
        Password.setEchoChar((char) 0);
      }
    //hide password, if it isn't selected
    else
      Password.setEchoChar('*');
  }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(LogInFrame.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(LogInFrame.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(LogInFrame.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(LogInFrame.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    keeplogin();  //check if the previous user keeped his login or not
                    
                    if(run==true || user ==null) //if not run will be true and login frame will open
                      
                    new LogInFrame().setVisible(true);
                    
                    else //if yes run will be false and main frame will open for this user role
                    {
                        Main main_frame = new Main(user);
                        main_frame.setVisible(true);
                    }
                }
            });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox KeepUserLogin;
  private javax.swing.JPasswordField Password;
  private javax.swing.JTextField email_username;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JButton logInButton1;
  private javax.swing.JPanel login_panel;
  // End of variables declaration//GEN-END:variables

}

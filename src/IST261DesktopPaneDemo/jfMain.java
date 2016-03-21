/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IST261DesktopPaneDemo;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author whb108
 * 
 * 
 * 
 ******************* MODIFICATION LOG *****************************************
 * 
 * 2016 February 06 - Added code to dynamically create look and feel menu to
 *                    implement dynamic setting of PLAF. - WHB
 * 
 */
public class jfMain extends JFrame {

    int intWindowCounter = 0;
    ButtonGroup bgLAF = new ButtonGroup();
    
    public Connection dbConnection;
    public DBConnection dbc;
    /**
     * Creates new form jfMain
     */
    public jfMain() 
    {
        initComponents();
        MakeLookAndFeelMenu();
        dbc = new DBConnection(this);
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) 
            {
                try {
                    if (dbConnection != null)
                        dbConnection.close();
                    
                  
                } catch (SQLException ex) {
                    Logger.getLogger(jfMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                  System.exit(0);
            }
        });

    } // no argument constructor

    public void MakeLookAndFeelMenu()
    {
         LookAndFeelInfo[] lfAll = UIManager.getInstalledLookAndFeels();
        
         
        for (LookAndFeelInfo lfAll1 : lfAll) 
        {
           System.out.println("Look and Feel - " + lfAll1.getName() 
              + " Class - " + lfAll1.getClassName());
          JRadioButtonMenuItem jmiTemp = new JRadioButtonMenuItem(); 
          jmiTemp.setText(lfAll1.getName());
          if (UIManager.getLookAndFeel().getName().equalsIgnoreCase(lfAll1.getName()))
          {
             jmiTemp.setSelected(true);
          } // is this the current L&F?
          
           jmiTemp.addActionListener((java.awt.event.ActionEvent evt) -> {
              try {
                 UIManager.setLookAndFeel(lfAll1.getClassName());
                 SwingUtilities.updateComponentTreeUI(this);
                 jbTile.doClick();
         //        this.pack();
                
                 JRadioButtonMenuItem jrbTemp = (JRadioButtonMenuItem)evt.getSource();
                 jrbTemp.setSelected(true);
              } 
              
              catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                 Logger.getLogger(jfMain.class.getName()).log(Level.SEVERE, null, ex);
              }
           });
          bgLAF.add(jmiTemp);
          jmLookAndFeel.add(jmiTemp);
       } // for
    } // MakeLookAndFeelMenu
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpMain = new javax.swing.JDesktopPane();
        jtbMain = new javax.swing.JToolBar();
        jbAddFrame = new javax.swing.JButton();
        jbTile = new javax.swing.JButton(new TileAction(jdpMain));
        jbCourse = new javax.swing.JButton();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiAddFrame = new javax.swing.JMenuItem();
        jmiOpenDB = new javax.swing.JMenuItem(new OpenDatabaseAction(this));
        jmiTestTablePanel = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jmWindows = new javax.swing.JMenu();
        jmiTile = new javax.swing.JMenuItem(new TileAction(jdpMain));
        jmLookAndFeel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpMainLayout = new javax.swing.GroupLayout(jdpMain);
        jdpMain.setLayout(jdpMainLayout);
        jdpMainLayout.setHorizontalGroup(
            jdpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
        );
        jdpMainLayout.setVerticalGroup(
            jdpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jtbMain.setFloatable(false);
        jtbMain.setRollover(true);
        jtbMain.setToolTipText("");

        jbAddFrame.setText("Add");
        jbAddFrame.setToolTipText("Create and add new window");
        jbAddFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddFrameActionPerformed(evt);
            }
        });
        jtbMain.add(jbAddFrame);

        jbTile.setText("Tile");
        jbTile.setToolTipText("");
        jbTile.setFocusable(false);
        jbTile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbTile.setMinimumSize(new java.awt.Dimension(36, 36));
        jbTile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMain.add(jbTile);

        jbCourse.setText("Course");
        jbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCourseActionPerformed(evt);
            }
        });

        jmFile.setMnemonic('F');
        jmFile.setText("File");

        jmiAddFrame.setText("Add Frame");
        jmiAddFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddFrameActionPerformed(evt);
            }
        });
        jmFile.add(jmiAddFrame);

        jmiOpenDB.setText("Open Database");
        jmFile.add(jmiOpenDB);

        jmiTestTablePanel.setText("JTable Test");
        jmiTestTablePanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTestTablePanelActionPerformed(evt);
            }
        });
        jmFile.add(jmiTestTablePanel);

        jmbMain.add(jmFile);

        jmEdit.setText("Edit");
        jmbMain.add(jmEdit);

        jmWindows.setMnemonic('W');
        jmWindows.setText("Window");

        jmiTile.setText("Tile");
        jmWindows.add(jmiTile);

        jmbMain.add(jmWindows);

        jmLookAndFeel.setText("Look And Feel");
        jmbMain.add(jmLookAndFeel);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdpMain)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpMain)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddFrameActionPerformed
        // TODO add your handling code here:
        CreateFrame();
      
        
    }//GEN-LAST:event_jbAddFrameActionPerformed

    private void jmiAddFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddFrameActionPerformed
        // TODO add your handling code here:
        CreateFrame();
    }//GEN-LAST:event_jmiAddFrameActionPerformed

    private void jmiTestTablePanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTestTablePanelActionPerformed
        try 
        {
           System.out.println("Made it to test2");
           Statement stTest = dbConnection.createStatement();
           String strQuery = "Select * from AttendanceCode";
            
           strQuery = (String) JOptionPane.showInputDialog(this, "Enter a query", strQuery);
           ResultSet rsAttendance = stTest.executeQuery(strQuery);
           
           
           int[] arrColsToHide = {0,5,6};
           jpTableDisplay jpDisplay = new jpTableDisplay(rsAttendance,0, arrColsToHide);    
            
            jpDisplay.setPreferredSize(new Dimension(900, 900));
           CreateFrame(jpDisplay, strQuery);
        } catch (SQLException ex) {
            Logger.getLogger(jfMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_jmiTestTablePanelActionPerformed

    private void jbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCourseActionPerformed
        JPanel Course = new jpCourse();
        Course.setName("Course");
        CreateFrame(Course,Course.getName());
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCourseActionPerformed

    private void CreateFrame()
    {
        
        JPanel jpTemp = new JPanel();
        jpTemp.setPreferredSize(new Dimension(200, 200));
       
        CreateFrame(jpTemp,"");
      
      
        
    } // CreateFrame
    
    
    private void CreateFrame(JPanel jpIn, String strIn)
    {
            intWindowCounter++;
        
        JInternalFrame jifTemp = new JInternalFrame("New Frame " 
                + intWindowCounter + " - " + strIn,true,true,true,true);
        
        jifTemp.add(jpIn);
        jifTemp.pack();
        
        jdpMain.add(jifTemp);
        jifTemp.setVisible(true);
       
    }
    
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAddFrame;
    private javax.swing.JButton jbCourse;
    private javax.swing.JButton jbTile;
    private javax.swing.JDesktopPane jdpMain;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmLookAndFeel;
    private javax.swing.JMenu jmWindows;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAddFrame;
    private javax.swing.JMenuItem jmiOpenDB;
    private javax.swing.JMenuItem jmiTestTablePanel;
    private javax.swing.JMenuItem jmiTile;
    private javax.swing.JToolBar jtbMain;
    // End of variables declaration//GEN-END:variables
}

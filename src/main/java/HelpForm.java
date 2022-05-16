

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class HelpForm extends javax.swing.JFrame {

    public HelpForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel mainPanel = new JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        jLabel2.setText("FAQ");
        mainPanel.add(jLabel2);
        jLabel4.setText("Q: How to read articles ?");
        mainPanel.add(jLabel4);
        jLabel5.setText("A: You simply click on the article");
        mainPanel.add(jLabel5);
        jLabel6.setText("Q: How to search for articles ?");
        mainPanel.add(jLabel6);
        jLabel7.setText("A: You simply type in the search bar lel");
        mainPanel.add(jLabel7);
        jLabel8.setText("Q: What does the tag mean ?");
        mainPanel.add(jLabel8);
        jLabel9.setText("A: It works like a filter for different articles when you search");
        mainPanel.add(jLabel9);
        setContentPane(mainPanel);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // GO TO ALL
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

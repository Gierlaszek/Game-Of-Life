/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JFrame;


/**
 *
 * @author kamil
 */

/*
    class start_window - creates a new window with pattern selection buttons
*/
public class start_window extends JFrame {
    /**
     * Creates new form start_window
     */
    public start_window() {
        initComponents();
        buttonGroup1.add(random);
        buttonGroup1.add(queen);
        buttonGroup1.add(tumbler);
        buttonGroup1.add(own);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        random = new javax.swing.JRadioButton();
        queen = new javax.swing.JRadioButton();
        tumbler = new javax.swing.JRadioButton();
        own = new javax.swing.JRadioButton();
        Choose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        random.setText("Random Pattern");

        queen.setText("The Queen Bee Shuttle Pattern");

        tumbler.setText("Tumbler Pattern");

        own.setText("Own Pattern");

        Choose.setText("Choose");
        Choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose initial patterns ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queen)
                            .addComponent(random)
                            .addComponent(tumbler, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(own)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(Choose, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(random)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tumbler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(own)
                .addGap(18, 18, 18)
                .addComponent(Choose)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        open new window with grid 
    */
    private void ChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseActionPerformed
        Enumeration<AbstractButton> buttons = buttonGroup1.getElements();
        int i = 0;
        while(buttons.hasMoreElements() ){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                game_window game = new game_window(thisFrame, i);
                game.setVisible(true);
                game.draw();
            }
            i++;
        }
    }//GEN-LAST:event_ChooseActionPerformed


    private JFrame thisFrame = this;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Choose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton own;
    private javax.swing.JRadioButton queen;
    private javax.swing.JRadioButton random;
    private javax.swing.JRadioButton tumbler;
    // End of variables declaration//GEN-END:variables
}

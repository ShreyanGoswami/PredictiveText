package predictivetext;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Shreyan Shazad
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Database db;

    public NewJFrame() {
        initComponents();
        db = new Database("F:\\notes\\Sem6\\PredictiveText\\database");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setText("Press down arrow to select the list");

        jLabel2.setText("Use right arrow to select word");

        jLabel3.setText("Use left arrow to go back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel3)))))
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN) {
            jList1.requestFocusInWindow();
        } else {
            predict(evt.getKeyChar());
        }
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jList1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyReleased
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                // handle left
                jTextArea1.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
            //case KeyEvent.VK_ENTER:
                // handle right
                String item = jList1.getSelectedValue();
                if (item.equals("") == false) {
                    String sentence = jTextArea1.getText();
                    if (sentence.length() > 0) {
                        char[] words = sentence.toCharArray();

                        StringBuffer currword = new StringBuffer("");
                        int i = words.length - 1;
                        while (i >= 0 && words[i] != ' ') {
                            currword = currword.append(words[i]);
                            i--;
                        }
                        currword = currword.reverse();
                        item = item.substring(currword.length(), item.length()) + " ";
                        System.out.println(item);
                        jTextArea1.append(item);
                        predict(' ');
                        jTextArea1.requestFocus();
                        break;
                    }
                }
        }
    }//GEN-LAST:event_jList1KeyReleased
    private void predict(char ch) {
        if (ch != ' ' && ch != '.') //suggest current word
        {
            String sentence = jTextArea1.getText();
            if (sentence.length() > 0) {
                char[] words = sentence.toCharArray();

                StringBuffer currword = new StringBuffer("");
                int i = words.length - 1;
                while (i >= 0 && words[i] != ' ') {
                    currword = currword.append(words[i]);
                    i--;
                }
                currword = currword.reverse();
                String s = "select word from singles where word like'" + currword + "%' order by count DESC limit 3";
                try {
                    ResultSet rs = db.getData(s);
                    String[] p = new String[1];
                    p[0] = "";
                    jList1.setListData(p);
                    String x = "";
                    while (rs.next()) {
                        x = x + rs.getString("word") + ",";
                    }
                    String[] w = x.split(",");
                    jList1.setListData(w);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else if (ch == ' ') {
            String sentence = jTextArea1.getText();
            String[] words = sentence.split(" ");
            String currword = words[words.length - 1];
            System.out.println(currword);
            String s = "select next from pairs where curr='" + currword + "' order by count DESC limit 3";
            try {
                ResultSet rs = db.getData(s);
                String[] p = new String[1];
                p[0] = "";
                jList1.setListData(p);
                String x = "";
                while (rs.next()) {
                    x = x + rs.getString("next") + ",";
                }
                String[] w = x.split(",");
                jList1.setListData(w);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //suggest next word
        } //create word pairs and single words
        else if (ch == '.') {

            String sentence = jTextArea1.getText();
            sentence = sentence.substring(0, (sentence.length() - 1));
            String[] words = sentence.split(" ");

            String[][] pairs = new String[words.length - 1][2];
            for (int i = 0; i < words.length - 1; i++) {
                pairs[i][0] = words[i];
                pairs[i][1] = words[i + 1];
            }

            for (int i = 0; i < pairs.length; i++) {
                System.out.println(pairs[i][0] + "," + pairs[i][1]);

            }
            for (int i = 0; i < words.length; i++) {
                try {
                    String s = "select word from singles where word='" + words[i] + "'";
                    ResultSet rs = db.getData(s);
                    boolean flag = false;
                    while (rs.next()) {
                        flag = true;
                        break;
                    }
                    if (flag == true) {
                        s = "update singles set count=count+1 where word='" + words[i] + "'";
                        db.modifyDB(s);
                    } else {
                        s = "insert into singles values ('" + words[i] + "','1')";
                        db.modifyDB(s);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //words pairs
            for (int i = 0; i < pairs.length; i++) {
                try {
                    String s = "select curr,next from pairs where curr='" + pairs[i][0] + "' and next='" + pairs[i][1] + "'";
                    ResultSet rs = db.getData(s);
                    boolean flag = false;
                    while (rs.next()) {
                        flag = true;
                        break;
                    }
                    if (flag == true) {
                        s = "update pairs set count=count+1 where curr='" + pairs[i][0] + "' and next='" + pairs[i][1] + "'";
                        db.modifyDB(s);
                    } else {
                        s = "insert into pairs values ('" + pairs[i][0] + "','" + pairs[i][1] + "',1)";
                        db.modifyDB(s);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

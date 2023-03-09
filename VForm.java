package entombedonlymaze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Slam
 */
public class VForm extends javax.swing.JFrame {

    /**
     * Creates new form VForm
     */
    Graphics gr;
    Random rnd = new Random();
    private int xsize;
    private int ysize;
    private int scrollUp;
    private int xaxis;
    private String oldPattern;
    Timer t = new Timer();

    public VForm() {
        initComponents();
        //this.setSize(800, 600);
        gr = jPanel1.getGraphics();
        //scrollUp = jPanel1.getHeight() - ysize;
        scrollUp = ysize;
        xsize = jPanel1.getWidth() / 20;
        ysize = jPanel1.getHeight() / 20;
    }

    public void blackScreen() {
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
    }

    public void retrasar(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    public void secuencia(String secuencia) {
        System.out.println(Integer.parseUnsignedInt(secuencia, 2));
        xaxis = 0;
        if (scrollUp >= jPanel1.getHeight()) {
            scrollUp = 0;
        }
        normal(secuencia);
        reverso(secuencia);
        scrollUp += ysize / 2;
        retrasar(100);
    }

    public void paintPixels() {
        //int rounds = 0;                    
        //if (rounds == 32) break;                
        xaxis = 0;
        if (scrollUp <= 0) {
            scrollUp = jPanel1.getHeight() - ysize;
        }
        //no al 32 sino al 255

        String pattern = Integer.toBinaryString(rnd.nextInt(255));
        if (pattern.equals(oldPattern)) {
            paintPixels();
        }
        oldPattern = pattern;
        System.out.println("Creado: " + pattern);
        //System.out.println(jPanel1.getWidth()+","+jPanel1.getHeight());

        normal(pattern);
        reverso(pattern);
        //reverso(pattern);
        //normal(pattern);
        retrasar(100);
        //rounds++;
        System.out.println("");
        scrollUp = scrollUp - ysize;
    }

    private void normal(String pattern) {
        for (int idx = 0; idx < pattern.length(); idx++) {
            //System.out.print(pattern.charAt(idx) + " ");
            if (pattern.charAt(idx) == '0') {
                gr.setColor(Color.BLACK);
                gr.fillRect(xaxis, scrollUp, xsize, ysize);
            } else {
                gr.setColor(Color.WHITE);
                gr.fillRect(xaxis, scrollUp, xsize, ysize);
            }
            xaxis += xsize;
        }
        int sl = pattern.length();

        if (sl <= 9) {
            for (int idx = 0; idx < 10 - sl; idx++) {
                if (idx % 2 == 0) {
                    gr.setColor(Color.WHITE);
                    gr.fillRect(xaxis += xsize, scrollUp, xsize, ysize);
                } else {
                    gr.setColor(Color.BLACK);
                    gr.fillRect(xaxis += xsize, scrollUp, xsize, ysize);
                }
                //System.out.print("0 ");
            }
        }
    }

    private void reverso(String pattern) {
        if (pattern.length() <= 9) {
            for (int revIdx = 0; revIdx < 10 - pattern.length(); revIdx++) {
                if (revIdx % 2 == 0) {
                    gr.setColor(Color.WHITE);
                    gr.fillRect(xaxis += xsize, scrollUp, xsize, ysize);
                } else {
                    gr.setColor(Color.BLACK);
                    gr.fillRect(xaxis += xsize, scrollUp, xsize, ysize);
                }
                //System.out.print("0 ");
            }
        }
        for (int revIdx = pattern.length() - 1; revIdx >= 0; revIdx--) {
            //System.out.print(pattern.charAt(revIdx) + " ");
            if (pattern.charAt(revIdx) == '0') {
                gr.setColor(Color.BLACK);
                gr.fillRect(xaxis, scrollUp, xsize, ysize);
            } else {
                gr.setColor(Color.WHITE);
                gr.fillRect(xaxis, scrollUp, xsize, ysize);
            }
            xaxis += xsize;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entombed");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(240, 320));
        setPreferredSize(new java.awt.Dimension(240, 320));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Maze"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String[] sec = "1111101111,1100001001,1101101101,1100001110,1101111101,1100010000,1101111111,1111000001,1101101101,1101000001,1101101101,1101000101".split(",");
        if (t != null) {
            blackScreen();
            t.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    //paintPixels();
                    String cad = Integer.toBinaryString(rnd.nextInt(64));
                    int size = cad.length();
                    if (size <= 8) {
                        secuencia("11" + cad);
                    } else if (size == 9) {
                        secuencia("11" + cad.substring(0, size - 1));
                    } else {
                        secuencia("11" + cad.substring(0, size - 2));
                    }
                    /*for (String str : sec) {
                     secuencia(str);
                     }*/
                }
            }, 0, 120);
        }

    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        System.exit(0);
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "An approach to Entombed maze generator of Atari 2600\nMade by Allan Ayes (08/03/2023)");
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
            java.util.logging.Logger.getLogger(VForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}

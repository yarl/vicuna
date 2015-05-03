package cuploader.frames;

import cuploader.Data;
import cuploader.PFile;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.*;

public final class FFileLoading extends javax.swing.JFrame {
    private ArrayList<File> files = null;   
    private volatile boolean stopRq = false;
    private double start, sum = 0.0;
    
    ArrayList<Boolean> fEdit = null;
    ArrayList<Boolean> fUpload = null;
    ArrayList<String> fName = null;
    ArrayList<String> fDate = null;
    ArrayList<String> fDesc = null;
    ArrayList<String> fCoor = null;
    ArrayList<String> fCats = null;
    
    private ArrayList<Map> sessionFiles;
    
    public FFileLoading(ArrayList<File> fPath, ArrayList<Boolean> fEdit, ArrayList<Boolean> fUpload, ArrayList<String> fName, 
            ArrayList<String> fDate, ArrayList<String> fDesc, ArrayList<String> fCoor, ArrayList<String> fCats) {
        this.files = fPath;
        this.fEdit = fEdit;
        this.fUpload = fUpload;
        this.fName = fName;
        this.fDate = fDate;
        this.fDesc = fDesc;
        this.fCoor = fCoor;
        this.fCats = fCats;

        initComponents();
        setLocationRelativeTo(null);
        
        //focus to 'hide'
        getRootPane().setDefaultButton(bHide); 
        bHide.requestFocus();  
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        startRead(true);
    }
    
    public FFileLoading(ArrayList<File> files) {
        this.files = files;
        
        initComponents();
        setLocationRelativeTo(null);
        
        //focus to 'hide'
        getRootPane().setDefaultButton(bHide); 
        bHide.requestFocus();  
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        startRead(false);
    }
    
    public FFileLoading(ArrayList<Map> files_, boolean hack) {
        this.sessionFiles = files_;
        
        files = new ArrayList<File>();
        for(Map m : files_) {
          File f = new File((String)m.get("path"));
          files.add(f);
        }
        
        initComponents();
        setLocationRelativeTo(null);
        
        //focus to 'hide'
        getRootPane().setDefaultButton(bHide); 
        bHide.requestFocus();  
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        startRead(true);
    }
            
    private void startRead(final boolean isLoadingSession) {
        if(isLoadingSession) {
            Data.getFiles().clear();
            Main.pFiles.removeAll();
            Main.pFiles.repaint();
        }
  
        Progress.setMinimum(0);
        Progress.setMaximum(files.size());
        
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Progress.setIndeterminate(false);
                DecimalFormat df = new DecimalFormat("#.##");
                
                int i = 0;
                for(File file : files) {
                    if(!stopRq) {
                        start = System.nanoTime(); 
                        lName.setText(bundle.getString("loading") + " " + (i+1) + " / " + files.size() + ": " + file.getName() + 
                                " (" + df.format(9.5367e-7*file.length()) + " MiB)");
                        lName.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/ui-progress-bar-indeterminate.gif")));
                        
                        PFile f;
                        if(isLoadingSession) {
                          if(sessionFiles==null)
                            f = new PFile(file, Data.getFiles().size(), fUpload.get(i), fEdit.get(i), fName.get(i), fDesc.get(i),
                                                  fDate.get(i), fCats.get(i), fCoor.get(i));
                          else
                            f = new PFile(file, Data.getFiles().size(), false, false, (String)sessionFiles.get(i).get("name"),
                                    (String)sessionFiles.get(i).get("desc"), (String)sessionFiles.get(i).get("date"), (String)sessionFiles.get(i).get("cats"), "");
                        } else
                            f = new PFile(file, Data.getFiles().size());
                        
                        Data.addPanel(f);
                        Progress.setValue(i+1);
                        ++i;
                        double end = ((System.nanoTime()-start)/1000.0/1000.0/1000.0);
                        sum += end;
                        //System.out.println(file.getName() + ": " + end);
                    }
                }
                Progress.setIndeterminate(true);
                stopRead();
                
                for(PFile file : Data.getFiles()) {
                  file.generateThumbnail();
                }
            }
        };
        
         
        Thread t = new Thread(run);
        t.start();
    }
    
    private void stopRead() {
        Data.isLoadSession=false;
        stopRq = true;
        //System.out.println("Łącznie: " + sum + ", średnio: " + sum/files.size());
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bStop = new javax.swing.JButton();
        bHide = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Progress = new javax.swing.JProgressBar();
        lName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("loading")); // NOI18N
        setResizable(false);

        bStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/cross.png"))); // NOI18N
        bStop.setText(bundle.getString("button-stop")); // NOI18N
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStopActionPerformed(evt);
            }
        });

        bHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-circle-135-left.png"))); // NOI18N
        bHide.setText(bundle.getString("button-hide")); // NOI18N
        bHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHideActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Progress.setIndeterminate(true);

        lName.setText("Wczytuję...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Progress, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(lName)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                        .addComponent(bHide))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bStop)
                    .addComponent(bHide))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStopActionPerformed
        stopRead();
    }//GEN-LAST:event_bStopActionPerformed

    private void bHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHideActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bHideActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Progress;
    private javax.swing.JButton bHide;
    private javax.swing.JButton bStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lName;
    // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }; 
}

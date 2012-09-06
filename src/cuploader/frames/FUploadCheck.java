package cuploader.frames;

import cuploader.Data;
import cuploader.Data.Elem;
import cuploader.PFile;
import cuploader.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.*;

public class FUploadCheck extends javax.swing.JFrame {
    Data data;
    
    private volatile boolean stopRq = false;
    boolean locNames = true;
    boolean locNamesDupe = true;
            
    public FUploadCheck(Data data) {
        this.data = data;
        initComponents();
        setLocationRelativeTo(null);
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        startCheck();
    }
    
    private void startCheck() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //clear extra extention
                for(PFile file : Data.getFiles()) {
                    if(file.toUpload) {
                        String text = file.getComponent(Elem.NAME);
                        if(text.endsWith(".jpg")||text.endsWith(".png")||text.endsWith(".gif")||text.endsWith(".pdf")||text.endsWith(".djvu"))
                            file.setComponent(Elem.NAME, text.substring(0, text.lastIndexOf('.')));
                    }   
                }
                
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/ui-progress-bar-indeterminate.gif")));
                int i = 0;
                //check IMG* / DSCF* names
                for(PFile file : Data.getFiles()) {
                    if(file.toUpload && file.getComponent(Elem.NAME).matches("(DSCF).*||(IMG).*")) {
                        locNames = false;
                        jLabel1.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
                        tResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/exclamation.png")));
                        tResults.setText(bundle.getString("uploadcheck-error-dscf"));
                        break;
                    }
                        
                }
                //check unique names at PC
                if(locNames) {
                    for(i=0; i<Data.getFiles().size(); ++i) {
                        for(int j=0; j<i; ++j) {
                            if(Data.getFiles().get(i).toUpload && Data.getFiles().get(j).toUpload && Data.getFiles().get(j).getComponent(Elem.NAME).equals(Data.getFiles().get(i).getComponent(Elem.NAME))) {
                                locNames = false;
                                jLabel1.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
                                tResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/exclamation.png")));
                                tResults.setText(bundle.getString("uploadcheck-error-dupe"));
                                break;
                            }
                        }
                    }
                }

                //check unique names on internet
                if(locNames && locNamesDupe) {
                    jLabel1.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/tick.png")));
                    jLabel2.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/ui-progress-bar-indeterminate.gif")));
                    ArrayList<String> cont = new ArrayList<String>();
                    for(PFile file : Data.getFiles()) {
                        if(file.toUpload) {
                            String name = file.getComponent(Elem.NAME);
                            if(name.endsWith(" "))
                                name = name.substring(0, name.length()-1);
                            name = name.replace("  ", " ");
                            name += "." + file.getComponent(Elem.EXT);
                    
                            cont.add(name);
                        }
                    }
                    String dupes = "";
                    try {
                        for(String file : cont) {
                            boolean info = Settings.wiki.isPageExist(file);
                            if(info) dupes += file+", ";
                        }
                    } catch (IOException ex) {}
                    
                    if(!dupes.equals("")) {
                        jLabel2.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
                        tResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/exclamation.png")));
                        tResults.setText(bundle.getString("uploadcheck-error-exists") + ": " + dupes);
                    } else {                     
                        jLabel2.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/tick.png")));
                        tResults.setText(bundle.getString("uploadcheck-ok"));
                        bUpload.setEnabled(true);
                        bUpload.requestFocus();  
                    }
                }
                stopCheck();
            }
        };
        
        Thread t = new Thread(run);
        t.start();
    }
    
    private void stopCheck() {
        stopRq = true;
    }
    
    private void startUpload() {
        if(!Data.isLogged) {
            new FLogin(data);
        } else {
            setVisible(false);
            ArrayList<PFile> list = new ArrayList<PFile>();
            for(PFile file : Data.getFiles())
                if(file.toUpload) {
                   list.add(file);
                   //System.out.print("Dodane: " + file.getComponent(Elem.NAME));
                }
            new FUpload(list);
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bUpload = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tResults = new javax.swing.JLabel();
        bFix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("upload-uploading")); // NOI18N
        setResizable(false);

        bUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/tick.png"))); // NOI18N
        bUpload.setText(bundle.getString("uploadcheck-button-upload")); // NOI18N
        bUpload.setEnabled(false);
        bUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUploadActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/-spacer.png"))); // NOI18N
        jLabel1.setText(bundle.getString("uploadcheck-check-names") + "...");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/-spacer.png"))); // NOI18N
        jLabel2.setText(bundle.getString("uploadcheck-check-server") + "...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tResults, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tResults, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bFix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-circle-135-left.png"))); // NOI18N
        bFix.setText(bundle.getString("uploadcheck-button-fix")); // NOI18N
        bFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bFix)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bUpload))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bFix, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUploadActionPerformed
        startUpload();
        dispose();
        Main.fUploadCheck = null;
    }//GEN-LAST:event_bUploadActionPerformed

    private void bFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFixActionPerformed
        dispose();
        Main.fUploadCheck = null;
    }//GEN-LAST:event_bFixActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFix;
    private javax.swing.JButton bUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tResults;
    // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            Main.fUploadCheck = null;
        }
    }; 
}

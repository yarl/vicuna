package cuploader.frames;

import cuploader.Data;
import cuploader.Data.Elem;
import cuploader.PFile;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.wikipedia.Wiki;

public class FUploadCheck extends javax.swing.JFrame {
    Data data;
    int problems = 0;
    
    volatile boolean stopRq = false;
    ArrayList<String> files;
    DefaultTableModel model = new DefaultTableModel();
    
    boolean locNames = true;
    boolean locNamesDupe = true;
    
    String blacklistRegexp;
            
    public FUploadCheck(Data data) {
        this.data = data;
        
        addWindowListener(exit);
        initComponents();
        setLocationRelativeTo(null);
        
        model.addColumn(Data.text("file-name"));
        model.addColumn(Data.text("uploadcheck-error"));
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        blacklistRegexp = fetchBlacklist();

        files = loadFiles();
        startCheck();
    }
    
    private ArrayList<String> loadFiles() {
        ArrayList<String> list = new ArrayList<String>();
        String name, ext;
        
        for(PFile file : Data.getFiles()) {
            if(file.toUpload) {
                name = file.getComponent(Elem.NAME);
                ext = file.getComponent(Elem.EXT);
                
                //cleaning
                if(name.endsWith(" ")) 
                    name = name.substring(0, name.length()-1);
                file.setName(name.replace("  ", " "));
                
                //extra ext
                if(name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")||name.endsWith(".pdf")||name.endsWith(".djvu")) {
                    name = name.substring(0, name.lastIndexOf('.'));
                    file.setName(name);
                }
                
                //add
                name += "." + ext;
                list.add(name);
            }
        }
        return list;
    }
    
    private String fetchBlacklist() {
        String regexp = "";
        try {
            // TODO: replace with Data.settings.server after checking behaviour when there is no local blacklist on wiki
            List<String> pages = List.of("MediaWiki:Filename-prefix-blacklist");
            String prefixes = Wiki.newSession("commons.wikimedia.org").getPageText(pages).get(0);
            String[] prefixesList = prefixes.replaceAll("(?m)#.*", "").trim().split("\\s+");
            for (String prefix : prefixesList) {
                regexp += prefix + "|";
            }
            if(regexp.endsWith("|")) {
                regexp = regexp.substring(0, regexp.length() - 1);
            } 
            regexp = "^(" + regexp + ").*";
        } catch (IOException ex) {
        }
        return regexp;
    }

    private void checkIfExists(PFile file) {
        String name = file.getComponent(Elem.NAME);
        String ext = file.getComponent(Elem.EXT);

        boolean[] exists = new boolean[1];
        try {
            exists = Wiki.newSession(Data.settings.server).exists(List.of("File:" + name + "." + ext));
        } catch (IOException ex) {
        }

        if (exists[0]) {
            model.addRow(new Object[]{name, Data.text("uploadcheck-error-exists")});
        }
    }

    private void checkPrefixBlacklist(PFile file) {
        String name = file.getComponent(Elem.NAME);

        if (name.matches(blacklistRegexp)) {
            model.addRow(new Object[]{name, Data.text("uploadcheck-error-dscf")});
        }
    }

    private void checkGPS(PFile file) {
        String name = file.getComponent(Elem.NAME);
        if (file.getComponent(Elem.COOR).isEmpty()) {
            model.addRow(new Object[]{name, Data.text("uploadcheck-error-gps")});
        }
    }

    private void checkUniqueNames(PFile file) {
        String name = file.getComponent(Elem.NAME);
        String ext = file.getComponent(Elem.EXT);

        Integer count = 0;

        for (String fileName : files) {
            if (fileName.equals(name + "." + ext)) {
                count++;
            }
        }

        if (count > 1) {
            model.addRow(new Object[]{name, Data.text("uploadcheck-error-dupe")});
        }
    }
    
    private void startCheck() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (PFile file : Data.getFiles()) {
                    if (file.toUpload) {
                        if(Data.settings.checkPrefixBlacklist) {
                            checkPrefixBlacklist(file);
                        }
                        
                        if(Data.settings.checkIfExists) {
                            checkIfExists(file);
                        }
                        
                        if(Data.settings.checkGPS) {
                            checkGPS(file);
                        }
                        
                        if(Data.settings.checkUniqueNames) {
                            checkUniqueNames(file);
                        }
                    }
                }

                //summary
                if (model.getRowCount() > 0) {
                    tProgress.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/exclamation.png")));
                    tProgress.setText(Data.text("uploadcheck-errors") + ": " + model.getRowCount());
                    bUpload.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/exclamation.png")));
                    bUpload.setEnabled(true);
                } else {
                    tProgress.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/tick.png")));
                    tProgress.setText(Data.text("uploadcheck-ok"));
                    bUpload.setEnabled(true);
                    bUpload.requestFocus();
                }
                stopCheck();
            }
        };

        Thread t = new Thread(run);
        t.setName("FUploadCheck");
        t.start();
    }
    
    private void stopCheck() {
        stopRq = true;
    }
    
    private void startUpload() {
        if(!Data.isLoggedIn()) {
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
        tProgress = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        tProgress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/-spacer.png"))); // NOI18N
        tProgress.setText(bundle.getString("uploadcheck-checks-running") + "...");

        jTable1.setModel(model);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tProgress)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bFix)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bUpload)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFix, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUploadActionPerformed
        startUpload();
        dispose();
        Data.fUploadCheck = null;
    }//GEN-LAST:event_bUploadActionPerformed

    private void bFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFixActionPerformed
        dispose();
        Data.fUploadCheck = null;
    }//GEN-LAST:event_bFixActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFix;
    private javax.swing.JButton bUpload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tProgress;
    // End of variables declaration//GEN-END:variables

    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            Data.fUploadCheck = null;
        }
        static final long serialVersionUID = -7671854455507221107L;
    }; 
    
    WindowListener exit = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            dispose();
            Data.fUploadCheck = null;
        }
    };

    static final long serialVersionUID = -4077266583844917305L;
}

package cuploader.frames;

import cuploader.Data.Elem;
import cuploader.*;
import cuploader.fixes.TransferFocus;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javax.swing.*;

public class FFileEdit extends javax.swing.JFrame {
    public Coord coor;
    public FCoord fCoord;
    
    //category hints
    CategoryHint ch;
    String prevCategory = "";
    
    public FFileEdit() {
        initComponents();
        setLocationRelativeTo(null);
        TransferFocus.patch(tDesc);
        
        cNameMethod.setSelectedIndex(2);
        setVisible(true);
        
        Data.ctrlPress = Data.shiftPress = false;
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mCatHint = new javax.swing.JPopupMenu();
        Panel = new javax.swing.JPanel();
        lName = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        lDate = new javax.swing.JLabel();
        tDate = new javax.swing.JTextField();
        lCoor = new javax.swing.JLabel();
        tCoor = new javax.swing.JLabel();
        jScrollPane1 = new cuploader.fixes.PDControlScrollPane();
        tDesc = new javax.swing.JTextArea();
        lDesc = new javax.swing.JLabel();
        lCategories = new javax.swing.JLabel();
        tCategories = new javax.swing.JTextField();
        lInfo = new javax.swing.JLabel();
        bSetCoor = new javax.swing.JButton();
        cCategoriesMethod = new javax.swing.JComboBox();
        cNameMethod = new javax.swing.JComboBox();
        cNum = new javax.swing.JCheckBox();
        lNumFormat = new javax.swing.JLabel();
        tNumFormat = new javax.swing.JTextField();
        lNumStart = new javax.swing.JLabel();
        tNumStart = new javax.swing.JSpinner();
        tDigits = new javax.swing.JSpinner();
        lDigits = new javax.swing.JLabel();
        cUpload = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        bClearCoor = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        bApply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("fileedit")); // NOI18N
        setResizable(false);

        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        lName.setText(bundle.getString("file-name")); // NOI18N

        lDate.setText(bundle.getString("file-date")); // NOI18N

        lCoor.setText(bundle.getString("file-coor")); // NOI18N

        tCoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/geolocation.png"))); // NOI18N

        tDesc.setColumns(20);
        tDesc.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tDesc.setLineWrap(true);
        tDesc.setRows(5);
        jScrollPane1.setViewportView(tDesc);

        lDesc.setText(bundle.getString("file-desc")); // NOI18N

        lCategories.setText(bundle.getString("file-cats")); // NOI18N
        lCategories.setToolTipText("");

        tCategories.setToolTipText("Kategorie dla pliku, oddziel średnikiem");
        tCategories.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tCategoriesCaretUpdate(evt);
            }
        });
        tCategories.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tCategoriesFocusGained(evt);
            }
        });

        lInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        lInfo.setText(bundle.getString("fileedit-info")); // NOI18N

        bSetCoor.setText(bundle.getString("fileedit-insert")); // NOI18N
        bSetCoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSetCoorActionPerformed(evt);
            }
        });

        cCategoriesMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("fileedit-append"), bundle.getString("fileedit-prepend"), bundle.getString("fileedit-overwrite")}));
        cCategoriesMethod.setToolTipText("Metoda wstawienia kategorii");

        cNameMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("fileedit-append"), bundle.getString("fileedit-prepend"), bundle.getString("fileedit-overwrite")}));
        cNameMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameMethodActionPerformed(evt);
            }
        });

        cNum.setSelected(true);
        cNum.setText(bundle.getString("fileedit-num")); // NOI18N
        cNum.setEnabled(false);
        cNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNumActionPerformed(evt);
            }
        });

        lNumFormat.setText(bundle.getString("fileedit-num-format")); // NOI18N
        lNumFormat.setToolTipText("<html>" + java.util.ResourceBundle.getBundle("cuploader/text/messages").getString("fileedit-num-format-tooltip") + "</html>");

        tNumFormat.setText(Settings.numFormat);
        tNumFormat.setEnabled(false);

        lNumStart.setText(bundle.getString("fileedit-num-start")); // NOI18N

        tNumStart.setEnabled(false);
        tNumStart.setValue(1);

        tDigits.setModel(new SpinnerNumberModel(Settings.numDigits, 1, 5, 1));
        tDigits.setEnabled(false);
        tDigits.setValue(Settings.numDigits);

        lDigits.setText(bundle.getString("fileedit-num-digits")); // NOI18N

        cUpload.setSelected(true);
        cUpload.setText(bundle.getString("edit-select")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bClearCoor.setText(bundle.getString("button-clear")); // NOI18N
        bClearCoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearCoorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cUpload)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                .addComponent(tNumStart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                .addComponent(lDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tNumFormat)))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(tName))))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cNameMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lCoor, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addComponent(bClearCoor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSetCoor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tDate)
                            .addComponent(tCoor, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                    .addComponent(lInfo)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(tCategories)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCategoriesMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNumFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lNumStart, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cUpload)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tName)
                            .addComponent(lDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tDate)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(tCoor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(bSetCoor)
                                            .addComponent(bClearCoor))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lCoor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cNameMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lNumFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tNumFormat))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tNumStart)
                                                .addComponent(tDigits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lNumStart, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCategoriesMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/tick.png"))); // NOI18N
        bSave.setText(bundle.getString("button-save")); // NOI18N
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/cross.png"))); // NOI18N
        bCancel.setText(bundle.getString("button-cancel")); // NOI18N
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-circle-135-left.png"))); // NOI18N
        bApply.setText(bundle.getString("button-apply")); // NOI18N
        bApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bApplyActionPerformed(evt);
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
                        .addComponent(bCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                        .addComponent(bApply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave))
                    .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSave)
                    .addComponent(bApply, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        bApplyActionPerformed(evt);
        dispose();
    }//GEN-LAST:event_bSaveActionPerformed

    private void bApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bApplyActionPerformed
        Settings.numFormat = tNumFormat.getText();
        Settings.numDigits = Integer.parseInt(tDigits.getValue().toString());
        Replace();
    }//GEN-LAST:event_bApplyActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bSetCoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSetCoorActionPerformed
        if(fCoord==null) fCoord = new FCoord(0, true);
        else fCoord.setVisible(true);
    }//GEN-LAST:event_bSetCoorActionPerformed

    private void cNameMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameMethodActionPerformed
        if(cNameMethod.getSelectedIndex()==2) {
            cNum.setEnabled(true);
            cNumActionPerformed(evt);
        }
        else {
            cNum.setEnabled(false);
            tNumFormat.setEnabled(false);
            tNumStart.setEnabled(false);
            tDigits.setEnabled(false);
        }
    }//GEN-LAST:event_cNameMethodActionPerformed

    private void cNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNumActionPerformed
        boolean b = cNum.isSelected();
        tNumFormat.setEnabled(b);
        tNumStart.setEnabled(b);
        tDigits.setEnabled(b);
    }//GEN-LAST:event_cNumActionPerformed

    private void tCategoriesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tCategoriesCaretUpdate
        showCategoryHints(false);
    }//GEN-LAST:event_tCategoriesCaretUpdate

    private void tCategoriesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCategoriesFocusGained
        showCategoryHints(true);
    }//GEN-LAST:event_tCategoriesFocusGained

    private void bClearCoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearCoorActionPerformed
        fCoord = null;
        coor = null;
        tCoor.setText("");
    }//GEN-LAST:event_bClearCoorActionPerformed
    
    private void showCategoryHints(boolean b) {
        String cat = CategoryHint.getCategory(tCategories);
        if(!prevCategory.equals(cat)) {
            if(ch==null) {
                ch = new CategoryHint(mCatHint, tCategories);
                ch.start();
            } else if(ch!=null && ch.isEnd()) {
                ch.stop = true;
                ch = new CategoryHint(mCatHint, tCategories);
                ch.start();
            } else {
                ch.restart();
            }
            prevCategory = cat;
        } else {
            if(b) {
                mCatHint.show(tCategories, 0, tCategories.getHeight());
                tCategories.requestFocus();
            }
        }
    }
    
    private void Replace() {
        int nr = 1;
        Integer n = Integer.parseInt(tNumStart.getValue().toString());
        
        for(PFile file : Data.getFiles()) {
            if(file.toEdit && file.editable) {
                if(cUpload.isSelected()) file.selectToUpload(true);
                
                //name
                if(!tName.getText().isEmpty()) {
                    switch(cNameMethod.getSelectedIndex()) {
                        case 0: //append
                            if(!file.getComponent(Elem.NAME).matches(".*"+tName.getText())) {
                                String s = file.getComponent(Elem.NAME)+tName.getText();
                                s.replace(";;", ";");
                                file.setComponent(Elem.NAME, s);
                            }
                            break;
                        case 1: //prepend
                            if(!file.getComponent(Elem.NAME).startsWith(tName.getText())) {
                                String s = tName.getText()+file.getComponent(Elem.NAME);
                                s.replace(";;", ";");
                                file.setComponent(Elem.NAME, s);
                            }
                            break;
                        case 2: //overwrite
                            if(cNum.isSelected()) {
                                //digits
                                String pattern = "";
                                for(int i=0; i<Integer.parseInt(tDigits.getValue().toString()); ++i)
                                    pattern += "0";
                                DecimalFormat df = new DecimalFormat(pattern);
                                
                                //rest
                                String text = tNumFormat.getText();
                                text = text.replace("%NAME%", tName.getText());
                                
                                text = text.replace("%N%", df.format(n));
                                file.setComponent(Elem.NAME, text);
                                n++;
                            } else
                                file.setComponent(Elem.NAME, tName.getText());
                            break;
                        default:
                    }
                    //file.changeComponent(Elem.NAME, tName.getText() + " (0" + nr + ")");
                    //++nr;
                }
                //date
                if(!tDate.getText().isEmpty()) 
                    file.setComponent(Elem.DATE, tDate.getText());
                //coor
                if(coor!=null) {
                    file.coor = coor;
                    file.setComponent(Elem.COOR, coor.getDMSformated());
                }
                //desc
                if(!tDesc.getText().isEmpty()) 
                    file.setComponent(Elem.DESC, tDesc.getText());
                //cats
                if(!tCategories.getText().isEmpty()) {
                    switch(cCategoriesMethod.getSelectedIndex()) {
                        case 0: //append
                            if(!file.getComponent(Elem.CATS).equals("")) {
                                String cats = file.getComponent(Elem.CATS);
                                String[] c = cats.split(";");
                                String[] c2 = tCategories.getText().split(";");
                                boolean b;
                                for(int i=0;i<c2.length;++i) {
                                    b = true;
                                    for(int j=0; j<c.length; ++j)
                                        if(c2[i].equals(c[j]))
                                            b = false;
                                    if(b)
                                        cats += ";" + c2[i];
                                }
                                file.setComponent(Elem.CATS, cats);
                            } else
                               file.setComponent(Elem.CATS, tCategories.getText()); 
                            break;
                        case 1: //prepend
                            if(!file.getComponent(Elem.CATS).equals("")) {
                                String cats = "";
                                String[] c = file.getComponent(Elem.CATS).split(";");
                                String[] c2 = tCategories.getText().split(";");
                                boolean b;
                                for(int i=0;i<c2.length;++i) {
                                    b = true;
                                    for(int j=0; j<c.length; ++j)
                                        if(c2[i].equals(c[j]))
                                            b = false;
                                    if(b)
                                        cats += c2[i] + ";";
                                }
                                file.setComponent(Elem.CATS, cats + file.getComponent(Elem.CATS));
                            } else
                                file.setComponent(Elem.CATS, tCategories.getText());
                            break;
                        case 2: //overwrite
                            file.setComponent(Elem.CATS, tCategories.getText());
                            break;
                        default:
                    }
                } 
            }
        }
        Data.ctrlPress = Data.shiftPress = false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton bApply;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bClearCoor;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSetCoor;
    private javax.swing.JComboBox cCategoriesMethod;
    private javax.swing.JComboBox cNameMethod;
    private javax.swing.JCheckBox cNum;
    private javax.swing.JCheckBox cUpload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lCategories;
    private javax.swing.JLabel lCoor;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lDesc;
    private javax.swing.JLabel lDigits;
    private javax.swing.JLabel lInfo;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lNumFormat;
    private javax.swing.JLabel lNumStart;
    private javax.swing.JPopupMenu mCatHint;
    private javax.swing.JTextField tCategories;
    public javax.swing.JLabel tCoor;
    private javax.swing.JTextField tDate;
    private javax.swing.JTextArea tDesc;
    private javax.swing.JSpinner tDigits;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tNumFormat;
    private javax.swing.JSpinner tNumStart;
    // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };
}

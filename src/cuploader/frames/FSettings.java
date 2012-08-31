package cuploader.frames;

import cuploader.Data;
import cuploader.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ResourceBundle;
import javax.swing.*;

public class FSettings extends javax.swing.JFrame {

    public FSettings() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        //FILE
        if(!Settings.author.equals("own")) {
            rOtherAuthor.setSelected(true);
            tOtherAuthor.setText(Settings.author);
            tOtherAuthor.setEnabled(true);
        }
        
        tSource.setText(Settings.source);
        
        String[] lic = new String[Data.licenses.size()];
        for(int i=0;i<Data.licenses.size();++i)
            lic[i] = Data.licenses.get(i);
        cLicense.setModel(new DefaultComboBoxModel(lic));
        
        if(Settings.license == Data.licenses.size()-1) {
            cLicense.setSelectedIndex(Data.licenses.size()-1);
            tLicense.setEditable(true);
            tLicense.setText(Settings.licenseCustom/*Data.licensesTemplates.get(Data.licenses.size()-1)*/);
        } else {
            cLicense.setSelectedIndex(Settings.license);
        }

        tAttrib.setText(Settings.attrib);
        tCategories.setText(Settings.categories);
        tExtraText.setText(Settings.extratext);
        
        //GALLERY
        cCreateGallery.setSelected(Settings.createGallery);
        cCreateGalleryActionPerformed(new ActionEvent(this, 0, null));
        tGalleryPage.setText(Settings.galleryPage);
        tGalleryHeader.setSelectedIndex(Settings.galleryHeader);
        tGalleryWidth.setValue(Settings.galleryWidth);
        
        //PROGRAM
        cReadHour.setSelected(Settings.readExifHour);
        cLoadSubdirectory.setSelected(Settings.loadSubdirectory);
        
        cRenameAfterUpload.setSelected(Settings.renameAfterUpload);
        cAskQuit.setSelected(Settings.askQuit);
        
        cFileDescSource.setSelectedIndex(Settings.fileDescSource);
        if(Settings.fileDescPath==null)
            tFileDesc.setText(bundle.getString("settings-program-descfile-noselected"));
        else
            tFileDesc.setText(Settings.fileDescPath);

        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bSave = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pFile = new javax.swing.JPanel();
        lAuthor = new javax.swing.JLabel();
        rOwnWork = new javax.swing.JRadioButton();
        rOtherAuthor = new javax.swing.JRadioButton();
        tOtherAuthor = new javax.swing.JTextField();
        cLicense = new javax.swing.JComboBox();
        lLicense = new javax.swing.JLabel();
        tLicense = new javax.swing.JTextField();
        tAttrib = new javax.swing.JTextField();
        lAttrib = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tCategories = new javax.swing.JTextField();
        lExtraText = new javax.swing.JLabel();
        tExtraTextScroll = new javax.swing.JScrollPane();
        tExtraText = new javax.swing.JTextArea();
        tSource = new javax.swing.JTextField();
        lSource = new javax.swing.JLabel();
        pGallery = new javax.swing.JPanel();
        cCreateGallery = new javax.swing.JCheckBox();
        lGalleryPage = new javax.swing.JLabel();
        tGalleryPage = new javax.swing.JTextField();
        lGalleryHeader = new javax.swing.JLabel();
        tGalleryHeader = new javax.swing.JComboBox();
        lGalleryWidth = new javax.swing.JLabel();
        tGalleryWidth = new javax.swing.JSpinner();
        pProgram = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cReadHour = new javax.swing.JCheckBox();
        cLoadSubdirectory = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        cRenameAfterUpload = new javax.swing.JCheckBox();
        cAskQuit = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        cFileDescSource = new javax.swing.JComboBox();
        lFileDescSource = new javax.swing.JLabel();
        tFileDesc = new javax.swing.JLabel();
        bSetFileDesc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("settings")); // NOI18N
        setResizable(false);

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/tick.png"))); // NOI18N
        bSave.setText(bundle.getString("button-save")); // NOI18N
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jTabbedPane1.setOpaque(true);

        lAuthor.setText(bundle.getString("settings-author")); // NOI18N

        buttonGroup1.add(rOwnWork);
        rOwnWork.setSelected(true);
        rOwnWork.setText(bundle.getString("settings-own")); // NOI18N
        rOwnWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOwnWorkActionPerformed(evt);
            }
        });

        buttonGroup1.add(rOtherAuthor);
        rOtherAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOtherAuthorActionPerformed(evt);
            }
        });

        tOtherAuthor.setEnabled(false);

        cLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cLicenseActionPerformed(evt);
            }
        });

        lLicense.setText(bundle.getString("settings-license")); // NOI18N

        tLicense.setEnabled(false);

        lAttrib.setText(bundle.getString("settings-attribution")); // NOI18N

        jLabel2.setText(bundle.getString("file-cats")); // NOI18N

        lExtraText.setText(bundle.getString("settings-extratext")); // NOI18N

        tExtraText.setColumns(20);
        tExtraText.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tExtraText.setRows(5);
        tExtraText.setText("{{Wiki Loves Monuments 2012|pl}}");
        tExtraTextScroll.setViewportView(tExtraText);

        tSource.setEnabled(false);

        lSource.setText(bundle.getString("settings-source")); // NOI18N

        javax.swing.GroupLayout pFileLayout = new javax.swing.GroupLayout(pFile);
        pFile.setLayout(pFileLayout);
        pFileLayout.setHorizontalGroup(
            pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFileLayout.createSequentialGroup()
                        .addComponent(lExtraText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tExtraTextScroll))
                    .addGroup(pFileLayout.createSequentialGroup()
                        .addComponent(lAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFileLayout.createSequentialGroup()
                                .addComponent(rOtherAuthor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tOtherAuthor))
                            .addComponent(rOwnWork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pFileLayout.createSequentialGroup()
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lAttrib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lLicense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(lSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tSource, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pFileLayout.createSequentialGroup()
                                .addComponent(cLicense, 0, 243, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tAttrib)
                            .addComponent(tCategories))))
                .addContainerGap())
        );
        pFileLayout.setVerticalGroup(
            pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAuthor)
                    .addComponent(rOwnWork))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rOtherAuthor)
                    .addComponent(tOtherAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tSource)
                    .addComponent(lSource, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLicense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tAttrib)
                    .addComponent(lAttrib, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lExtraText)
                    .addComponent(tExtraTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("settings-files"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image---small.png")), pFile); // NOI18N

        cCreateGallery.setText(bundle.getString("settings-gallery-create")); // NOI18N
        cCreateGallery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCreateGalleryActionPerformed(evt);
            }
        });

        lGalleryPage.setLabelFor(tGalleryPage);
        lGalleryPage.setText(bundle.getString("settings-gallery-subpage")); // NOI18N

        lGalleryHeader.setLabelFor(tGalleryHeader);
        lGalleryHeader.setText(bundle.getString("settings-gallery-header")); // NOI18N

        tGalleryHeader.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("settings-gallery-uploaddate"), bundle.getString("settings-gallery-ask")}));

        lGalleryWidth.setLabelFor(tGalleryWidth);
        lGalleryWidth.setText(bundle.getString("settings-gallery-width")); // NOI18N

        tGalleryWidth.setValue(200);

        javax.swing.GroupLayout pGalleryLayout = new javax.swing.GroupLayout(pGallery);
        pGallery.setLayout(pGalleryLayout);
        pGalleryLayout.setHorizontalGroup(
            pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGalleryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pGalleryLayout.createSequentialGroup()
                        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lGalleryPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lGalleryHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lGalleryWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pGalleryLayout.createSequentialGroup()
                                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tGalleryHeader, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tGalleryWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tGalleryPage)))
                    .addComponent(cCreateGallery, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pGalleryLayout.setVerticalGroup(
            pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGalleryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cCreateGallery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryPage)
                    .addComponent(lGalleryPage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryHeader)
                    .addComponent(lGalleryHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryWidth)
                    .addComponent(lGalleryWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("settings-gallery"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/images-stack.png")), pGallery); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("loading"))); // NOI18N

        cReadHour.setText(bundle.getString("settings-program-exifhour")); // NOI18N

        cLoadSubdirectory.setText(bundle.getString("settings-program-readsubdir")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cReadHour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cLoadSubdirectory, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cReadHour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cLoadSubdirectory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("settings-other"))); // NOI18N

        cRenameAfterUpload.setText(bundle.getString("settings-program-changename")); // NOI18N

        cAskQuit.setText(bundle.getString("settings-program-askquit")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cRenameAfterUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(cAskQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cRenameAfterUpload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cAskQuit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("settings-advanced"))); // NOI18N

        cFileDescSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("settings-program-descfile-program"), bundle.getString("settings-program-descfile-ext")}));

        lFileDescSource.setText(bundle.getString("settings-program-descfile")); // NOI18N

        tFileDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document.png"))); // NOI18N

        bSetFileDesc.setText(bundle.getString("button-load")); // NOI18N
        bSetFileDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSetFileDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tFileDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSetFileDesc)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lFileDescSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(cFileDescSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSetFileDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tFileDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pProgramLayout = new javax.swing.GroupLayout(pProgram);
        pProgram.setLayout(pProgramLayout);
        pProgramLayout.setHorizontalGroup(
            pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProgramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pProgramLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProgramLayout.setVerticalGroup(
            pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProgramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("settings-program"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/application.png")), pProgram); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if(cFileDescSource.getSelectedIndex()==1 && Settings.fileDescPath==null)
            JOptionPane.showMessageDialog(rootPane, "Select file");
        else {
            //FILE
            //author
            if(rOtherAuthor.isSelected() && !"".equals(tOtherAuthor.getText())) Settings.author = tOtherAuthor.getText();
                else Settings.author = "own";
            //source
            Settings.source = tSource.getText();
            //license
            if(cLicense.getSelectedIndex() == Data.licenses.size()-1) {
                if(!tLicense.getText().equals("")) {
                    Data.licensesTemplates.set(Data.licenses.size()-1, tLicense.getText());
                    Settings.licenseCustom = tLicense.getText();
                    Settings.license = Data.licenses.size()-1;
                }
            } else 
                Settings.license = cLicense.getSelectedIndex();
            //attrib
            if(tAttrib.getText() == null ? Settings.attrib != null : !tAttrib.getText().equals(Settings.attrib)) 
                Settings.attrib = tAttrib.getText();
            //cats
            Settings.categories = tCategories.getText();
            //extra text
            if(Settings.extratext == null ? tExtraText.getText() != null : !Settings.extratext.equals(tExtraText.getText())) 
                Settings.extratext = tExtraText.getText();

            //GALLERY
            Settings.createGallery = cCreateGallery.isSelected();
                if(!tGalleryPage.getText().equals(""))
            Settings.galleryPage = tGalleryPage.getText();
            Settings.galleryHeader = tGalleryHeader.getSelectedIndex();
            Settings.galleryWidth = Integer.parseInt(tGalleryWidth.getValue().toString());

            //PROGRAM
            Settings.readExifHour = cReadHour.isSelected();
            Settings.loadSubdirectory = cLoadSubdirectory.isSelected();

            Settings.renameAfterUpload = cRenameAfterUpload.isSelected();
            Settings.askQuit = cAskQuit.isSelected();

            Settings.fileDescSource = cFileDescSource.getSelectedIndex(); 

            Settings.Serialize();
            dispose();
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void cCreateGalleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCreateGalleryActionPerformed
        boolean b = cCreateGallery.isSelected();
        tGalleryHeader.setEnabled(b);
        tGalleryPage.setEnabled(b);
        tGalleryWidth.setEnabled(b);
    }//GEN-LAST:event_cCreateGalleryActionPerformed

    private void rOwnWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOwnWorkActionPerformed
        tOtherAuthor.setEnabled(false);
        tSource.setEnabled(false);
    }//GEN-LAST:event_rOwnWorkActionPerformed

    private void rOtherAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOtherAuthorActionPerformed
        tOtherAuthor.setEnabled(true);
        tSource.setEnabled(true);
    }//GEN-LAST:event_rOtherAuthorActionPerformed

    private void cLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cLicenseActionPerformed
        if (cLicense.getSelectedIndex() == (Data.licenses.size() - 1)) {
            tLicense.setEnabled(true);
        } else {
            tLicense.setEnabled(false);
        }
    }//GEN-LAST:event_cLicenseActionPerformed

    private void bSetFileDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSetFileDescActionPerformed
        JFileChooser ch = new JFileChooser();
            ch.setCurrentDirectory(null);
            ch.setDialogTitle(bundle.getString("session-load"));
            ch.setAcceptAllFileFilterUsed(false);
            ch.setMultiSelectionEnabled(false);
            ch.addChoosableFileFilter(new TxtFilter());

            if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                if(f.isFile()) {
                    Settings.fileDescPath = f.getPath();
                    tFileDesc.setText(f.getPath());
                }
//                else
//                    JOptionPane.showMessageDialog(rootPane, bundle.getString("session-load-error"), bundle.getString("session-load"), JOptionPane.WARNING_MESSAGE, null);
            }
    }//GEN-LAST:event_bSetFileDescActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSetFileDesc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cAskQuit;
    private javax.swing.JCheckBox cCreateGallery;
    private javax.swing.JComboBox cFileDescSource;
    private javax.swing.JComboBox cLicense;
    private javax.swing.JCheckBox cLoadSubdirectory;
    private javax.swing.JCheckBox cReadHour;
    private javax.swing.JCheckBox cRenameAfterUpload;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lAttrib;
    private javax.swing.JLabel lAuthor;
    private javax.swing.JLabel lExtraText;
    private javax.swing.JLabel lFileDescSource;
    private javax.swing.JLabel lGalleryHeader;
    private javax.swing.JLabel lGalleryPage;
    private javax.swing.JLabel lGalleryWidth;
    private javax.swing.JLabel lLicense;
    private javax.swing.JLabel lSource;
    private javax.swing.JPanel pFile;
    private javax.swing.JPanel pGallery;
    private javax.swing.JPanel pProgram;
    private javax.swing.JRadioButton rOtherAuthor;
    private javax.swing.JRadioButton rOwnWork;
    private javax.swing.JTextField tAttrib;
    private javax.swing.JTextField tCategories;
    private javax.swing.JTextArea tExtraText;
    private javax.swing.JScrollPane tExtraTextScroll;
    private javax.swing.JLabel tFileDesc;
    private javax.swing.JComboBox tGalleryHeader;
    private javax.swing.JTextField tGalleryPage;
    private javax.swing.JSpinner tGalleryWidth;
    private javax.swing.JTextField tLicense;
    private javax.swing.JTextField tOtherAuthor;
    private javax.swing.JTextField tSource;
    // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }; 
}

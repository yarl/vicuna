package cuploader.frames;

import cuploader.Data;
import cuploader.FileFilters;
import cuploader.QuickTemplate;
import cuploader.Settings;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class FSettings extends javax.swing.JFrame {
    private QuickTemplatesModel model = new QuickTemplatesModel();
    
    public FSettings() {
        
        initComponents();
        addWindowListener(exit);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //GENERAL
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
        
        //FILE
        tQuickTemplatesTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        
        //GALLERY
        cCreateGallery.setSelected(Settings.createGallery);
        cCreateGalleryActionPerformed(new ActionEvent(this, 0, null));
        tGalleryPage.setText(Settings.galleryPage);
        tGalleryHeader.setSelectedIndex(Settings.galleryHeader);
        tGalleryWidth.setValue(Settings.galleryWidth);
        tPositionTop.setSelected(Settings.galleryOnTop);
        tPositionBottom.setSelected(!Settings.galleryOnTop);
        
        //PROGRAM
        cReadHour.setSelected(Settings.readExifHour);
        cLoadSubdirectory.setSelected(Settings.loadSubdirectory);
        
        cRenameAfterUpload.setSelected(Settings.renameAfterUpload);
        cAskQuit.setSelected(Settings.askQuit);
        
        cFileDescSource.setSelectedIndex(Settings.fileDescSource);
        if(Settings.fileDescPath==null)
            tFileDesc.setText(Data.text("settings-program-descfile-noselected"));
        else
            tFileDesc.setText(Settings.fileDescPath);

        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gAuthor = new javax.swing.ButtonGroup();
        gGallery = new javax.swing.ButtonGroup();
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
        pFileDetails = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lQuickTemplatesHint = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tQuickTemplatesTable = new javax.swing.JTable();
        bDelete = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        pGallery = new javax.swing.JPanel();
        cCreateGallery = new javax.swing.JCheckBox();
        lGalleryPage = new javax.swing.JLabel();
        tGalleryPage = new javax.swing.JTextField();
        lGalleryHeader = new javax.swing.JLabel();
        tGalleryHeader = new javax.swing.JComboBox();
        lGalleryWidth = new javax.swing.JLabel();
        tGalleryWidth = new javax.swing.JSpinner();
        lSectionPosition = new javax.swing.JLabel();
        tPositionTop = new javax.swing.JRadioButton();
        tPositionBottom = new javax.swing.JRadioButton();
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

        gAuthor.add(rOwnWork);
        rOwnWork.setSelected(true);
        rOwnWork.setText(bundle.getString("settings-own")); // NOI18N
        rOwnWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOwnWorkActionPerformed(evt);
            }
        });

        gAuthor.add(rOtherAuthor);
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
        tExtraText.setComponentPopupMenu(Data.mQuickTemplates);
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
                            .addComponent(lExtraText, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tCategories)
                            .addComponent(tExtraTextScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)))
                    .addGroup(pFileLayout.createSequentialGroup()
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lAttrib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(lSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tLicense, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tSource, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cLicense, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tAttrib))))
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
                    .addComponent(cLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLicense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tLicense)
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
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab(bundle.getString("settings-general"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/gear.png")), pFile); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("<html>" + Data.text("settings-templates") + "</html>")); // NOI18N

        lQuickTemplatesHint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        lQuickTemplatesHint.setText("<html>" + Data.text("settings-templates-hint") + "</html>"); // NOI18N

        tQuickTemplatesTable.setModel(model);
        tQuickTemplatesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tQuickTemplatesTable.getTableHeader().setReorderingAllowed(false);
        tQuickTemplatesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tQuickTemplatesTableKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tQuickTemplatesTable);

        bDelete.setText( Data.text("button-delete")); // NOI18N
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bAdd.setText(Data.text("button-add")); // NOI18N
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lQuickTemplatesHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDelete)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lQuickTemplatesHint, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDelete)
                    .addComponent(bAdd))
                .addContainerGap())
        );

        javax.swing.GroupLayout pFileDetailsLayout = new javax.swing.GroupLayout(pFileDetails);
        pFileDetails.setLayout(pFileDetailsLayout);
        pFileDetailsLayout.setHorizontalGroup(
            pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileDetailsLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pFileDetailsLayout.setVerticalGroup(
            pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(Data.text("settings-files"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image---small.png")), pFileDetails); // NOI18N

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

        lSectionPosition.setText( Data.text("settings-gallery-position")); // NOI18N

        gGallery.add(tPositionTop);
        tPositionTop.setText( Data.text("settings-gallery-prepend")); // NOI18N

        gGallery.add(tPositionBottom);
        tPositionBottom.setText( Data.text("settings-gallery-append")); // NOI18N

        javax.swing.GroupLayout pGalleryLayout = new javax.swing.GroupLayout(pGallery);
        pGallery.setLayout(pGalleryLayout);
        pGalleryLayout.setHorizontalGroup(
            pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGalleryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGalleryLayout.createSequentialGroup()
                        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lGalleryPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lGalleryHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lGalleryWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tGalleryWidth)
                            .addComponent(tGalleryHeader, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tGalleryPage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lSectionPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pGalleryLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tPositionTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tPositionBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(pGalleryLayout.createSequentialGroup()
                        .addComponent(cCreateGallery, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pGalleryLayout.setVerticalGroup(
            pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGalleryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cCreateGallery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryPage)
                    .addComponent(lGalleryPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lSectionPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryHeader)
                    .addComponent(lGalleryHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tPositionTop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tGalleryWidth)
                    .addComponent(lGalleryWidth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tPositionBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(196, Short.MAX_VALUE))
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
                        .addComponent(lFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tFileDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSetFileDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("settings-program"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/application.png")), pProgram); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if(cFileDescSource.getSelectedIndex()==1 && Settings.fileDescPath==null)
            JOptionPane.showMessageDialog(rootPane, "Select file");
        else {
            //GENERAL
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

            //FILE
            Data.refreshQuickTemplates();
            
            //GALLERY
            Settings.createGallery = cCreateGallery.isSelected();
                if(!tGalleryPage.getText().equals(""))
            Settings.galleryPage = tGalleryPage.getText();
            Settings.galleryHeader = tGalleryHeader.getSelectedIndex();
            Settings.galleryWidth = Integer.parseInt(tGalleryWidth.getValue().toString());
            Settings.galleryOnTop = tPositionTop.isSelected();
            
            //PROGRAM
            Settings.readExifHour = cReadHour.isSelected();
            Settings.loadSubdirectory = cLoadSubdirectory.isSelected();

            Settings.renameAfterUpload = cRenameAfterUpload.isSelected();
            Settings.askQuit = cAskQuit.isSelected();

            Settings.fileDescSource = cFileDescSource.getSelectedIndex(); 

            Settings.Serialize();
            dispose();
            Data.fSettings = null;
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void cCreateGalleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCreateGalleryActionPerformed
        boolean b = cCreateGallery.isSelected();
        tGalleryHeader.setEnabled(b);
        tGalleryPage.setEnabled(b);
        tGalleryWidth.setEnabled(b);
        tPositionBottom.setEnabled(b);
        tPositionTop.setEnabled(b);
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
        boolean b;
        if(cLicense.getSelectedIndex() == (Data.licenses.size() - 1)) b = true;
        else b = false;
        
        tLicense.setEnabled(b);
        
        b = Data.licensesTemplates.get(cLicense.getSelectedIndex()).contains("cc-by");
        tAttrib.setEnabled(b);
    }//GEN-LAST:event_cLicenseActionPerformed

    private void bSetFileDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSetFileDescActionPerformed
        JFileChooser ch = new JFileChooser();
            ch.setCurrentDirectory(null);
            ch.setDialogTitle(Data.text("session-load"));
            ch.setAcceptAllFileFilterUsed(false);
            ch.setMultiSelectionEnabled(false);
            ch.addChoosableFileFilter(FileFilters.text);

            if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                if(f.isFile()) {
                    Settings.fileDescPath = f.getPath();
                    tFileDesc.setText(f.getPath());
                }
//                else
//                    JOptionPane.showMessageDialog(rootPane, Data.text("session-load-error"), Data.text("session-load"), JOptionPane.WARNING_MESSAGE, null);
            }
    }//GEN-LAST:event_bSetFileDescActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        Settings.quickTemplates.add(new QuickTemplate(Data.text("settings-templates-name"), "{{" + Data.text("settings-templates-template") + "}}", false));
        ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_bAddActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        int row = tQuickTemplatesTable.getSelectedRow();
        if(row>-1){
            Settings.quickTemplates.remove(row);
            ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void tQuickTemplatesTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tQuickTemplatesTableKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_DELETE) {
            System.out.println("DELETE");
            bDeleteActionPerformed(new ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_tQuickTemplatesTableKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSetFileDesc;
    private javax.swing.JCheckBox cAskQuit;
    private javax.swing.JCheckBox cCreateGallery;
    private javax.swing.JComboBox cFileDescSource;
    private javax.swing.JComboBox cLicense;
    private javax.swing.JCheckBox cLoadSubdirectory;
    private javax.swing.JCheckBox cReadHour;
    private javax.swing.JCheckBox cRenameAfterUpload;
    private javax.swing.ButtonGroup gAuthor;
    private javax.swing.ButtonGroup gGallery;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lAttrib;
    private javax.swing.JLabel lAuthor;
    private javax.swing.JLabel lExtraText;
    private javax.swing.JLabel lFileDescSource;
    private javax.swing.JLabel lGalleryHeader;
    private javax.swing.JLabel lGalleryPage;
    private javax.swing.JLabel lGalleryWidth;
    private javax.swing.JLabel lLicense;
    private javax.swing.JLabel lQuickTemplatesHint;
    private javax.swing.JLabel lSectionPosition;
    private javax.swing.JLabel lSource;
    private javax.swing.JPanel pFile;
    private javax.swing.JPanel pFileDetails;
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
    private javax.swing.JRadioButton tPositionBottom;
    private javax.swing.JRadioButton tPositionTop;
    private javax.swing.JTable tQuickTemplatesTable;
    private javax.swing.JTextField tSource;
    // End of variables declaration//GEN-END:variables

    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            Data.fSettings = null;
        }
    }; 
    
    WindowListener exit = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            dispose();
            Data.fSettings = null;
        }
    };
}

class QuickTemplatesModel extends DefaultTableModel {
    public QuickTemplatesModel() {}
    JCheckBox box = new JCheckBox();
         
    @Override
    public int getRowCount() {
        return Settings.quickTemplates.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return Settings.quickTemplates.get(rowIndex).active;
            case 1: return Settings.quickTemplates.get(rowIndex).name;
            case 2: return Settings.quickTemplates.get(rowIndex).template;
            default: return 0;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: Settings.quickTemplates.get(rowIndex).active = Boolean.parseBoolean(value.toString()); break;
            case 1: Settings.quickTemplates.get(rowIndex).name = value.toString(); break;
            case 2: Settings.quickTemplates.get(rowIndex).template = value.toString(); break;
        }
    }

    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0: return Data.text("settings-templates-active");
            case 1: return Data.text("settings-templates-name");
            case 2: return Data.text("settings-templates-template");
            default: return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0) return Boolean.class;
        else return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /*if(columnIndex==1 && rowIndex<5) return false;  //i18n
        else*/ return true;
    }
    
    
}
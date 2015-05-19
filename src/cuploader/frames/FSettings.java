package cuploader.frames;

import cuploader.Data;
import cuploader.FileFilters;
import cuploader.QuickTemplate;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class FSettings extends javax.swing.JFrame {
    private QuickTemplatesModel model = new QuickTemplatesModel();    
    DefaultTableModel dm = new DefaultTableModel();
    
    public FSettings() {

        initComponents();
        addWindowListener(exit);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //GENERAL
        if(!Data.settings.author.equals("own")) {
            rOtherAuthor.setSelected(true);
            tOtherAuthor.setText(Data.settings.author);
            tOtherAuthor.setEnabled(true);
        }
        
        tSource.setText(Data.settings.source);
        tPermission.setText(Data.settings.permission);
        
        String[] lic = new String[Data.licenses.size()];
        for(int i=0;i<Data.licenses.size();++i)
            lic[i] = Data.licenses.get(i);
        cLicense.setModel(new DefaultComboBoxModel(lic));
        
        if(Data.settings.license == Data.licenses.size()-1) {
            cLicense.setSelectedIndex(Data.licenses.size()-1);
            tLicense.setEditable(true);
            tLicense.setText(Data.settings.licenseCustom/*Data.licensesTemplates.get(Data.licenses.size()-1)*/);
        } else {
            cLicense.setSelectedIndex(Data.settings.license);
        }

        tAttrib.setText(Data.settings.attribution);
        tCategories.setText(Data.settings.categories);
        tExtraText.setText(Data.settings.extraText);
        
        //FILE
        tQuickTemplatesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tQuickTemplatesTable.getColumnModel().getColumn(0).setMaxWidth(30);
        
        tCopyName.setSelected(Data.settings.copyName);
        tCopyDesc.setSelected(Data.settings.copyDescription);
        tCopyCats.setSelected(Data.settings.copyCategories);
        
        tCatHints.setSelected(Data.settings.showCatHints);
        
        //GALLERY
        cCreateGallery.setSelected(Data.settings.createGallery);
        cCreateGalleryActionPerformed(new ActionEvent(this, 0, null));
        tGalleryPage.setText(Data.settings.galleryPage);
        tGalleryHeader.setSelectedIndex(Data.settings.galleryHeader);
        tGalleryWidth.setValue(Data.settings.galleryWidth);
        tPositionTop.setSelected(Data.settings.galleryOnTop);
        tPositionBottom.setSelected(!Data.settings.galleryOnTop);
        
        //PROGRAM
        cReadHour.setSelected(Data.settings.readExifHour);
        cLoadSubdirectory.setSelected(Data.settings.loadSubdirectory);
        
        cRenameAfterUpload.setSelected(Data.settings.renameAfterUpload);
        cServerMonitorEnabled.setSelected(Data.settings.isServerMonitorEnabled());
        cAskQuit.setSelected(Data.settings.askQuit);
        
        cFileDescSource.setSelectedIndex(Data.settings.fileDescSource);
        tFileDesc.setText(Data.settings.fileDescPath == null ? Data.text("settings-program-descfile-noselected") : Data.settings.fileDescPath);
        tUploadSummary.setText(Data.settings.uploadSummary == null ? "VicuñaUploader" : Data.settings.uploadSummary);
       
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        pDefault.setVisible(false);
        tUploadSummary.setVisible(false);
    }

    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    gAuthor = new javax.swing.ButtonGroup();
    gGallery = new javax.swing.ButtonGroup();
    gDescSource = new javax.swing.ButtonGroup();
    bSave = new javax.swing.JButton();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    pFile = new javax.swing.JPanel();
    jPanel7 = new javax.swing.JPanel();
    cLicense = new javax.swing.JComboBox();
    tLicense = new javax.swing.JTextField();
    lAttrib = new javax.swing.JLabel();
    tAttrib = new javax.swing.JTextField();
    jPanel8 = new javax.swing.JPanel();
    rOtherAuthor = new javax.swing.JRadioButton();
    rOwnWork = new javax.swing.JRadioButton();
    tOtherAuthor = new javax.swing.JTextField();
    lSource = new javax.swing.JLabel();
    tSource = new javax.swing.JTextField();
    jPanel9 = new javax.swing.JPanel();
    lCategories = new javax.swing.JLabel();
    tCategories = new javax.swing.JTextField();
    lExtraText = new javax.swing.JLabel();
    tExtraTextScroll = new javax.swing.JScrollPane();
    tExtraText = new javax.swing.JTextArea();
    tPermission = new javax.swing.JTextField();
    lPermission = new javax.swing.JLabel();
    pFileDetails = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    lQuickTemplatesHint = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tQuickTemplatesTable = new javax.swing.JTable();
    bDelete = new javax.swing.JButton();
    bAdd = new javax.swing.JButton();
    jPanel5 = new javax.swing.JPanel();
    lCopyInfoHint = new javax.swing.JLabel();
    tCopyName = new javax.swing.JCheckBox();
    tCopyDesc = new javax.swing.JCheckBox();
    tCopyCats = new javax.swing.JCheckBox();
    tNumFormat = new javax.swing.JTextField();
    lNumFormat = new javax.swing.JLabel();
    lDigits = new javax.swing.JLabel();
    tDigits = new javax.swing.JSpinner();
    jPanel6 = new javax.swing.JPanel();
    tCatHints = new javax.swing.JCheckBox();
    pGallery = new javax.swing.JPanel();
    jPanel10 = new javax.swing.JPanel();
    lGalleryWidth = new javax.swing.JLabel();
    tGalleryWidth = new javax.swing.JSpinner();
    tGalleryHeader = new javax.swing.JComboBox();
    lGalleryHeader = new javax.swing.JLabel();
    lGalleryPage = new javax.swing.JLabel();
    tGalleryPage = new javax.swing.JTextField();
    cCreateGallery = new javax.swing.JCheckBox();
    jPanel11 = new javax.swing.JPanel();
    tPositionTop = new javax.swing.JRadioButton();
    tPositionBottom = new javax.swing.JRadioButton();
    pProgram = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    cReadHour = new javax.swing.JCheckBox();
    cLoadSubdirectory = new javax.swing.JCheckBox();
    jPanel2 = new javax.swing.JPanel();
    cRenameAfterUpload = new javax.swing.JCheckBox();
    cServerMonitorEnabled = new javax.swing.JCheckBox();
    cAskQuit = new javax.swing.JCheckBox();
    tUploadSummary = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    cFileDescSource = new javax.swing.JComboBox();
    lFileDescSource = new javax.swing.JLabel();
    bSetFileDesc = new javax.swing.JButton();
    tFileDesc = new javax.swing.JTextField();
    pDefault = new javax.swing.JPanel();
    lName = new javax.swing.JLabel();
    rNameEmpty = new javax.swing.JRadioButton();
    rNameDefault = new javax.swing.JRadioButton();
    lDesc = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tDesc = new javax.swing.JTextArea();

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

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-license"))); // NOI18N

    cLicense.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cLicenseActionPerformed(evt);
      }
    });

    tLicense.setEnabled(false);

    lAttrib.setText(bundle.getString("settings-attribution")); // NOI18N

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tLicense, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(cLicense, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel7Layout.createSequentialGroup()
            .addComponent(lAttrib, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tAttrib)))
        .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(cLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lAttrib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tAttrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-author"))); // NOI18N

    gAuthor.add(rOtherAuthor);
    rOtherAuthor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rOtherAuthorActionPerformed(evt);
      }
    });

    gAuthor.add(rOwnWork);
    rOwnWork.setSelected(true);
    rOwnWork.setText(bundle.getString("settings-own")); // NOI18N
    rOwnWork.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rOwnWorkActionPerformed(evt);
      }
    });

    tOtherAuthor.setEnabled(false);

    lSource.setText(bundle.getString("settings-source")); // NOI18N

    tSource.setEnabled(false);

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel8Layout.createSequentialGroup()
            .addComponent(rOtherAuthor)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tOtherAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(rOwnWork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tSource)
          .addComponent(lSource, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(rOwnWork)
          .addComponent(lSource, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(rOtherAuthor)
          .addComponent(tOtherAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 10, Short.MAX_VALUE))
    );

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-other"))); // NOI18N

    lCategories.setText(bundle.getString("file-cats")); // NOI18N

    lExtraText.setText(bundle.getString("settings-extratext")); // NOI18N

    tExtraText.setColumns(20);
    tExtraText.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
    tExtraText.setRows(5);
    tExtraText.setComponentPopupMenu(Data.mQuickTemplates);
    tExtraTextScroll.setViewportView(tExtraText);

    lPermission.setText(bundle.getString("settings-permission")); // NOI18N

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lExtraText, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
          .addComponent(lCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
          .addComponent(lPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tCategories)
          .addComponent(tExtraTextScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
          .addComponent(tPermission))
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tPermission)
          .addComponent(lPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lExtraText)
          .addComponent(tExtraTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(12, 12, 12))
    );

    javax.swing.GroupLayout pFileLayout = new javax.swing.GroupLayout(pFile);
    pFile.setLayout(pFileLayout);
    pFileLayout.setHorizontalGroup(
      pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFileLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pFileLayout.setVerticalGroup(
      pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFileLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane1.addTab(bundle.getString("settings-general"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/gear.png")), pFile); // NOI18N

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-templates"))); // NOI18N

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
          .addComponent(lQuickTemplatesHint, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
        .addComponent(lQuickTemplatesHint)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bDelete)
          .addComponent(bAdd))
        .addContainerGap())
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-copying"))); // NOI18N

    lCopyInfoHint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-turn-180-left.png"))); // NOI18N
    lCopyInfoHint.setText("<html>" + Data.text("settings-copying-hint") + "</html>"); // NOI18N
    lCopyInfoHint.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    tCopyName.setText(Data.text("file-name")); // NOI18N

    tCopyDesc.setText(Data.text("file-desc")); // NOI18N

    tCopyCats.setText(Data.text("file-cats")); // NOI18N

    tNumFormat.setText(Data.settings.numFormat);

    lNumFormat.setText(bundle.getString("fileedit-num-format")); // NOI18N
    lNumFormat.setToolTipText("<html>" + java.util.ResourceBundle.getBundle("cuploader/text/messages").getString("fileedit-num-format-tooltip") + "</html>");

    lDigits.setText(bundle.getString("fileedit-num-digits")); // NOI18N

    tDigits.setModel(new SpinnerNumberModel(Data.settings.numDigits, 1, 5, 1));
    tDigits.setValue(Data.settings.numDigits);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lCopyInfoHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tCopyCats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(tCopyName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(lDigits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lNumFormat, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tNumFormat)
              .addComponent(tDigits)))
          .addComponent(tCopyDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addComponent(lCopyInfoHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tCopyName)
          .addComponent(lNumFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tNumFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tDigits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tCopyDesc)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tCopyCats)
        .addContainerGap())
    );

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-other"))); // NOI18N

    tCatHints.setText(Data.text("settings-cathint")); // NOI18N

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tCatHints, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tCatHints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pFileDetailsLayout = new javax.swing.GroupLayout(pFileDetails);
    pFileDetails.setLayout(pFileDetailsLayout);
    pFileDetailsLayout.setHorizontalGroup(
      pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFileDetailsLayout.createSequentialGroup()
        .addGroup(pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pFileDetailsLayout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pFileDetailsLayout.setVerticalGroup(
      pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFileDetailsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pFileDetailsLayout.createSequentialGroup()
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jTabbedPane1.addTab(Data.text("settings-files"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image---small.png")), pFileDetails); // NOI18N

    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-gallery"))); // NOI18N

    lGalleryWidth.setLabelFor(tGalleryWidth);
    lGalleryWidth.setText(bundle.getString("settings-gallery-width")); // NOI18N

    tGalleryWidth.setValue(200);

    tGalleryHeader.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("settings-gallery-uploaddate"), bundle.getString("settings-gallery-ask")}));

    lGalleryHeader.setLabelFor(tGalleryHeader);
    lGalleryHeader.setText(bundle.getString("settings-gallery-header")); // NOI18N

    lGalleryPage.setLabelFor(tGalleryPage);
    lGalleryPage.setText(bundle.getString("settings-gallery-subpage")); // NOI18N

    cCreateGallery.setText(bundle.getString("settings-gallery-create")); // NOI18N
    cCreateGallery.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cCreateGalleryActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel10Layout.createSequentialGroup()
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(lGalleryPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lGalleryHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lGalleryWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tGalleryWidth)
              .addComponent(tGalleryHeader, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tGalleryPage)))
          .addComponent(cCreateGallery, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(cCreateGallery)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tGalleryPage)
          .addComponent(lGalleryPage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(6, 6, 6)
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tGalleryHeader)
          .addComponent(lGalleryHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tGalleryWidth)
          .addComponent(lGalleryWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-gallery-position"))); // NOI18N

    gGallery.add(tPositionTop);
    tPositionTop.setText( Data.text("settings-gallery-prepend")); // NOI18N

    gGallery.add(tPositionBottom);
    tPositionBottom.setText( Data.text("settings-gallery-append")); // NOI18N

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tPositionTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tPositionBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel11Layout.setVerticalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tPositionTop, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tPositionBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pGalleryLayout = new javax.swing.GroupLayout(pGallery);
    pGallery.setLayout(pGalleryLayout);
    pGalleryLayout.setHorizontalGroup(
      pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pGalleryLayout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    pGalleryLayout.setVerticalGroup(
      pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pGalleryLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pGalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(257, Short.MAX_VALUE))
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
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(cReadHour)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cLoadSubdirectory)
        .addGap(119, 119, 119))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("settings-other"))); // NOI18N

    cRenameAfterUpload.setText(bundle.getString("settings-program-changename")); // NOI18N

    cServerMonitorEnabled.setText(bundle.getString("settings-program-servermonitorenabled")); // NOI18N
    cAskQuit.setText(bundle.getString("settings-program-askquit")); // NOI18N

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(cRenameAfterUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
              .addComponent(cServerMonitorEnabled, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(cAskQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 39, Short.MAX_VALUE))
          .addComponent(tUploadSummary))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(cRenameAfterUpload)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cServerMonitorEnabled)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cAskQuit)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tUploadSummary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("settings-advanced"))); // NOI18N

    cFileDescSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { bundle.getString("settings-program-descfile-program"), bundle.getString("settings-program-descfile-ext")}));

    lFileDescSource.setText(bundle.getString("settings-program-descfile")); // NOI18N

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
          .addComponent(lFileDescSource, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
          .addComponent(tFileDesc))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(bSetFileDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
          .addComponent(cFileDescSource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(7, 7, 7)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cFileDescSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tFileDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bSetFileDesc))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pDefault.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("settings-default-values"))); // NOI18N

    lName.setText(bundle.getString("file-name")); // NOI18N

    rNameEmpty.setText(bundle.getString("settings-default-name-empty")); // NOI18N
    rNameEmpty.setEnabled(false);

    rNameDefault.setText(bundle.getString("settings-default-name-filename")); // NOI18N
    rNameDefault.setEnabled(false);

    lDesc.setText(bundle.getString("file-desc")); // NOI18N

    tDesc.setColumns(20);
    tDesc.setRows(5);
    tDesc.setEnabled(false);
    jScrollPane1.setViewportView(tDesc);

    javax.swing.GroupLayout pDefaultLayout = new javax.swing.GroupLayout(pDefault);
    pDefault.setLayout(pDefaultLayout);
    pDefaultLayout.setHorizontalGroup(
      pDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pDefaultLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(rNameEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(rNameDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1)
          .addComponent(lDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pDefaultLayout.setVerticalGroup(
      pDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pDefaultLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rNameEmpty)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rNameDefault)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(lDesc)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout pProgramLayout = new javax.swing.GroupLayout(pProgram);
    pProgram.setLayout(pProgramLayout);
    pProgramLayout.setHorizontalGroup(
      pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pProgramLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pProgramLayout.createSequentialGroup()
            .addGroup(pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(pDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pProgramLayout.setVerticalGroup(
      pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pProgramLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(pProgramLayout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jTabbedPane1.addTab(bundle.getString("settings-program"), new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/application.png")), pProgram); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jTabbedPane1)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(bSave)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bSave)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if(cFileDescSource.getSelectedIndex()==1 && Data.settings.fileDescPath==null)
            JOptionPane.showMessageDialog(rootPane, "Select file");
        else {
            //GENERAL
            //author
            if(rOtherAuthor.isSelected() && !"".equals(tOtherAuthor.getText())) Data.settings.author = tOtherAuthor.getText();
                else Data.settings.author = "own";
            //source
            Data.settings.source = tSource.getText();
            //permission
            Data.settings.permission = tPermission.getText();
            //license
            if(cLicense.getSelectedIndex() == Data.licenses.size()-1) {
                if(!tLicense.getText().equals("")) {
                    Data.licensesTemplates.set(Data.licenses.size()-1, tLicense.getText());
                    Data.settings.licenseCustom = tLicense.getText();
                    Data.settings.license = Data.licenses.size()-1;
                }
            } else 
                Data.settings.license = cLicense.getSelectedIndex();
            //attrib
            if(tAttrib.getText() == null ? Data.settings.attribution != null : !tAttrib.getText().equals(Data.settings.attribution)) 
                Data.settings.attribution = tAttrib.getText();
            //cats
            Data.settings.categories = tCategories.getText();
            //extra text
            if(Data.settings.extraText == null ? tExtraText.getText() != null : !Data.settings.extraText.equals(tExtraText.getText())) 
                Data.settings.extraText = tExtraText.getText();

            //FILE
            Data.refreshQuickTemplates();
            
            Data.settings.copyName = tCopyName.isSelected();
            Data.settings.copyDescription = tCopyDesc.isSelected();
            Data.settings.copyCategories = tCopyCats.isSelected();

            Data.settings.showCatHints = tCatHints.isSelected();
            
            Data.settings.numFormat = tNumFormat.getText();
            Data.settings.numDigits = Integer.parseInt(tDigits.getValue().toString());
            
            //GALLERY
            Data.settings.createGallery = cCreateGallery.isSelected();
                if(!tGalleryPage.getText().equals(""))
            Data.settings.galleryPage = tGalleryPage.getText();
            Data.settings.galleryHeader = tGalleryHeader.getSelectedIndex();
            Data.settings.galleryWidth = Integer.parseInt(tGalleryWidth.getValue().toString());
            Data.settings.galleryOnTop = tPositionTop.isSelected();
            
            //PROGRAM
            Data.settings.readExifHour = cReadHour.isSelected();
            Data.settings.loadSubdirectory = cLoadSubdirectory.isSelected();

            Data.settings.renameAfterUpload = cRenameAfterUpload.isSelected();
            Data.settings.setServerMonitorEnabled(cServerMonitorEnabled.isSelected());
            Data.settings.askQuit = cAskQuit.isSelected();

            Data.settings.fileDescSource = cFileDescSource.getSelectedIndex(); 
            Data.settings.uploadSummary = tUploadSummary.getText();
            
            Data.saveSettings();
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

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        Data.settings.quickTemplates.add(new QuickTemplate(Data.text("settings-templates-name"), "{{" + Data.text("settings-templates-template") + "}}", false));
        ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_bAddActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        int row = tQuickTemplatesTable.getSelectedRow();
        if(row>-1){
            Data.settings.quickTemplates.remove(row);
            ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void tQuickTemplatesTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tQuickTemplatesTableKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_DELETE) {
            System.out.println("DELETE");
            bDeleteActionPerformed(new ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_tQuickTemplatesTableKeyTyped

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
                Data.settings.fileDescPath = f.getPath();
                tFileDesc.setText(f.getPath());
            }
            //                else
            //                    JOptionPane.showMessageDialog(rootPane, Data.text("session-load-error"), Data.text("session-load"), JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_bSetFileDescActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAdd;
  private javax.swing.JButton bDelete;
  private javax.swing.JButton bSave;
  private javax.swing.JButton bSetFileDesc;
  private javax.swing.JCheckBox cAskQuit;
  private javax.swing.JCheckBox cServerMonitorEnabled;
  private javax.swing.JCheckBox cCreateGallery;
  private javax.swing.JComboBox cFileDescSource;
  private javax.swing.JComboBox cLicense;
  private javax.swing.JCheckBox cLoadSubdirectory;
  private javax.swing.JCheckBox cReadHour;
  private javax.swing.JCheckBox cRenameAfterUpload;
  private javax.swing.ButtonGroup gAuthor;
  private javax.swing.ButtonGroup gDescSource;
  private javax.swing.ButtonGroup gGallery;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel11;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JLabel lAttrib;
  private javax.swing.JLabel lCategories;
  private javax.swing.JLabel lCopyInfoHint;
  private javax.swing.JLabel lDesc;
  private javax.swing.JLabel lDigits;
  private javax.swing.JLabel lExtraText;
  private javax.swing.JLabel lFileDescSource;
  private javax.swing.JLabel lGalleryHeader;
  private javax.swing.JLabel lGalleryPage;
  private javax.swing.JLabel lGalleryWidth;
  private javax.swing.JLabel lName;
  private javax.swing.JLabel lNumFormat;
  private javax.swing.JLabel lPermission;
  private javax.swing.JLabel lQuickTemplatesHint;
  private javax.swing.JLabel lSource;
  private javax.swing.JPanel pDefault;
  private javax.swing.JPanel pFile;
  private javax.swing.JPanel pFileDetails;
  private javax.swing.JPanel pGallery;
  private javax.swing.JPanel pProgram;
  private javax.swing.JRadioButton rNameDefault;
  private javax.swing.JRadioButton rNameEmpty;
  private javax.swing.JRadioButton rOtherAuthor;
  private javax.swing.JRadioButton rOwnWork;
  private javax.swing.JTextField tAttrib;
  private javax.swing.JCheckBox tCatHints;
  private javax.swing.JTextField tCategories;
  private javax.swing.JCheckBox tCopyCats;
  private javax.swing.JCheckBox tCopyDesc;
  private javax.swing.JCheckBox tCopyName;
  private javax.swing.JTextArea tDesc;
  private javax.swing.JSpinner tDigits;
  private javax.swing.JTextArea tExtraText;
  private javax.swing.JScrollPane tExtraTextScroll;
  private javax.swing.JTextField tFileDesc;
  private javax.swing.JComboBox tGalleryHeader;
  private javax.swing.JTextField tGalleryPage;
  private javax.swing.JSpinner tGalleryWidth;
  private javax.swing.JTextField tLicense;
  private javax.swing.JTextField tNumFormat;
  private javax.swing.JTextField tOtherAuthor;
  private javax.swing.JTextField tPermission;
  private javax.swing.JRadioButton tPositionBottom;
  private javax.swing.JRadioButton tPositionTop;
  private javax.swing.JTable tQuickTemplatesTable;
  private javax.swing.JTextField tSource;
  private javax.swing.JTextField tUploadSummary;
  // End of variables declaration//GEN-END:variables

    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            Data.fSettings = null;
        }
        static final long serialVersionUID = 7850593258773014992L;
    }; 
    
    WindowListener exit = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            dispose();
            Data.fSettings = null;
        }
    };
    static final long serialVersionUID = 8765476340053495420L;
}

class QuickTemplatesModel extends DefaultTableModel {
    public QuickTemplatesModel() {}
    JCheckBox box = new JCheckBox();
         
    @Override
    public int getRowCount() {
        return Data.settings.quickTemplates.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public void getColumnWidth() {
        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return Data.settings.quickTemplates.get(rowIndex).active;
            case 1: return Data.settings.quickTemplates.get(rowIndex).name;
            case 2: return Data.settings.quickTemplates.get(rowIndex).template;
            default: return 0;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: Data.settings.quickTemplates.get(rowIndex).active = Boolean.parseBoolean(value.toString()); break;
            case 1: Data.settings.quickTemplates.get(rowIndex).name = value.toString(); break;
            case 2: Data.settings.quickTemplates.get(rowIndex).template = value.toString(); break;
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

    static final long serialVersionUID = -8533295926904577136L;
}

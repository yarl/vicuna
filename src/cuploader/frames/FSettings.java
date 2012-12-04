package cuploader.frames;

import cuploader.Data;
import cuploader.DescSource;
import cuploader.FileFilters;
import cuploader.QuickTemplate;
import java.awt.Component;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FSettings extends javax.swing.JFrame {
    private QuickTemplatesModel model = new QuickTemplatesModel();
    private DescSourceModel descSourceModel = new DescSourceModel();
    
    DefaultTableModel dm = new DefaultTableModel();
    
    public FSettings() {

//        Vector<Object[]> array = new Vector<Object[]>();
//        for(int i=0; i<Main.settings.descSources.size(); ++i) {
//            Object[] o = { new JRadioButton(), Main.settings.descSources.get(0).name, "buton" };
//            array.add(o);
//        }
//
//        Vector<Object[]> desc = new Vector<Object[]>();
//        Object[] o = { "Btn", Data.text("file-name"), "Buton" };
//        desc.add(o);

        


        initComponents();
        
        Object[][] obj = new Object[Main.settings.descSources.size()][3];
        
        for(int i=0; i<Main.settings.descSources.size(); ++i) {
            obj[i][0] = new JRadioButton();
            obj[i][1] = Main.settings.descSources.get(i).name;
            obj[i][2] = "buton";
        };
        
        dm.setDataVector(obj, new Object[] {
            "Btn", Data.text("file-name"), "Buton"
        });
               for(int i=0; i<Main.settings.descSources.size(); ++i)
            gDescSource.add((JRadioButton)dm.getValueAt(i,0));
               
        
        //table fix
        UIDefaults ui = UIManager.getLookAndFeel().getDefaults();    
        UIManager.put("RadioButton.focus", ui.getColor("control"));
        tDescSource.getColumn("Btn").setCellRenderer(new RadioButtonRenderer());
        tDescSource.getColumn("Btn").setCellEditor(new RadioButtonEditor(new JCheckBox()));


        
        addWindowListener(exit);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //GENERAL
        if(!Main.settings.author.equals("own")) {
            rOtherAuthor.setSelected(true);
            tOtherAuthor.setText(Main.settings.author);
            tOtherAuthor.setEnabled(true);
        }
        
        tSource.setText(Main.settings.source);
        
        String[] lic = new String[Data.licenses.size()];
        for(int i=0;i<Data.licenses.size();++i)
            lic[i] = Data.licenses.get(i);
        cLicense.setModel(new DefaultComboBoxModel(lic));
        
        if(Main.settings.license == Data.licenses.size()-1) {
            cLicense.setSelectedIndex(Data.licenses.size()-1);
            tLicense.setEditable(true);
            tLicense.setText(Main.settings.licenseCustom/*Data.licensesTemplates.get(Data.licenses.size()-1)*/);
        } else {
            cLicense.setSelectedIndex(Main.settings.license);
        }

        tAttrib.setText(Main.settings.attribution);
        tCategories.setText(Main.settings.categories);
        tExtraText.setText(Main.settings.extraText);
        
        //FILE
        tQuickTemplatesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tQuickTemplatesTable.getColumnModel().getColumn(0).setMaxWidth(30);
        
        tCopyName.setSelected(Main.settings.copyName);
        tCopyDesc.setSelected(Main.settings.copyDescription);
        tCopyCats.setSelected(Main.settings.copyCategories);
        
        tCatHints.setSelected(Main.settings.showCatHints);
        
        //GALLERY
        cCreateGallery.setSelected(Main.settings.createGallery);
        cCreateGalleryActionPerformed(new ActionEvent(this, 0, null));
        tGalleryPage.setText(Main.settings.galleryPage);
        tGalleryHeader.setSelectedIndex(Main.settings.galleryHeader);
        tGalleryWidth.setValue(Main.settings.galleryWidth);
        tPositionTop.setSelected(Main.settings.galleryOnTop);
        tPositionBottom.setSelected(!Main.settings.galleryOnTop);
        
        //PROGRAM
        cReadHour.setSelected(Main.settings.readExifHour);
        cLoadSubdirectory.setSelected(Main.settings.loadSubdirectory);
        
        cRenameAfterUpload.setSelected(Main.settings.renameAfterUpload);
        cAskQuit.setSelected(Main.settings.askQuit);
        
        cFileDescSource.setSelectedIndex(Main.settings.fileDescSource);
        if(Main.settings.fileDescPath==null)
            tFileDesc.setText(Data.text("settings-program-descfile-noselected"));
        else
            tFileDesc.setText(Main.settings.fileDescPath);
       
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
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
        jLabel2 = new javax.swing.JLabel();
        tCategories = new javax.swing.JTextField();
        lExtraText = new javax.swing.JLabel();
        tExtraTextScroll = new javax.swing.JScrollPane();
        tExtraText = new javax.swing.JTextArea();
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
        cAskQuit = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        cFileDescSource = new javax.swing.JComboBox();
        lFileDescSource = new javax.swing.JLabel();
        bSetFileDesc = new javax.swing.JButton();
        tFileDesc = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescSource = new javax.swing.JTable() {
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                repaint();
            }
        };
        jButton1 = new javax.swing.JButton();

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

        jLabel2.setText(bundle.getString("file-cats")); // NOI18N

        lExtraText.setText(bundle.getString("settings-extratext")); // NOI18N

        tExtraText.setColumns(20);
        tExtraText.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tExtraText.setRows(5);
        tExtraText.setComponentPopupMenu(Data.mQuickTemplates);
        tExtraTextScroll.setViewportView(tExtraText);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lExtraText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCategories)
                    .addComponent(tExtraTextScroll))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lExtraText)
                    .addComponent(tExtraTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lQuickTemplatesHint, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
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
                .addComponent(lQuickTemplatesHint, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCopyCats, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(tCopyDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tCopyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lCopyInfoHint, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lCopyInfoHint, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCopyName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCopyDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCopyCats)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("settings-other"))); // NOI18N

        tCatHints.setText(Data.text("settings-cathint")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tCatHints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tCatHints)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pFileDetailsLayout = new javax.swing.GroupLayout(pFileDetails);
        pFileDetails.setLayout(pFileDetailsLayout);
        pFileDetailsLayout.setHorizontalGroup(
            pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileDetailsLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pFileDetailsLayout.setVerticalGroup(
            pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFileDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFileDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pFileDetailsLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(230, Short.MAX_VALUE))
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
                .addContainerGap(53, Short.MAX_VALUE))
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
                    .addComponent(lFileDescSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tDescSource.setModel(dm);
        jScrollPane1.setViewportView(tDescSource);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if(cFileDescSource.getSelectedIndex()==1 && Main.settings.fileDescPath==null)
            JOptionPane.showMessageDialog(rootPane, "Select file");
        else {
            //GENERAL
            //author
            if(rOtherAuthor.isSelected() && !"".equals(tOtherAuthor.getText())) Main.settings.author = tOtherAuthor.getText();
                else Main.settings.author = "own";
            //source
            Main.settings.source = tSource.getText();
            //license
            if(cLicense.getSelectedIndex() == Data.licenses.size()-1) {
                if(!tLicense.getText().equals("")) {
                    Data.licensesTemplates.set(Data.licenses.size()-1, tLicense.getText());
                    Main.settings.licenseCustom = tLicense.getText();
                    Main.settings.license = Data.licenses.size()-1;
                }
            } else 
                Main.settings.license = cLicense.getSelectedIndex();
            //attrib
            if(tAttrib.getText() == null ? Main.settings.attribution != null : !tAttrib.getText().equals(Main.settings.attribution)) 
                Main.settings.attribution = tAttrib.getText();
            //cats
            Main.settings.categories = tCategories.getText();
            //extra text
            if(Main.settings.extraText == null ? tExtraText.getText() != null : !Main.settings.extraText.equals(tExtraText.getText())) 
                Main.settings.extraText = tExtraText.getText();

            //FILE
            Data.refreshQuickTemplates();
            
            Main.settings.copyName = tCopyName.isSelected();
            Main.settings.copyDescription = tCopyDesc.isSelected();
            Main.settings.copyCategories = tCopyCats.isSelected();

            Main.settings.showCatHints = tCatHints.isSelected();
            
            //GALLERY
            Main.settings.createGallery = cCreateGallery.isSelected();
                if(!tGalleryPage.getText().equals(""))
            Main.settings.galleryPage = tGalleryPage.getText();
            Main.settings.galleryHeader = tGalleryHeader.getSelectedIndex();
            Main.settings.galleryWidth = Integer.parseInt(tGalleryWidth.getValue().toString());
            Main.settings.galleryOnTop = tPositionTop.isSelected();
            
            //PROGRAM
            Main.settings.readExifHour = cReadHour.isSelected();
            Main.settings.loadSubdirectory = cLoadSubdirectory.isSelected();

            Main.settings.renameAfterUpload = cRenameAfterUpload.isSelected();
            Main.settings.askQuit = cAskQuit.isSelected();

            Main.settings.fileDescSource = cFileDescSource.getSelectedIndex(); 

            Main.Save();
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
                    Main.settings.fileDescPath = f.getPath();
                    tFileDesc.setText(f.getPath());
                }
//                else
//                    JOptionPane.showMessageDialog(rootPane, Data.text("session-load-error"), Data.text("session-load"), JOptionPane.WARNING_MESSAGE, null);
            }
    }//GEN-LAST:event_bSetFileDescActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        Main.settings.quickTemplates.add(new QuickTemplate(Data.text("settings-templates-name"), "{{" + Data.text("settings-templates-template") + "}}", false));
        ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_bAddActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        int row = tQuickTemplatesTable.getSelectedRow();
        if(row>-1){
            Main.settings.quickTemplates.remove(row);
            ((AbstractTableModel)tQuickTemplatesTable.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void tQuickTemplatesTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tQuickTemplatesTableKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_DELETE) {
            System.out.println("DELETE");
            bDeleteActionPerformed(new ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_tQuickTemplatesTableKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Main.settings.descSources.add(new DescSource("New", "Desc"));
        
                Object[][] obj = new Object[Main.settings.descSources.size()][3];
        
        for(int i=0; i<Main.settings.descSources.size(); ++i) {
            obj[i][0] = new JRadioButton();
            obj[i][1] = Main.settings.descSources.get(i).name;
            obj[i][2] = "buton";
        };
        
        dm.setDataVector(obj, new Object[] {
            "Btn", Data.text("file-name"), "Buton"
        });
               for(int i=0; i<Main.settings.descSources.size(); ++i)
            gDescSource.add((JRadioButton)dm.getValueAt(i,0));
               
               UIDefaults ui = UIManager.getLookAndFeel().getDefaults();    
        UIManager.put("RadioButton.focus", ui.getColor("control"));
        tDescSource.getColumn("Btn").setCellRenderer(new RadioButtonRenderer());
        tDescSource.getColumn("Btn").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.ButtonGroup gDescSource;
    private javax.swing.ButtonGroup gGallery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
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
    private javax.swing.JLabel lCopyInfoHint;
    private javax.swing.JLabel lExtraText;
    private javax.swing.JLabel lFileDescSource;
    private javax.swing.JLabel lGalleryHeader;
    private javax.swing.JLabel lGalleryPage;
    private javax.swing.JLabel lGalleryWidth;
    private javax.swing.JLabel lQuickTemplatesHint;
    private javax.swing.JLabel lSource;
    private javax.swing.JPanel pFile;
    private javax.swing.JPanel pFileDetails;
    private javax.swing.JPanel pGallery;
    private javax.swing.JPanel pProgram;
    private javax.swing.JRadioButton rOtherAuthor;
    private javax.swing.JRadioButton rOwnWork;
    private javax.swing.JTextField tAttrib;
    private javax.swing.JCheckBox tCatHints;
    private javax.swing.JTextField tCategories;
    private javax.swing.JCheckBox tCopyCats;
    private javax.swing.JCheckBox tCopyDesc;
    private javax.swing.JCheckBox tCopyName;
    private javax.swing.JTable tDescSource;
    private javax.swing.JTextArea tExtraText;
    private javax.swing.JScrollPane tExtraTextScroll;
    private javax.swing.JTextField tFileDesc;
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
        return Main.settings.quickTemplates.size();
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
            case 0: return Main.settings.quickTemplates.get(rowIndex).active;
            case 1: return Main.settings.quickTemplates.get(rowIndex).name;
            case 2: return Main.settings.quickTemplates.get(rowIndex).template;
            default: return 0;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: Main.settings.quickTemplates.get(rowIndex).active = Boolean.parseBoolean(value.toString()); break;
            case 1: Main.settings.quickTemplates.get(rowIndex).name = value.toString(); break;
            case 2: Main.settings.quickTemplates.get(rowIndex).template = value.toString(); break;
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

final class DescSourceModel extends DefaultTableModel {
    ButtonGroup group;
    public DescSourceModel() {
        group = new ButtonGroup();
        
        JRadioButton selected = (JRadioButton) getValueAt(Main.settings.descSourceSelected, 0);
        selected.setSelected(true);
    }
        
    @Override
    public int getRowCount() {
        return Main.settings.descSources.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: {
                JRadioButton b = new JRadioButton();
                if(rowIndex == Main.settings.descSourceSelected) b.setSelected(true);
                else b.setSelected(false);
                group.add(b);   
                return b;
            }
                        
            case 1: return Main.settings.descSources.get(rowIndex).name;
            case 2: return Main.settings.descSources.get(rowIndex).desc;
            default: return 0;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: 
                JRadioButton b = (JRadioButton) value;
                break;
            case 1: Main.settings.descSources.get(rowIndex).name = value.toString(); break;
            case 2: Main.settings.descSources.get(rowIndex).desc = value.toString(); break;
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

class RadioButtonRenderer implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                                                    boolean hasFocus, int row, int column) {
        if (value==null) return null;
        return (Component)value;
    }
}
/*
class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
    private JRadioButton button;

    public RadioButtonEditor(JCheckBox checkBox) {
        super(checkBox);
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value==null) return null;
        button = new JRadioButton("", isSelected);
        button.addItemListener(this);
        Main.settings.descSourceSelected = row;
        System.out.println("Zmieniam na " + Main.settings.descSourceSelected);
        return (Component)value;
    }

    @Override
    public Object getCellEditorValue() {
        button.removeItemListener(this);

        return button;
    }

    public void itemStateChanged(ItemEvent e) {
        super.fireEditingStopped();
    }
}*/

class RadioButtonEditor extends    DefaultCellEditor
                        implements ItemListener {
  private JRadioButton button;
 
  public RadioButtonEditor(JCheckBox checkBox) {
    super(checkBox);
  }
 
    @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (value==null) return null;
    button = (JRadioButton)value;
    button.addItemListener(this);
    return (Component)value;
  }
 
  public Object getCellEditorValue() {
    button.removeItemListener(this);
    return button;
  }
 
  public void itemStateChanged(ItemEvent e) {
    super.fireEditingStopped();
  }
}


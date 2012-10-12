package cuploader.frames;

import cuploader.Data;
import cuploader.Data.Elem;
import cuploader.FileFilters;
import cuploader.PFile;
import cuploader.Settings;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wikipedia.Wiki;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class Main extends javax.swing.JFrame implements DropTargetListener {
    String version, date;
    Data data;
    File directory = null;

    public Main(String version, String date) {
        this.version = version;
        this.date = date;
        
        int hello = readSettings();
        data = new Data(version, date);
        addWindowListener(exit);
        
        initComponents();
        readLang();
        setLocationRelativeTo(null);
        readPosition();
        
        new DropTarget(pFiles, this);
        
        pFilesScroll.getVerticalScrollBar().setUnitIncrement(16);
        mEdit.setEnabled(false);
        mFileUploadSelect.setEnabled(false);
        mUpload.setEnabled(false);
        
        checkLag();
        setVisible(true);
        
        if(hello==1) 
            JOptionPane.showMessageDialog(rootPane, Data.text("hello"));
        else if(hello==2) {
            File f = new File("autoupdate-session.xml");
            if(f.exists()) {
                loadSessionFile(f);
                JOptionPane.showMessageDialog(rootPane, Data.text("hello-loadsession"));
                f.delete();
            } else
                JOptionPane.showMessageDialog(rootPane, Data.text("hello-newsession"));
        }
        checkVersion();
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        gView = new javax.swing.ButtonGroup();
        mShow = new javax.swing.JPopupMenu();
        mViewAll1 = new javax.swing.JRadioButtonMenuItem();
        mViewToUpload1 = new javax.swing.JRadioButtonMenuItem();
        mViewNotUpload1 = new javax.swing.JRadioButtonMenuItem();
        gLang = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        bLoadFiles = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bLoadSession = new javax.swing.JButton();
        bSaveSession = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bFileEditSelected = new javax.swing.JButton();
        bView = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        bLogin = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bSettings = new javax.swing.JButton();
        bAbout = new javax.swing.JButton();
        pFilesScroll = new javax.swing.JScrollPane();
        pFiles = new javax.swing.JPanel();
        lStartInfo = new javax.swing.JLabel();
        pUserInfo = new javax.swing.JPanel();
        lUserInfo = new javax.swing.JLabel();
        lServer = new javax.swing.JLabel();
        lServerStatus = new javax.swing.JLabel();
        pDesc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pHelp = new javax.swing.JPanel();
        lHelp = new javax.swing.JLabel();
        pUpload = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        bUpload = new javax.swing.JButton();
        lFileUpload = new javax.swing.JLabel();
        mMenu = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        mLoadFiles = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mLoadSession = new javax.swing.JMenuItem();
        mSaveSession = new javax.swing.JMenuItem();
        mCleanSession = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mLogin = new javax.swing.JMenuItem();
        mUpload = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mFileUploadSelect = new javax.swing.JMenu();
        mFileUploadSelectAll = new javax.swing.JMenuItem();
        mFileUploadSelectInv = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mEnd = new javax.swing.JMenuItem();
        mRestart = new javax.swing.JMenuItem();
        mEdit = new javax.swing.JMenu();
        mUndo = new javax.swing.JMenuItem();
        mRedo = new javax.swing.JMenuItem();
        mFileSelectAll = new javax.swing.JMenuItem();
        mFileSelectInv = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mFileSelectedToUpload = new javax.swing.JMenuItem();
        mFileEditSelected = new javax.swing.JMenuItem();
        mView = new javax.swing.JMenu();
        mViewAll = new javax.swing.JRadioButtonMenuItem();
        mViewToUpload = new javax.swing.JRadioButtonMenuItem();
        mViewNotUpload = new javax.swing.JRadioButtonMenuItem();
        mTools = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mLangDe = new javax.swing.JRadioButtonMenuItem();
        mLangEn = new javax.swing.JRadioButtonMenuItem();
        mLangPl = new javax.swing.JRadioButtonMenuItem();
        mSettings = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        mHelpOnline = new javax.swing.JMenuItem();
        mAbout = new javax.swing.JMenuItem();

        gView.add(mViewAll1);
        mViewAll1.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        mViewAll1.setText(bundle.getString("view-all")); // NOI18N
        mViewAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewAll1ActionPerformed(evt);
            }
        });
        mShow.add(mViewAll1);

        gView.add(mViewToUpload1);
        mViewToUpload1.setText(bundle.getString("view-toupload")); // NOI18N
        mViewToUpload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewToUpload1ActionPerformed(evt);
            }
        });
        mShow.add(mViewToUpload1);

        gView.add(mViewNotUpload1);
        mViewNotUpload1.setText(bundle.getString("view-notupload")); // NOI18N
        mViewNotUpload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewNotUpload1ActionPerformed(evt);
            }
        });
        mShow.add(mViewNotUpload1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VicuñaUploader " + version);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cuploader/resources/color-swatch-lama.png")));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(860, 550));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        bLoadFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-import.png"))); // NOI18N
        bLoadFiles.setToolTipText(bundle.getString("folder-read")); // NOI18N
        bLoadFiles.setFocusable(false);
        bLoadFiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bLoadFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadFilesActionPerformed(evt);
            }
        });
        jToolBar1.add(bLoadFiles);
        jToolBar1.add(jSeparator6);

        bLoadSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/blue-folder-open.png"))); // NOI18N
        bLoadSession.setToolTipText(bundle.getString("session-open")); // NOI18N
        bLoadSession.setFocusable(false);
        bLoadSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bLoadSession.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bLoadSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadSessionActionPerformed(evt);
            }
        });
        jToolBar1.add(bLoadSession);

        bSaveSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/disk-black-24.png"))); // NOI18N
        bSaveSession.setToolTipText(bundle.getString("session-save")); // NOI18N
        bSaveSession.setFocusable(false);
        bSaveSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSaveSession.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSaveSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveSessionActionPerformed(evt);
            }
        });
        jToolBar1.add(bSaveSession);
        jToolBar1.add(jSeparator7);

        bFileEditSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image-edit-24.png"))); // NOI18N
        bFileEditSelected.setToolTipText(bundle.getString("files-edit")); // NOI18N
        bFileEditSelected.setFocusable(false);
        bFileEditSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bFileEditSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bFileEditSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFileEditSelectedActionPerformed(evt);
            }
        });
        jToolBar1.add(bFileEditSelected);

        bView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/card-address-img-24.png"))); // NOI18N
        bView.setToolTipText(bundle.getString("view")); // NOI18N
        bView.setFocusable(false);
        bView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewActionPerformed(evt);
            }
        });
        jToolBar1.add(bView);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        bLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/user-24.png"))); // NOI18N
        bLogin.setToolTipText(bundle.getString("login")); // NOI18N
        bLogin.setFocusable(false);
        bLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        jToolBar2.add(bLogin);
        jToolBar2.add(jSeparator8);

        bSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/switch-24.png"))); // NOI18N
        bSettings.setToolTipText(bundle.getString("settings")); // NOI18N
        bSettings.setFocusable(false);
        bSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSettingsActionPerformed(evt);
            }
        });
        jToolBar2.add(bSettings);

        bAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/color-swatch-24.png"))); // NOI18N
        bAbout.setToolTipText(bundle.getString("help-about")); // NOI18N
        bAbout.setFocusable(false);
        bAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAboutActionPerformed(evt);
            }
        });
        jToolBar2.add(bAbout);

        pFilesScroll.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("files"))); // NOI18N
        pFilesScroll.setAutoscrolls(true);
        pFilesScroll.setMinimumSize(new java.awt.Dimension(100, 100));
        pFilesScroll.setPreferredSize(new java.awt.Dimension(100, 100));

        pFiles.setMinimumSize(new java.awt.Dimension(300, 56));
        pFiles.setLayout(new java.awt.GridBagLayout());

        lStartInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        lStartInfo.setText(bundle.getString("start-info")); // NOI18N
        lStartInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        pFiles.add(lStartInfo, gridBagConstraints);

        pFilesScroll.setViewportView(pFiles);

        pUserInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("status"))); // NOI18N

        lUserInfo.setForeground(new java.awt.Color(102, 102, 102));
        lUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/user.png"))); // NOI18N
        lUserInfo.setText(bundle.getString("status-unlogged")); // NOI18N

        lServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/server.png"))); // NOI18N
        lServer.setText(Settings.server);

        lServerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/status-offline.png"))); // NOI18N
        lServerStatus.setText("Status");

        javax.swing.GroupLayout pUserInfoLayout = new javax.swing.GroupLayout(pUserInfo);
        pUserInfo.setLayout(pUserInfoLayout);
        pUserInfoLayout.setHorizontalGroup(
            pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lServer, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pUserInfoLayout.setVerticalGroup(
            pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUserInfoLayout.createSequentialGroup()
                .addComponent(lUserInfo)
                .addGap(18, 18, 18)
                .addComponent(lServer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lServerStatus))
        );

        pDesc.setBorder(javax.swing.BorderFactory.createTitledBorder(Data.text("manual"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter.png"))); // NOI18N
        jLabel1.setText("<html>" + Data.text("manual-1") + "</html>"); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-02.png"))); // NOI18N
        jLabel2.setText("<html>" + Data.text("manual-2") + "</html>"); // NOI18N
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-03.png"))); // NOI18N
        jLabel4.setText("<html>" + Data.text("manual-3") + "</html>"); // NOI18N
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-04.png"))); // NOI18N
        jLabel6.setText("<html>" + Data.text("manual-4") + "</html>"); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-05.png"))); // NOI18N
        jLabel7.setText("<html>" + Data.text("manual-5") + "</html>"); // NOI18N

        javax.swing.GroupLayout pDescLayout = new javax.swing.GroupLayout(pDesc);
        pDesc.setLayout(pDescLayout);
        pDescLayout.setHorizontalGroup(
            pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDescLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pDescLayout.setVerticalGroup(
            pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDescLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pHelp.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("help"))); // NOI18N
        pHelp.setToolTipText("");

        lHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        lHelp.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pHelpLayout = new javax.swing.GroupLayout(pHelp);
        pHelp.setLayout(pHelpLayout);
        pHelpLayout.setHorizontalGroup(
            pHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHelpLayout.setVerticalGroup(
            pHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        pUpload.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("toupload"))); // NOI18N

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        bUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/drive-upload-24.png"))); // NOI18N
        bUpload.setToolTipText(bundle.getString("upload")); // NOI18N
        bUpload.setFocusable(false);
        bUpload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bUpload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUploadActionPerformed(evt);
            }
        });
        jToolBar4.add(bUpload);

        lFileUpload.setText("0 / 0 (0 MiB)");
        jToolBar4.add(lFileUpload);

        javax.swing.GroupLayout pUploadLayout = new javax.swing.GroupLayout(pUpload);
        pUpload.setLayout(pUploadLayout);
        pUploadLayout.setHorizontalGroup(
            pUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUploadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pUploadLayout.setVerticalGroup(
            pUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUploadLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mFile.setText(bundle.getString("file")); // NOI18N

        mLoadFiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        mLoadFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-import_1.png"))); // NOI18N
        mLoadFiles.setText(Data.text("folder-read")); // NOI18N
        mLoadFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoadFilesActionPerformed(evt);
            }
        });
        mFile.add(mLoadFiles);
        mFile.add(jSeparator5);

        mLoadSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mLoadSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/blue-folder-open_1.png"))); // NOI18N
        mLoadSession.setText(bundle.getString("session-open")); // NOI18N
        mLoadSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoadSessionActionPerformed(evt);
            }
        });
        mFile.add(mLoadSession);

        mSaveSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSaveSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/disk-black.png"))); // NOI18N
        mSaveSession.setText(bundle.getString("session-save")); // NOI18N
        mSaveSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveSessionActionPerformed(evt);
            }
        });
        mFile.add(mSaveSession);

        mCleanSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        mCleanSession.setText(bundle.getString("session-clear")); // NOI18N
        mCleanSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCleanSessionActionPerformed(evt);
            }
        });
        mFile.add(mCleanSession);
        mFile.add(jSeparator3);

        mLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_QUOTE, java.awt.event.InputEvent.CTRL_MASK));
        mLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/users.png"))); // NOI18N
        mLogin.setText(bundle.getString("login")); // NOI18N
        mLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginActionPerformed(evt);
            }
        });
        mFile.add(mLogin);

        mUpload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/drive-upload.png"))); // NOI18N
        mUpload.setText(bundle.getString("upload")); // NOI18N
        mUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUploadActionPerformed(evt);
            }
        });
        mFile.add(mUpload);
        mFile.add(jSeparator4);

        mFileUploadSelect.setText(bundle.getString("files-to-upload")); // NOI18N

        mFileUploadSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mFileUploadSelectAll.setText(bundle.getString("files-select-all")); // NOI18N
        mFileUploadSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileUploadSelectAllActionPerformed(evt);
            }
        });
        mFileUploadSelect.add(mFileUploadSelectAll);

        mFileUploadSelectInv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mFileUploadSelectInv.setText(bundle.getString("files-inv")); // NOI18N
        mFileUploadSelectInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileUploadSelectInvActionPerformed(evt);
            }
        });
        mFileUploadSelect.add(mFileUploadSelectInv);

        mFile.add(mFileUploadSelect);
        mFile.add(jSeparator1);

        mEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mEnd.setText(bundle.getString("button-close")); // NOI18N
        mEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEndActionPerformed(evt);
            }
        });
        mFile.add(mEnd);

        mRestart.setText(bundle.getString("restart")); // NOI18N
        mRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRestartActionPerformed(evt);
            }
        });
        mFile.add(mRestart);

        mMenu.add(mFile);

        mEdit.setText(bundle.getString("edit")); // NOI18N

        mUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-transition.png"))); // NOI18N
        mUndo.setText(bundle.getString("undo")); // NOI18N
        mUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUndoActionPerformed(evt);
            }
        });
        mEdit.add(mUndo);

        mRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-transition-180.png"))); // NOI18N
        mRedo.setText(bundle.getString("redo")); // NOI18N
        mRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRedoActionPerformed(evt);
            }
        });
        mEdit.add(mRedo);

        mFileSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mFileSelectAll.setText(bundle.getString("files-select-all")); // NOI18N
        mFileSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileSelectAllActionPerformed(evt);
            }
        });
        mEdit.add(mFileSelectAll);

        mFileSelectInv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mFileSelectInv.setText(bundle.getString("files-inv")); // NOI18N
        mFileSelectInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileSelectInvActionPerformed(evt);
            }
        });
        mEdit.add(mFileSelectInv);
        mEdit.add(jSeparator2);

        mFileSelectedToUpload.setText(bundle.getString("files-select-to-upload")); // NOI18N
        mFileSelectedToUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileSelectedToUploadActionPerformed(evt);
            }
        });
        mEdit.add(mFileSelectedToUpload);

        mFileEditSelected.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mFileEditSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image--pencil.png"))); // NOI18N
        mFileEditSelected.setText(bundle.getString("files-edit")); // NOI18N
        mFileEditSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFileEditSelectedActionPerformed(evt);
            }
        });
        mEdit.add(mFileEditSelected);

        mMenu.add(mEdit);

        mView.setText(bundle.getString("view")); // NOI18N

        gView.add(mViewAll);
        mViewAll.setText(bundle.getString("view-all")); // NOI18N
        mViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewAllActionPerformed(evt);
            }
        });
        mView.add(mViewAll);

        gView.add(mViewToUpload);
        mViewToUpload.setText(bundle.getString("view-toupload")); // NOI18N
        mViewToUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewToUploadActionPerformed(evt);
            }
        });
        mView.add(mViewToUpload);

        gView.add(mViewNotUpload);
        mViewNotUpload.setText(bundle.getString("view-notupload")); // NOI18N
        mViewNotUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewNotUploadActionPerformed(evt);
            }
        });
        mView.add(mViewNotUpload);

        mMenu.add(mView);

        mTools.setText(bundle.getString("tools")); // NOI18N

        jMenu1.setText(bundle.getString("settings-lang")); // NOI18N

        gLang.add(mLangDe);
        mLangDe.setText("Deutsch (de)");
        mLangDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLangDeActionPerformed(evt);
            }
        });
        jMenu1.add(mLangDe);

        gLang.add(mLangEn);
        mLangEn.setText("English (en)");
        mLangEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLangEnActionPerformed(evt);
            }
        });
        jMenu1.add(mLangEn);

        gLang.add(mLangPl);
        mLangPl.setText("Polski (pl)");
        mLangPl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLangPlActionPerformed(evt);
            }
        });
        jMenu1.add(mLangPl);

        mTools.add(jMenu1);

        mSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/switch.png"))); // NOI18N
        mSettings.setText(bundle.getString("settings")); // NOI18N
        mSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSettingsActionPerformed(evt);
            }
        });
        mTools.add(mSettings);

        mMenu.add(mTools);

        mHelp.setText(bundle.getString("help")); // NOI18N

        mHelpOnline.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        mHelpOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/lifebuoy.png"))); // NOI18N
        mHelpOnline.setText(bundle.getString("help-help")); // NOI18N
        mHelpOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHelpOnlineActionPerformed(evt);
            }
        });
        mHelp.add(mHelpOnline);

        mAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/color-swatch_1.png"))); // NOI18N
        mAbout.setText(bundle.getString("help-about")); // NOI18N
        mAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAboutActionPerformed(evt);
            }
        });
        mHelp.add(mAbout);

        mMenu.add(mHelp);

        setJMenuBar(mMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pFilesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pFilesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginActionPerformed
        if(Data.isLogged) {
            Settings.wiki.logout();
            Data.isLogged = false;
            setLogged(false);
        } else {
            if(Data.fLogin==null) Data.fLogin = new FLogin(data);
            else Data.fLogin.setVisible(true);
        }
    }//GEN-LAST:event_mLoginActionPerformed

    private void mEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEndActionPerformed
        exit.windowClosing(null);
    }//GEN-LAST:event_mEndActionPerformed

    private void mUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUploadActionPerformed
        if(Data.filesUpload==0)
            JOptionPane.showMessageDialog(rootPane, Data.text("upload-selectfiles"), Data.text("uploading"), JOptionPane.ERROR_MESSAGE);
        else {
            if(Settings.wiki==null) {
                if(Data.fLogin==null) Data.fLogin = new FLogin(data);
                else Data.fLogin.setVisible(true);
            }
            else {
                if(Data.fUploadCheck==null) Data.fUploadCheck = new FUploadCheck(data);
                else Data.fUploadCheck.setVisible(true);
            }
        }
    }//GEN-LAST:event_mUploadActionPerformed

    private void mFileUploadSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileUploadSelectAllActionPerformed
        for(PFile i : Data.getFiles())
            i.selectToUpload(true);
    }//GEN-LAST:event_mFileUploadSelectAllActionPerformed

    private void mFileUploadSelectInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileUploadSelectInvActionPerformed
        for(PFile i : Data.getFiles())
            i.selectToUpload(!i.toUpload);
    }//GEN-LAST:event_mFileUploadSelectInvActionPerformed

    private void mFileEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileEditSelectedActionPerformed
        if(Data.filesEdit>0) {
            if(Data.fFileEdit==null) Data.fFileEdit = new FFileEdit();
            else Data.fFileEdit.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(rootPane, Data.text("edit-selectfiles"), Data.text("editing"), JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_mFileEditSelectedActionPerformed

    private void mLoadFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoadFilesActionPerformed
        //@TODO: translate: http://www.java-forums.org/new-java/13699-filechooser-ui.html
        JFileChooser ch = new JFileChooser();
            ch.setCurrentDirectory(directory);
            ch.setDialogTitle(Data.text("files-load"));
            ch.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            ch.setMultiSelectionEnabled(true);
            ch.setAcceptAllFileFilterUsed(false);
            ch.addChoosableFileFilter(FileFilters.all);
            ch.addChoosableFileFilter(FileFilters.images);
            ch.addChoosableFileFilter(FileFilters.documents);
            ch.addChoosableFileFilter(FileFilters.multimedia);
            
            if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File[] selected = ch.getSelectedFiles();
                ArrayList<File> files = new ArrayList<File>();
                
                array = new ArrayList<File>();

                for(File f : selected) {
                    if(Settings.loadSubdirectory)
                        addToArray(f);
                    else {
                        if(f.isDirectory())
                            array.addAll(Arrays.asList(f.listFiles())); 
                        if(f.isFile())
                            array.add(f);
                    }
                }
                addImages(array);
                directory = ch.getCurrentDirectory();
            }
    }//GEN-LAST:event_mLoadFilesActionPerformed

    private void mFileSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileSelectAllActionPerformed
        for(PFile i : Data.getFiles())
            i.selectToEdit(true);
    }//GEN-LAST:event_mFileSelectAllActionPerformed

    private void mFileSelectInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileSelectInvActionPerformed
        for(PFile i : Data.getFiles())
            i.selectToEdit(!i.toEdit);
    }//GEN-LAST:event_mFileSelectInvActionPerformed

    private void mFileSelectedToUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFileSelectedToUploadActionPerformed
        for(PFile i : Data.getFiles())
            if(i.toEdit)
                i.selectToUpload(true);
    }//GEN-LAST:event_mFileSelectedToUploadActionPerformed

    private void mSaveSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveSessionActionPerformed
        saveSession();
    }//GEN-LAST:event_mSaveSessionActionPerformed

    private void mLoadSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoadSessionActionPerformed
        loadSession();
    }//GEN-LAST:event_mLoadSessionActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        if(Data.fAbout==null) Data.fAbout = new FAbout();
        else Data.fAbout.setVisible(true);
    }//GEN-LAST:event_mAboutActionPerformed

    private void mCleanSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCleanSessionActionPerformed
        Object[] o = {Data.text("button-clear"), Data.text("button-cancel")};
        int n = JOptionPane.showOptionDialog(rootPane, Data.text("session-clear-q"), Data.text("session"), 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, o, o[0]);
        switch(n) {
            case 0: {
                Data.getFiles().clear();
                pFiles.removeAll();
                pFiles.repaint();

                mEdit.setEnabled(false);
                mFileUploadSelect.setEnabled(false);
                mUpload.setEnabled(false);
                
                Data.updateFileCounter();
                break;
            }
            case 1:
                break;
            default: break;
        }
    }//GEN-LAST:event_mCleanSessionActionPerformed

    private void mSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSettingsActionPerformed
        if(Data.fSettings==null) Data.fSettings = new FSettings(); 
        else Data.fSettings.setVisible(true);
    }//GEN-LAST:event_mSettingsActionPerformed

    private void mViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewAllActionPerformed
        for(PFile f : Data.getFiles())
            f.setVisible(true);
    }//GEN-LAST:event_mViewAllActionPerformed

    private void mViewToUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewToUploadActionPerformed
        for(PFile f : Data.getFiles())
            if(f.toUpload) f.setVisible(true);
            else f.setVisible(false);
    }//GEN-LAST:event_mViewToUploadActionPerformed

    private void mViewNotUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewNotUploadActionPerformed
        for(PFile f : Data.getFiles())
            if(f.toUpload) f.setVisible(false);
                else f.setVisible(true);
    }//GEN-LAST:event_mViewNotUploadActionPerformed

    private void bLoadFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadFilesActionPerformed
        mLoadFilesActionPerformed(evt);
    }//GEN-LAST:event_bLoadFilesActionPerformed

    private void bLoadSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadSessionActionPerformed
        mLoadSessionActionPerformed(evt);
    }//GEN-LAST:event_bLoadSessionActionPerformed

    private void bSaveSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveSessionActionPerformed
        mSaveSessionActionPerformed(evt);
    }//GEN-LAST:event_bSaveSessionActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        mLoginActionPerformed(evt);
    }//GEN-LAST:event_bLoginActionPerformed

    private void bFileEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFileEditSelectedActionPerformed
        mFileEditSelectedActionPerformed(evt);
    }//GEN-LAST:event_bFileEditSelectedActionPerformed

    private void bSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSettingsActionPerformed
        mSettingsActionPerformed(evt);
    }//GEN-LAST:event_bSettingsActionPerformed

    private void bAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAboutActionPerformed
        mAboutActionPerformed(evt);
    }//GEN-LAST:event_bAboutActionPerformed

    private void bViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewActionPerformed
        mShow.show(bView, 0, 25);
    }//GEN-LAST:event_bViewActionPerformed

    private void mViewAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewAll1ActionPerformed
         mViewAllActionPerformed(evt);
    }//GEN-LAST:event_mViewAll1ActionPerformed

    private void mViewToUpload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewToUpload1ActionPerformed
        mViewToUploadActionPerformed(evt);
    }//GEN-LAST:event_mViewToUpload1ActionPerformed

    private void mViewNotUpload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewNotUpload1ActionPerformed
        mViewNotUploadActionPerformed(evt);
    }//GEN-LAST:event_mViewNotUpload1ActionPerformed

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUploadActionPerformed
        mUploadActionPerformed(evt);
    }//GEN-LAST:event_bUploadActionPerformed

    private void mUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUndoActionPerformed
        if(Data.manager.canUndo())
            Data.manager.undo();
    }//GEN-LAST:event_mUndoActionPerformed

    private void mRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRedoActionPerformed
        if(Data.manager.canRedo())
            Data.manager.redo();
    }//GEN-LAST:event_mRedoActionPerformed

    private void mHelpOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHelpOnlineActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/yarl/vicuna/wiki#head"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mHelpOnlineActionPerformed

    private void mRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRestartActionPerformed
        ConfirmClose(true);
    }//GEN-LAST:event_mRestartActionPerformed

    private void mLangEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLangEnActionPerformed
        changeLang(Locale.ENGLISH);
    }//GEN-LAST:event_mLangEnActionPerformed

    private void mLangPlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLangPlActionPerformed
        changeLang(new Locale("pl"));
    }//GEN-LAST:event_mLangPlActionPerformed

    private void mLangDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLangDeActionPerformed
        changeLang(Locale.GERMAN);
    }//GEN-LAST:event_mLangDeActionPerformed

    /**
     * Init
     **/
    //<editor-fold defaultstate="collapsed" desc=" Init ">
    
    /**
     * Checks if settings file exist
     * @return true if exist
     */
    private int readSettings() {
        int i = 0;
        try {
            FileInputStream f = new FileInputStream(".vicuna-settings");
            if(f!=null) {
                ObjectInputStream in = new ObjectInputStream(f);
                Settings s = (Settings) in.readObject();
                in.close();
                if(Settings.lang==null) Settings.lang = getLocale();
            }
        } catch (FileNotFoundException ex) {
                setDefaultLang();
                i = 1;
        } catch (ClassNotFoundException ex) {
                setDefaultLang();
        } catch (IOException ex) {
                setDefaultLang();
                i = 2;
        }
        
        Locale.setDefault(Settings.lang);
        Data.text = java.util.ResourceBundle.getBundle("cuploader/text/messages", Settings.lang);
        return i;
    }
    
    private void setDefaultLang() {
        Locale loc = getLocale();
        
        if(loc.equals(new Locale("pl", "PL")))
            Settings.lang = new Locale("pl");
        else
            Settings.lang = loc;
    }
    
    private void readLang() {
        Locale l = Settings.lang;
        if(l.equals(Locale.ENGLISH) || l.equals(Locale.UK) || l.equals(Locale.US)) mLangEn.setSelected(true);
        else if(l.equals(Locale.GERMAN)) mLangDe.setSelected(true);
        else if(l.equals(new Locale("pl")) || l.equals(new Locale("pl", "PL"))) mLangPl.setSelected(true);
    }
    
    private void readPosition() {
        if(Settings.position != null && Settings.size!= null)
            setBounds(Settings.position.x, Settings.position.y, Settings.size.width, Settings.size.height);
    }
    
    private void checkVersion() {
        try {
            String v = new Wiki("commons.wikimedia.org").getPageText("User:Yarl/VicunaUploader/version").trim();
            if(Double.parseDouble(v)>Double.parseDouble(Data.version)) {
                Object[] o = {Data.text("button-autoupdate"), Data.text("button-download"), Data.text("button-cancel")};
                int n = JOptionPane.showOptionDialog(rootPane, "<html><body>" + Data.text("about-checkupdate-text") + " (<b>" + v + "</b>).</body></html>", 
                        Data.text("about-checkupdate"), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, o, o[0]);
                if(n==0)
                    new FDownload(this);
                else if(n==1) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/yarl/vicuna/downloads"));
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } 
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void checkLag() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        int lag = new Wiki(Settings.server).getCurrentDatabaseLag();
                        if(lag==0) {
                            lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status.png")));
                            lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-ok"));
                        } else if(lag>0 && lag<=5) {
                            lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-away.png")));
                            lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-lag") + " " + lag + " s");
                        } else {
                            lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-busy.png")));
                            lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-lag") + " " + lag + " s");
                        }
                    } catch (IOException ex) {
                        lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-offline"));
                        lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-offline.png")));
                    }
                    try { Thread.sleep(5000); } catch (InterruptedException ex) {}
                }
            }
        };
        Thread t = new Thread(run);
        t.start();
    }
    
    //</editor-fold>
    
    /**
     * Saving session
     **/
    //<editor-fold defaultstate="collapsed" desc=" Saving session ">
    private void saveSession() {
        JFileChooser ch = new JFileChooser();
        ch.setCurrentDirectory(directory);
        ch.setDialogTitle(Data.text("session-save"));
        ch.setAcceptAllFileFilterUsed(false);
        ch.addChoosableFileFilter(FileFilters.session);
        ch.setSelectedFile(new File(directory, "session"));

        if (ch.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file;

            if(ch.getSelectedFile().getAbsolutePath().endsWith(".xml"))
                file = new File(ch.getSelectedFile().getAbsolutePath());
            else    
                file = new File(ch.getSelectedFile().getAbsolutePath()+".xml");

            //System.out.println(file);
            if(!file.exists()) {
                try {
                    file = new File(file.getAbsoluteFile()+"");
                    file.createNewFile();
                    //boolean result = SaveSession(file);
                    boolean result = saveSessionFile(file);
                    if(result) JOptionPane.showMessageDialog(rootPane, Data.text("session-save-success"), Data.text("session-save"), JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, Data.text("error") + ": " + ex.toString());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                int dialog = JOptionPane.showConfirmDialog(rootPane, Data.text("session-save-exist"));
                if(dialog==0) {
                    boolean result = saveSessionFile(file);
                    if(result) JOptionPane.showMessageDialog(rootPane, Data.text("session-save-success"));
                }
            }
        }
    }
    
    /***
     * Saves session into XML file.
     * @param f destination file
     * @return true if OK
     */
    public boolean saveSessionFile(File f) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            String text;
            
            // SETTINGS
            Document doc = docBuilder.newDocument();
            Element root = doc.createElement("session");
                doc.appendChild(root);

            Element elem = doc.createElement("server");
                elem.appendChild(doc.createTextNode(Settings.server));
                root.appendChild(elem);
            elem = doc.createElement("user");
                text = Settings.username.isEmpty() ? "null" : Settings.username;
                elem.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                root.appendChild(elem);
            elem = doc.createElement("author");
                text = Settings.author.isEmpty() ? "null" : Settings.author;
                elem.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                root.appendChild(elem);
            elem = doc.createElement("source");
                text = Settings.source.isEmpty() ? "null" : Settings.source;
                elem.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                root.appendChild(elem);
                
            Element license = doc.createElement("license");
                root.appendChild(license);

                Attr id = doc.createAttribute("id");
                    id.setValue(Settings.license+"");
                    license.setAttributeNode(id);
                Attr custom = doc.createAttribute("custom");
                    text = Data.licensesTemplates.get(Data.licensesTemplates.size()-1).isEmpty() ? "null" : Data.licensesTemplates.get(Data.licensesTemplates.size()-1);
                    custom.setValue(text);
                    license.setAttributeNode(custom);
                Attr attributon = doc.createAttribute("attribution");
                    text = Settings.attrib.isEmpty() ? "null" : Settings.attrib;
                    attributon.setValue(text.replace("&", "amp;"));
                    license.setAttributeNode(attributon);

            Element gallery = doc.createElement("gallery");
                root.appendChild(gallery);

                Attr create = doc.createAttribute("create");
                    create.setValue(Settings.createGallery+"");
                    gallery.setAttributeNode(create);
                Attr page = doc.createAttribute("page");
                    text = Settings.galleryPage.isEmpty() ? "null" : Settings.galleryPage;
                    page.setValue(text.replace("&", "amp;"));
                    gallery.setAttributeNode(page);
                Attr header = doc.createAttribute("header");
                    header.setValue(Settings.galleryHeader+"");
                    gallery.setAttributeNode(header);
                Attr width = doc.createAttribute("width");
                    width.setValue(Settings.galleryWidth+"");
                    gallery.setAttributeNode(width);
                Attr ontop = doc.createAttribute("ontop");
                    ontop.setValue(Settings.galleryOnTop+"");
                    gallery.setAttributeNode(ontop);   

            Element other = doc.createElement("other");
                root.appendChild(other);

                Attr attr = doc.createAttribute("read_exif_hour");
                    attr.setValue(Settings.readExifHour+"");
                    other.setAttributeNode(attr);
                attr = doc.createAttribute("rename_after_upload");
                    attr.setValue(Settings.renameAfterUpload+"");
                    other.setAttributeNode(attr);
                attr = doc.createAttribute("load_subdirectory");
                    attr.setValue(Settings.loadSubdirectory+"");
                    other.setAttributeNode(attr);
                attr = doc.createAttribute("ask_quit");
                    attr.setValue(Settings.askQuit+"");
                    other.setAttributeNode(attr);
                attr = doc.createAttribute("file_desc_dource");
                    attr.setValue(Settings.fileDescSource+"");
                    other.setAttributeNode(attr);
                attr = doc.createAttribute("file_desc_path");
                    text = Settings.fileDescPath.isEmpty() ? "null" : Settings.fileDescPath;
                    attr.setValue(text.replace("&", "amp;"));
                    other.setAttributeNode(attr);

            Element categories = doc.createElement("categories");
                text = Settings.categories.isEmpty() ? "null" : Settings.categories;
                categories.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                root.appendChild(categories);
                    
            Element extra_text = doc.createElement("extra_text");
                text = Settings.extratext.isEmpty() ? "null" : Settings.extratext;
                extra_text.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                root.appendChild(extra_text);

            // FILES
            for(PFile i : Data.getFiles()) {
                Element file = doc.createElement("file");
                    //server.appendChild(doc.createTextNode(Settings.server));
                    root.appendChild(file);

                    Attr path = doc.createAttribute("path");
                        path.setValue(i.file.getAbsolutePath().replace("&", "amp;"));
                        file.setAttributeNode(path);
                    Attr upload = doc.createAttribute("upload");
                        upload.setValue(i.toUpload+"");
                        file.setAttributeNode(upload);
                    Attr edit = doc.createAttribute("edit");
                        edit.setValue(i.toEdit+"");
                        file.setAttributeNode(edit);

                Element name = doc.createElement("name");
                text = i.getComponent(Elem.NAME).isEmpty() ? "null" : i.getComponent(Elem.NAME);
                    name.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                    file.appendChild(name);

                Element date2 = doc.createElement("date");
                text = i.getComponent(Elem.DATE).isEmpty() ? "null" : i.getComponent(Elem.DATE);
                    date2.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                    file.appendChild(date2);

                Element desc = doc.createElement("desc");
                text = i.getComponent(Elem.DESC).isEmpty() ? "null" : i.getComponent(Elem.DESC);
                    desc.appendChild(doc.createTextNode(text.replace("&", "amp;").replace("\n", "\\n")));
                    file.appendChild(desc);

                Element coor = doc.createElement("coor");
                text = i.getComponent(Elem.COOR).isEmpty() ? "null" : i.getComponent(Elem.COOR);
                    coor.appendChild(doc.createTextNode(text));
                    file.appendChild(coor);

                Element cats = doc.createElement("cats");
                text = i.getComponent(Elem.CATS).isEmpty() ? "null" : i.getComponent(Elem.CATS);
                    cats.appendChild(doc.createTextNode(text.replace("&", "amp;")));
                    file.appendChild(cats);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            return true;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //</editor-fold>
    
    /**
     * Loading session
     **/
    //<editor-fold defaultstate="collapsed" desc=" Loading session ">
    /**
     * Reads session
     */
    private void loadSession() {
        JFileChooser ch = new JFileChooser();
        ch.setCurrentDirectory(directory);
        ch.setDialogTitle(Data.text("session-load"));
        ch.setAcceptAllFileFilterUsed(false);
        ch.setMultiSelectionEnabled(false);
        ch.addChoosableFileFilter(FileFilters.session);

        if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if(ch.getSelectedFile().isFile())
                loadSessionFile(ch.getSelectedFile());
            else
                JOptionPane.showMessageDialog(rootPane, Data.text("session-load-error"), Data.text("session-load"), JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    /**
     * Reads session from XML file.
     * @param f source file
     */
    public void loadSessionFile(File f) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            final ArrayList<File> fPath = new ArrayList<File>();
            final ArrayList<Boolean> fEdit = new ArrayList<Boolean>();
            final ArrayList<Boolean> fUpload = new ArrayList<Boolean>();
            final ArrayList<String> fName = new ArrayList<String>();
            final ArrayList<String> fDate = new ArrayList<String>();
            final ArrayList<String> fDesc = new ArrayList<String>();
            final ArrayList<String> fCoor = new ArrayList<String>();
            final ArrayList<String> fCats = new ArrayList<String>();
            
            DefaultHandler handler = new DefaultHandler() {
                String tag = "";
                TreeMap<String, String> attr;
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    String text;
                    tag = qName;
                    attr = new TreeMap<String, String>();

                    if(attributes.getLength()>0) {
                        for(int i=0;i<attributes.getLength();++i)
                             attr.put(attributes.getLocalName(i), attributes.getValue(i));
                        
                        if(tag.equals("license")) {
                            Settings.license = Integer.parseInt(attr.get("id"));
                            text = attr.get("custom").equals("null") ? "" : attr.get("custom");
                            Data.licensesTemplates.set(Data.licensesTemplates.size()-1, text.replace("amp;", "&"));
                            
                            if(attr.get("attribution")!=null) {
                                text = attr.get("attribution").equals("null") ? "" : attr.get("attribution");
                                Settings.attrib = text.replace("amp;", "&");
                            }
                        } 
                        else if(tag.equals("gallery")) {
                            if(attr.get("create")!=null) Settings.createGallery = Boolean.parseBoolean(attr.get("create"));
                            if(attr.get("header")!=null) Settings.galleryHeader = Integer.parseInt(attr.get("header"));
                            
                            if(attr.get("page")!=null) {
                                text = attr.get("page").equals("null") ? "" : attr.get("page");
                                Settings.galleryPage = text.replace("amp;", "&");
                            }
                            if(attr.get("width")!=null) Settings.galleryWidth = Integer.parseInt(attr.get("width"));
                            if(attr.get("ontop")!=null) Settings.galleryOnTop = Boolean.parseBoolean(attr.get("ontop"));
                        } 
                        else if(tag.equals("other")) {
                            if(attr.get("read_exif_hour")!=null) Settings.readExifHour = Boolean.parseBoolean(attr.get("read_exif_hour"));
                            if(attr.get("rename_after_upload")!=null) Settings.renameAfterUpload = Boolean.parseBoolean(attr.get("rename_after_upload"));
                            if(attr.get("load_subdirectory")!=null) Settings.loadSubdirectory = Boolean.parseBoolean(attr.get("load_subdirectory"));
                            if(attr.get("ask_quit")!=null) Settings.askQuit = Boolean.parseBoolean(attr.get("ask_quit"));
                            if(attr.get("file_desc_dource")!=null) Settings.fileDescSource = Integer.parseInt(attr.get("file_desc_dource"));
                            if(attr.get("file_desc_path")!=null) {
                                text = attr.get("file_desc_path").equals("null") ? "" : attr.get("file_desc_path");
                                Settings.fileDescPath = text.replace("amp;", "&");
                            }
                        }
                        else if(tag.equals("file")) {
                            fPath.add(new File(attr.get("path").replace("amp;", "&")));
                            fEdit.add(Boolean.parseBoolean(attr.get("edit")));
                            fUpload.add(Boolean.parseBoolean(attr.get("upload")));
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    String text = new String(ch, start, length);
                    text = text.equals("null") ? "" : text;
                    //System.out.println("\tTag: " + tag + ", wartość: " + text);
                    if(tag.equals("server"))
                        Settings.server = text;
                    else if(tag.equals("user"))
                        Settings.username = text.replace("amp;", "&");
                    else if(tag.equals("author"))
                        Settings.author = text.replace("amp;", "&");
                    else if(tag.equals("source"))
                        Settings.source = text.replace("amp;", "&");
                    else if(tag.equals("extra_text"))
                        Settings.extratext = text.replace("amp;", "&");
                    else if(tag.equals("categories"))
                        Settings.categories = text.replace("amp;", "&");
                    
                    else if(tag.equals("name")) fName.add(text.replace("amp;", "&"));
                    else if(tag.equals("date")) fDate.add(text.replace("amp;", "&"));
                    else if(tag.equals("desc")) fDesc.add(text.replace("amp;", "&").replace("\\n", "\n"));
                    else if(tag.equals("coor")) fCoor.add(text);
                    else if(tag.equals("cats")) fCats.add(text.replace("amp;", "&"));
                }

            };
            saxParser.parse(f, handler);
            new FFileLoading(fPath, fEdit, fUpload, fName, fDate, fDesc, fCoor, fCats);
            lStartInfo.setVisible(false);
            mEdit.setEnabled(true);
            mFileUploadSelect.setEnabled(true);
            mUpload.setEnabled(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, Data.text("session-error") + " " + e.getLocalizedMessage(), Data.text("session-load"), JOptionPane.ERROR_MESSAGE, null);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //</editor-fold>
    
    /**
     * Adding files
     **/
    //<editor-fold defaultstate="collapsed" desc=" Adding files ">
    /***
     * Reads directory and/or files to upload, send list of files to 'loading frame'.
     * @param files array of selected directories/files
     * @return true if ok
     */
    public synchronized boolean addImages(ArrayList<File> files) {
        
        if(!files.isEmpty()) {
            ArrayList<File> vector = new ArrayList<File>();
            
            for(File f : files) { 
                if(f.isFile()) {
                    String name = f.getName();
                    String ext = name.substring(name.lastIndexOf('.')+1).toLowerCase();
                    if(ext.matches("jpg") || ext.matches("png") || ext.matches("svg") || ext.matches("gif") || 
                            ext.matches("pdf") || ext.matches("djvu") || ext.matches("ogg") || 
                            ext.matches("ogv")) {

                        boolean dupe = false;
                        for(PFile ff : Data.getFiles()) {
                            if(ff.file.equals(f)) {
                                dupe = true;
                                break;
                            }
                        }
                        if(!dupe) {
                            vector.add(f);
                        }
                    }
                }
            }

            if(vector.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, Data.text("loading-nofiles"), Data.text("loading"), 
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else {
                new FFileLoading(vector);
                lStartInfo.setVisible(false);
                mEdit.setEnabled(true);
                mFileUploadSelect.setEnabled(true);
                mUpload.setEnabled(true);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, Data.text("loading-nofiles"), Data.text("loading"), 
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    //</editor-fold>
    
    /**
     * Closing
     **/
    //<editor-fold defaultstate="collapsed" desc=" Closing ">
   
    WindowListener exit = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            if(Settings.askQuit) 
                ConfirmClose(false);
            else Close();
        }
    };
       
    /*
     * 'Are you sure' window
     */
    public void ConfirmClose(boolean restart) {
        Object[] options = { Data.text("button-close"), Data.text("button-save&close"), Data.text("button-cancel")};
        int n = JOptionPane.showOptionDialog(rootPane, Data.text("quit-confirm"), Data.text("end"), 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
          
        switch(n) {
            case 0: {
                if(restart) Restart();
                Close();
                break;
            } case 1: {
                mSaveSessionActionPerformed(new ActionEvent(mFile, 0, null));
                if(restart) Restart();
                Close();
                break;
            } case 2 : 
                break;
            default: break;
        }
    }
    
    void Close() {
        Settings.position = getLocation();
        Settings.size = getSize();
        Settings.Serialize();
        System.exit(0);
    }
    
    void Restart() {
        try {
            final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            /* is it a jar file? */
            if(!currentJar.getName().endsWith(".jar"))
                return;

            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>
    
    /**
     * Changes language
     * @TODO: needs restart now
     * @param lang target locale
     */
    void changeLang(Locale lang) {
        Settings.lang = lang;
        
        Object[] o = {Data.text("button-restart"), Data.text("server-ok")};
        int n = JOptionPane.showOptionDialog(rootPane, Data.text("settings-lang-info"), 
                Data.text("settings-lang"), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, o, o[0]);
        if(n==0)
            ConfirmClose(true);
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        String version = "1.16";
        String date = "2012-10-12";

        final JFrame frame = new Main(version, date);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbout;
    private javax.swing.JButton bFileEditSelected;
    private javax.swing.JButton bLoadFiles;
    private javax.swing.JButton bLoadSession;
    public static javax.swing.JButton bLogin;
    private javax.swing.JButton bSaveSession;
    private javax.swing.JButton bSettings;
    private javax.swing.JButton bUpload;
    private javax.swing.JButton bView;
    private javax.swing.ButtonGroup gLang;
    private javax.swing.ButtonGroup gView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar4;
    public static javax.swing.JLabel lFileUpload;
    public static javax.swing.JLabel lHelp;
    public static javax.swing.JLabel lServer;
    private javax.swing.JLabel lServerStatus;
    private javax.swing.JLabel lStartInfo;
    public static javax.swing.JLabel lUserInfo;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mCleanSession;
    private javax.swing.JMenu mEdit;
    private javax.swing.JMenuItem mEnd;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuItem mFileEditSelected;
    private javax.swing.JMenuItem mFileSelectAll;
    private javax.swing.JMenuItem mFileSelectInv;
    private javax.swing.JMenuItem mFileSelectedToUpload;
    private javax.swing.JMenu mFileUploadSelect;
    private javax.swing.JMenuItem mFileUploadSelectAll;
    private javax.swing.JMenuItem mFileUploadSelectInv;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenuItem mHelpOnline;
    private javax.swing.JRadioButtonMenuItem mLangDe;
    private javax.swing.JRadioButtonMenuItem mLangEn;
    private javax.swing.JRadioButtonMenuItem mLangPl;
    private javax.swing.JMenuItem mLoadFiles;
    private javax.swing.JMenuItem mLoadSession;
    public static javax.swing.JMenuItem mLogin;
    private javax.swing.JMenuBar mMenu;
    private javax.swing.JMenuItem mRedo;
    private javax.swing.JMenuItem mRestart;
    private javax.swing.JMenuItem mSaveSession;
    private javax.swing.JMenuItem mSettings;
    private javax.swing.JPopupMenu mShow;
    private javax.swing.JMenu mTools;
    private javax.swing.JMenuItem mUndo;
    private javax.swing.JMenuItem mUpload;
    private javax.swing.JMenu mView;
    private javax.swing.JRadioButtonMenuItem mViewAll;
    private javax.swing.JRadioButtonMenuItem mViewAll1;
    private javax.swing.JRadioButtonMenuItem mViewNotUpload;
    private javax.swing.JRadioButtonMenuItem mViewNotUpload1;
    private javax.swing.JRadioButtonMenuItem mViewToUpload;
    private javax.swing.JRadioButtonMenuItem mViewToUpload1;
    private javax.swing.JPanel pDesc;
    public static javax.swing.JPanel pFiles;
    private javax.swing.JScrollPane pFilesScroll;
    private javax.swing.JPanel pHelp;
    private javax.swing.JPanel pUpload;
    private javax.swing.JPanel pUserInfo;
    // End of variables declaration//GEN-END:variables

    public static void setLogged(boolean mode) {
        if(mode) {
            Data.isLogged = true;
            lUserInfo.setText("<html>" + Data.text("status-hello") + ", <b>" + Settings.username + "</b>!</html>");
            lUserInfo.setForeground(Color.BLACK);
            mLogin.setText(Data.text("logoff")); 
            lServer.setText(Settings.server);
        } else {
            lUserInfo.setText(Data.text("status-unlogged"));
            lUserInfo.setForeground(new Color(102,102,102));
            mLogin.setText(Data.text("login")); 
        }
    }
    
    /**
    * Drag & drop
    * @see http://www.java-tips.org/java-se-tips/javax.swing/how-to-implement-drag-drop-functionality-in-your-applic.html
    */
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {}

    @Override
    public void dragOver(DropTargetDragEvent dtde) {}

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {}

    @Override
    public void dragExit(DropTargetEvent dte) {}
    
    public ArrayList<File> array;
    
    public void addToArray(File f) {
        if(f.isFile())
            array.add(f);
        
        if(f.isDirectory()) {
            File[] files = f.listFiles();
            for(File fi : files)
                addToArray(fi);
        }
    }
    
    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (int i = 0; i < flavors.length; i++) {
                //System.out.println("Possible flavor: " + flavors[i].getMimeType());
                if (flavors[i].isFlavorJavaFileListType()) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    array = new ArrayList<File>();
                    List list = (List)tr.getTransferData(flavors[i]);
                    
                    for(Object o : list) {
                        File f = new File(o.toString());
                        if(Settings.loadSubdirectory)
                            addToArray(f);
                        else {
                            if(f.isDirectory())
                                array.addAll(Arrays.asList(f.listFiles())); 
                            if(f.isFile())
                               array.add(f);
                        }
                    }
                    addImages(array);
                    dtde.dropComplete(true);
                    return;
                } else if (flavors[i].isRepresentationClassInputStream()) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    dtde.dropComplete(true);
                    return;
                }
            }
            dtde.rejectDrop();
        } catch (Exception e) {
            dtde.rejectDrop();
        }
    }
}
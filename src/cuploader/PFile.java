package cuploader;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import cuploader.Data.Elem;
import cuploader.fixes.TransferFocus;
import cuploader.frames.FCoord;
import cuploader.frames.FInfo;
import cuploader.frames.FFileEdit;
import cuploader.frames.FUpload;
import cuploader.frames.FUploadCheck;
import cuploader.frames.Main;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

public final class PFile extends javax.swing.JPanel implements KeyListener {
    public boolean toUpload = false;
    public boolean toEdit = false;
    
    public int uploadStatus = 0; //0 - not uploaded; 1 - uploaded; 2 - upload error
    public boolean editable = true;
    
    //category hints
    CategoryHint ch;
    String prevCategory = "";
    boolean cathintStop = false;
    
    int nameHelp = 2;
    
    int rotateThumb = 0;    //rotate thumbnail
    FInfo fExif;            // subwindow exif
    public FCoord fCoord;   // subwindow coordinates
    
    //info
    public File file;
    public String ext;
    public int number;
    public Coord coor = null;
    
    public Map<String, String> returnData() {
      Map<String, String> map = new HashMap<String, String>();
        map.put("name", tName.getText());
        map.put("path", file.getAbsolutePath());
        map.put("desc", tDesc.getText());
        map.put("date", tDate.getText());
        map.put("cats", tCategories.getText());
        //map.put("coor", coor.getDecimal());
      return map;
    }
    
    public PFile(File file, int number) {  
        this.file = file;
        this.number = number;
        
        initComponents();
        addUndo();
        addKeyListener(this);
        TransferFocus.patch(tDesc);
        
        String name = file.getName();
        tName.setText(name.substring(0, name.lastIndexOf('.')));
        readEXIF();
        generateThumbnail();
    }
    
    public PFile(File file, int number, boolean toUpload, boolean toEdit, String name, String desc, String date, String cats, String coor) {  
        this.file = file;
        this.number = number;
        
        initComponents();
        addUndo();
        addKeyListener(this);
        TransferFocus.patch(tDesc);
        
        //reading session
        if(!name.equals("null")) tName.setText(name);
        if(!desc.equals("null")) tDesc.setText(desc);
        if(!date.equals("null")) tDate.setText(date);
        if(!cats.equals("null")) tCategories.setText(cats);
        
        selectToEdit(toEdit);
        selectToUpload(toUpload);
        
        if(!coor.contains(";"))
            resetCoordinates();
        else {
            String[] s = coor.split(";");
            this.coor = new Coord(s[0], s[1]);
            setCoordinates(this.coor);
        }
        
        generateThumbnail();
    }
  
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mContext = new javax.swing.JPopupMenu();
    mSelectToUpload = new javax.swing.JMenuItem();
    mDeselectToUpload = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    mEdit = new javax.swing.JMenuItem();
    mDelete = new javax.swing.JMenuItem();
    mTools = new javax.swing.JPopupMenu();
    mRefreshThumb = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    mShowEXIF = new javax.swing.JMenuItem();
    mReloadEXIF = new javax.swing.JMenuItem();
    mWiki = new javax.swing.JPopupMenu();
    mAddEngDesc = new javax.swing.JMenuItem();
    mAddPlDesc = new javax.swing.JMenuItem();
    mGeoloc = new javax.swing.JPopupMenu();
    mAddCoor = new javax.swing.JMenuItem();
    mDelCoor = new javax.swing.JMenuItem();
    mMaps = new javax.swing.JMenu();
    mOSM = new javax.swing.JMenuItem();
    mGoogle = new javax.swing.JMenuItem();
    mGeoHack = new javax.swing.JMenuItem();
    mCatHint = new javax.swing.JPopupMenu();
    Panel = new javax.swing.JPanel();
    tThumb = new javax.swing.JLabel();
    tName = new javax.swing.JTextField();
    jScrollPane1 = new cuploader.fixes.PDControlScrollPane();
    tDesc = new javax.swing.JTextArea();
    tDate = new javax.swing.JTextField();
    lDate = new javax.swing.JLabel();
    lName = new javax.swing.JLabel();
    lCategories = new javax.swing.JLabel();
    tCategories = new javax.swing.JTextField();
    lDesc = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    lStatus = new javax.swing.JLabel();
    tSize = new javax.swing.JLabel();
    tCoor = new javax.swing.JLabel();
    bCopyDescUp = new javax.swing.JButton();
    bCopyDescDown = new javax.swing.JButton();
    bTools = new javax.swing.JButton();
    lFilename = new javax.swing.JLabel();
    bOpenFile = new javax.swing.JButton();
    bOpenDir = new javax.swing.JButton();
    bOpenMap = new javax.swing.JButton();
    lDirectory = new javax.swing.JLabel();
    bDesc = new javax.swing.JButton();
    cUpload = new javax.swing.JCheckBox();

    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
    mSelectToUpload.setText(bundle.getString("file-context-selectupload")); // NOI18N
    mSelectToUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mSelectToUploadActionPerformed(evt);
      }
    });
    mContext.add(mSelectToUpload);

    mDeselectToUpload.setText(bundle.getString("file-context-deselectupload")); // NOI18N
    mDeselectToUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mDeselectToUploadActionPerformed(evt);
      }
    });
    mContext.add(mDeselectToUpload);
    mContext.add(jSeparator1);

    mEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image--pencil.png"))); // NOI18N
    mEdit.setText(bundle.getString("file-context-edit")); // NOI18N
    mEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mEditActionPerformed(evt);
      }
    });
    mContext.add(mEdit);

    mDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/cross.png"))); // NOI18N
    mDelete.setText(bundle.getString("button-delete")); // NOI18N
    mDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mDeleteActionPerformed(evt);
      }
    });
    mContext.add(mDelete);

    mRefreshThumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image-resize.png"))); // NOI18N
    mRefreshThumb.setText(bundle.getString("file-tools-refreshthumb")); // NOI18N
    mRefreshThumb.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mRefreshThumbActionPerformed(evt);
      }
    });
    mTools.add(mRefreshThumb);
    mTools.add(jSeparator2);

    mShowEXIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image-export.png"))); // NOI18N
    mShowEXIF.setText(bundle.getString("file-tools-showexif")); // NOI18N
    mShowEXIF.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mShowEXIFActionPerformed(evt);
      }
    });
    mTools.add(mShowEXIF);

    mReloadEXIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-circle-double.png"))); // NOI18N
    mReloadEXIF.setText(bundle.getString("file-tools-refreshexif")); // NOI18N
    mReloadEXIF.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mReloadEXIFActionPerformed(evt);
      }
    });
    mTools.add(mReloadEXIF);

    mAddEngDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/flag_great_britain.png"))); // NOI18N
    mAddEngDesc.setText(bundle.getString("file-wiki-en")); // NOI18N
    mAddEngDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mAddEngDescActionPerformed(evt);
      }
    });
    mWiki.add(mAddEngDesc);

    mAddPlDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/flag_poland.png"))); // NOI18N
    mAddPlDesc.setText(bundle.getString("file-wiki-pl")); // NOI18N
    mAddPlDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mAddPlDescActionPerformed(evt);
      }
    });
    mWiki.add(mAddPlDesc);

    mAddCoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/geolocation.png"))); // NOI18N
    mAddCoor.setText(bundle.getString("fileedit-insert")); // NOI18N
    mAddCoor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mAddCoorActionPerformed(evt);
      }
    });
    mGeoloc.add(mAddCoor);

    mDelCoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/geolocation.png"))); // NOI18N
    mDelCoor.setText(bundle.getString("button-clear")); // NOI18N
    mDelCoor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mDelCoorActionPerformed(evt);
      }
    });
    mGeoloc.add(mDelCoor);

    mMaps.setText(bundle.getString("file-coor-show")); // NOI18N

    mOSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/map.png"))); // NOI18N
    mOSM.setText("OpenStreetMap");
    mOSM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mOSMActionPerformed(evt);
      }
    });
    mMaps.add(mOSM);

    mGoogle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/map.png"))); // NOI18N
    mGoogle.setText("Google Maps");
    mGoogle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mGoogleActionPerformed(evt);
      }
    });
    mMaps.add(mGoogle);

    mGeoHack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/map.png"))); // NOI18N
    mGeoHack.setText("GeoHack");
    mGeoHack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mGeoHackActionPerformed(evt);
      }
    });
    mMaps.add(mGeoHack);

    mGeoloc.add(mMaps);

    setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    setMaximumSize(new java.awt.Dimension(6400, 200));
    setMinimumSize(new java.awt.Dimension(550, 200));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        formMousePressed(evt);
      }
    });

    Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 5));
    Panel.setName(""); // NOI18N
    Panel.setOpaque(false);
    Panel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        PanelMouseClicked(evt);
      }
    });

    tThumb.setBackground(new java.awt.Color(0, 0, 0));
    tThumb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    tThumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image.png"))); // NOI18N
    tThumb.setFocusable(false);
    tThumb.setMaximumSize(new java.awt.Dimension(150, 100));
    tThumb.setMinimumSize(new java.awt.Dimension(150, 100));
    tThumb.setOpaque(true);
    tThumb.setPreferredSize(new java.awt.Dimension(150, 100));
    tThumb.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    tThumb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tThumbMouseClicked(evt);
      }
    });

    tName.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        tNameFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        tNameFocusLost(evt);
      }
    });

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setNextFocusableComponent(Panel);

    tDesc.setColumns(20);
    tDesc.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
    tDesc.setLineWrap(true);
    tDesc.setRows(3);
    tDesc.setComponentPopupMenu(Data.mQuickTemplates);
    tDesc.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        tDescFocusGained(evt);
      }
    });
    jScrollPane1.setViewportView(tDesc);

    tDate.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        tDateFocusGained(evt);
      }
    });

    lDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    lDate.setText(bundle.getString("file-date")); // NOI18N

    lName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    lName.setText(bundle.getString("file-name")); // NOI18N

    lCategories.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lCategories.setText(bundle.getString("file-cats")); // NOI18N

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

    lDesc.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    lDesc.setText(bundle.getString("file-desc")); // NOI18N

    jPanel1.setOpaque(false);

    lStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/null-button.png"))); // NOI18N
    lStatus.setFocusable(false);
    lStatus.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    tSize.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    tSize.setText("<text>");

    tCoor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    tCoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/-spacer.png"))); // NOI18N
    tCoor.setPreferredSize(new java.awt.Dimension(34, 20));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(lStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(tSize, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
      .addComponent(tCoor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
          .addComponent(tSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(tCoor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    bCopyDescUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-turn-180.png"))); // NOI18N
    bCopyDescUp.setToolTipText(bundle.getString("file-copyabove")); // NOI18N
    bCopyDescUp.setFocusable(false);
    bCopyDescUp.setOpaque(false);
    bCopyDescUp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCopyDescUpActionPerformed(evt);
      }
    });

    bCopyDescDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-turn-180-left.png"))); // NOI18N
    bCopyDescDown.setToolTipText(bundle.getString("file-copybelow")); // NOI18N
    bCopyDescDown.setFocusable(false);
    bCopyDescDown.setOpaque(false);
    bCopyDescDown.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCopyDescDownActionPerformed(evt);
      }
    });

    bTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/gear.png"))); // NOI18N
    bTools.setFocusable(false);
    bTools.setOpaque(false);
    bTools.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bToolsActionPerformed(evt);
      }
    });

    lFilename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document.png"))); // NOI18N
    lFilename.setText(file.getName());
    lFilename.setMaximumSize(new Dimension((int)(Panel.getWidth()*0.15), 16));
    lFilename.setMinimumSize(new Dimension((int)(Panel.getWidth()*0.15), 16));
    lFilename.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        PanelMouseClicked(evt);
      }
    });

    bOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/magnifier.png"))); // NOI18N
    bOpenFile.setToolTipText(bundle.getString("file-openfile")); // NOI18N
    bOpenFile.setFocusable(false);
    bOpenFile.setOpaque(false);
    bOpenFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bOpenFileActionPerformed(evt);
      }
    });

    bOpenDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-horizontal-open.png"))); // NOI18N
    bOpenDir.setToolTipText(bundle.getString("file-opendir")); // NOI18N
    bOpenDir.setFocusable(false);
    bOpenDir.setOpaque(false);
    bOpenDir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bOpenDirActionPerformed(evt);
      }
    });

    bOpenMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/map.png"))); // NOI18N
    bOpenMap.setToolTipText(Data.text("file-coord")); // NOI18N
    bOpenMap.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/map-bw.png"))); // NOI18N
    bOpenMap.setFocusable(false);
    bOpenMap.setOpaque(false);
    bOpenMap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bOpenMapActionPerformed(evt);
      }
    });

    lDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-horizontal-open.png"))); // NOI18N
    lDirectory.setText(file.getParent().substring(file.getParent().lastIndexOf('\\')+1, file.getParent().length()));
    lDirectory.setToolTipText(file.getParent());
    lDirectory.setMaximumSize(new Dimension((int)(Panel.getWidth()*0.15), 16));
    lDirectory.setMinimumSize(new Dimension((int)(Panel.getWidth()*0.15), 16));
    lDirectory.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        PanelMouseClicked(evt);
      }
    });

    bDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/ui-text-field.png"))); // NOI18N
    bDesc.setToolTipText(Data.text("file-wikicode")); // NOI18N
    bDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bDescActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
    Panel.setLayout(PanelLayout);
    PanelLayout.setHorizontalGroup(
      PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tThumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(PanelLayout.createSequentialGroup()
            .addComponent(bOpenMap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bTools, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(lCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
          .addComponent(lDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tCategories)
          .addGroup(PanelLayout.createSequentialGroup()
            .addComponent(jScrollPane1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(bCopyDescUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(bCopyDescDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(lFilename, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOpenDir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(tName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lDate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(2, 2, 2))))
    );
    PanelLayout.setVerticalGroup(
      PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(bOpenDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(bOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lDirectory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lFilename, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lDesc)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(PanelLayout.createSequentialGroup()
            .addComponent(bCopyDescUp)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bCopyDescDown)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      .addGroup(PanelLayout.createSequentialGroup()
        .addComponent(tThumb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(bOpenMap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bTools, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(bDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    cUpload.setBackground(new java.awt.Color(255, 204, 153));
    cUpload.setToolTipText(bundle.getString("file-select")); // NOI18N
    cUpload.setFocusable(false);
    cUpload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    cUpload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cUploadActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(cUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(cUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents
    
    private void cUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUploadActionPerformed
        selectToUpload(cUpload.isSelected());
        Main.lHelp.setText("<html>" + bundle.getString("help-select") + "</html>");
    }//GEN-LAST:event_cUploadActionPerformed

    private void bOpenDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenDirActionPerformed
        try {
            Desktop.getDesktop().open(file.getParentFile());
        } catch (IOException e){ }
    }//GEN-LAST:event_bOpenDirActionPerformed

    private void bOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenFileActionPerformed
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e){ }
    }//GEN-LAST:event_bOpenFileActionPerformed

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        int mouse = evt.getButton();
        if(mouse == MouseEvent.BUTTON1) {
            requestFocus();
            //CTRL
            if(Data.ctrlPress)
                selectToEdit(!Data.getFiles().get(number).toEdit/*!data.getFileEdit(number)*/);
            //SHIFT
            else if ((Data.ctrlPress && Data.shiftPress) || (!Data.ctrlPress && Data.shiftPress)) {
                int x = Data.getFirstFileEdit();

                if(x>number) {
                    //System.out.println("Od " + number + " do " + x);
                    for(int i=0;i<Data.getFiles().size();++i) {
                        if(i>=number && i<=x) Data.getFiles().get(i).selectToEdit(true);
                        else Data.getFiles().get(i).selectToEdit(false);
                    }
                } else if(x<number) {
                    //System.out.println("Od " + x + " do " + number);
                    for(int i=0;i<Data.getFiles().size();++i) {
                        if(i<=number && i>=x) Data.getFiles().get(i).selectToEdit(true);
                        else Data.getFiles().get(i).selectToEdit(false);
                    }
                } else
                    for(int i=0;i<Data.getFiles().size();++i) {
                        if(i==number) Data.getFiles().get(i).selectToEdit(true);
                        else Data.getFiles().get(i).selectToEdit(false);
                    }
            //STANDARD
            } else {
                for(int i=0;i<Data.getFiles().size();++i) {
                    if(i==number) Data.getFiles().get(i).selectToEdit(true);
                    else Data.getFiles().get(i).selectToEdit(false);
                }
            }
            requestFocusInWindow(true);

        } else if(mouse == MouseEvent.BUTTON3) {
            if(Data.getFiles().get(number).toEdit)
                mContext.show(evt.getComponent(), evt.getX(), evt.getY());
            else {
                for(int i=0;i<Data.getFiles().size();++i) {
                    if(i==number) Data.getFiles().get(i).selectToEdit(true);
                    else Data.getFiles().get(i).selectToEdit(false);
                }
                mContext.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_PanelMouseClicked

    private void tDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDateFocusGained
        Main.lHelp.setText("<html>" + bundle.getString("help-date") + "</html>");
    }//GEN-LAST:event_tDateFocusGained

    private void tCategoriesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCategoriesFocusGained
        Main.lHelp.setText("<html>" + bundle.getString("help-categories") + "</html>");
        if(Data.settings.showCatHints) showCategoryHints(true);
    }//GEN-LAST:event_tCategoriesFocusGained

    private void bOpenMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenMapActionPerformed
        mGeoloc.show(bOpenMap, 0, 25);
    }//GEN-LAST:event_bOpenMapActionPerformed

    private void bCopyDescUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCopyDescUpActionPerformed
        int nr = number;
        while(true) {
            if(nr>0 && !Data.getFiles().get(nr-1).isVisible()) --nr;
            else break;
        }
        
        if(nr>0) {
            --nr;
            PFile f = Data.getFiles().get(nr);
            copyDescription(f);
        }
    }//GEN-LAST:event_bCopyDescUpActionPerformed

    String retNumber(Matcher match, DecimalFormat df) {
        String text = match.group(0).replace(match.group(2), df.format(nameHelp));
        for(PFile f : Data.getFiles()) {
            if(f.getComponent(Elem.NAME).equals(text)) {
                ++nameHelp;
                return retNumber(match, df);
            }
        }
        
        nameHelp = 2;
        return text;
    }
    
    /**
     * Copies description from another file to this file
     * @param source source file
     */
    private void copyDescription(PFile source) {
      if(Data.settings.copyName) {
        String name = source.getComponent(Elem.NAME);
        String format = Data.settings.numFormat.replace("(", "\\(")
                .replace(")", "\\)").replace("[", "\\[").replace("]", "\\]")
                .replace("%NAME%", "(.*?)").replace("%N%", "([0-9]*)");
        
        Pattern pattern = Pattern.compile("^" + format + "$");
        Matcher match = pattern.matcher(name);

        String zeros = "";
        for(int i=0; i<Data.settings.numDigits; ++i) zeros += "0";
        DecimalFormat df = new DecimalFormat(zeros);

        if(match.find()) {
            tName.setText(retNumber(match, df));
        //nope
        } else {
            String name2 = Data.settings.numFormat.replace("%NAME%", name).replace("%N%", df.format(2));
            match = pattern.matcher(name2);
            if(match.find()) tName.setText(retNumber(match, df));
            else tName.setText(name2);
        }
      }

      if(Data.settings.copyDescription) setDescription(source.getComponent(Elem.DESC));
      if(Data.settings.copyCategories) setCategories(source.getComponent(Elem.CATS));
    }
    
    private void bCopyDescDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCopyDescDownActionPerformed
        int nr = number;
        while(true) {
            if(nr<Data.getFiles().size()-1 && !Data.getFiles().get(nr+1).isVisible()) ++nr;
            else break;
        }
        
        if(nr<Data.getFiles().size()-1) {
            ++nr;     
            PFile f = Data.getFiles().get(nr);
            copyDescription(f);
        }
    }//GEN-LAST:event_bCopyDescDownActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
            PanelMouseClicked(evt);
    }//GEN-LAST:event_formMousePressed

    private void mSelectToUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSelectToUploadActionPerformed
        for(PFile i : Data.getFiles())
            if(i.toEdit)
                i.selectToUpload(true);
    }//GEN-LAST:event_mSelectToUploadActionPerformed

    private void mDeselectToUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDeselectToUploadActionPerformed
        for(PFile i : Data.getFiles())
            if(i.toEdit)
                i.selectToUpload(false);
    }//GEN-LAST:event_mDeselectToUploadActionPerformed

    private void bToolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bToolsActionPerformed
        mTools.show(bTools, 0, 25);
    }//GEN-LAST:event_bToolsActionPerformed

    private void mAddEngDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddEngDescActionPerformed
        String s = tDesc.getSelectedText();
        if(s!=null) tDesc.replaceSelection("{{en|" + s + "}}");
        else tDesc.append("{{en|English desc.}}");
    }//GEN-LAST:event_mAddEngDescActionPerformed

    private void mAddPlDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddPlDescActionPerformed
        String s = tDesc.getSelectedText();
        if(s!=null) tDesc.replaceSelection("{{pl|" + s + "}}");
        else tDesc.append("{{pl|Polski opis.}}");
    }//GEN-LAST:event_mAddPlDescActionPerformed

    private void mEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEditActionPerformed
        if(Data.fFileEdit==null) Data.fFileEdit = new FFileEdit();
        else Data.fFileEdit.setVisible(true);
    }//GEN-LAST:event_mEditActionPerformed

    private void mRefreshThumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRefreshThumbActionPerformed
        generateThumbnail();
    }//GEN-LAST:event_mRefreshThumbActionPerformed

    private void mReloadEXIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReloadEXIFActionPerformed
        readEXIF();
    }//GEN-LAST:event_mReloadEXIFActionPerformed

    private void mShowEXIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mShowEXIFActionPerformed
        if(fExif==null) fExif = new FInfo(file);
        else fExif.setVisible(true);
    }//GEN-LAST:event_mShowEXIFActionPerformed

    private void tNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNameFocusGained
        Main.lHelp.setText("<html>" + bundle.getString("help-filename") + "</html>");
    }//GEN-LAST:event_tNameFocusGained

    private void tDescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDescFocusGained
        Main.lHelp.setText("<html>" + bundle.getString("help-desc") + "</html>");
    }//GEN-LAST:event_tDescFocusGained

    private void mGoogleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGoogleActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://maps.google.com/maps?q=" +coor.getLat()+ "+" +coor.getLon()+ "&t=h&z=16"));
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex){ 
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mGoogleActionPerformed

    private void mOSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOSMActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("http://www.openstreetmap.org/?mlat=" +coor.getLat()+ "&mlon=" +coor.getLon()+ "&zoom=16&layers=M"));
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex){ 
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mOSMActionPerformed

    private void mAddCoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddCoorActionPerformed
        if(fCoord==null) fCoord = new FCoord(number, false);
        else fCoord.setVisible(true);
    }//GEN-LAST:event_mAddCoorActionPerformed

    private void tThumbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tThumbMouseClicked
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex){
        }
    }//GEN-LAST:event_tThumbMouseClicked

    private void mDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDeleteActionPerformed
        deleteItems();
    }//GEN-LAST:event_mDeleteActionPerformed

    private void tCategoriesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tCategoriesCaretUpdate
        if(Data.settings.showCatHints) showCategoryHints(false);
    }//GEN-LAST:event_tCategoriesCaretUpdate

    private void mDelCoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDelCoorActionPerformed
        coor = null;
        resetCoordinates();
    }//GEN-LAST:event_mDelCoorActionPerformed

    private void mGeoHackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGeoHackActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("http://toolserver.org/~geohack/geohack.php?params=" + coor.getDecimal()));
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex){ 
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mGeoHackActionPerformed

  private void bDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDescActionPerformed
    new FInfo(FUpload.getUploadText(this, Data.settings));
  }//GEN-LAST:event_bDescActionPerformed

  private void tNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNameFocusLost
    String result = FUploadCheck.checkFile(getName()+"."+getExt());
    if(!result.isEmpty()) {
      tName.setBackground(new Color(255,226,226));
      tName.setToolTipText(Data.text(result));
    } else {
      tName.setBackground(new Color(194,238,194));
      tName.setToolTipText(null);
    }  
  }//GEN-LAST:event_tNameFocusLost
   
    private void addUndo() {
        tName.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                Data.manager.addEdit(e.getEdit());
            }
        });
        tDate.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                Data.manager.addEdit(e.getEdit());
            }
        });
        tDesc.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                Data.manager.addEdit(e.getEdit());
            }
        });
        tCategories.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                Data.manager.addEdit(e.getEdit());
            }
        });
    }
    
    private void showCategoryHints(boolean b) {
        if(!cathintStop) {
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
    }
    
    /**
     * Reads info from file EXIF (date, gps, rotation)
     */
    private void readEXIF() {
        try {
            Directory directory = ImageMetadataReader.readMetadata(file).getDirectory(ExifIFD0Directory.class);
            if(directory != null && directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)) {
                String rotate = directory.getDescription(ExifIFD0Directory.TAG_ORIENTATION);
                if(rotate.contains("90 CW")) rotateThumb = 1;
                else if(rotate.contains("180 CW")) rotateThumb = 2;
                else if(rotate.contains("270 CW")) rotateThumb = 3;
            }
                    
            directory = ImageMetadataReader.readMetadata(file).getDirectory(ExifSubIFDDirectory.class);
            if(directory != null && directory.containsTag(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL)) {
                Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                SimpleDateFormat sdf;
                if(Data.settings.readExifHour) sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                else sdf = new SimpleDateFormat("yyyy-MM-dd");
                tDate.setText(sdf.format(date));
            } else 
                tDate.setText("");

            directory = ImageMetadataReader.readMetadata(file).getDirectory(GpsDirectory.class);
            if(directory != null) {
                String lat = directory.getDescription(GpsDirectory.TAG_GPS_LATITUDE);
                String lon  = directory.getDescription(GpsDirectory.TAG_GPS_LONGITUDE);
                if(lat!=null && lon!=null) {
                    String[] NS = lat.split(" ");
                        NS[0] = NS[0].substring(0, NS[0].lastIndexOf('°'));
                        NS[1] = NS[1].substring(0, NS[1].lastIndexOf('\''));
                        NS[2] = NS[2].substring(0, NS[2].lastIndexOf('\"'));
                    String[] EW = lon.split(" ");
                        EW[0] = EW[0].substring(0, EW[0].lastIndexOf('°'));
                        EW[1] = EW[1].substring(0, EW[1].lastIndexOf('\''));
                        EW[2] = EW[2].substring(0, EW[2].lastIndexOf('\"'));
                    coor = new Coord(NS, directory.getDescription(GpsDirectory.TAG_GPS_LATITUDE_REF), 
                                            EW, directory.getDescription(GpsDirectory.TAG_GPS_LONGITUDE_REF));
                    setCoordinates(coor);
                } else resetCoordinates();
            } else resetCoordinates();
        } catch (ImageProcessingException ex) {
            resetCoordinates();
        } catch (IOException ex) {
            resetCoordinates();
        }
    }
    
    /**
     * Thumbnail rotator
     * @param  imageToRotate original thumbnail
     * @param  angle         angle to rotate it
     * @return BufferedImage rotated thumbnail
     * @see http://dzone.com/snippets/java-rotate-90%C3%A2%C2%B090%C3%A2%C2%B0
     */
    public BufferedImage rotateThumbnail(Image imageToRotate, int angle) {
	Image rotatedImage = new BufferedImage(imageToRotate.getHeight(null), imageToRotate.getWidth(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) rotatedImage.getGraphics();
        if(angle==1) {
            g2d.rotate(Math.toRadians(90.0));
            g2d.drawImage(imageToRotate, 0, -rotatedImage.getWidth(null), null);
        } if(angle==2) {
        } if(angle==3) {
            g2d.rotate(Math.toRadians(270.0));
            g2d.drawImage(imageToRotate, (int)(-rotatedImage.getWidth(null)*1.5), 0, null);
        }
        g2d.dispose();
	
	return (BufferedImage)rotatedImage;
    }

    /**
     * Thumbnail generator
     * @source: http://codereview.stackexchange.com/questions/912/optimized-thumbnail-generation
     */
    private void generateThumbnail() {
      ext = file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();

      double size = 9.5367e-7*file.length();
      DecimalFormat df = new DecimalFormat("#.##");
      tSize.setText(df.format(size) + " MiB");

      //IMAGES
      if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")) {
        
        Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        final MediaTracker tracker = new MediaTracker(new Container());
        tracker.addImage(image, 0);
        try {
           tracker.waitForID(0);
        } catch (InterruptedException e) {
           System.out.println("Interrupted getting thumb");
        }
        
        if(rotateThumb != 0) image = rotateThumbnail(image, rotateThumb);

        final int width = image.getWidth(null);
        final int height = image.getHeight(null);

        if ((width > 0) && (width * height < 54000000)) {
          float ratio = (float)width/(float)height;

          int thumbHeight = 100;
          int thumbWidth = (int)(100.0*(ratio));
          if(thumbWidth>150) {
              thumbHeight = (int)(thumbHeight*(150.0/thumbWidth));
              thumbWidth = 150;
          }

          BufferedImage scaledImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);

          Graphics2D g2dBuffer = scaledImage.createGraphics();
          g2dBuffer.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
          g2dBuffer.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

          tThumb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(scaledImage.getSource())));
          scaledImage.flush();
          image.flush();
          g2dBuffer = null;
          
          tSize.setText("<html><body>" + width + " x " + height + " (" + df.format((width*height)/1000000.0) + " Mpix)<br>" +
            df.format(size) + " MiB");

        } else
            tThumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document-32.png")));
        
        lFilename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document-image.png")));
        lFilename.setToolTipText(bundle.getString("file-image") + " (." + ext + ")");
        
      } else if(ext.equals("svg")) {
          tThumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document-32.png")));
      } else {
          tThumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/document-32.png")));
      }
    }
    
    /*
     * SET
     */
    
    @Override
    public void setName(String text) {
        tName.setText(text);
    }
    
    public void setDate(String text) {
        tDate.setText(text);
    }
       
    public void setCoordinates(Coord coor) {
        this.coor = coor;
        tCoor.setText(coor.getDMSformated());
        tCoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/geolocation.png")));
        mMaps.setEnabled(true);
        mDelCoor.setEnabled(true);
    }
    
    public void resetCoordinates() {
        tCoor.setIcon(null);
        mMaps.setEnabled(false);
        mDelCoor.setEnabled(false);
    }
    
    public void setDescription(String text) {
        tDesc.setText(text);
    }
    
    public void setCategories(String text) {
        cathintStop = true;
        tCategories.setText(text);
        cathintStop = false;
    }
       
    public String getComponent(Elem component) {
        switch(component) {
            case NAME: return tName.getText();
            case EXT: return ext;
            case DATE: return tDate.getText();
            case COOR: {
                if(coor==null) return "";
                else return coor.getDecimal();
            }
            case DESC: return tDesc.getText();
            case CATS: return tCategories.getText();
            default: return null;
        }
    }
    
    public String getName() { return tName.getText(); };
    public String getExt() { return ext; };
    
    public void setAsUploaded() {
        selectToUpload(false);
        lockPanel(false);
        lStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/tick-button.png")));
        lStatus.setToolTipText(bundle.getString("file-upload-success"));
        uploadStatus = 1;
    }
    
    public void setAsFailed(String details) {
        selectToUpload(true);
        lockPanel(false);
        lStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/exclamation-button.png")));
        lStatus.setToolTipText(bundle.getString("file-upload-error") + ": " + details);
        uploadStatus = 2;
    }
    
    public void selectToUpload(boolean mode) {
        if(mode!=toUpload) {
            toUpload = mode;
            cUpload.setSelected(mode);
            
            if(mode)
                cUpload.setBackground(new Color(200,228,169));
            else
                cUpload.setBackground(new Color(255,204,153));
            
            Data.updateFileCounter();
        }
    }
    
    public void selectToEdit(boolean mode) {
        if(mode!=toEdit) {
            toEdit = mode;
            if(mode) {
                Panel.setOpaque(true);
                Panel.setBackground(new Color(220,220,220));
                ++Data.filesEdit;
            } else {
                Panel.setOpaque(false);
                Panel.setBackground(null);
                --Data.filesEdit;
            }
        }
    }
    
    public void lockPanel(boolean mode) {
        tName.setEnabled(!mode);
        tDate.setEnabled(!mode);
        tDesc.setEnabled(!mode);
        tDesc.setOpaque(!mode);
        tCategories.setEnabled(!mode);
        bCopyDescDown.setEnabled(!mode);
        bCopyDescUp.setEnabled(!mode);
        
        editable = !mode;
        if(mode) 
            lStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/navigation-090-button.png")));
        else
            lStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/null-button.png")));
    }
    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel Panel;
  private javax.swing.JButton bCopyDescDown;
  private javax.swing.JButton bCopyDescUp;
  private javax.swing.JButton bDesc;
  private javax.swing.JButton bOpenDir;
  private javax.swing.JButton bOpenFile;
  private javax.swing.JButton bOpenMap;
  private javax.swing.JButton bTools;
  private javax.swing.JCheckBox cUpload;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JLabel lCategories;
  private javax.swing.JLabel lDate;
  private javax.swing.JLabel lDesc;
  private javax.swing.JLabel lDirectory;
  private javax.swing.JLabel lFilename;
  private javax.swing.JLabel lName;
  private javax.swing.JLabel lStatus;
  private javax.swing.JMenuItem mAddCoor;
  private javax.swing.JMenuItem mAddEngDesc;
  private javax.swing.JMenuItem mAddPlDesc;
  private javax.swing.JPopupMenu mCatHint;
  private javax.swing.JPopupMenu mContext;
  private javax.swing.JMenuItem mDelCoor;
  private javax.swing.JMenuItem mDelete;
  private javax.swing.JMenuItem mDeselectToUpload;
  private javax.swing.JMenuItem mEdit;
  private javax.swing.JMenuItem mGeoHack;
  private javax.swing.JPopupMenu mGeoloc;
  private javax.swing.JMenuItem mGoogle;
  private javax.swing.JMenu mMaps;
  private javax.swing.JMenuItem mOSM;
  private javax.swing.JMenuItem mRefreshThumb;
  private javax.swing.JMenuItem mReloadEXIF;
  private javax.swing.JMenuItem mSelectToUpload;
  private javax.swing.JMenuItem mShowEXIF;
  private javax.swing.JPopupMenu mTools;
  private javax.swing.JPopupMenu mWiki;
  private javax.swing.JTextField tCategories;
  private javax.swing.JLabel tCoor;
  private javax.swing.JTextField tDate;
  private javax.swing.JTextArea tDesc;
  private javax.swing.JTextField tName;
  private javax.swing.JLabel tSize;
  private javax.swing.JLabel tThumb;
  // End of variables declaration//GEN-END:variables
    ResourceBundle bundle = ResourceBundle.getBundle("cuploader/text/messages");

    /**
     * Convenience method that returns a scaled instance of the
     * provided {@code BufferedImage}.
     *
     * @param img the original image to be scaled
     * @param targetWidth the desired width of the scaled instance,
     *    in pixels
     * @param targetHeight the desired height of the scaled instance,
     *    in pixels
     * @param hint one of the rendering hints that corresponds to
     *    {@code RenderingHints.KEY_INTERPOLATION} (e.g.
     *    {@code RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BILINEAR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BICUBIC})
     * @param higherQuality if true, this method will use a multi-step
     *    scaling technique that provides higher quality than the usual
     *    one-step technique (only useful in downscaling cases, where
     *    {@code targetWidth} or {@code targetHeight} is
     *    smaller than the original dimensions, and generally only when
     *    the {@code BILINEAR} hint is specified)
     * @return a scaled version of the original {@code BufferedImage}
     */
    private BufferedImage getScaledInstance(BufferedImage img,
                                           int targetWidth,
                                           int targetHeight,
                                           Object hint,
                                           boolean higherQuality) {
        int type = (img.getTransparency() == Transparency.OPAQUE) ?
            BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage)img;
        
        int w, h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();                   
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }
        
        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }
            
//            Graphics2D g2d = (Graphics2D) rotatedImage.getGraphics();
//        g2d.rotate(Math.toRadians(90.0));
//        g2d.drawImage(imageToRotate, 0, -rotatedImage.getWidth(null), null);
//        g2d.dispose();

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }

    private void deleteItems() {
        ArrayList<Integer> del = new ArrayList<Integer>();

        for(PFile f : Data.getFiles())
            if (f.toEdit) del.add(f.number);

        Object[] options = { bundle.getString("button-delete"), bundle.getString("button-cancel")};
        int n = JOptionPane.showOptionDialog(new Component() {}, bundle.getString("file-delete-confirm"), bundle.getString("file-delete"), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(n==0) {
            for (Iterator<PFile> it = Data.getFiles().iterator(); it.hasNext();) {
                PFile f = it.next();
                if(f.toEdit) {
                    f.selectToEdit(false);
                    f.selectToUpload(false);
                    f.setVisible(false);
                    it.remove();
                }
            }

            Data.updateFileCounter();
            for(int i=0;i<Data.getFiles().size();++i)
                Data.getFiles().get(i).number = i;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT && !Data.shiftPress) {
            Data.shiftPress = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL && !Data.ctrlPress) {
            Data.ctrlPress = true;
        }
        //System.out.print("Key: " + e.getKeyCode() + "... ");
    }
   
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            Data.shiftPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            Data.ctrlPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            deleteItems();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
package cuploader.frames;

import cuploader.Data;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.security.auth.login.FailedLoginException;
import javax.swing.*;
import org.wikipedia.Wiki;

public class FLogin extends javax.swing.JFrame {
    private Data data;
    private boolean startUpload = false;
    
    public FLogin(Data data) {   
        this.data = data;
        initComponents();
        init();
    }
    
    public FLogin(Data data, boolean startUpload) {   
        this.data = data;
        this.startUpload = startUpload;
        initComponents();
        init();
    }
    
    private void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(FLogin.DISPOSE_ON_CLOSE);

        if(!Data.settings.username.isEmpty()) {
            tName.setText(Data.settings.username);
            tPassword.requestFocus();
        } else
            tName.requestFocus();  
        
        tPrefix.setEnabled(false);
        
        if(Data.settings.server.equals("commons.wikimedia.org")) 
            cServer.setSelectedIndex(0);
        else if (Data.settings.server.endsWith(".wikipedia.org")) {
            cServer.setSelectedIndex(1);
            
            String prefix = Data.settings.server.substring(0, Data.settings.server.lastIndexOf(".wikipedia.org"));
            tPrefix.setEnabled(true);
            tPrefix.setText(prefix);
        } else {
            cServer.setSelectedIndex(2);
            tServer.setEnabled(true);
            tServer.setText(Data.settings.server);
        }
        
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }
    
    private void Login() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                tName.setEditable(false);
                tPassword.setEditable(false);
                Data.settings.username = tName.getText();
                
                switch(cServer.getSelectedIndex()) {
                    case 0:
                        Data.settings.server = "commons.wikimedia.org";
                        break;
                    case 1:
                        String prefix = tPrefix.getText().toLowerCase();
                        if(prefix.equals("")) prefix="en";
                        Data.settings.server = prefix + ".wikipedia.org";
                        break;
                    case 2:
                        Data.settings.server = tServer.getText();
                }
                lTextInfo.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/ui-progress-bar-indeterminate.gif")));
                lTextInfo.setText(bundle.getString("login-loggingin"));
                lTextInfo.setVisible(true);
                try {
                        Wiki w;
                        if(Data.settings.server.contains("wikiskripta")) {
                            w = new Wiki(Data.settings.server, "");
                            w.setHttp("http");
                        } else
                            w = new Wiki(Data.settings.server);
                        w.login(tName.getText(), tPassword.getPassword());
                        Data.wiki = w;
                        //TODO: pobieranie ustawień konta
                        Main.setLogged(true);
                        
                        dispose();
                        if(startUpload) new FUploadCheck(data);
                        Data.fLogin = null;
                } catch (IOException ex) {
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    lTextInfo.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
                    lTextInfo.setText(bundle.getString("login-error-server"));
                    tName.setEditable(true);
                    tPassword.setEditable(true);
                    tPassword.selectAll();

                } catch (FailedLoginException ex) {
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    lTextInfo.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
                    lTextInfo.setText(bundle.getString("login-error-login"));
                    tName.setEditable(true);
                    tPassword.setEditable(true);
                    tPassword.selectAll();
                }
            }
        };
        
        Thread t = new Thread(run);
        t.start();
    }
    
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bLogin = new javax.swing.JButton();
    Panel = new javax.swing.JPanel();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    tPrefix = new javax.swing.JTextField();
    cServer = new javax.swing.JComboBox();
    jPanel3 = new javax.swing.JPanel();
    tServer = new javax.swing.JTextField();
    jTextField1 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    lPath = new javax.swing.JLabel();
    lLogin = new javax.swing.JLabel();
    lPassword = new javax.swing.JLabel();
    tName = new javax.swing.JTextField();
    tPassword = new javax.swing.JPasswordField();
    jPanel1 = new javax.swing.JPanel();
    lTextInfo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
    setTitle(bundle.getString("login-loggingin")); // NOI18N
    setResizable(false);

    bLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/tick.png"))); // NOI18N
    bLogin.setText(bundle.getString("login-login")); // NOI18N
    bLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bLoginActionPerformed(evt);
      }
    });

    Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    Panel.setName(""); // NOI18N

    jLabel1.setText(bundle.getString("login-server")); // NOI18N

    jRadioButton1.setText("Wikimedia Commons");

    cServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "wikipedia.org", "wiktionary.org", "wikiquote.org", "wikibooks.org", "wikisource.org", "wikispecies.org", "wikinews.org", "wikiversity.org", "wikivoyage.org" }));
    cServer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cServerActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jRadioButton2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cServer, 0, 249, Short.MAX_VALUE))
          .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jRadioButton2))
        .addContainerGap(29, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab(bundle.getString("settings-basic"), jPanel2); // NOI18N

    tServer.setText("en.wikipedia.org");
    tServer.setEnabled(false);

    jTextField1.setText("http");

    jLabel2.setText("://");

    jTextField2.setText("/w");

    jLabel3.setText("/api.php");

    jLabel4.setText(bundle.getString("login-protocol")); // NOI18N

    jLabel5.setText(bundle.getString("login-server")); // NOI18N

    lPath.setText(bundle.getString("login-server-path")); // NOI18N

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
          .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tServer, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lPath, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
          .addComponent(jTextField2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5))
          .addComponent(lPath, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(35, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab(bundle.getString("settings-advanced"), jPanel3); // NOI18N

    lLogin.setText(bundle.getString("login-name")); // NOI18N

    lPassword.setText(bundle.getString("login-password")); // NOI18N

    tPassword.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        tPasswordKeyPressed(evt);
      }
    });

    javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
    Panel.setLayout(PanelLayout);
    PanelLayout.setHorizontalGroup(
      PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jTabbedPane1)
          .addGroup(PanelLayout.createSequentialGroup()
            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(lLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
              .addComponent(lPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(tName)
              .addComponent(tPassword))))
        .addContainerGap())
    );
    PanelLayout.setVerticalGroup(
      PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tPassword)
          .addComponent(lPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lTextInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(lTextInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 1, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bLogin))
          .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(bLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    
    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        if(tName.getText().length()==0 || tPassword.getPassword().length==0)
            JOptionPane.showMessageDialog(rootPane, bundle.getString("login-error-nodata"), bundle.getString("login-loggingin"), JOptionPane.WARNING_MESSAGE);
        else
            Login();
    }//GEN-LAST:event_bLoginActionPerformed

    private void tPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) 
            Login();
    }//GEN-LAST:event_tPasswordKeyPressed

    private void cServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cServerActionPerformed
        if(cServer.getSelectedIndex()==(cServer.getComponentCount())) {//other
            tServer.setEnabled(true);
            tPrefix.setEnabled(false);
        } else if (cServer.getSelectedIndex()==1) {
            tServer.setEnabled(false);
            tPrefix.setEnabled(true);
        } else if (cServer.getSelectedIndex()==0) {
            tServer.setEnabled(false);
            tPrefix.setEnabled(false);
        }
    }//GEN-LAST:event_cServerActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel Panel;
  private javax.swing.JButton bLogin;
  private javax.swing.JComboBox cServer;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JLabel lLogin;
  private javax.swing.JLabel lPassword;
  private javax.swing.JLabel lPath;
  private javax.swing.JLabel lTextInfo;
  private javax.swing.JTextField tName;
  private javax.swing.JPasswordField tPassword;
  private javax.swing.JTextField tPrefix;
  private javax.swing.JTextField tServer;
  // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };
}

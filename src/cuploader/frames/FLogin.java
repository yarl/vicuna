package cuploader.frames;

import cuploader.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.security.auth.login.FailedLoginException;
import javax.swing.*;
import org.wikipedia.Wiki;

public class FLogin extends javax.swing.JFrame implements WindowListener {

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
    setDefaultCloseOperation(FLogin.DO_NOTHING_ON_CLOSE);
    addWindowListener(this);

    if (!Data.settings.username.isEmpty()) {
      tName.setText(Data.settings.username);
      tPassword.requestFocus();
    } else {
      tName.requestFocus();
    }

    //commons
    if (Data.settings.server.equals("commons.wikimedia.org")) {
      pServer.setSelectedIndex(0);
      rCommons.setSelected(true);
      //sister projects
    } else if (Data.settings.server.matches(".*wik[it](pedia|ionary|quote|books|source|species|news|versity|voyage)\\.org")) {
      pServer.setSelectedIndex(0);
      rWikimedia.setSelected(true);

      String prefix = Data.settings.server.substring(0, Data.settings.server.indexOf("."));
      tPrefix.setText(prefix);

      String domain = Data.settings.server.substring(prefix.length() + 1);
      for (int i = 0; i < cServer.getItemCount(); i++) {
        String s = cServer.getItemAt(i).toString();
        if (s.equals(domain)) {
          cServer.setSelectedIndex(i);
          break;
        }
      }
      //sth else
    } else {
      pServer.setSelectedIndex(1);
      tServer.setText(Data.settings.server);
      tProtocol.setText(Data.settings.protocol == null ? "http" : Data.settings.protocol);
      tPath.setText(Data.settings.path == null ? "/w" : Data.settings.path);
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
        Wiki w;

        if (pServer.getSelectedIndex() == 0) {
          //commons
          if (rCommons.isSelected()) {
            Data.settings.server = "commons.wikimedia.org";
            Data.settings.protocol = "https";
            Data.settings.path = "/w";
          } //sister projects
          else if (rWikimedia.isSelected()) {
            Data.settings.server = tPrefix.getText() + "." + cServer.getSelectedItem().toString();
            Data.settings.protocol = "https";
            Data.settings.path = "/w";
          }
        } //sth else
        else {
          Data.settings.protocol = tProtocol.getText();
          Data.settings.server = tServer.getText();
          Data.settings.path = tPath.getText();
        }

        w = new Wiki(Data.settings.server, Data.settings.path);
        w.setHttp(Data.settings.protocol);
        w.setUserAgent("VicunaUploader/" + Data.version + " (https://github.com/yarl/vicuna)");


        //login info
        lTextInfo.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/ui-progress-bar-indeterminate.gif")));
        lTextInfo.setText(bundle.getString("login-loggingin"));
        lTextInfo.setVisible(true);

        //login
        try {
          w.login(tName.getText(), tPassword.getPassword());
          Data.wiki = w;

          //TODO: pobieranie ustawień konta
          Data.setLoggedIn(true);

          if (startUpload) {
            new FUploadCheck(data);
          }
          dispose();
          Data.fLogin = null;
        } catch (IOException ex) {
          lTextInfo.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/cross.png")));
          lTextInfo.setText(bundle.getString("login-error-server"));
          tName.setEditable(true);
          tPassword.setEditable(true);
          tPassword.selectAll();

        } catch (FailedLoginException ex) {
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


  /* implement WindowListener */
  public void windowOpened(WindowEvent e) {};
  public void windowClosed(WindowEvent e) {};
  public void windowIconified(WindowEvent e) {};
  public void windowDeiconified(WindowEvent e) {};
  public void windowActivated(WindowEvent e) {};
  public void windowDeactivated(WindowEvent e) {};
  /**
   * Close the login window
   */
  public void windowClosing(WindowEvent e) {
    Log.finer("Login window closing");
    dispose();
    Data.fLogin = null;
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bLogin = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        pServer = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rCommons = new javax.swing.JRadioButton();
        rWikimedia = new javax.swing.JRadioButton();
        tPrefix = new javax.swing.JTextField();
        cServer = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        tServer = new javax.swing.JTextField();
        tProtocol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tPath = new javax.swing.JTextField();
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

        buttonGroup1.add(rCommons);
        rCommons.setText("Wikimedia Commons");

        buttonGroup1.add(rWikimedia);

        cServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "wikipedia.org", "wiktionary.org", "wikiquote.org", "wikibooks.org", "wikisource.org", "wikispecies.org", "wikinews.org", "wikiversity.org", "wikivoyage.org" }));

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
                        .addComponent(rWikimedia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cServer, 0, 249, Short.MAX_VALUE))
                    .addComponent(rCommons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rCommons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rWikimedia))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pServer.addTab(bundle.getString("settings-basic"), jPanel2); // NOI18N

        tServer.setText("en.wikipedia.org");

        tProtocol.setText("http");

        jLabel2.setText("://");

        tPath.setText("/w");

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
                    .addComponent(tProtocol, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tServer, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPath, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(tPath))
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
                    .addComponent(tProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pServer.addTab(bundle.getString("settings-advanced"), jPanel3); // NOI18N

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
                    .addComponent(pServer)
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
                .addComponent(pServer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      if (tName.getText().length() == 0 || tPassword.getPassword().length == 0) {
        JOptionPane.showMessageDialog(rootPane, bundle.getString("login-error-nodata"), bundle.getString("login-loggingin"), JOptionPane.WARNING_MESSAGE);
      } else {
        Login();
      }
    }//GEN-LAST:event_bLoginActionPerformed

    private void tPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPasswordKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        Login();
      }
    }//GEN-LAST:event_tPasswordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton bLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lPath;
    private javax.swing.JLabel lTextInfo;
    private javax.swing.JTabbedPane pServer;
    private javax.swing.JRadioButton rCommons;
    private javax.swing.JRadioButton rWikimedia;
    private javax.swing.JTextField tName;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tPath;
    private javax.swing.JTextField tPrefix;
    private javax.swing.JTextField tProtocol;
    private javax.swing.JTextField tServer;
    // End of variables declaration//GEN-END:variables

  ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
  KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
  Action escapeAction = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
      windowClosing(null);
    }
    static final long serialVersionUID = 3641980775838779462L;
  };

  public static java.util.logging.Logger Log = java.util.logging.Logger.getLogger(FLogin.class.getName());

  static final long serialVersionUID = -1163628623045129787L;
}

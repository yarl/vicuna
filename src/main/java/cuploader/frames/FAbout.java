package cuploader.frames;

import cuploader.Data;
import cuploader.LocalizationChangedListener;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.wikipedia.Wiki;

public class FAbout extends javax.swing.JFrame {

    public FAbout() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        ReloadBundle rb = new ReloadBundle();
        Data.settings.addLocalizationChangedListener(rb);
        addWindowListener(rb);
    }

    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    lInfo = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    bProgramSite = new javax.swing.JButton();
    bCheckUpdate = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader.text.messages"); // NOI18N
    setTitle(bundle.getString("help-about")); // NOI18N
    setResizable(false);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("help-about"))); // NOI18N

    lInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/logo.png"))); // NOI18N
    lInfo.setText("<html><body>VicuñaUploader " + Data.version + "<br>" + Data.date + "</body></html>");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lInfo)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("about-used"))); // NOI18N

    jLabel3.setText("<html><body>&bull;  wiki-java (GNU GPL)<br>&bull;  metadata-extractor (Apache 2.0)<br>&bull; JXMapViewer2 (GNU LGPL)<br>&bull; Icons  by Yusuke Kamiyamane</body></html>");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        .addGap(119, 119, 119))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    bProgramSite.setText(bundle.getString("about-site")); // NOI18N
    bProgramSite.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bProgramSiteActionPerformed(evt);
      }
    });

    bCheckUpdate.setText(bundle.getString("about-checkupdate")); // NOI18N
    bCheckUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCheckUpdateActionPerformed(evt);
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
          .addGroup(layout.createSequentialGroup()
            .addComponent(bCheckUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bProgramSite, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bCheckUpdate)
          .addComponent(bProgramSite))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bCheckUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCheckUpdateActionPerformed
        try {
            String v = new Wiki("commons.wikimedia.org").getPageText("User:Yarl/VicunaUploader/version").trim();
            if(Double.parseDouble(v)>Double.parseDouble(Data.version)) {
                Object[] o = {bundle.getString("button-download"), bundle.getString("button-cancel")};
                int n = JOptionPane.showOptionDialog(rootPane, "<html><body>" + bundle.getString("about-checkupdate-text") + " (<b>" + v + "</b>). " + bundle.getString("about-checkupdate-download") + "</body></html>", bundle.getString("about-checkupdate"), 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, o, o[0]);
                if(n==0) {
                    try {
                        Desktop.getDesktop().browse(new URI("http://yarl.github.io/vicuna/"));
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else
                JOptionPane.showMessageDialog(rootPane, bundle.getString("about-checkupdate-ok"), bundle.getString("about-checkupdate"), JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("login-error-server"), bundle.getString("login-error-server"), JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bCheckUpdateActionPerformed

    private void bProgramSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProgramSiteActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("http://yarl.github.io/vicuna/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bProgramSiteActionPerformed

    private class ReloadBundle implements LocalizationChangedListener, WindowListener {
      @Override
      public void localizationChanged(java.util.Locale loc) {
          Logger.getLogger(FAbout.class.getName()).log(Level.INFO, "Reloading messages");
          bundle = java.util.ResourceBundle.getBundle("cuploader.text.messages", loc);
          lInfo.setText("<html><body>VicuñaUploader " + Data.version + "<br>" + Data.date + "</body></html>");
          setTitle(bundle.getString("help-about")); // NOI18N
          jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("help-about"))); // NOI18N
          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("about-used"))); // NOI18N
          bProgramSite.setText(bundle.getString("about-site")); // NOI18N
          bCheckUpdate.setText(bundle.getString("about-checkupdate")); // NOI18N
      }
      public void    windowActivated(java.awt.event.WindowEvent e) {}
      public void    windowClosed(java.awt.event.WindowEvent e) {
        Logger.getLogger(FAbout.class.getName()).log(Level.FINEST, "FAbout closed");
        Data.settings.removeLocalizationChangedListener(this);
        removeWindowListener(this);
      }
      public void    windowClosing(java.awt.event.WindowEvent e) {}
      public void    windowDeactivated(java.awt.event.WindowEvent e) {}
      public void    windowDeiconified(java.awt.event.WindowEvent e) {}
      public void    windowIconified(java.awt.event.WindowEvent e) {}
      public void    windowOpened(java.awt.event.WindowEvent e) {}
  }

    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCheckUpdate;
  private javax.swing.JButton bProgramSite;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel lInfo;
  // End of variables declaration//GEN-END:variables
    
    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader.text.messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
        static final long serialVersionUID = -870636177102960976L;
    }; 

    static final long serialVersionUID = 3563015584085051392L;
}

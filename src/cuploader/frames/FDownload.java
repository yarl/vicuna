package cuploader.frames;

import cuploader.Data;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public final class FDownload extends javax.swing.JFrame {
    Main frame;
    private volatile boolean stopRq = false;
    
    public FDownload(Main frame) {
        this.frame = frame;
        
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        start();
    }

    /**
     * @see http://stackoverflow.com/a/4194224/1418878
     */
    void start() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    frame.setState(Frame.ICONIFIED);
                    
                    final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                    final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

                    /* is it a jar file? */
                    if(currentJar.getName().endsWith(".jar")) {
                        frame.saveSessionFile(new File(currentJar.getParentFile() + File.separator + "autoupdate-session.xml"));
                        
                        String path = currentJar.getAbsolutePath();
                        //JOptionPane.showMessageDialog(frame, "Path: " + path);
                        download(path);

                        /* Build command: java -jar application.jar */
                        final ArrayList<String> command = new ArrayList<String>();
                        command.add(javaBin);
                        command.add("-jar");
                        command.add(currentJar.getPath());

                        final ProcessBuilder builder = new ProcessBuilder(command);
                        builder.start();
                        System.exit(0);
                        
                    } else
                        dispose();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(run);
        t.start();
    }
    
    /**
     * Downloads file from server
     * @param dest destination
     * @see http://cookbooks.adobe.com/post_Download_a_file_from_a_URL_in_Java-17947.html
     */
    private void download(String dest) {
        try {
            lName.setText(Data.text("download-connect"));

            URL url = new URL("http://yarl.github.io/vicuna/download/latest.jar");
            url.openConnection();
            InputStream reader = url.openStream();

            FileOutputStream writer = new FileOutputStream(dest);
            byte[] buffer = new byte[153600];
            int totalBytesRead = 0;
            int bytesRead = 0;

            lName.setText(Data.text("download-download"));
            Progress.setIndeterminate(false);
            while ((bytesRead = reader.read(buffer)) > 0) {  
                writer.write(buffer, 0, bytesRead);
                buffer = new byte[153600];
                totalBytesRead += bytesRead;
                int val = Progress.getValue()+2;
                if(Progress.getMaximum()>=val) Progress.setValue(val);
            }
            lName.setText(Data.text("download-restart"));
            
            writer.close();
            reader.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titledBorder1 = javax.swing.BorderFactory.createTitledBorder("");
        jPanel1 = new javax.swing.JPanel();
        Progress = new javax.swing.JProgressBar();
        lName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Progress.setIndeterminate(true);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        lName.setText(bundle.getString("download-init")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Progress;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lName;
    private javax.swing.border.TitledBorder titledBorder1;
    // End of variables declaration//GEN-END:variables
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

}

package cuploader.frames;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.*;

public class FInfo extends javax.swing.JFrame {
    
    File file;

    public FInfo(File file) {
        this.file = file;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(bundle.getString("file-tools-showexif") + file.getName());
        
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    //System.out.println(tag);
                    tText.append(tag + "\n");
                }
            }
            tText.setCaretPosition(0);
            setVisible(true);
            
        } catch (ImageProcessingException ex) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("file-tools-noexif"), "EXIF", JOptionPane.INFORMATION_MESSAGE);  
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("file-tools-noexif"), "EXIF", JOptionPane.INFORMATION_MESSAGE);
        }
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }
    
    public FInfo(String text) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle(bundle.getString("file-wikicode"));
        
        tText.setFont(tText.getFont().deriveFont(12f));
        tText.setEditable(false);
        tText.setText(text);
        setVisible(true);
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tText = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);

    tText.setEditable(false);
    tText.setColumns(20);
    tText.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
    tText.setRows(5);
    jScrollPane1.setViewportView(tText);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea tText;
  // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader.text.messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
        static final long serialVersionUID = 6268509638332148434L;
    }; 
    static final long serialVersionUID = 8400848783643219708L;
}

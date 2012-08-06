package cuploader.frames;

import cuploader.Coord;
import cuploader.Data;
import cuploader.Data.Elem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javax.swing.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class FCoord extends javax.swing.JFrame {

    private int number;
    private boolean multiEdit;
    private JMapViewer map = new JMapViewer();

    public FCoord(int number, boolean multiEdit) {
        this.number = number;
        this.multiEdit = multiEdit;
        
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        map.setZoomContolsVisible(false);
        if(Data.coor!=null && Data.coorZoom!=0)
            map.setDisplayPositionByLatLon(Data.coor.getLat(), Data.coor.getLon(), Data.coorZoom);
        setVisible(true);
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tCoor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pMap = map;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("file-coor")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        jLabel1.setText(bundle.getString("coord-info")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("<html>52.2299;21.0628<br>permalink: OpenStreetMap, Wikimapia<br>{{Koordynaty|52|14|5.15|N|21|7|51.91|E|region:PL}}</html>");

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/tick.png"))); // NOI18N
        bSave.setText(bundle.getString("button-apply")); // NOI18N
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCoor)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCoor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        jLabel2.setText(bundle.getString("coord-info-map")); // NOI18N

        pMap.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        pMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pMapMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pMapLayout = new javax.swing.GroupLayout(pMap);
        pMap.setLayout(pMapLayout);
        pMapLayout.setHorizontalGroup(
            pMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pMapLayout.setVerticalGroup(
            pMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        Data.coor = map.getPosition();
        Data.coorZoom = map.getZoom();
        
        String input = tCoor.getText();
        if(input != null) {
            Coord coor;
            
            //52.2299;21.0628
            if(input.matches("[-.0-9]*;[-.0-9]*")) {
                String[] s = input.trim().split(";");
                coor = new Coord(s[0], s[1]);
                
                if(multiEdit) {
                    Main.fFileEdit.coor = coor;
                    Main.fFileEdit.tCoor.setText(coor.getDMSformated());
                } else {
                    Data.getFiles().get(number).coor = coor;
                    Data.getFiles().get(number).setComponent(Elem.COOR, coor.getDMSformated());
                }
            }
            //52,2299;21,0628
            else if(input.matches("[-,0-9]*;[-,0-9]*")) {
                input = input.replace(',', '.');
                String[] s = input.trim().split(";");
                coor = new Coord(s[0], s[1]);
                
                if(multiEdit) {
                    Main.fFileEdit.coor = coor;
                    Main.fFileEdit.tCoor.setText(coor.getDMSformated());
                } else {
                    Data.getFiles().get(number).coor = coor;
                    Data.getFiles().get(number).setComponent(Elem.COOR, coor.getDMSformated());
                }
            }
            //www.openstreetmap.org/?lat=52.4075&lon=16.9315&zoom=13&layers=M
            else if(input.matches(".*lat=[-.0-9]*&lon=[-.0-9]*.*")) {
                String[] s = input.split("[#?&]");
                //JOptionPane.showMessageDialog(bSetCoor, s[1] + "----" + s[2]);
                String lat="0", lon="0";
                for(String i : s) {
                    if(i.contains("lat"))
                        lat=i.substring(4);
                    if(i.contains("lon"))
                        lon=i.substring(4);
                }
                coor = new Coord(lat, lon);
                if(multiEdit) {
                    Main.fFileEdit.coor = coor;
                    Main.fFileEdit.tCoor.setText(coor.getDMSformated());
                } else {
                    Data.getFiles().get(number).coor = coor;
                    Data.getFiles().get(number).setComponent(Elem.COOR, coor.getDMSformated());
                }
            }
            
            //{{Koordynaty|52|14|5.15|N|21|7|51.91|E|region:PL}}
            else if(input.matches(".*[Kk]oordynaty|.*")) {
                String[] s = input.split("\\|");
                if(s.length>8) {    //długi
                    String lat[] = {s[1],s[2],s[3]};
                    String lon[] = {s[5],s[6],s[7]};
                    coor = new Coord(lat, s[4], lon, s[8]);
                    if(multiEdit) {
                        Main.fFileEdit.coor = coor;
                        Main.fFileEdit.tCoor.setText(coor.getDMSformated());
                    } else {
                        Data.getFiles().get(number).coor = coor;
                        Data.getFiles().get(number).setComponent(Elem.COOR, coor.getDMSformated());
                    }
                }
            }
            //else JOptionPane.showMessageDialog(rootPane, bundle.getString("coord-unknown"), bundle.getString("file-coor"), JOptionPane.ERROR_MESSAGE);
        }
        if(multiEdit)
            Main.fFileEdit.fCoord = null;
        else
           Data.getFiles().get(number).fCoord = null;
        
        dispose();
    }//GEN-LAST:event_bSaveActionPerformed

    private void pMapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMapMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {
            DecimalFormat df = new DecimalFormat("#.######");

            Point point = new Point(getMousePosition().x-13, getMousePosition().y-63);
            //System.out.println(point.toString());
            Coordinate c = map.getPosition(point);

            tCoor.setText(df.format(c.getLat()) + ";" + df.format(c.getLon()));
        }
        //JOptionPane.showMessageDialog(rootPane, string);
    }//GEN-LAST:event_pMapMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pMap;
    private javax.swing.JTextField tCoor;
    // End of variables declaration//GEN-END:variables

    ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages");
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action escapeAction = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }; 
}

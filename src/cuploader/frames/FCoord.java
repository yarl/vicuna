package cuploader.frames;

import cuploader.Coord;
import cuploader.Data;
import cuploader.Data.Elem;
import cuploader.Settings;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javax.swing.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

public class FCoord extends javax.swing.JFrame {
    private int number;
    private boolean multiEdit;
    
    private JMapViewer map = new JMapViewer();
    private MapMarker marker;
    
    public FCoord(int number, boolean multiEdit) {
        this.number = number;
        this.multiEdit = multiEdit;
        
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        map.setZoomContolsVisible(false);
        
        if(Settings.coor!=null && Settings.coorZoom!=0)
            map.setDisplayPositionByLatLon(Settings.coor.getLat(), Settings.coor.getLon(), Settings.coorZoom);
        
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
        bOSM = new javax.swing.JButton();
        bBing = new javax.swing.JButton();
        bMapquest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
        setTitle(bundle.getString("file-coor")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
        jLabel1.setText(bundle.getString("coord-info")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("<html>"+Data.text("fileedit-coor-info")+"</html>");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCoor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSave))
                .addContainerGap())
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
            .addGap(0, 256, Short.MAX_VALUE)
        );

        bOSM.setText("OpenStreetMap");
        bOSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOSMActionPerformed(evt);
            }
        });

        bBing.setText("Bing");
        bBing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBingActionPerformed(evt);
            }
        });

        bMapquest.setText("MapQuest Open");
        bMapquest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMapquestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bOSM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bMapquest)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOSM)
                    .addComponent(bBing)
                    .addComponent(bMapquest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Coord readCoordinates(String input) {
        Coord coor = null;
            
        //52.2299;21.0628
        if(input.matches("[-.0-9]*;[-.0-9]*")) {
            String[] s = input.trim().split(";");
            coor = new Coord(s[0], s[1]);
        }

        //52,2299;21,0628
        else if(input.matches("[-,0-9]*;[-,0-9]*")) {
            input = input.replace(',', '.');
            String[] s = input.trim().split(";");
            coor = new Coord(s[0], s[1]);
        }

        //www.openstreetmap.org/?lat=52.4075&lon=16.9315&zoom=13&layers=M
        else if(input.matches(".*lat=[-.0-9]*&lon=[-.0-9]*.*")) {
            String[] s = input.split("[#?&]");
            //JOptionPane.showMessageDialog(bSetCoor, s[1] + "----" + s[2]);
            String lat="0", lon="0";
            for(String i : s) {
                if(i.contains("lat")) lat=i.substring(4);
                if(i.contains("lon")) lon=i.substring(4);
            }
        }

        //{{Coord|52|14|5.15|N|21|7|51.91|E|region:PL}}
        else if(input.matches(".*[Kk]oordynaty|.*") || input.matches(".*[Cc]oord|.*")) {
            String[] s = input.split("\\|");
            if(s.length>8) {    //długi
                String lat[] = {s[1],s[2],s[3]};
                String lon[] = {s[5],s[6],s[7]};
                coor = new Coord(lat, s[4], lon, s[8]);
            }
        }

        return coor; 
    }
    
    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        Settings.coor = map.getPosition();
        Settings.coorZoom = map.getZoom();
        
        String input = tCoor.getText();
        if(!input.isEmpty()) {
            Coord coor = readCoordinates(input);
            
            //push
            if(coor != null) {
                if(multiEdit) {
                    Data.fFileEdit.coor = coor;
                    Data.fFileEdit.tCoor.setText(coor.getDMSformated());
                    Data.fFileEdit.fCoord = null;
                } else {
                    Data.getFiles().get(number).coor = coor;
                    Data.getFiles().get(number).setComponent(Elem.COOR, coor.getDMSformated());
                    Data.getFiles().get(number).fCoord = null;
                }
                dispose();
            } else
                JOptionPane.showMessageDialog(rootPane, bundle.getString("coord-unknown"), bundle.getString("file-coor"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void pMapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMapMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {
            map.removeMapMarker(marker);
            DecimalFormat df = new DecimalFormat("#.######");
            
            Point point = new Point(getMousePosition().x-13, getMousePosition().y-92);
            Coordinate c = map.getPosition(point);
            
            marker = new MapMarkerDot(c.getLat(), c.getLon());
            map.addMapMarker(marker);
            tCoor.setText(df.format(c.getLat()) + ";" + df.format(c.getLon()));
        }
        //JOptionPane.showMessageDialog(rootPane, string);
    }//GEN-LAST:event_pMapMouseReleased

    private void bOSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOSMActionPerformed
        map.setTileSource(new OsmTileSource.Mapnik());
    }//GEN-LAST:event_bOSMActionPerformed

    private void bBingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBingActionPerformed
        map.setTileSource(new BingAerialTileSource());
    }//GEN-LAST:event_bBingActionPerformed

    private void bMapquestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMapquestActionPerformed
        map.setTileSource(new MapQuestOsmTileSource());
    }//GEN-LAST:event_bMapquestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBing;
    private javax.swing.JButton bMapquest;
    private javax.swing.JButton bOSM;
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

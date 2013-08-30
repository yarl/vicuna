package cuploader;

import cuploader.frames.Main;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.wikipedia.Wiki;

/**
 * Shows already created categories in 'HotCat' style
 * @author Pawel, osm.org/user/kendzi (thx!)
 */
public class CategoryHint extends Thread {    
    JPopupMenu mCatHint;
    JTextField tCategories;
    Wiki wiki = new Wiki(Data.settings.server);
    
    final ArrayList<JMenu> list = new ArrayList<JMenu>();
    final ArrayList<Boolean> listBool = new ArrayList<Boolean>();
    
    volatile int count = 0;
    volatile boolean end = false;
    public volatile boolean stop = false;
    
    public CategoryHint(JPopupMenu mCatHint, JTextField tCategories) {
        this.mCatHint = mCatHint;
        this.tCategories = tCategories;
    }
    
    @Override
    public void run() {
        while(count < 30) {
            count++;
            try { Thread.sleep(25); } catch (InterruptedException ex) {}
        }
        end = true;
        loadCategories();
    }
    
    public void restart() {
        stop = true;
        end = false;
        count = 0;
        mCatHint.removeAll();
        mCatHint.setVisible(false);
    }
    public boolean isEnd() {
        return end;
    }
    
    public void forceStop() {
        stop = true;
        end = true;
        count = 100;
        mCatHint.removeAll();
        mCatHint.setVisible(false);
    }
    
    /**
     * Returns category to download from string separated with semicolon according to caret position.<br /><br />
     * Eg.: "Paris;Lon|don;Berlin" returns London.
     * @param tf JTextField
     * @return category to download
     */
    public static String getCategory(JTextField tf) {
        String[] s = tf.getText().split(";");
        
        int caret = tf.getCaretPosition();
        int n = 0, length = s[0].length();

        for(int i=0; i<s.length-1; ++i) {
            if(caret>length+1) {
                ++n;
                ++length; //";"
                length+=s[i+1].length();
            }
            else break;
        }
        return s[n];
    }
    
    /**
     * Loads categories
     */
    private void loadCategories() {
        stop = false;
        String text = getCategory(tCategories);
        mCatHint.removeAll();
        
        if(!text.isEmpty()) {
            //loading...
            JMenuItem item = new JMenuItem("<html><i>"+Data.text("fileedit-cat-load")+" \""+text+"\"</i></html>");
            item.setEnabled(false);
            mCatHint.add(item);
            mCatHint.show(tCategories, 0, tCategories.getHeight());
            tCategories.requestFocus();
            
            try {
                //get list
                String[] listPages = wiki.listPages("Category:"+text, null, Wiki.CATEGORY_NAMESPACE);

                //remove loading
                mCatHint.removeAll();
                mCatHint.setVisible(false);

                if(listPages.length>0) {
                    //create menu items
                    for(String s : listPages) {
                        list.add(new JMenu(s.substring(s.indexOf(":")+1)));
                        listBool.add(false);
                    }
                    for(final JMenu category : list) {
                        mCatHint.add(category);
                        category.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/arrow-270-small.png")));

                        category.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent evt) {
                                setCategory(category.getText());
                            }
                        });

                        //Open category in browser
                        JMenuItem mOpen = new JMenuItem(Data.text("fileedit-cat-open"));
                        mOpen.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                try {
                                    Desktop.getDesktop().browse(new URI("http://"+Data.settings.server+"/wiki/Category:"+category.getText().replace(" ", "_")));
                                } catch (URISyntaxException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        category.add(mOpen);
                    }
                } else {
                    item = new JMenuItem("<html><i>"+Data.text("fileedit-cat-zero")+"</i></html>");
                    item.setEnabled(false);
                    mCatHint.add(item);
                }

                //show
                mCatHint.show(tCategories, 0, tCategories.getHeight());
                mCatHint.repaint();
                tCategories.requestFocus();

                //download subcats
                for(JMenu category : list) {
                    if(!stop) loadSubcategories(category);
                    else break;
                }
//                tCategories.requestFocus();
//                if(!tCategories.hasFocus())
//                    mCatHint.setVisible(false);

            } catch (UnknownHostException ex) {
            } catch (IOException ex) {
                Logger.getLogger(PFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Inserts category to JTextField
     * @param str category
     */
    private void setCategory(String str) {
        String[] cats = tCategories.getText().split(";");

        int caret = tCategories.getCaretPosition()+1;
        int n = 0, length = cats[0].length();

        for(int i=0; i<cats.length-1; ++i) {
            if(caret>length+1) {
                ++n;
                ++length; //";"
                length+=cats[i+1].length();
            }
            else break;
        }

        //set text
        cats[n] = str;
        String text = "";
        for(String s : cats)
            text += s + ";";
        tCategories.setText(text);
        stop=true;
        //tCategories.setCaretPosition(caret);
    } 
    
    /**
     * Loads subcategories and root categories of given category
     * @param category JMenu with category
     */
    public void loadSubcategories(JMenu category) {
        int n = list.indexOf(category);

        if(!listBool.get(n)) {
            String[] categoryMembers = new String[15];

            //subcategories
            try {
                categoryMembers = wiki.getCategoryMembers(category.getText(), Wiki.CATEGORY_NAMESPACE);
            } catch (IOException ex) {
                Logger.getLogger(CategoryHint.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(categoryMembers.length>0) {
                category.addSeparator();

                //title
                JMenuItem title = new JMenuItem("<html><i>"+Data.text("fileedit-cat-subcats")+"</i></html>");
                    title.setEnabled(false);
                    category.add(title);

                //add
                for(String s : categoryMembers)
                    if(s.contains(":")) {
                        final JMenuItem item = new JMenuItem(s.substring(s.indexOf(":")+1));
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setCategory(item.getText());
                            }
                        });
                        category.add(item);
                    }
            }

            //supcategories
            try {
                categoryMembers = wiki.getCategories("Category:"+category.getText());
            } catch (IOException ex) {
                Logger.getLogger(CategoryHint.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(categoryMembers.length>0) {
                category.addSeparator();

                //title
                JMenuItem title = new JMenuItem("<html><i>"+Data.text("fileedit-cat-supcats")+"</i></html>");
                    title.setEnabled(false);
                    category.add(title);

                //add
                for(String s : categoryMembers)
                    if(s.contains(":")) {
                        final JMenuItem item = new JMenuItem(s.substring(s.indexOf(":")+1));
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setCategory(item.getText());
                            }
                        });
                        category.add(item);
                    }
            }

            listBool.set(n, true);
            category.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/tick-small.png")));
        }
    }
}

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.*;


public class MainWindow extends javax.swing.JFrame {
    
    /**
     * Creates new form Article
     */
    public MainWindow() throws MalformedURLException, URISyntaxException {
        initComponents();            
    }
    
    public void scaleImage(JLabel label, int width, int hight){
        ImageIcon icon = (ImageIcon)label.getIcon();
        Image img = icon.getImage().getScaledInstance(width,hight,Image.SCALE_SMOOTH); //scales the icon 3la hasab l label
        System.out.println();
        ImageIcon scaledIcon = new ImageIcon(img);
        label.setIcon(scaledIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws MalformedURLException, URISyntaxException {
        java.awt.GridBagConstraints gridBagConstraints;

        MainPaneContainer = new javax.swing.JPanel();
        headerPane = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        previewArticlePane = new javax.swing.JPanel();
        menuBarre = new javax.swing.JPanel();
        goHome = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID'19 news");
        setIconImage(new ImageIcon("C:\\Users\\azedi\\Documents\\NetBeansProjects\\TpSad1\\src\\main\\java\\resources\\favicon.png").getImage());
        setSize(new java.awt.Dimension(1366, 768));
        //<editor-fold>
        mainTitle.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        mainTitle.setForeground(new java.awt.Color(0, 0, 0));
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Covid 19 NEWS");
        mainTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        searchButton.setText("SEARCH 🔍");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchBar.getText().isEmpty()) {
                    try {
                        Search(searchBar.getText());
                        System.out.println(searchBar.getText());
                    } catch (URISyntaxException | IOException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                }
            }
        });

        jButton7.setText("TAG #1");
        jButton7.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton7.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton7.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton9.setText("TAG #2");
        jButton9.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton9.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton9.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton10.setText("TAG #3");
        jButton10.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton10.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton10.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton11.setText("TAG #4");
        jButton11.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton11.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton11.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton12.setText("TAG #5");
        jButton12.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton12.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton12.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton13.setText("TAG #6");
        jButton13.setMaximumSize(new java.awt.Dimension(72, 25));
        jButton13.setMinimumSize(new java.awt.Dimension(72, 25));
        jButton13.setPreferredSize(new java.awt.Dimension(72, 25));

        javax.swing.GroupLayout titleWsearchContainerLayout = new javax.swing.GroupLayout(headerPane);
        headerPane.setLayout(titleWsearchContainerLayout);
        titleWsearchContainerLayout.setHorizontalGroup(
            titleWsearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleWsearchContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(titleWsearchContainerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(titleWsearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(titleWsearchContainerLayout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(titleWsearchContainerLayout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        titleWsearchContainerLayout.setVerticalGroup(
            titleWsearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleWsearchContainerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(mainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(titleWsearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(searchBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(titleWsearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        //</editor-fold>

        previewArticlePane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        previewArticlePane.setLayout(new javax.swing.BoxLayout(previewArticlePane, javax.swing.BoxLayout.LINE_AXIS));
        ArrayList<String> fileNames = new Functions().getArticle(".html");//get .html files
        ArrayList<String> articleNames = new Functions().getRandomArticles(fileNames, 3); // get 3 random Articles
         preview1 = new ArticlePreview(articleNames.get(0));
         preview2 = new ArticlePreview(articleNames.get(1));
         preview3 = new ArticlePreview(articleNames.get(2));
        previewArticlePane.add(preview1);
        previewArticlePane.add(preview2);
        previewArticlePane.add(preview3);

        //<editor-fold>
        javax.swing.GroupLayout MainPaneContainerLayout = new javax.swing.GroupLayout(MainPaneContainer);
        MainPaneContainer.setLayout(MainPaneContainerLayout);
        MainPaneContainerLayout.setHorizontalGroup(
            MainPaneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPaneContainerLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(MainPaneContainerLayout.createSequentialGroup()
                .addComponent(previewArticlePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPaneContainerLayout.setVerticalGroup(
            MainPaneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPaneContainerLayout.createSequentialGroup()
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewArticlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuBarre.setBackground(new java.awt.Color(37, 37, 37));
        menuBarre.setLayout(new java.awt.GridBagLayout());

        goHome.setFont(new java.awt.Font("Roboto", 0, 32)); // NOI18N
        final JPanel pane = (JPanel) getContentPane();
        goHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    pane.removeAll();
                    initComponents();

                } catch (MalformedURLException | URISyntaxException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
        goHome.setForeground(new java.awt.Color(249, 243, 243));
        goHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goHome.setText("Home");
        goHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        menuBarre.add(goHome, gridBagConstraints);

        jToolBar1.setBackground(new java.awt.Color(37, 37, 37));
        jToolBar1.setBorderPainted(false);
        jToolBar1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(66, 66, 66));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(249, 243, 243));
        jButton1.setText("All");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(66, 66, 66));
        jButton2.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(249, 243, 243));
        jButton2.setText("International");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(66, 66, 66));
        jButton3.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(249, 243, 243));
        jButton3.setText("National");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(66, 66, 66));
        jButton4.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(249, 243, 243));
        jButton4.setText("Vaccine");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 3.1;
        gridBagConstraints.weighty = 0.1;
        menuBarre.add(jToolBar1, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(66, 66, 66));
        jButton5.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(249, 243, 243));
        jButton5.setIcon(new ImageIcon(getClass().getResource("exclamation-mark.png")));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        menuBarre.add(jButton5, gridBagConstraints);

        jButton6.setBackground(new java.awt.Color(66, 66, 66));
        jButton6.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jButton6.setForeground(new java.awt.Color(249, 243, 243));
        jButton6.setIcon(new ImageIcon(getClass().getResource("information.png")));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        menuBarre.add(jButton6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        menuBarre.add(jLabel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarre, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addComponent(MainPaneContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menuBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPaneContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        //</editor-fold>
        pack();
        getContentPane().revalidate();
        getContentPane().repaint();

        setListeners();

        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //listens to the enter key
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!searchBar.getText().isEmpty()) {
                        try {
                            Search(searchBar.getText());
                            System.out.println(searchBar.getText());
                        } catch (URISyntaxException | IOException uriSyntaxException) {
                            uriSyntaxException.printStackTrace();
                        }
                    }
                }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void setListeners() {
        //<editor-fold desc="setListeners">
        preview1.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview1.previewTitle.getText().replaceAll("\\<.*?\\>", "");// get the title and removes the html tags

                try {
                    new Test(newTitle).setVisible(true);
                    dispose();
                } catch (IOException |  URISyntaxException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        preview2.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview2.previewTitle.getText().replaceAll("\\<.*?\\>", ""); // get the title and removes the html tags
                try {
                    new Test(newTitle).setVisible(true);
                    dispose();
                } catch (IOException |  URISyntaxException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        preview3.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview3.previewTitle.getText().replaceAll("\\<.*?\\>", "");// get the title and removes the html tags
                try {
                    new Test(newTitle).setVisible(true);
                    dispose();
                } catch (IOException |  URISyntaxException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //</editor-fold>
    }

    protected void Search(String val) throws URISyntaxException, IOException {
        File mainFile = new File(getClass().getResource("\\articles").toURI());
        String[] listOfFiles = mainFile.list();
        String res;
        boolean found = false;
        if (listOfFiles != null) {
            for (String file : listOfFiles) {
                //faire to lowercase pour que les resultat soit homogene !
                if (file.toLowerCase().contains(val.toLowerCase())) {
                    res = file.replace(".html", "");
                    found = true;

                    setSearchPane(res); // Change the pane
                    break;
                }
            }
            System.out.println(found);
            // si la var found reste sur faux cad le fichier n'a pas ete trouvé
            if (!found) {
                JOptionPane.showMessageDialog(this, "File Not Found Try Again");
            }
        } else {
            System.err.println("err");
        }
        searchBar.setText(null);
    }
    private void setSearchPane(String val) throws IOException, URISyntaxException {
        //removing everything from the content pane
        MainPaneContainer.remove(headerPane);
        MainPaneContainer.remove(previewArticlePane);

        MainPaneContainer.revalidate();
        MainPaneContainer.repaint();

        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView();
        MainPaneContainer.setLayout(new FlowLayout());
        scrollPane.setBorder(null);


        //setting the seachPane
        SearchPane searchPane = new SearchPane(val, 5);
        scrollPane.setViewportView(searchPane); //the viewport isnt working
        MainPaneContainer.add(scrollPane);
        MainPaneContainer.revalidate();
        MainPaneContainer.repaint();
        setSearchPaneListener(searchPane.getJComponents());
    }
    private void setSearchPaneListener(ArticlePreview[] arr) {
        for (final ArticlePreview articlePreview : arr) {
            if (articlePreview != null)
                articlePreview.getPreviewTitle().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        dispose();
                        try {
                            new Test(articlePreview.getTitle()).setVisible(true);
                        } catch (IOException | URISyntaxException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // GO TO ALL
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (MalformedURLException | URISyntaxException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPaneContainer;
    private javax.swing.JButton jButton1;
    ArticlePreview preview1;
    ArticlePreview preview2;
    ArticlePreview preview3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel goHome;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField searchBar;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel menuBarre;
    private static javax.swing.JPanel previewArticlePane;
    private javax.swing.JPanel headerPane;
    // End of variables declaration//GEN-END:variables
}
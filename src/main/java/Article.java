
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class Article extends JPanel {
    //<editor-fold desc="GLOBAL VARIABLES">
    private File htmlFile;
    private String title;


    URI articlesPath;
    ArticlePreview preview1;
    ArticlePreview preview2;
    ArticlePreview preview3;
    private Font contentCustomFont;
    private Font TitleCustomFont;
    GridBagConstraints gridBagConstraints;
    JPanel subContainer = new JPanel(); //li fih scroll 1 w 2
    JScrollPane similarContentScroll = new JScrollPane();// li 3la ljemb
    JScrollPane articleScroll = new JScrollPane();//li fih article
    JPanel articlePane;
    JPanel similarArticlesPane = new JPanel();
    JPanel menuBar = new JPanel();
    SearchPane searchPane;
    JLabel goHome = new JLabel();
    JToolBar jToolBar1 = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    JButton jButton5 = new JButton();
    JButton jButton6 = new JButton();
    JTextField searchBar = new JTextField();
    JLabel searchLabel = new JLabel();
    JLabel loupe = new JLabel();
    JLabel seeAlso = new JLabel();

    //</editor-fold>

    //constructors
    public Article(File htmlFile, String tile) throws URISyntaxException, MalformedURLException { //hna i need to add my variables
        TitleCustomFont = new Font("Roboto", Font.PLAIN, 24);
        contentCustomFont = new Font("Roboto", Font.PLAIN, 24);
        articlesPath = getClass().getResource("\\articles\\").toURI();
        this.htmlFile = htmlFile;
        this.title = tile;
        //getting the Fonts
        try {
            TitleCustomFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("\\Font\\Chomsky.otf").toURI()));
            contentCustomFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("\\Font\\Nunito-Light.ttf").toURI()));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(contentCustomFont.deriveFont(Font.BOLD, 18f)); //
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        initComponents();
    }


    //MY Code
    public void scaleImage(JLabel label, int width, int hight) {
        ImageIcon icon = (ImageIcon) label.getIcon();
        Image img = icon.getImage().getScaledInstance(width, hight, Image.SCALE_SMOOTH); //scales the icon 3la hasab l label
        System.out.println();
        ImageIcon scaledIcon = new ImageIcon(img);
        label.setIcon(scaledIcon);
    }

    public ArrayList<String> getArticle(String extension) {// returns a list of fileNames with a specific extension
        File doc = new File(articlesPath);
        String[] fileNames;
        fileNames = doc.list();
        assert fileNames != null;
        ArrayList<String> reqFiles = new ArrayList<String>();
        for (String filename : fileNames) {
            if (filename.contains(extension) && !filename.equals(title + ".html")) {
                reqFiles.add(filename.replace(extension, "")); //removes the extension
            }
        }
        return reqFiles;
    }

    public ArrayList<String> getRandomArticles(ArrayList<String> ArticleNames, int nbrReq) { // returns nbrRequested of randomArticles form filesnames
        ArrayList<String> randoms = new ArrayList<String>();
        int[] nbrs = new int[nbrReq];
        Random randInt = new Random();
        int i = 0;
        while (i < nbrReq) {           //we cant have same number twice
            boolean redudent = false;
            int temp = (randInt.nextInt(ArticleNames.size()));//don't need random kbir 3la size
            for (int j = 0; j < nbrReq; j++) {
                if (temp == nbrs[j]) {
                    redudent = true;
                    break;
                }
            }
            if (!redudent) { //if it doesn't exist in the array add it
                nbrs[i] = temp;
                i++;
            }
        }
        for (i = 0; i < nbrReq; i++) {
            randoms.add(ArticleNames.get(nbrs[i]));
        }
        return randoms;
    }

    // <editor-fold defaultstate="collapsed" desc="InitFunction">
    private void initComponents() throws MalformedURLException, URISyntaxException {

        setContentPane();

        //<editor-fold desc="menuBar Setup">
        menuBar.setBackground(new Color(37, 37, 37));
        menuBar.setLayout(new GridBagLayout());

        goHome.setFont(TitleCustomFont.deriveFont(32f)); // NOI18N
        //add getters for this
        goHome.setForeground(new Color(249, 243, 243));
        goHome.setHorizontalAlignment(SwingConstants.CENTER);
        goHome.setText("Home");
        goHome.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        menuBar.add(goHome, gridBagConstraints);

        jToolBar1.setBackground(new Color(37, 37, 37));
        jToolBar1.setBorderPainted(false);

        jButton1.setBackground(new Color(66, 66, 66));
        jButton1.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton1.setForeground(new Color(249, 243, 243));
        jButton1.setText("All");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setBackground(new Color(66, 66, 66));
        jButton2.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton2.setForeground(new Color(249, 243, 243));
        jButton2.setText("International");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setBackground(new Color(66, 66, 66));
        jButton3.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton3.setForeground(new Color(249, 243, 243));
        jButton3.setText("National");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setBackground(new Color(66, 66, 66));
        jButton4.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton4.setForeground(new Color(249, 243, 243));
        jButton4.setText("Vaccine");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 3.1;
        gridBagConstraints.weighty = 0.1;
        menuBar.add(jToolBar1, gridBagConstraints);

        jButton5.setBackground(new Color(66, 66, 66));
        jButton5.setFont(new Font("Roboto", Font.PLAIN, 22)); // NOI18N
        jButton5.setForeground(new Color(249, 243, 243));

        jButton5.setIcon(new ImageIcon(getClass().getResource("information.png")));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new Insets(0, 7, 0, 7);
        menuBar.add(jButton5, gridBagConstraints);

        jButton6.setBackground(new Color(66, 66, 66));
        jButton6.setFont(new Font("Roboto", Font.PLAIN, 22)); // NOI18N
        jButton6.setForeground(new Color(249, 243, 243));
        jButton6.setIcon(new ImageIcon(getClass().getResource("exclamation-mark.png")));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 6, 0, 6);
        menuBar.add(jButton6, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 5, 0, 5);
        searchBar.setBorder(BorderFactory.createEmptyBorder());
        searchBar.setFont(contentCustomFont.deriveFont(18f));
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //listens to the enter key
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!searchBar.getText().isEmpty()) {
                        try {
                            Search(searchBar.getText());
                        } catch (URISyntaxException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        menuBar.add(searchBar, gridBagConstraints);

        searchLabel.setFont(contentCustomFont.deriveFont(Font.BOLD, 22f)); // NOI18N
        searchLabel.setForeground(new Color(249, 243, 243));
        searchLabel.setText("Search");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        menuBar.add(searchLabel, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new Insets(0, 2, 0, 0);

        loupe.setIcon(new ImageIcon(getClass().getResource("loupe.png")));
        loupe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loupe.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        loupe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!searchBar.getText().isEmpty()) {
                    try {
                        Search(searchBar.getText());
                    } catch ( IOException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                }
            }
        });
        menuBar.add(loupe, gridBagConstraints);
        //</editor-fold>

        //<editor-fold desc="Adding MenuBar to GroupLayout ">
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                        .addComponent(subContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );// </editor-fold>
    }

    // </editor-fold>
    private void setContentPane() throws MalformedURLException, URISyntaxException {
        // <editor-fold defaultstate="collapsed" desc="ArticlePane setup">
        articlePane = initArticlePane(title, htmlFile);
        articleScroll.setViewportView(articlePane);
        // </editor-fold>

        //<editor-fold desc="Similar Articles setup">
        similarArticlesPane = initSimilarArticlePane();
        similarContentScroll.setViewportView(similarArticlesPane);
        //</editor-fold>

        //<editor-fold desc="Adding ArticlePane & Similar Articles Pane to GroupLayout ">
        GroupLayout subContainerLayout = new GroupLayout(subContainer);
        subContainer.setLayout(subContainerLayout);
        subContainerLayout.setHorizontalGroup(
                subContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, subContainerLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(articleScroll)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(similarContentScroll, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subContainerLayout.setVerticalGroup(
                subContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, subContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(subContainerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(articleScroll, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                        .addComponent(similarContentScroll))
                                .addContainerGap())
        );
        //</editor-fold>
    }

    private void addSearchBar() {
        //<editor-fold desc="menuBar Setup">
        menuBar.setBackground(new Color(37, 37, 37));
        menuBar.setLayout(new GridBagLayout());

        goHome.setFont(TitleCustomFont.deriveFont(32f)); // NOI18N
        System.out.println(TitleCustomFont.getName());
        goHome.setForeground(new Color(249, 243, 243));
        goHome.setHorizontalAlignment(SwingConstants.CENTER);
        goHome.setText("Home");
        goHome.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        menuBar.add(goHome, gridBagConstraints);

        jToolBar1.setBackground(new Color(37, 37, 37));
        jToolBar1.setBorderPainted(false);

        jButton1.setBackground(new Color(66, 66, 66));
        jButton1.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton1.setForeground(new Color(249, 243, 243));
        jButton1.setText("All");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setBackground(new Color(66, 66, 66));
        jButton2.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton2.setForeground(new Color(249, 243, 243));
        jButton2.setText("International");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setBackground(new Color(66, 66, 66));
        jButton3.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton3.setForeground(new Color(249, 243, 243));
        jButton3.setText("National");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setBackground(new Color(66, 66, 66));
        jButton4.setFont(contentCustomFont.deriveFont(22f)); // NOI18N
        jButton4.setForeground(new Color(249, 243, 243));
        jButton4.setText("Vaccine");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 3.1;
        gridBagConstraints.weighty = 0.1;
        menuBar.add(jToolBar1, gridBagConstraints);

        jButton5.setBackground(new Color(66, 66, 66));
        jButton5.setFont(new Font("Roboto", Font.PLAIN, 22)); // NOI18N
        jButton5.setForeground(new Color(249, 243, 243));

        jButton5.setIcon(new ImageIcon(getClass().getResource("information.png")));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new Insets(0, 7, 0, 7);
        menuBar.add(jButton5, gridBagConstraints);

        jButton6.setBackground(new Color(66, 66, 66));
        jButton6.setFont(new Font("Roboto", Font.PLAIN, 22)); // NOI18N
        jButton6.setForeground(new Color(249, 243, 243));
        jButton6.setIcon(new ImageIcon(getClass().getResource("exclamation-mark.png")));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 6, 0, 6);
        menuBar.add(jButton6, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 5, 0, 5);
        searchBar.setBorder(BorderFactory.createEmptyBorder());
        searchBar.setFont(contentCustomFont.deriveFont(18f));
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //listens to the enter key
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!searchBar.getText().isEmpty()) {
                        try {
                            Search(searchBar.getText());
                        } catch (URISyntaxException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        menuBar.add(searchBar, gridBagConstraints);

        searchLabel.setFont(contentCustomFont.deriveFont(Font.BOLD, 22f)); // NOI18N
        searchLabel.setForeground(new Color(249, 243, 243));
        searchLabel.setText("Search");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        menuBar.add(searchLabel, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new Insets(0, 2, 0, 0);

        loupe.setIcon(new ImageIcon(getClass().getResource("loupe.png")));
        loupe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loupe.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        loupe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!searchBar.getText().isEmpty()) {
                    try {
                        Search(searchBar.getText());
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    } catch (IOException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                }
            }
        });
        menuBar.add(loupe, gridBagConstraints);
        //</editor-fold>
        menuBar.revalidate();
        menuBar.revalidate();
    }

    private JPanel initArticlePane(String title, File htmlFile) throws URISyntaxException, MalformedURLException {
        URI imgPath = getClass().getResource("/articles/" + title + ".jpg").toURI();
        JPanel articlePane = new JPanel();
        articlePane.setLayout(new GridBagLayout());
        JLabel article_title = new JLabel();
        article_title.setFont(TitleCustomFont.deriveFont(36f)); // NOI18N
        article_title.setText(title);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(15, 0, 17, 0);
        articlePane.add(article_title, gridBagConstraints);

        JLabel article_coverImage = new JLabel();
        article_coverImage.setIcon(new ImageIcon(imgPath.toURL()));
        scaleImage(article_coverImage, 600, 300);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.9;
        articlePane.add(article_coverImage, gridBagConstraints);

        JScrollPane jScrollPane3 = new JScrollPane();
        jScrollPane3.setBorder(null);

        JEditorPane article_textContent = new JEditorPane();
        article_textContent.setEditable(false);
        article_textContent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        article_textContent.setFocusable(false);
        jScrollPane3.setViewportView(article_textContent);
        String fileContent;
        article_textContent.setContentType("text/html");//bach ya3ref that this isn't some weird text
        try {
            Scanner fileScanner = new Scanner(htmlFile);
            fileScanner.useDelimiter("</HTML>");//stop at
            fileContent = fileScanner.next();//reads all file and puts it in the string
            article_textContent.setText(fileContent);//setting the text
            article_textContent.setFont(contentCustomFont.deriveFont(18f));

//            article_textContent.setPage(htmlFile.toURI().toURL());//can be used
        } catch (Exception e) {
            System.out.print(e.getMessage());// we replace it b some jdialog
        }

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 5.7;
        articlePane.add(jScrollPane3, gridBagConstraints);
        return articlePane;
    }

    private JPanel initSimilarArticlePane() throws MalformedURLException, URISyntaxException {
        JPanel similarArticlesPane = new JPanel();
        ArrayList<String> fileNames = getArticle(".html");//get .html files
        ArrayList<String> articleNames = getRandomArticles(fileNames, 3); // get 3 random Articles
        preview1 = new ArticlePreview(articleNames.get(0));
        preview2 = new ArticlePreview(articleNames.get(1));
        preview3 = new ArticlePreview(articleNames.get(2));

        similarArticlesPane.setLayout(new BoxLayout(similarArticlesPane, BoxLayout.PAGE_AXIS));
        similarArticlesPane.setPreferredSize(new Dimension(250, 700));
        seeAlso.setFont(contentCustomFont.deriveFont(18f));
        seeAlso.setPreferredSize(new Dimension(200, 44));
        seeAlso.setText("<html><div style=\" margin:10px; height: 50px; text-decoration:underline; \"><h2>À voir aussi</h2></div></html>");
        similarArticlesPane.add(seeAlso);

        preview2.setSize(210, 250);
        similarArticlesPane.add(preview2);

        preview1.setSize(190, 250);
        similarArticlesPane.add(preview1);
        similarArticlesPane.add(preview3);
        setListeners();
        return similarArticlesPane;
    }

    private void updatePane(String newTitle) throws URISyntaxException, MalformedURLException {
        File newHtmlfile = new File(getClass().getResource("\\articles\\" + newTitle + ".html").toURI());
        JPanel panel = initArticlePane(newTitle, newHtmlfile);
        articleScroll.remove(articlePane);
        articleScroll.setViewportView(panel);
        articleScroll.revalidate();
        articleScroll.repaint();

        //change the main global variables just in case
        title = newTitle;
        htmlFile = newHtmlfile;

        similarContentScroll.remove(similarArticlesPane);
        similarContentScroll.setViewportView(initSimilarArticlePane());
    }

    // sets the listeners for labels cuz we need to set them each time we create new preview
    private void setListeners() {
        //<editor-fold desc="setListeners">
        preview1.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview1.previewTitle.getText().replaceAll("\\<.*?\\>", "");// get the title and removes the html tags
                try {
                    updatePane(newTitle);
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                } catch (MalformedURLException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        preview2.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview2.previewTitle.getText().replaceAll("\\<.*?\\>", ""); // get the title and removes the html tags
                try {
                    updatePane(newTitle);
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                } catch (MalformedURLException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        preview3.previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newTitle = preview3.previewTitle.getText().replaceAll("\\<.*?\\>", "");// get the title and removes the html tags
                try {
                    updatePane(newTitle);
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                } catch (MalformedURLException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
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
        subContainer.remove(articleScroll);
        subContainer.remove(similarContentScroll);
        subContainer.revalidate();
        subContainer.repaint();

        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView();
        subContainer.setLayout(new FlowLayout());
        scrollPane.setBorder(null);
        //removing the search bar from the menubar
        menuBar.remove(searchBar);
        menuBar.remove(searchLabel);
        menuBar.remove(loupe);
        menuBar.revalidate();
        menuBar.repaint();

        //setting the seachPane
        searchPane = new SearchPane(val, 5);
        scrollPane.setViewportView(searchPane); //the viewport isnt working
        subContainer.add(scrollPane);
        subContainer.revalidate();
        subContainer.repaint();
        setSearchPaneListener(searchPane.getJComponents());

    }

    private void setSearchPaneListener(ArticlePreview[] arr) {
        for (final ArticlePreview articlePreview : arr) {
            if (articlePreview != null)
                articlePreview.getPreviewTitle().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        title = articlePreview.getTitle();
                        subContainer.removeAll();
                        try {
                            setContentPane();
                        } catch (MalformedURLException malformedURLException) {
                            malformedURLException.printStackTrace();
                        } catch (URISyntaxException malformedURLException) {
                            malformedURLException.printStackTrace();
                        }
                        addSearchBar();
                        subContainer.revalidate();
                        subContainer.repaint();
                    }
                });
        }
    }

    public JLabel getGoHome(){
        return goHome;
    }

    public static void main(String[] args) {
    }
}

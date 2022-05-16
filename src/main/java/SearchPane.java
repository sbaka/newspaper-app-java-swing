
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchPane extends javax.swing.JPanel {

    /**
     * Creates new form SearchPane
     */
    public SearchPane(String title, int numberOfArticles) throws IOException, URISyntaxException {
        this.title = title;
        this.nbrOfArticles = numberOfArticles;
        contentCustomFont = new Font("", Font.PLAIN, 24);
        try{ //change the path 3la hsabek
            contentCustomFont =Font.createFont(Font.TRUETYPE_FONT,new File(getClass().getResource("\\Font\\Nunito-Light.ttf").toURI()));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(contentCustomFont.deriveFont(Font.BOLD,18f)); //

        }catch (Exception e){
            System.err.println("Error");
        }
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() throws IOException, URISyntaxException {
        java.awt.GridBagConstraints gridBagConstraints;


        Title = new javax.swing.JLabel("COVID\"19 News");
        searchBar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loupe = new JLabel();
        articleScroll = new JScrollPane();

        setLayout(new java.awt.GridBagLayout());

        Title.setFont(contentCustomFont.deriveFont(Font.BOLD,28f));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 7, 6, 7);
        add(Title, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 6);
        add(searchBar, gridBagConstraints);

        //not working somehow
//        loupe.setIcon(new ImageIcon(getClass().getResource("loupe.png")));
//        loupe.setBorder(null);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 2;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.ipadx = 6;
//        gridBagConstraints.ipady = 1;
//        gridBagConstraints.insets = new Insets(0, 2, 0, 0);
//        add(loupe, gridBagConstraints);

        jLabel2.setText("You searched for:");
        jLabel2.setFont(contentCustomFont.deriveFont(18f));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 50, 4, 12);
        add(jLabel2, gridBagConstraints);


        initPanel();
        listeners();
    }// </editor-fold>
    private void initPanel() throws IOException, URISyntaxException {
        jPanel1 = initpreviewArticles();
        articleScroll.setViewportView(jPanel1);
        articleScroll.setBorder(null);
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1;
        add(articleScroll, gridBagConstraints);
        revalidate();
        repaint();
    }
    private JPanel initpreviewArticles() throws IOException, URISyntaxException {
        JPanel subPanel = new JPanel();
        prvTable = new ArticlePreview[nbrOfArticles];
        ArrayList<String>allArticles = new Functions().getArticle(".html");
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));
        prv1 = new ArticlePreview(title,0);
        prvTable[0] = prv1;
        subPanel.add(prv1);
        for (int i = 1; i < nbrOfArticles-2; i++) {
            prvTable[i] =new ArticlePreview(allArticles.get(i),0);
            subPanel.add(prvTable[i]);
        }
        return subPanel;
    }
    public ArticlePreview[] getJComponents(){
        return prvTable;
    }
    private void listeners() {
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER  ){
                    File mainFile = null;
                    try {
                        mainFile = new File(getClass().getResource("\\articles").toURI());
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }

                    assert mainFile != null;
                    String[] listOfFiles = mainFile.list();
                    String res;
                    boolean found = false;
                    if (listOfFiles != null) {
                        for (String file : listOfFiles) {
                            //faire to lowercase pour que les resultat soit homogene !
                            if (file.toLowerCase().contains(searchBar.getText().toLowerCase())) {
                                res = file.replace(".html", "");
                                found = true;
                                title = res; // Change the pane
                                try {
                                    initPanel();
                                } catch (IOException | URISyntaxException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;
                            }
                        }
                        // si la var found reste sur faux cad le fichier n'a pas ete trouvé
                        if (!found) {
                            JOptionPane.showMessageDialog(jPanel1, "File Not Found Try Again");
                        }
                    } else {
                        System.err.println("err");
                    }
                    searchBar.setText(null);
                }
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loupe;
    private javax.swing.JPanel jPanel1;
    private  Font contentCustomFont;
    private JScrollPane articleScroll;
    private ArticlePreview prv1;
    private ArticlePreview[] prvTable;
    private String title;
    private int nbrOfArticles;
    private javax.swing.JTextField searchBar;
    // End of variables declaration
}
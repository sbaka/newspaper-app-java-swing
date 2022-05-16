

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class ArticlePreview extends JPanel {
    private final String title;
    private final URI imgPath;
    private JLabel previewCover;
    private Font contentCustomFont;
    JLabel previewTitle;
    public ArticlePreview(String title) throws URISyntaxException, MalformedURLException {
        this.title = title;
        this.imgPath = this.getClass().getResource("/articles/"+title+".jpg").toURI();
        contentCustomFont = new  Font("", Font.PLAIN,24 );
        try{ //change the path 3la hsabek
            contentCustomFont =Font.createFont(Font.TRUETYPE_FONT,new File(getClass().getResource("\\Font\\Nunito-Light.ttf").toURI()));
        }catch (Exception e){
            System.err.println("Error");
        }
        initComponents();
    }
    public ArticlePreview(String title,int rand) throws URISyntaxException, IOException {
        this.imgPath = this.getClass().getResource("/articles/"+title+".jpg").toURI();
        this.title = title;
        contentCustomFont = new  Font("", Font.PLAIN,24 );
        try{ //change the path 3la hsabek
            contentCustomFont =Font.createFont(Font.TRUETYPE_FONT,new File(getClass().getResource("\\Font\\Nunito-Light.ttf").toURI()));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(contentCustomFont.deriveFont(Font.BOLD,18f)); //

        }catch (Exception e){
            System.err.println("Error");
        }
        initVerticalComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="InitFunction">
    private void initComponents() throws MalformedURLException {

        // Variables declaration - do not modify
        previewCover = new JLabel();
        previewTitle = new JLabel();
        Font contentCustomFont = new  Font("", Font.PLAIN,24 );
        try{ //change the path 3la hsabek
            contentCustomFont =Font.createFont(Font.TRUETYPE_FONT,new File(getClass().getResource("\\Font\\Nunito-Light.ttf").toURI()));
        }catch (Exception e){
            System.err.println("Error");
        }
        setPreferredSize(new Dimension(250,210));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        previewCover.setIcon(new ImageIcon(imgPath.toURL()));
        new Functions().scaleImage(previewCover,250,120);

        previewCover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewCover.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(previewCover);

        previewTitle.setFont(contentCustomFont.deriveFont(Font.BOLD,18f));
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(contentCustomFont.deriveFont(Font.BOLD,18f)); //
        previewTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewTitle.setText("<html><div align=\"center\" style=\" width: 150px; height:auto;\">"+title+"</html>");

        previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                previewTitle.setText("<html><div align=\"center\" style=\" width: 150px; height:auto; " +
                        "text-decoration: underline;\">"+title+"</html>");
                previewTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                previewTitle.setText("<html><div align=\"center\" style=\" width: 150px; height:auto;\">"+title+"</html>");
            }
        });
        add(previewTitle);
    }
    // </editor-fold>
    public String getTitle(){
        return title;
    }
    private void initVerticalComponents() throws IOException, URISyntaxException {
        JLabel previewImage = new JLabel();
        previewTitle = new JLabel();
        JPanel subContainer = new JPanel();
        JEditorPane articleContent = new JEditorPane();
        setLayout(new FlowLayout());

        previewImage.setIcon(new ImageIcon(imgPath.toURL()));
        new Functions().scaleImage(previewImage,250,120);
        previewImage.setPreferredSize(new Dimension(250,150));
        add(previewImage);

        subContainer.setLayout(new BorderLayout());

        previewTitle.setFont(contentCustomFont.deriveFont(Font.BOLD,22f));
        previewTitle.setBackground(Color.decode("#f9f3f3"));
        previewTitle.setText("<html><div align=\"center\" style=\" width: 350px; height:auto;\">"+title+"</html>");
        //<editor-fold desc="mouse listeners">
        previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                previewTitle.setText("<html><div align=\"center\" style=\" width: 350px; height:auto; " +
                        "text-decoration: underline;\">"+title+"</html>");
                previewTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        previewTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                previewTitle.setText("<html><div align=\"center\" style=\" width: 350px; height:auto;\">"+title+"</html>");
            }
        });


        //</editor-fold>
        subContainer.add(previewTitle,BorderLayout.PAGE_START);

        articleContent.setEditable(false);
        articleContent.setFocusable(false);
        articleContent.setContentType("text/html");
        //<editor-fold desc="reding some lines from the file">
        File file = new File(getClass().getResource("/articles/"+title+".html").toURI());
        StringBuilder str = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("<p>")){
                break;
            }
        }
        int i = 0;
        while ((line = br.readLine()) != null && i<1) {
            str.append(line);
            i++;
        }
        //</editor-fold>
        articleContent.setText(str.toString());
        articleContent.setFont(contentCustomFont.deriveFont(14f));
        articleContent.setPreferredSize(new Dimension(300,130));
        articleContent.setBackground(Color.decode("#f9f3f3"));
        subContainer.add(articleContent,BorderLayout.PAGE_END);
        setBackground(Color.decode("#f9f3f3"));
        add(subContainer);
    }
    public JLabel getPreviewTitle(){
        return previewTitle;
    }


    public static void main(String[] args) throws URISyntaxException, IOException {
//        JFrame frame = new JFrame();
//        frame.setContentPane(new ArticlePreview("5 mythes et faits sur le vaccin COVID-19",0));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(570,250);
//        frame.setVisible(true);
    }

    // End of variables declaration
}

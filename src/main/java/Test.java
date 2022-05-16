import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Test extends JFrame {
    Article article;
    String PATH = "D:\\Studies\\University\\L3\\IHM\\project\\Module\\src\\main\\resources\\articles\\";
    File file = new File(PATH + "La Chine donne 200 000 doses de vaccin à l’Algérie.html");
    String title;
    public Test(String title) throws IOException, URISyntaxException {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        this.title = title;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        article = new Article(file,title);
        setContentPane(/*new SearchPane("5 mythes et faits sur le vaccin COVID-19")*/article);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(screenSize.width,screenSize.height));
        article.getGoHome().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new MainWindow().setVisible(true);
                    dispose();
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                } catch (URISyntaxException malformedURLException) {
                    malformedURLException.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Test("5 mythes et faits sur le vaccin COVID-19").setVisible(true);
    }
}

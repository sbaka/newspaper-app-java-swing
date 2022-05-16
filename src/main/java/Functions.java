import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Functions {
    public void scaleImage(JLabel label, int width, int hight){
        ImageIcon icon = (ImageIcon)label.getIcon();
        Image img = icon.getImage().getScaledInstance(width,hight,Image.SCALE_SMOOTH); //scales the icon 3la hasab l label
        System.out.println();
        ImageIcon scaledIcon = new ImageIcon(img);
        label.setIcon(scaledIcon);
    }
    public void readFile(){
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("filename : ");
            File file = new File(getClass().getResource("/articles/"+s.nextLine()+".html").toURI().toString());
            System.out.println(file.exists());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public ArrayList<String> getArticle(String extension) throws URISyntaxException {// returns a list of fileNames with a specific extension
        URI articlesPath = getClass().getResource("/articles").toURI();
        File doc = new File(articlesPath);
        String[] fileNames;
        fileNames = doc.list();
        assert fileNames != null;
        ArrayList<String> reqFiles = new ArrayList<>();
        for (String filename : fileNames) {
            if (filename.contains(extension)) {
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
    public static void main(String[] args) throws URISyntaxException {

    }
}

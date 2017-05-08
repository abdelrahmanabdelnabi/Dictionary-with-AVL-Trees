import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.util.Comparator;

/**
 * Created by abdelrahman on 5/1/17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AVLTree<String> dictionary = new AVLTree<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        GUI treeDrawer = new GUI(dictionary);

        File file = new File(System.getProperty("user.dir") + "/src/dictionary.txt");

        long startTime = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                dictionary.add(line);
            }
        } catch (IOException e) {
            System.out.println("Can not read dictionary file");
            System.out.println(e.getMessage());
        }

        System.out.println(dictionary.height());

        treeDrawer.repaint();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Reading and inserting time: " + elapsedTime + " ms");
        System.out.println("Number of words inserted: " + dictionary.size());

        dictionary.remove("galileo");
        System.out.println(dictionary.size());
    }
}
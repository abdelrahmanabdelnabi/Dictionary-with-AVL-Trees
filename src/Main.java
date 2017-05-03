import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;

/**
 * Created by abdelrahman on 5/1/17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AVLTree<String> dictionary = new AVLTree<>();

        File file = new File(System.getProperty("user.dir") + "/src/small.txt");

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

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Reading and inserting time: " + elapsedTime + " ms");
        System.out.println("Number of words inserted: " + dictionary.size());

        dictionary.remove("galileo");
        System.out.println(dictionary.size());
    }
}
import java.io.*;
import java.util.Comparator;

import java.util.Scanner;

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
        Scanner scanner=new Scanner(System.in);


        File file = new File(System.getProperty("user.dir") + "/src/dictionary.txt");


        long startTime = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                dictionary.add(line);
            }
        } catch (IOException e) {
            System.out.println("Can not the file");
            System.out.println(e.getMessage());
        }

        treeDrawer.repaint();
        scanner.next();


        // Queries from a file
        File QueryFromFile = new File(System.getProperty("user.dir") + "/src/queries.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(QueryFromFile))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                System.out.println("Querying " + "\"" + line + "\"" + " " + dictionary.contains(line));
            }
        } catch (IOException e) {
            System.out.println("Can not read the file");
            System.out.println(e.getMessage());
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Number of words inserted: " + dictionary.size());
        System.out.println("Reading and inserting time: " + elapsedTime + " ms");

        // Reading and deleting from file
        long oldDictionarySize=dictionary.size();

        File removeFromFile = new File(System.getProperty("user.dir") + "/src/deletions.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(removeFromFile))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                System.out.println("Deleting " + "\"" + line + "\"" + " " + dictionary.remove(line));
            }
        } catch (IOException e) {
            System.out.println("Can not read the file");
            System.out.println(e.getMessage());
        }

        treeDrawer.repaint();
        scanner.next();

        System.out.println("Reading and deleting time: " + elapsedTime + " ms");
        System.out.println("Number of words Deleted: " + (oldDictionarySize - dictionary.size()) );


        // Add a word
        String word;
        System.out.print("Enter a word to add: ");
        word=scanner.next();
        System.out.println("Adding " + "\"" + word + "\"" + " " + dictionary.add(word));

        // Delete a word
        System.out.print("Enter a word to delete: ");
        word=scanner.next();
        System.out.println("Deleting " + "\"" + word + "\"" + " " + dictionary.remove(word));

        // Search for a word
        System.out.print("Enter a word to search for: ");
        word=scanner.next();
        System.out.println("Searching for " + "\"" + word + "\"" + " " + dictionary.contains(word));

        System.out.println("Tree Height: " + dictionary.getHeight());

    }
}

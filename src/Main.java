/**
 * Created by abdelrahman on 5/1/17.
 */
public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();

        tree.add(5);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        System.out.println(tree.size());
    }
}

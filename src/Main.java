/**
 * Created by abdelrahman on 5/1/17.
 */
public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();

        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(6);
        tree.add(8);
        tree.add(10);
        tree.add(6);
        tree.add(1);

        System.out.println(tree.contains(5) + " " + tree.contains(4) + " " + tree.contains(3) +
                " " + tree.contains(2));

        tree.showTree();
        System.out.println(tree.size());
    }
}

import java.util.*;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E extends Comparable<E>> extends BalancedTreeSet<E> {

    private Node<E> root = null;

    private int size = 0;
    private Comparator<? super E> comparator;

    public AVLTree() {

    }

    public AVLTree(Comparator<? super E> c) {
        this.comparator = c;
    }

    // TODO: Implement the methods below

    private Node<E> balance(Node<E> node) {
        if (node == null)
            return null;

        int hleft = height(node.left);
        int hright = height(node.right);

        if (hleft - hright > 1)
            if (height(node.left.left) >= height(node.left.right))
                node = rotateLeft(node);
            else
                node = doubleRotateLeft(node);
        else if (hright - hleft > 1)
            if (height(node.right.right) >= height(node.right.left))
                node = rotateRight(node);
            else
                node = doubleRotateRight(node);

        node.height = max(height(node.left), height(node.right)) + 1;
        return node;

    }

    private int height(Node<E> t) {
        return t == null ? -1 : t.height;
    }

    private Node<E> rotateLeft(Node<E> k2) {
        Node<E> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(k2.left.height, k2.right.height) + 1;
        k1.height= max(k1.left.height, k2.height) + 1;
        return k1;
    }


    private Node<E> rotateRight(Node<E> k1) {
        Node<E> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;

        k2.height = max(height(k2.right), height(k1)) + 1;
        return k2;
    }

    private Node<E> doubleRotateLeft(Node<E> k3) {
        k3.left = rotateRight(k3.left);
        return rotateLeft(k3);
    }

    private Node<E> doubleRotateRight(Node<E> k1) {
        k1.right = rotateLeft(k1.right);
        return rotateRight(k1);
    }

    private Node<E> insert(E data, Node<E> node) {
        if (node == null) {
            size++;
            return new Node<>(data, null, null);
        }

        int compareResult = myCompare(data, node.getData());

        if (compareResult < 0)
            node.left = insert(data, node.left);
        else if (compareResult > 0)
            node.right = insert(data, node.right);
        else // Ignore duplicates
            ;

        return balance(node);

    }

    private void displayTree(Node<E> node) {
        if (node == null)
            return;

        displayTree(node.left);
        System.out.println(node.getData() + " ");
        displayTree(node.right);

    }

    private int myCompare(E first, E second) {
        if (comparator != null)
            return comparator.compare(first, second);

        return first.compareTo(second);
    }

    private boolean delete(Object data, Node<E> root) {
        return false;
    }

    private E maximum(Node<E> node) {
        if (node == null)
            return node.getData();

        while (node.right != null)
            node = node.right;

        return node.getData();
    }

    private E minimum(Node<E> node) {
        if (node == null)
            return node.getData();

        while (node.left != null)
            node = node.left;

        return node.getData();
    }

    private boolean isEmpty(Node<E> node) {
        return (node == null);
    }

    @Override
    public boolean add(E e) {
        if (root == null) {
            root = insert(e, root);
            return root != null;
        }
        return insert(e, root) != null;
    }

    @Override
    public boolean remove(Object o) {
        return delete(o, root);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean inserted = false;
        for (E e : collection) {
            if (e == null)
                throw new NullPointerException("Null elements are not allowed");

            if (add(e))
                inserted = true;
        }

        return inserted;
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return search(o, this.root) != null;
    }

    private Node<E> search(Object key, Node<E> root) {
        if (comparator != null)
            return searchWithComparator(key);
        if (key == null)
            throw new NullPointerException();

        @SuppressWarnings("unchecked")
        Comparable<? super E> k = (Comparable<? super E>) key;
        Node<E> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.getData());
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    private Node<E> searchWithComparator(Object key) {
        @SuppressWarnings("unchecked")
        E k = (E) key;
        Comparator<? super E> cpr = comparator;
        if (cpr != null) {
            Node<E> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.getData());
                if (cmp < 0)
                    p = p.left;
                else if (cmp > 0)
                    p = p.right;
                else
                    return p;
            }
        }
        return null;
    }

    private int max(int x, int y) {
        return Integer.max(x, y);
    }

    private int getBalanceFactor(Node<E> node) {
        if (node == null)
            return 0;
        return node.left.height - node.right.height;
    }

    @Override
    public boolean isBalanced() {
        return false;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object o : collection) {
            if (o == null)
                throw new NullPointerException("Null elements are not allowed");

            if (search(o, root) != null) {
                delete(o, root);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E first() {
        return minimum(root);
    }

    @Override
    public E last() {
        return maximum(root);
    }

    public static void main(String args[]) {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.add(5);
        tree.add(7);

        System.out.println(tree.contains(5) + " " + tree.contains(7));

        tree.displayTree(tree.root);
    }

}
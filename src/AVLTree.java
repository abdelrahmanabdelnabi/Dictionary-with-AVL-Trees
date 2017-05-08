import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E extends Comparable<E>> extends BalancedTreeSet<E> {

    private Node<E> root = null;

    private int size = 0;
    private Comparator<? super E> comparator;

    /**************************
     * CONSTRUCTORS
     **************************/

    public AVLTree() {

    }

    public Node<E> getRoot() {
        return root;
    }

    public AVLTree(Comparator<? super E> c) {
        this.comparator = c;
    }


    /**************************
     * COLLECTIONS INTERFACE METHODS
     **************************/

    @Override
    public boolean add(E e) {
        int sizeBefore = size();
        root = insert(e, root);
        int sizeAfter = size();
        return sizeAfter != sizeBefore;
    }

    @Override
    public boolean contains(Object o) {
        return search(o, this.root) != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        if (contains(o)) {
            int sizeBefore = size();
            root = delete((E) o, root, false);
            int sizeAfter = size();

            return sizeAfter != sizeBefore;
        }
        return false;
    }

    public int getHeight(){
        return root!=null ? root.height+1 : 0;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        super.clear();
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
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object o : collection) {
            if (o == null)
                throw new NullPointerException("Null elements are not allowed");

            if (remove(o))
                modified = true;
        }
        return modified;
    }

    /**************************
     * SORTED SET INTERFACE METHODS
     **************************/


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
    public E first() {
        return minimum(root).data;
    }

    @Override
    public E last() {
        return maximum(root);
    }

    @Override
    public int height() {
        return root.height;
    }

    @Override
    public boolean isBalanced() {
        return false;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
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

    private Node<E> delete(E key, Node<E> node, boolean found) {
        if (node == null)
            return node;

        int compareResult = myCompare(key, node.data);

        if (compareResult < 0)
            node.left = delete(key, node.left, found);
        else if (compareResult > 0)
            node.right = delete(key, node.right, found);
        else {
            if(!found) // if the key has just been found
                size--;
            if (node.left != null && node.right != null) {
                node.data = minimum(node.right).data;
                node.right = delete(node.data, node.right, true); // set found to true to avoid
                // decrementing the size twice
            } else
                node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
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

    private E maximum(Node<E> node) {
        if (node == null)
            return node.getData();

        while (node.right != null)
            node = node.right;

        return node.getData();
    }

    private Node<E> minimum(Node<E> node) {
        if (node == null)
            return node;

        while (node.left != null)
            node = node.left;

        return node;
    }

    // balance and rotation methods
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

    private Node<E> rotateLeft(Node<E> k2) {
        Node<E> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), height(k2)) + 1;
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

    public void showTree() {
        displayTree(root);
    }

    // private Utilities

    private int myCompare(E first, E second) {
        if (comparator != null)
            return comparator.compare(first, second);

        return first.compareTo(second);
    }

    private boolean isEmpty(Node<E> node) {
        return (node == null);
    }

    private int height(Node<E> t) {
        return t == null ? -1 : t.height;
    }

    private int max(int x, int y) {
        return Integer.max(x, y);
    }

    private int getBalanceFactor(Node<E> node) {
        if (node == null)
            return 0;
        return node.left.height - node.right.height;
    }

    private void displayTree(Node<E> node) {
        if (node == null)
            return;

        displayTree(node.left);
        System.out.print(node.getData() + " ");
        displayTree(node.right);

    }

}

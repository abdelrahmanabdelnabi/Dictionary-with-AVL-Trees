import java.util.*;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E extends Comparable> extends BalancedTreeSet<E> {

    private Node<E> root = null;
    private int size = 0;
    private Comparator<? extends E> comparator;

    public AVLTree() {

    }

    public AVLTree(Comparator<? extends E> c) {
        this.comparator = c;
    }

    // TODO: Implement the methods below

    private Node<E> search(Object key, Node<E> root) {
        return null;
    }

    private boolean insert(E data, Node<E> root) {
        return false;
    }

    private boolean delete(Object data, Node<E> root) {
        return false;
    }

    private E maximum(Node<E> root) {
        return null;
    }

    private E minimum(Node<E> root) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return search(o, root) != null;
    }

    @Override
    public boolean add(E e) {
        return insert(e, root);
    }

    @Override
    public boolean remove(Object o) {
        return delete(o, root);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean inserted = false;
        for (E e : collection) {
            if(e == null)
                throw new NullPointerException("Null elements are not allowed");

            if(add(e))
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
        for(Object o : collection) {
            if(o == null)
                throw new NullPointerException("Null elements are not allowed");

            if(search(o, root) != null) {
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
}

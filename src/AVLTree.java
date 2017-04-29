import java.util.*;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E extends Comparable> extends BalancedTreeSet<E> {

    Node<E> root = null;
    int size = 0;

    public AVLTree() {

    }

    // TODO: Implement the methods below

    private Node<E> search(E key, Node<E> root) {
        return null;
    }

    private boolean insert(E data, Node<E> root) {
        return false;
    }

    private boolean delete(E data, Node<E> root) {
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
        return super.contains(o);
    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
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
    public int size() {
        return 0;
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
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }
}

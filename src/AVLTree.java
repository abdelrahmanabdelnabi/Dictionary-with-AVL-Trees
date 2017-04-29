import java.util.*;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E> extends BalancedTreeSet<E> {
    Node<E> root = null;
    int size = 0;

    public AVLTree() {

    }

    // TODO: Implement the methods below

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
    public int maxHeight() {
        return 0;
    }

    @Override
    public boolean isBalanced() {
        return false;
    }
}

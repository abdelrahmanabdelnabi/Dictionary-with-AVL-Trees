import java.util.Comparator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;


import java.util.*;

/**
 * Created by abdelrahman on 4/29/17.
 */
public class AVLTree<E> extends BalancedTreeSet<E> {

    private Node<E> root = null;
    private int size = 0;
    private Comparator<? super E> comparator;

    public AVLTree() {

    }

    public AVLTree(Comparator<? super E> c) {
        this.comparator = c;
    }

    // TODO: Implement the methods below

    private Node<E> search(Object key, Node<E> root) {
        return null;
    }

    private Node<E> insert(E data, Node<E> node) {
        if(node==null)
            return new Node<>(data, null, null);

        int compareResult=data.compareTo(node.getData());

        if(compareResult < 0)
            node.setLeft(insert(data, node.getLeft()));
        else if(compareResult > 0)
            node.setRight(insert(data, node.getRight()));
        else // Ignore duplicates
            return node;

        node.setHeight(max(root.getLeft().getHeight(), root.getRight().getHeight() +1);

        int balanceFactor=getBalanceFactor(node);

        if(balanceFactor>1 && data.compareTo(node.getLeft().getData()) < 0)
            return rotateRight(node);

        if(balanceFactor<-1 && data.compareTo(node.getRight().getData()) > 0)
            return rotateLeft(node);

        if(balanceFactor > 1 && data.compareTo(node.getLeft().getData()) > 0){
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        if(balanceFactor < -1 && data.compareTo(node.getRight().getData()) < 0){
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;

    }

    private int myCompare(E first, E second) {
        if(comparator != null)
            return comparator.compare(first, second);

        if(!(first instanceof Comparable && second instanceof Comparable))
            throw new ClassCastException();

        return ((Comparable)first).compareTo( second );
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


    private int height(Node<E> node){
        if(node==null)
            return 0;
        return node.getHeight();
    }

    int max(int x, int y){
        return x>y? x:y;
    }

    public Node<E> rotateRight(Node<E> root){
        Node<E> x=root.getLeft();
        Node<E> y=x.getRight();

        x.setRight(root);
        root.setLeft(y);

        root.setHeight(max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1);
        x.setHeight(max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);

        return x;
    }

    public Node<E> rotateLeft(Node<E> root){
        Node<E> x=root.getRight();
        Node<E> y=x.getLeft();

        x.setLeft(root);
        root.setRight(y);

        root.setHeight(max(root.getLeft().getHeight(), root.getRight().getHeight()));
        x.setHeight(max(x.getLeft().getHeight(), x.getRight().getHeight()));

        return x;
    }

    private int getBalanceFactor(Node<E> node){
        if(node==null)
            return 0;
        return node.getLeft().getHeight() - node.getRight().getHeight();
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

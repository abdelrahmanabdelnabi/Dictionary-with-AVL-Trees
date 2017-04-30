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

        @Override
        public int height(Node<E> node){
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
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }
}

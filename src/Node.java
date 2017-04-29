/**
 * Created by abdelrahman on 4/29/17.
 */
class Node<E> {
    private E data;
    private int height;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
        this.data = data;
        height = -1;
        left = right = null;
    }

    public Node(E data, Node<E> left, Node<E> right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }
}

/**
 * Created by abdelrahman on 4/29/17.
 */
class Node<E> {
    private E data;
    private int height;
    private Node<E> left;
    private Node<E> right;

    public int getHeight() {
        return height;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getRight() {

        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getLeft() {

        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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

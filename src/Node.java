/**
 * Created by abdelrahman on 4/29/17.
 */
class Node<E> {
    E data;
    int height;
    Node<E> left;
    Node<E> right;

    Node(E data) {
        this(data, null, null);
    }


    Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    E getData() {
        return data;
    }

}

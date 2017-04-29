import java.util.AbstractCollection;
import java.util.AbstractSet;

/**
 * Created by abdelrahman on 4/29/17.
 */
public abstract class BalancedTreeSet<E> extends AbstractSet<E> {

    /**
     * @return the current maximum height of the tree
     */
    public abstract int maxHeight();

    /**
     * mainly used for testing purposes.
     *
     * returns true iff the tree is balanced tree. The balancing condition is that for each node in
     * the tree, the difference between the height of the left and right subtree is at most 1.
     *
     * @return true if the tree is balanced, false otherwise
     */
    public abstract boolean isBalanced();
}

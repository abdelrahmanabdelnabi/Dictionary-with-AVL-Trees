import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by abdelrahman on 5/3/17.
 *
 * Tests the Collection Interface methods
 */
public class AVLTreeCollectionTest {
    AVLTree<Integer> tree;

    @org.junit.Test
    public void addOneElement() throws Exception {
    tree = new AVLTree<>();

    tree.add(5);

    assertEquals(1, tree.size());
    assertEquals(true, tree.contains(5));
    }

    @Test
    public void addThreeElements() throws Exception {
        tree = new AVLTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        assertEquals(3, tree.size());
        assertEquals(true, tree.contains(5));
        assertEquals(true, tree.contains(4));
        assertEquals(true, tree.contains(6));
    }

    @Test
    public void testAddReturnsFalse() throws Exception {
        tree = new AVLTree<>();
        tree.add(5);
        assertEquals(false, tree.add(5));
    }

    @Test
    public void testAddReturnsTrue() throws Exception {
        tree = new AVLTree<>();
        assertEquals(true, tree.add(5));
    }

    @Test
    public void testEmptyContains() throws Exception {
        tree = new AVLTree<>();
        assertEquals(false, tree.contains(1));
    }

    @Test
    public void testContainsReturnsTrue() throws Exception {
        tree = new AVLTree<>();
        tree.add(1);
        assertEquals(true, tree.contains(1));
    }

    @Test
    public void testContainsReturnsFalse() throws Exception {
        tree = new AVLTree<>();
        tree.add(1);
        assertEquals(false, tree.contains(2));
    }

    @Test
    public void testRemoveRoot() throws Exception {
        tree = new AVLTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.remove(5);

        assertEquals(true, tree.contains(4));
        assertEquals(true, tree.contains(6));
        assertEquals(false, tree.contains(5));
    }

    @Test
    public void testRemoveLeaf() throws Exception {
        tree = new AVLTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.remove(3);
        assertEquals(true, tree.contains(4));
        assertEquals(true, tree.contains(5));
        assertEquals(false, tree.contains(3));
    }

    @Test
    public void testRemoveInternal() throws Exception {
        tree = new AVLTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.remove(4);
        assertEquals(false,tree.contains(4));
        assertEquals(true,tree.contains(5));
        assertEquals(true,tree.contains(6));
        assertEquals(true,tree.contains(2));
        assertEquals(true,tree.contains(3));
    }

    @Test
    public void addAll() throws Exception {
        ArrayList<Integer> numbers = new ArrayList<>();
        tree = new AVLTree<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(6);

        tree.addAll(numbers);

        assertEquals(3, tree.size());
        assertEquals(true, tree.contains(5));
        assertEquals(true, tree.contains(4));
        assertEquals(true, tree.contains(6));
    }

    @Test
    public void removeAll() throws Exception {
        ArrayList<Integer> numbers = new ArrayList<>();
        tree = new AVLTree<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(6);

        tree.addAll(numbers);
        tree.removeAll(numbers);

        assertEquals(0, tree.size());
        assertEquals(false, tree.contains(5));
        assertEquals(false, tree.contains(4));
        assertEquals(false, tree.contains(6));
    }

}
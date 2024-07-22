package structures;

import krivokapic.djordjije.structures.UnionFind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UnionFindTest {

    private UnionFind<String> unionFind;


    @BeforeEach
    void setUp() {
        unionFind = new UnionFind<>();
    }


    @Test
    void addNewItem() {
        Optional<String> result = unionFind.add("A");

        assertTrue(result.isPresent());
        assertEquals("A", result.get());
        assertEquals(1, unionFind.components());
    }


    @Test
    void addExistingItem() {
        unionFind.add("A");
        Optional<String> result = unionFind.add("A");

        assertFalse(result.isPresent());
        assertEquals(1, unionFind.components());
    }


    @Test
    void findNonExistentItem() {
        Optional<String> result = unionFind.find("A");

        assertFalse(result.isPresent());
    }


    @Test
    void findExistingItem() {
        unionFind.add("A");
        Optional<String> result = unionFind.find("A");

        assertTrue(result.isPresent());
        assertEquals("A", result.get());
    }


    @Test
    void unionOfNonExistentItems() {
        unionFind.union("A", "B");

        assertEquals(0, unionFind.components());
    }


    @Test
    void unionOfExistingItems() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.union("A", "B");

        assertEquals(1, unionFind.components());
        assertTrue(unionFind.connected("A", "B"));
    }


    @Test
    void unionOfAlreadyConnectedItems() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.union("A", "B");

        int componentsBefore = unionFind.components();

        unionFind.union("A", "B");

        assertEquals(componentsBefore, unionFind.components());
    }


    @Test
    void connectedWithNonExistentItems() {
        assertFalse(unionFind.connected("A", "B"));
    }


    @Test
    void connectedWithUnconnectedItems() {
        unionFind.add("A");
        unionFind.add("B");

        assertFalse(unionFind.connected("A", "B"));
    }


    @Test
    void connectedWithConnectedItems() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.union("A", "B");

        assertTrue(unionFind.connected("A", "B"));
    }


    @Test
    void componentSizeOfNonExistentItem() {
        assertEquals(-1, unionFind.componentSize("A"));
    }


    @Test
    void componentSizeOfSingleItem() {
        unionFind.add("A");

        assertEquals(1, unionFind.componentSize("A"));
    }


    @Test
    void componentSizeAfterUnion() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.union("A", "B");

        assertEquals(2, unionFind.componentSize("A"));
        assertEquals(2, unionFind.componentSize("B"));
    }


    @Test
    void componentsInitially() {
        assertEquals(0, unionFind.components());
    }


    @Test
    void componentsAfterAddingItems() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.add("C");

        assertEquals(3, unionFind.components());
    }


    @Test
    void componentsAfterUnion() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.add("C");
        unionFind.union("A", "B");

        assertEquals(2, unionFind.components());
    }


    @Test
    void largeNumberOfUnions() {
        for (int i = 0; i < 1000; i++) {
            unionFind.add("Item" + i);
        }

        assertEquals(1000, unionFind.components());

        for (int i = 1; i < 1000; i++) {
            unionFind.union("Item0", "Item" + i);
        }

        assertEquals(1, unionFind.components());
        assertEquals(1000, unionFind.componentSize("Item0"));

        System.out.println(unionFind.getRank());
    }


    @Test
    void pathCompression() {
        unionFind.add("A");
        unionFind.add("B");
        unionFind.add("C");
        unionFind.add("D");

        unionFind.union("A", "B");
        unionFind.union("B", "C");
        unionFind.union("C", "D");

        // this find operation should compress the path
        unionFind.find("D");

        // now, all items should point directly to the root
        assertEquals(unionFind.find("A"), unionFind.find("D"));
        assertEquals(unionFind.find("B"), unionFind.find("D"));
        assertEquals(unionFind.find("C"), unionFind.find("D"));
    }
}

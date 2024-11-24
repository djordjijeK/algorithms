package datastructures;


import java.util.Map;
import java.util.HashMap;
import java.util.Optional;


public class UnionFind<T> {
    private final Map<T, T> parent;
    private final Map<T, Integer> size;
    private int numberOfComponents;


    public UnionFind() {
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
    }


    // Adds a new item to the structure as a singleton set.
    public Optional<T> add(T item) {
        if (this.parent.containsKey(item)) {
            return Optional.empty();
        }

        this.parent.put(item, item);
        this.size.put(item, 1);

        numberOfComponents += 1;

        return Optional.of(item);
    }


    // Finds the representative (root) of the set containing the item.
    // Uses path compression for optimization.
    public Optional<T> find(T item) {
        if (!this.parent.containsKey(item)) {
            return Optional.empty();
        }

        T parent = this.parent.get(item);

        if (!parent.equals(item)) {
            this.parent.put(item, find(parent).get());
        }

        return Optional.of(parent);
    }


    // Merges the sets containing item1 and item2.
    // Uses union by rank for optimization.
    public void union(T item1, T item2) {
        T root1 = find(item1).orElse(null);
        if (root1 == null) {
            return;
        }

        T root2 = find(item2).orElse(null);
        if (root2 == null || root1.equals(root2)) {
            return;
        }

        int rank1 = this.size.get(root1);
        int rank2 = this.size.get(root2);

        if (rank1 >= rank2) {
            this.parent.put(root2, root1);
            this.size.put(root1, rank1 + rank2);
        } else {
            this.parent.put(root1, root2);
            this.size.put(root2, rank1 + rank2);
        }

        numberOfComponents--;
    }


    // Checks if two items are in the same set.
    public boolean connected(T item1, T item2) {
        T root1 = find(item1).orElse(null);
        T root2 = find(item2).orElse(null);

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.equals(root2);
    }


    // Returns the size of the set containing the item.
    public int componentSize(T item) {
        T root = find(item).orElse(null);
        if (root == null) {
            return -1;
        }

        return this.size.get(root);
    }


    // Returns the total number of disjoint sets.
    public int components() {
        return numberOfComponents;
    }
}

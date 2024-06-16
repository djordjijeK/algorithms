package krivokapic.djordjije;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


// https://leetcode.com/problems/keys-and-rooms/description/
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        Set<Integer> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            Integer roomToVisit = stack.pop();
            visited.add(roomToVisit);

            for (Integer x : rooms.get(roomToVisit)) {
                if (!visited.contains(x)) {
                    stack.push(x);
                }
            }
        }

        return visited.size() == rooms.size();
    }

}

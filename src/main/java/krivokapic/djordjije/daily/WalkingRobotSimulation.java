package krivokapic.djordjije.daily;

import java.util.HashSet;
import java.util.Set;


public class WalkingRobotSimulation {
    // https://leetcode.com/problems/walking-robot-simulation/description/
    // Time Complexity: O(sum(commands))
    // Space Complexity: O(obstacles)
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(String.format("%s,%s", obstacle[0], obstacle[1]));
        }

        int currentDirection = 0;

        int maxDistance = 0;
        int currentX = 0;
        int currentY = 0;

        for (int command : commands) {
            if (command == -1) {
                currentDirection = (currentDirection + 1) % 4;
            } else if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int dX = DIRECTIONS[currentDirection][0];
                    int dY = DIRECTIONS[currentDirection][1];

                    if (obstaclesSet.contains(String.format("%s,%s", currentX + dX, currentY + dY))) {
                        break;
                    }

                    currentX += dX;
                    currentY += dY;

                    maxDistance = Math.max(maxDistance, currentX * currentX + currentY * currentY);
                }
            }
        }

        return maxDistance;
    }
}

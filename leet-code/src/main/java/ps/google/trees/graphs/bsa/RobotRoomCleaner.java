package ps.google.trees.graphs.bsa;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Pair) {
                Pair p = (Pair) o;
                return p.first == first && p.second == second;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return first * 137 ^ second * 173;
        }
    }

    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Set<Pair> visited = new HashSet<>();
    private Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}

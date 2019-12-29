package contest.c169;

public class Q3 {
    public boolean canReach(int[] arr, int start) {
        Boolean[] reachable = new Boolean[arr.length];
        boolean[] visited = new boolean[arr.length];
        return reachable(start, arr, reachable, visited);
    }

    private boolean reachable(int start, int[] arr, Boolean[] reachable, boolean[] visited) {
        if (start >= arr.length || start < 0) {
            return false; // out side boundary
        }
        if (reachable[start] != null) {
            return reachable[start];
        }
        if(visited[start]) {
            reachable[start] = false;
        } else if (arr[start] == 0) {
            reachable[start] = true;
        } else {
            visited[start] = true;
            boolean reach = reachable(start - arr[start], arr, reachable, visited);
            reach = reach || reachable(start + arr[start], arr, reachable, visited);
            reachable[start] = reach;
        }
        return reachable[start];
    }


    public static void main(String[] args) {
        Q3 sol = new Q3();
        System.out.println(sol.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(sol.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(sol.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }
}

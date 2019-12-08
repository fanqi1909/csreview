package ps.google.recursion;

import java.util.Arrays;

public class AndroidUnLockPattern {

    public int numberOfPatterns(int m, int n) {
        int ans = 0;
        boolean[] visited = new boolean[9];
        for (int len = m; len <= n; len++) {
            Arrays.fill(visited, false);
            //by symmetry
            ans += dfsFrom(0, len - 1, visited) * 4;
            ans += dfsFrom(1, len - 1, visited) * 4;
            ans += dfsFrom(4, len - 1, visited);
        }
        return ans;
    }

    private int dfsFrom(int node, int len, boolean[] visited) {
        visited[node] = true;
        int count = dfs(node, len, visited);
        visited[node] = false;
        return count;
    }

    private boolean isValid(int index, int last, boolean[] used) {
        if (used[index])
            return false;
        // knight moves or adjacent cells (in a row or in a column)
        if ((index + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (index + last) / 2;
        if (mid == 4)
            return used[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }

    private int dfs(int last, int len, boolean[] used) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last, used)) {
                used[i] = true;
                sum += dfs(i, len - 1, used);
                used[i] = false;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        AndroidUnLockPattern aup = new AndroidUnLockPattern();

        System.out.println(aup.numberOfPatterns(2, 5));
    }
}

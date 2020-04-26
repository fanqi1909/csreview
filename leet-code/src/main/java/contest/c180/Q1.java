package contest.c180;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            int index = 0;
            int min = 1000001;
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            //verify
            boolean isMax = true;
            for(int k = 0; k < matrix.length; k++) {
                if(matrix[k][index] > min) {
                    isMax = false;
                    break;
                }
            }
            if(isMax) {
                ans.add(min);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q1 sol = new Q1();
    }
}

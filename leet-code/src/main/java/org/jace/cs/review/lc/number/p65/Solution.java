package org.jace.cs.review.lc.number.p65;

public class Solution {

    public boolean isNumber(String s) {
        if(s.contains("f") || s.contains("F") || s.contains("d") || s.contains("D"))
             return false;
        boolean isValid = true;
        try {
            Double.parseDouble(s);
        }catch(Exception e){
            isValid=false;
        }
        return isValid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String test = "005047e+6";
        System.out.println(test + "\t" + solution.isNumber(test));

        test = "078332e437";
        System.out.println(test + "\t" + solution.isNumber(test));

        test = "959440.94f";
        System.out.println(test + "\t" + !solution.isNumber(test));
    }
}

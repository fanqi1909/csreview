package org.jace.cs.review.lc.string.p12;

public class Solution {

    //Use encoders to find the proper divisors in Roman numbers
    static Entry[] encoders = new Entry[]{
            new Entry(1000, "M"),
            new Entry(900, "CM"),
            new Entry(500, "D"),
            new Entry(400, "CD"),
            new Entry(100, "C"),
            new Entry(90, "XC"),
            new Entry(50, "L"),
            new Entry(40, "XL"),
            new Entry(10, "X"),
            new Entry(9, "IX"),
            new Entry(5, "V"),
            new Entry(4, "IV"),
            new Entry(1, "I"),
    };

    public String intToRoman(int num) {
        StringBuilder output = new StringBuilder();
        for(Entry encoder : encoders) {
            int occ = num / encoder.divisor;
            for(int i = 1 ; i <= occ; i++) {
                output.append(encoder.rep);
            }
            num = num - occ * encoder.divisor;
        }
        return output.toString();
    }

    static class Entry {
        public int divisor;
        public String rep;
        public Entry (int divisor, String rep) {
            this.divisor = divisor;
            this.rep = rep;
        }
    }
}
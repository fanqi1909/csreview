package org.jace.cs.review.lc.string.p166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        String sign = ((numerator > 0) ^ (denominator > 0)) ? "-" : "";
        long bigNum = Math.abs((long) numerator);
        long bigDeno = Math.abs((long) denominator);
        long integral = bigNum/bigDeno;
        long decimal = bigNum - integral * bigDeno;
        if(decimal == 0) {
            return String.format("%s%d", sign,  integral);
        } else {
            return String.format("%s%d.%s", sign, integral, formatDecimal(decimal * 10, bigDeno));
        }
    }

    private String formatDecimal(long numerator, long denominator) {
        List<Long> quotients = new ArrayList<>();
        Map<Long, Integer> quotientMap = new HashMap<>();

        while(numerator != 0 && !quotientMap.containsKey(numerator)) {
            long quotient = numerator/denominator;
            long remainder = numerator - denominator * quotient;
            quotients.add(quotient);
            quotientMap.put(numerator, quotients.size() - 1);
            numerator = remainder * 10;
        }

//        System.out.println(quotients + "\t" + quotientMap + "\t" + numerator);
//        System.out.println("****\n");

        StringBuilder result = new StringBuilder();
        for(Long quotient : quotients) {
            result.append(quotient);
        }

        if(numerator != 0) {
            int splitPosition = quotientMap.get(numerator);
            result.insert(splitPosition, '(');
            result.append(')');
        }
        return result.toString();
    }
}
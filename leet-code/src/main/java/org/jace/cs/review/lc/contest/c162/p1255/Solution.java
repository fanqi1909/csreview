package org.jace.cs.review.lc.contest.c162.p1255;

public class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] frequency = new int[score.length];
        for(char letter :letters) {
            frequency[letter - 'a']++;
        }

        int[][] wordMap = new int[words.length][26];
        int index = 0;
        for(String word : words){
            for(int i = 0 ; i < word.length(); i ++) {
                wordMap[index][word.charAt(i) - 'a'] ++;
            }
            index++;
        }

        return maxScore(0,  wordMap, frequency, score);
    }

    private int maxScore(int index, int[][] wordMap, int[] frequency, int[] score) {
        if(index == wordMap.length) {
            return 0;
        }
        //fill current words
        int[] currentWord = wordMap[index];

        boolean valid = canFill(currentWord, frequency);
        int useCurrentWord = 0;
        if(valid) {
            int myScore = fill(currentWord, frequency, score);
            int nextScore = maxScore(index + 1, wordMap, frequency, score);
            unfill(currentWord, frequency);
            useCurrentWord = myScore + nextScore;
        }

        int notUseCurrentWord = maxScore(index + 1, wordMap, frequency, score);

        return Math.max(notUseCurrentWord, useCurrentWord);
    }

    private void unfill(int[] currentWord, int[] frequency) {
        for(int i = 0; i < currentWord.length; i++) {
            frequency[i] = frequency[i] + currentWord[i];
        }
    }

    private int fill(int[] currentWord, int[] frequency, int[] score) {
        int ws = 0;
        for(int i = 0; i < currentWord.length; i++) {
            if(currentWord[i] != 0) {
                frequency[i] = frequency[i] - currentWord[i];
                ws += score[i] * currentWord[i];
            }
        }
        return ws;
    }

    private boolean canFill(int[] currentWord, int[] frequency) {
        for(int i = 0 ; i < currentWord.length; i++) {
            if(currentWord[i] > frequency[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] scores = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(solution.maxScoreWords(words, letters, scores));

        words = new String[]{"xxxz","ax","bx","cx"};
        letters = new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        scores = new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

        System.out.println(solution.maxScoreWords(words, letters, scores));
    }
}

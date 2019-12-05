package ps.google;

/**
 * Find the positions of bulls first. Then check the count of cows.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] chars = new int[10];

        int bulls = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                chars[secret.charAt(i) - '0']++; // cow candidate
            }
        }

        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                int index = guess.charAt(i) - '0';
                if (chars[index] > 0) {
                    cows++;
                    chars[index]--;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println(bullsAndCows.getHint("1807", "7810"));
        System.out.println(bullsAndCows.getHint("1123", "0111"));

    }
}

package ps.google.array.string;


public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        return formatting(S.replace("-","").toUpperCase(), K);
    }

    private String formatting(String s, int K) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >=0; i--) {
            result.append(s.charAt(i));
            count ++;
            if(count % K == 0 && i != 0) {
                result.append("-");
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting solution = new LicenseKeyFormatting();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-W", 4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));
    }
}

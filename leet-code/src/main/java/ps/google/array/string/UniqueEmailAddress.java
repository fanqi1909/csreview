package ps.google.array.string;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email: emails) {
            String[] parts = email.split("@");
            String beforePlus = parts[0].split(Pattern.quote("+"))[0];
            String sanitizedLocalName = beforePlus.replaceAll(Pattern.quote("."), "");
            String sanitizedEmail = sanitizedLocalName + "@" + parts[1];
            uniqueEmails.add(sanitizedEmail);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddress solution = new UniqueEmailAddress();

        System.out.println( 2 + " === " + solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}

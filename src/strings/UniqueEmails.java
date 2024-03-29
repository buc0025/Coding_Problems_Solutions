package strings;
/*
https://leetcode.com/problems/unique-email-addresses/
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to
the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the
same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be
filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 */

public class UniqueEmails {

    // 9/22/2022 solution
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            int at = email.indexOf("@");
            int plus = email.indexOf("+");

            StringBuilder str = new StringBuilder();

            String domain = email.substring(at);

            if (plus != -1) {
                for (int i = 0; i < plus; i++) {
                    if (Character.isLetter(email.charAt(i))) {
                        str.append(email.charAt(i));
                    }
                }
            } else {
                for (int i = 0; i < at; i++) {
                    if (Character.isLetter(email.charAt(i))) {
                        str.append(email.charAt(i));
                    }
                }
            }

            str.append(domain);
            set.add(str.toString());
        }

        return set.size();
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            set.add(uniqueEmail(email));
        }

        return set.size();
    }

    public String uniqueEmail(String email) {
        int at = email.indexOf('@');
        String front = email.substring(0, at);
        String com = email.substring(at);
        front = front.replace(".", "");

        String result = "";

        for (int i = 0; i < front.length(); i++) {
            if (front.charAt(i) == '+') {
                break;
            } else {
                result += front.charAt(i);
            }
        }

        return result + com;
    }
}

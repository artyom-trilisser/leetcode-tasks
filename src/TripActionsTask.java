import java.util.HashSet;
import java.util.List;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign.
 * Besides lowercase letters, the email may contain one or more '.' or '+'. For example, in "alice@epam.com",
 * "alice" is the local name, and "epam.com" is the domain name. If you add periods '.' between some characters
 * in the local name part of an email address, mail sent there will be forwarded to the same address without dots in
 * the local name. Note that this rule does not apply to domain names. For example, "alice.z@epam.com"
 * and "alicez@epam.com" forward to the same email address. If you add a plus '+' in the local name,
 * everything after the first plus sign will be ignored. This allows certain emails to be filtered.
 * Note that this rule does not apply to domain names. For example, "m.y+name@email.com" will be
 * forwarded to "my@email.com". It is possible to use both of these rules at the same time. 
 * Given an array of strings emails where we send one email to each emails[i],
 * return the number of different addresses that actually receive mails. 
 * Example 1:
 * Input: emails = ["test.email+alex@epam.com","test.e.mail+bob.cathy@epam.com","testemail+david@epa.m.com"]
 * Output: 2
 * Explanation: "testemail@epam.com" and "testemail@epa.m.com" actually receive mails. Example 2:
 * Input: emails = ["a@epam.com","b@epam.com","c@epam.com"]
 * Output: 3
 *
 */
public class TripActionsTask {
    public int countOriginalEmails(List<String> emails) {
        var originalEmails = new HashSet<String>();

        for (String email: emails) {
            String[] splittedEmail = email.split("@");
            String localName = splittedEmail[0].split("\\+")[0].replace("\\.", "");
            String newEmail = localName + splittedEmail[1];
            originalEmails.add(newEmail);
        }

        return originalEmails.size();
    }
}

import java.util.HashSet;
import java.util.Set;

public class StringTask {
    public boolean hasNoDuplicatesInString(String str) {
        checkStringIsNull(str);
        checkStringIsEmpty(str);

        Set<Character> allCharsInStr = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            allCharsInStr.add(str.charAt(i));
            if (allCharsInStr.size() != i + 1) {
                return false;
            }
        }
        return true;
    }

    private void checkStringIsNull(String str) {
        if (str == null) {
            throw new NullPointerException("Null input.");
        }
    }

    private void checkStringIsEmpty(String str) {
        if (str.equals("")) {
            throw new NullPointerException("Empty input.");
        }
    }
}

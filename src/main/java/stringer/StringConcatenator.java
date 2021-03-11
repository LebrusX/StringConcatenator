package stringer;

public class StringConcatenator {

    private StringConcatenator() {}

    public static String concat(String s1, String s2, int n) {
        if (s2 == null)
            return s1;
        StringBuilder result = new StringBuilder(s1);
        while (n > 0) {
            result.append(s2);
            n--;
        }
        return result.toString();
    }
}

package labs.medvid;

/**
 * Provides a simple method to insert substring after k-th position.
 */
public class StringInserter {

    public static String insertAfter(String text, int k, String insert) {
        if (k < 0 || k > text.length()) return text;
        return text.substring(0, k) + insert + text.substring(k);
    }
}

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int i = partition(arr, start, end);
        quickSort(arr, start, i);
        quickSort(arr, i, end);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
        T pivot = arr[(start + end) / 2];
        int i = start - 1;
        int j = end;
        while (true) {
            do {
                i++;
            } while (arr[i].compareTo(pivot) < 0);
            do {
                j--;
            } while (arr[j].compareTo(pivot) > 0);

            if (i >= j) {
                break;
            } else {
                swap(arr, i, j);
            }
        }
        return i;
    }

    public static String countSort(String s) {
        var counts = new int[26];
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') {
                throw new InvalidParameterException("String must only contain lowercase letters.");
            }
            counts[c - 'a']++;
        }

        var sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            String c = String.valueOf((char) ('a' + i));
            sb.append(c.repeat(counts[i]));
        }
        return sb.toString();
    }

    public static List<Integer> search(String s, String pattern) {
        if (s.contains("$") || pattern.contains("$")) {
            throw new InvalidParameterException("String and pattern must not contain \"$\".");
        }

        int[] z = generateZ(pattern + "$" + s);
        var list = new ArrayList<Integer>();
        for (int i = 0; i < z.length; i++) {
            if (z[i] == pattern.length()) {
                list.add(i - pattern.length() - 1);
            }
        }
        return list;
    }

    private static int[] generateZ(String s) {
        var z = new int[s.length()];

        int l = 0;
        int r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i > r) {
                l = r = i;
                while (r < s.length() && s.charAt(r - l) == s.charAt(r)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < s.length() && s.charAt(r - l) == s.charAt(r)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }

        return z;
    }
}

package ua.com.alevel;

public final class StringReverseUtil {

    private StringReverseUtil() {
    }

    public static String reverse(String src) {
        String rez = "";
        for (int i = src.length() - 1; i >= 0; i--) {
            rez += src.charAt(i);
        }
        return rez;
    }

    public static String reverseOnlyWords(String src) {
        String[] ss = src.split(" ");
        String rez = "";
        int cnt = 0;
        for (int i = 0; i < ss.length; i++) {
            if (!ss[i].equals("")) cnt++;
        }

        if (cnt == 0) {
            return src;
        }

        String[] chopped = new String[cnt];
        int j = -1;
        for (int i = 0; i < ss.length; i++) {
            if (!ss[i].equals("")) {
                j++;
                chopped[j] = reverse(ss[i]);
            }
        }

        int i = 0;
        j = -1;
        while (i < src.length()) {
            if (src.charAt(i) == ' ') {
                rez += ' ';
                i++;
            } else {
                j++;
                rez += chopped[j];
                i += chopped[j].length();
            }
        }
        return rez;
    }

    public static String reverse(String src, String dest, boolean opt) {
        if (opt) {
            return src.replaceAll(dest, reverse(dest));
        } else {
            return src.replaceAll(dest, reverseOnlyWords(dest));
        }
    }

    public static String reverse(String src, int firstIndex, int lastIndex, boolean opt) {

        if (firstIndex > lastIndex || firstIndex < 0 || lastIndex >= src.length()) {
            return "Incorrect bounds!!!";
        }

        String rez;
        if (opt) {
            rez = reverse(src.substring(firstIndex, lastIndex + 1));
        } else {
            rez = reverseOnlyWords(src.substring(firstIndex, lastIndex + 1));
        }
        return src.substring(0, firstIndex) + rez + src.substring(lastIndex + 1, src.length());
    }

    public static String retMessage(String a) {
        return '\'' + a + '\'' + " doesn't exist in this string!!!";
    }

    public static String reverse(String src, char firstChar, char lastChar, boolean opt) {
        String rez;
        int firstIndex = src.indexOf(firstChar);
        if (firstIndex == -1) {
            return retMessage(firstChar + "");
        }
        int lastIndex = src.indexOf(lastChar, firstIndex + 1);
        if (lastIndex == -1) {
            return retMessage(lastChar + "");
        }

        if (opt) {
            rez = reverse(src.substring(firstIndex, lastIndex + 1));
        } else {
            rez = reverseOnlyWords(src.substring(firstIndex, lastIndex + 1));
        }
        return src.substring(0, firstIndex) + rez + src.substring(lastIndex + 1, src.length());
    }

    public static String reverse(String src, String firstString, String lastString, boolean opt) {
        String rez;
        int firstIndex = src.indexOf(firstString);
        if (firstIndex == -1) {
            return retMessage(firstString);
        }
        int lastIndex = src.indexOf(lastString, firstIndex + firstString.length());
        if (lastIndex == -1) {
            return retMessage(lastString);
        }

        if (opt) {
            rez = reverse(src.substring(firstIndex, lastIndex + lastString.length()));
        } else {
            rez = reverseOnlyWords(src.substring(firstIndex, lastIndex + lastString.length()));
        }
        return src.substring(0, firstIndex) + rez + src.substring(lastIndex + lastString.length(), src.length());
    }

}

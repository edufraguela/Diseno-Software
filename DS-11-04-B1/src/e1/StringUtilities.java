package e1;

public class StringUtilities {
    public static boolean isValidMix(String a, String b, String c) {

        int i, posA = 0, posB = 0;
        if ((a.length() + b.length()) == c.length()) {
            if ((c.charAt(0) != a.charAt(0)) && (c.charAt(0) != b.charAt(0))) {
                return false;
            }
            for (i = 0; i < c.length(); i++) {
                if (posA < a.length()) {
                    if (c.charAt(i) == a.charAt(posA)) {
                        posA += 1;
                        continue;
                    }
                }
                if (posB < b.length()) {
                    if (c.charAt(i) == b.charAt(posB)) {
                        posB += 1;
                    }
                }
            }
            return ((posA + posB) == c.length());
        }
        return false;
    }


    public static String generateRandomValidMix(String a, String b) {
        int largo = (a.length() + b.length());
        int aux, i = 0, auxA = 0, auxB = 0;
        StringBuilder cSB = new StringBuilder();
        StringBuilder aSB = new StringBuilder(a);
        StringBuilder bSB = new StringBuilder(b);

        while (i < largo) {
            aux = (int) (Math.random() * 2);
            if (aux == 0) {
                if (auxA < a.length()) {
                    cSB.append(aSB.charAt(0));
                    aSB.deleteCharAt(0);
                    auxA += 1;
                    continue;
                }
            }
            if (aux == 1) {
                if (auxB < b.length()) {
                    cSB.append(bSB.charAt(0));
                    bSB.deleteCharAt(0);
                    auxB += 1;
                }
            }
            if (!((auxA < a.length()) || (auxB < b.length()))) {
                i++;
            }
        }
        return cSB.toString();
    }
}



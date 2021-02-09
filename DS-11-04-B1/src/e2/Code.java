package e2;

public class Code {
    public static boolean isKeypadValid ( char [][] keypad ) {
        int i, j, cnt = 0;
        char[] stringValid = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C',
                        'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        if(keypad != null) {
            if (keypad.length > 1) {
                if (keypad[0][0] == stringValid[0]) {

                    for (i = 0; i < keypad.length; i++) {
                        if(keypad[i] == null) return false;
                        for (j = 0; j < keypad[0].length; j++) {

                            if(keypad[0].length == 1){
                                j = 0;
                                if(keypad[i][j] == stringValid[i]){
                                    cnt += 1;
                                    continue;
                                }
                            }

                            if (keypad[0][1] == stringValid[1]) { //Por filas
                                if(keypad[i][j] == stringValid[j + (i* keypad[0].length)]){
                                    cnt += 1;
                                }
                            } else if (keypad[1][0] == stringValid[1]) { //Por columnas
                                if(keypad[i][j] == stringValid[i + (j * keypad.length)]){
                                    cnt += 1;
                                }
                            }

                        }
                    }

                }
                return cnt == (keypad.length * keypad[0].length);
            } else return keypad.length == 1;
        } else return false;
    }
    public static boolean areMovementsValid ( String [] movements ) {
        int i, j, cnt = 0, cntLetras = 0;

        if(movements == null){
            return false;
        }
        for(i = 0; i < movements.length; i++) {
            if(movements[i] == null){
                return false;
            }
            for(j = 0; j < movements[i].length(); j++){
                char letra = movements[i].charAt(j);
                if ((letra == 'U') || (letra == 'D') || (letra == 'L') || (letra == 'R')) {
                    cnt += 1;
                }
                cntLetras += 1;
            }
        }
        return cnt == cntLetras;
    }
    public static String obtainCode ( char [][] keypad , String [] movements ) {
        int i, j, x = 0, y = 0;
        StringBuilder clave = new StringBuilder();

        if (!isKeypadValid(keypad) && !areMovementsValid(movements)) {
            throw new IllegalArgumentException("El teclado o los movimientos están mal.");
        }

        for (i = 0; i < movements.length; i++) {
            for (j = 0; j < movements[i].length(); j++) {

                if (movements[i].charAt(j) == 'U') {
                    if (x - 1 >= 0) {
                        x -= 1;
                        continue;
                    }
                }

                if (movements[i].charAt(j) == 'D') {
                    if (x + 1 < keypad.length) {
                        x += 1;
                        continue;
                    }
                }

                if (movements[i].charAt(j) == 'L') {
                    if (y - 1 >= 0) {
                        y -= 1;
                        continue;
                    }
                }

                if (movements[i].charAt(j) == 'R') {
                    if (y + 1 < keypad[0].length) {
                        y += 1;
                    }
                }

            }
            clave.append(keypad[x][y]);
        }

        return clave.toString();
    }
}

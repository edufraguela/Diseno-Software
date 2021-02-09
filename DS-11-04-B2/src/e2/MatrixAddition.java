package e2;

import java.util.ArrayList;

public class MatrixAddition {
    public static Matrix Suma(Matrix m1, Matrix m2) {
        if(m1.Data.length == m2.Data.length && m1.Data[0].length == m2.Data[0].length) {
            int i, j, k = 0;
            Matrix m = new Matrix(m1.Data.length, m1.Data[0].length);
            //Creamos ArrayLists donde almacenar los valores de las matrices para facilitar la suma
            ArrayList<Integer> m1L = new ArrayList<>();
            ArrayList<Integer> m2L = new ArrayList<>();
            ArrayList<Integer> mL = new ArrayList<>();

            for(int elemento : m1) {
                m1L.add(elemento);
            }
            for(int elemento : m2) {
                m2L.add(elemento);
            }
            for(int elemento : m) {
                mL.add(m1L.get(k) + m2L.get(k));
                k++;
            }

            for(i = 0; i < m.Data.length; i++) {
                for(j = 0; j < m.Data[0].length; j++) {
                    m.Data[i][j] = mL.get(m1.Data[0].length*i + j);
                }
            }

            return m;
        } else throw new ArithmeticException("Las matrices no tienen las mismas dimensiones");
    }
}

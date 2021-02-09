package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAdditionTest {

    @Test
    void suma() {
        int[][] s1 = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9, 12}
        };
        int[][] s2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] notSameSize = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        int[][] c = {
                {2, 6, 10, 14},
                {7, 11, 15, 19},
                {12, 16, 20, 24}
        };
        int[][] d = {
                {2, 9, 16, 12},
                {8, 15, 11, 18},
                {14, 10, 17, 24}
        };
        int[][] e = {
                {2, 4, 6, 8},
                {10, 12, 14, 16},
                {18, 20, 22, 24}
        };
        int[][] f = {
                {2, 7, 12, 6},
                {11, 16, 10, 15},
                {20, 14, 19, 24}
        };

        Matrix m1 = new Matrix(s1);
        Matrix m2 = new Matrix(s2);
        Matrix mRR = new Matrix(c);
        Matrix mRC = new Matrix(d);
        Matrix mCR = new Matrix(e);
        Matrix mCC = new Matrix(f);

        m1.iter = true;
        m2.iter = true;
        assertEquals(Arrays.deepToString(mRR.getCopyArray()), Arrays.deepToString(MatrixAddition.Suma(m1, m2).getCopyArray()));
        m1.iter = true;
        m2.iter = false;
        assertEquals(Arrays.deepToString(mRC.getCopyArray()), Arrays.deepToString(MatrixAddition.Suma(m1, m2).getCopyArray()));
        m1.iter = false;
        m2.iter = true;
        assertEquals(Arrays.deepToString(mCR.getCopyArray()), Arrays.deepToString(MatrixAddition.Suma(m1, m2).getCopyArray()));
        m1.iter = false;
        m2.iter = false;
        assertEquals(Arrays.deepToString(mCC.getCopyArray()), Arrays.deepToString(MatrixAddition.Suma(m1, m2).getCopyArray()));

        Matrix m = new Matrix(notSameSize);
        assertThrows(ArithmeticException.class, () -> MatrixAddition.Suma(m1, m));
    }
}
package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    int[][] a = {
            {1, 4, 7, 10},
            {2, 5, 8, 11},
            {3, 6, 9, 12}
    };

    @Test
    void isRectangular() {
        int[][] b = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9}
        };
        assertThrows(IllegalArgumentException.class, () -> new Matrix(b));
    }

    @Test
    void isIllegalPos() {
        Matrix m1 = new Matrix(2, 4);
        assertTrue(m1.isIllegalPos(3, 3));
    }

    @Test
    void iterator() {
    }

    @Test
    void setCell() {
        Matrix m1 = new Matrix(2, 4);
        assertThrows(IllegalArgumentException.class, () -> m1.setCell(2, 4, 5));

        Matrix m2 = new Matrix(a);
        assertThrows(IllegalArgumentException.class, () -> m2.setCell(2, 4, 5));
    }

    @Test
    void getNRow() {
        Matrix m1 = new Matrix(2, 4);
        assertEquals(2, m1.getNRow());

        Matrix m2 = new Matrix(a);
        assertEquals(3, m2.getNRow());
    }

    @Test
    void getNColumn() {
        Matrix m1 = new Matrix(2, 4);
        assertEquals(4, m1.getNColumn());

        Matrix m2 = new Matrix(a);
        assertEquals(4, m2.getNColumn());
    }

    @Test
    void getCell() {
        Matrix m1 = new Matrix(2, 4);
        m1.setCell(1, 2, 2);
        assertEquals(2, m1.getCell(1, 2));
        assertThrows(IllegalArgumentException.class, () -> m1.getCell(2, 4));

        Matrix m2 = new Matrix(a);
        m2.setCell(2, 3, 20);
        assertEquals(20, m2.getCell(2, 3));
        assertThrows(IllegalArgumentException.class, () -> m2.getCell(3, 4));
    }

    @Test
    void getCopyArray() {
        Matrix m1 = new Matrix(2, 4);
        m1.setCell(1, 2, 2);
        assertEquals("[[0, 0, 0, 0], [0, 0, 2, 0]]", Arrays.deepToString(m1.getCopyArray()));

        Matrix m2 = new Matrix(a);
        m2.setCell(2, 3, 20);
        assertEquals("[[1, 4, 7, 10], [2, 5, 8, 11], [3, 6, 9, 20]]", Arrays.deepToString(m2.getCopyArray()));
    }

    @Test
    void getRow() {
        Matrix m1 = new Matrix(2, 4);
        assertEquals("[0, 0, 0, 0]", Arrays.toString(m1.getRow(0)));
        assertThrows(IllegalArgumentException.class, () -> m1.getRow(2));

        Matrix m2 = new Matrix(a);
        m2.setCell(2, 3, 20);
        assertEquals("[3, 6, 9, 20]", Arrays.toString(m2.getRow(2)));
    }

    @Test
    void getColumn() {
        Matrix m1 = new Matrix(2, 4);
        assertEquals("[0, 0]", Arrays.toString(m1.getColumn(3)));
        assertThrows(IllegalArgumentException.class, () -> m1.getColumn(4));

        Matrix m2 = new Matrix(a);
        assertEquals("[1, 2, 3]", Arrays.toString(m2.getColumn(0)));
        assertThrows(IllegalArgumentException.class, () -> m2.getColumn(4));
    }

    @Test
    void getArray() {
        Matrix m1 = new Matrix(2, 4);
        m1.setCell(1, 2, 2);
        assertEquals("[0, 0, 0, 0]\n[0, 0, 2, 0]", m1.getArray());

        Matrix m2 = new Matrix(a);
        m2.setCell(2, 3, 20);
        assertEquals("[1, 4, 7, 10]\n[2, 5, 8, 11]\n[3, 6, 9, 20]", m2.getArray());
    }
}
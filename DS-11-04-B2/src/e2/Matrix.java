package e2;

import java.util.Arrays;
import java.util.Iterator;

public class Matrix implements Iterable<Integer> {
    public int Row;
    public int Column;
    public int[][] Data;
    public boolean iter;

    /* Constructores */
    //Primer constructor: Pasamos el número de filas y columnas e inicializamos a 0
    public Matrix(int row, int column) {
        this.Row = row;
        this.Column = column;
        this.Data = new int[this.Row][this.Column];
    }

    //Segundo constructor: Pasamos un Array y lo copiamos en el nuestro
    public Matrix(int[][] a) {
        if(a == null)
            throw new IllegalArgumentException("La matriz no puede ser nula");
        if (!isRectangular(a))
            throw new IllegalArgumentException("La matriz no es rectangular");

        int i, j;
        this.Row = a.length;
        this.Column = a[0].length;
        this.Data = new int[this.Row][this.Column];

        for (i = 0; i < Row; i++) {
            for(j = 0; j < Column; j++) {
                Data[i][j] = a[i][j];
            }
        }
    }

    /* Métodos booleanos */
    public boolean isRectangular(int[][] a) {
        int i, j, aux = a[0].length;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < aux; j++) {
                if (a[i].length != aux) return false;
            }
        }
        return true;
    }

    public boolean isIllegalPos(int row, int column) {
        return this.Row <= row || this.Column <= column;
    }

    /* Métodos iteradores */
    public Iterator<Integer> iterator() {
        if (iter) return new RowColumnIterator(Data);    //En caso de que iter sea true, usamos el iterador RowColumn
        else return new ColumnRowIterator(Data);        //En caso contrario usamos el iterador ColumnRow
    }

    /* Setters */
    //Cambiar el valor de una celda
    public void setCell(int row, int column, int valor) {
        if (isIllegalPos(row, column)) {
            throw new IllegalArgumentException("Intentando acceder a una posición ilegal del array");
        }
        this.Data[row][column] = valor;
    }

    /* Getters*/
    //Retornar el número de filas
    public int getNRow() {
        return this.Row;
    }

    //Retornar el número de columnas
    public int getNColumn() {
        return this.Column;
    }

    //Retornar el valor de una celda
    public int getCell(int row, int column) {
        if (isIllegalPos(row, column)) {
            throw new IllegalArgumentException("Intentando acceder a una posición ilegal del array");
        }
        return this.Data[row][column];
    }

    //Retornar una copia del Array bidimensional
    public int[][] getCopyArray() {
        int i, j;
        int[][] a = new int[this.Row][this.Column];

        for (i = 0; i < this.Row; i++) {
            for (j = 0; j < this.Column; j++) {
                a[i][j] = this.Data[i][j];
            }
        }

        return a;
    }

    //Retornar una copia de una fila unidimensional
    public int[] getRow(int row) {
        if (row >= this.Row)
            throw new IllegalArgumentException("Intentando acceder a una fila ilegal");
        return Arrays.copyOf(this.Data[row], Column);
    }

    //Retornar una copia de una columna unidimensional
    public int[] getColumn(int column) {
        int i;
        int[] a = new int[this.Row];
        if (column >= this.Column)
            throw new IllegalArgumentException("Intentando acceder a una columna ilegal");
        for(i = 0; i < this.Row; i++) {
            a[i] = this.Data[i][column];
        }
        return Arrays.copyOf(a, Data.length);
    }

    //Retornar un versión del Array en formato String
    public String getArray() {
        int i;
        StringBuilder str = new StringBuilder();

        for (i = 0; i < Data.length; i++) {
            str.append(Arrays.toString(getRow(i)));
            if (i != Data.length - 1)
                str.append("\n");
        }
        return str.toString();
    }
}

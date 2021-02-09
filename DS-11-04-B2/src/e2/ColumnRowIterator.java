package e2;

import java.util.Iterator;

public class ColumnRowIterator implements Iterator<Integer> {
    int i, j;
    int[][] m;

    public ColumnRowIterator(int[][] a) {
        this.m = a;
    }

    @Override
    public boolean hasNext() {
        return !(i == this.m.length && j == this.m[0].length-1);

    }

    @Override
    public Integer next() {
        if(!hasNext())
            throw new IllegalArgumentException("Has llegado al último elemento");
        if(i < m.length)
            return m[i++][j];
        else
            i = 0;
            return m[i++][++j];
    }

    @Override
    public void remove() {
        throw new IllegalArgumentException("Método inválido");
    }
}

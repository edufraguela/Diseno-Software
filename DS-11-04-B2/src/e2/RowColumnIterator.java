package e2;

import java.util.Iterator;

public class RowColumnIterator implements Iterator<Integer> {
    int i, j;
    int[][] m;

    public RowColumnIterator(int[][] a) {
        this.m = a;
    }

    @Override
    public boolean hasNext() {
        return !(i == this.m.length-1 && j == this.m[0].length);
    }

    @Override
    public Integer next() {
        if(!hasNext())
            throw new IllegalArgumentException("Has llegado al último elemento");
        if(j < this.m[i].length)
            return m[i][j++];
        else
            j = 0;
            return m[++i][j++];
    }

    @Override
    public void remove() {
        throw new IllegalArgumentException("Método inválido");
    }
}

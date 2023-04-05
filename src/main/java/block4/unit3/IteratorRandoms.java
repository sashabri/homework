package block4.unit3;

import java.util.Iterator;

public class IteratorRandoms implements Iterator<Integer> {
    private final Randoms randoms;

    public IteratorRandoms(Randoms randoms) {
        this.randoms = randoms;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return (randoms.random.nextInt(randoms.max - randoms.min + 1)) + randoms.min;
    }
}

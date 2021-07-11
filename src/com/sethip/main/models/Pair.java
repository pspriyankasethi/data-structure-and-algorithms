package com.sethip.main.models;

import java.util.Objects;

public class Pair<U, V> {
    U i;
    V j;

    public U getI() {
        return i;
    }

    public void setI(U i) {
        this.i = i;
    }

    public V getJ() {
        return j;
    }

    public void setJ(V j) {
        this.j = j;
    }

    public Pair(U i, V j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(i, pair.i) &&
                Objects.equals(j, pair.j);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

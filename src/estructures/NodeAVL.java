package estructures;

import java.util.Objects;

public class NodeAVL<T extends Comparable<T>> extends Node {
    private int height;

    public NodeAVL() {
        height = -1;
    }

    public NodeAVL(T value) {
        super(value);
        height = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeAVL)) return false;
        if (!super.equals(o)) return false;
        NodeAVL<?> nodeAVL = (NodeAVL<?>) o;
        return getHeight() == nodeAVL.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHeight());
    }

    @Override
    public String toString() {
        return "NodeAVL{" +
                super.toString() +
                "height=" + height +
                '}';
    }
}

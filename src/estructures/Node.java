package estructures;


import java.util.Objects;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node() {
        value = null;
        left = null;
        right = null;
    }

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(getValue(), node.getValue()) &&
                Objects.equals(getLeft(), node.getLeft()) &&
                Objects.equals(getRight(), node.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value.toString() +
                '}';
    }
}

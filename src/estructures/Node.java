package estructures;


import java.util.Objects;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> father;
    private Node<T> left;
    private Node<T> right;

    public Node() {
        this(null);
    }

    public Node(T value) {
        this.value = value;
        father = null;
        left = null;
        right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getFather() {
        return father;
    }

    public void setFather(Node<T> father) {
        this.father = father;
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
                Objects.equals(getFather(), node.getFather()) &&
                Objects.equals(getLeft(), node.getLeft()) &&
                Objects.equals(getRight(), node.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getFather(), getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
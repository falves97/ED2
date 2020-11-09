package estructures;

import java.util.Objects;

public class Tree <T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(Node<T> node) {
        if (root == null) {
            setRoot(node);
        }
        else {
            root.insert(node.getValue());
        }
    }

    public Node<T> remove(Node<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(remove(node.getLeft(), value));
        }
        else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(remove(node.getRight(), value));
        }
        else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node<T> n = min(node.getRight());
                n.setLeft(node.getLeft());
                return node.getRight();
            }
        }
        return node;
    }

    public Node<T> min(Node<T> node) {
        if (node.getLeft() != null) {
            return min(node.getLeft());
        }
        return node;
    }

    public Node<T> max(Node<T> node) {
        if (node.getRight() != null) {
            return min(node.getRight());
        }
        return node;
    }

    public void order(Node<T> node) {

        if (node != null) {
            order(node.getLeft());
            System.out.print(node.getValue().toString() + " ");
            order(node.getRight());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(getRoot(), tree.getRoot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoot());
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root.toString() +
                '}';
    }
}

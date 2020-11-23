package estructures;

import java.util.Objects;

public class TreeAVL<T extends Comparable<T>>{
    private NodeAVL<T> root;

    public TreeAVL() {
        root = null;
    }

    public TreeAVL(T value) {
        this.root = new NodeAVL<>(value);
    }

    public NodeAVL<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        root = insert(getRoot(), value);
    }

    public NodeAVL<T> insert(NodeAVL<T> root, T value) {
        if (root != null) {

            if (value.compareTo((T) root.getValue()) < 0) {
                root.setLeft(insert((NodeAVL<T>) root.getLeft(), value));
                if (height((NodeAVL<T>) root.getLeft()) - height((NodeAVL<T>) root.getRight()) == 2) {
                    if (value.compareTo((T) root.getLeft().getValue()) < 0) {
                        root = rightRotation(root);
                    } else {
                        root = doubleRightRotation(root);
                    }
                }
            } else if (value.compareTo((T) root.getValue()) > 0) {
                root.setRight(insert((NodeAVL<T>) root.getRight(), value));
                if (height((NodeAVL<T>) root.getRight()) - height((NodeAVL<T>) root.getLeft()) == 2) {
                    if (value.compareTo((T) root.getRight().getValue()) > 0) {
                        root = leftRotation(root);
                    } else {
                        root = doubleLeftRotation(root);
                    }
                }
            }
            root.setHeight(Math.max(height((NodeAVL<T>) root.getLeft()), height((NodeAVL<T>) root.getRight())) + 1);
        } else {
            root = new NodeAVL<>(value);
        }

        return root;
    }

    public NodeAVL<T> leftRotation(NodeAVL<T> root) {
        NodeAVL<T> aux;

        aux = null;

        if (root != null) {
            aux = (NodeAVL) root.getRight();
            root.setRight(aux.getLeft());
            aux.setLeft(root);
            root.setHeight(Math.max(height((NodeAVL<T>) root.getLeft()), height((NodeAVL<T>) root.getRight())) + 1);
            aux.setHeight(Math.max(height((NodeAVL<T>) root.getLeft()), root.getHeight()) + 1);
        }

        return aux;
    }

    public NodeAVL<T> rightRotation(NodeAVL<T> root) {
        NodeAVL<T> aux;

        aux = null;

        if (root != null) {
            aux = (NodeAVL) root.getLeft();
            root.setLeft(aux.getRight());
            aux.setRight(root);
            root.setHeight(Math.max(height((NodeAVL<T>) root.getLeft()), height((NodeAVL<T>) root.getRight())) + 1);
            aux.setHeight(Math.max(height((NodeAVL<T>) root.getLeft()), root.getHeight()) + 1);
        }

        return aux;
    }

    public NodeAVL<T> doubleLeftRotation(NodeAVL<T> root) {
        root.setRight(rightRotation((NodeAVL<T>) root.getRight()));
        return leftRotation(root);
    }

    public NodeAVL<T> doubleRightRotation(NodeAVL<T> root) {
        root.setLeft(leftRotation((NodeAVL<T>) root.getLeft()));
        return rightRotation(root);
    }

    public int height(NodeAVL<T> root) {
        if (root != null) {
            return Math.max(height((NodeAVL<T>) root.getLeft()), height((NodeAVL<T>) root.getRight())) + 1;
        } else {
            return -1;
        }
    }

    public void order(NodeAVL<T> root) {
        if (root != null) {
            int balance = height((NodeAVL<T>) root);
            order((NodeAVL<T>) root.getLeft());
            System.out.print(root.getValue() + ":" + balance + " ");
            order((NodeAVL<T>) root.getRight());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeAVL)) return false;
        TreeAVL<?> treeAVL = (TreeAVL<?>) o;
        return Objects.equals(getRoot(), treeAVL.getRoot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoot());
    }

    @Override
    public String toString() {
        return "TreeAVL{" +
                "root=" + root +
                '}';
    }
}

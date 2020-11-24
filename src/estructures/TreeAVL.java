package estructures;

import java.util.Objects;

public class TreeAVL<T extends Comparable<T>> extends BinaryTree<T> {
    private Node<T> root;

    public TreeAVL() {
        root = null;
    }

    public TreeAVL(T value) {
        this.root = new NodeAVL<>(value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public NodeAVL<T> leftRotation(NodeAVL<T> root) {
        NodeAVL<T> aux;

        aux = null;

        if (root != null) {
            aux = (NodeAVL) root.getRight();
            root.setRight(aux.getLeft());
            aux.setLeft(root);
            aux.setFather(root.getFather());
            root.setFather(aux);

            if (root.getRight() != null) {
                root.getRight().setFather(root);
            }

            root.setHeight(Math.max(this.height(root.getLeft()), this.height(root.getRight())) + 1);
            aux.setHeight(Math.max(this.height(root.getLeft()), root.getHeight()) + 1);
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
            aux.setFather(root.getFather());
            root.setFather(aux);

            if (root.getLeft() != null) {
                root.getLeft().setFather(root);
            }

            root.setHeight(Math.max(this.height(root.getLeft()), this.height(root.getRight())) + 1);
            aux.setHeight(Math.max(this.height(root.getLeft()), root.getHeight()) + 1);
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

    @Override
    public void insert(T value) {
        root = insert(root, value);
    }

    @Override
    public Node<T> insert(Node<T> root, T value) {
        if (root != null) {

            Node<T> son;

            if (value.compareTo(root.getValue()) < 0) {

                son = insert(root.getLeft(), value);
                root.setLeft(son);

                if (this.height(root.getLeft()) - this.height(root.getRight()) == 2) {
                    if (value.compareTo((T) root.getLeft().getValue()) < 0) {
                        root = rightRotation((NodeAVL<T>) root);
                    } else {
                        root = doubleRightRotation((NodeAVL<T>) root);
                    }
                }
                else {
                    son.setFather(root);
                }
            } else if (value.compareTo((T) root.getValue()) > 0) {

                son = insert(root.getRight(), value);
                root.setRight(son);

                if (this.height(root.getRight()) - this.height(root.getLeft()) == 2) {
                    if (value.compareTo((T) root.getRight().getValue()) > 0) {
                        root = leftRotation((NodeAVL<T>) root);
                    } else {
                        root = doubleLeftRotation((NodeAVL<T>) root);
                    }
                }
                else {
                    son.setFather(root);
                }
            }

            ((NodeAVL<T>) root).setHeight(Math.max(this.height(root.getLeft()), this.height(root.getRight())) + 1);
        } else {
            root = new NodeAVL<>(value);
        }

        order(root);
        System.out.println();
        return root;
    }

    @Override
    public int height(Node<T> root) {
        if (root != null) {
            if (root instanceof NodeAVL) {
                NodeAVL<T> aux = (NodeAVL<T>) root;
                return aux.getHeight();
            }
        }
        return -1;
    }

    @Override
    public void order(Node<T> root) {
        if (root != null) {
            order(root.getLeft());
            System.out.print(((NodeAVL) root) + " ");
            order(root.getRight());
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

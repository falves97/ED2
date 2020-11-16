package estructures;

import java.util.ArrayList;
import java.util.Objects;

public class Tree <T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    public Tree(T value) {
        this.root = new Node<>(value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> search(T value) {
        return search(root, value);
    }

    public Node<T> search(Node<T> node, T vaulue) {
        if(node != null) {
            if (vaulue.compareTo(node.getValue()) < 0) {
                return search(node.getLeft(), vaulue);
            }
            else if (vaulue.compareTo(node.getValue()) > 0) {
                return search(node.getRight(), vaulue);
            }
        }
        return node;
    }

    public void insert(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
        }
        else {
            if (value.compareTo(root.getValue()) < 0) {
                insert(root.getLeft(), value);
            }
            else {
                insert(root.getRight(), value);
            }
        }
    }

    public Node<T> remove(T value) {
        Node<T> father;
        Node<T> current;
        boolean finded;

        father = null;
        current = root;
        finded = false;

        while (current != null && !finded) {
            if (value.compareTo(current.getValue()) != 0){
                father = current;
                if (value.compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                }
                else if (value.compareTo(current.getValue()) > 0) {
                    current = current.getRight();
                }
            }
            else {
                finded = true;
            }
        }

        if (finded) {
            if (father == null) {
                root = null;
            }
            else {
                Node<T> aux;

                if (current.getLeft() == null) {
                    aux = current.getRight();
                }
                else if (current.getRight() == null) {
                    aux = current.getLeft();
                }
                else {
                    aux = min(current.getRight());
                    aux.setLeft(current.getLeft());
                }

                if (father.getLeft() == current) {
                    father.setLeft(aux);
                }
                else {
                    father.setRight(aux);
                }
            }
        }

        return current;
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

    public void order() {
        order(root);
    }

    public void order(Node<T> root) {
        if (root != null) {
            order(root.getLeft());
            System.out.print(root.getValue() + " ");
            order(root.getRight());
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

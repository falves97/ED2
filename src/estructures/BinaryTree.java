package estructures;

import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T value) {
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

    public void insert(T value) {
        if (root != null) {
            insert(root, value);
        }
        else {
            root = new Node<>(value);
        }
    }

    public Node<T> insert(Node<T> root, T value) {
        if (root != null) {
            Node<T> son;

            if (value.compareTo(root.getValue()) < 0) {
                son = insert(root.getLeft(), value);
                root.setLeft(son);
            }
            else {
                son = insert(root.getRight(), value);
                root.setRight(son);
            }

            son.setFather(root);
        }
        else {
            root = new Node<>(value);
        }
        return root;
    }

    public Node<T> remove(T value) {
        if (root != null) {
            root = remove(root, value);
        }
        return root;
    }

    public Node<T> remove(Node<T> root, T value) {
        if (root != null) {
            if (value.compareTo(root.getValue()) < 0) {
                root.setLeft(remove(root.getLeft(), value));
            }
            else if (value.compareTo(root.getValue()) > 0) {
                root.setRight(remove(root.getRight(), value));
            }
            else {
                Node<T> son;

                if (root.getLeft() == null && root.getRight() == null) {
                    return null;
                }
                else if (root.getLeft() == null) {
                    son = root.getRight();
                }
                else if(root.getRight() == null) {
                    son = root.getLeft();
                }
                else {
                    son = min(root.getRight());
                    son.setLeft(root.getLeft());
                    root.getLeft().setFather(son);
                    son = root.getRight();
                }
                son.setFather(root.getFather());

                return son;
            }
        }

        return  root;
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

    public boolean isLeft(Node<T> node) {
        if (node != null) {
            Node<T> father = node.getFather();
            if (father != null) {
                if (father.getLeft() == node) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isRight(Node<T> node) {
        if (node != null) {
            Node<T> father = node.getFather();
            if (father != null) {
                if (father.getRight() == node) {
                    return true;
                }
            }
        }
        return false;
    }

    public int height(Node<T> root) {
        if (root != null) {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        }
        return -1;
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
        if (!(o instanceof BinaryTree)) return false;
        BinaryTree<?> binaryTree = (BinaryTree<?>) o;
        return Objects.equals(getRoot(), binaryTree.getRoot());
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

package test;

import java.security.SecureRandom;
import java.util.Scanner;

import estructures.Node;
import estructures.Tree;
import util.Sort;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Node<Integer> node;
        SecureRandom secureRandom = new SecureRandom();
        Scanner input = new Scanner(System.in);
        int j;
        int[] values = {88, 85, 21, 79, 63, 65, 22, 80, 25, 48};


        for (int i = 0; i < 10; i++) {
            node = new Node<>(values[i]);
            tree.insert(node);
        }


        System.out.println();
        tree.order(tree.getRoot());
        System.out.println();

        System.out.println("Digite um valor a ser achado: ");
        Integer value = input.nextInt();

        node = tree.search(tree.getRoot(), value);
        System.out.println("achado: " + node);
    }
}

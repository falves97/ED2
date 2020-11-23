package test;

import estructures.BinaryTree;
import estructures.Node;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> integerTree = new BinaryTree<>();
        int[] values = {95, 30, 25, 98, 76, 99, 37, 46, 58, 62};
        SecureRandom random = new SecureRandom();
        Scanner input = new Scanner(System.in);
        int value;

        for (int i = 0; i < 10; i++) {
            integerTree.insert(values[i]);
        }
        integerTree.order(integerTree.getRoot());
        System.out.println();
        Node<Integer> root = integerTree.remove(99);
        integerTree.order(integerTree.getRoot());
    }
}

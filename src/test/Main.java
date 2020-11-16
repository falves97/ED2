package test;

import estructures.List;
import estructures.Node;
import estructures.Tree;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> integerTree = new Tree<>();
        SecureRandom random = new SecureRandom();
        Scanner input = new Scanner(System.in);
        int value;

        for (int i = 0; i < 10; i++) {
            value = random.nextInt(100);
            System.out.print(value + " ");
            integerTree.insert(integerTree.getRoot(), value);
        }

        System.out.println();
        integerTree.order();

        System.out.println();
        System.out.print("Digite valor a ser removido: ");
        value = input.nextInt();
        Node<Integer> node = integerTree.remove(value);

        integerTree.order();
        System.out.println("Valor removido: " + node);
    }
}

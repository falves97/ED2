package test;

import estructures.List;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new List<>();
        List<Integer> integerList1 = new List<>();

        for (int i = 0; i < 10; i++) {
            integerList.insertAtFront(i);
            integerList1.insertAtBack(i);
        }

        System.out.println("===================");
        integerList.print();
        System.out.println();
        integerList1.print();

        while (!integerList.isEmpity()) {
            integerList.removeFromBack();
            integerList.print();
            System.out.println("--------------");
        }

        while (!integerList1.isEmpity()) {
            integerList1.removeFromFront();
            integerList1.print();
            System.out.println("--------------");
        }
    }
}

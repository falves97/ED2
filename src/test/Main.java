package test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import util.Sort;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            list.add(secureRandom.nextInt(100));
        }

        System.out.println(list);

        Sort.select(list, (x, y) -> x.compareTo(y));

        System.out.println(list);
    }
}

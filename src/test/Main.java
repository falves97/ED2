package test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import util.Sort;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            list.add(secureRandom.nextInt(100));
        }

        System.out.println(list);

        List<Integer> b = new ArrayList<>(list);
        b = b.stream().map(m -> m = 0).collect(Collectors.toList());
        Sort.merge(list, b, 0, list.size() - 1);

        System.out.println(list);
    }
}

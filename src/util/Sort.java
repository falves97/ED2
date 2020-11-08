package util;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public static <T extends Comparable<T>> void insert(List<T> list) {
        T key;                      //variável que será comparada com as demais

        for (int i = 1; i < list.size(); i++) {
            //key recebe o valor de i e assim será comparada com todas as demais da lista
            key = list.get(i);
            //j ecebe o índice do elemento antecessor a key para iniciar as comparações
            int j = i - 1;

            /*
            o laço compara se j chegou ao início da lista e se o elemento de índece j é
            maior que o valor de key, se for, ele "arrasta" esse elemento para "frente",
            e assim repete com os demais até chegar ao inicio da lista,
            deixando todos os valores a esquerda de key ordenados, assim coloca
            key no índice correto.
            */
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            //coloca key no índice correto
            list.set(j + 1, key);
        }
    }

    //métedo insert que utiliza um Comparator
    public static <T> void insert(List<T> list, Comparator<T> comparator) {
        T key;

        for (int i = 1; i < list.size(); i++) {
            key = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }
    }

    public static <T extends Comparable<T>> void select(List<T> list) {
        T aux;
        int key;

        /*
        laço percorre do início ao penúltimo elemento da lista para comparara com
        os elementos à direita de i
         */

        for (int i = 0; i < list.size() - 1; i++) {
            key = i;

            /*
            após key receber i, o segundo laço compara o elemento de índice i com
            todos à sua direita, até achar o menor elemento comparado com ele
             */
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(key)) < 0) {
                    key = j;
                }
            }

            /*
            após achar o índice do menor elemento comparado com o elemento de índice i,
            ele é colocado na posição i, fazendo assim que todos os elementos à esquerda de
            i fiquem sempre ordenados
             */
            aux = list.get(key);
            list.set(key, list.get(i));
            list.set(i, aux);
        }
    }

    //métedo select que utiliza um Comparator
    public static <T> void select(List<T> list, Comparator<T> comparator) {
        T aux;
        int key;

        for (int i = 0; i < list.size() - 1; i++) {
            key = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(key)) < 0) {
                    key = j;
                }
            }

            aux = list.get(key);
            list.set(key, list.get(i));
            list.set(i, aux);
        }
    }

    public static <T extends Comparable<T>> void merge(List<T> a, List<T> b, int init, int last) {
        int midle;

        if (init < last) {
            midle = (init + last) / 2;
            merge(a, b, init, midle);
            merge(a, b, midle + 1, last);
            toMerge(a, b, init, midle, last);
        }
    }

    public static <T extends Comparable<T>> void toMerge(List<T> a, List<T> b, int init, int middle, int last) {
        int initA;
        int initB;
        int posFree;
        int numElem;

        initA = init;
        initB = middle + 1;
        posFree = init;
        numElem = last - init + 1;

        while (initA <= middle && initB <= last) {
            if (a.get(initA).compareTo(a.get(initB)) <= 0) {
                b.set(posFree, a.get(initA));
                initA++;
            }
            else {
                b.set(posFree, a.get(initB));
                initB++;
            }
            posFree++;
        }

        while (initA <= middle) {
            b.set(posFree, a.get(initA));
            posFree++;
            initA++;
        }

        while (initB <= last) {
            b.set(posFree, a.get(initB));
            posFree++;
            initB++;
        }

        for (int i = 0; i < numElem; i++, last--) {
            a.set(last, b.get(last));
        }
    }

    public static void quick() {

    }

    public static void shell() {

    }

    public static void heap() {

    }
}

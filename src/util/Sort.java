package util;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public static <T extends Comparable<T>> void insert(List<T> list) {
        int i;
        int j;
        T key;                      //variável que será comparada com as demais

        for (i = 1; i < list.size(); i++) {
            //key recebe o valor de i e assim será comparada com todas as demais da lista
            key = list.get(i);
            //j ecebe o índice do elemento antecessor a key para iniciar as comparações
            j = i - 1;

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
        int i;
        int j;
        T key;

        for (i = 1; i < list.size(); i++) {
            key = list.get(i);
            j = i - 1;

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
        int i;
        int j;

        /*
        laço percorre do início ao penúltimo elemento da lista para comparara com
        os elementos à direita de i
         */

        for (i = 0; i < list.size() - 1; i++) {
            key = i;

            /*
            após key receber i, o segundo laço compara o elemento de índice i com
            todos à sua direita, até achar o menor elemento comparado com ele
             */
            for (j = i + 1; j < list.size(); j++) {
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
        int i;
        int j;

        for (i = 0; i < list.size() - 1; i++) {
            key = i;

            for (j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(key)) < 0) {
                    key = j;
                }
            }

            aux = list.get(key);
            list.set(key, list.get(i));
            list.set(i, aux);
        }
    }

    public static void merge() {

    }

    public static void quick() {

    }

    public static void shell() {

    }

    public static void heap() {

    }
}

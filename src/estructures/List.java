package estructures;

import Exceptions.EmpityListException;

import java.util.Objects;

public class List<T> {
    private ItemList<T> first;
    private ItemList<T> last;

    public List() {
        this(null, null);
    }

    public List(ItemList<T> first, ItemList<T> last) {
        this.first = first;
        this.last = last;
    }

    public void insertAtFront(T value) {
        ItemList<T> itemList;
        itemList = new ItemList<>(value);

        if (isEmpity()) {
           first = itemList;
            last = itemList;
        }
        else {
            itemList.setNext(first);
            first = itemList;
        }
    }

    public void insertAtBack(T value) {
        if (isEmpity()) {
            insertAtFront(value);
        }
        else {
            last.setNext(new ItemList<>(value));
            last = last.getNext();
        }
    }

    public T removeFromFront() throws EmpityListException {
        T itemRemoved;

        if (isEmpity()) {
            throw new EmpityListException();
        }

        itemRemoved = first.getValue();

        if (first == last) {
            first = null;
            last = null;
        }
        else {
            first = first.getNext();
        }

        return itemRemoved;
    }

    public T removeFromBack() throws EmpityListException {
        T itemRemoved;
        ItemList item;

        if (isEmpity()){
            throw new EmpityListException();
        }

        itemRemoved = last.getValue();

        if (first == last) {
            first = null;
            last = null;
        }
        else {
            item = first;
            while (item.getNext() != last) {
                item = item.getNext();
            }
            item.setNext(null);
            last = item;
        }

        return itemRemoved;
    }

    public boolean isEmpity() {
        return first == null;
    }

    public void print() {
        ItemList<T> itemList;

        itemList = first;

        while (itemList != null) {
            System.out.print(itemList.toString() + " ");
            itemList = itemList.getNext();
        }

        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        List<?> list = (List<?>) o;
        return Objects.equals(first, list.first) &&
                Objects.equals(last, list.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    @Override
    public String toString() {
        return "List{" +
                "first=" + first.toString() +
                ", last=" + last.toString() +
                '}';
    }
}

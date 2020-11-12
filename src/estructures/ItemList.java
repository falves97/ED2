package estructures;

import java.util.Objects;

public class ItemList<T> {
    private T value;
    private ItemList<T> next;

    public ItemList() {
        this(null, null);
    }

    public ItemList(T value) {
        this(value, null);
    }

    public ItemList(T value, ItemList<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ItemList<T> getNext() {
        return next;
    }

    public void setNext(ItemList<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemList)) return false;
        ItemList<?> itemList = (ItemList<?>) o;
        return Objects.equals(getValue(), itemList.getValue()) &&
                Objects.equals(getNext(), itemList.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getNext());
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "value=" + value.toString() +
                '}';
    }
}

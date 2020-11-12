package Exceptions;

public class EmpityListException extends RuntimeException {
    public EmpityListException() {
        this("List");
    }

    public EmpityListException(String list) {
        super(list + "is empity");
    }
}

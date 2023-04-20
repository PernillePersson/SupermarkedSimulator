public class Customer <T> {
    private T data;
    private Customer<T> next;

    public Customer(T data) {
        this.data = data;
        next = null;
    }

    public void setNext(Customer<T> next) {
        this.next = next;
    }

    public Customer<T> getNext(){
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
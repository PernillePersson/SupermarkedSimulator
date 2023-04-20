import java.util.Random;

public class QueueThingy <T> {

    private Customer<T> root;

    public QueueThingy() {
        root = null;
    }

    public void enqueue(T data) {
        if(isEmpty()) {
            root = new Customer<T>(data);
        }
        else {
            Customer<T> curr = root;
            while(curr.getNext()!=null) {
                curr = curr.getNext();
            }
            curr.setNext(new Customer<T>(data));
        }
    }

    public T dequeue() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();

        T data = root.getData();
        root = root.getNext();
        return data;
    }

    public T peek() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();

        return root.getData();
    }

    public void changeRootData(T data) throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();

        root.setData(data);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void simulateSupermarket(int time, int arrivalInterval) {
        Random r = new Random();
        int maxCustomers = 0;
        int currentCustomers = 0;
        int longestWait = 0;

        QueueThingy<Integer> customers = new QueueThingy<>();
        int customerArrival = r.nextInt(arrivalInterval - 1) + 1;
        for(int i  = 0;i<time;i++) {
            if(i == customerArrival) {
                System.out.println("A customer arrived.");
                if(!customers.isEmpty()) customers.enqueue(i);
                else {
                    int doneAt = i + r.nextInt(arrivalInterval - 1) + 1;
                    if(doneAt - i>longestWait) longestWait = doneAt - i;
                    customers.enqueue(doneAt);
                }
                currentCustomers++;
                if(currentCustomers>maxCustomers) maxCustomers = currentCustomers;
                customerArrival = i + r.nextInt(arrivalInterval - 1) + 1;
            }
            if(!customers.isEmpty()) {
                if(customers.peek()==i) {
                    System.out.println("A customer is completed.");
                    customers.dequeue();
                    currentCustomers--;
                    if(!customers.isEmpty()) {
                        int arrivedAt = customers.peek();
                        int finishTime = i + r.nextInt(arrivalInterval - 1) + 1;
                        customers.changeRootData(finishTime);
                        if(longestWait < finishTime - arrivedAt) longestWait =  finishTime - arrivedAt;
                    }
                }
            }
        }

        System.out.println("The maximum number of cusotmers at any time was: " + maxCustomers);
        System.out.println("The longest wait was: " + longestWait);
    }
}
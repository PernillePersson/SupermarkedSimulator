import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int max = 4;
        int dayshift = 720;

        QueueThingy<Customer> cs = new QueueThingy<>();
        cs.simulateSupermarket(dayshift, max);
    }
}
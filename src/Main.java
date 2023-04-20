import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int min = 1;
        int max = 4;

        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int dayshift = 720;

        QueueThingy<Customer> cs = new QueueThingy<>();
        cs.simulateSupermarket(dayshift, random_int);
    }
}
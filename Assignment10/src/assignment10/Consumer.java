package assignment10;
import java.nio.IntBuffer;
/**
 * 
 * Evan Preisler - 10101753
 * Assignment 10 - CT326
 * For lecture slides - page 216, 217
 * 2015
 * 
 *
 * @author dex
 */
public class Consumer extends Thread {
    private BoundedBuffer cubbyhole;
    private int number;
    
    public Consumer(BoundedBuffer c, int number) {
        cubbyhole = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for(int i = 0; i < 10; i++) {
            try {
                sleep((int)Math.random() * 10);
                value = (int)cubbyhole.take();
                System.out.println("Consumer #" + this.number + " got: " + value);
            } catch(InterruptedException ex) {}
        }
    }
}

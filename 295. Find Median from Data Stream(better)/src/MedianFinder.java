import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue();//min queue actually holds the bigger half of the numbers
    PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);

        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(12);
        System.out.println("12,"+obj.findMedian());// -> 12
        obj.addNum(10);
        System.out.println("11,"+obj.findMedian());// -> 8
        obj.addNum(13);
        System.out.println("12,"+obj.findMedian());// -> 6
        obj.addNum(11);
        System.out.println("11.5,"+obj.findMedian());// -> 6
        obj.addNum(5);
        System.out.println("11,"+obj.findMedian());// -> 6
        obj.addNum(15);
        System.out.println("11.5,"+obj.findMedian());// -> 5.5
        obj.addNum(1);
        System.out.println("11,"+obj.findMedian());// -> 6
        obj.addNum(11);
        System.out.println("11,"+obj.findMedian());// -> 5.5
        obj.addNum(6);
        System.out.println("11,"+obj.findMedian());// -> 5
        obj.addNum(17);
        System.out.println("11,"+obj.findMedian());// -> 4
        obj.addNum(14);
        System.out.println("11,"+obj.findMedian());// -> 3
        obj.addNum(8);
        System.out.println("11,"+obj.findMedian());// -> 3

            MedianFinder obj2 = new MedianFinder();
            obj2.addNum(-1);
            //System.out.println("-1,"+obj2.findMedian());// -> 12
            obj2.addNum(-2);
            //System.out.println("-1.5,"+obj2.findMedian());// -> 8
            obj2.addNum(-3);
            //System.out.println("-2,"+obj2.findMedian());// -> 6
            obj2.addNum(-4);
            //System.out.println("-2.5,"+obj2.findMedian());// -> 6
            obj2.addNum(-5);
            //System.out.println("-3,"+obj2.findMedian());// -> 6


        MedianFinder obj3 = new MedianFinder();
        obj3.addNum(40);
        System.out.println("40," + obj3.findMedian());// -> 12
        obj3.addNum(12);
        System.out.println("26," + obj3.findMedian());// -> 8
        obj3.addNum(16);
        System.out.println("16," + obj3.findMedian());// -> 6
        obj3.addNum(14);
        System.out.println("15," + obj3.findMedian());// -> 6
        obj3.addNum(35);
        System.out.println("16," + obj3.findMedian());// -> 6
        obj3.addNum(19);
        System.out.println("17.5," + obj3.findMedian());// -> 12
        obj3.addNum(34);
        System.out.println("19," + obj3.findMedian());// -> 8
        obj3.addNum(35);
        System.out.println("26.5," + obj3.findMedian());// -> 6
        obj3.addNum(28);
        System.out.println("28," + obj3.findMedian());// -> 6
        obj3.addNum(35);
        System.out.println("31," + obj3.findMedian());// -> 6
        obj3.addNum(26);
        System.out.println("28," + obj3.findMedian());// -> 12
        obj3.addNum(6);
        System.out.println("27," + obj3.findMedian());// -> 8
        obj3.addNum(8);
        System.out.println("26," + obj3.findMedian());// -> 6
        obj3.addNum(2);
        System.out.println("22.5," + obj3.findMedian());// -> 6
        obj3.addNum(14);
        System.out.println("19," + obj3.findMedian());// -> 6
        obj3.addNum(25);
        System.out.println("22," + obj3.findMedian());// -> 6

    }
}

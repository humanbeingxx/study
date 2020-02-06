package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class MyCircularQueue {

    int[] buffer;
    int size = 0;
    int head = 0;
    int tail = -1;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        buffer = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        tail = (this.tail + 1) % buffer.length;
        buffer[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        head = (head + 1) % buffer.length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        return buffer[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        return buffer[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == buffer.length;
    }
}

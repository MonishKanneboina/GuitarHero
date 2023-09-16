public class RingBuffer 
{
    private double[] data;          // items in the buffer
    private int      first;         // index for the next dequeue or peek
    private int      last;          // index for the next enqueue
    private int      size;          // number of items in the buffer
    
    private double[] buffer;
    private int capacity;

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
       this.capacity = capacity; 
       buffer = new double[capacity];
       first = 0;
       last = 0;
       size = 0;
    }

    /** return number of items currently in the buffer */
    public int size() {
        // YOUR CODE HERE
        
        return size; 
     }

    /** is the buffer empty (size equals zero)? */
    public boolean isEmpty() {
        // YOUR CODE HERE
        if (size == 0)
         {
            return true;
         }
        return false;
    }

    /** is the buffer full (size equals array capacity)? */
    public boolean isFull() {
        // YOUR CODE HERE
        if (size == buffer.length)
         {
            return true;
         }
        return false; 
    }

    /** add item x to the end */
    public void enqueue(double x) {
        // YOUR CODE HERE

        
        if (isFull())
         {
            throw new RuntimeException();
         }
         buffer[last] = x;
         size++;
         last++;

          if (last == capacity)
            {
                
                last = 0;
                
            }
            
        
    }

    /** delete and return item from the front */
    public double dequeue() {
        // YOUR CODE HERE
        
        double temp = 0;
        
        if (isEmpty())
         {
            throw new RuntimeException();
         }
        temp = buffer[first];
        first++;
        size--;
        if (first == capacity)
         {
           first = 0;
         }
                
         return temp; 

       }

    /** return (but do not delete) item from the front */
    public double peek() {
        // YOUR CODE HERE

        return buffer[first]; 
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
        
        /*
         * Your program should produce the following output:
         * 
         *  Size after wrap-around is 100
			5050.0
         */
    }
}

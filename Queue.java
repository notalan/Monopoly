
public interface Queue {
 public void enqueue(Object object) throws QueueFullException;
 public Object dequeuer() throws QueueEmptyException;
 public Object front();
 public boolean isEmpty();
 public int size();
} 
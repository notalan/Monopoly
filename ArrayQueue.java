public class ArrayQueue implements Queue {
	
	private Object[] Q;
	private int rear = 0, front = 0;
	private static final int capacity = 50;
	private final int N;
	
	public ArrayQueue(int capacity) {
		N = capacity;
		Q = new Object[N];
	}

	public ArrayQueue() {
		this(capacity);
	}

	public void enqueue(Object object){
		Q[rear] = object;
		rear = (rear + 1) % N;
	}
	public int size()
	{	if(rear > front)
		return rear-front;
		return (N + rear - front)%N;
		
	}

	public boolean isEmpty()
	{
		return (front == rear) ? true : false;
	}
	
	public Object dequeuer() throws QueueEmptyException {
		Object e;
		if(isEmpty()){
			throw new QueueEmptyException();
		}else{
		e = Q[front];
		Q[front] =  null;
		front = (front + 1)%N;
		}
		return e;
	}
	
	public Object front() {
		return Q[front];
	}
}
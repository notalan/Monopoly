public class runq{
public static void main(String[] args) {
		
		Queue queue = new ArrayQueue();
		
		System.out.println(queue);
		queue.enqueue("R");
		System.out.println(queue);
		queue.enqueue("E");
		System.out.println(queue);
		System.out.println(queue.dequeuer());
		System.out.println(queue);
		queue.enqueue("M");
		System.out.println(queue);
		queue.enqueue("H");
		System.out.println(queue);
		queue.enqueue("E");
		System.out.println(queue);
		System.out.println(queue.dequeuer());
		System.out.println(queue);
		queue.enqueue("L");
		System.out.println(queue);
		queue.enqueue("L");
		System.out.println(queue);
		System.out.println(queue.dequeuer());
		System.out.println(queue);
		queue.enqueue("O");
		System.out.println(queue);
		
	}
}
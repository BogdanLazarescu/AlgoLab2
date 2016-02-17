
public class Test {
	public static void main(String[] args) {
		CircularArrayQueue q = new CircularArrayQueue(3);
		CircularArrayQueue q1 = new CircularArrayQueue();
		
		//check if the q seize is correct
		System.out.println(q.getSize());
		System.out.println(q.getCapacityLeft());
		System.out.println(q1.getSize());
		System.out.println(q1.getCapacityLeft());
		
		//add 5 elements to check the resize method  of q
		for(int i=1;i <= 5; i++ ){
			q.enqueue(i);
		}
		System.out.println("capacity left: " + q.getCapacityLeft());
		q.printArray();
		q.dequeue();
		q.printArray();
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.printArray();
		q.enqueue(9);
		for(int i=1;i<=11;i++)
		{
			q.enqueue(i);
		}
	}
	
	
}

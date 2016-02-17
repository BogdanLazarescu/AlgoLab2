import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue {

	final static int DEFAULT_SIZE = 10;
	int[] elements;
	Integer size;
	Integer head;
	Integer tail;
	Integer elemNum;

	public CircularArrayQueue(int firstSize){
		this.size = firstSize;
		elements = new int[this.size];
		elemNum = 0;
		head = 0;
		tail = 0;
	}
	
	public CircularArrayQueue(){
		this(DEFAULT_SIZE);
	}
	
	public void enqueue(int in) {

		if(elemNum >= size){
			resizeArray();
			//tail = head + elemNum  ;
		}
		elemNum++;
		elements[tail] = in;
		tail = head + elemNum;
		tail = tail % size ;
		this.printArray();
	}
	public void resizeArray(){
		size *= 2;
		if(head==0){
			System.out.println("normal");
			tail = head+ elemNum;
			elements = Arrays.copyOf(elements, size);
		}else{
			System.out.println("anormal");
			int temp[] = new int[size];
			System.arraycopy(elements, 0, temp, 0, this.tail);
			System.arraycopy(elements, head, temp, temp.length-elements.length+this.head, elements.length-head);
			elements=temp;
			head = head+ size/2;
			for(int i=0 ;i<elements.length;i++){
				System.out.print(elements[i]+",");
			}
			System.out.println();
		}
	}
	
	public int dequeue() throws NoSuchElementException {
		if(this.isEmpty())
			throw new NoSuchElementException();
		int elem = elements[head];
		elements[head] = 0;
		head ++;
		head = head % size;
		elemNum --;
		return elem;
	}

	public int noItems() {
		return elemNum;
	}

	//check if the queue is empty
	public boolean isEmpty() {
		return (noItems() == 0);
	}
	
	public int getSize(){
		return elements.length;
	}
	
	//return the number of elements that can be added
	public int getCapacityLeft(){
		return this.elements.length - this.elemNum;
	}
	
	//used for test
	public void printArray(){
		for(int i= 0; i <size; i++)
			System.out.print(elements[i]+",");
		System.out.println();
	}
}

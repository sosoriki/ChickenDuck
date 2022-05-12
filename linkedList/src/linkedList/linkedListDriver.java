package linkedList;

/**
 * 
 * driver class to test
 * linked list
 * @author Kendrick Pham
 *
 */

public class linkedListDriver {
	public static void main(String[] args) {
		linkedList<Integer> list = new linkedList<Integer>();
		System.out.printf("List size: %d\n", list.size());
		System.out.printf("Is list Empty? %s\n", list.isEmpty());
		list.add(2);
		list.add(1);
		list.add(3, 2);
		list.addLast(4);
		list.addLast(5);
		System.out.printf("First element: %d\n", list.getFirst());
		System.out.printf("Element at index 2: %d\n", list.get(1));
		System.out.printf("Element at index 3: %d\n", list.get(2));
		System.out.printf("Element at index 4: %d\n", list.get(3));
		System.out.printf("Last Element: %d\n", list.getLast());
		list.addLast(6);
		System.out.printf("Element at index 5: %d\n", list.get(4));
		System.out.printf("Last Element: %d\n", list.getLast());
		System.out.printf("List size: %d\n", list.size());
		System.out.printf("Is list Empty? %s\n", list.isEmpty());
		list.removeFirst();
		System.out.printf("First element: %d\n", list.getFirst());
		list.removeLast();
		System.out.printf("Last element: %d\n", list.getLast());
		System.out.printf("List contains 3? %s\n", list.contains(3));
		System.out.printf("List contains 20? %s\n", list.contains(20));
	}
}

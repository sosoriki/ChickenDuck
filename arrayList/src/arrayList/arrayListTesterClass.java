package arrayList;

public class arrayListTesterClass {
	public static void main(String[] args) {
		arrayList<Integer> AL = new arrayList<>(4);
		System.out.printf("Is AL empty? %s\n", AL.isEmpty());
		AL.add(25);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.add(4);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.add(22);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.add(65);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.add(98);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.add(100, 5);
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		System.out.printf("Does the AL contain 22? %s\n", AL.contains(22));
		System.out.printf("Does the AL contain 99? %s\n", AL.contains(99));
		System.out.printf("AL at index 3: %d \n", AL.get(2));								//index 3 but look at 2 because array starts at 0
		System.out.printf("AL at index 1: %d \n", AL.get(0));
		System.out.printf("AL at index 5: %d \n", AL.get(4));
		AL.indexOf(4);
		AL.indexOf(99);
		System.out.printf("Is AL empty? %s\n", AL.isEmpty());
		System.out.printf("Size of ArrayList: %d\n", AL.size());
		AL.clear();
		System.out.printf("Is AL empty? %s\n", AL.isEmpty());
		System.out.printf("Size of ArrayList: %d\n", AL.size());
	}
}

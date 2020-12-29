package com.coderscampus.arraylist;


public class ExampleApplication {

	public static void main(String[] args) {
		String ipsum = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system,"
				+ " and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself,"
				+ " because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone"
				+ " who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great"
				+ " pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with "
				+ "a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?";
		
		lessThan10Test();
		moreThan10Test();		
        strLessTest(ipsum);
        strMoreTest(ipsum);

	}
	
	
	private static void lessThan10Test() {
		CustomList<Integer> numbers = new CustomArrayList<Integer> ();				 
		Integer a[] = new Integer[] { 10, 20, 30, 40 };
		System.out.println("--- less than 10 numbers test ----");
		integerCoreTest(numbers, a);
	}
	private static void moreThan10Test() {
		CustomList<Integer> numbers = new CustomArrayList<Integer> ();		
		Integer a[] = new Integer[] { 10, 20, 30, 40, 50,60,70,80,29,22,21,34 };	
		System.out.println("--- more than 10 numbers test ----");
		integerCoreTest(numbers, a);
	}

	private static void integerCoreTest(CustomList<Integer> numbers, Integer[] a) {
		for (Integer i : a)
			numbers.add(i);
		
		for (Integer i: a)
			System.out.println(i);

		System.out.println("size: "+numbers.getSize());
		 
	}
	
	private static void strLessTest(String ipsum) {
		
		CustomList<String> str = new CustomArrayList<String> ();		
        String[] text = ipsum.split(" ",9);	
        System.out.println("--- less than 10 string test ----");
		strCoreTest(str, text);
	}
	
private static void strMoreTest(String ipsum) {
		
		CustomList<String> str = new CustomArrayList<String> ();		
        String[] text = ipsum.split(" ",45);	
        System.out.println("--- more than 10 strings test ----");
		strCoreTest(str, text);
	}


	private static void strCoreTest(CustomList<String> str, String[] text) {
		for (String i : text)
			str.add(i);
		
		for (int j=0; j<str.getSize(); j++) {
			System.out.println (str.get(j));
		}
		System.out.println("size: "+str.getSize());
		 
	}

}

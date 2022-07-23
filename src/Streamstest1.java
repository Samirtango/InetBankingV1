import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Streamstest1 {
	
	public static void main(String []args) {

		regular();
		streamfilter();
		streamCollect();
		
	}

		// TODO Auto-generated method stub
		
		//Count the number of names starring with aplphabet a in the list.
		//Below is done regular java
		
		//@Test
		public static void regular() {
			
		ArrayList<String> names= new ArrayList<String>();
		names.add("Sameer");
		names.add("Farhan");
		names.add("Arh");
		int count=0;
		for(int i=0;i<names.size();i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println("without streams "+count);	
		
		//printing the names above using streams in a single line with the my condition.
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));//it gives only one output.
		Stream.of("Sameer","Frahan","Arhan").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println("can be done like this also  "+s));
		//if you want to print names which have first letter as a with upparcase and sorted
		
		
		List<String> name =Arrays.asList("Sameer","Anubhav","Azdi","Adil","Zuby","Aanav");
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("    "+s));
		
		//above forEach also takes lambda expression.
		
		//If you want to concatinate two streams then do this. Merging two different lists
		List<String> name2 =Arrays.asList("Sameer","Anubhav","Azdi","Adil","Zuby","Aanav");
		List<String> name3 =Arrays.asList("SaiRam","Frahn","Ayesh","Addiba");
		
		Stream newstream =Stream.concat(name2.stream(), name3.stream());
		newstream.sorted().forEach(s->System.out.println("after concatination new stream-->"+s));
		
		while((name2.stream().anyMatch(s->s.equalsIgnoreCase("Azdi"))))
				{
					System.out.println("yes there is a match");
					break;
				}	
				
		}
		
		
		
		public static void streamfilter() {
			
			ArrayList<String> names= new ArrayList<String>();
			names.add("Sameer");
			names.add("Farhan");
			names.add("Arham");
			
			//above can be ctead using streams. no need to go with collection.
			
			Long d =Stream.of("Sameer","Frahan","Arham").filter(s->s.startsWith("A")).count();
			//there is no life for intermediate operation if there is no terminal operatin above count.
			//terminal operation will execute only if intermediate op (filter) returs true.
			//how to use filter in stream api.
			
			//above can be written like this also.
			/*
				Stream.of("Sameer","Frahan","Arham").filter(s->
				{
						s.startsWith("A");
				}).count();*/
			
			Long c=names.stream().filter(s->s.startsWith("A")).count();
			//assign arralyist to stream.
			//stream api can do the operations parallally.
			//stream api there is method called filter
			//.filter-->filter based on condition.
			//Lambda Expression: new expression in java language.
				//s->   here left sid-('s') is parameter and arrow is action which we are going to perform on the paramenter.
			
			
			System.out.println("using streams "+c);
			System.out.println("using streams direcly not using any collection "+d);
			
		}
		
		public static void streamCollect() {
			 
			//list
			//convert it to new list.
			List<String> ls=Stream.of("Sameer","Frahan","Arhan").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).collect(Collectors.toList());
			Stream.of("Sameer","Frahan","Arhan").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).limit(1).forEach(s->System.out.println(s));
			System.out.println(ls.get(1));
			
			List<Integer> l1=Arrays.asList(3,2,4,6,2,1,6,8,9,2);
			//print unique number from array
			//sor the array.
			
			//above can be done using streams.
			
			l1.stream().distinct().forEach(s->System.out.println(s));
			List<Integer> l2=l1.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println("is it printed "+l2.get(2));
			
			
		}

}
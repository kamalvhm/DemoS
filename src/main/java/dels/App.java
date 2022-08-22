package dels;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import com.lembda.BeanClass;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;





public class App{
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BeanClass> list = Arrays.asList(
			new BeanClass(1,"kamal"),
			new BeanClass(2,"Ram"),
			new BeanClass(3,"Shyam"),
			new BeanClass(4,"Amit")
		);
		
		
		//Step 1:- Sort the list by name
		Collections.sort(list,(a,b)->a.getName().compareTo(b.getName()));
		//Step 2:- print all
		//list.forEach(System.out::println);
		printConditionally(list, p->true,p->System.out.println(p));
		
		//list.stream().filter(r->r.getName().startsWith("A")).forEach(System.out::println);
		//Step3:- print all name which start from S
		printConditionally(list,(a)->a.getName().startsWith("S"),p->System.out.println(p));
	}
	
	public static void printConditionally(List<BeanClass> list,Predicate<BeanClass> cond,Consumer<BeanClass> c) {
		for(BeanClass l:list) {
			if(cond.test(l))
				c.accept(l);
		}
	}
	

	
	
}
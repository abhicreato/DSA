import java.util.*;
import java.util.stream.Collectors;

public class java8 {

    public static void main(String[] arg){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(2);
        list.add(4);

        long corecount = Runtime.getRuntime().totalMemory() / 1024 /1024 /1014;

        System.out.println(corecount);
        
        //list.stream().filter(i -> i > 1 ).forEach(System.out :: print);

        //list.stream().map(i -> i + 1 ).forEach(System.out :: print);

        //list.stream().sorted().forEach(System.out :: println);

        //System.out.println(list.stream().max((i,j) -> i.compareTo(j)).get());

        //System.out.println(list.stream().min((i,j) -> i.compareTo(j)).get());

        //list.stream().distinct().collect(Collectors.toList()).forEach(System.out :: println);

    }
    
}

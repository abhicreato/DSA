import java.util.*;
import java.util.stream.Collectors;

public class java8 {


    public static void main(String[] arg){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(4);
        
        //list.stream().filter(i -> i > 1 ).forEach(System.out :: print);

        //list.stream().map(i -> i + 1 ).forEach(System.out :: print);

        //list.stream().sorted().forEach(System.out :: println);

        //System.out.println(list.stream().max((i,j) -> i.compareTo(j)).get());

        System.out.println(list.stream().min((i,j) -> i.compareTo(j)).get());

    }
    
}

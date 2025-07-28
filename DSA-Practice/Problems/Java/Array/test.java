import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);

        a.stream().mapToInt(value -> value).collect(null, null, null);
}

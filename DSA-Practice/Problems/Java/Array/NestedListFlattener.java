import java.util.ArrayList;
import java.util.List;

public class NestedListFlattener {

    public static List<Integer> flatList(List<Object> nestedList, List<Integer> op) {

        if(nestedList == null || nestedList.isEmpty()) return op;
        for (Object element : nestedList) {
            if (element instanceof Integer) {
                op.add((Integer) element);
            } else if (element instanceof List) {
                flatList((List<Object>) element, op); // recursive flattening
            } else {
                throw new IllegalArgumentException("Unsupported element type: " + element.getClass());
            }
        }
        return op;
    }

    // Example usage
    public static void main(String[] args) {
        List<Object> input = new ArrayList<>();
        input.add(1);
        input.add(2);

        List<Object> nested1 = new ArrayList<>();
        nested1.add(3);
        nested1.add(4);

        List<Object> nested2 = new ArrayList<>();
        nested2.add(5);

        List<Object> deepNested = new ArrayList<>();
        deepNested.add(6);
        nested2.add(deepNested); // [5, [6]]

        nested1.add(nested2); // [3, 4, [5, [6]]]
        input.add(nested1); // [1, 2, [3, 4, [5, [6]]]]

        List<Integer> result = new ArrayList<>();
        flatList(input, result);
        System.out.println(result); // Output: [1, 2, 3, 4, 5, 6]
    }
}

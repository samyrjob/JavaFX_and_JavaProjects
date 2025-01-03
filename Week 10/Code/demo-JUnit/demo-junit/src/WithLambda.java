import java.util.*;

public class WithLambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Sort with a lambda expression
        names.sort((a, b) -> b.compareTo(a));

        // Print the sorted list
        names.forEach(name -> System.out.println(name));
    }
}

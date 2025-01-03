import java.util.Arrays;
import java.util.Random;


class NumberSort {

    static Random random = new Random();

    public static void main(String[] args) {

        int array_of_random_values [] = new int[25];

        for (int i =0; i<25; i++){
            
            int random_number = random.nextInt(51);
            array_of_random_values[i] = random_number;
        }

        System.out.println(Arrays.toString(array_of_random_values));
        Arrays.sort(array_of_random_values);
        
        System.out.println(Arrays.toString(array_of_random_values));

        
    }
}
import java.util.Arrays;


public class LongList {


    public static void main(String[] args) {
        try_access_index(200, 201);
    }


    static String [] return_array_of_string(int length){

        String [] array_strings = new String [length];
        Arrays.fill(array_strings, "*");
        return array_strings;
    }


    static void try_access_index(int length_array, int index){
        // try {

            String [] array_of_strings = return_array_of_string(length_array);

            // if (index > length_array){
            //     throw new ArrayIndexOutOfBoundsException("you try to access an index greather out the bounds of the array");
            // }
            array_of_strings[index] = "not * ";

        // }
        // catch (ArrayIndexOutOfBoundsException aiobe){
        //     aiobe.getMessage();
        // }
    }
    
}

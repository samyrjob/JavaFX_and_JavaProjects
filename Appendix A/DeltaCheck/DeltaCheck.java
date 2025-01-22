import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class DeltaCompression {


    
    static List<Map.Entry<Object, Object>> listmapBeforeAfter = new ArrayList<>();



    static ArrayList<Object> compress(ArrayList<Object> input){

        ArrayList<Object> deltas = new ArrayList<>();

        if (input == null || input.isEmpty()){
            return input;
        }
        else if (input.get(0) instanceof Character){
            int first_character = ((Character) input.get(0)).charValue();
            deltas.add(first_character);
            listmapBeforeAfter.add(Map.entry(input.get(0),first_character));
        }
        else {
            int first_element = ( (Number) input.get(0)).intValue();
            deltas.add(first_element);
            listmapBeforeAfter.add(Map.entry(input.get(0),first_element));
        }
        

        for (int i=1;i<input.size(); i++){

            Object current = input.get(i);
            Object previous = input.get(i-1);

            if (current instanceof Number && previous instanceof Number){

                double valueForAdd = ((Number) current).doubleValue() - ((Number) previous).doubleValue();
                deltas.add(valueForAdd);
                listmapBeforeAfter.add(Map.entry(current,valueForAdd));
            }
            else {
                int valueForAdd = ((char) current) - ((char) previous); // if we suppose else the objects are of type Charcter so we unbox them  as char characters and then we apply the difference and store the value as an int value 
                deltas.add(valueForAdd);
                listmapBeforeAfter.add(Map.entry(current,valueForAdd));
            }
        }

        return deltas;

    }

    static ArrayList<Object> decompress(ArrayList<Object> deltas){


        ArrayList<Object> output = new ArrayList<>();
        if (deltas ==null || deltas.isEmpty()){
            return deltas; // return an arraylist with null elements
        }


        if (listmapBeforeAfter.get(0).getKey() instanceof Character){
            output.add(listmapBeforeAfter.get(0).getKey());
        }

        else {
            output.add(deltas.get(0));

        }

        // for (int i =1; i< deltas.size(); i++){
        //     output.add(deltas.get(i) + output.get(i-1));
        // }
        
        for (int i=1;i<deltas.size(); i++){

            Object currentDelta = deltas.get(i);
            Object previousOutput = output.get(i-1);

            if (currentDelta instanceof Number && previousOutput instanceof Number){

                double valueForAdd = ((Number) currentDelta).doubleValue() + ((Number) previousOutput).doubleValue();
                output.add(valueForAdd);
            }
            else {
                char valueForAdd = (char)(((Number) currentDelta).intValue() + ((char)previousOutput)); // if we suppose else the objects are of type Charcter 
                output.add(valueForAdd);
            }
        }
        return output;



    }


}


class DeltaCheck {

    public static void main(String[] args) {

        ArrayList<Object> input = new ArrayList<>(Arrays.asList(78, 82, 9));

        ArrayList<Object> inputCompressed = DeltaCompression.compress(input);

        System.out.println(inputCompressed);

        input = DeltaCompression.decompress(inputCompressed);

        System.out.println(input);
    }
}
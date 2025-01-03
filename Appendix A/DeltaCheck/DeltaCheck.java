import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class DeltaCompression {



    static ArrayList<Integer> compress(ArrayList<Integer> input){

        ArrayList<Integer> deltas = new ArrayList<>();

        if (input == null || input.isEmpty()){
            return input;
        }

        deltas.add(input.get(0));
        

        for (int i=1;i<input.size(); i++){
            deltas.add(input.get(i) - input.get(i-1));
        }

        return deltas;

    }

    static ArrayList<Integer> decompress(ArrayList<Integer> deltas){


        ArrayList<Integer> output = new ArrayList<>();
        if (deltas ==null || deltas.isEmpty()){
            return deltas; // return an arraylist with null elements
        }

        output.add(deltas.get(0));

        for (int i =1; i< deltas.size(); i++){
            output.add(deltas.get(i) + output.get(i-1));
        }
        return output;



    }


}


class DeltaCheck {

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(13,15,14,18,11,10,15,16));

        ArrayList<Integer> inputCompressed = DeltaCompression.compress(input);

        System.out.println(inputCompressed);

        input = DeltaCompression.decompress(inputCompressed);

        System.out.println(input);
        




    }
}
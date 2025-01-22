import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class ComplexMagnitude {


    public static void main(String[] args) throws IOException{

        FileWriter fileWriter = new FileWriter("results_per_timeComplexity.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        // // first array of size 10
        // int [] array_figures1 = {1,2,3,4,5,6,7,9,8,10};
        // // second array of size 40
        // int [] array_figures2 = {1,2,3,4,5,6,7,9,8,10, 11,12,13,14,15,16,17,18,19,20, 21, 22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        Random random  = new Random();

          // first array of size 500 : 
          int  [] array_figures1 = new int [5000];
          for (int i =0; i< array_figures1.length; i++){
              array_figures1[i] = i;
          }

            // second array of size 1000 : 
        int  [] array_figures2 = new int [10000];
        for (int i =0; i< array_figures2.length; i++){
            array_figures2[i] = i;
        }


        // third array of size 10000 : 
        int  [] array_figures3 = new int [15000];
        for (int i =0; i< array_figures3.length; i++){
            array_figures3[i] = i;
        }

        ArrayList<int []> list_of_array_of_integers = new ArrayList<>();
        list_of_array_of_integers.add(array_figures1);
        list_of_array_of_integers.add(array_figures2);
        list_of_array_of_integers.add(array_figures3);

        for (int [] array_figures : list_of_array_of_integers){

            int elementToFind = random.nextInt(array_figures.length);
            System.out.println("element to find : " + elementToFind);

            long startTime = System.nanoTime();
            tryComplexityOn(array_figures, array_figures[elementToFind]);
            long elapsedTime = System.nanoTime() - startTime;
    
            System.out.println(elapsedTime);
            bufferedWriter.write(Long.toString(elapsedTime));
            bufferedWriter.newLine();
    
            startTime = System.nanoTime();
            tryComplexityOn2(array_figures, array_figures[elementToFind]);
            elapsedTime = System.nanoTime() - startTime;
    
            System.out.println(elapsedTime);
            bufferedWriter.write(Long.toString(elapsedTime));
            bufferedWriter.newLine();
    
            startTime = System.nanoTime();
            tryComplexityOn3(array_figures, array_figures[elementToFind]);
            elapsedTime = System.nanoTime() - startTime;
    
            System.out.println(elapsedTime);
            bufferedWriter.write(Long.toString(elapsedTime));
            bufferedWriter.newLine();
        }

          // Close the BufferedWriter to ensure the data is written to the file
        bufferedWriter.close();
        runPythonScript();
        
    }

    
    private static void runPythonScript() {
        try {
            // Path to the Python executable and the Python script
            String pythonScriptPath = "graph_timecomplexity.py";
            // Create a ProcessBuilder to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            processBuilder.inheritIO();  // This will show the output in the console

            // Start the process
            Process process = processBuilder.start();
            int exitCode = process.waitFor();  // Wait for the Python script to finish

            if (exitCode == 0) {
                System.out.println("Python script executed successfully.");
            } else {
                System.out.println("Python script execution failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static void tryComplexityOn(int [] array_figures, int target_figure){

        for (int i =0; i<array_figures.length; i++){
            
            if (array_figures[i] == target_figure){
                return;
            }
        }

    }

    
    static void tryComplexityOn2(int [] array_figures, int target_figure){

        for (int j =0; j<array_figures.length; j++){
            for (int i =0; i<array_figures.length; i++){
                // if (array_figures[i] == array_figures[j] && array_figures[i] == target_figure){
                //     return;
                // }
                if (array_figures[j] == target_figure) {
                    return;
                }

            }
        }

    }


    static void tryComplexityOn3(int [] array_figures, int target_figure){

        for (int h =0; h<array_figures.length; h++){
            for (int i =0; i<array_figures.length; i++){
                for (int j =0; j< array_figures.length; j++){
                    // if (array_figures[i] == array_figures[j] && array_figures[h] == array_figures[j] && array_figures[i] == target_figure){
                    //     return;
                    // }
                    if (array_figures[h] == target_figure) {
                        return;
                    }
                }
            }
        }

    }






}
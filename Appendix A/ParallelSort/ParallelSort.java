import java.util.Arrays;
import java.util.Random;

public class ParallelSort {
    static final int THREAD_COUNT = 4;
    static final int ARRAY_SIZE = 40;



    public static void main(String[] args) throws InterruptedException{

        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        // Fill the array with random integers
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(750);
        }

        // Measure time for sequential sort
        int[] sequentialArray = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        Arrays.sort(sequentialArray);
        long endTime = System.nanoTime();
        long sequentialTime = endTime - startTime;

        // Measure time for parallel sort
        int[] parallelArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        parallelSort(parallelArray);
        endTime = System.nanoTime();
        long parallelTime = endTime - startTime;

        // Print results
        System.out.println("Sequential Sort Time (ns): " + sequentialTime);
        System.out.println("Parallel Sort Time (ns): " + parallelTime);

        // Check if both methods produced the same result
        System.out.println("Arrays are equal: " + Arrays.equals(sequentialArray, parallelArray));
        runPythonScript();

    }

    

    private static void runPythonScript() {
        try {
            // Path to the Python executable and the Python script
            String pythonScriptPath = "plotGraph.py";

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





    private static void parallelSort(int [] array) throws InterruptedException {
        int chunksize = (array.length/THREAD_COUNT);

        ThreadSorting [] threadSorting = new ThreadSorting [THREAD_COUNT];


        for (int i = 0; i<THREAD_COUNT; i++){
            
            int start = i*chunksize;
            int end = (i == THREAD_COUNT-1) ? array.length : start + chunksize;
            threadSorting[i] = new ThreadSorting(array, start, end);
            threadSorting[i].start();
        }




        for (Thread thread : threadSorting){
            thread.join();
        }

        mergeChunks(array, chunksize);


    }

    
    private static void mergeChunks(int[] array, int chunkSize) {

        int[] tempArray = Arrays.copyOf(array, array.length);
        int[] indices = new int[THREAD_COUNT];

        int[] chunkEnds = new int[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            chunkEnds[i] = (i == THREAD_COUNT - 1) ? array.length : (i + 1) * chunkSize; // chucksize for not even perfect chunks sizes 
            indices[i] = i * chunkSize;
        }

        for (int i = 0; i < array.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < THREAD_COUNT; j++) {
                int idx = indices[j];
                if (idx < chunkEnds[j] && tempArray[idx] < minValue) 
                     {
                        minValue = tempArray[idx];
                        minIndex = j;
                    }
                
            }

            if (minIndex != -1) {
                array[i] = tempArray[indices[minIndex]];
                indices[minIndex]++;
            }
        }
    }





    static class ThreadSorting extends Thread{
    
        public final int array[];
        public final int start, end;


        ThreadSorting(int arr[], int s, int e){
            this.array =arr;
            this.start = s;
            this.end = e;
        }
    
    
        @Override
        public void run(){
            Arrays.sort(array, start, end);
        }
    
    } 


}


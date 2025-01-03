

public class Run200 {

    public static void main(String[] args) {
        
        double [] times = { 29.47, 27.25, 31.73, 27.22, 28.46, 33.51, 29.38, 29.65, 31.82, 26.96};

        
        InsertionSort ob = new InsertionSort();
        ob.sort_float(times);
        System.err.println(times[times.length - 2]);


    }
    
}

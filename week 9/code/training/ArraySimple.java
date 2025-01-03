package training;


import java.util.Arrays;

class ArraySimple {
    public static void main(String[] args) {
        double [] sales = {2.797, 1.656, 5.638, 0.923, 8.108, 3.048, 1.107, 0.007};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(sales));
        
        // sort array and re-display
        Arrays.sort(sales);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(sales));
    }
}

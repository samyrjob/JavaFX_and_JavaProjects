import java.io.*;
import java.util.ArrayList;

class Bubblesimulation {

    // An optimized version of Bubble Sort
    static void bubbleSort( ArrayList<Student> arraylist_student) {
        int i, j;
        boolean swapped;
        for (i = 0; i < arraylist_student.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < arraylist_student.size() - i - 1; j++) {
                if (arraylist_student.get(j).grade > arraylist_student.get(j+1).grade) {
                    // Swap arr[j] and arr[j+1]
                    Student temp = arraylist_student.get(j);
                    arraylist_student.set(j, arraylist_student.get(j+1));
                    arraylist_student.set(j+1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Function to print an array
    // static void printArray(int arr[], int size) {
    //     for (int i = 0; i < size; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.println(); // Print a new line after the array
    // }

    // // Driver program
    // public static void main(String args[]) {
    //     int arr[] = {64, 34, 25, 12, 22, 11, 90};
    //     int n = arr.length;
    //     bubbleSort(arr, n);
    //     System.out.println("Sorted array: ");
    //     printArray(arr, n);
    // }
}

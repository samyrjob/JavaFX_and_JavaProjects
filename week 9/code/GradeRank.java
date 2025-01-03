import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class  Student implements Comparable<Student> {

    int age;
    String name;
    char grade;

    public int compareTo(Student student){
        return this.grade - student.grade;
    }

    //constructor
    public Student(String n, int a, char gr)
    {
        this.name = n;
        this.grade = gr;
        this.age = a;
    }





}


public class GradeRank {

    public static void main(String[] args) {
        
        // Student student = new Student("samy", 25, 'A'); 
        // Student student2 = new Student("Milla", 28, 'B');
        // Student student3 = new Student("Mira", 21, 'C');
        // Student student4 = new Student("Sean", 20, 'D');
        // Student student5 = new Student("samuel", 22, 'B');

        ArrayList<Student> arraylist_of_students = new ArrayList<>();
        arraylist_of_students.add(new Student("samy", 25, 'D'));
        arraylist_of_students.add(new Student("Zilla", 28, 'A'));
        arraylist_of_students.add(new Student("Mira", 21, 'C'));
        arraylist_of_students.add(new Student("Sean", 20, 'B'));
        arraylist_of_students.add(new Student("samuel", 22, 'A'));
        arraylist_of_students.add(new Student("samir", 20, 'D'));
        arraylist_of_students.add(new Student("isabelle", 27, 'B'));
        arraylist_of_students.add(new Student("Rawan", 23, 'C'));
        arraylist_of_students.add(new Student("Patrick", 25, 'D'));
        arraylist_of_students.add(new Student("sam", 18, 'A'));
        arraylist_of_students.add(new Student("samantha", 23, 'D'));
        arraylist_of_students.add(new Student("robert", 18, 'A'));
        arraylist_of_students.add(new Student("John", 20, 'C'));
        arraylist_of_students.add(new Student("Mattheus", 20, 'B'));
        arraylist_of_students.add(new Student("Jones", 17, 'B'));

        // ArrayList<Student> arraylist_of_students_initial_saved = arraylist_of_students;
        ArrayList<Student> arraylist_of_students_initial_saved = new ArrayList<>(arraylist_of_students);
        


        
        long startime = System.nanoTime();
        Collections.sort(arraylist_of_students);
        long elapsedtime = System.nanoTime() - startime;

        for (Student student: arraylist_of_students)
        {
            System.out.println(student.age + " " +
                               student.name + " " +
                               student.grade);
        }
        System.out.println( "time taken in nano for via Collections.sort method : " +  elapsedtime);




        startime = System.nanoTime();
        Bubblesimulation.bubbleSort(arraylist_of_students_initial_saved);
        elapsedtime = System.nanoTime() - startime;

        for (Student student: arraylist_of_students_initial_saved)
        {
            System.out.println(student.age + " " +
                               student.name + " " +
                               student.grade);
        }


        System.out.println("time taken in nano for via bubble sorting : " + elapsedtime);



    }
    
}

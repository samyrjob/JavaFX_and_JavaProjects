import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class  Student {

    int age;
    String name;
    char grade;
    String faculty;

    // public int compareTo(Student student){
    //     return this.grade - student.grade;
    // }

    //constructor
    public Student(String n, int a, char gr, String f)
    {
        this.name = n;
        this.grade = gr;
        this.age = a;
        this.faculty = f;
    }


}


class CompareByFaculty implements Comparator<Student>{

    public int compare(Student c1, Student c2){


        int facultyComparison =  c1.faculty.compareTo(c2.faculty);
        if (facultyComparison ==0) {
            return c1.grade - c2.grade;
        }
        return facultyComparison;
    }
}



public class FacultyGradeRank {

    static CompareByFaculty compareByFaculty = new CompareByFaculty();

    public static void main(String[] args) {
        
        // Student student = new Student("samy", 25, 'A'); 
        // Student student2 = new Student("Milla", 28, 'B');
        // Student student3 = new Student("Mira", 21, 'C');
        // Student student4 = new Student("Sean", 20, 'D');
        // Student student5 = new Student("samuel", 22, 'B');

        ArrayList<Student> arraylist_of_students = new ArrayList<>();
        arraylist_of_students.add(new Student("samy", 25, 'D', "Health"));
        arraylist_of_students.add(new Student("Zilla", 28, 'A', "Arts"));
        arraylist_of_students.add(new Student("Mira", 21, 'C', "Business"));
        arraylist_of_students.add(new Student("Sean", 20, 'B', "Engineering"));
        arraylist_of_students.add(new Student("samuel", 22, 'A', "Science"));
        arraylist_of_students.add(new Student("samir", 20, 'D', "Education"));
        arraylist_of_students.add(new Student("isabelle", 27, 'B', "Law"));
        arraylist_of_students.add(new Student("Rawan", 23, 'C', "Science"));
        arraylist_of_students.add(new Student("Patrick", 25, 'D', "Arts"));
        arraylist_of_students.add(new Student("sam", 18, 'A', "Law"));
        arraylist_of_students.add(new Student("samantha", 23, 'D', "Science"));
        arraylist_of_students.add(new Student("robert", 18, 'A' , "Science"));
        arraylist_of_students.add(new Student("John", 20, 'C', "Business"));
        arraylist_of_students.add(new Student("Mattheus", 20, 'B', "Arts"));
        arraylist_of_students.add(new Student("Jones", 17, 'B', "Science"));

        // // ArrayList<Student> arraylist_of_students_initial_saved = arraylist_of_students;
        // ArrayList<Student> arraylist_of_students_initial_saved = new ArrayList<>(arraylist_of_students);
        


        
        System.out.println("Unsorted students : " );

         // Header
         System.out.printf("%-10s %-5s %-7s %-10s%n", "NAME", "AGE", "GRADE", "FACULTY");

        for (Student student: arraylist_of_students)
        {
            System.out.printf("%-10s %-5d %-7s %-10s%n", student.name,
                               student.age,
                               student.grade, student.faculty);
        }


        Collections.sort(arraylist_of_students, compareByFaculty);

             
        System.out.println("sorted students : " );


        
         // Header
         System.out.printf("%-10s %-5s %-7s %-10s%n", "NAME", "AGE", "GRADE", "FACULTY");


        for (Student student: arraylist_of_students)
        {
            System.out.printf("%-10s %-5d %-7s %-10s%n", student.name,
                               student.age,
                               student.grade, student.faculty);
        }


    }
    
}

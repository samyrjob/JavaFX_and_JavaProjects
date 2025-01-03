import java.util.Scanner;

public class FiveStudents {

      public static String result(Float mark) {
        if (mark >= 50) {
            return "Pass";
        }
        else {
            return "Fail";
        }
    }
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student 1\u0027s score:\n");
        float first = scanner.nextFloat();
        //scanner.nextLine();
        System.out.print("Enter student 2\u0027s score:\n");
        float second = scanner.nextFloat();
        //scanner.nextLine();
        System.out.print("Enter student 3\u0027s score:\n");
        float third = scanner.nextFloat();
        // scanner.nextLine();
        System.out.print("Enter student 4\u0027s score:\n");
        float fourth = scanner.nextFloat();

        System.out.print("Enter student 5\u0027s score:\n");
        float fifth = scanner.nextFloat();

        float average = (first + second + third + fourth + fifth) / 5;
        System.out.print("------------------------ \n" + "Student\t" + "Score\t" + "Pass/Fail" + "\n" );
        System.out.println("1\t" + first + "\t" + result(first));
        System.out.println("1\t" + second + "\t" + result(second));
        System.out.println("1\t" + third + "\t" + result(third));
        System.out.println("1\t" + fourth + "\t" + result(fourth));
        System.out.println("1\t" + fifth + "\t" + result(fifth));


        System.out.print("------------------------ \n" + "The average score is:\t" + average );

        scanner.close();
    }
}

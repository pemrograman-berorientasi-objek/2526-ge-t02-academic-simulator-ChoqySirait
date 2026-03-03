package academic.driver;

/**
 * @author 12S24012 - Choqy Pananda Sirait
 */
import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            // Asumsi input selalu valid sesuai format karena autograder
            String id = parts[0];
            String name = parts[1];
            String entryYear = parts[2];
            String major = parts[3];

            Student student = new Student(id, name, entryYear, major);
            students.add(student);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        input.close();
    }
}
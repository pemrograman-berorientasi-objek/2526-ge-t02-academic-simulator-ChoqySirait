package academic.driver;

/**
 * @author 12S24012 - Choqy Pananda Sirait
 */
import academic.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            // Asumsi input selalu valid sesuai format karena autograder
            String code = parts[0];
            String name = parts[1];
            int credits = Integer.parseInt(parts[2]);
            String grade = parts[3];

            Course course = new Course(code, name, credits, grade);
            courses.add(course);
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        input.close();
    }
}
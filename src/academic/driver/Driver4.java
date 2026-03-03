package academic.driver;

/**
 * @author 12S24012 - Choqy Pananda Sirait
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            String command = parts[0];
            
            // Asumsi input selalu valid sesuai format karena autograder
            if ("course-add".equals(command)) {
                String code = parts[1];
                String name = parts[2];
                int credits = Integer.parseInt(parts[3]);
                String grade = parts[4];
                courses.add(new Course(code, name, credits, grade));
            } 
            else if ("student-add".equals(command)) {
                String id = parts[1];
                String name = parts[2];
                String entryYear = parts[3];
                String major = parts[4];
                students.add(new Student(id, name, entryYear, major));
            } 
            else if ("enrollment-add".equals(command)) {
                String courseCode = parts[1];
                String studentId = parts[2];
                String academicYear = parts[3];
                String semester = parts[4];
                enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
            }
        }

        // Menampilkan semua entitas yang tersimpan sesuai urutan: Course, Student, Enrollment
        for (Course course : courses) {
            System.out.println(course);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close();
    }
}
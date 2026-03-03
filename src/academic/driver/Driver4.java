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

        System.out.println("Masukkan data (course-add#..., student-add#..., atau enrollment-add#...), ketik '---' untuk berhenti:");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Hentikan loop jika input adalah "---"
            }

            String[] parts = line.split("#");
            if (parts.length > 0) {
                String command = parts[0];
                
                // Menangani command "course-add"
                if ("course-add".equals(command)) {
                    if (parts.length == 5) { // command + 4 data = 5 parts
                        String code = parts[1];
                        String name = parts[2];
                        int credits = Integer.parseInt(parts[3]);
                        String grade = parts[4]; // Grade di sini adalah default grade untuk course itu sendiri
                        courses.add(new Course(code, name, credits, grade));
                    } else {
                        System.err.println("Format input 'course-add' tidak valid: " + line + ". Harap gunakan format command#Kode#Nama#Credits#Grade.");
                    }
                } 
                // Menangani command "student-add"
                else if ("student-add".equals(command)) {
                    if (parts.length == 5) { // command + 4 data = 5 parts
                        String id = parts[1];
                        String name = parts[2];
                        String entryYear = parts[3];
                        String major = parts[4];
                        students.add(new Student(id, name, entryYear, major));
                    } else {
                        System.err.println("Format input 'student-add' tidak valid: " + line + ". Harap gunakan format command#ID#Nama#TahunMasuk#Major.");
                    }
                } 
                // Menangani command "enrollment-add"
                else if ("enrollment-add".equals(command)) {
                    if (parts.length == 5) { // command + 4 data = 5 parts
                        String courseCode = parts[1];
                        String studentId = parts[2];
                        String academicYear = parts[3];
                        String semester = parts[4];
                        // Grade untuk enrollment diinisialisasi "None" di konstruktor Enrollment
                        enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                    } else {
                        System.err.println("Format input 'enrollment-add' tidak valid: " + line + ". Harap gunakan format command#KodeCourse#IDMahasiswa#TahunAkademik#Semester.");
                    }
                } else {
                    System.err.println("Perintah tidak dikenal: " + command + " pada baris: " + line);
                }
            } else {
                System.err.println("Format input kosong atau tidak valid: " + line);
            }
        }

        // Menampilkan semua entitas yang tersimpan sesuai urutan: Course, Student, Enrollment
        System.out.println("\n--- Hasil Akhir ---");

        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.println("\nStudents:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nEnrollments:");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close(); // Tutup scanner
    }
}
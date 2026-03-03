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
        List<Course> courses = new ArrayList<>(); // Menggunakan ArrayList untuk penyimpanan dinamis

        System.out.println("\nMasukkan data course (format: Kode#Nama#Credits#Grade), ketik '---' untuk berhenti:");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Hentikan loop jika input adalah "---"
            }

            // Memproses setiap baris masukan
            String[] parts = line.split("#");
            if (parts.length == 4) { // Memastikan format input sesuai
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]); // Konversi credits dari String ke int
                String grade = parts[3];

                Course course = new Course(code, name, credits, grade);
                courses.add(course); // Tambahkan objek Course ke dalam ArrayList
            } else {
                System.err.println("Format input tidak valid: " + line + ". Harap gunakan format Kode#Nama#Credits#Grade.");
            }
        }

        // Menampilkan semua courses yang tersimpan
        System.out.println("\nCourses yang tersimpan:");
        for (Course course : courses) {
            System.out.println(course); // Menggunakan method toString() dari kelas Course
            System.out.println("\n");
        }

        input.close(); // Tutup scanner untuk menghindari resource leak
    }
}
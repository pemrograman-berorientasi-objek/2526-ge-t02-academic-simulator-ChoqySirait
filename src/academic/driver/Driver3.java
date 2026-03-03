package academic.driver;

/**
 * @author 12S24012 - Choqy Pananda Sirait
 */
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Enrollment> enrollments = new ArrayList<>(); // Menggunakan ArrayList untuk penyimpanan dinamis

        System.out.println("Masukkan data pendaftaran (format: KodeCourse#IDMahasiswa#TahunAkademik#Semester), ketik '---' untuk berhenti:");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Hentikan loop jika input adalah "---"
            }

            // Memproses setiap baris masukan
            String[] parts = line.split("#");
            if (parts.length == 4) { // Memastikan format input sesuai
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(enrollment); // Tambahkan objek Enrollment ke dalam ArrayList
            } else {
                System.err.println("Format input tidak valid: " + line + ". Harap gunakan format KodeCourse#IDMahasiswa#TahunAkademik#Semester.");
            }
        }

        // Menampilkan semua pendaftaran yang tersimpan
        System.out.println("\nPendaftaran yang tersimpan:");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment); // Menggunakan method toString() dari kelas Enrollment
        }

        input.close(); // Tutup scanner untuk menghindari resource leak
    }
}
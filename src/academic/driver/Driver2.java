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
        List<Student> students = new ArrayList<>(); // Menggunakan ArrayList untuk penyimpanan dinamis

        System.out.println("\nMasukkan data mahasiswa (format: ID#Nama#TahunMasuk#Major), ketik '---' untuk berhenti:");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Hentikan loop jika input adalah "---"
            }

            // Memproses setiap baris masukan
            String[] parts = line.split("#");
            if (parts.length == 4) { // Memastikan format input sesuai
                String id = parts[0];
                String name = parts[1];
                String entryYear = parts[2]; // Tahun masuk sebagai String
                String major = parts[3];

                Student student = new Student(id, name, entryYear, major);
                students.add(student); // Tambahkan objek Student ke dalam ArrayList
            } else {
                System.err.println("Format input tidak valid: " + line + ". Harap gunakan format ID#Nama#TahunMasuk#Major.");
            }
        }

        // Menampilkan semua mahasiswa yang tersimpan
        System.out.println("\nMahasiswa yang tersimpan:");
        for (Student student : students) {
            System.out.println(student); // Menggunakan method toString() dari kelas Student
            System.out.println("\n");
        }


        input.close(); // Tutup scanner untuk menghindari resource leak
    }
}
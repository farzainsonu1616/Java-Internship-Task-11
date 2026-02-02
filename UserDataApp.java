import java.io.*;
import java.util.Scanner;

public class UserDataApp {

    private static final String FILE_PATH = "data/users.txt";

    // Method to store user data (Append mode)
    static void saveUserData(String name, String email, String phone) {
        File file = new File(FILE_PATH);

        try {
            // Create file if it does not exist
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true); // append mode
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Email: " + email);
            bw.newLine();
            bw.write("Phone: " + phone);
            bw.newLine();
            bw.write("----------------------");
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("User data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    // Method to read stored user data
    static void readUserData() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No user data file found.");
            return;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n--- Stored User Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---- User Data Storage System ----");

        System.out.print("Enter Name  : ");
        String name = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Phone : ");
        String phone = sc.nextLine();

        saveUserData(name, email, phone);
        readUserData();

        sc.close();
    }
}

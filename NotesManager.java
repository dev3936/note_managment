import java.io.*;
import java.util.Scanner;

public class NotesManager {
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Write a note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void writeNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    private static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- All Notes ---");
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("No notes found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes file found. Please add a note first.");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}

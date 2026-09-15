
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public List<Assignment> loadAssignments() {

        List<Assignment> assignments = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists()) {
            return assignments;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length == 6) {

                    Assignment assignment = new Assignment(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            LocalDate.parse(parts[3]),
                            parts[4],
                            Boolean.parseBoolean(parts[5])
                    );

                    assignments.add(assignment);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading assignment data: "
                            + e.getMessage()
            );
        }

        return assignments;
    }

    public void saveAssignments(List<Assignment> assignments) {

        File file = new File(fileName);

        File parent = file.getParentFile();

        if (parent != null) {
            parent.mkdirs();
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file))) {

            for (Assignment assignment : assignments) {

                writer.write(assignment.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving assignment data: "
                            + e.getMessage()
            );
        }
    }
}

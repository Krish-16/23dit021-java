import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentAttendance {
    int[] totalLectures = new int[5];
    int[] attendance = new int[5];
}

public class AttendanceSystem {
    private static final int NUM_SUBJECTS = 5;
    private static final String[] subjects = {"Java", "DBMS", "Maths", "CPI", "DSA"};
    private static final String filename = "attendance_data.txt";
    private static Map<Integer, StudentAttendance> attendanceMap = new HashMap<>();
    private static int[] totalLectures = new int[NUM_SUBJECTS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        loadAttendanceData();

        if (!areTotalLecturesSet()) {
            inputTotalLectures(scanner);
        }

        int choice;

        do {
            System.out.println();
            System.out.println("Student Attendance System");
            System.out.println("-------------------------");
            System.out.println("1. Input attendance for a roll number");
            System.out.println("2. Display attendance for a roll number");
            System.out.println("3. Update total number of lectures for a subject");
            System.out.println("4. Predict attendance if a student misses lectures");
            System.out.println("5. Clear screen");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number of the student: ");
                    int rollNumber = scanner.nextInt();
                    inputAttendance(rollNumber, scanner);
                    break;
                case 2:
                    System.out.print("Enter roll number of the student to display attendance: ");
                    rollNumber = scanner.nextInt();
                    displayAttendance(rollNumber);
                    break;
                case 3:
                    updateTotalLectures(scanner);
                    break;
                case 4:
                    System.out.print("Enter roll number of the student to predict attendance: ");
                    rollNumber = scanner.nextInt();
                    predictAttendanceIfMissesLectures(rollNumber, scanner);
                    break;
                case 5:
                    clearScreen();
                    break;
                case 6:
                    saveAttendanceData();
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing the screen.");
        }
    }

    private static boolean areTotalLecturesSet() {
        for (int lectures : totalLectures) {
            if (lectures == 0) {
                return false;
            }
        }
        return true;
    }

    private static void inputTotalLectures(Scanner scanner) {
        for (int i = 0; i < NUM_SUBJECTS; ++i) {
            System.out.print("Enter total number of lectures conducted for " + subjects[i] + ": ");
            totalLectures[i] = scanner.nextInt();
        }
    }

    private static void inputAttendance(int rollNumber, Scanner scanner) {
        StudentAttendance student;
        if (!attendanceMap.containsKey(rollNumber)) {
            student = new StudentAttendance();
            for (int i = 0; i < NUM_SUBJECTS; ++i) {
                student.totalLectures[i] = totalLectures[i];
            }
            attendanceMap.put(rollNumber, student);
        } else {
            student = attendanceMap.get(rollNumber);
        }

        for (int i = 0; i < NUM_SUBJECTS; ++i) {
            System.out.print("Enter number of lectures attended for " + subjects[i] + " (current: " + student.attendance[i] + "): ");
            student.attendance[i] = scanner.nextInt();
        }
    }

    private static void displayAttendance(int rollNumber) {
        if (attendanceMap.containsKey(rollNumber)) {
            StudentAttendance student = attendanceMap.get(rollNumber);

            System.out.println("Attendance Record (Percentage) for Roll Number " + rollNumber);
            System.out.println("------------------------------");

            double totalAttendance = 0.0;
            double totalPossibleAttendance = 0.0;

            for (int i = 0; i < NUM_SUBJECTS; ++i) {
                double attendancePercentage = ((double) student.attendance[i] / student.totalLectures[i]) * 100.0;
                System.out.printf("%-10s: %.2f%%%n", subjects[i], attendancePercentage);
                totalAttendance += student.attendance[i];
                totalPossibleAttendance += student.totalLectures[i];
            }

            if (totalPossibleAttendance > 0) {
                double overallPercentage = (totalAttendance / totalPossibleAttendance) * 100.0;
                System.out.println("------------------------------");
                System.out.printf("Overall Attendance: %.2f%%%n", overallPercentage);
            }
        } else {
            System.out.println("Roll number not found in the system.");
        }
    }

    private static void updateTotalLectures(Scanner scanner) {
        System.out.println("Select subject to update total lectures:");
        for (int i = 0; i < NUM_SUBJECTS; ++i) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }
        int subjectChoice = scanner.nextInt() - 1;

        if (subjectChoice >= 0 && subjectChoice < NUM_SUBJECTS) {
            System.out.print("Enter number of new lectures conducted for " + subjects[subjectChoice] + ": ");
            int newLectures = scanner.nextInt();
            totalLectures[subjectChoice] += newLectures;

            // Ask which roll numbers were present in the new lectures
            for (int lecture = 0; lecture < newLectures; lecture++) {
                System.out.print("Enter number of students present for lecture " + (lecture + 1) + ": ");
                int numPresent = scanner.nextInt();
                System.out.println("Enter roll numbers of students present for lecture " + (lecture + 1) + ":");

                for (int i = 0; i < numPresent; i++) {
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    if (attendanceMap.containsKey(rollNumber)) {
                        attendanceMap.get(rollNumber).attendance[subjectChoice]++;
                    } else {
                        StudentAttendance student = new StudentAttendance();
                        student.totalLectures = totalLectures.clone();
                        student.attendance[subjectChoice] = 1;
                        attendanceMap.put(rollNumber, student);
                    }
                }
            }
        } else {
            System.out.println("Invalid subject choice.");
        }
    }

    private static void predictAttendanceIfMissesLectures(int rollNumber, Scanner scanner) {
        if (attendanceMap.containsKey(rollNumber)) {
            StudentAttendance student = attendanceMap.get(rollNumber);

            System.out.print("Enter the number of lectures the student will miss: ");
            int numMisses = scanner.nextInt();

            int[] missedLectures = new int[NUM_SUBJECTS];
            for (int i = 0; i < numMisses; i++) {
                System.out.println("Select subject for missed lecture " + (i + 1) + ":");
                for (int j = 0; j < NUM_SUBJECTS; ++j) {
                    System.out.println((j + 1) + ". " + subjects[j]);
                }
                int subjectChoice = scanner.nextInt() - 1;
                if (subjectChoice >= 0 && subjectChoice < NUM_SUBJECTS) {
                    missedLectures[subjectChoice]++;
                } else {
                    System.out.println("Invalid subject choice.");
                    i--;
                }
            }

            double totalAttendance = 0.0;
            double totalPossibleAttendance = 0.0;
            double totalPredictedAttendance = 0.0;

            for (int i = 0; i < NUM_SUBJECTS; ++i) {
                int newTotalLecturesForSubject = student.totalLectures[i] + missedLectures[i];
                int attendanceForSubject = student.attendance[i];

                totalPossibleAttendance += newTotalLecturesForSubject;
                totalPredictedAttendance += attendanceForSubject;
                totalAttendance += student.attendance[i];
            }

            double overallPredictedPercentage = (totalPredictedAttendance / totalPossibleAttendance) * 100.0;

            System.out.println("Predicted Attendance if student misses the selected lectures:");
            System.out.printf("%-10s: %.2f%%%n", "Overall", overallPredictedPercentage);
        } else {
            System.out.println("Roll number not found in the system.");
        }
    }

    private static void saveAttendanceData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int lectures : totalLectures) {
                writer.write(lectures + " ");
            }
            writer.newLine();
            for (Map.Entry<Integer, StudentAttendance> entry : attendanceMap.entrySet()) {
                int rollNumber = entry.getKey();
                StudentAttendance student = entry.getValue();
                writer.write(rollNumber + " ");
                for (int i = 0; i < NUM_SUBJECTS; ++i) {
                    writer.write(student.totalLectures[i] + " " + student.attendance[i] + " ");
                }
                writer.newLine();
            }
            System.out.println("Attendance data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for saving attendance data.");
        }
    }

    private static void loadAttendanceData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            if ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                for (int i = 0; i < NUM_SUBJECTS; ++i) {
                    totalLectures[i] = scanner.nextInt();
                }
                scanner.close();
            }
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                int rollNumber = scanner.nextInt();
                StudentAttendance student = new StudentAttendance();
                for (int i = 0; i < NUM_SUBJECTS; ++i) {
                    student.totalLectures[i] = scanner.nextInt();
                    student.attendance[i] = scanner.nextInt();
                }
                attendanceMap.put(rollNumber, student);
                scanner.close();
            }
            System.out.println("Attendance data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for loading attendance data.");
        }
    }
}

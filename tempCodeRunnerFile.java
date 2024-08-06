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
            System.out.println("4. Exit");
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
                    saveAttendanceData();
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
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
            System.out.print("Enter new total number of lectures for " + subjects[subjectChoice] + ": ");
            totalLectures[subjectChoice] = scanner.nextInt();

            // Ask which roll numbers were present in that specific lecture
            System.out.print("Enter number of students present for this lecture: ");
            int numPresent = scanner.nextInt();
            System.out.println("Enter roll numbers of students present:");

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
        } else {
            System.out.println("Invalid subject choice.");
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

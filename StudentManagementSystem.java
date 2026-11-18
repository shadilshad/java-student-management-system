import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final Map<Integer, Student> students = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (students.containsKey(id)) {
                System.out.println("A student with this ID already exists.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter department: ");
            String department = scanner.nextLine().trim();

            if (name.isEmpty() || department.isEmpty()) {
                System.out.println("Name and department cannot be empty.");
                return;
            }

            students.put(id, new Student(id, name, department));
            System.out.println("Student added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a whole number.");
        }
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- STUDENT RECORDS ---");
        for (Student student : students.values()) {
            student.display();
        }
    }

    private static void searchStudent() {
        try {
            System.out.print("Enter student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Student student = students.get(id);
            if (student == null) {
                System.out.println("Student not found.");
            } else {
                student.display();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a whole number.");
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Student student = students.get(id);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter new name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter new department: ");
            String department = scanner.nextLine().trim();

            if (name.isEmpty() || department.isEmpty()) {
                System.out.println("Name and department cannot be empty.");
                return;
            }

            student.setName(name);
            student.setDepartment(department);
            System.out.println("Student record updated successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a whole number.");
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Student removed = students.remove(id);
            if (removed == null) {
                System.out.println("Student not found.");
            } else {
                System.out.println("Student deleted successfully.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a whole number.");
        }
    }

    private static void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Thank you for using the Student Management System.");
                        break;
                    default:
                        System.out.println("Please choose a number from 1 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }

        scanner.close();
    }
}

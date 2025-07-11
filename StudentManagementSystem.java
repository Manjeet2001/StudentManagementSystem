
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Student {
    private static Long idCounter = 101L;
    private Long id;
    private String name;
    private double marks;
    private int age;

    public Student(String name, double marks, int age){
        this.id = idCounter++;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getMarks(){
        return marks;
    }

    public void setMarks(double marks){
        this.marks = marks;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Age: " + age);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    int choice = -1;

    while (choice != 5) {
        System.out.println("\n**** Student Record Management System ****");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        try {
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please select choice between 1 to 5.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
        }
    }
}

    public static void addStudent(){
        sc.nextLine();

        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter marks: ");
        double marks = sc.nextDouble();

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        students.add(new Student(name, marks, age));
        System.out.println("Student added successfully. ");
    }

    public static  void viewStudents(){
        if(students.isEmpty()) System.out.println("No Students to display");

        else{
            for(Student s: students){
                s.display();
            }
        }
    }

    public static void updateStudent(){
        System.out.println("Enter student Id to Update: ");
        Long id = sc.nextLong();
        boolean found = false;

        for(Student s : students){
            if(s.getId() == id){
                sc.nextLine();
                System.out.println("Enter new name: ");
                String name = sc.nextLine();

                System.out.println("Enter new marks: ");
                double marks = sc.nextDouble();

                System.out.println("Enter new age: ");
                int age = sc.nextInt();

                s.setName(name);
                s.setMarks(marks);
                s.setAge(age);
                System.out.println("Student Updated successfully");
                found = true;
                break;
            }
            
        }
        if(!found){
            System.out.println("No Student with matching Id: " + id);
        }
    }


    public static void deleteStudent(){
        System.out.println("Enter Student id to be Deleted: ");
        Long id = sc.nextLong();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if(removed) System.out.println("Student removed successfully");
        else{
            System.out.println("Student with Id: " + id + "not found");
        }
    }
    
}
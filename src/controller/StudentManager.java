package controller;

import Storage.ReadWriteFile;
import model.Student;
import views.Client;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class StudentManager {
    private static StudentManager instance;
    private final List<Student> students;
    private final ReadWriteFile readWriteFile = new ReadWriteFile();

    private StudentManager() {
        this.students = readWriteFile.readToFileStudent();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }


    public double checkDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ban nhap loi, moi ban nha lai: ");
        }
        return -1;
    }

    public int checkInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ban nhap loi, moi ban nhap lai: ");
        }
        return -1;
    }

    public void display() {
        System.out.println(students);
    }

    public void addElement(Student student) {
        students.add(student);
        readWriteFile.writeToFileStudent(students);
    }

    public void editStudent(Scanner scanner) {
        String newName;
        int newAge;
        String newSex;
        String newAdress;
        double newMediumScore;

        System.out.println("Moi ban nhap id can tim: ");
        String id = scanner.nextLine();
        for (Student s :
                students) {
            if (id.equalsIgnoreCase(s.getId())){
                System.out.println("moi ban nhap ten: ");
                newName = scanner.nextLine();
                System.out.println("moi ban nhap tuoi");
                newAge = checkInt(scanner);
                System.out.println("Moi ban nhap gioi tinh");
                newSex = scanner.nextLine();
                System.out.println("Moi ban nhap dia chi");
                newAdress = scanner.nextLine();
                System.out.println("Moi ban nhap diem trung binh");
                newMediumScore = checkDouble(scanner);
                s.setName(newName);
                s.setAge(newAge);
                s.setSex(newSex);
                s.setAddress(newAdress);
                s.setMediumScore(newMediumScore);
            }
            else {
                System.out.println("Khong tim thay hoc sinh co id can tim");
            }
        }
        readWriteFile.writeToFileStudent(students);
    }
    public void deleteToStudent(Scanner scanner){
        System.out.println("Moi ban nhap id hoc sinh can xoa");
        String id = scanner.nextLine();
        for (Student s:
             students) {
            if (id.equalsIgnoreCase(s.getId())){
                students.remove(s);
            }
        }
    }
    public void sortStudentById() {
        sortStudents();
    }
    private void sortStudents() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (Integer.parseInt(o1.getId())) - (Integer.parseInt(o2.getId()));
            }

        });
    }
}

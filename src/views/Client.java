package views;

import Storage.ReadWriteFile;
import controller.StudentManager;
import model.Student;

import java.util.Scanner;

public class Client {
    public static StudentManager studentManager = StudentManager.getInstance();

    public static Scanner scanner = new Scanner(System.in);
    public static int inPut = -1;

    public static void main(String[] args) {
        menu();
    }

    public static Student addToStudent() {
        System.out.println("Moi ban nhap ma sinh vien: ");
        String id = scanner.nextLine();
        System.out.println("Moi ban nhap ten sinh vien: ");
        String name = scanner.nextLine();
        System.out.println("Moi ban nhap tuoi sinh vien: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Moi ban nhap gioi tinh sinh vien: ");
        String sex = scanner.nextLine();
        System.out.println("Moi ban nhap dia chi sinh vien: ");
        String address = scanner.nextLine();
        System.out.println("Moi ban nhap diem trung binh sinh vien: ");
        double mediumScore = Double.parseDouble(scanner.nextLine());
        return new Student(id, name, age, sex, address, mediumScore);
    }

    public static void menu() {
        while (inPut != 0) {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN---");
            System.out.println("Chọn chức năng theo số(để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            inPut = studentManager.checkInt(scanner);
            switch (inPut) {
                case 2:
                    studentManager.addElement(addToStudent());
                case 1:
                    studentManager.display();
                case 3:
                    studentManager.editStudent(scanner);
                case 4:
                    studentManager.deleteToStudent(scanner);
                case 5:
                    studentManager.sortStudentById();
                case 6:
                    default:
                    System.out.println("ban nhap loi, moi ban nhap lai");
            }
        }
    }
}

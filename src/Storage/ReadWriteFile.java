package Storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteFile {
    public void writeToFileStudent(List<Student> students) {
        File file = new File("student.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> readToFileStudent() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("student.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                List<Student> students;
                try {
                    students = (List<Student>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                }
                return students;
            } else {
                return new ArrayList<>();
            }
        }
    }
}

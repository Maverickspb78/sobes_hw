package HW5;

import java.util.Random;

public class TestApp {
    public static void main(String[] args) {
        Random random = new Random();
        StudentDao dao = StudentDao.getInstance();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student("name" + i, (random.nextInt(4)+2));
            dao.addStudent(student);
        }
        System.out.println(dao.getStudentById(57L));
        Student student1 = dao.getStudentById(100L);
        student1.setName("Batman");
        dao.updateStudent(student1);
        System.out.println(dao.getStudentById(100L));
        dao.deleteStudent(dao.getStudentById(1L));
        dao.getAllStudents().forEach(System.out::println);
    }
}

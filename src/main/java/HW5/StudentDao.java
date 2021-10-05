package HW5;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentDao {
    private static StudentDao studentDao;
    private EntityManager em;


    private StudentDao() {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        em = factory.createEntityManager();
    }

    public static StudentDao getInstance() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }

    public void addStudent(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    public Student getStudentById(Long id) {
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.getTransaction().commit();
        return student;
    }

    public void updateStudent(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    public List<Student> getAllStudents() {
        em.getTransaction().begin();
        List<Student> studentList = em.createQuery(
                "SELECT a FROM Student a", Student.class)
                .getResultList();
        em.getTransaction().commit();
        return studentList;
    }
}
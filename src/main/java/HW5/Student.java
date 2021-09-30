package HW5;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
            sequenceName = "SEQ_STUDENT",
            allocationSize = 5)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

}
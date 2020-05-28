import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class LinkedPurchaseListId implements Serializable
{
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    LinkedPurchaseListId(){}

    public LinkedPurchaseListId(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }
}


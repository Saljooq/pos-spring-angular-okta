package pos.backend.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@IdClass(CompositeKey.class)
public class Course {
    @Id
    private String dept;
    @Id
    private String course_num;
    private String title;
    private String num_credits;
    private String semesters_offered;
    private String requirement;
    private String description;

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCourse_num() {
        return this.course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum_credits() {
        return this.num_credits;
    }

    public void setNum_credits(String num_credits) {
        this.num_credits = num_credits;
    }

    public String getSemesters_offered() {
        return this.semesters_offered;
    }

    public void setSemesters_offered(String semesters_offered) {
        this.semesters_offered = semesters_offered;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

class CompositeKey implements Serializable {
    public String dept;
    public String course_num;
}
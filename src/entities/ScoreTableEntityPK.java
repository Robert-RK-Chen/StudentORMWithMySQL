package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
public class ScoreTableEntityPK implements Serializable
{
    private String studentId;
    private String courseNo;
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "studentID")
    @Id
    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    @Column(name = "courseNo")
    @Id
    public String getCourseNo()
    {
        return courseNo;
    }

    public void setCourseNo(String courseNo)
    {
        this.courseNo = courseNo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ScoreTableEntityPK that = (ScoreTableEntityPK) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseNo, that.courseNo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId, courseNo);
    }
}

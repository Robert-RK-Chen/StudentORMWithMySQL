package entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
@Entity
@Table(name = "score_table", schema = "studentorm")
@IdClass(ScoreTableEntityPK.class)
public class ScoreTableEntity implements Serializable
{
    private String studentId;
    private String courseNo;
    private Integer score;
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "studentID")
    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "courseNo")
    public String getCourseNo()
    {
        return courseNo;
    }

    public void setCourseNo(String courseNo)
    {
        this.courseNo = courseNo;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
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
        ScoreTableEntity that = (ScoreTableEntity) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseNo, that.courseNo) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId, courseNo, score);
    }
}

package entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
@Entity
@Table(name = "course_table", schema = "studentorm")
public class CourseTableEntity
{
    private String courseNo;
    private String courseName;
    private int courseTime;
    private int courseCredit;

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
    @Column(name = "courseName")
    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "courseTime")
    public int getCourseTime()
    {
        return courseTime;
    }

    public void setCourseTime(int courseTime)
    {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "courseCredit")
    public int getCourseCredit()
    {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit)
    {
        this.courseCredit = courseCredit;
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
        CourseTableEntity that = (CourseTableEntity) o;
        return courseTime == that.courseTime && courseCredit == that.courseCredit && Objects.equals(courseNo, that.courseNo) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(courseNo, courseName, courseTime, courseCredit);
    }
}

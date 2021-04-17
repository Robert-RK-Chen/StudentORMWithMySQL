package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
@Entity
@Table(name = "student_table", schema = "studentorm")
public class StudentTableEntity
{
    private String studentId;
    private String studentName;
    private String gender;
    private Date birthday;

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

    @Basic
    @Column(name = "studentName")
    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
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
        StudentTableEntity that = (StudentTableEntity) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(studentName, that.studentName) && Objects.equals(gender, that.gender) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId, studentName, gender, birthday);
    }
}

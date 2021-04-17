package entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
@Entity
@Table(name = "class_table", schema = "studentorm")
public class ClassTableEntity
{
    private String classNo;
    private String className;
    private Set<StudentTableEntity> students;

    public Set<StudentTableEntity> getStudents()
    {
        return students;
    }

    public void setStudents(Set<StudentTableEntity> students)
    {
        this.students = students;
    }

    @Id
    @Column(name = "classNo")
    public String getClassNo()
    {
        return classNo;
    }

    public void setClassNo(String classNo)
    {
        this.classNo = classNo;
    }

    @Basic
    @Column(name = "className")
    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
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
        ClassTableEntity that = (ClassTableEntity) o;
        return Objects.equals(classNo, that.classNo) && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(classNo, className);
    }
}

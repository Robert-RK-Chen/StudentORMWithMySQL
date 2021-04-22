package client;

import entities.ClassTableEntity;
import entities.CourseTableEntity;
import entities.ScoreTableEntity;
import entities.StudentTableEntity;
import model.ClassModel;
import model.CourseModel;
import model.ScoreModel;
import model.StudentModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Robert Chen
 * @date 2021-04-17
 * @ TODO: 2021-04-19 修改Client使其适应所有Model而非单一学生
 */
public class Client
{
    public static void findAllStudent()
    {
        StudentModel studentModel = new StudentModel();
        List<StudentTableEntity> studentList = studentModel.findAll();
        for (StudentTableEntity ste : studentList)
        {
            System.out.println(ste.toString());
        }
    }

    public static void insertStudent()
    {
        Scanner scanner = new Scanner(System.in);
        ClassModel classModel = new ClassModel();
        StudentModel studentModel = new StudentModel();

        System.out.print("\n请输入学生学号：");
        String studentId = scanner.next();
        if (studentModel.findById(studentId) != null)
        {
            System.out.println("学号重复！");
        }
        else
        {
            System.out.print("请输入学生姓名：");
            String studentName = scanner.next();
            System.out.print("请输入学生性别：");
            String gender = scanner.next();
            System.out.print("请输入学生的生日（XXXX-XX-XX）：");
            String birthday = scanner.next();
            System.out.print("请输入学生的班级：");
            String classNo = scanner.next();

            ClassTableEntity cte = classModel.findById(classNo);
            StudentTableEntity ste = new StudentTableEntity();
            ste.setStudentId(studentId);
            ste.setStudentName(studentName);
            ste.setGender(gender);
            ste.setBirthday(Date.valueOf(birthday));
            ste.setStudentClass(cte);
            studentModel.insert(ste);
            System.out.println("已增加学生：" + studentName);
        }
    }

    public static void findStudentInClass()
    {
        Scanner scanner = new Scanner(System.in);
        ClassModel classModel = new ClassModel();

        System.out.print("\n你想查询哪一个班级的全部学生：");
        String classNo = scanner.next();
        ClassTableEntity cte = classModel.findById(classNo);
        Set<StudentTableEntity> studentsInClass = cte.getStudents();
        if (studentsInClass.isEmpty())
        {
            System.out.println("这个班级暂时没有学生。");
        }
        else
        {
            System.out.println(classNo + " 班的全部学生：");
            for (StudentTableEntity temp : studentsInClass)
            {
                System.out.println(temp.getStudentName());
            }
        }
    }

    public static void findStudentInCourse()
    {
        Scanner scanner = new Scanner(System.in);
        CourseModel courseModel = new CourseModel();

        System.out.print("\n你想查询哪一门课的全部学生：");
        String courseNo = scanner.next();

        CourseTableEntity courseTe = courseModel.findById(courseNo);
        Set<StudentTableEntity> studentsInCourse = courseTe.getStudents();
        if (studentsInCourse.isEmpty())
        {
            System.out.println("这门课暂时没有学生选修。");
        }
        else
        {
            System.out.println("选修了 " + courseTe.getCourseName() + " 的全部学生：");
            for (StudentTableEntity temp : studentsInCourse)
            {
                System.out.println(temp.getStudentName());
            }
        }
    }

    public static void getCourseScoreOfStudent()
    {
        Scanner scanner = new Scanner(System.in);
        ScoreModel scoreModel = new ScoreModel();
        ScoreTableEntity scoreTableEntity = new ScoreTableEntity();

        System.out.print("\n请输入你想查询成绩的学生学号：");
        String studentId = scanner.next();
        scoreTableEntity.setStudentId(studentId);
        System.out.print("\n请输入课程编号：");
        String courseId = scanner.next();
        scoreTableEntity.setCourseNo(courseId);
        scoreTableEntity = scoreModel.findById(scoreTableEntity);
        if (scoreTableEntity == null)
        {
            System.out.println("该学生没有选修这门课！");
        }
        else
        {
            System.out.println(studentId + ": " + scoreTableEntity.getCourseNo() + ", " + scoreTableEntity.getScore());
        }
    }

    public static void getCourseOfStudent()
    {
        Scanner scanner = new Scanner(System.in);
        StudentModel studentModel = new StudentModel();

        System.out.print("\n你想查询哪位学生的全部课程：");
        String studentId = scanner.next();
        StudentTableEntity student = studentModel.findById(studentId);
        Set<CourseTableEntity> courses = student.getCourses();
        if (courses.isEmpty())
        {
            System.out.println("这位学生还没有选课！");
        }
        else
        {
            System.out.println(student.getStudentName() + "选修了以下课程：");
            for (CourseTableEntity temp : courses)
            {
                System.out.println(temp.getCourseName());
            }
        }
    }

    public static void deleteStudent()
    {
        Scanner scanner = new Scanner(System.in);
        StudentModel studentModel = new StudentModel();

        System.out.print("\n请输入你想删除学生的学号：");
        String studentId = scanner.next();
        StudentTableEntity ste = studentModel.findById("201401004");
        if (ste == null)
        {
            System.out.println("数据库中没有该学生的信息！");
        }
        else
        {
            studentModel.delete(ste);
            System.out.println("已删除 " + studentId + ", " + ste.getStudentName());
        }
    }

    public static void updateStudent()
    {
        Scanner scanner = new Scanner(System.in);
        StudentModel studentModel = new StudentModel();

        System.out.print("\n你想修改哪位学生的信息：");
        String studentId = scanner.next();
        StudentTableEntity ste = studentModel.findById(studentId);
        if (ste == null)
        {
            System.out.println("数据库中没有该学生的信息！");
        }
        else
        {
            // 例如修改姓名
            System.out.print("请输入新的学生姓名：");
            String information = scanner.next();
            ste.setStudentName(information);
            studentModel.update(ste);
            System.out.println("更新学生姓名成功！");
        }
    }

    public static void main(String[] args)
    {
        // 显示原数据库中的学生信息
        System.out.println("学生表（原）：");
        findAllStudent();

        // 增加一条学生信息
        insertStudent();

        // 显示插入数据后数据库中的学生信息
        System.out.println("\n学生表（新）：");
        findAllStudent();

        // 查询某一班级的全部学生（验证一对多)
        findStudentInClass();

        // 查询某门课的全部学生（验证多对多）
        findStudentInCourse();

        // 查询某位学生选的所有课（验证多对多）
        getCourseOfStudent();

        // 查询某位学生选的所有课的所有成绩（验证连接）
        getCourseScoreOfStudent();

        // 更新某位学生的信息（验证改）
        updateStudent();

        // 删除某位学生的信息（验证删除）
        deleteStudent();

        findAllStudent();
    }
}

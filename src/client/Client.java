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

    /**
     * @ TODO: 2021-04-17 该功能暂时存在问题
     */
    public static void getCourseScoreOfStudent()
    {
        Scanner scanner = new Scanner(System.in);
        StudentModel studentModel = new StudentModel();
        ScoreModel scoreModel = new ScoreModel();

        System.out.print("\n你想查询哪位学生的全部成绩：");
        String studentId = scanner.next();
        StudentTableEntity student = studentModel.findById(studentId);
        Set<CourseTableEntity> courses = student.getCourses();
        Set<ScoreTableEntity> scores = null;
        if (courses.isEmpty())
        {
            System.out.println("这位学生还没有选课！");
        }
        else
        {
            for (CourseTableEntity temp : courses)
            {
                String courseNo = temp.getCourseNo();
                scores.add(scoreModel.findById(courseNo));
            }
            System.out.println(student.getStudentName() + " 的全部成绩：\n" + scores);
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

        // 查询某一班级的全部学生（验证一对多
        findStudentInClass();

        // 查询某门课的全部学生（验证多对多）
        findStudentInCourse();

        // 查询某位学生选的所有课（验证多对多）
        getCourseScoreOfStudent();
        
        /*
          增删改查已完成：增、查
          @// TODO: 2021-04-17 完成删除、更新操作
        */

        getCourseOfStudent();
    }
}

package client;

import entities.StudentTableEntity;
import model.StudentModel;

/**
 * @author Robert Chen
 */
public class Client
{
    public static void main(String[] args)
    {
        StudentModel studentModel = new StudentModel();
        StudentTableEntity ste = studentModel.findById("201401001");
        System.out.println("学号：" + ste.getStudentId());
        System.out.println("姓名：" + ste.getStudentName());
        System.out.println("性别：" + ste.getGender());
        System.out.println("生日：" + ste.getBirthday());
    }
}

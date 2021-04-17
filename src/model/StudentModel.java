package model;

import abstractModel.AbstractModel;
import entities.StudentTableEntity;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
public class StudentModel extends AbstractModel<StudentTableEntity>
{
    public StudentModel()
    {
        super(StudentTableEntity.class);
    }
}

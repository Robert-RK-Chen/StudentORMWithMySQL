package model;

import abstractModel.AbstractModel;
import entities.CourseTableEntity;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
public class CourseModel extends AbstractModel<CourseTableEntity>
{
    public CourseModel()
    {
        super(CourseTableEntity.class);
    }
}

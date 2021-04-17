package model;

import abstractModel.AbstractModel;
import entities.ClassTableEntity;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
public class ClassModel extends AbstractModel<ClassTableEntity>
{
    public ClassModel()
    {
        super(ClassTableEntity.class);
    }
}
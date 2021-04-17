package model;

import abstractModel.AbstractModel;
import entities.ScoreTableEntity;

/**
 * @author Robert Chen
 * @date 2021-04-17
 */
public class ScoreModel extends AbstractModel<ScoreTableEntity>
{
    public ScoreModel()
    {
        super(ScoreTableEntity.class);
    }
}

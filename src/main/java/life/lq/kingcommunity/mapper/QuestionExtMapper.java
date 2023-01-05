package life.lq.kingcommunity.mapper;

import life.lq.kingcommunity.model.Question;
import life.lq.kingcommunity.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question question);
}
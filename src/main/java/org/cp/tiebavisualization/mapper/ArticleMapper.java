package org.cp.tiebavisualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cp.tiebavisualization.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Article findByTid(@Param("tid") Long tid);

    int insertBatch(@Param("list") List<Article> list);
}

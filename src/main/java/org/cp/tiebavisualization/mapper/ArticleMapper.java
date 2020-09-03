package org.cp.tiebavisualization.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cp.tiebavisualization.pojo.Article;

import java.util.List;


@Mapper
public interface ArticleMapper{

    Article findByTid(@Param("tid") long tid);

    int insertBatch(@Param("list") List<Article> list);
}

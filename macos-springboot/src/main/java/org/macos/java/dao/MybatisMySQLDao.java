package org.macos.java.dao;


import org.apache.ibatis.annotations.Mapper;
import org.macos.java.dao.beans.ArticleLabel;
import org.macos.java.dao.beans.JobAddress;
import org.macos.java.dao.beans.LabelTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MybatisMySQLDao {
    List<JobAddress> getAll();
    void save(Object obj);
    void saveList(List<ArticleLabel> list);
    void delById(String articleId);

    void aggQpsHistory(String yesterday);

    List<LabelTest> getDash();
//    List<LabelTest> getDashIn(List<String> filter);
    List<LabelTest> getDashIn(Map<String, Object> map) ;
}


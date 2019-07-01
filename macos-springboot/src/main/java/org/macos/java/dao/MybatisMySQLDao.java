package org.macos.java.dao;


import org.apache.ibatis.annotations.Mapper;
import org.macos.java.dao.beans.JobAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MybatisMySQLDao {
    List<JobAddress> getAll();
}


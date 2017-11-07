package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:34
 */
@Repository
public interface TestDao {
    List<Test> queryTestDao() throws Exception;
}

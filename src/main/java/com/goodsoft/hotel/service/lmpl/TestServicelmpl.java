package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.TestDao;
import com.goodsoft.hotel.domain.entity.Test;
import com.goodsoft.hotel.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:50
 */
@Service
public class TestServicelmpl implements TestService {

    @Resource
    private TestDao dao;

    @Override
    public List<Test> queryTestService() throws Exception {
        return this.dao.queryTestDao();
    }
}

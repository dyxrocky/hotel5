package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.cookbook.*;
import com.goodsoft.hotel.domain.entity.param.PageParam;

import java.util.List;

/**
 * description:
 * ===>菜单管理业务接口类
 *
 * @author 严彬荣 Created on 2017-11-07 16:49
 * @version V1.0
 */
public interface CookBookService {
    <T> T queryMenuStypeService(String tid) throws Exception;

    <T> T queryMenuTypeService() throws Exception;

    <T> T queryMenuStypeService(String tid, PageParam page) throws Exception;

    <T> T queryMenuService(String stid, PageParam page) throws Exception;

    <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception;

    void addMenuTypeDao(MenuType msg, List<MenuSubType> msg1) throws Exception;

    void addMenuDao(List<Menu> msg) throws Exception;

    void addInventoryDao(List<Inventory> msg) throws Exception;

    void addMenuMeansDao(List<MenuMeans> msg) throws Exception;

}

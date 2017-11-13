package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.entity.cookbook.*;
import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.CookBookService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description:
 * ===>菜单管理业务接口实现类
 *
 * @author 严彬荣 Created on 2017-11-07 16:50
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class CookBookServicelmpl implements CookBookService {

    @Resource
    private CookBookDao dao;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * 菜单子类型数据过滤业务方法
     *
     * @param tid 菜单类型编号
     * @param <T>
     * @return 过滤数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuStypeService(String tid) throws Exception {
        List<MenuSubType> data = this.dao.queryMenuStypeByIdDao(tid);
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(0, "无");
    }

    /**
     * 查询菜单数据业务方法
     *
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuTypeService() throws Exception {
        List<MenuType> data = this.dao.queryMenuTypeDao();
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单子类型数据业务方法
     *
     * @param tid  菜单类型编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuStypeService(String tid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<MenuSubType> data = this.dao.queryMenuSubtypeDao(tid);
        if (data.size() > 0) {
            PageInfo<MenuSubType> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单数据业务方法
     *
     * @param stid 菜单字类型编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuService(String stid, PageParam page) throws Exception {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<Menu> data = this.dao.queryMenuDao(stid, date);
        if (data.size() > 0) {
            PageInfo<Menu> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单做法数据业务方法
     *
     * @param cbid 菜单编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<MenuMeans> data = this.dao.queryMenuMeansDao(cbid);
        if (data.size() > 0) {
            PageInfo<MenuMeans> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    @Override
    public void addMenuTypeService(List<MenuSubType> msg1) throws Exception {
        String id = this.uuid.getUUID().toString();
        MenuType msg = new MenuType();
        msg.setId(id);
        msg.settName(msg1.get(0).gettName());
        if (msg1 != null) {
            int len = msg1.size() - 1;
            msg1.remove(len);
            for (int i = 0; i < len; ++i) {
                msg1.get(i).setId(this.uuid.getUUID().toString());
                msg1.get(i).setTid(id);
            }
            this.dao.addMenuSubtypeDao(msg1);
        }
        this.dao.addMenuTypeDao(msg);
    }

    @Override
    public void addMenuService(List<Menu> msg) throws Exception {
        if (msg != null) {
            int len = msg.size() - 1;
            msg.remove(len);
            String tid = msg.get(0).getTid();
            String stid = msg.get(0).getStid();
            msg.get(0).setId(this.uuid.getUUID().toString());
            Inventory inv = new Inventory();
            inv.setNum(msg.get(0).getNum());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            for (int i = 1; i < len; ++i) {
                msg.get(i).setId(this.uuid.getUUID().toString());
                msg.get(i).setTid(tid);
                msg.get(i).setStid(stid);
                inv.setNum(msg.get(i).getNum());
                inv.setDate(date);
            }
        }
        this.dao.addMenuDao(msg);
    }

    @Override
    public void addInventoryService(List<Inventory> msg) throws Exception {
        if (msg != null) {
            int len = msg.size() - 1;
            msg.remove(len);
            String cbid = msg.get(0).getCbid();
            msg.get(0).setId(this.uuid.getUUID().toString());
            for (int i = 1; i < len; ++i) {
                msg.get(i).setId(this.uuid.getUUID().toString());
                msg.get(i).setCbid(cbid);
            }
        }
        this.dao.addInventoryDao(msg);
    }

    @Override
    public void addMenuMeansService(List<MenuMeans> msg) throws Exception {
        if (msg != null) {
            int len = msg.size() - 1;
            msg.remove(len);
            String cbid = msg.get(0).getCbid();
            for (int i = 1; i < len; ++i) {
                msg.get(i).setId(this.uuid.getUUID().toString());
                msg.get(i).setCbid(cbid);
            }
        }
        this.dao.addMenuMeansDao(msg);
    }


}

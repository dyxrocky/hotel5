package com.goodsoft.hotel.domain.entity.param;

import com.goodsoft.hotel.domain.entity.cookbook.MenuSubType;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>类型辅助类
 *
 * @author 严彬荣 Created on 2017-11-13 13:07
 */
public class TypeParam implements java.io.Serializable {

    private static final long serialVersionUID = -2109817493514653515L;
    private List<MenuSubType> msg;

    public List<MenuSubType> getMsg() {
        return msg;
    }

    public void setMsg(List<MenuSubType> msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeParam)) return false;
        TypeParam typeParam = (TypeParam) o;
        return Objects.equals(msg, typeParam.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}

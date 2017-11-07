package com.goodsoft.hotel.domain.entity;

import java.util.Objects;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:42
 */
public class Test {

    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) &&
                Objects.equals(type, test.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}

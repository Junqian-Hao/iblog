package com.nuc.iblog.entity;

/**
 * @Author hao
 * @Date 2018/1/17 10:02
 * @Description : 所属组织的扩展类，用于后台管理系统修改所属组织
 */
public class CategoryExt extends Category{
    private boolean isBelong;

    public boolean isBelong() {
        return isBelong;
    }

    public void setBelong(boolean belong) {
        isBelong = belong;
    }
}

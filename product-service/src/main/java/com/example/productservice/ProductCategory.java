package com.example.productservice;

import java.util.Date;

/**
 * 商品分类实体类，对应数据库中的 product_categories 表，用于管理商品的分类信息。
 */
public class ProductCategory {
    private Integer categoryId; // 分类的唯一标识，对应数据库中自增的 category_id 字段
    private String name; // 分类的名称
    private Integer parentId; // 父分类的 ID，用于构建多层级分类结构
    private Date createdAt; // 分类的创建时间

    // Getters 和 Setters 方法
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
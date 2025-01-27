package com.example.productservice;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类，对应数据库中的 products 表，用于封装商品的基本信息。
 */
public class Product {
    private Integer productId; // 商品的唯一标识，对应数据库中自增的 product_id 字段
    private String name; // 商品的名称
    private String description; // 商品的详细描述信息
    private BigDecimal price; // 商品的价格，使用 BigDecimal 确保精确计算
    private Integer stockQuantity; // 商品的库存数量
    private List<Integer> categories; // 商品所属分类的 ID 列表，支持多分类关联
    private String imageUrl; // 商品图片的 URL 地址
    private Date createdAt; // 商品的创建时间
    private Date updatedAt; // 商品信息的最后更新时间

    // Getters 和 Setters 方法，用于访问和修改类的私有属性
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
package com.learn.dto;

public class ItemStockDto {

    private Long itemId; //商品id
    private Integer num; //数量

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

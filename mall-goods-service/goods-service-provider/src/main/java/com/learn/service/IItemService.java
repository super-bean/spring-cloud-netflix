package com.learn.service;


import com.learn.domain.ItemStockDo;
import com.learn.mapper.entitys.TbItem;

import java.util.List;



public interface IItemService {

    List<TbItem> findItemsByIds(List<Long> ids);

    boolean decreaseStock(List<ItemStockDo> itemStockDos);

}

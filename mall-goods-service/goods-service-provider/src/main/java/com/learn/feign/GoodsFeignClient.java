package com.learn.feign;

import com.learn.api.R;
import com.learn.clients.IGoodsFeignClient;
import com.learn.converter.ItemConverter;
import com.learn.domain.ItemStockDo;
import com.learn.dto.ItemStockDto;
import com.learn.mapper.entitys.TbItem;
import com.learn.service.IItemService;
import com.learn.vo.ItemDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsFeignClient implements IGoodsFeignClient {

    @Autowired
    IItemService itemService;

    @Autowired
    ItemConverter itemConverter;

    @Override
    public R<List<ItemDetailVo>> getItemsByIds(List<Long> ids) {
        System.out.println("begin GoodsFeignClient.getItemsByIds:"+ids);
        List<TbItem> itemList=itemService.findItemsByIds(ids);
        List<ItemDetailVo> itemDetailVos=itemConverter.itemDetail2VoList(itemList);
        return new R.Builder<List<ItemDetailVo>>().setData(itemDetailVos).buildOk();
    }

    @Override
    public R decreaseStock(List<ItemStockDto> itemStockDtos) {
        System.out.println("begin GoodsFeignClient.decreaseStock:"+itemStockDtos);
        List<ItemStockDo> itemStockDos=itemConverter.itemStockDo2DoList(itemStockDtos);
        boolean rs=itemService.decreaseStock(itemStockDos);
        return new R.Builder<>().buildOk();
    }
}

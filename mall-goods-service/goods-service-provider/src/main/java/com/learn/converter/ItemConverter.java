package com.learn.converter;

import com.learn.domain.ItemStockDo;
import com.learn.dto.ItemStockDto;
import com.learn.mapper.entitys.TbItem;
import com.learn.vo.ItemDetailVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemConverter {

    @Mappings({})
    ItemDetailVo tbItemDetail2Vo(TbItem tbItem);

    List<ItemDetailVo> itemDetail2VoList(List<TbItem> tbItemList);

    @Mappings({})
    ItemStockDo itemStockDto2Do(ItemStockDto itemStockDto);

    List<ItemStockDo> itemStockDo2DoList(List<ItemStockDto> itemStockDtos);
}

package com.learn.converter;

import com.learn.controller.dto.ItemsDto;
import com.learn.dto.ItemStockDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderConverter {

    ItemStockDto itemDtoStockDto(ItemsDto itemsDto);

    List<ItemStockDto> itemsDto2StockDtoList(List<ItemsDto> itemsDtos);
}

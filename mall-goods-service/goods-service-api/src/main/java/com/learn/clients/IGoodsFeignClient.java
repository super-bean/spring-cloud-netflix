package com.learn.clients;


import com.learn.api.R;
import com.learn.dto.ItemStockDto;
import com.learn.vo.ItemDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "goods-service")
public interface IGoodsFeignClient {

    /**
     * 锁定并扣减库存
     * @Param  商品的id
     * @Param  库存数量
     */
    @PutMapping(value = "/items/stock",consumes = MediaType.APPLICATION_JSON_VALUE)
    R decreaseStock(@RequestBody List<ItemStockDto> itemStockDtos);

    /**
     * 根据商品id查询商品列表
     */
    @GetMapping("/items/{ids}")
    R<List<ItemDetailVo>>  getItemsByIds(@PathVariable("ids") List<Long> ids);
}

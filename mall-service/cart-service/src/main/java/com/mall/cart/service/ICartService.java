package com.hmall.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.cart.domain.dto.CartFormDTO;
import com.mall.cart.domain.po.Cart;
import com.mall.cart.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 订单详情表 服务类
 * </p>
 *
 * @author xx
 *  * @since 2025-02-02
 */
public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}

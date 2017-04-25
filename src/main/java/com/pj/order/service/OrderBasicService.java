package com.pj.order.service;

import com.pj.config.base.BaseService;
import com.pj.order.pojo.OrderBasic;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:13:19
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface OrderBasicService extends BaseService<OrderBasic, Integer> {

	/**
	 * 	查询订单详情
	 *	@author 	GFF
	 *	@date		2017年4月24日下午6:10:29	
	 * 	@param orderId
	 * 	@return
	 */
	OrderBasic selectOrderById(Integer orderId);

	/**
	 * 	添加订单
	 *	@author 	GFF
	 *	@date		2017年4月25日下午3:10:55	
	 * 	@param orderBasic
	 * 	@param cartId
	 */
	void insertSelective(OrderBasic orderBasic, int cartId);

}

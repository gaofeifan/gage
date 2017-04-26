package com.pj.order.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.config.poi.Excel;
import com.pj.customer.controller.CustomerShoppingCartController;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.service.OrderBasicService;
import com.pj.utils.ExcleUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 	订单详情
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="OrderController", description="订单详情")
@RequestMapping("/order")
@Controller
public class OrderBasicController extends BaseController {

	@Resource
	private OrderBasicService orderBasicService;
	
	@Resource
	private CustomerShoppingCartService customerShoppingCartService;
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	public String orderInit(){
		return "order/orderBasic";
	}
	
	@ApiOperation(value = "添加订单", httpMethod = "POST", response=Map.class, notes ="添加订单")
	@RequestMapping(value="/saveOrderBasic",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Map<String,Object> saveOrderBasic(OrderBasic orderBasic){
		int cartId = getShoppingCartByCustomerId(CustomerShoppingCartController.customerId);
		this.orderBasicService.insertSelective(orderBasic,cartId);
		return this.success(null);
	}

	@ApiOperation(value = "导出订单详情", httpMethod = "POST", response=Map.class, notes ="导出订单详情")
	@RequestMapping(value="/exportOrderExcel",method=RequestMethod.POST)
	@ResponseBody
	public void exportOrderExcel(@RequestParam("orderId")Integer orderId,HttpServletRequest request , HttpServletResponse response){
		String downLoadName = "考勤绩效统计.xls";  
		OrderBasic orderBasic = this.orderBasicService.selectOrderById(orderId);
		List<String> orderBasics = Arrays.asList("订单编号","订单总数量","订单创建时间");
		List<String> orderAddress = Arrays.asList("收件人名称","电话","详细地址","备注");
		List<String> shopGoods = Arrays.asList("商品名称","商品数量","商品类型","商品条形码","商品原件","商品现价","商品详情");
		Map<String, List<String>> map = new HashMap<>();
		map.put("orderBasics", orderBasics);
		map.put("orderAddress", orderAddress);
		map.put("shopGoods", shopGoods);
		HSSFWorkbook wb = ExcleUtils.exportOrder(new Excel("订单详情", map), orderBasic);
		OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			downLoadName = com.pj.utils.StringUtils.downloadEncoding(request, downLoadName);
			response.setHeader("Content-disposition","attachment;filename=" + downLoadName); 
			response.setContentType("multipart/form-data");
			wb.write(outputStream);  
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(outputStream != null){
					outputStream.close();
				}
				if(wb != null){
					wb.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 	查询用户购物车 (不存在则创建)
	 *	@author 	GFF
	 *	@date		2017年4月25日上午11:52:01	
	 * 	@param customerId
	 * 	@return
	 */
	public int getShoppingCartByCustomerId(Integer customerId){
		List<CustomerShoppingCart> list = this.customerShoppingCartService.select(new CustomerShoppingCart(null, customerId));
		if(list.size() == 0){
			CustomerShoppingCart cart = new CustomerShoppingCart();
			cart.setCustomerId(customerId);
			this.customerShoppingCartService.insertSelective(cart);
			return cart.getId();
		}
		return list.get(0).getId();
	}
	
}

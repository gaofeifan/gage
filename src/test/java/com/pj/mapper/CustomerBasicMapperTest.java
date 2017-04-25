package com.pj.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.config.page.Pagination;
import com.pj.goods.pojo.ShopGoods;
import com.pj.goods.service.ShopGoodsService;
import com.pj.order.mapper.OrderAddressMapper;
import com.pj.order.pojo.OrderAddress;
import com.pj.order.service.OrderAddressService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午10:57:38
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CustomerBasicMapperTest {


	@Resource
	private OrderAddressMapper orderAddressMapper;
	
	@Resource
	private OrderAddressService orderAddressService;
	
	@Resource
	private ShopGoodsService shopGoodsService;
	
	@Test
	public void test(){
		OrderAddress record = new OrderAddress();
		record.setName("xxx");
		this.orderAddressMapper.insert(record);
		System.out.println(record.getId());
//		this.orderAddressMapper.insertSelective(record);
//		this.orderAddressMapper.insertUseGeneratedKeys(record);
//		this.orderAddressMapper.insertSelective(record);
	}
	
	@Test
	public void test1(){
		Pagination pagination = shopGoodsService.selectByInfo(null, null, null, null, 2);
		System.out.println(pagination);
	
	}
	@Test
	public void test2(){
		Page<Object> startPage = PageHelper.startPage(1,3,true);
		List<ShopGoods> list = shopGoodsService.selectAll();
		Pagination pagination= new Pagination(startPage.getPageNum(), startPage.getPageSize(), 50, list);
		System.out.println(pagination.toString());
		System.out.println(pagination.getPageNo());
		System.out.println(pagination.getPageSize());
		System.out.println(pagination.getTotalPage());
		for (Object shopGoods : pagination.getList()) {
			System.out.println((ShopGoods)shopGoods);
		}
		System.out.println(startPage.getTotal());
	}
}

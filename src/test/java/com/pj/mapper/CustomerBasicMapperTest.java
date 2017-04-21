package com.pj.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pj.order.mapper.OrderAddressMapper;
import com.pj.order.pojo.OrderAddress;

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
}

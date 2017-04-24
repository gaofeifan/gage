package com.pj.config.base.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import com.pj.utils.ClassUtils;

/**
 *	@author		GFF
 *	@date		2017年4月21日下午3:53:31
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public abstract class AbstractHandleServiceImpl<T,ID extends Serializable > extends AbstractBaseServiceImpl<T, ID> {

	@Override
	public int insert(T t) {
		return super.insert(inserCreateTimeField(t));
	}


	@Override
	public int insertSelective(T t) {
		return super.insertSelective(inserCreateTimeField(t));
	}

	@Override
	public int insertUseGeneratedKeys(T t) {
		return super.insertUseGeneratedKeys(inserCreateTimeField(t));
	}

	/**
	 * 	插入创建时间
	 *	@author 	GFF
	 *	@date		2017年4月21日下午4:30:03	
	 * 	@param 		t
	 * 	@return
	 */
	private T inserCreateTimeField(T t) {
		return ClassUtils.setFieldDateValue(t, Arrays.asList("createTime"), Arrays.asList(new Date()));
	}
	
	
}

package com.pj.config.base.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import com.pj.utils.ClassUtils;

import tk.mybatis.mapper.entity.Example;

/**
 *	@author		GFF
 *	@date		2017年4月21日下午3:53:31
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public abstract class AbstractHandleTimeServiceImpl<T,ID extends Serializable > extends AbstractBaseServiceImpl<T, ID> {

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
	
	/**
	 * 	更新时间
	 *	@author 	GFF
	 *	@date		2017年4月21日下午4:30:03	
	 * 	@param 		t
	 * 	@return
	 */
	private T inserupdateTimeField(T t) {
		return ClassUtils.setFieldDateValue(t, Arrays.asList("modifyTime"), Arrays.asList(new Date()));
	}


	@Override
	public int updateByPrimaryKey(T record) {
		
		return super.updateByPrimaryKey(inserupdateTimeField(record));
	}


	@Override
	public int updateByPrimaryKeySelective(T record) {
		return super.updateByPrimaryKeySelective(inserupdateTimeField(record));
	}


	@Override
	public int updateByExample(T record, Example example) {
		return super.updateByExample(inserupdateTimeField(record), example);
	}


	@Override
	public int updateByExampleSelective(T record, Example example) {
		return super.updateByExampleSelective(inserupdateTimeField(record), example);
	}
	
	
	
}

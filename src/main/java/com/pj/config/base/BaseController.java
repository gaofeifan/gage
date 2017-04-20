package com.pj.config.base;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.pj.utils.enums.ExceptionEnum;
/**
 * 
 */
@Controller
public class BaseController{
	protected Logger logger = LoggerFactory.getLogger(BaseController.class); 
	
	public Map<String,Object> success(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",true);
		datas.put("msg","操作成功");
		datas.put("code","200");
		datas.put("data",data);
		return datas;
	}
	
	public Map<String,Object> error(ExceptionEnum exceptionEnum){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("status",false);
		data.put("msg",exceptionEnum.getMsg());
		data.put("code",exceptionEnum.getCode());
		return data;
	}
	
	public Map<String,Object> error(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",false);
		datas.put("msg",data);
		datas.put("code","400");
		datas.put("data","操作失败:"+data);
		return datas;
	}
	
}

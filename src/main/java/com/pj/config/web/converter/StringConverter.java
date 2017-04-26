package com.pj.config.web.converter;

import org.springframework.core.convert.converter.Converter;
/**
 * 	string 类型转换器
 */
public class StringConverter implements Converter<String, Object> {
	public String convert(String source) {
		if (source != null) {
			source = source.trim();
			if (!"".equals(source)) {
				return source;
			}
		}
		return null;
	}

}

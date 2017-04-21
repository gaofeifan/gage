package com.pj.config.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * @author GFF
 * @date 2017年4月20日下午5:58:27
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Controller
@ApiIgnore
public class Swagger3Controller extends Swagger2Controller {

	@ApiIgnore
	@RequestMapping(value = "${springfox.documentation.swagger.v2.path:" + "/v2/api-docs.do"
			+ "}", method = RequestMethod.GET)
	@Override
	public ResponseEntity<Json> getDocumentation(String swaggerGroup) {
		return super.getDocumentation(swaggerGroup);
	}
	
}

package com.tao.web.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tao.dubbo.core.entry.InputObject;
import com.tao.dubbo.core.entry.OutputObject;
import com.tao.web.common.dubboUtil.DubboUtils;

@RestController
public class TestController {
	
	@Autowired
	private DubboUtils dubboUtils;
	
	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/test/dubbo")
	public OutputObject testDubbo() {
		InputObject input = new InputObject();
		input.setMethod("getIniConfig");
		input.setService("iniConfigServiceImpl");
		Map<String, String> map = new HashMap<String, String>();
		map.put("ini_type", "1001");
		map.put("ini_class", "01");
		input.setParams(map);		
		return dubboUtils.invoke(input);
	}
}

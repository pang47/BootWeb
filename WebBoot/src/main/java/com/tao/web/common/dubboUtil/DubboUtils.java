package com.tao.web.common.dubboUtil;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tao.dubbo.core.entry.InputObject;
import com.tao.dubbo.core.entry.OutputObject;
import com.tao.dubbo.core.service.ICommonService;

@Component
public class DubboUtils {
	
	@Reference
	private ICommonService commonService;
	private static final String DESC = "dubboUtils发送工具";
	private static final Logger LOG = LoggerFactory.getLogger(DubboUtils.class);
	
	public OutputObject<Object> invoke(InputObject input) {
		LOG.info("DESC={},开始发送", DESC);
		OutputObject<Object> out = new OutputObject<Object>();
		try {
			if(input.getParams() == null)
				input.setParams(new HashMap<String, String>());
			out = commonService.invoke(input);
		}catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("DESC={},发送结束", DESC);
		return out;
	}
	
}

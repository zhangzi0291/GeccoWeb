package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.RentService;
import com.demo.util.SpringContextUtil;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;

@Controller
public class WebController {
	
	@Resource(name="rentService")
	private RentService rentService;
	
	@Resource(name="springPipelineFactory")
	private PipelineFactory springPipelineFactory;
	
	@RequestMapping("index.html")
	public String index(){
		return "index";
	}
	@RequestMapping("map")
	public String map(){
		return "Map";
	}
	@RequestMapping("getInfo")
	@ResponseBody
	public String getInfo(){
		try {
	        HttpGetRequest start = new HttpGetRequest("http://nj.58.com/chuzu/pn1/?PGTID=0d3090a7-000a-cbc9-0526-eeaec68fc3ed&ClickID=9");
	        start.setCharset("GBK");
	        System.out.println(GeccoEngine.create().pipelineFactory(springPipelineFactory).getSpiderBeanFactory());
	        GeccoEngine.create()
	                .pipelineFactory(springPipelineFactory)
	                .classpath("com.demo.gecco.htmlBean")
	                .start(start)
	                .loop(false)
	                .run();

		} catch (Exception e) {
			e.printStackTrace();
			return"false";
		}
		return"success";
	}
}

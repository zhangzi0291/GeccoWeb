package com.demo.gecco.htmlBean;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.service.RentService;
import com.demo.util.HttpUtil;
import com.geccocrawler.gecco.pipeline.Pipeline;

@Service
public class SaveHousePipeline implements Pipeline<ChuZhuBean>{

	private static Logger logger = LoggerFactory
			.getLogger(SaveHousePipeline.class);
	
	@Resource
	private RentService rentService;
	
	@Override
	public void process(ChuZhuBean bean) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> detailList = rentService.findAllDetailId();
		String url=bean.getRequest().getUrl();
		bean.setUrl(url);
		if(detailList.contains(bean.getDetailId())){
			logger.debug("数据已经存在，信息標題為："+bean.getMainTitle()+"/n ---- DetailId="+bean.getDetailId());
			return;
		}
		if((bean.getArea3()==null||bean.getArea2()==null)&&bean.getAddress()==null){
			logger.debug("地址信息不详细，信息標題為："+bean.getMainTitle());
			return;
		}
		try {
			getPoi(bean);
		} catch (Exception e) {
			logger.error("地址無法轉換為坐標，信息標題為："+bean.getMainTitle());
			return;
		}
		rentService.insert(bean);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private ChuZhuBean getPoi(ChuZhuBean bean) throws Exception{
		String param="output=json&ak=tpSczqbEgPBdxPMSOznYucjyHryoQ5b8&city=南京&address=";
		String address="";
		if(bean.getAddress()!=null){
			address+=bean.getAddress();
		}else{
			if (bean.getArea1()!=null) {
				address+=bean.getArea1();
			}
			if(bean.getArea2()!=null){
				address+=bean.getArea2();
			}
			if(bean.getArea3()!=null){
				address+=bean.getArea3();
			}
		}
		address=URLEncoder.encode(address,"UTF-8");
		String out = HttpUtil.sendGet("http://api.map.baidu.com/geocoder/v2/", param+address);

		JSONObject json=JSON.parseObject(out);
		JSONObject result = (JSONObject) json.get("result");
		JSONObject location = (JSONObject) result.get("location");
		System.out.println(location.get("lng")+","+location.get("lat"));
		bean.setLongitude(location.getString("lng"));
		bean.setLatitude(location.getString("lat"));

		return bean;
	}
	
	
	
	private static String getPoi(String bean){
		String param="output=json&ak=tpSczqbEgPBdxPMSOznYucjyHryoQ5b8&address=";
		param+=bean;
		return param;
	}
	public static void main(String[] args) {
		String out = HttpUtil.sendGet("http://api.map.baidu.com/geocoder/v2/", getPoi("江宁将军大道1号"));
		JSONObject json=JSON.parseObject(out);
		JSONObject result = (JSONObject) json.get("result");
		JSONObject location = (JSONObject) result.get("location");
		System.out.println(location.get("lng")+","+location.get("lat"));
	}

}

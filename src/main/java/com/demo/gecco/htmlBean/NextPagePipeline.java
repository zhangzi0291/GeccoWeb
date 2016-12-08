package com.demo.gecco.htmlBean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

@Service("nextPagePipeline")
public class NextPagePipeline implements Pipeline<ChuZhuPageBean>{
	
	@Override
	public void process(ChuZhuPageBean bean) {
		try {
			HttpRequest currRequest=bean.getRequest();
			
			Integer currPage = bean.getCurrPage();
			Integer nextPage = currPage + 1;
			Integer totalPage = 20;
			
			if(nextPage <= totalPage) {
			    String nextUrl = "";
			    String currUrl = currRequest.getUrl();
			    if(currUrl.indexOf("pn") != -1) {
			        nextUrl = StringUtils.replaceOnce(currUrl, "pn" + currPage, "pn" + nextPage);
			    } else {
			        nextUrl = currUrl + "/pn" + nextPage;
			    }
			    System.out.println("当前URL："+currUrl);
			    System.out.println("下一页URL："+nextUrl);
			    DeriveSchedulerContext.into(currRequest.subRequest(nextUrl));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

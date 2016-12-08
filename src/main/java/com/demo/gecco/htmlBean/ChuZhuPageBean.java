package com.demo.gecco.htmlBean;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://nj.58.com/chuzu/pn{currPage}/?PGTID={pgtid}&ClickID={clickId}",pipelines="nextPagePipeline")
public class ChuZhuPageBean implements HtmlBean {

	private static final long serialVersionUID = -2480716913136531372L;

	
	@RequestParameter
	private Integer currPage;
	@RequestParameter
	private String pgtid;
	@RequestParameter
	private String clickid;
	
	@Request
	private HttpRequest request;
	

	@Href(click=true)
	@HtmlField(cssPath = "div.des > h2 > a")
	private List<String> href;
	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String getPgtid() {
		return pgtid;
	}

	public void setPgtid(String pgtid) {
		this.pgtid = pgtid;
	}

	public String getClickid() {
		return clickid;
	}

	public void setClickid(String clickid) {
		this.clickid = clickid;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public List<String> getHref() {
		return href;
	}

	public void setHref(List<String> href) {
		this.href = href;
	}

	public void startG() {
		HttpGetRequest start = new HttpGetRequest("http://nj.58.com/chuzu/pn1/?PGTID=0d3090a7-000a-cbc9-0526-eeaec68fc3ed&ClickID=9");
		start.setCharset("GBK");
		GeccoEngine.create()
				.classpath("com.demo.gecco.htmlBean")
				.start(start);
	}
	
	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://nj.58.com/chuzu/pn1/?PGTID=0d3090a7-000a-cbc9-0526-eeaec68fc3ed&ClickID=9");
		start.setCharset("GBK");
		GeccoEngine.create()
				.classpath("com.demo.gecco.htmlBean")
				.start(start)
				.run();
	}

	@Override
	public String toString() {
		return "ChuZhuPageBean [currPage=" + currPage + ", pgtid=" + pgtid + ", clickid=" + clickid +"\n"
				+ ", request="	+ request + ", href=" + href + "]"+"\n";
	}

	
}

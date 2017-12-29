package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

//index.html로 요청일 들어오면....IndexController가 동작할 것이다.
public class IndexController implements Controller{

	private Shop shop;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//비지니스 로직을 호출....리턴된 값을 ModelAndView에 저장...결과 페이지도 같이
		
		List<Item> itemList=shop.findAll();
		return new ModelAndView("WEB-INF/jsp/index.jsp","itemList",itemList);
	}

}






















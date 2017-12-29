package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class DetailController implements Controller{
	private Shop shop;

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//비지니스 로직을 호출... 리턴된 값을 ModelAndView에 저장...결과 페이지도 같이 
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		Item item = shop.findPrimaryKey(itemId);
	
	return new ModelAndView("WEB-INF/jsp/detail.jsp","item",item); // 바인딩 될때 MAP방식으로
	//forwarding 방식으로 바인딩 request.SetAttribute("itemList",itemList)를 같다고 보면도미.
	}
}

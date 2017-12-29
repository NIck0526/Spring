package ibatis.services.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ibatis.services.domain.Item;
import ibatis.services.item.Shop;

public class DetailController implements Controller{
	private Shop shop;
	
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("itemId"));
		Item item= shop.findPrimaryKey(id);
		return new ModelAndView("WEB-INF/jsp/detail.jsp","item",item );
	}
}










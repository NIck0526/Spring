package controller;

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
		int id = Integer.parseInt(request.getParameter("itemId"));
		Item item=shop.getItemByItemId(id);
		return new ModelAndView("WEB-INF/jsp/detail.jsp","item",item );
	}
}










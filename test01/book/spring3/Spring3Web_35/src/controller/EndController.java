package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Cart;
import logic.Shop;
import logic.User;
import utils.WebConstants;

@Controller
public class EndController {

	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView end(HttpSession session) {
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("not login");
		}
		
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null || cart.isEmpty()) {
			throw new CartEmptyException("no cart");
		}
		
		this.shopService.checkout(loginUser, cart);
		
		cart.clearAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginUser", loginUser);
		return modelAndView;
	}
}

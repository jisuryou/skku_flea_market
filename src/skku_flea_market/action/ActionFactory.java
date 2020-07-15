package skku_flea_market.action;

import skku_flea_market.web.CategoryController;
import skku_flea_market.web.LoginController;
import skku_flea_market.web.ProductController;
import skku_flea_market.web.RegisterController;
import skku_flea_market.web.SearchController;
import skku_flea_market.web.SellController;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory GetInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action =null;
		System.out.println("ActionFactory: "+command);
		if(command.equals("home")) {
			action = new HomeAction();
		}else if(command.equals("product")) {
			action = new ProductController();
		}else if(command.equals("search")) {
			action = new SearchController();
		}else if(command.equals("category")) {
			action = new CategoryController();
		}else if(command.equals("login")) {
			action = new LoginController();
		}else if(command.equals("register")) {
			action = new RegisterController();
		}else if(command.equals("sell")) {
			action = new SellController();
		}
		return action;
	}
}

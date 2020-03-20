package com.ldg.coffee.Action.Menu;

import com.ldg.coffee.Action.Action;

public class MenuFactory {
	public static Action route(String cmd) {
		if(cmd.equals("cart")) {
			return new MenuCartAction();
		}else if(cmd.equals("menu")) {
			return new MenuMenuAction();
		}else if(cmd.equals("menuProc")) {
			return new MenuMenuProcAction();
		}else if(cmd.equals("cartDeleteProc")) {
			return new MenuCartDeleteProcAction();
		}else if(cmd.equals("bill")) {
			return new MenuBillAction();
		}
		return null;
	}
	
}

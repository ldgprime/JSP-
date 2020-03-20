package com.ldg.coffee.Action.Admin;

import com.ldg.coffee.Action.Action;


public class AdminFactory {
	public static Action route(String cmd) {
		if(cmd.equals("user")) {
			return new AdminUserAction();
		}else if(cmd.equals("board")) {
			return new AdminBoardAction();
		}else if(cmd.equals("bill")) {
			return new AdminBillAction();
		}else if(cmd.equals("userProc")) {
			return new AdminUserProcAction();
		}else if(cmd.equals("boardProc")) {
			return new AdminBoardProcAction();
		}else if(cmd.equals("billProc")) {
			return new AdminBillProcAction();
		}		
		
		return null;
	}

}

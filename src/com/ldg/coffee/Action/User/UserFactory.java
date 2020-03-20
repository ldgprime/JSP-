package com.ldg.coffee.Action.User;

import com.ldg.coffee.Action.Action;

public class UserFactory {
	public static Action route(String cmd) {
		if(cmd.equals("join")) {
			return new UserJoinAction();
		}else if(cmd.equals("login")) {
			return new UserLoginAction();
		}else if(cmd.equals("profile")) {
			return new UserProfileAction();
		}else if(cmd.equals("loginProc")) {
			return new UserLoginProcAction();
		}else if(cmd.equals("joinProc")) {
			return new UserJoinProcAction();			
		}else if(cmd.equals("profileProc")) {
			return new UserProfileProcAction();
		}else if(cmd.equals("usernameCheck")) {
			return new UserUsernameCheckAction();
		}else if(cmd.equals("logout")) {
			return new UserLogoutAction();
		}
		return null;
	}

}

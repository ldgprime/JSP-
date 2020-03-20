package com.ldg.coffee.Action.Board;

import com.ldg.coffee.Action.Action;

public class BoardFactory {
 
	public static Action route(String cmd) {
		if(cmd.equals("list")) {
			return new BoardListAction();
		}else if(cmd.equals("detail")) {
			return new BoardDetailAction();
		}else if(cmd.equals("post")) {
			return new BoardPostAction();
		}else if(cmd.equals("postProc")) {
			return new BoardPostProcAction();
		}else if(cmd.equals("update")) {
			return new BoardUpdateAction();
		}else if(cmd.equals("updateProc")) {
			return new BoardUpdateProcAction();
		}else if(cmd.equals("delete")) {
			return new BoardDeleteAction();
		}else if(cmd.equals("postcomment")) {
			return new BoardPostCommentAction();
		}else if(cmd.equals("selectcomment")) {
			return new BoardSelectCommentAction();
		}else if(cmd.equals("deletecomment")) {
			return new BoardDeleteCommentAction();
		}
		return null;
	}
}

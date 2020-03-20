package com.ldg.coffee.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private int id;
	private int boardid;
	private int userid;
	private String content;
	private Timestamp createtime;
}

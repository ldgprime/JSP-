package com.ldg.coffee.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	private int id;
	private String title;
	private String content;
	private int userid;
	private Timestamp createtime;
}

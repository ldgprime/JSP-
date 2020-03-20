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
public class Bill {
	private int id;
	private int productid;
	private int count;
	private int price;
	private int userid;
	private Timestamp createtime;

}

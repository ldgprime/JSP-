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
public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private Timestamp createtime;
}

package com.kylin.btm;

import java.sql.Connection;

import com.kylin.btm.h2.H2Helper;

public class DB {

	public static void main(String[] args) {
		
//		Connection conn = H2Helper.getConnection();
//		System.out.println(conn);
		
//		H2Helper.prepareBTMDemo();
		H2Helper.testBTMDemo();
	}

}

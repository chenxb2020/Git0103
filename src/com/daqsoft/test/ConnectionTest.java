package com.daqsoft.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.daqsoft.utils.JDBCUtils;

class ConnectionTest {

	@Test
	void test() throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}

}

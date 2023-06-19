package testcases;

import java.sql.SQLException;

import utilities.DbManager;

public class testDbConn {

//	note that we have some files in the utilities package for this. -- You also would need to set up the mysql db on your local machine.
	public static void main(String[] args) throws SQLException {
		DbManager.setMysqlDbConnection();

		System.out.println(DbManager.getMysqlQuery("SELECT * FROM databasename"));
	}

}

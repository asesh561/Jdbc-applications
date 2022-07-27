package com.abc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApplication
{
	public static void main(String[] args) 
	{
		//resources used in JDBC API
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;

		//DB specific Required parameters
		String url="jdbc:mysql:///abc";
		String username="root";
		String password="Root@123";

		try
		{
			//Step 1: Establishing the connection
			connection=DriverManager.getConnection(url,username,password);

			if(connection!=null)
			{
				System.out.println("Connection is established with::"+url);

				//step 2: create a statement object to transfer the query
				statement = connection.createStatement();

				if(statement!=null)
				{
					//Step 4 : transfer the query and inform DB engine to execute the Query
					String sqlSelectQuery="insert into student(sid,sname,sage) values(45,'rohit',37)";
					int rowCount=statement.executeUpdate(sqlSelectQuery);
					if(rowCount>0)
					{
						System.out.println("No of records inserted is : "+rowCount);
					}//end if row count 
				}//end if statement
			}//end if connection
		}//end of try
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//closing the resources
		finally
		{
			if(statement!=null)
			{
				try
				{
					statement.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
	}

}

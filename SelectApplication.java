package com.abc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApplication 
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
					String sqlSelectQuery="select sid,sname,sage from student";
					resultSet=statement.executeQuery(sqlSelectQuery);
					if(resultSet!=null)
					{
						System.out.println("SID\tSNAME\tSAGE");
						while(resultSet.next())
						{
							System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
						}
					}
				}
			}

		}
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
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
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

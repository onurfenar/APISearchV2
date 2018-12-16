package com.t5.apisearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataService {
	

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/apisepeti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					db_userName = "root",
					db_password = "Sys!%2018";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

    public static ArrayList getApiList(int start, int size,String keyword){
			    	ArrayList apiList = new ArrayList();  
			    	try {
			    		
			    		System.out.println("getApiList KEYWORD IS :"+keyword);
			    		
			    		stmtObj = getConnection().createStatement();    
			    		
				    	 
			    		if (keyword!=null)
			    		{ 	
			    				resultSetObj = stmtObj.executeQuery("select * from api where description LIKE '%"+keyword+"%' LIMIT  "+start+","+size+""); 
			    		}
			    		else
			    		{ 	
						    resultSetObj = stmtObj.executeQuery("select * from api LIMIT "+start+","+size+""); 
					}   
			    		
			    		System.out.println("SQL QUERY IS :");
			    		System.out.println(stmtObj.toString());
			 
			    		while(resultSetObj.next()) {  
			    			Api apiObj = new Api(); 
			    			
			    			apiObj.setId(resultSetObj.getInt("id"));
			    			apiObj.setName(resultSetObj.getString("name"));	
			    			apiObj.setDescription(resultSetObj.getString("description"));	
			    			apiObj.setSample_uri(resultSetObj.getString("sample_uri"));	
			    			apiObj.setSample_request(resultSetObj.getString("sample_request"));	
			    			apiObj.setSample_response(resultSetObj.getString("sample_response"));	
			    			
			    			apiList.add(apiObj);  
			    		}  
			    		System.out.println("Total Records Fetched: " + apiList.size());
			    		connObj.close();
			    	} catch(Exception sqlException) {
			    		sqlException.printStackTrace();
			    	} 
			    	return apiList;
    }
    

    public static int getApiTotalCount(String keyword) {
        
    			int result=0;
    	
		    try {
		    		stmtObj = getConnection().createStatement();   
		    		
		    		if (keyword==null)
		    		{ 	
		    			resultSetObj = stmtObj.executeQuery("select count(*) as total from api"); 
		    		}
		    		else
		    		{ 	
		    			resultSetObj = stmtObj.executeQuery("select count(*) as total from api where description LIKE '%"+keyword+"%'"); 
		    		}
		    		
		    		while(resultSetObj.next()){
		    			result = resultSetObj.getInt("total");
		    		    }
		    		
		    		System.out.println("Total Records Fetched: " + result);
		    		
		    		connObj.close();
		    		
		    	} catch(Exception sqlException) {
		    		sqlException.printStackTrace();
		    	} 
		    	return result;
    }
}




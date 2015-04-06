package com.imscore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ims.pojo.Category;

public class CategoryBase extends ConnectionBase {
	
	
	
	public boolean insertCategory(String categoryName, String categoryDesc){
		boolean executed=false;
		Connection con= getConnection();
		
		String sql= "INSERT INTO category (categoryid,name,description) values (seq_category.nextval,?,?)";
		try {
			int nextCategory=1;
			String getId="";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, categoryName);
			ps.setString(2, categoryDesc);
			executed=  ps.execute();
			
			System.out.println("executed..."+executed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return executed;
	}
	
	public Category getCategoryById(int id){
		String sql= "select name,description,categoryid from category where categoryid=?";
		Category ct= new Category();
		Connection con= getConnection();
		ResultSet rs = null;
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			 rs= ps.executeQuery();
			 /*if(numberofRow==1){*/
				 while(rs.next() ){
					 String str=rs.getString(1);
					 //System.out.println(str);
					 ct.setName(str);
					 ct.setDescription(rs.getString(2));
					 ct.setId(rs.getInt(3));
				 }
			 /*}
			 else{
				 System.out.println("there is some problem. Multiple rows found for the same id");
				 
			 }*/
		}
		catch(Exception e){
			 e.printStackTrace();
		 }
		return ct;
	}
	
	public List<Category> getAllCategories(){
		 
		 List<Category> categoryList= new ArrayList<Category>();
		 Connection con= getConnection();
		
		 ResultSet rs = null;
		 String sql= "select name,description,categoryid from category ";
		 try{
			 
			 Statement stmt= con.createStatement();
			 rs= stmt.executeQuery(sql);
			 while(rs.next() ){
				 Category ct=new Category();
				 String str=rs.getString(1);
				 ct.setName(str);
				 ct.setDescription(rs.getString(2));
				 ct.setId(rs.getInt(3));
				 categoryList.add(ct);
			 }
			 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return categoryList;
		 
		
	}
	
	public boolean updateCategory(Category ct){
		 Connection con= getConnection();
		 boolean updatedSucessfully=false;
		 ResultSet rs = null;
		 String sql= "update category set name=?,description=?  where categoryid=? ";
		 try{
			 PreparedStatement ps= con.prepareStatement(sql);
			 ps.setString(1, ct.getName());
			 ps.setString(2, ct.getDescription());
			 ps.setInt(3, ct.id);
			 int rs1= ps.executeUpdate();
			 System.out.println("no of rows affected "+rs1);
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		
		return false;
	}
	
	public boolean deleteCategory(int ctId){
		Connection con= getConnection();
		boolean successfullyDeleted=false;
		String sql= "delete category where categoryid=?  ";
		try{
			 PreparedStatement ps= con.prepareStatement(sql);
			 ps.setInt(1, ctId);
			 int rs1= ps.executeUpdate();
			 System.out.println("no of rows affected "+rs1);
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		return successfullyDeleted;
	}
	
}

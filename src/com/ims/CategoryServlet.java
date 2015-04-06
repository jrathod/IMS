package com.ims;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.pojo.Category;
import com.imscore.CategoryBase;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String insertCategory="categoryAdd.jsp";
	String editCategory="categoryEdit.jsp";
	String listCategory="categoryList.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getParameter("action");
		RequestDispatcher view ;
		CategoryBase cb= new CategoryBase();
		String forward = null;
		if(action.equals("listCategory") ){
			forward="jsp/category/DisplayCategory.jsp";
			List<Category> categoryList = cb.getAllCategories();
			request.setAttribute("categoryList", categoryList);
		}
		else if(action.equals("edit") ){
			forward=editCategory;
			String catId=request.getParameter("category_id");
			int categoryId= Integer.parseInt(catId);
			Category ct= cb.getCategoryById(categoryId);
			request.setAttribute("category", ct);
		}
		else if(action.equals("delete")){
			String catId=request.getParameter("category_id");
			int categoryId= Integer.parseInt(catId);
			cb.deleteCategory(categoryId);
			forward="jsp/category/DisplayCategory.jsp";
			List<Category> categoryList = cb.getAllCategories();
			request.setAttribute("categoryList", categoryList);
		}
		view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CategoryBase cb= new CategoryBase();
		System.out.println("post method");
		
		String strId= request.getParameter("category_id");
		Category ct= new Category();
		String categroyName= request.getParameter("category_name");
		String description= request.getParameter("category_desc");
		System.out.println(""+categroyName+" "+description+" "+strId);
		if(strId!=null ){
			int id= Integer.parseInt(strId);
			ct.setId(id);
			ct.setDescription(description);
			ct.setName(categroyName);
			boolean executed=cb.updateCategory(ct);
			System.out.println("going for update");
		}
		else{
			//
			boolean executed =cb.insertCategory(categroyName,description);
			System.out.println("going for insert");
		}
		System.out.println("going to forward to jsp"+ strId);
		String forward = listCategory;
		response.sendRedirect(forward);
	}
}

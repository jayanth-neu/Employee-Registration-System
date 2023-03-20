package com.project.test;

import java.util.List;

import com.project.dao.PostDAO;
import com.project.pojo.Post;



public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostDAO pdao = new PostDAO();
		List<Post> list = pdao.list();
		
		for (var pst : list)
			System.out.println(pst.getSubject());
		
		System.out.println("Displayed all posts");
	}

}

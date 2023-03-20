package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.project.dao.PostDAO;
import com.project.exception.EmpException;
import com.project.pojo.Post;
import com.project.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PostController {
	@GetMapping("/addpost.htm")
	public String addPostGet(ModelMap model, Post post, HttpServletRequest request) {
		
		if(UserController.invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		model.addAttribute("post", post);

		return "post-add";
	}

	@PostMapping("/addpost.htm")
	public String addPostPost(@ModelAttribute("post") Post post, BindingResult result, SessionStatus status, PostDAO postdao, HttpServletRequest request) {
		
		if(UserController.invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		User u = (User)request.getSession().getAttribute("emplogin");
		post.setSenderid(u);
		
		if(post.getSubject().trim().equals("")) {
			request.setAttribute("Msg", "Subject field cannot be blank/only spaces");
			return "response";
		}
		
		if(post.getContent().trim().equals("")) {
			request.setAttribute("Msg", "Content field cannot be blank/only spaces");
			return "response";
		}
		
		try {
			postdao.save(post);
			request.setAttribute("Msg", "Post Added");
		} catch (EmpException e) {
			System.out.println("Post cannot be Added: " + e.getMessage());
			request.setAttribute("Msg", "Post cannot be Added");
		}
		
		status.setComplete();
		return "response";
	}
	
	@GetMapping("/viewpost.htm")
	public String viewPostGet(HttpServletRequest request, PostDAO postdao) {
		
		if(UserController.invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		request.setAttribute("Posts", postdao.list());

		return "view-post";
	}
	
	@GetMapping("/deletepost.htm")
	public String deletePostGet(ModelMap model, Post post, HttpServletRequest request) {
		
		if(UserController.invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		model.addAttribute("post", post);

		return "post-delete";
	}

	@PostMapping("/deletepost.htm")
	public String deletePostPost(@ModelAttribute("post") Post post, BindingResult result, SessionStatus status, 
			PostDAO postdao, HttpServletRequest request) {
		
		if(UserController.invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		Post postdelete = postdao.checkPost(post.getId());
		
		
		if(postdelete == null) {
			request.setAttribute("Msg", "Invalid PostID");
			return "response";
		}
		
		if(postdelete.getSenderid().getId() != ((User)request.getSession().getAttribute("emplogin")).getId() && 
				!((User)request.getSession().getAttribute("emplogin")).isIsadmin()) {
			request.setAttribute("Msg", "Only Admins can delete other Employees posts");
			return "response";
		}
		
		try {
			postdao.delete(postdelete);
			request.setAttribute("Msg", "Post Deleted");
		} catch (EmpException e) {
			System.out.println("Post cannot be Deleted: " + e.getMessage());
			request.setAttribute("Msg", "Post cannot be Deleted");
		}
		
		status.setComplete();
		return "response";
	}
		
}

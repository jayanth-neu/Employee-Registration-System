package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.project.dao.UserDAO;
import com.project.exception.EmpException;
import com.project.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String defaultView() {
		return "emp-login";
	}
	
	@GetMapping("/emplogin.htm")
	public String empLoginGet() {
		return "emp-login";
	}
	
	@GetMapping("/welcome.htm")
	public String empWelcomeGet(HttpServletRequest request) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		if(((User)request.getSession().getAttribute("emplogin")).isIsadmin())
			return "welcome-admin";
		else
			return "welcome";
	}
		
	@PostMapping("/welcome.htm")
	public String empLoginPost(HttpServletRequest request, UserDAO userdao) {
		String emailid = request.getParameter("emailid");
		String passw = request.getParameter("passw");
		
		User emplogin = userdao.checkEmpLogin(emailid,passw);
		
		if(emplogin == null) {
			request.setAttribute("displayError", "Invalid EmailID or Password");
			return "error-login";
		}
		
		request.getSession().setAttribute("emplogin",emplogin);
		
		if(emplogin.isIsadmin())
			return "welcome-admin";
		else
			return "welcome";
	}

	@GetMapping("/adddata.htm")
	public String addEmpGet(ModelMap model, User user, HttpServletRequest request) {
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		// command object
		model.addAttribute("user", user);

		if(((User)request.getSession().getAttribute("emplogin")).isIsadmin())
			return "emp-add";
		else
			return "welcome";
		
	}

	@PostMapping("/adddata.htm")
	public String addEmpPost(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDAO userdao, HttpServletRequest request) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		User useradd = userdao.checkEmp(user.getEmailid());
		
		if(useradd != null) {
			request.setAttribute("Msg", "Email ID must be changed as it already exists in the records");
			return "response";
		}
		
		if(user.getEmailid().trim().equals("")) {
			request.setAttribute("Msg", "EmailID field cannot be blank/only spaces");
			return "response";
		}
		
		if(user.getPwd().trim().equals("")) {
			request.setAttribute("Msg", "Password field cannot be blank/only spaces");
			return "response";
		}		
		
		
		try {
			userdao.save(user);
			request.setAttribute("Msg", "Employee Added");
		} catch (EmpException e) {
			System.out.println("User cannot be Added: " + e.getMessage());
			request.setAttribute("Msg", "Employee cannot be Added");
		}
		
		status.setComplete(); 
		return "response";
	}
	
	@GetMapping("/deletedata.htm")
	public String deleteEmpGet(ModelMap model, User user, HttpServletRequest request) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		

		model.addAttribute("user", user);

		if(((User)request.getSession().getAttribute("emplogin")).isIsadmin())
			return "emp-delete";
		else
			return "welcome";
	}

	@PostMapping("/deletedata.htm")
	public String deleteEmpPost(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, 
			UserDAO userdao, HttpServletRequest request) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		User empdelete = userdao.checkEmp(user.getEmailid());
		
		if(empdelete == null) {
			request.setAttribute("Msg", "Invalid EmailID");
			return "response";
		}
		
		try {
			userdao.delete(empdelete);
			request.setAttribute("Msg", "Employee Deleted");
		} catch (EmpException e) {
			System.out.println("User cannot be Deleted: " + e.getMessage());
			request.setAttribute("Msg", "Employee cannot be Deleted");
		}
		
		status.setComplete(); 
		return "response";
	}
	
	@GetMapping("/updatedata.htm")
	public String empUpdateGet(HttpServletRequest request) {
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		return "emp-update";
	}
	
	@PostMapping("/updatedata.htm")
	public String empUpdatePost(HttpServletRequest request, UserDAO userdao, SessionStatus status) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		String emailid_update = request.getParameter("emailid_update");
		String isadmin_update = request.getParameter("isadmin_update");
		String fname_update = request.getParameter("fname_update");
		String lname_update = request.getParameter("lname_update");
		String password_update = request.getParameter("password_update");
		
		String new_emailid = request.getParameter("new_emailid");
		String new_isadmin = request.getParameter("new_isadmin");
		String new_fname = request.getParameter("new_fname");
		String new_lname = request.getParameter("new_lname");
		String new_password = request.getParameter("new_password");
		
		String emailid= request.getParameter("emailid");
			
		User empupdate = userdao.checkEmp(emailid);
		
		User curEmp = ((User)request.getSession().getAttribute("emplogin"));
		
		if(empupdate == null) {
			request.setAttribute("Msg", "Invalid EmailID");
			return "response";
		}
		
		else if(!emailid.equals(curEmp.getEmailid()) && !curEmp.isIsadmin()) {
			request.setAttribute("Msg", "Only Admins can update other Employees data");
			return "response";
		}
			
		if(emailid_update.equals("Yes")) {
			if(new_emailid.trim().equals("")) {
				request.setAttribute("Msg", "New EmailID cannot be empty/only spaces");
				return "response";
			}
			
			User userupdate = userdao.checkEmp(new_emailid);
			
			if(userupdate != null) {
				request.setAttribute("Msg", "New Email ID entered already exists in the records");
				return "response";
			}
			
			else if(emailid.equals(curEmp.getEmailid()) && !curEmp.isIsadmin()) {
				request.setAttribute("Msg", "Regular Employees cannot change their EmailID");
				return "response";
			}
			
			empupdate.setEmailid(new_emailid);
		}
		if(isadmin_update.equals("Yes")) {
			if(emailid.equals(curEmp.getEmailid()) && !curEmp.isIsadmin()) {
				request.setAttribute("Msg", "Regular Employees cannot change their Access Type");
				return "response";
			}
			empupdate.setIsadmin(new_isadmin.equals("Admin"));
		}
		
		if(fname_update.equals("Yes")) {
			if(emailid.equals(curEmp.getEmailid()) && !curEmp.isIsadmin()) {
				request.setAttribute("Msg", "Regular Employees cannot change their fname");
				return "response";
			}
			empupdate.setFname(new_fname);
		}
		
		if(lname_update.equals("Yes")) {
			if(emailid.equals(curEmp.getEmailid()) && !curEmp.isIsadmin()) {
				request.setAttribute("Msg", "Regular Employees cannot change their lname");
				return "response";
			}
			empupdate.setLname(new_lname);
		}
		if(password_update.equals("Yes")) {
			
			if(new_password.trim().equals("")) {
				request.setAttribute("Msg", "New Password cannot be empty/only spaces");
				return "response";
			}
			empupdate.setPwd(new_password);	
		}
		
			try {
				userdao.update(empupdate);
				request.setAttribute("Msg", "Employee Updated");
			} catch (EmpException e) {
				System.out.println("User cannot be Updated: " + e.getMessage());
				request.setAttribute("Msg", "Employee cannot be Updated");
			}
			
			status.setComplete(); 	
			
		return "response";	
	}
	
	@GetMapping("/dir.htm")
	public String empDirGet(HttpServletRequest request, UserDAO userdao) {
		
		if(invalidSession(request)) {
			request.setAttribute("displayError", "Please Login");
			return "error-login";
		}
		
		request.setAttribute("EmpList", userdao.list());

		return "dir";
	}
	
	@GetMapping("/emplgout.htm")
	public String LogOut(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "emp-login";
	}
	
	public static boolean invalidSession(HttpServletRequest request)  {
		if(request.getSession().getAttribute("emplogin")==null) {
			return true;
		}
		else 
			return false;
	}
	
}

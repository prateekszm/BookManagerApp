package MainController.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import Model.Book;

@Controller
public class BooksController {
	@Autowired	
	Gson gson;
	
	@Autowired
	DaoManager daoManager ;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "success";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	@ResponseBody
	public String addBook(@ModelAttribute Book book) {
		System.out.println(book.getClass().getName());
		//System.out.println("In Controller");
		System.out.println(book.getName());
		System.out.println(book.getPirce());
		daoManager.createBook(book); 
		String str = gson.toJson(book);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value= "/edit",method  = RequestMethod.POST)
	public String editBook(@ModelAttribute Book book) {
		this.daoManager.editBooks(book);
		
		return gson.toJson(book);
	}
	
	@ResponseBody
	@RequestMapping(value= "/delete",method  = RequestMethod.POST)
	public String deleteBook(@RequestParam("pid") int pid) {
		System.out.println(pid);
		
		
		Book book = this.daoManager.deleteBook(pid);
		System.out.println(book.toString());
		//String str = new Gson().toJson(book);
		
		return book.toString();
	}
}

package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Bookstore;
import com.example.bookstore.domain.BookstoreRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;



@Controller
public class BookstoreController {
	@Autowired
	private BookstoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/booklist")
	public String Booklist(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
		
	}
	
	@RequestMapping(value= "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Bookstore());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping (value= "/save", method = RequestMethod.POST)
	public String Save(Bookstore book) {
		repository.save(book);
		return "redirect:booklist";
		
	}
	
	@RequestMapping(value="/Books", method = RequestMethod.GET)
	public @ResponseBody List<Bookstore> bookListRest(){
		return(List<Bookstore>) repository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Bookstore> findStudentRest(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id")Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		
		return "editbook";
		
	}
	
	
	
	

}

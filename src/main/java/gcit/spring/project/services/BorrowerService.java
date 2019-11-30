package gcit.spring.project.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gcit.spring.project.dao.AuthorDAO;
import gcit.spring.project.dao.BookDAO;
import gcit.spring.project.dao.BookLoansDAO;
import gcit.spring.project.entity.AuthorsModel;
import gcit.spring.project.entity.BookLoansModel;
import gcit.spring.project.entity.BookModel;
@RestController
public class BorrowerService {
	
	@Autowired
	BookDAO bdao;
	@Autowired
	AuthorDAO adao;
	@Autowired 
	BookLoansDAO bldao;
	@RequestMapping(value="/client/readAllBooks", method=RequestMethod.GET, produces="application/json")
	public List<BookModel> readAllBooks(){
		try {
			return bdao.readAllBooks();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}}
	@RequestMapping(value="/client/readAllAuthors", method=RequestMethod.GET, produces="application/json")
	public List<AuthorsModel> readAllAuthors() throws ClassNotFoundException, SQLException{
		try {
			return adao.readAllAuthors();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}}
		
	
	
	@RequestMapping(value="/client/borrow", method=RequestMethod.POST, consumes="application/json")
	@Transactional
	public String borrow(@RequestBody BookLoansModel loan) {
		try {
			return bldao.saveBookLoan(loan);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "Class Cast Exception";
		} catch (SQLException e) {
			e.printStackTrace();
			return "CheckSQL syntax";
		}
		
	}
	
	@RequestMapping(value="/client/{title}", method=RequestMethod.GET, produces="application/json")
	public List<BookModel> listAllBooksByName(@PathVariable String title){
		try {
			return bdao.readAllBooksByName(title);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}

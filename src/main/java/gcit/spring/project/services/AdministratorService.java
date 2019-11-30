package gcit.spring.project.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gcit.spring.project.dao.AuthorDAO;
import gcit.spring.project.dao.BookDAO;
import gcit.spring.project.dao.BookLoansDAO;
import gcit.spring.project.entity.AuthorsModel;
import gcit.spring.project.entity.BookLoansModel;
import gcit.spring.project.entity.BookModel;
import gcit.spring.project.entity.Book_Author_Genre_Branch_CopiesModel;
import gcit.spring.project.entity.BorrowerModel;


@RestController
public class AdministratorService {

	@Autowired
	AuthorDAO adao;

	@Autowired
	BookDAO bdao;
	
	@Autowired
	BookLoansDAO bldao;

	@Transactional
	@RequestMapping(value="/admin/saveAuthor", method=RequestMethod.POST, consumes="application/json")
	public String saveAuthor(@RequestBody AuthorsModel author) throws SQLException{
		try {
			if(author!=null){
				if((Integer)author.getAuthorId()!=null && author.getAuthorName()!=null){
					adao.updateAuthor(author);
					return "Author updated sucessfully";
				}else if(author.getAuthorId()!=0){
					adao.deleteAuthor(author);
					return "Author deleted sucessfully";
				}else{
					adao.saveAuthor(author);
					return "Author saved sucessfully";
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Unable to save Author, try again";
		}
		return null;
	}

	@Transactional
	@RequestMapping(value="/admin/saveAllBookRelations", method=RequestMethod.POST, consumes="application/json")
	public String saveBook(@RequestBody Book_Author_Genre_Branch_CopiesModel book){
		if(book!=null) {
			try {
			Integer bookId = (Integer)bdao.saveBookWithID(book);
			bdao.saveBookByAuthorId(book, bookId);
			bdao.saveBookByGenreId(book, bookId);
			bdao.saveBookByNoOfCopies(book, bookId);
		   return "Book successfully Added";}
			catch(SQLException | ClassNotFoundException e) {
				if((Integer)book.getAuthorId()!=null)return "AuthorId Can't be null";
				else if((Integer)book.getGenreId()!=null)return "GenreId Can't be null";
				else if((Integer)book.getBranchId()!=null)return "BranchId Can't be null";
				else if((Integer)book.getCopies()!=null)return "No_of_copies Can't be null";
				else return "Failed!";
			}}
			else return "Empty request!";}
			
	

	@RequestMapping(value="/admin/readAuthors/{searchString}", method=RequestMethod.GET, produces="application/json")
	public List<AuthorsModel> readAuthors(@PathVariable String searchString) throws SQLException{
		List<AuthorsModel> authors = new ArrayList<>();
		try {
			if(searchString!=null){
				authors= adao.readAllAuthorsByName(searchString);
			}else{
				authors = adao.readAllAuthors();

			}
			for(AuthorsModel a: authors){
				a.setBook_list(bdao.readAllBooksByAuthorId(a.getAuthorId()));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return authors;

	}

	@RequestMapping(value="/admin/readAuthorsByName", method=RequestMethod.GET, produces="application/json")
	public List<AuthorsModel> readAuthorsByName(@RequestParam String searchString) throws SQLException{
		List<AuthorsModel> authors = new ArrayList<>();
		try {
			if(searchString!=null){
				authors= adao.readAllAuthorsByName(searchString);
			}else{
				authors = adao.readAllAuthors();
			}
			for(AuthorsModel a: authors){
				a.setBook_list(bdao.readAllBooksByAuthorId(a.getAuthorId()));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return authors;

	}
	@RequestMapping(value="/admin/readAllBooks", method=RequestMethod.GET, produces="application/json")
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
	}
		
		
	}
	
	@RequestMapping(value="/admin/updateBook", method=RequestMethod.POST, consumes="application/json")
	@Transactional
	public String updateBook(@RequestBody BookModel book) {
		try {
			if((Integer)book.getBookId()!=null) 
			bdao.updateBook(book);
			return "Succcessful Operation!";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Sql failure";
		}
		
	}
	@RequestMapping(value="/admin/readAllAuthors", method=RequestMethod.GET, produces="application/json")
	public List<AuthorsModel> readAllAuthors(){
		try {
			return adao.readAllAuthors();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	@RequestMapping(value="/admin/addNewClient", method=RequestMethod.POST, consumes="application/json")
	@Transactional
	public int addNewBorrower(@RequestBody BorrowerModel borrower) {
		try {
			if(borrower.getName()!=null && borrower.getAddress()!=null) 
			{  return bldao.addNewBorrower(borrower);}
			else {return -1;}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	@RequestMapping(value="/admin/showBookLoans", method=RequestMethod.GET, produces="application/json")
	public List<BookLoansModel> readAllBorrowedBooks(){
		try {	
		return bldao.showBorrowedBooks();}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException e) {
			e.getStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="/admin/updateDueDate/{cardNo}", method=RequestMethod.GET)
	@Transactional
	public String extendDueDate(@PathVariable int cardNo) {
		if((Integer)cardNo!=null) {
			try {
			return bldao.extendDueDate(cardNo);}
			catch(SQLException e) {
				return "unsuccessful!";
			}
		}
		return "unsuccesfull!";
	}
	
	
	
}
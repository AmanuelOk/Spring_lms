package gcit.spring.project.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import gcit.spring.project.entity.BookModel;
import gcit.spring.project.entity.Book_Author_Genre_Branch_CopiesModel;

public class BookDAO extends BaseDAO<BookModel> implements ResultSetExtractor<List<BookModel>>{
@Autowired
AuthorDAO adao;
@Autowired
GenreDAO gdao;
	public void saveBook(BookModel book) throws ClassNotFoundException, SQLException {
		mySqlTemplate.update("INSERT INTO tbl_book (title) values (?)", new Object[] { book.getTitle()});
	}

	public Integer saveBookWithID(Book_Author_Genre_Branch_CopiesModel book) throws ClassNotFoundException, SQLException {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String SAVE_BOOK_ID_QUERY = "INSERT INTO tbl_book (title,pubId) values (?,?)";
		mySqlTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(SAVE_BOOK_ID_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
	          ps.setString(1, book.getTitle());
	          ps.setInt(2, book.getPubId());
	          return ps;
	        }, keyHolder);
	        return keyHolder.getKey().intValue();
	}
	//update all tables related to Book
	public void saveBookByAuthorId(Book_Author_Genre_Branch_CopiesModel book, int bookId) {
		mySqlTemplate.update("INSERT INTO tbl_book_authors (bookId,authorId) values (?,?)", new Object[] { bookId, book.getAuthorId() });	
	}
	public void saveBookByGenreId(Book_Author_Genre_Branch_CopiesModel book, int bookId) {
		mySqlTemplate.update("INSERT INTO tbl_book_genres (genre_id,bookId) values (?,?)", new Object[] { book.getGenreId(),bookId });			
	}
	public void saveBookByNoOfCopies(Book_Author_Genre_Branch_CopiesModel book, int bookId) {
		mySqlTemplate.update("INSERT INTO tbl_book_copies (bookId,branchId,noOfCopies) values (?,?,?)", new Object[] {bookId,book.getBranchId(), book.getCopies()});			
	}
	
	//end of book update Cascade
	public void updateBook(BookModel book) throws SQLException, ClassNotFoundException {
		mySqlTemplate.update("UPDATE tbl_book SET title = ? where bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });
	}

	public void deleteBook(BookModel book) throws ClassNotFoundException, SQLException {
		mySqlTemplate.update("delete from tbl_book where bookId = ?", new Object[] { book.getBookId() });
	}

	public List<BookModel> readAllBooks() throws ClassNotFoundException, SQLException {
		return mySqlTemplate.query("SELECT * FROM tbl_book", this);
	}

	public List<BookModel> readAllBooksByName(String title) throws ClassNotFoundException, SQLException {
		title = "%"+title+"%";
		return mySqlTemplate.query("SELECT * FROM tbl_book where title like ?", new Object[]{title}, this);
	}

	public List<BookModel> readAllBooksByAuthorId(Integer authorId) throws ClassNotFoundException, SQLException {
		return mySqlTemplate.query("SELECT * FROM tbl_book where bookId IN(select bookId from tbl_book_authors where authorId = ?)", new Object[]{authorId}, this);
	}

	public List<BookModel> readAllBookByAuthorId(int authorId){
		return mySqlTemplate.query("select tbl_book.bookId,title,"
				+ " pubId from tbl_book inner join tbl_book_authors on tbl_book.bookId = tbl_book_authors.bookId where authorId = ?", new Object[] {authorId},this);
	}
	public List<BookModel>readAllBooksByBranchId(int branchId){
String sql="select tbl_book.bookId, title,pubId, noOfCopies from tbl_book_copies inner join tbl_book on tbl_book_copies.bookId =tbl_book.bookId where branchId = ? and noOfCopies is not null";
		return mySqlTemplate.query(sql, new Object[] {branchId}, this);
	}
	
	@Override
	public List<BookModel> extractData(ResultSet rs) throws SQLException {
		List<BookModel> books = new ArrayList<>();
		while (rs.next()) {
			BookModel b = new BookModel();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPubId(rs.getInt("pubId"));
			b.setGenre_list(gdao.readAllGenesByBookId(rs.getInt("bookId")));
			books.add(b);
		}
		return books;
	}
}
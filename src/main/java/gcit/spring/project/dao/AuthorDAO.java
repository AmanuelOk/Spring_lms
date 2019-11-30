package gcit.spring.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import gcit.spring.project.entity.AuthorsModel;
import gcit.spring.project.entity.BookModel;

public class AuthorDAO extends BaseDAO<AuthorsModel> implements ResultSetExtractor<List<AuthorsModel>>{
   @Autowired
	BookDAO bdao;
	public void saveAuthor(AuthorsModel author) throws ClassNotFoundException, SQLException {
		mySqlTemplate.update("INSERT INTO tbl_author (authorName) values (?)", new Object[] { author.getAuthorName() });
	}

	public void updateAuthor(AuthorsModel author) throws SQLException, ClassNotFoundException {
		mySqlTemplate.update("UPDATE tbl_author SET authorName = ? where authorId = ?",
				new Object[] { author.getAuthorName(), author.getAuthorId() });
	}

	public void deleteAuthor(AuthorsModel author) throws ClassNotFoundException, SQLException {
		mySqlTemplate.update("delete from tbl_author where authorId = ?", new Object[] { author.getAuthorId() });
	}

	public List<AuthorsModel> readAllAuthors() throws ClassNotFoundException, SQLException {
		return mySqlTemplate.query("SELECT * FROM tbl_author", this);
	}

	public List<AuthorsModel> readAllAuthorsByName(String authorName) throws ClassNotFoundException, SQLException {
		authorName = "%"+authorName+"%";
		return mySqlTemplate.query("SELECT * FROM tbl_author where authorName like ?", new Object[]{authorName}, this);
	}
	
	@Override
	public List<AuthorsModel> extractData(ResultSet rs) throws SQLException {
		List<AuthorsModel> authors = new ArrayList<>();
		while (rs.next()) {
			AuthorsModel a = new AuthorsModel();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			try {
				a.setBook_list(bdao.readAllBooksByAuthorId(rs.getInt("authorId")));
			} catch (ClassNotFoundException e) {
				a.setBook_list(null);
			}
			authors.add(a);
		}
		return authors;
	}
}
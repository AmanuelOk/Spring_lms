package gcit.spring.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import gcit.spring.project.entity.BookModel;
import gcit.spring.project.entity.GenreModel;

public class GenreDAO extends BaseDAO<GenreModel> implements ResultSetExtractor<List<GenreModel>>{
	public List<GenreModel> getAllGenres(){
		String mysql="select * from tbl_genre";		
		return mySqlTemplate.query(mysql,this);
		
	}
	public List<GenreModel> readAllGenres() throws ClassNotFoundException, SQLException {
		return mySqlTemplate.query("SELECT * FROM tbl_genre", this);
	}
	public List<GenreModel> readAllGenesByBookId(int bookId){
		String sql="select genre_name,tbl_genre.genre_id from tbl_genre inner join tbl_book_genres on tbl_genre.genre_id=tbl_book_genres.genre_id where bookId =?";
		return mySqlTemplate.query(sql, new Object[] {bookId},this);
	}

	@Override
	public List<GenreModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GenreModel>list=new ArrayList<>();
		while(rs.next()) {
			GenreModel gm = new GenreModel();
			gm.setGenreId(rs.getInt("genre_id"));
			gm.setGenreName(rs.getString("genre_name"));
			list.add(gm);
		}
		return list;
	}

}

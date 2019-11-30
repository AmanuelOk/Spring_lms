package gcit.spring.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import gcit.spring.project.entity.BookCopiesModel;
import gcit.spring.project.entity.LibraryBranchModel;

public class LibrarianDAO extends BaseDAO<LibraryBranchModel> implements ResultSetExtractor<List<LibraryBranchModel>> {

	@Autowired 
	BookDAO bdao;
	public Integer insertLibrary(LibraryBranchModel branch) throws SQLException, ClassNotFoundException{
		String sql="insert into tbl_library_branch(branchName,branchAddress)values(?,?)";
		KeyHolder holder= new GeneratedKeyHolder();;
		
		 mySqlTemplate.update(connection -> 
		{PreparedStatement pstm = 
		connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		pstm.setString(1,"branchName");
		pstm.setString(2,"branchAddress");
		return pstm;},holder);
		
		return holder.getKey().intValue();
	
	}
	public List<LibraryBranchModel> getList_of_branches() throws SQLException{
		String sql="select branchId,branchName, branchAddress from tbl_library_branch";
		return mySqlTemplate.query(sql, this);
	
	}
	
	@Override
	public List<LibraryBranchModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<LibraryBranchModel> list= new ArrayList<>();
		while(rs.next()) {
		LibraryBranchModel libModel= new LibraryBranchModel();
		libModel.setAddress(rs.getString("branchAddress"));
		libModel.setBranchId(rs.getInt("branchId"));
		libModel.setName(rs.getString("branchName"));
		libModel.setList_of_Books(bdao.readAllBooksByBranchId(rs.getInt("branchId")));
		list.add(libModel);
		}
		return list;
	}
 public void deleteBranch(int branchId) throws SQLException{
	 mySqlTemplate.update("delete from tbl_library_branch where branchId=?", new Object[] {branchId});
	 
 }
 public void addBooks(BookCopiesModel copies) throws SQLException{
	String  sql="update tbl_book_copies set noOfCopies=noOfCopies+? where bookId=? and branchId=?";
 mySqlTemplate.update(sql, new Object[] {copies.getNo_of_copies(),copies.getBookId(),copies.getBranchId()});
}}

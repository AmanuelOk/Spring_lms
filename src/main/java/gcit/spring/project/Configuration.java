package gcit.spring.project;

import javax.inject.Qualifier;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import gcit.spring.project.dao.AuthorDAO;
import gcit.spring.project.dao.BookDAO;
import gcit.spring.project.dao.BookLoansDAO;
import gcit.spring.project.dao.GenreDAO;
import gcit.spring.project.dao.LibrarianDAO;
@org.springframework.context.annotation.Configuration
public class Configuration {
	public final String url = "jdbc:mysql://localhost:3306/library";
	public final String userName = "root";
	public final String password = "selemet24!";
	public final String driver = "com.mysql.cj.jdbc.Driver";

	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setPassword(password);
		ds.setUsername(userName);
		return ds;
	}

	@Bean("bookDAO")
	public BookDAO getBookDAO() {
		return new BookDAO();
	}
	@Bean("authorDAO")
	public AuthorDAO getAuthorDAO() {
		return new AuthorDAO();
	}
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	@Bean
	public PlatformTransactionManager txManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	@Bean
	public GenreDAO genreDAO(){
		return new GenreDAO();
	}
	@Bean
	public BookLoansDAO bookLoansDAO(){
		return new BookLoansDAO();
	}
@Bean
public LibrarianDAO librarianDAO() {
	return new LibrarianDAO();
}
}

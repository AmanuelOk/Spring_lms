package gcit.spring.project.entity;

import java.util.List;

public class GenreModel {
	/**
	 * @return the genreName
	 */
	private String genreName;
	private int genreId;
	private List<BookModel> list_of_books;
	private List<AuthorsModel> list_of_authors;
	
	public String getGenreName() {
		return genreName;
	}
	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	/**
	 * @return the genreId
	 */
	public int getGenreId() {
		return genreId;
	}
	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	/**
	 * @return the list_of_books
	 */
	public List<BookModel> getList_of_books() {
		return list_of_books;
	}
	/**
	 * @param list_of_books the list_of_books to set
	 */
	public void setList_of_books(List<BookModel> list_of_books) {
		this.list_of_books = list_of_books;
	}
	/**
	 * @return the list_of_authors
	 */
	public List<AuthorsModel> getList_of_authors() {
		return list_of_authors;
	}
	/**
	 * @param list_of_authors the list_of_authors to set
	 */
	public void setList_of_authors(List<AuthorsModel> list_of_authors) {
		this.list_of_authors = list_of_authors;
	}
	
}

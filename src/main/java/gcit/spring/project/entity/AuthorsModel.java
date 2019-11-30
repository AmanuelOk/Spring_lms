package gcit.spring.project.entity;

import java.util.List;

public class AuthorsModel {
private int authorId;
private String authorName;
private List<BookModel> book_list;
private List<GenreModel> genre_list;
/**
 * @return the authorId
 */
public int getAuthorId() {
	return authorId;
}
/**
 * @param authorId the authorId to set
 */
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
/**
 * @return the authorName
 */
public String getAuthorName() {
	return authorName;
}
/**
 * @param authorName the authorName to set
 */
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
/**
 * @return the book_list
 */
public List<BookModel> getBook_list() {
	return book_list;
}
/**
 * @param list the book_list to set
 */
public void setBook_list(List<BookModel> list) {
	this.book_list = list;
}
/**
 * @return the genre_list
 */
public List<GenreModel> getGenre_list() {
	return genre_list;
}
/**
 * @param genre_list the genre_list to set
 */
public void setGenre_list(List<GenreModel> genre_list) {
	this.genre_list = genre_list;
}

}

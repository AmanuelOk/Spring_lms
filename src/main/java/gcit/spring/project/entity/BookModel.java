package gcit.spring.project.entity;

import java.util.List;

public class BookModel {
private int bookId;
private String title;
private int pubId;
private List<AuthorsModel> authorList;
private List<GenreModel> genre_list;
/**
 * @return the authorList
 */
public List<AuthorsModel> getAuthorList() {
	return authorList;
}
/**
 * @param list the authorList to set
 */
public void setAuthorList(List<AuthorsModel> list) {
	this.authorList = list;
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

/**
 * @return the bookId
 */
public int getBookId() {
	return bookId;
}
/**
 * @param bookId the bookId to set
 */
public void setBookId(int bookId) {
	this.bookId = bookId;
}
/**
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}
/**
 * @return the pubId
 */
public int getPubId() {
	return pubId;
}
/**
 * @param pubId the pubId to set
 */
public void setPubId(int pubId) {
	this.pubId = pubId;
}
}

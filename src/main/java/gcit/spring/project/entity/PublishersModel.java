package gcit.spring.project.entity;

import java.util.List;

public class PublishersModel {
private int pubId;
private String publName;
private List<BookModel> book_list;
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
/**
 * @return the publName
 */
public String getPublName() {
	return publName;
}
/**
 * @param publName the publName to set
 */
public void setPublName(String publName) {
	this.publName = publName;
}
/**
 * @return the book_list
 */
public List<BookModel> getBook_list() {
	return book_list;
}
/**
 * @param book_list the book_list to set
 */
public void setBook_list(List<BookModel> book_list) {
	this.book_list = book_list;
}

}

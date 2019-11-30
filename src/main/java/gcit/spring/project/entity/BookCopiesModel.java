package gcit.spring.project.entity;

public class BookCopiesModel {
private int bookId;
private int branchId;
private int no_of_copies;
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
 * @return the branchId
 */
public int getBranchId() {
	return branchId;
}
/**
 * @param branchId the branchId to set
 */
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
/**
 * @return the no_of_copies
 */
public int getNo_of_copies() {
	return no_of_copies;
}
/**
 * @param no_of_copies the no_of_copies to set
 */
public void setNo_of_copies(int no_of_copies) {
	this.no_of_copies = no_of_copies;
}

}

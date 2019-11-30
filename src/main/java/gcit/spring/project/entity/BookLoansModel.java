package gcit.spring.project.entity;

public class BookLoansModel {
private int bookId;
private int branchId;
private int cardNo;
private String dateOut;
private String dueDate;
private String dateIn;
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
 * @return the banchId
 */
public int getBranchId() {
	return branchId;
}
/**
 * @param banchId the banchId to set
 */
public void setBanchId(int banchId) {
	this.branchId = banchId;
}
/**
 * @return the cardNo
 */
public int getCardNo() {
	return cardNo;
}
/**
 * @param cardNo the cardNo to set
 */
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
/**
 * @return the dateOut
 */
public String getDateOut() {
	return dateOut;
}
/**
 * @param dateOut the dateOut to set
 */
public void setDateOut(String dateOut) {
	this.dateOut = dateOut;
}
/**
 * @return the dueDate
 */
public String getDueDate() {
	return dueDate;
}
/**
 * @param dueDate the dueDate to set
 */
public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}
/**
 * @return the dateIn
 */
public String getDateIn() {
	return dateIn;
}
/**
 * @param dateIn the dateIn to set
 */
public void setDateIn(String dateIn) {
	this.dateIn = dateIn;
}

}

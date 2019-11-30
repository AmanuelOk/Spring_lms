package gcit.spring.project.entity;

import java.util.List;

public class BorrowerModel {
private int cardNo;
private String name;
private String address;
private String phone;
private List<BookModel> list_of_borrowed_books;
/**
 * @return the list_of_borrowed_books
 */
public List<BookModel> getList_of_borrowed_books() {
	return list_of_borrowed_books;
}
/**
 * @param list_of_borrowed_books the list_of_borrowed_books to set
 */
public void setList_of_borrowed_books(List<BookModel> list_of_borrowed_books) {
	this.list_of_borrowed_books = list_of_borrowed_books;
}
/**
 * @return the branches_borrowed_from
 */
public List<LibraryBranchModel> getBranches_borrowed_from() {
	return branches_borrowed_from;
}
/**
 * @param branches_borrowed_from the branches_borrowed_from to set
 */
public void setBranches_borrowed_from(List<LibraryBranchModel> branches_borrowed_from) {
	this.branches_borrowed_from = branches_borrowed_from;
}
private List<LibraryBranchModel> branches_borrowed_from;
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
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}

}

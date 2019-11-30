package gcit.spring.project.entity;

import java.util.List;

public class LibraryBranchModel {
private int branchId;
private String name;
private String address;
private List<BorrowerModel> list_of_borrowers;
private List<BookModel> list_of_Books;

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
 * @return the list_of_borrowers
 */
public List<BorrowerModel> getList_of_borrowers() {
	return list_of_borrowers;
}
/**
 * @param list_of_borrowers the list_of_borrowers to set
 */
public void setList_of_borrowers(List<BorrowerModel> list_of_borrowers) {
	this.list_of_borrowers = list_of_borrowers;
}
/**
 * @return the list_of_Books
 */
public List<BookModel> getList_of_Books() {
	return list_of_Books;
}
/**
 * @param list_of_Books the list_of_Books to set
 */
public void setList_of_Books(List<BookModel> list_of_Books) {
	this.list_of_Books = list_of_Books;
}

}

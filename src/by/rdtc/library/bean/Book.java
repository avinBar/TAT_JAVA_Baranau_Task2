package by.rdtc.library.bean;

public class Book {
	private int id;
	private String title;
	private String author;
	private String status;
	//private Category category;
	/*private int year;
	private int pages;*/
	
	public Book(){
		
	}
	
	public Book(String title,String author){
		this.title=title;
		this.author=author;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	/*public Category getCategory() {
		return category;
	}*/

	/*public int getYear() {
		return year;
	}

	public int getPages() {
		return pages;
	}*/

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	/*public void setCategory(Category category) {
		this.category = category;
	}*/

	/*public void setYear(int year) {
		this.year = year;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}*/
			
}

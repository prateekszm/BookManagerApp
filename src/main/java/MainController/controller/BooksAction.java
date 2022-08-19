package MainController.controller;

import org.springframework.stereotype.Component;

@Component
public class BooksAction {
	
	private int pid;
	private String name;
	private String author;
	private int pirce;
	@Override
	public String toString() {
		return "Book [pid=" + pid + ", name=" + name + ", author=" + author + ", pirce=" + pirce + ", description="
				+ description + "]";
	}
	private String description;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPirce() {
		return pirce;
	}
	public void setPirce(int pirce) {
		this.pirce = pirce;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

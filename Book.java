// Assignment (1)
// Question: (Book subclass)
// Written by: (Eilya Nasertorabi 40183363)

package library;

public class Book extends Item {
	// Additional attributes
	private int numberOfPages;

	// Constructors
	public Book() {
		// Default constructor
	}

	public Book(String id, String name, String author, int yearOfPublication, int numberOfPages) {
		super(id, name, author, yearOfPublication);
		this.numberOfPages = numberOfPages;
	}

	public Book(Book otherBook) {
		super(otherBook.getId(), otherBook.getName(), otherBook.getAuthor(), otherBook.getYearOfPublication());
		this.numberOfPages = otherBook.numberOfPages;
	}

	// Accessors and mutators
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	// toString() method
	@Override
	public String toString() {
		return "Book{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", author='" + author + '\''
				+ ", yearOfPublication=" + yearOfPublication + ", numberOfPages=" + numberOfPages + '}';
	}

	// equals() method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		Book book = (Book) obj;
		return numberOfPages == book.numberOfPages;
	}
}

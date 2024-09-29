// Assignment (1)
// Question: (Item class)
// Written by: (Eilya Nasertorabi 40183363)

package library;

public class Item {
	// Common attributes
	protected String id;
	protected String name;
	protected String author;
	protected int yearOfPublication;

	// Constructors
	// Default constructor
	public Item() {

	}

	// Parameterized constructor
	public Item(String id, String name, String author, int yearOfPublication) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
	}

	// Copy constructor
	public Item(Item otherItem) {
		this.id = otherItem.id;
		this.name = otherItem.name;
		this.author = otherItem.author;
		this.yearOfPublication = otherItem.yearOfPublication;
	}

	// Accessors and mutators
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		// TODO Auto-generated method stub
		this.name = newName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String newAuthor) {
		// TODO Auto-generated method stub
		this.author = newAuthor;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int newYearOfPublication) {
		// TODO Auto-generated method stub
		this.yearOfPublication = newYearOfPublication;
	}

	// toString() method to generate a string representation of the item
	@Override
	public String toString() {
		return "Item{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", author='" + author + '\''
				+ ", yearOfPublication=" + yearOfPublication + '}';
	}

	// equals() method to check if two items are equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Item item = (Item) obj;
		return name.equals(item.name) && author.equals(item.author) && yearOfPublication == item.yearOfPublication;
	}
}

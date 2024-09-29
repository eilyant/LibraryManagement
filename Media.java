// Assignment (1)
// Question: (Media subclass)
// Written by: (Eilya Nasertorabi 40183363)

package library;

public class Media extends Item {
	// Additional attributes
	private String type;

	// Constructors
	public Media() {
		// Default constructor
	}

	public Media(String id, String name, String author, int yearOfPublication, String type) {
		super(id, name, author, yearOfPublication);
		this.type = type;
	}

	public Media(Media otherMedia) {
		super(otherMedia.getId(), otherMedia.getName(), otherMedia.getAuthor(), otherMedia.getYearOfPublication());
		this.type = otherMedia.type;
	}

	// Accessors and mutators (getter and setter)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// toString() method
	@Override
	public String toString() {
		return "Media{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", author='" + author + '\''
				+ ", yearOfPublication=" + yearOfPublication + ", type='" + type + '\'' + '}';
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
		Media media = (Media) obj;
		return type.equals(media.type);
	}

}

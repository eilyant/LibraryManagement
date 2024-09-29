// Assignment (1)
// Question: (Journal)
// Written by: (Eilya Nasertorabi 40183363)

package library;

public class Journal extends Item {
	// Additional attributes
	private int volumeNumber;

	// Constructors
	public Journal() {
		// Default constructor
	}

	public Journal(String id, String name, String author, int yearOfPublication, int volumeNumber) {
		super(id, name, author, yearOfPublication);
		this.volumeNumber = volumeNumber;
	}

	public Journal(Journal otherJournal) {
		super(otherJournal.getId(), otherJournal.getName(), otherJournal.getAuthor(),
				otherJournal.getYearOfPublication());
		this.volumeNumber = otherJournal.volumeNumber;
	}

	// Accessors and mutators
	public int getVolumeNumber() {
		return volumeNumber;
	}

	public void setVolumeNumber(int volumeNumber) {
		this.volumeNumber = volumeNumber;
	}

	// toString() method
	@Override
	public String toString() {
		return "Journal{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", author='" + author + '\''
				+ ", yearOfPublication=" + yearOfPublication + ", volumeNumber=" + volumeNumber + '}';
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
		Journal journal = (Journal) obj;
		return volumeNumber == journal.volumeNumber;
	}

}

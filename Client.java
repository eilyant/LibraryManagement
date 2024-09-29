// Assignment (1)
// Question: (Client class)
// Written by: (Eilya Nasertorabi 40183363)

package clients;

public class Client {
	// Attributes
	private String id;
	private String name;
	private String phoneNumber;
	private String email;

	// Constructors
	public Client() {
		// Default constructor
	}

	public Client(String id, String name, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Client(Client otherClient) {
		this.id = otherClient.id;
		this.name = otherClient.name;
		this.phoneNumber = otherClient.phoneNumber;
		this.email = otherClient.email;
	}

	// Accessors and mutators
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString() method
	@Override
	public String toString() {
		return "Client{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\''
				+ ", email='" + email + '\'' + '}';
	}

	// equals() method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Client client = (Client) obj;
		return name.equals(client.name) && phoneNumber.equals(client.phoneNumber) && email.equals(client.email);
	}

}

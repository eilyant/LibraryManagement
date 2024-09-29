// Assignment (1)
// Question: (Driver)
// Written by: (Eilya Nasertorabi 40183363)

package funReadingLibrary;

import java.util.*;
import library.*;
import clients.*;

public class LibrarySystem {

	private static Scanner scanner = new Scanner(System.in);
	private static Item[] items = new Item[100]; // Assuming a maximum of 100 items
	private static int itemCount = 0;
	private static Client[] clients = new Client[100]; // Assuming a maximum of 100 clients
	private static Lease[] leases = new Lease[100]; // Assuming a maximum of 100 leases
	private static int leaseCount = 0;
	private static int clientCount = 0;

	public static void main(String[] args) {
		// Main method to start the Library Management System
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Enter your choice:");
		System.out.println("1. Access menu");
		System.out.println("2. Run predefined scenario");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			accessMenu();
			break;
		case 2:
			runPredefinedScenario();
			break;
		default:
			System.out.println("Invalid choice");
		}

		scanner.close();
	}

	public static void accessMenu() {
		// Menu main page
		System.out.println("Menu:");
		System.out.println("1. Add an item");
		System.out.println("2. Delete an item");
		System.out.println("3. Change information of an item");
		System.out.println("4. List all items in a specific category");
		System.out.println("5. Print all items");
		System.out.println("6. Add a client");
		System.out.println("7. Edit a client");
		System.out.println("8. Delete a client");
		System.out.println("9. Lease an item to a client");
		System.out.println("10. Return an item from a client");
		System.out.println("11. Show all items leased by a client");
		System.out.println("12. Show all leased items by all clients");
		System.out.println("13. Display the biggest book");
		System.out.println("14. Make a copy of the books array");
		System.out.println("0. Exit");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		switch (choice) {
		case 1:
			addItem();
			break;
		case 2:
			deleteItem();
			break;
		case 3:
			changeItemInformation();
			break;
		case 4:
			listItemsInCategory();
			break;
		case 5:
			printAllItems();
			break;
		case 6:
			addClient();
			break;
		case 7:
			editClient();
			break;
		case 8:
			deleteClient();
			break;
		case 9:
			leaseItemToClient();
			break;
		case 10:
			returnItemFromClient();
			break;
		case 11:
			showItemsLeasedByClient();
			break;
		case 12:
			showLeasedItems();
			break;
		case 13:
			displayBiggestBook();
			break;
		case 14:
			makeCopyOfBooksArray();
			break;
		case 0:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid choice");
		}
		while (choice != 0)
			;

		scanner.close();

	}

	// method to add item between our 3 options

	private static void addItem() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select item type:");
		System.out.println("1. Book");
		System.out.println("2. Journal");
		System.out.println("3. Media");
		System.out.print("Enter choice: ");
		int itemType = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (itemType) {
		case 1:
			addBook(scanner);
			break;
		case 2:
			addJournal(scanner);
			break;
		case 3:
			addMedia(scanner);
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	private static void addBook(Scanner scanner) {
		System.out.print("Enter book name: ");
		String name = scanner.nextLine();
		System.out.print("Enter author: ");
		String author = scanner.nextLine();
		System.out.print("Enter year of publication: ");
		int year = scanner.nextInt();
		System.out.print("Enter number of pages: ");
		int pages = scanner.nextInt();

		Book newBook = new Book("B" + (itemCount + 1), name, author, year, pages);
		items[itemCount++] = newBook;
		System.out.println("Book added successfully.");
	}

	private static void addJournal(Scanner scanner) {
		System.out.print("Enter journal name: ");
		String name = scanner.nextLine();
		System.out.print("Enter author: ");
		String author = scanner.nextLine();
		System.out.print("Enter year of publication: ");
		int year = scanner.nextInt();
		System.out.print("Enter volume number: ");
		int volume = scanner.nextInt();

		Journal newJournal = new Journal("J" + (itemCount + 1), name, author, year, volume);
		items[itemCount++] = newJournal;
		System.out.println("Journal added successfully.");
	}

	private static void addMedia(Scanner scanner) {
		System.out.print("Enter media name: ");
		String name = scanner.nextLine();
		System.out.print("Enter producer: ");
		String producer = scanner.nextLine();
		System.out.print("Enter year of publication: ");
		int year = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter media type: ");
		String type = scanner.nextLine();

		Media newMedia = new Media("M" + (itemCount + 1), name, producer, year, type);
		items[itemCount++] = newMedia;
		System.out.println("Media added successfully.");
	}

	// method to delete an item in library
	private static void deleteItem() {

		System.out.print("Enter the ID of the item to delete: ");
		String idToDelete = scanner.nextLine();

		int indexToDelete = -1;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].getId().equals(idToDelete)) {
				indexToDelete = i;
				break;
			}
		}

		if (indexToDelete != -1) {
			// Shift items to the left to fill the gap created by deleting the item
			for (int i = indexToDelete; i < itemCount - 1; i++) {
				items[i] = items[i + 1];
			}
			itemCount--;
			System.out.println("Item with ID " + idToDelete + " deleted successfully.");
		} else {
			System.out.println("Item with ID " + idToDelete + " not found.");
		}
	}

	private static void changeItemInformation() {

		System.out.print("Enter the ID of the item to change information: ");
		String idToChange = scanner.nextLine();

		int indexToChange = -1;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].getId().equals(idToChange)) {
				indexToChange = i;
				break;
			}
		}

		if (indexToChange != -1) {
			Item itemToUpdate = items[indexToChange];
			System.out.println("Item found. Enter new information:");

			System.out.print("Enter new name: ");
			String newName = scanner.nextLine();
			itemToUpdate.setName(newName);

			System.out.print("Enter new author: ");
			String newAuthor = scanner.nextLine();
			itemToUpdate.setAuthor(newAuthor);

			System.out.print("Enter new year of publication: ");
			int newYear = scanner.nextInt();
			itemToUpdate.setYearOfPublication(newYear);

			if (itemToUpdate instanceof Book) {
				Book bookToUpdate = (Book) itemToUpdate;
				System.out.print("Enter new number of pages: ");
				int newPages = scanner.nextInt();
				bookToUpdate.setNumberOfPages(newPages);
			} else if (itemToUpdate instanceof Journal) {
				Journal journalToUpdate = (Journal) itemToUpdate;
				System.out.print("Enter new volume number: ");
				int newVolume = scanner.nextInt();
				journalToUpdate.setVolumeNumber(newVolume);
			} else if (itemToUpdate instanceof Media) {
				Media mediaToUpdate = (Media) itemToUpdate;
				scanner.nextLine(); // Consume newline
				System.out.print("Enter new type: ");
				String newType = scanner.nextLine();
				mediaToUpdate.setType(newType);
			}

			System.out.println("Item information updated successfully.");
		} else {
			System.out.println("Item with ID " + idToChange + " not found.");
		}
	}

	// method to list all the items based on their category
	private static void listItemsInCategory() {

		System.out.println("Select category:");
		System.out.println("1. Book");
		System.out.println("2. Journal");
		System.out.println("3. Media");
		System.out.print("Enter choice: ");
		int categoryChoice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (categoryChoice) {
		case 1:
			listItems("Book");
			break;
		case 2:
			listItems("Journal");
			break;
		case 3:
			listItems("Media");
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	private static void listItems(String category) {
		System.out.println("List of " + category + "s:");
		boolean found = false;
		for (int i = 0; i < itemCount; i++) {
			if (category.equals("Book") && items[i] instanceof Book) {
				System.out.println(items[i]);
				found = true;
			} else if (category.equals("Journal") && items[i] instanceof Journal) {
				System.out.println(items[i]);
				found = true;
			} else if (category.equals("Media") && items[i] instanceof Media) {
				System.out.println(items[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No " + category + "s found.");
		}
	}

	private static void printAllItems() {
		System.out.println("All items:");
		if (itemCount == 0) {
			System.out.println("No items found.");
		} else {
			for (int i = 0; i < itemCount; i++) {
				System.out.println(items[i]);
			}
		}
	}

	// method to add client information
	private static void addClient() {

		// Prompt user for client information
		System.out.print("Enter client ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter client name: ");
		String name = scanner.nextLine();
		System.out.print("Enter client phone number: ");
		String phoneNumber = scanner.nextLine();
		System.out.print("Enter client email address: ");
		String emailAddress = scanner.nextLine();

		// Create a new Client object using the provided information
		Client newClient = new Client(id, name, phoneNumber, emailAddress);

		// Add the new client to the clients array
		clients[clientCount++] = newClient;

		// Display success message
		System.out.println("Client added successfully.");
	}

	// method to edit client infos in library system
	private static void editClient() {

		// Prompt user for the ID of the client to edit
		System.out.print("Enter ID of the client to edit: ");
		String idToEdit = scanner.nextLine();

		// Search for the client in the clients array
		int indexToEdit = -1;
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getId().equals(idToEdit)) {
				indexToEdit = i;
				break;
			}
		}

		if (indexToEdit != -1) {
			// Client found, prompt user for new information
			Client clientToEdit = clients[indexToEdit];
			System.out.println("Enter new information for the client:");
			System.out.print("Enter new name: ");
			String newName = scanner.nextLine();
			System.out.print("Enter new phone number: ");
			String newPhoneNumber = scanner.nextLine();
			System.out.print("Enter new email address: ");
			String newEmailAddress = scanner.nextLine();

			// Update client information
			clientToEdit.setName(newName);
			clientToEdit.setPhoneNumber(newPhoneNumber);
			clientToEdit.setEmail(newEmailAddress);

			// Display success message
			System.out.println("Client information updated successfully.");
		} else {
			// Client not found
			System.out.println("Client with ID " + idToEdit + " not found.");
		}
	}

	private static void deleteClient() {

		// Prompt user for the ID of the client to delete
		System.out.print("Enter ID of the client to delete: ");
		String idToDelete = scanner.nextLine();

		// Search for the client in the clients array
		int indexToDelete = -1;
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getId().equals(idToDelete)) {
				indexToDelete = i;
				break;
			}
		}

		if (indexToDelete != -1) {
			// Shift clients to the left to fill the gap created by deleting the client
			for (int i = indexToDelete; i < clientCount - 1; i++) {
				clients[i] = clients[i + 1];
			}
			clientCount--;

			// Display success message
			System.out.println("Client with ID " + idToDelete + " deleted successfully.");
		} else {
			// Client not found
			System.out.println("Client with ID " + idToDelete + " not found.");
		}
	}

	// method to lease an item to client
	private static void leaseItemToClient() {

		// Prompt user for client ID
		System.out.print("Enter client ID: ");
		String clientId = scanner.nextLine();

		// Search for the client in the clients array
		Client client = null;
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getId().equals(clientId)) {
				client = clients[i];
				break;
			}
		}

		if (client == null) {
			// Client not found
			System.out.println("Client with ID " + clientId + " not found.");
			return;
		}

		// Prompt user for item ID
		System.out.print("Enter item ID to lease: ");
		String itemId = scanner.nextLine();

		// Search for the item in the items array
		Item itemToLease = null;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].getId().equals(itemId)) {
				itemToLease = items[i];
				break;
			}
		}

		if (itemToLease == null) {
			// Item not found
			System.out.println("Item with ID " + itemId + " not found.");
			return;
		}

		// Create a Lease object and add it to the leases array
		Lease lease = new Lease(itemToLease, client);
		leases[leaseCount++] = lease;

		// Display success message
		System.out.println("Item leased successfully.");
	}

	private static void returnItemFromClient() {

		// Prompt user for client ID
		System.out.print("Enter client ID: ");
		String clientId = scanner.nextLine();

		// Search for the client in the clients array
		Client client = null;
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getId().equals(clientId)) {
				client = clients[i];
				break;
			}
		}

		if (client == null) {
			// Client not found
			System.out.println("Client with ID " + clientId + " not found.");
			return;
		}

		// Prompt user for item ID
		System.out.print("Enter item ID to return: ");
		String itemId = scanner.nextLine();

		// Search for the lease associated with the client and the item
		Lease leaseToReturn = null;
		for (int i = 0; i < leaseCount; i++) {
			if (leases[i].getClient().getId().equals(clientId) && leases[i].getItem().getId().equals(itemId)) {
				leaseToReturn = leases[i];
				break;
			}
		}

		if (leaseToReturn == null) {
			// Lease not found
			System.out.println("No lease found for client with ID " + clientId + " and item with ID " + itemId + ".");
			return;
		}

		// Remove the lease from the leases array
		for (int i = 0; i < leaseCount; i++) {
			if (leases[i] == leaseToReturn) {
				for (int j = i; j < leaseCount - 1; j++) {
					leases[j] = leases[j + 1];
				}
				leaseCount--;
				break;
			}
		}

		// Display success message
		System.out.println("Item returned successfully.");
	}

	private static void showItemsLeasedByClient() {

		// Prompt user for client ID
		System.out.print("Enter client ID: ");
		String clientId = scanner.nextLine();

		// Search for the client in the clients array
		Client client = null;
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getId().equals(clientId)) {
				client = clients[i];
				break;
			}
		}

		if (client == null) {
			// Client not found
			System.out.println("Client with ID " + clientId + " not found.");
			return;
		}

		// Display header
		System.out.println("Items leased by client:");

		boolean found = false;
		// Search for leases associated with the client
		for (int i = 0; i < leaseCount; i++) {
			if (leases[i].getClient().getId().equals(clientId)) {
				System.out.println(leases[i].getItem());
				found = true;
			}
		}

		if (!found) {
			// No items leased by the client
			System.out.println("No items leased by client with ID " + clientId + ".");
		}
	}

	private static void showLeasedItems() {
		// Display header
		System.out.println("All leased items:");

		if (leaseCount == 0) {
			// No leases found
			System.out.println("No items are currently leased.");
			return;
		}

		// Display details of all leased items
		for (int i = 0; i < leaseCount; i++) {
			System.out.println(leases[i].getItem());
		}
	}

	private static void displayBiggestBook() {
		if (itemCount == 0) {
			// No items found
			System.out.println("No items available to find the biggest book.");
			return;
		}

		// Search for the biggest book
		Book biggestBook = null;
		int maxPages = 0;
		for (int i = 0; i < itemCount; i++) {
			if (items[i] instanceof Book) {
				Book currentBook = (Book) items[i];
				if (currentBook.getNumberOfPages() > maxPages) {
					maxPages = currentBook.getNumberOfPages();
					biggestBook = currentBook;
				}
			}
		}

		if (biggestBook != null) {
			// Display the details of the biggest book
			System.out.println("Biggest Book:");
			System.out.println(biggestBook);
		} else {
			// No books found
			System.out.println("No books available to find the biggest book.");
		}
	}

	private static Book[] makeCopyOfBooksArray() {
		// Create a new array to hold the copy of books
		Book[] copyOfBooks = new Book[itemCount];

		// Copy each book from the original items array to the copy array
		for (int i = 0; i < itemCount; i++) {
			if (items[i] instanceof Book) {
				// If the item is a book, create a copy using the copy constructor
				Book originalBook = (Book) items[i];
				Book copiedBook = new Book(originalBook); // Using the copy constructor
				copyOfBooks[i] = copiedBook;
			}
		}

		// Return the copy of books array
		return copyOfBooks;
	}

	public static void runPredefinedScenario() {
		// Creating objects
		Book book1 = new Book("B1", "Book 1", "Author 1", 2000, 300);
		Book book2 = new Book("B2", "Book 2", "Author 2", 2005, 250);
		Book book3 = new Book("B3", "Book 3", "Author 3", 2010, 400);

		Journal journal1 = new Journal("J1", "Journal 1", "Author 4", 2015, 1);
		Journal journal2 = new Journal("J2", "Journal 2", "Author 5", 2020, 2);
		Journal journal3 = new Journal("J3", "Journal 3", "Author 6", 2021, 3);

		Media media1 = new Media("M1", "Media 1", "Producer 1", 2018, "Video");
		Media media2 = new Media("M2", "Media 2", "Producer 2", 2019, "Audio");
		Media media3 = new Media("M3", "Media 3", "Producer 3", 2020, "Interactive");

		Client client1 = new Client("C1", "Client 1", "123456789", "client1@example.com");
		Client client2 = new Client("C2", "Client 2", "987654321", "client2@example.com");
		Client client3 = new Client("C3", "Client 3", "456123789", "client3@example.com");

		// Displaying information
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(journal1);
		System.out.println(journal2);
		System.out.println(journal3);
		System.out.println(media1);
		System.out.println(media2);
		System.out.println(media3);
		System.out.println(client1);
		System.out.println(client2);
		System.out.println(client3);

		// Testing equality
		System.out.println("Equality tests:");
		System.out.println("book1.equals(book2): " + book1.equals(book2));
		System.out.println("book1.equals(book3): " + book1.equals(book3));
		System.out.println("journal1.equals(journal2): " + journal1.equals(journal2));
		System.out.println("journal1.equals(journal3): " + journal1.equals(journal3));
		System.out.println("media1.equals(media2): " + media1.equals(media2));
		System.out.println("client1.equals(client2): " + client1.equals(client2));

		// Testing equality of objects from different classes
		System.out.println("Equality tests between different classes:");
		System.out.println("book1.equals(journal1): " + book1.equals(journal1));
		System.out.println("media1.equals(client1): " + media1.equals(client1));

		// Creating arrays
		Book[] books = { book1, book2, book3 };
		Media[] mediaArray = { media1, media2, media3 };

		// Finding the biggest book
		Book biggestBook = getBiggestBook(books);
		System.out.println("Biggest Book: " + biggestBook);

		// Making a deep copy of media array
		Media[] copiedMedia = copyBooks(mediaArray);
		System.out.println("Copied Media:");
		for (Media media : copiedMedia) {
			System.out.println(media);
		}
	}

	public static Book getBiggestBook(Book[] books) {
		Book biggestBook = books[0];
		for (Book book : books) {
			if (book.getNumberOfPages() > biggestBook.getNumberOfPages()) {
				biggestBook = book;
			}
		}
		return biggestBook;
	}

	public static Media[] copyBooks(Media[] original) {
		Media[] copy = new Media[original.length];
		for (int i = 0; i < original.length; i++) {
			copy[i] = new Media(original[i]);
		}
		return copy;
	}
}
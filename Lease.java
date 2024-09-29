// Assignment (1)
// Question: (Lease class)
// Written by: (Eilya Nasertorabi 40183363)

package library;

import clients.Client;

//Lease class represents the leasing of an item to a client
public class Lease {
	private Item item; // The item being leased
	private Client client; // The client leasing the item
	// Constructor

	public Lease(Item item, Client client) {
		this.item = item;
		this.client = client;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// toString() method to generate a string representation of the lease
	@Override
	public String toString() {
		return "Lease{" + "item=" + item + ", client=" + client + '}';
	}
}

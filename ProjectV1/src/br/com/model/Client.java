package br.com.model;

public class Client {
	
	
	private Long id;
	private String name;
	private String email;
	
	public Client() {
		
	}
	
	public Client(Long id, String name, String emai) {
		this.id = id;
		this.name = name;
		this.email = emai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

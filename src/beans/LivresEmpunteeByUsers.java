package beans;

public class LivresEmpunteeByUsers {
	private int isbn;
	private String titre;
	private String cin;
	private String name;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LivresEmpunteeByUsers(int isbn, String titre, String cin, String name, String date) {
	
		this.isbn = isbn;
		this.titre = titre;
		this.cin = cin;
		this.name = name;
		this.date=date;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

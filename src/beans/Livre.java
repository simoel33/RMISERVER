package beans;

import java.io.Serializable;

public class Livre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4527385508106905722L;
	
	private int isbn;
	private String title;
	private String auteur;
	private String editeur;

	public Livre(int isbn, String title, String auteur, String editeur) {
		this.isbn = isbn;
		this.title = title;
		this.auteur = auteur;
		this.editeur = editeur;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

}

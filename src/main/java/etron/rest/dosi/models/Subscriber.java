
package etron.rest.dosi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "subscriber")
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="NOM", nullable=false)
	private String nom;

	@Column(name="PRENOM", nullable=false)
	private String prenom;
	
	@Column(name="TEL", nullable=false)
	private String tel;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="ESTACHETEUR", nullable=false)
	private String estAcheteur;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	/*
	@OneToMany( mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compte> comptes = new ArrayList<>();
	*/
	public Subscriber() {}


	public Subscriber(Long id, String nom, String prenom, String tel, String email, String estAcheteur,String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.estAcheteur = estAcheteur;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstAcheteur() {
		return estAcheteur;
	}

	public void setEstAcheteur(String estAcheteur) {
		this.estAcheteur = estAcheteur;
	}



}

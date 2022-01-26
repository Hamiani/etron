package etron.rest.dosi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="password", nullable=false)
	private String password;
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subscriber_id",referencedColumnName="id",nullable=false,unique=true)
    private Subscriber subscriber;
    */
}

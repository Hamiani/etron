package etron.rest.dosi.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "abonnement")
public class Abonnement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private EnumAbonnement typeAbonnement;
	
    @ManyToOne(fetch = FetchType.EAGER)
    private Subscriber subscriber;
	

}

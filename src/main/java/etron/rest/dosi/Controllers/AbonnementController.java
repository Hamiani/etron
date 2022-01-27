package etron.rest.dosi.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import etron.rest.dosi.Repositories.AbonnementRepository;
import etron.rest.dosi.Repositories.SubscriberRepository;
import etron.rest.dosi.models.Abonnement;
import etron.rest.dosi.models.Subscriber;

@RestController
public class AbonnementController {
	
	@Autowired
	AbonnementRepository abonnementRepository;
	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	@GetMapping(value = "/abonnement/{id}")
    public List<Abonnement> findAbonnementsBySubscriber(@PathVariable(value = "id") Long id) {
		Subscriber subscriberSearch=new Subscriber();
		Optional<Subscriber> subscriber= subscriberRepository.findById(id);
		if(subscriber.isPresent()) {
			subscriberSearch=subscriber.get();
		}
		List<Abonnement> abonnements= subscriberSearch.getAbonnements();
		return null;
	}
	
}

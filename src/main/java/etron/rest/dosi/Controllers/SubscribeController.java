package etron.rest.dosi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import etron.rest.dosi.Repositories.SubscriberRepository;
import etron.rest.dosi.models.Error;
import etron.rest.dosi.models.Subscriber;

@RestController
public class SubscribeController {

	@Autowired
	SubscriberRepository subscriberRepository;

	// @GetMapping("/{id}", produces = "application/json")
	@RequestMapping(value = "/subscriber", method = RequestMethod.GET)
	public List<Subscriber> getSubscribers() {
		// List<Subscriber> subscribers= new ArrayList<Subscriber>();
		return (List<Subscriber>) subscriberRepository.findAll();

	}
	/*
	 * @RequestMapping(value = "/subscriber/{id}", method = RequestMethod.GET)
	 * public Subscriber getUser(@PathVariable int id) { return null; }
	 */

	@RequestMapping(value = "/subscriber_add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addSubscriber(@RequestBody Subscriber subscriber) {
		try {
			List<Subscriber> sub = subscriberRepository.findByEmail(subscriber.getEmail());
			if (!sub.isEmpty() && sub != null) {

				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Déja inscrit"));
			}
			Subscriber subscriberr = subscriberRepository.save(
					new Subscriber(subscriber.getId(), subscriber.getNom(), subscriber.getPrenom(), subscriber.getTel(),
							subscriber.getEmail(), subscriber.getEstAcheteur(), subscriber.getPassword()));
			return ResponseEntity.status(HttpStatus.CREATED).body(subscriberr);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Une erreur est survenue"));
		}
	}

	@DeleteMapping("/subscriber/{id}")
	public ResponseEntity<Object> deleteSubscriber(@PathVariable(value = "id") Long id) {
		try {

			subscriberRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("subscriber deleted");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

}

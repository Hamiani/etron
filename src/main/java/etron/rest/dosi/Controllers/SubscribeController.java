package etron.rest.dosi.Controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import etron.rest.dosi.Repositories.SubscriberRepository;
import etron.rest.dosi.models.Subscriber;

@RestController
public class SubscribeController {

	@Autowired
	SubscriberRepository subscriberRepository;

	//   @GetMapping("/{id}", produces = "application/json")
	@RequestMapping(value = "/subscriber", method = RequestMethod.GET)
	public List<Subscriber> getSubscribers() {
		//	List<Subscriber> subscribers= new ArrayList<Subscriber>();
		return (List<Subscriber>) subscriberRepository.findAll();

	}
	/*
	@RequestMapping(value = "/subscriber/{id}", method = RequestMethod.GET)
    public Subscriber getUser(@PathVariable int id) {
        return null;
    }
	 */


	@RequestMapping(value="/subscriber_add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addSubscriber( @RequestBody Subscriber subscriber ) {
		try {
			List<Subscriber> sub = subscriberRepository.findByEmail(subscriber.getEmail());
			if(!sub.isEmpty() && sub!=null) {
				return ResponseEntity
						.status(HttpStatus.FORBIDDEN)
						.body("déja inscrit");
			}
			Subscriber subscriberr = subscriberRepository
					.save(new Subscriber(subscriber.getId(),subscriber.getNom(),subscriber.getPrenom(),subscriber.getTel(),subscriber.getEmail(),subscriber.getEstAcheteur(),subscriber.getPassword()));
			return ResponseEntity
					.status(HttpStatus.CREATED)                 
					.body(subscriberr);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}    
	}
	
	@RequestMapping(value="/subscriber_delete/{id_subscriber}", method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Subscriber> deleteSubscriber (@PathParam("id_subscriber") Long id_subscriber ) {
		try {
		Optional<Subscriber> subscriber= subscriberRepository.findById(id_subscriber);
		
		if(!subscriber.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body(subscriber.get());
		}
		subscriberRepository.deleteById(id_subscriber);
			return ResponseEntity
				.status(HttpStatus.ACCEPTED)                 
				.body(subscriber.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	} 


}




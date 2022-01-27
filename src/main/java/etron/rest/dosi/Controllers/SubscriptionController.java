package etron.rest.dosi.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etron.rest.dosi.Repositories.SubscriptionRepository;
import etron.rest.dosi.Repositories.UserRepository;
import etron.rest.dosi.models.Subscription;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SubscriptionController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@GetMapping(value = "/subscriptions")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Subscription> findAbonnements() {
		return subscriptionRepository.findAll();
	}

	@GetMapping(value = "/subscriptions/{id}")
	public Optional<Subscription> subscription(@PathVariable Long id) {
		return subscriptionRepository.findById(id);
	}
}

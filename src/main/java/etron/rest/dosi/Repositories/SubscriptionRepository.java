package etron.rest.dosi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import etron.rest.dosi.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
	 
}

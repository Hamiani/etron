package etron.rest.dosi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import etron.rest.dosi.models.Abonnement;
import etron.rest.dosi.models.Subscriber;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long>{
	 
}

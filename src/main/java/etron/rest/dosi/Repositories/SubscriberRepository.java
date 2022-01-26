package etron.rest.dosi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import etron.rest.dosi.models.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber,Long>
{
	 @Query("select s from subscriber s where s.email =?1")
	  List<Subscriber> findByEmail ( String email);
	

}

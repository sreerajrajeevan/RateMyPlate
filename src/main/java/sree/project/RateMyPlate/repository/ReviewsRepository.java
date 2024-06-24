package sree.project.RateMyPlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sree.project.RateMyPlate.model.Reviews;
@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {
}

package zci.training.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zci.training.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}

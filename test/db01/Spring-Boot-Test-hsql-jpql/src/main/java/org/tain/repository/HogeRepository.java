package org.tain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tain.domain.Hoge;

public interface HogeRepository extends JpaRepository<Hoge, Long>{

	@Query("SELECT h FROM Hoge h WHERE (h.id % 2) = 0")
	List<Hoge> findEvenIdEntities();
}

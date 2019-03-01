package org.tain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tain.domain.Hoge;

public interface HogeRepository extends JpaRepository<Hoge, Long>{

}

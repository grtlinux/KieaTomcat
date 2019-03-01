package org.tain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tain.domain.MyEntity;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long>{

}

package org.tain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.Item23;

@RepositoryRestResource
public interface Item23Repository extends JpaRepository<Item23, Long>{

}

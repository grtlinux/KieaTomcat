package org.tain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.Item01;

@RepositoryRestResource
public interface Item01Repository extends JpaRepository<Item01, Long>{

}

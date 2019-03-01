package org.tain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tain.domain.Hoge;

@Repository
public interface HogeRepository extends JpaRepository<Hoge, Long> {

	List<Hoge> findByNumber(int number);
	
	List<Hoge> findByNumberOrderByIdDesc(int number);
	
	List<Hoge> findByStringLike(String string);
	
	List<Hoge> findByNumberLessThan(int number);
	
	List<Hoge> findByStringIgnoreCase(String string);
	
	List<Hoge> findByFugaValue(String string);
	
	long countByStringLike(String string);
	
	List<Hoge> findByNumberAndStringLike(int number, String string);
	
	List<Hoge> findByNumberOrString(int number, String string);
}

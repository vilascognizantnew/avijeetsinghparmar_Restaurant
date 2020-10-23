package com.cts.avijeet.dao;

import org.springframework.stereotype.Repository;

import com.cts.avijeet.model.Menu;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MenuDAO extends CrudRepository<Menu, Integer> {

	
	@Query(nativeQuery = true, value = "select * from menu order by price desc limit 5;")
	
	
	public List<Menu> findTopFiveMenus();

	public Optional<Menu> findByMenuName(String name);

	public List<Menu> findByPriceBetween(Double startPrice, Double endPrice);


	public List<Menu> findByDateBetween(Date startDate, Date endDate);
}

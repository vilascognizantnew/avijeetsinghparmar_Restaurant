package com.cts.avijeet.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.avijeet.dao.MenuDAO;
import com.cts.avijeet.model.Menu;

@Service
public class MenuService {
	
	@Autowired
	MenuDAO menuDao;
	
	public List<Menu> allMenu(){
		return (List<Menu>) MenuDao.findAll();
	}
	
	public List<Menu> topFiveStock(){
		return (List<Menu>) menuDao.findTopFiveMenus();
	}
	
	public Menu searchMenuById(int id){
		Optional<Menu> m = MenuDao.findById(id);
		if(m.isPresent()){
			return m.get();
		}
		return null;
	}
	
	public Menu searchMenuByName(String name){
		Optional<Menu> m = menuDao.findByMenuName(name);
		if(m.isPresent()){
			return m.get();
		}
		return null;
	}
	
	public List<Menu> searchMenuByPrice(Double startPrice, Double endPrice){
		return (List<Menu>) menuDao.findByPriceBetween(startPrice,endPrice);
	}
	
	
	public List<Menu> searchMenuByDate(Date startDate, Date endDate){
		return (List<Menu>) menuDao.findByDateBetween(startDate,endDate);
	}

}

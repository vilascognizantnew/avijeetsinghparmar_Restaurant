package com.cts.avijeet.MenuController;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.avijeet.model.Menu;

@Controller
public class MenuController {

	@GetMapping(value="/allMenus")
	public ResponseEntity<?> menuList()
	{
		return new ResponseEntity<List<Menu>>(menuService.allMenu(),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/searchMenuById/{id}")
	public ResponseEntity<?> searchMenuById(@PathVariable("id") int id)
	{
		menu mn = menuService.searchMenuById(id);
		if(mn==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Menu>(mn,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchMenuByName/{name}")
	public ResponseEntity<?> searchMenuById(@PathVariable("name") String name)
	{
		Menu m = menuService.searchMenuByName(name);
		if(m==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Menu>(m,HttpStatus.OK);
}
	
	@GetMapping(value="/topFiveMenus")
	public ResponseEntity<?> topFiveMenus()
	{
		return new ResponseEntity<List<Menu>>(menuService.topFiveMenu(),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/searchMenuByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchMenuByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<Menu> m= menuService.searchMenuByPrice(startPrice,endPrice);
		if(m.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Menu>>(m,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/searchMenuByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchMenuById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Menu> m = menuService.searchMenukByDate(startDate,endDate);
		if(m.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Menu>>(m,HttpStatus.OK);
	}
}
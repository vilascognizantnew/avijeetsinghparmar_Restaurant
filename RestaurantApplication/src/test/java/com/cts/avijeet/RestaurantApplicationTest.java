package com.cts.avijeet;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.avijeet.model.Menu;
import com.cts.avijeet.service.MenuService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantApplicationTest {
	
	@MockBean
	MenuDao menuDao;

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	MenuService menuImpl;
	
	@Before
	public void init() {
		Menu menu = new Menu(1,"Ice Cream",150.25,150,new Date(2020-06-01));
		
		when(MenuDao.findById(1)).thenReturn(Optional.of(menu));
	}

	@WithMockUser("USER")
	@Test
	public void testFindId() throws Exception{
		mockMvc.perform(get("/stock/getStocksById/1"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("Ice cream")))
        .andExpect(jsonPath("$.price", is(150.25)))
        
        .andExpect(jsonPath("$.date", is(new Date(2020-06-01))));
	}
	
	@WithMockUser("USER")
	@Test
	public void testFindName() throws Exception{
		mockMvc.perform(get("/stock/findByName/cts"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("Ice cream")))
        .andExpect(jsonPath("$.price", is(150.25)))
        
        .andExpect(jsonPath("$.date", is(new Date(2020-06-01))));
	}
	
	@WithMockUser("USER")
	@Test
    public void findAll() throws Exception {
        // given
        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("Menu 1");
        menu.setPrice(150.0);
      
        menu.setDate(new Date(2020-05-05));
        
        List<Menu> menus = Arrays.asList(menu);
        given(menuImpl.allMenu()).willReturn(menus);

        // when + then
        this.mockMvc.perform(get("/menu/getMenus"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json("[{'id': 1,'name': 'Stock 1';'price': 150.0;'volume':120;'date':'2020-06-01'}]"));
    }
	
	private Object given(List<Menu> allMenu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testMenuDelete() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/stock/menuById/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}

}

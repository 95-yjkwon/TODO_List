package com.keduit.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
@Log4j
public class TodoControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
		}
	
	@Test
	public void testList()throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/todo/list")).andReturn().getModelAndView().getModelMap());
				
	}
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/todo/get")
				.param("tno", "2"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	@Test
	public void testModify()throws Exception{
		String resultPage=mockMvc.perform(MockMvcRequestBuilders.post("/todo/modify")
						.param("tno", "1")
						.param("title", "목씨에서 수정했다")
						.param("writer", "영춘권")
						.param("finished", "1")).andReturn().getModelAndView().getViewName();
	}
	
	@Test
	public void testRemove()throws Exception{
		String resultPage=mockMvc.perform(MockMvcRequestBuilders.post("/todo/remove")
						.param("tno", "5")).andReturn().getModelAndView().getViewName();
		
						log.info("============resultpage==========="+resultPage);
	}

}

package com.keduit.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.keduit.domain.TodoVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TodoServiceTests {
	@Autowired
	private TodoService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		TodoVO todo=new TodoVO();
		todo.setTitle("서비스에서 왔찌롱~");
		todo.setWriter("용춘권이닷");
		todo.setFinished(0);
		service.register(todo);
		log.info("생성된 게시물 번호"+todo.getTno());
	}
	
	
	
	@Test
	public void testGet() {
		service.get(4L);
	}
	
	@Test
	public void testUpdate() {
		TodoVO todo=service.get(4L);
		if(todo==null) {
			return;
		}
		todo.setTitle("서비스 테스트에서 수정했다이");
		log.info("=======testupdate==="+service.modify(todo));
	}
	
	@Test
	public void testDelete() {
		log.info("...............testDelete"+service.remove(53L));
	}

}

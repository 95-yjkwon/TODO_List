package com.keduit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.keduit.domain.TodoVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	@Setter(onMethod_ =@Autowired)
	private TodoMapper mapper;
	
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(todo->log.info(todo));
	}
	
	
	
	@Test
	public void testInsert() {
		TodoVO todo=new TodoVO();
		todo.setTitle("테스트에서 추가함");
		todo.setWriter("user00");
		todo.setFinished(1);
		mapper.insert(todo);
		log.info(todo);
	}
	
	@Test
	
	public void testInsertSelectKey() {
		TodoVO todo=new TodoVO();
		todo.setTitle("insert셀렉트 키에서 추가함");
		todo.setWriter("user01");
		todo.setFinished(0);
		mapper.insertSelectKey(todo);
		log.info("==========insertselectkey======"+todo);
	}
	
	@Test
	public void testRead() {
		TodoVO todo=mapper.read(4L);
		log.info("=======read======"+todo);
	}
	
	@Test
	public void testDelete() {
		log.info("delete count:"+mapper.delete(3L));
	}
	@Test
	public void testUpdate() {
		TodoVO todo=new TodoVO();
		todo.setTno(4L);
		todo.setTitle("TEST에서 수정했따잉~~");
		todo.setWriter("영춘권");
		todo.setFinished(1);
		
		int count=mapper.update(todo);
		log.info("===========update count========="+count);
	}
	
	

}

package com.keduit.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.keduit.domain.TodoVO;
import com.keduit.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	
	private final TodoMapper mapper;
	
	@Override
	public void register(TodoVO todo) {
		log.info("===============register========="+todo);
		mapper.insertSelectKey(todo);
		
	}

	//한건 읽기
	@Override
	public TodoVO get(Long tno) {
		log.info("=========get=========="+tno);
		return mapper.read(tno);
	}

	@Override
	public boolean modify(TodoVO todo) {
		log.info("============modify======="+todo);
		return mapper.update(todo)==1;
	}

	@Override
	public boolean remove(Long tno) {
		log.info("=========remove======="+tno);
		return mapper.delete(tno)==1;
	}

	@Override
	public List<TodoVO> getList() {
		log.info("======getList========");
		return mapper.getList();
	}



}

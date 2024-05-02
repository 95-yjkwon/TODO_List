package com.keduit.service;

import java.util.List;


import com.keduit.domain.TodoVO;

public interface TodoService {
	//등록
	public void register(TodoVO todo);
	//한건 읽어오기
	public TodoVO get(Long tno);
	//수정
	public boolean modify(TodoVO todo);
	//삭제
	public boolean remove(Long tno);
	//목록 읽기
	public List<TodoVO> getList();


}

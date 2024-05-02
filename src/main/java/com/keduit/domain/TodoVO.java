package com.keduit.domain;

import java.util.Date;

import lombok.Data;
@Data
public class TodoVO {
	private Long tno;
	private String title;
	private Date dueDate;
	private String writer;
	private int finished;
	private Date regdate;

}

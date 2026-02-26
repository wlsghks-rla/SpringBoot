package com.example.demo.board.mapper;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReplyVO {
	String rno;
	String bno;
	String reply;
	String replyer;
	Date replydate;
	Date updatedate;
}

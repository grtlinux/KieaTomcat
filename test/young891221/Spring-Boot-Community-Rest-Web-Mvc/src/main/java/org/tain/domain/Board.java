package org.tain.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.tain.domain.enums.BoardType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private String title;
	
	@Column
	private String subTitle;
	
	@Column
	private String content;
	
	@Column
	@Enumerated(EnumType.STRING)
	private BoardType boardType;
	
	@Column
	private LocalDateTime createdDate;
	
	@Column
	private LocalDateTime updatedDate;
	
	//@OneToOne
	//private User user;

	@Builder
	public Board(
			String title,
			String subTitle,
			String content,
			BoardType boardType,
			LocalDateTime createdDate,
			LocalDateTime updatedDate
			/*, User user */) {
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.boardType = boardType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		//this.user = user;
	}
	
	public void setCreatedDateNow() {
		this.createdDate = LocalDateTime.now();
	}
	
	public void update(Board board) {
		this.title = board.getTitle();
		this.subTitle = board.getSubTitle();
		this.content = board.getContent();
		this.boardType = board.getBoardType();
		this.updatedDate = board.getUpdatedDate();
	}
}

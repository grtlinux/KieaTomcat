package org.tain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.tain.domain.Board;
import org.tain.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public Page<Board> findBoardList(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1
				, pageable.getPageSize()
				, Sort.Direction.DESC
				, "idx");
		return this.boardRepository.findAll(pageable);
	}
	
	public Board findBoardById(Long idx) {
		return this.boardRepository.findById(idx).orElse(new Board());
	}
}

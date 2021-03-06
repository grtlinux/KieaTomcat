package org.tain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tain.service.BoardService;

@Controller
@RequestMapping(value = {"/board"})
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = {"", "/"})
	public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
		model.addAttribute("board", this.boardService.findBoardById(idx));
		return "/board/form";
	}
	
	@GetMapping(value = {"/list"})
	public String list(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("boardList", this.boardService.findBoardList(pageable));
		return "/board/list";
	}
}

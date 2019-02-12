package org.tain.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.domain.Board;
import org.tain.repository.BoardRepository;

@RestController
@RequestMapping("/api/boards")
public class BoardRestController {

	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBoards(@PageableDefault Pageable pageable) {
		Page<Board> boards = this.boardRepository.findAll(pageable);
		PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), boards.getNumber(), boards.getTotalElements());
		PagedResources<Board> resources = new PagedResources<>(boards.getContent(), pageMetadata);
		resources.add(linkTo(methodOn(BoardRestController.class).getBoards(pageable)).withSelfRel());
		return ResponseEntity.ok(resources);
	}
	
	@PostMapping
	public ResponseEntity<?> postBoard(@RequestBody Board board) {
		// valid check
		board.setCreatedDateNow();
		this.boardRepository.save(board);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);
	}
	
	@PutMapping("/{idx}")
	public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody Board board) {
		// valid check
		Board persistBoard = this.boardRepository.getOne(idx);
		persistBoard.update(board);
		this.boardRepository.save(persistBoard);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
	
	@DeleteMapping("/{idx}")
	public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {
		// valid check
		this.boardRepository.deleteById(idx);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
}

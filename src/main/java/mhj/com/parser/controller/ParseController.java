package mhj.com.parser.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mhj.com.parser.dto.Test200Dto;
import mhj.com.parser.service.ParseService;

@Slf4j
@RestController
@RequestMapping(path="/parse", produces="application/json")
@CrossOrigin(origins="*") 
public class ParseController {
	
	private ParseService parseService;

	@Autowired
	public ParseController(ParseService parseService) {
		this.parseService = parseService;
	}

	@GetMapping("parse-c6")
	public ResponseEntity<?> test200() {
		log.info("test 200");
		return ResponseEntity.ok(Test200Dto.builder().retorno("Retorno 200 ok").build());
	}

	@GetMapping("parse-inter/{arquivo}")
	public void parseInter(@PathVariable String arquivo) throws IOException {
		log.error("parse inter");
		parseService.parseInter(arquivo);
	}

}

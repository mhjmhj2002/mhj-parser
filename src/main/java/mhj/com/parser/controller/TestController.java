package mhj.com.parser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mhj.com.parser.dto.Test200Dto;
import mhj.com.parser.exception.ServerErrorException;

@Slf4j
@RestController
@RequestMapping(path="/test", produces="application/json")
@CrossOrigin(origins="*") 
public class TestController {

	@GetMapping("test-200")
	public ResponseEntity<?> test200() {
		log.info("test 200");
		return ResponseEntity.ok(Test200Dto.builder().retorno("Retorno 200 ok").build());
	}

	@GetMapping("test-500")
	public void test500() throws ServerErrorException {
		log.error("test 500");
		throw new ServerErrorException("Erro interno servidor");
	}

}

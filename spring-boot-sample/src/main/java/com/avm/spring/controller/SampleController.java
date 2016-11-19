/**
 * 
 */
package com.avm.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amod Mulay
 *
 */
@RestController
@RequestMapping("/avm/worksample")
public class SampleController {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Object o) {
		return new ResponseEntity<Object>(o, HttpStatus.CREATED);
	}

	@RequestMapping(value = "{email:.+}", method = RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable("email") String email) {
		return new ResponseEntity<Object>(email, HttpStatus.OK);

	}

	@RequestMapping(value = "i/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> findById(@PathVariable("id") long id) {

		return new ResponseEntity<Object>(id, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "page", "size" })
	public ResponseEntity<List<Object>> findAllPagable(@RequestParam("page") int page, @RequestParam("size") int size) {
		return new ResponseEntity<List<Object>>(new ArrayList<Object>(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> findAll() {
		return new ResponseEntity<List<Object>>(new ArrayList<Object>(), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") long id) {

		return new ResponseEntity<Object>(id, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody Object o) {
		return new ResponseEntity<Object>(o, HttpStatus.CREATED);
	}

}

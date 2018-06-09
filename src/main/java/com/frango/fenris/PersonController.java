package com.frango.fenris;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;
	
	private static final List<PersonRequest> mockDB = new ArrayList<>();

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public BaseResponse add(@RequestBody PersonRequest request) {
		mockDB.add(request);
		BaseResponse response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
		return response;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<PersonRequest> getAll() {
		return mockDB;
	}
	
	@RequestMapping(value = "/{index}", method = RequestMethod.GET)
	public PersonRequest get(@PathVariable("index") int index) {
		return mockDB.get(index);
	}

}

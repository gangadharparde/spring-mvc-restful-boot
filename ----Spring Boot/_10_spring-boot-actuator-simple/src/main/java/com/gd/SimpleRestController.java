package com.gd;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	@GetMapping("/actuator/beans")
	public void example() {
		return ";
	}
}

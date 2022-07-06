package com.gd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gd.dao.EmpDao;
import com.gd.model.Emp;

`  //@RestController=@Controller+@ResponseBody
@RequestMapping("api/v1")
public class RestEmpController {

	@Autowired
	EmpDao dao;// will inject dao from xml file

	@GetMapping("/employees")  //@RequestMapping(method = RequestMethod.GET)
	public List<Emp> getAllEmployees() {
		return dao.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id) {
		Emp emp = dao.getEmpById(id);
		if (emp == null) {
			return new ResponseEntity<Object>("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(emp, HttpStatus.OK);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<Object> insertEmployee(@RequestBody Emp emp) {
		dao.save(emp);
		return new ResponseEntity<Object>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		dao.delete(id);
		return new ResponseEntity<Object>("Employee deleted with ID " + id, HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Emp emp) {
		if (null == emp) {
			return new ResponseEntity<Object>("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}
		Emp updatedEmp = dao.update(id, emp);
		return new ResponseEntity<Object>(updatedEmp, HttpStatus.OK);
	}

}

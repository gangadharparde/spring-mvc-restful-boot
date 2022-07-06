package com.gd;

import static java.util.Arrays.asList;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gd.model.Employee;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(Application.class, args);
		Application employeeClient = new Application();
		System.out.println("---------------------------------------------");
		System.out.println("Calling getPlainJson()");
		getPlainJson();
		System.out.println("---------------------------------------------");
		System.out.println("Calling getHeaders()");
		getHeaders();
		System.out.println("---------------------------------------------");
		System.out.println("Calling GET array of entity using getForEntityEmployeesAsArray(");
		employeeClient.getForEntityEmployeesAsArray();
		System.out.println("---------------------------------------------");
		System.out.println("Calling POST using callPostForObject()");
		employeeClient.callPostForObject();
		System.out.println("---------------------------------------------");
		System.out.println("Calling GET using ParameterizedTypeReference");
		employeeClient.getAllEmployeesUsingParameterizedTypeReference();
		System.out.println("---------------------------------------------");
		System.out.println("Calling all allowed HTTP methods getAllowedHttpMethods()");
		getAllowedHttpMethods();

		
		employeeClient.callMovideDatabase();
	}

	private static void getAllowedHttpMethods() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/api/v1/employees/";
		Set<HttpMethod> optionsForAllow = restTemplate.optionsForAllow(fooResourceUrl);
		System.out.print(fooResourceUrl + "supported HTTP method(s):");
		optionsForAllow.forEach(x -> System.out.print(x + " "));
		System.out.println();
		fooResourceUrl = "http://localhost:8080/api/v1/employees/101";
		optionsForAllow = restTemplate.optionsForAllow(fooResourceUrl);
		System.out.print(fooResourceUrl + "supported HTTP method(s):");
		optionsForAllow.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void getPlainJson() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/api/v1/employees/";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/101", String.class);
		System.out.println(response.getStatusCode() == HttpStatus.OK);
		System.out.println(response.getBody().toString());
	}

	private static void getHeaders() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/api/v1/employees/";
		HttpHeaders httpHeaders = restTemplate.headForHeaders(fooResourceUrl);
		httpHeaders.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
	}

	public Employee[] getForEntityEmployeesAsArray() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/api/v1/employees/",
				Employee[].class);

		Employee[] employees = response.getBody();

		assert employees != null;
		asList(employees).forEach(System.out::println);

		return employees;

	}

	public List<Employee> getAllEmployeesUsingParameterizedTypeReference() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Employee>> response = restTemplate.exchange("http://localhost:8080/api/v1/employees/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
				});

		List<Employee> employees = response.getBody();

		assert employees != null;
		employees.forEach(System.out::println);

		return employees;
	}

	public void callPostForObject() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/api/v1/employees/";
		HttpEntity<Employee> request = new HttpEntity<>(
				new Employee(200L, "G", "D", "gd@gd.com", 19, null, null, null));
		Employee savedEmployee = restTemplate.postForObject(fooResourceUrl, request, Employee.class);
		System.out.println(savedEmployee);
	}

	public void callMovideDatabase() throws UnsupportedEncodingException {
		String query = String.format("q=%s", URLEncoder.encode("game of thr", Constant.CHARSET).replace("+", "%20"));
		System.out.println(query);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
		headers.set("X-RapidAPI-Host", Constant.x_rapidapi_host); 
		headers.set("X-RapidAPI-Key", Constant.x_rapidapi_key); 
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(Constant.HOST + "?" + query, HttpMethod.GET, entity, String.class);
		System.out.println(response.getStatusCode() == HttpStatus.OK);
		System.out.println(response.getBody().toString());
		
		//format and see table --> https://www.convertjson.com/json-to-html-table.htm
		//https://rapidapi.com/apidojo/api/online-movie-database/
	}
}

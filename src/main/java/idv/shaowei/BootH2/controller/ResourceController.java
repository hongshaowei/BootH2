package idv.shaowei.BootH2.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.shaowei.BootH2.entity.Billionaire;
import idv.shaowei.BootH2.service.Service;

@RestController
@RequestMapping("/api/v1/billionaires")
public class BillionaireController {
	private Service<Billionaire> service;
	
	@Autowired
	public BillionaireController(Service<Billionaire> service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public Optional<Billionaire> fetchById(@PathVariable int id) {
		return service.fetch(id);
	}
	
	@GetMapping("/all")
	public List<Billionaire> fetchAll() {
		return service.fetchAll();
	}
	
	@PostMapping("/new")
	public Map<String, Integer> save(@RequestBody Billionaire b) {
		service.save(b);
		return Stream.of(new Object[][] { {"RC", 1} }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
	}
	
	@PostMapping("/{id}/edit")
	public Map<String, Integer> update(@PathVariable int id, @RequestBody Map<String, String> map) {
		service.update(id, map);
		return Stream.of(new Object[][] { {"RC", 1} }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
	}
	
	@PostMapping("/{id}/discard")
	public Map<String, Integer> delete(@PathVariable int id) {
		service.delete(id);
		return Stream.of(new Object[][] { {"RC", 1} }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
	}
}

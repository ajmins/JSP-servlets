package com.example.StudentCrud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	ContactRepository contactRepository;
	
	@GetMapping("/api")
	public String test() {
		try {
			Optional<Person> p2 = personRepo.findById(1);
			if(p2.isPresent()) {
				Person p2Obj = p2.get();
				System.out.println(p2Obj.toString());
			}
			System.out.println("Contact"+contactRepository.findById(new ContactPK(210, 210)).get());
			
		} catch (Exception e) {
		}
		return "hello";
		
	}

}

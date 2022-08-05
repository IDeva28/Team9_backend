package com.db.grad.javaapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;


@RestController
@RequestMapping("/api/v2")
public class SecurityController {
	
	@Autowired
    private SecurityRepository securityRepository;    

    @GetMapping("/security")
    public List<Security> getAllDogs() {
        return securityRepository.findAll();
    }
    
    @GetMapping("/security/{id}")
    public ResponseEntity < Security > getSecurityById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Security security = securityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));
        return ResponseEntity.ok().body(security);
    }

    @PostMapping("/security")
    public Security createDog(@Valid @RequestBody Security security) {
        return securityRepository.saveAndFlush(security);
    }

//    @PutMapping("/dogs/{id}")
//    public ResponseEntity < Dogs > updateSecurity(@PathVariable(value = "id") Long id,
//        @Valid @RequestBody Dogs securityDetails) throws ResourceNotFoundException {
//    	Security getSecurity = securityRepository.findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));
//
//    	getSecurity.setName(securityDetails.getName());
//    	getSecurity.setAge(securityDetails.getAge());
//        final Security updatedSecurity = securityRepository.save(getSecurity);
//        return ResponseEntity.ok(updatedSecurity);
//    }

    @DeleteMapping("/security/{id}")
    public Map < String, Boolean > deleteSecurity(@PathVariable(value = "id") Long id)
    throws Exception {
    	Security security = securityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));

    	securityRepository.delete(security);
        Map < String, Boolean > response = new HashMap <>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

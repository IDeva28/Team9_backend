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
import com.db.grad.javaapi.model.Trade;
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
    
    @GetMapping("/security/{id}/trade")
    public ResponseEntity < List<Trade> > getAllTradesBySecurityId(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	Security security = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));
    	List<Trade> trade = security.getTrade();
        return ResponseEntity.ok().body(trade);
    }

    @PostMapping("/security")
    public Security createDog(@Valid @RequestBody Security security) {
        return securityRepository.saveAndFlush(security);
    }

    @PutMapping("/security/{id}")
    public ResponseEntity < Security > updateSecurity(@PathVariable(value = "id") Long id,
        @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
    	Security getSecurity = securityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));

    	getSecurity.setFacevalue(securityDetails.getFacevalue());
    	getSecurity.setMaturity_date(securityDetails.getMaturity_date());
    	getSecurity.setStatus(securityDetails.getStatus());
    	getSecurity.setCoupon(securityDetails.getCoupon());
    	getSecurity.setIssuer(securityDetails.getIssuer());
        final Security updatedSecurity = securityRepository.save(getSecurity);
        return ResponseEntity.ok(updatedSecurity);
    }

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

package com.db.grad.javaapi.controller;

import java.sql.Date;
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
@RequestMapping("/api/v1")
public class SecurityController {
	
	@Autowired
    private SecurityRepository securityRepository;    

    @GetMapping("/security")
    public List<Security> getAllSecurity() {
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
    
    @GetMapping("/security/status/{status}")
    public List<Security> getSecurityByStatus(@PathVariable(value = "status") String status){
    	List<Security> security = securityRepository.getAllByStatus(status);
    	return security;
    }
    
    @GetMapping("/security/user/{userId}")
    public ResponseEntity < List<Security> > getSecurityByUserId(@PathVariable(value = "userId") Long userId)
    throws ResourceNotFoundException {
        List<Security> security = securityRepository.getSecurityByUserId(userId);
        return ResponseEntity.ok().body(security);
    }
    
    @PostMapping("/security/dateRange")
    public ResponseEntity <List< Security >> getSecurityByMaturityDateRange(@Valid @RequestBody Map<String, Date> inputDate)
    throws ResourceNotFoundException {
    	System.out.println(inputDate.get("From"));
    	
        List<Security> security = (List<Security>) securityRepository.getSecurityByMaturityDate(inputDate.get("From").toLocalDate(),inputDate.get("To").toLocalDate());
        return ResponseEntity.ok().body(security);
    }
    
    @PostMapping("/security/add")
    public Security createSecurity(@Valid @RequestBody Security security) {
        return securityRepository.saveAndFlush(security);
    }

    @PutMapping("/security/update/{id}")
    public ResponseEntity < Security > updateSecurity(@PathVariable(value = "id") Long id,
        @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
    	Security getSecurity = securityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));

    	getSecurity.setFacevalue(securityDetails.getFacevalue());
    	getSecurity.setMaturity_date(securityDetails.getMaturity_date());
    	getSecurity.setStatus(securityDetails.getStatus());
    	getSecurity.setCoupon(securityDetails.getCoupon());
    	getSecurity.setIssuer(securityDetails.getIssuer());
    	getSecurity.setAction(securityDetails.getAction());
    	getSecurity.setIssue(securityDetails.getIssue());
    	
    	
        final Security updatedSecurity = securityRepository.save(getSecurity);
        return ResponseEntity.ok(updatedSecurity);
    }

    @DeleteMapping("/security/delete/{id}")
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

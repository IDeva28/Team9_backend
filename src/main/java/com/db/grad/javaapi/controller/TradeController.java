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
import com.db.grad.javaapi.repository.TradeRepository;


@RestController
@RequestMapping("/api/v1")
public class TradeController {
	@Autowired
    private TradeRepository tradeRepository;

    @GetMapping("/trade")
    public List < Trade > getAllTrades() {
        return tradeRepository.findAll();
    }

    @GetMapping("/trade/{id}")
    public ResponseEntity < Trade > getTradeById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Trade trade = tradeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));
        return ResponseEntity.ok().body(trade);
    }

    @PostMapping("/trade/add")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        return tradeRepository.saveAndFlush(trade);
    }

    @PutMapping("/trade/update/{id}")
    public ResponseEntity < Trade > updateTrade(@PathVariable(value = "id") Long id,
        @Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {
    	Trade getTrade = tradeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));

    	getTrade.setStatus(tradeDetails.getStatus());
    	getTrade.setPrice(tradeDetails.getPrice());
    	getTrade.setBuy_sell(tradeDetails.getBuy_sell());
    	getTrade.setQuantity(tradeDetails.getQuantity());
    	getTrade.setSettlement_date(tradeDetails.getSettlement_date());
    	getTrade.setTrade_date(tradeDetails.getTrade_date());
        final Trade updatedTrade = tradeRepository.save(getTrade);
        return ResponseEntity.ok(updatedTrade);
    }

    @DeleteMapping("/trade/delete/{id}")
    public Map < String, Boolean > deleteTrade(@PathVariable(value = "id") Long id)
    throws Exception {
    	Trade trade = tradeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));

    	tradeRepository.delete(trade);
        Map < String, Boolean > response = new HashMap <>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    @GetMapping("/trade/{id}/security")
    public ResponseEntity < Security > getAllSecurityByTradeId(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trade not found for this id :: " + id));
    	Security security = trade.getSecurity();
        return ResponseEntity.ok().body(security);
    }

}

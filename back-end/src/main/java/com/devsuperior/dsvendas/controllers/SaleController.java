package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.services.SaleServices;


@RestController
@RequestMapping(value ="/sales")
public class SaleController {

	@Autowired
	private SaleServices saleServices;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public Sale user(@RequestBody Sale sale) {
		return this.saleRepository.save(sale);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public Page<SaleDTO> findAll(Pageable pageable) {
		return this.saleServices.findAll(pageable);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/amountBySeller")
	public List<SaleSumDTO> amountGroupedBySeller() {
		return this.saleServices.amountGroupedBySeller();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/successBySeller")
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return this.saleServices.successGroupedBySeller();
	}

}

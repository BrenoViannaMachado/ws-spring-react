package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dsvendas.services.SellerServices;


@RestController
@RequestMapping(value ="/sellers")
public class SellerController {

	@Autowired
	private SellerServices sellerServices;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public Seller user(@RequestBody Seller seller) {
		return this.sellerRepository.save(seller);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<SellerDTO> findAll() {
		return this.sellerServices.findAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public Seller deleteUser(@PathVariable("id")Long id) {
		return sellerServices.deleteSeller(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Seller userId(@PathVariable("id") Long id) {
		return sellerServices.findById(id);
	}
}

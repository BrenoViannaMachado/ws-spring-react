package com.devsuperior.dsvendas.services;

import java.util.List;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;

public interface SellerServices {

	Seller findById(Long id);

	Seller deleteSeller(Long id);
	
	List<SellerDTO> findAll();
}

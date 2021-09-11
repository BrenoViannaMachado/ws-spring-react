package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;

public interface SaleServices {

	Page<SaleDTO> findAll(Pageable pageable);
	
	List<SaleSumDTO> amountGroupedBySeller();
	
	List<SaleSuccessDTO> successGroupedBySeller();
}

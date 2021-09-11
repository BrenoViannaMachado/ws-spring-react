package com.devsuperior.dsvendas.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsvendas.dto.SaleDTO;

public interface SaleServices {

	Page<SaleDTO> findAll(Pageable pageable);
}

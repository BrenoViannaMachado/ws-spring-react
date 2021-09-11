package com.devsuperior.dsvendas.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dsvendas.services.SaleServices;

@Service
public class SaleServicesImpl implements SaleServices{

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Override
	@Transactional(readOnly= true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
}
/*
@Override
	public List<SaleDTO> listByNamePartAndDescription(String name, String description, int pageNumber, int  limit) {
        List<Wine> wines = getPersistenceEngine().retrieveByNamedQuery("LIST_WINE_BY_NAME_PART_AND_DESCRIPTION", new Object[] {"%"+name+"%", "%"+description+"%" }, (pageNumber-1)*limit, limit);
        return wines;
    }
*/
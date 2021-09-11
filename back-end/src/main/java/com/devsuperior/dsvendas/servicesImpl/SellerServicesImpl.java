package com.devsuperior.dsvendas.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dsvendas.services.SellerServices;

@Service
public class SellerServicesImpl implements SellerServices{

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public Seller deleteSeller(Long id) {
		Optional<Seller> sellerFind = sellerRepository.findById(id);
		Seller seller = new Seller();
		
		if(sellerFind.isPresent()) {
			seller = sellerFind.get();
		}
		this.sellerRepository.deleteById(id);
		return  seller;
	}

	@Override
	public Seller findById(@PathVariable Long id) {
		Optional<Seller> userFind = this.sellerRepository.findById(id);
		
		if(userFind.isPresent()) {
			return userFind.get();
		}
		
		return null;
	}

	@Override
	public List<SellerDTO> findAll() {
		List<Seller> result = sellerRepository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}

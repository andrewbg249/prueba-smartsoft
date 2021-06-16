package com.smartsoft.pruebasmartsoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartsoft.pruebasmartsoft.models.Bill;
import com.smartsoft.pruebasmartsoft.repository.BillRepository;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillRepository billRepository;

	@GetMapping("/bill")
	public ResponseEntity<List<Bill>> getAllBills(@RequestParam(required = false) String num_bill) {
		try {
			List<Bill> bills = new ArrayList<Bill>();

			if (num_bill == null)
				billRepository.findAll().forEach(bills::add);

			if (bills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/bill/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") String num_bill) {
		Optional<Bill> billData = billRepository.findById(num_bill);

		if (billData.isPresent()) {
			return new ResponseEntity<>(billData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/bill")
	public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
		try {
			Bill _bill = billRepository.save(new Bill(bill.getId_Client(), bill.getDate()));
			return new ResponseEntity<>(_bill, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

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

import com.smartsoft.pruebasmartsoft.models.Detail;
import com.smartsoft.pruebasmartsoft.repository.DetailRepository;

@RestController
@RequestMapping("/api")
public class DetailController {

	@Autowired
	private DetailRepository detailRepository;

	@GetMapping("/detail")
	public ResponseEntity<List<Detail>> getAllDetails(@RequestParam(required = false) String num_detail) {
		try {
			List<Detail> details = new ArrayList<Detail>();

			if (num_detail == null)
				detailRepository.findAll().forEach(details::add);

			if (details.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Detail> getDetailById(@PathVariable("id") String num_detail) {
		Optional<Detail> detailData = detailRepository.findById(num_detail);

		if (detailData.isPresent()) {
			return new ResponseEntity<>(detailData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add-detail")
	public ResponseEntity<Detail> createDetail(@RequestBody Detail detail) {
		try {
			Detail _detail = detailRepository.save(
					new Detail(detail.getId_bill(), detail.getId_product(), detail.getAmount(), detail.getCost()));
			return new ResponseEntity<>(_detail, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

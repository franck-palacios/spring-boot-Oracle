package com.example.WsRest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WsRest.model.Casa;
import com.example.WsRest.repository.CasaRepository;
import com.google.gson.Gson;

@RestController
public class CasaResource {
	@Autowired
	private CasaRepository casaRepository;
	
	@GetMapping("casas")
	public ResponseEntity<String> obtenerCasas(){
		List<Casa> casas = casaRepository.findAll();
		return new ResponseEntity<String>(new Gson().toJson(casas), HttpStatus.OK);
	}
	
	@PostMapping("casas")
	public ResponseEntity<String> guardarCasa(@Valid @RequestBody Casa casa){
		casaRepository.save(casa);
		return new ResponseEntity<String>(new Gson().toJson(casa), HttpStatus.OK);
	}

}

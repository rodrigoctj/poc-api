package br.com.aguiabranca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aguiabranca.exception.InternalException;
import br.com.aguiabranca.exception.NotFoundException;
import br.com.aguiabranca.model.Empresa;
import br.com.aguiabranca.repository.EmpresaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired	
	EmpresaRepository empresaRepository;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna uma empresa"),
		    @ApiResponse(code = 401, message = "Você não tem está autenticado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Empresa> findById(@PathVariable("id") Long id) throws NotFoundException, InternalException {
		
		Empresa empresa = null;
		
		try {
			empresa = empresaRepository
						.findById(id)
						.orElseThrow(() -> new NotFoundException("Empresa não cadastrada") );
			
		}catch(NotFoundException e) {
			throw e;
		}catch (Exception e) {
			throw new InternalException(e);
		}
				
		return ResponseEntity.ok().body(empresa);
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna todas empresas cadastradas"),
		    @ApiResponse(code = 401, message = "Você não tem está autenticado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Empresa>> findAll(){		
		return ResponseEntity.ok().body(empresaRepository.findAll());		
	}
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Retorna dados da empresa cadastrada"),
		    @ApiResponse(code = 401, message = "Você não tem está autenticado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PostMapping(value="/", produces = "application/json", consumes = "application/json" )
	public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {	
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna dados da empresa atualizada"),
		    @ApiResponse(code = 401, message = "Você não tem está autenticado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PutMapping(value="/{id}", produces = "application/json", consumes = "application/json" )
	public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @Valid @RequestBody Empresa empresa) throws NotFoundException {
		
		empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não cadastrada."));
		
		empresa.setId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(empresaRepository.save(empresa));
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 204, message = "Retorna nenhum dado. Empresa deletada."),
		    @ApiResponse(code = 401, message = "Você não tem está autenticado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException {
		
		Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não cadastrada."));
		
		empresaRepository.delete(empresa);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
	}
		
	
}
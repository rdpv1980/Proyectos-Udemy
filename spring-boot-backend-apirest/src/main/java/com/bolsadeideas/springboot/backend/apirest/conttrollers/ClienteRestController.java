package com.bolsadeideas.springboot.backend.apirest.conttrollers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Region;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private  IUploadFileService uploadService;	
	
	@GetMapping("/clientes")
	public List<Cliente> index(){	
		return clienteService.encontrarTodos();		
	}
	
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable(name = "page") Integer pagina){
		//Pageable pageable=PageRequest.of(pagina, 4);
		return clienteService.findAll(PageRequest.of(pagina, 4));		
	}
	
//	@GetMapping("/clientes/{id}")
//	@ResponseStatus(HttpStatus.OK)
//	public Cliente show(@PathVariable Long id){	
//		return clienteService.encontrarPorId(id);	
//	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/clientes/{id}")	
	public ResponseEntity<?> show(@PathVariable Long id){// ? : cualquier tipo de objeto
		
		Cliente cliente=null;
		Map<String, Object> response=new HashMap<String,Object>();		
		
		try {
			cliente=clienteService.encontrarPorId(id);			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (null==cliente) {
			response.put("mensaje", "El cliente ID : ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}	
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);  
	}
	
//	@PostMapping("/clientes")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente create(@RequestBody Cliente cliente) {		
//		return clienteService.guardar(cliente);		
//	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		
		Cliente clienteNew=null;
		Map<String, Object> response=new HashMap<String,Object>();
		
		if (result.hasErrors()) {
//     Antes de jdk 8			
//			List<String> errors=new ArrayList<>();
//			
//			for (FieldError err : result.getFieldErrors()) {
//				errors.add("El campo" + err.getField()+err.getDefaultMessage());
//			}
			
			List<String> errors=result.getFieldErrors()
					                  .stream()
					                  .map(err -> "El campo " + err.getField()+" "+err.getDefaultMessage())
					                  .collect(Collectors.toList());
			
			response.put("errors",errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteNew=clienteService.guardar(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El cliente ha sido creado con exito!");
		response.put("clienteRecargado", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);		
	}
	
//	@PutMapping("/clientes/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
//		Cliente clienteaActual=clienteService.encontrarPorId(id);
//		
//		clienteaActual.setApellido(cliente.getApellido());
//		clienteaActual.setNombre(cliente.getNombre());
//		clienteaActual.setEmail(cliente.getEmail());
//		
//		return clienteService.guardar(clienteaActual);
//	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente,BindingResult result,@PathVariable Long id) {
		Cliente clienteActual=clienteService.encontrarPorId(id);
		Cliente clienteUpdate=null;
		
		Map<String, Object> response=new HashMap<>();
		
		if (result.hasErrors()) {					
					List<String> errors=result.getFieldErrors()
							                  .stream()
							                  .map(err -> "El campo" + err.getField()+err.getDefaultMessage())
							                  .collect(Collectors.toList());
					
					response.put("errors",errors);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
		
		if (null==clienteActual) {
			response.put("mensaje", "Error : no se pudo editar, El cliente ID : ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setCreateAt(cliente.getCreateAt());
			clienteActual.setRegion(cliente.getRegion());
			
			clienteUpdate=clienteService.guardar(clienteActual);			
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("clienteActualizado",clienteUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
//	@DeleteMapping("/clientes/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) {
//		clienteService.eliminar(id);
//	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response=new HashMap<>();
		
		try {
			Cliente cliente=clienteService.encontrarPorId(id);
			String nombreFotoAnterior=cliente.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);	
			
			clienteService.eliminar(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el cliente de la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile archivo,@RequestParam("identificador")Long id ){
		
		Map<String, Object> response=new HashMap<>();
		
		Cliente cliente=clienteService.encontrarPorId(id);
		
		if (!archivo.isEmpty()) {
			
			String nombreArchivo=null;
			try {
				nombreArchivo=uploadService.copiar(archivo);
			
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del cliente");
				response.put("error",e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);				
			}
			
			String nombreFotoAnterior=cliente.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			cliente.setFoto(nombreArchivo);
			
			clienteService.guardar(cliente);
			
			response.put("cliente",cliente);
			response.put("mensaje","Has subido correctamente la imagen : " + nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{foto:.+}")
	ResponseEntity<Resource> verFoto(@PathVariable("foto") String nombreFoto){
		
		Resource recurso=null;
		
		try {
			recurso=uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {				
			e.printStackTrace();
		}
		
		org.springframework.http.HttpHeaders cabecera=new org.springframework.http.HttpHeaders();
		cabecera.add("Content-Disposition","attachment; filename=\""+recurso.getFilename()+"\"");
		// tambien usando la constante : cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"");
		
		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/clientes/regiones")
	public List<Region> listarRegiones() {		
		return clienteService.findAllRegiones();
	}

}

package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

@RepositoryRestResource(path="usuarios")//hace de forma automatica el CRUD 
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{
	
	//si no se pernoliza la url seria asi : localhost:8090/api/usuarios/usuarios/search/nombreMetodo?nombreParametro=rommer
	//localhost:8090/api/usuarios/usuarios/search/findByUsername?username=rommer; siempre va el search
	
	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
	
	@Query("select u from Usuario u where u.usernme=?1")
	//Si se quiere colocar consultas nativas sql seria de la sgte manera :
	//@Query(value = "select u from usuario where u.username=?",nativeQuery = true)
	public Usuario obtenerPorUsername(String username);
	

}

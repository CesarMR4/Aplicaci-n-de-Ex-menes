package com.aplicacion.examenes.controladores;

import java.security.Principal;

import com.aplicacion.examenes.configuraciones.JwtUtils;
import com.aplicacion.examenes.entidades.JwtRequest;
import com.aplicacion.examenes.entidades.JwtResponse;
import com.aplicacion.examenes.entidades.Usuario;
import com.aplicacion.examenes.servicios.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	   @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    private JwtUtils jwtUtils;

	    @PostMapping("/generate-token")
	    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	    	
	    	 
	    	
	        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	        String token = this.jwtUtils.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(token));
	    }

	    private void autenticar(String username,String password) throws Exception {
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
	        }catch (DisabledException exception){
	            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
	        }catch (BadCredentialsException e){
	            throw  new Exception("Credenciales invalidas " + e.getMessage());
	        }
	    }

	    @GetMapping("/actual-usuario")
	    public Usuario obtenerUsuarioActual(Principal principal){
	        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
	    }
	}

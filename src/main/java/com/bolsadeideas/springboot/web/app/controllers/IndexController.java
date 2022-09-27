package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	
	@GetMapping({"/index","/",""})
	public String index( Model model) {
		model.addAttribute("titulo","hola Spring framework con Model");
		return "index";
	}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usu=new Usuario();
		usu.setApellido("Fernandez");
		usu.setNombre("Andrés");
		usu.setEmail("andres@correo.es");
		model.addAttribute("usuario", usu);
		model.addAttribute("titulo","Perfil de usuario : ".concat(usu.getNombre()));
		return "perfil";
		
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		//List<Usuario> usuarios=new ArrayList<>();
		//usuarios.add(new Usuario("Andrés","Fernandez","andres@correo.es"));
		//usuarios.add(new Usuario("Francisco","Ruiz","francis@correo.es"));
		model.addAttribute("titulo","Listado de usuarios");
		//model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios=new ArrayList<>();
		usuarios.add(new Usuario("Andrés","Fernandez","andres@correo.es"));
		usuarios.add(new Usuario("Francisco","Ruiz","francis@correo.es"));
		return usuarios;
		
	}
	
	
}

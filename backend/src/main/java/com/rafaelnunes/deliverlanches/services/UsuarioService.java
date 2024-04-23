package com.rafaelnunes.deliverlanches.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.dto.UsuarioDTO;
import com.rafaelnunes.deliverlanches.dto.UsuarioFullDTO;
import com.rafaelnunes.deliverlanches.entities.Permissao;
import com.rafaelnunes.deliverlanches.entities.Usuario;
import com.rafaelnunes.deliverlanches.repositories.PermissaoRepository;
import com.rafaelnunes.deliverlanches.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PermissaoRepository permissaoRepository; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public UsuarioDTO criarCliente(UsuarioFullDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setTelefone(dto.getTelefone());
		
		Permissao permissao = permissaoRepository.retornaAcessoCliente();
		
		usuario.getPermissoes().add(permissao);
		usuario = repository.save(usuario);
		
		return new UsuarioDTO(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		System.out.print(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Email não encontrado");
		}
		return usuario;
	}
}

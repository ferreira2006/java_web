package info.ferreira2006.cadastroweb.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.dto.UsuarioDto;
import info.ferreira2006.cadastroweb.model.Usuario;
import info.ferreira2006.cadastroweb.repository.UsuarioRepository;
import info.ferreira2006.cadastroweb.security.Token;
import info.ferreira2006.cadastroweb.security.TokenUtil;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private PasswordEncoder usuarioEncoder;
	private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Usuario> listarUsuario() {
		logger.info("Usuario: " + getLogado() + " Listando Usuarios");
		List<Usuario> lista = usuarioRepository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.usuarioEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = usuarioRepository.save(usuario);
		logger.info("Usuario: " + getLogado() + " Criando Usuario");
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.usuarioEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		logger.info("Usuario: " + getLogado() + " Editando Usuario: " + usuario.getNome());
		return usuarioRepository.save(usuario);
	}
	
	public Boolean excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
		logger.info("Usuario: " + getLogado() + " Excluindo Usuario");
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		String senha = usuarioRepository.getById(usuario.getId()).getSenha();
		Boolean valid = usuarioEncoder.matches(usuario.getSenha(), senha);		
		return valid;
	}
	
	public Token gerarToken(@Valid UsuarioDto usuario) {
		Usuario user = usuarioRepository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());
		if (user != null) {
			Boolean valid = usuarioEncoder.matches(usuario.getSenha(), user.getSenha());
			if (valid) {
				return new Token(TokenUtil.createToken(user));
			}
		}
		return null;
	}
	
	private String getLogado() {
		Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
		if(!(userLogado instanceof AnonymousAuthenticationToken)) {
			return userLogado.getName();
		}
		return "Null";
	}
	
}

package info.ferreira2006.cadastroweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import info.ferreira2006.cadastroweb.model.Usuario;
import info.ferreira2006.cadastroweb.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = usuarioRepository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		Usuario usuarioNovo = usuarioRepository.save(usuario);
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		Usuario usuarioNovo = usuarioRepository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return true;
	}
	
}

package info.ferreira2006.cadastroweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ferreira2006.cadastroweb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

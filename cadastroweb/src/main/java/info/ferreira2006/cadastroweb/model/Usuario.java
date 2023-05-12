package info.ferreira2006.cadastroweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@NotBlank(message = "O nome é obrigatório!")
	@Column(name="nome", length = 200, nullable = false)
	@Size(min = 2, message = "O nome deve ter no mínio 2 caracteres!")
	private String nome;
	
	@Email(message = "Informe um e-mail válido!")
	@NotBlank(message = "O e-mail é obrigatório!")
	@Column(name="email", length = 50, nullable = false)
	private String email;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Column(name="senha", columnDefinition = "TEXT", nullable = false)
	private String senha;
	
	@NotBlank(message = "O telefone é obrigatório!")
	@Column(name="telefone", length = 15, nullable = false)
	private String telefone;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return nome;
	}
}

package br.com.lognetbr.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lognetbr.dtos.AutenticarUsuarioRequestDto;
import br.com.lognetbr.dtos.AutenticarUsuarioResponseDto;
import br.com.lognetbr.dtos.CriarUsuarioRequestDto;
import br.com.lognetbr.dtos.CriarUsuarioResponseDto;
import br.com.lognetbr.entities.Usuario;
import br.com.lognetbr.exceptions.EmailJaCadastradoException;
import br.com.lognetbr.exceptions.ErroUsuarioOuSenhaException;
import br.com.lognetbr.helpers.CryptoHelper;
import br.com.lognetbr.helpers.JwtHelper;
import br.com.lognetbr.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Value("${chave_token}")
	private String chaveToken;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto request) {

		var usuarioFound = usuarioRepository.findEmail(request.getEmail());
		if (usuarioFound != null)
			throw new EmailJaCadastradoException();

		var crypto = new CryptoHelper();

		var usuario = new Usuario();
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(crypto.getSha256(request.getSenha()));
		usuarioRepository.save(usuario);

		var response = new CriarUsuarioResponseDto();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());

		return response;
	}

	public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto request) {

		var crypto = new CryptoHelper();

		var usuarioFound = usuarioRepository.findEmailAndSenha(request.getEmail(),
				crypto.getSha256(request.getSenha()));

		if (usuarioFound == null)
			throw new ErroUsuarioOuSenhaException();

		var expiracao = 3600000L;

		var gerarToken = new JwtHelper();
		var token = gerarToken.generateToken(usuarioFound.getNome(), expiracao, chaveToken);

		var response = new AutenticarUsuarioResponseDto();
		response.setId(usuarioFound.getId());
		response.setNome(usuarioFound.getNome());
		response.setEmail(usuarioFound.getEmail());
		response.setToken(token);
		response.setHoraCriacao(LocalDateTime.now());
		response.setHoraExpiracao(LocalDateTime.now().plusSeconds(expiracao / 1000));

		return response;
	}

	public ResponseEntity<?> getUsuarios() {
		try {
			var lista = usuarioRepository.findAll();
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}

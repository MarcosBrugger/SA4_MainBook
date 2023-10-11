package br.edu.senai.springSA4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senai.springSA4.orm.Livro;
import br.edu.senai.springSA4.repository.LivroRepository;


@Service
public class LivroServiceCRUD implements LivroService {
	@Autowired
	private LivroRepository repositorio;
	
	public List<Livro> listarLivros(){
		return (List<Livro>)repositorio.findAll();
	}
	
	public Livro salvarLivros(Livro livro) {
		return repositorio.save(livro);
	}
	public void apagarLivro(Integer id) {
		repositorio.deleteById(id);
	}
	public Livro consultarLivrosId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Livro atualizarLivros(Livro livro) {
		return repositorio.save(livro);
	}
}

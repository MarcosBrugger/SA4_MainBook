package br.edu.senai.springSA4.services;

import java.util.List;

import br.edu.senai.springSA4.orm.Livro;


public interface LivroService {
public List<Livro> listarLivros();
	
	public Livro salvarLivros(Livro livro);

	public void apagarLivro(Integer id);
	
	public Livro consultarLivrosId(Integer id);
	
	public Livro atualizarLivros(Livro livro);
}

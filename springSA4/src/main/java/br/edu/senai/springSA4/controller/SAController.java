package br.edu.senai.springSA4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.senai.springSA4.orm.Livro;
import br.edu.senai.springSA4.services.LivroService;

@Controller
public class SAController {
	@Autowired
	private LivroService servico;
	
	@GetMapping({"/"})
	public String path() {
        return "index";
    }
	
	@GetMapping({"/livros"})
	public String listarLivros(Model modelo) {
        modelo.addAttribute("livro", servico.listarLivros());
		return "livros";
    }
	
	@GetMapping("/livros/adicionar")
	public String adicionarLivros(Model modelo) {
		Livro objlivro = new Livro();
		modelo.addAttribute("livro", objlivro);
		return "livrosform";
	}
	
	@PostMapping("/livro")
	public String salvarLivros(@ModelAttribute("livro") Livro objlivro) {
		servico.salvarLivros(objlivro);
		return "redirect:/livros";
	}
	@GetMapping({"/livro/{id}"})
	public String apagarLivro(@PathVariable Integer id) {
		servico.apagarLivro(id);
		return "redirect:/livros";
	}
	@GetMapping({"/livro/editar/{id}"})
	public String editarLivro(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("livro", servico.consultarLivrosId(id));
		return "editarLivro";
	}
	@PostMapping("/livro/{id}")
	public String atualizarLivro(@PathVariable Integer id, @ModelAttribute("livro") Livro livro, Model modelo) {
		Livro liv = servico.consultarLivrosId(id);
		liv.setId(id);
		liv.setTitulo(livro.getTitulo());
		liv.setAutor(livro.getAutor());
		liv.setEditora(livro.getEditora());
		liv.setIsbn(livro.getIsbn());
		servico.atualizarLivros(liv);
		return "redirect:/livros";
	}
}

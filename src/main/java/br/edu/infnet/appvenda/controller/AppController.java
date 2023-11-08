package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.AlimenticioService;
import br.edu.infnet.appvenda.model.service.EletronicoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private AlimenticioService alimenticioService;
	@Autowired
	private EletronicoService eletronicoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeAlimenticio", alimenticioService.obterQtde());
		model.addAttribute("qtdeEletronico", eletronicoService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/alimenticio/lista")
	public String obterListaAlimenticio(Model model) {
		
		model.addAttribute("titulo", "Produtos Alimentícios:");
		model.addAttribute("listagem", alimenticioService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/eletronico/lista")
	public String obterListaEletronico(Model model) {
		
		model.addAttribute("titulo", "Produtos Eletrônicos:");
		model.addAttribute("listagem", eletronicoService.obterLista());

		return showHome(model);
	}
}
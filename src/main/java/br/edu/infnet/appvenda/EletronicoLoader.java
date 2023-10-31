package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Eletronico;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.EletronicoService;

@Order(4)
@Component
public class EletronicoLoader implements ApplicationRunner {
	
	@Autowired
	private EletronicoService eletronicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/eletronico.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Eletronico eletronico = new Eletronico();

			eletronico.setCodigo(Integer.valueOf(campos[0]));
			eletronico.setDescricao(campos[1]);
			eletronico.setEstoque(Boolean.valueOf(campos[2]));
			eletronico.setPreco(Float.valueOf(campos[3]));
			eletronico.setGarantiaMeses(Integer.valueOf(campos[4]));
			eletronico.setMarca(campos[5]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			eletronico.setVendedor(vendedor);
			
			eletronicoService.incluir(eletronico);
			
			linha = leitura.readLine();
		}

		for(Eletronico eletronico : eletronicoService.obterLista()) {
			System.out.println("[Eletrônico] " + eletronico);
		}
		
		leitura.close();
	}
}
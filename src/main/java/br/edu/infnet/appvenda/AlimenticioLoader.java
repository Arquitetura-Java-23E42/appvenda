package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Alimenticio;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.AlimenticioService;

@Order(3)
@Component
public class AlimenticioLoader implements ApplicationRunner {
	
	@Autowired
	private AlimenticioService alimenticioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/alimenticio.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Alimenticio alimenticio = new Alimenticio();

			alimenticio.setCodigo(Integer.valueOf(campos[0]));
			alimenticio.setDescricao(campos[1]);
			alimenticio.setEstoque(Boolean.valueOf(campos[2]));
			alimenticio.setPreco(Float.valueOf(campos[3]));
			alimenticio.setCaracteristica(campos[4]);
			alimenticio.setOrganico(Boolean.valueOf(campos[5]));
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			alimenticio.setVendedor(vendedor);
			
			alimenticioService.incluir(alimenticio);
			
			linha = leitura.readLine();
		}

		for(Alimenticio alimenticio: alimenticioService.obterLista()) {
			System.out.println("[Alimentício] " + alimenticio);			
		}

		leitura.close();
	}
}
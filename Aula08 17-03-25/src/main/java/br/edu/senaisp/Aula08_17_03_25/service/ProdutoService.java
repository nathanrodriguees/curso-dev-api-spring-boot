package br.edu.senaisp.Aula08_17_03_25.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula08_17_03_25.model.Produto;

@Service
public class ProdutoService {

	public void gravarProdutoTexto(Produto p) throws Exception {

		String nomeArq = "produto" + p.getId() + ".txt";
		String caminhoArq = "C:\\Temp\\Produtos\\";

		try {
			FileWriter arq = new FileWriter(caminhoArq + nomeArq);

			PrintWriter pw = new PrintWriter(arq);
			pw.print(p.getId() + ";\n");
			pw.print(p.getNome() + ";\n");
			pw.print(p.getPreco());

			pw.close();
		} catch (IOException e) {
			throw new Exception("Erro ao tentar gravar o arquivo !");
		}

	}
}

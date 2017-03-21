package br.com.drogaria.teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {

	// Utilizando JUnit

	@Test
	@Ignore
	public void salvar() throws SQLException {

		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45D);
		p.setQuantidade(10L);

		Fabricante f = new Fabricante();
		f.setCodigo(14L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();

		/* Testes Próprios
		int i = 0;
		System.out.println("Código do Produto: " + lista.get(i).getCodigo());
		System.out.println("Descrição do Produto: " + lista.get(i).getDescricao());
		System.out.println("Fabricante do produto: " + lista.get(i).getFabricante().getDescricao());
		*/

		for (Produto produto : lista) {

			// SELECT p.codigo, p.descricao, p.preco, p.quantidade, f.codigo,
			// f.descricao
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("");

		}

		/* Testes Próprios
		for (Produto produto : lista) {
			System.out.println("Resultado: " + produto);
		}*/

	}

	@Ignore
	@Test
	public void excluir() throws SQLException {

		Produto p = new Produto();
		p.setCodigo(3L);

		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);

	}

	@Test
	public void editar() throws SQLException {

		Produto p = new Produto();

		p.setCodigo(4L);
		p.setDescricao("Cataflan Pomada com 60 gramas	");
		p.setPreco(15.30D);
		p.setQuantidade(1L);

		Fabricante f = new Fabricante();
		
		f.setCodigo(5L);
		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);

	}

}

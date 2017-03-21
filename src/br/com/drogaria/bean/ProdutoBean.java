package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;

	private Produto produto;
	private ArrayList<Fabricante> comboFabricantes;

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}

	// usando m�todo alternativo ao '@PostConstruct'
	public void carregarListagem() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();

		} catch (Exception e) {

			System.out.println("Ocorreu um erro ao tentar listar os fabricantes!");
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovo() {

		produto = new Produto();

		try {
			FabricanteDAO dao = new FabricanteDAO();
			comboFabricantes = dao.listar();

		} catch (Exception e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}

	}

	public void novo() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}

	public void excluir() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);

			// Atualiza a lista ap�s excluir novo produto
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto removido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void prepararEditar() {

		try {

			FabricanteDAO dao = new FabricanteDAO();
			comboFabricantes = dao.listar();

		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void editar() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			
			// Atualiza a lista ap�s editar novo produto
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
			
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

}

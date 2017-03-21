package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	/*
	 *  '@PostConstruct' define que o método 'prepararPesquisa()' vai ser chamado
	 *  obrigatoriamente antes da Tela de 'fabricante.xhtml' ser chamada
	 */
	@PostConstruct
	public void prepararPesquisa() {

		// BUSCA COM VARIOS RESULTADOS (listar tudo)
		try {

			FabricanteDAO fdao = new FabricanteDAO();
			itens = fdao.listar();

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar listar os fabricantes!");
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovo() {

		fabricante = new Fabricante();
	}

	public void novo() {

		try {

			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			// Atualiza a lista após salvar novo fabricante
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);

			// Atualiza a lista após excluir novo fabricante
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			// Atualiza a lista após editar novo fabricante
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante atualizado com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

}

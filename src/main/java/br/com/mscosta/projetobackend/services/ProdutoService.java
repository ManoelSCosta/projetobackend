package br.com.mscosta.projetobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mscosta.projetobackend.model.Produto;
import br.com.mscosta.projetobackend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos
     * 
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos() {
        // Possiveis regras de negócio
        return produtoRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id) {
        // Possiveis regras
        return produtoRepository.obterPorId(id);
    }

    public Produto adicionar(Produto produto) {
        // Possiveis regras
        return produtoRepository.adicionar(produto);
    }

    public void deletar(Integer id) {
        // Possiveis regras de validação
        produtoRepository.deletar(id);
    }

    public Produto atualizar(Integer id, Produto produto) {
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }

}

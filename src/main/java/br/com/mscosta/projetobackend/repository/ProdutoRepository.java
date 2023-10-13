package br.com.mscosta.projetobackend.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import br.com.mscosta.projetobackend.model.Produto;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * 
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado de acordo com o id informado
     * 
     * @param id do produto que será localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    /**
     * Método para adicionar Produto na lista
     * 
     * @param produto a ser adicionado
     * @return retorna o produto adicionado
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Deleta o produto pelo id informado
     * 
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto atualizar(Produto produto) {
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (!produtoEncontrado.isPresent()) {
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());
        produtos.add(produto);

        return produto;
    }
}

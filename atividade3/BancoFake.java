package atividade3;

import java.util.HashMap;
public class BancoFake {
    private HashMap<String, Produto> produtos = new HashMap<>();
    public BancoFake() {
        // Populando o "Banco de Dados"
        produtos.put("123", new Produto("Arroz 5kg", 25.50));
        produtos.put("456", new Produto("Feijão 1kg", 8.90));
        produtos.put("789", new Produto("Óleo de Soja", 6.20));
        produtos.put("001", new Produto("Coca-Cola 2L", 12.00));
    }
    public Produto buscar(String codigo) {
        return produtos.get(codigo);
    }
}
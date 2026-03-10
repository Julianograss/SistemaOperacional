package atividade3;

import java.util.HashMap;
public class BancoFake {
    private HashMap<String, Produto> produtos = new HashMap<>();
    public BancoFake() {
        // Populando o "Banco de Dados"
        produtos.put("1", new Produto("Arroz 5kg", 25.50));
        produtos.put("2", new Produto("Feijão 1kg", 8.90));
        produtos.put("3", new Produto("Óleo de Soja", 6.20));
        produtos.put("4", new Produto("Coca-Cola 2L", 12.00));
        produtos.put("5", new Produto("Energético 2L", 14.00));
        produtos.put("6", new Produto("Macarrão", 5.40));
        produtos.put("7", new Produto("Açucar", 4.70));
        produtos.put("8", new Produto("Café", 18.90));
        produtos.put("9", new Produto("Detergente 500ml", 7.10));
        produtos.put("10", new Produto("Sabão em pó 4kg", 32.50));
        produtos.put("11", new Produto("Desinfetante 1L", 22.30));
        produtos.put("12", new Produto("Água mineral 500ml", 0.80));
        produtos.put("13", new Produto("Sal", 2.50));
        produtos.put("14", new Produto("Farinha", 3.40));
        produtos.put("15", new Produto("Azeite", 19.50));
    }
    public Produto buscar(String codigo) {
        return produtos.get(codigo);
    }
}

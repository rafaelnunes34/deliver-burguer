import { Produto } from "./produto";

export class CarrinhoProduto {
    produto: Produto;
    quantidade: number;

    constructor(produto: Produto, quantidade: number) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
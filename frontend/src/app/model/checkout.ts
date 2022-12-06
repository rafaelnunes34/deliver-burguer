import { CarrinhoProduto } from "./carrinhoProduto";
import { Endereco } from "./endereco";

export class Checkout {
    formaPagamento: String;
    endereco: Endereco = new Endereco();
    itens: Array<CarrinhoProduto> = [];
}
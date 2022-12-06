export class Pedido {
    id: number = 0;
    data: Date = new Date();
    status: string = "";
    formaPagamento: string = "";
    clienteNome: string = "";
    cidade: string = "";
    bairro: string = "";
    endereco: string = "";
    total: number = 0;
}
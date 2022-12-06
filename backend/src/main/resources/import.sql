INSERT INTO tb_permissao (nome) VALUES ('ROLE_ADMIN');
INSERT INTO tb_permissao (nome) VALUES ('ROLE_CLIENTE');

INSERT INTO tb_usuario (nome, email, senha, telefone) VALUES ('rafael nunes', 'rafael@gmail.com', '$2a$10$M/9GeDHKrDVZhdGcijy6FOu57mVkmDpFJ2f//4a9P2kY.kdcQ9Eay', '21974315563');
INSERT INTO tb_usuario (nome, email, senha, telefone) VALUES ('Dayane Alves', 'dayane@gmail.com', '$2a$10$M/9GeDHKrDVZhdGcijy6FOu57mVkmDpFJ2f//4a9P2kY.kdcQ9Eay', '21974315563');

INSERT INTO tb_usuario_permissao (usuario_id, permissao_id) VALUES (1, 1);
INSERT INTO tb_usuario_permissao (usuario_id, permissao_id) VALUES (1, 2);
INSERT INTO tb_usuario_permissao (usuario_id, permissao_id) VALUES (2, 2);

INSERT INTO tb_categoria (nome) VALUES ('Hamburguer');
INSERT INTO tb_categoria (nome) VALUES ('Pizza');
INSERT INTO tb_categoria (nome) VALUES ('Hot-Dog');
INSERT INTO tb_categoria (nome) VALUES ('Bebidas');
INSERT INTO tb_categoria (nome) VALUES ('Sobremesas');
INSERT INTO tb_categoria (nome) VALUES ('Açai');

INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('X-Picanha', 'Pão de brioche, queijo cheedar, salada, 150 gr hamburguer de picanha e um molho suculhento', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1ISm8n6o1S2oSIJA9ILztuMLtp5bikj3uag&usqp=CAU', 18.50, 1);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('X-Tudo', 'Pão de brioche, queijo cheedar, salada, 150 gr hamburguer de picanha e um molho suculhento', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLHEX5O297uUjKuI8byYdkV4OS4HmtxFAHig&usqp=CAU', 12.50, 1);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('X-Bacon', 'Pão de brioche, queijo cheedar, salada, 150 gr hamburguer de picanha e um molho suculhento', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLHEX5O297uUjKuI8byYdkV4OS4HmtxFAHig&usqp=CAU', 15.50, 1);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('X-Burguer', 'Pão de brioche, queijo cheedar, salada, 150 gr hamburguer de picanha e um molho suculhento', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLHEX5O297uUjKuI8byYdkV4OS4HmtxFAHig&usqp=CAU', 9.50, 1);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('Pizza Calabresa', 'Pizza média, massa fina, queijo mussarela, molho de tomate. Serve 8 pedaços!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr2YTqZuGlpAjKXKA1DZJJ9FB1VT_KHho6zw&usqp=CAU', 19.50, 2);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('Pizza Bacon', 'Pizza média, massa fina, queijo mussarela, molho de tomate. Serve 8 pedaços!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr2YTqZuGlpAjKXKA1DZJJ9FB1VT_KHho6zw&usqp=CAU', 17.50, 2);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('Pizza Portuguesa', 'Pizza média, massa fina, queijo mussarela, molho de tomate. Serve 8 pedaços!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr2YTqZuGlpAjKXKA1DZJJ9FB1VT_KHho6zw&usqp=CAU', 22.50, 2);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('Coca cola', '2 litros, super gelada!!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSCC0rJbDIFnQmUKv915PLSxsW-Kn1S3uVOA&usqp=CAU', 10.00, 4);
INSERT INTO tb_produto (nome, descricao, img_url, preco, categoria_id) VALUES ('Coca cola', '2 litros, super gelada!!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSCC0rJbDIFnQmUKv915PLSxsW-Kn1S3uVOA&usqp=CAU', 10.00, 4);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-01T03:00:00Z', 'DINHEIRO', 'PENDENTE', 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (3, 18.5, 1, 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (4, 15.5, 3, 1);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 1);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-05T03:00:00Z', 'CARTÃO', 'PREPARANDO', 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 17.5, 6, 2);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 10.0, 9, 2);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 2);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-05T03:00:00Z', 'CARTÃO', 'ENVIADO', 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 17.5, 6, 3);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 10.0, 9, 3);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 3);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-05T03:00:00Z', 'CARTÃO', 'ENTREGUE', 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 17.5, 6, 4);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 10.0, 9, 4);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 4);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-09T03:00:00Z', 'PIX', 'PENDENTE', 2);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (2, 15.5, 3, 5);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 10.0, 9, 5);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 5);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2022-11-09T03:00:00Z', 'PIX', 'CANCELADO', 1);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (2, 15.5, 3, 6);
INSERT INTO tb_pedido_item (quantidade, valor, produto_id, pedido_id) VALUES (1, 10.0, 9, 6);

INSERT INTO tb_endereco (cep, localidade, bairro, logradouro, numero, complemento, pedido_id) VALUES ('26185010', 'Belford Roxo', 'Jardim Brasil', 'Alameda Argentina', 's/n', 'Lote 06 quadra 08', 6);
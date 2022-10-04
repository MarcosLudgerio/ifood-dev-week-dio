INSERT INTO restaurant (id, cep, city, complement, number, state, street, name)
VALUES (1L, '58000-000', 'João Pessoa', 'Apto 2', 0, 'Paraiba', 'Dos bobos','restaurante do zé'),
       (2L, '58000-001', 'João Pessoa', 'Apto 3', 1, 'Paraiba', 'Dos alfredos','Zé delivery'),
       (3L, '58000-002', 'Santa Rita', '', 2, 'Paraiba', 'Contorno','Hames Boot');

INSERT INTO client
VALUES (1L, '12345-352', 'João Pessoa', 'Apto 5', 0, 'Paraiba', 'Rua da Festa','Home');

INSERT INTO product (id, available, name, unit_value, restaurant_id)
VALUES (1L, true, 'Arroz', 5.0, 1L),
       (2L, true, 'Salada', 6.0, 2L),
       (3L, true, 'Hamburguér', 12.0, 1L),
       (4L, true, 'Batata frita', 15.0, 2L),
       (5L, true, 'Coca', 3.0, 3L);

INSERT INTO bag (id, payment_form, closed, total_value, client_id)
VALUES (1L, 1, false, 0.0, 1L);
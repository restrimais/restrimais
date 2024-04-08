INSERT INTO tb_patient (name, email, birth_date, password, cpf, gender, profile_img, phone, height, weight) VALUES ('Bob Brown', 'bob@gmail.com', '2001-07-25', '123', '45678998709', 0, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg', '988889999', 1.75, 68.0);
INSERT INTO tb_patient(name, email, birth_date, password, cpf, gender, profile_img, phone, height, weight) VALUES ('Maria Silva', 'maria@gmail.com', '2007-08-18', '4567', '44455566609', 1, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg', '955557777', 1.60, 55.0);

INSERT INTO tb_restriction (name, patient_id) VALUES ('Intolerancia a Lactose', 1);
INSERT INTO tb_restriction (name, patient_id) VALUES ('Alergia a amendoim', 1);
INSERT INTO tb_restriction (name, patient_id) VALUES ('Intolerancia a gluten', 2);

INSERT INTO tb_category (name) VALUES ('Intolerância');
INSERT INTO tb_category (name) VALUES ('Restrição');
INSERT INTO tb_category (name) VALUES ('Alergia');

INSERT INTO tb_restriction_category (restriction_id, category_id) VALUES (1, 1);
INSERT INTO tb_restriction_category (restriction_id, category_id) VALUES (2, 3);
INSERT INTO tb_restriction_category (restriction_id, category_id) VALUES (3, 1);

INSERT INTO tb_nutritionist (name, email, birth_date, password, cpf, gender, profile_img, phone, crn, specialization, academic_degree, biography) VALUES ('Ana Luiza', 'ana@gmail.com', '2002-10-08', 'teste123', '44455566609', 1, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg', '955557777', 'CRM/SP 123456', 'Nutricao Esportiva', 'Bacharelado em Nutricao', 'Nutricionista Esportiva dedicada a otimizar desempenho e saúde. Graduada em Nutrição pela [Nome da Universidade], com especialização em Nutrição Esportiva pela [Nome da Instituição]. Meu foco é fornecer orientação personalizada para ajudar meus clientes a alcançar seus objetivos. Apaixonada por promover educação em saúde, sou palestrante em eventos esportivos e escolas. Acredito que a nutrição e um estilo de vida ativo são a chave para o bem-estar.');

INSERT INTO tb_professional_experience (office, company, start_date, end_date, nutritionist_id) VALUES ('Nutricionista Esportivo', 'Hospital X', '2022-06-13', '2023-09-03', 1);

INSERT INTO tb_state (name) VALUES ('São Paulo');
INSERT INTO tb_state (name) VALUES ('Minas Gerais');
INSERT INTO tb_state (name) VALUES ('Rio de Janeiro');
INSERT INTO tb_state (name) VALUES ('Pernambuco');

INSERT INTO tb_city (name, state_id) VALUES ('Franco da Rocha', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Várzea Paulista', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Jundiaí', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Cambuí', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Angra dos Reis', 3);

INSERT INTO tb_adress (street, number, complement, neighborhood, cep, city_id, patient_id, nutritionist_id) VALUES ('Rua Ministro Nelson Hungria', '108', 'Casa', 'Jardim Luzia', '49045-510', 1, 1, null);
INSERT INTO tb_adress (street, number, complement, neighborhood, cep, city_id, patient_id, nutritionist_id) VALUES ('Avenida Joa Silva', '16', 'Apartamento', 'Monte Verde', '69906-470', 2, null, 1);
INSERT INTO tb_adress (street, number, complement, neighborhood, cep, city_id, patient_id, nutritionist_id) VALUES ('Avenida Ferroviarios', '17', 'Casa', 'Jardim Barros', '49045-234', 3, 2, null);

INSERT INTO tb_query (query_date, status, observation, price, nutritionist_id, patient_id) VALUES ('2023-08-10T14:30:00', 1, 'Consulta para avaliação', 179.90, 1, 2);
INSERT INTO tb_query (query_date, status, observation, price, nutritionist_id, patient_id) VALUES ('2023-09-10T18:30:00', 1, 'Sem observação', 100.0, 1, 1);

INSERT INTO tb_preparation (step, time, observation) VALUES ('1 - Lave e escorra bem a alface e as ervas frescas. 2 - Corte os tomates em fatias finas e os pepinos em rodelas. 3 -Misture a alface, tomates, pepinos e cenouras raladas em uma tigela grande.', '5 minutos', 'Sal a gosto!');
INSERT INTO tb_preparation (step, time, temperature, observation) VALUES ('1 - Pré-aqueça o forno a 180°C. Unte e enfarinhe uma forma de bolo. 2 - No liquidificador, bata as cenouras picadas, os ovos, o óleo e a essência de baunilha até obter uma mistura homogênea.', '20 minutos', '180º', 'Rende até 8 pessoas.');

INSERT INTO tb_revenue (title, img, description, preparation_id) VALUES ('Salada ', 'link da img','Desfrute de uma salada especial fresca e colorida, repleta de ingredientes da estação. Delicie-se com a combinação de vegetais crocantes, ervas aromáticas e um molho irresistível, criando uma explosão de sabores em cada garfada. Uma opção saudável e deliciosa para satisfazer o seu paladar.', 1);
INSERT INTO tb_revenue (title, img, description, preparation_id) VALUES ('Bolo de cenoura sem gluten ', 'link da img','Desfrute desse bolo delicioso.', 2);

INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('1 Alface fresca', 1);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('2 Tomates maduros', 1);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('3 Pepinos cortados', 1);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('1 Cenoura ralada', 1);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('2 cenouras grandes, descascadas e picadas', 2);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('3 ovos', 2);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('1 xícara de óleo vegetal', 2);
INSERT INTO tb_ingredients (igredient, revenue_id) VALUES ('2 xícaras de açúcar', 2);

INSERT INTO tb_assessment (score, comment, patient_id, nutritionist_id) VALUES (4.5, 'Muito bom profissional, atencionoso e educado!', 1, 1);
INSERT INTO tb_assessment (score, comment, patient_id, revenue_id) VALUES (5.0, 'Receita maravilhosa', 1, 2);

INSERT INTO tb_revenue_category (revenue_id, category_id) VALUES (1, 1);
INSERT INTO tb_revenue_category (revenue_id, category_id) VALUES (1, 2);
INSERT INTO tb_revenue_category (revenue_id, category_id) VALUES (2, 2);
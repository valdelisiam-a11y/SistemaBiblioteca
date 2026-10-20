
-- SISTEMA DE BIBLIOTECA
-- Exercício 2: modelagem e dados de teste

-- 1. Tabela de itens
CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_item_tipo
        CHECK (tipo IN ('livro', 'revista'))
);

-- 2. Tabela de usuários
CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,

    CONSTRAINT chk_usuario_tipo
        CHECK (tipo IN ('aluno', 'professor')),

    CONSTRAINT chk_usuario_limite
        CHECK (limite_itens > 0)
);

-- 3. Tabela de empréstimos
CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0.00,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id),

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id),

    CONSTRAINT chk_emprestimo_datas
        CHECK (data_devolucao_prevista >= data_retirada),

    CONSTRAINT chk_emprestimo_multa
        CHECK (valor_multa >= 0)
);

-- 4. Cadastro de itens
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
    ('L001', 'A Fortaleza', 'livro', 'Autor Exemplo 1', NULL, FALSE),
    ('L002', 'Capitães de areia', 'livro', 'Jorge Amado', NULL, TRUE),
    ('L003', 'Dom Casmurro', 'livro', 'Machado de Assis', NULL, TRUE),
    ('R001', 'Super Interessante', 'revista', NULL, 'Edicao 450', TRUE);

-- 5. Cadastro de usuários
INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('Ana', 'aluno', 3),
    ('Val', 'professor', 5);

-- 6. Empréstimo em aberto
INSERT INTO emprestimo (
    item_id, usuario_id, data_retirada,
    data_devolucao_prevista, data_devolucao, valor_multa
)
VALUES (
    1, 1, '2026-10-10',
    '2026-10-24', NULL, 0.00
);

-- 7. Empréstimo devolvido, com multa registrada
INSERT INTO emprestimo (
    item_id, usuario_id, data_retirada,
    data_devolucao_prevista, data_devolucao, valor_multa
)
VALUES (
    2, 2, '2026-09-01',
    '2026-09-15', '2026-09-18', 1.50
);

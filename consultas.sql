
-- SISTEMA DE BIBLIOTECA
-- Consultas obrigatórias do Exercício 2

-- 1. Listar todos os itens do acervo
SELECT
    id,
    codigo,
    titulo,
    tipo,
    autor,
    edicao,
    disponivel
FROM item
ORDER BY id;


-- 2. Listar empréstimos em aberto com usuário e item
SELECT
    e.id AS emprestimo_id,
    u.nome AS usuario,
    i.codigo AS codigo_item,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u ON e.usuario_id = u.id
INNER JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_retirada;


-- 3. Calcular o total de multas por usuário
SELECT
    u.id,
    u.nome,
    COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome
ORDER BY u.nome;


-- 4. Listar itens que nunca foram emprestados
SELECT
    i.id,
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL
ORDER BY i.id;

-- Armazena os tipos de chamados para organização.
CREATE TABLE CATEGORIA (
    ID_Categoria INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Categoria VARCHAR(100) NOT NULL UNIQUE
);

-- Tabela: FIEL
-- Armazena os dados dos usuários que abrem os chamados.
CREATE TABLE FIEL (
    ID_Fiel INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(150) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    Paroquia VARCHAR(100)
);

-- Tabela: DESENVOLVEDOR
-- Armazena os dados dos técnicos responsáveis por resolver os chamados.
CREATE TABLE DESENVOLVEDOR (
    ID_Dev INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(150) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    Nivel_Especialidade VARCHAR(50) -- Ex: 'N1', 'N2', 'Desenvolvedor Backend'
);

-- Tabela: CHAMADO
-- Tabela central que armazena os tickets de suporte.
-- Contém chaves estrangeiras para relacionar com FIEL, DESENVOLVEDOR e CATEGORIA.
CREATE TABLE CHAMADO (
    ID_Chamado INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(200) NOT NULL,
    Descricao TEXT NOT NULL,
    Data_Abertura DATETIME NOT NULL,
    Status VARCHAR(50) NOT NULL, -- Ex: 'Aberto', 'Em Andamento', 'Fechado'
    Prioridade VARCHAR(50), -- Ex: 'Baixa', 'Média', 'Alta'

    -- Chaves Estrangeiras (Implementando os relacionamentos)
    ID_Fiel_FK INT NOT NULL,
    ID_Dev_FK INT, -- Pode ser nulo se o chamado ainda não foi atribuído
    ID_Categoria_FK INT NOT NULL,

    FOREIGN KEY (ID_Fiel_FK) REFERENCES FIEL(ID_Fiel),
    FOREIGN KEY (ID_Dev_FK) REFERENCES DESENVOLVEDOR(ID_Dev),
    FOREIGN KEY (ID_Categoria_FK) REFERENCES CATEGORIA(ID_Categoria)
);

-- Tabela: ATUALIZACAO
-- Armazena o histórico de interações de um chamado.
CREATE TABLE ATUALIZACAO (
    ID_Atualizacao INT PRIMARY KEY AUTO_INCREMENT,
    Descricao_Atualizacao TEXT NOT NULL,
    Data_Hora DATETIME NOT NULL,
    Autor VARCHAR(150) NOT NULL, -- Nome de quem escreveu a atualização
     
    -- Chave Estrangeira para relacionar com o chamado
    ID_Chamado_FK INT NOT NULL,

    FOREIGN KEY (ID_Chamado_FK) REFERENCES CHAMADO(ID_Chamado)
);
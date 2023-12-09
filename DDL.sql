DROP SCHEMA IF EXISTS recrutatech;

DROP USER IF EXISTS 'user'@'localhost';

CREATE SCHEMA recrutatech;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass123';

GRANT SELECT, INSERT, DELETE, UPDATE ON recrutatech.* TO 'user'@'localhost';

USE recrutatech;

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    user_email VARCHAR(255),
    user_password VARCHAR(255),
    user_status BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key aut_usuario_fk (usr_id) references user (usr_id) on delete restrict on update cascade,
    foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

CREATE TABLE job (
    job_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_title VARCHAR(255),
    job_level VARCHAR(255),
    job_description TEXT,
    job_status VARCHAR(255),
    kaa_id BIGINT,
    FOREIGN KEY (kaa_id) REFERENCES kaa(id)
);

CREATE TABLE kaa (
    kaa_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    knowledge_id BIGINT,
    ability_id BIGINT,
    attitude_id BIGINT,
    FOREIGN KEY (knowledge_id) REFERENCES knowledge_id(id)
);

CREATE TABLE knowledge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    c_content TEXT
);
CREATE TABLE ability (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    h_content TEXT
);
CREATE TABLE attitude (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    a_content TEXT
);

-- INSERT INTO user (user_name, user_email, user_password, user_status, created_at, updated_at)
-- VALUES
--     ('Usuario1', 'usuario1@example.com', 'senha1', true, NOW(), NOW()),
--     ('Usuario2', 'usuario2@example.com', 'senha2', true, NOW(), NOW()),
--     ('Usuario3', 'usuario3@example.com', 'senha3', true, NOW(), NOW()),
--     ('Usuario4', 'usuario4@example.com', 'senha4', false, NOW(), NOW());

insert into user (user_name, user_email, user_password, user_status, created_at, updated_at)
    values ('admin', 'usuario1@example.com', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C', true, NOW(), NOW());

insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');

insert into uau_usuario_autorizacao (usr_id, aut_id) 
    values (1, 1);

INSERT INTO knowledge (c_content) VALUES 
--P.O
("- Knowledge em metodologias ágeis (Scrum, Kanban, Lean, etc.);\n- Knowledge em gerenciamento de projetos;\n- Knowledge em gestão de produtos digitais e tecnologia da informação;\n- Knowledge em análise de dados e métricas para tomada de decisão;\n- Knowledge em marketing digital e técnicas de comunicação.\n");
--Analista de Testes 
("- Ensino superior completo em Sistemas de Informação, Ciências da Computação ou Engenharia da Computação.\n- Knowledges básicos em HTML e bancos de dados SQL.\n- Certificações na área de qualidade.\n- Experiência com ferramentas de realização de testes.\n- Knowledge de metodologias ágeis.");
-- Scrum Master 
("Pré-requisitos:\n- Ensino superior completo na área de tecnologia da informação ou afins.\n- Certificação Scrum Master.\n- Experiência em liderança de equipes ágeis.\n- Knowledge em metodologias ágeis.");
-- Desenvolvedor Frontend
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas.\n- Experiência em desenvolvimento Frontend.\n- Knowledge em HTML, CSS e JavaScript.\n- Familiaridade com frameworks Frontend.");
-- Desenvolvedor Backend
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas.\n- Experiência em desenvolvimento Backend.\n- Knowledge em linguagens de programação para Backend.\n- Familiaridade com bancos de dados.");
-- Desenvolvedor Full Stack
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas.\n- Experiência em desenvolvimento Full Stack.\n- Knowledge em linguagens de programação tanto para Frontend quanto para Backend.\n- Familiaridade com frameworks e bancos de dados.");
-- P.O Sênior
("- Knowledge avançado em metodologias ágeis (Scrum, Kanban, Lean, etc.);\n- Experiência extensa em gerenciamento de projetos complexos;\n- Profundo knowledge em gestão de produtos digitais e tecnologia da informação;\n- Experiência avançada em análise de dados e métricas para tomada de decisão;\n- Experiência em marketing digital e técnicas de comunicação avançadas.\n");
-- Analista de Testes Sênior
("- Ensino superior completo em Sistemas de Informação, Ciências da Computação ou Engenharia da Computação;\n- Certificações avançadas na área de qualidade;\n- Experiência substancial com ferramentas de realização de testes e automação;\n- Profundo knowledge de metodologias ágeis.");
-- Scrum Master Sênior
("Pré-requisitos:\n- Ensino superior completo na área de tecnologia da informação ou afins;\n- Certificação Scrum Master avançada;\n- Experiência significativa em liderança de equipes ágeis;\n- Ampla experiência em metodologias ágeis.");
-- Desenvolvedor Frontend Sênior
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas;\n- Ampla experiência em desenvolvimento Frontend;\n- Knowledge avançado em HTML, CSS e JavaScript;\n- Proficiência em frameworks Frontend.");
-- Desenvolvedor Backend Sênior
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas;\n- Experiência substancial em desenvolvimento Backend;\n- Knowledge avançado em linguagens de programação para Backend;\n- Proficiência em otimização de consultas e desempenho do servidor;\n- Experiência em integração de sistemas e APIs avançada.");
-- Desenvolvedor Full Stack Sênior
("Pré-requisitos:\n- Ensino superior completo em Ciência da Computação ou áreas relacionadas;\n- Experiência substancial em desenvolvimento Full Stack;\n- Knowledge avançado em linguagens de programação tanto para Frontend quanto para Backend;\n- Proficiência em frameworks e bancos de dados.");


INSERT INTO ability (h_content) VALUES 
--P.O
("- Ability em liderança e gestão de equipe;\n- Ability em negociação e resolução de conflitos;\n- Ability em priorização de demandas e alinhamento de prazos;\n- Ability em comunicação e engajamento de stakeholders;\n- Ability em prototipação e validação de ideias.\n");
--Analista de Testes 
("- Boa capacidade investigativa.\n- Visão analítica e criteriosa.\n- Capacidade de observação dos detalhes.\nDesejável:\n\n- Pós-graduação em andamento.\n- Knowledge em programação.");
-- Scrum Master
("Abilitys:\n- Facilitação de reuniões ágeis.\n- Acompanhamento e remoção de impedimentos.\n- Garantir a execução das práticas ágeis.\n- Colaboração com a equipe e o Product Owner.");
-- Desenvolvedor Frontend
("Abilitys:\n- Desenvolvimento de interfaces de usuário atraentes.\n- Colaboração com a equipe de design.\n- Solução de problemas de compatibilidade com navegadores.");
-- Desenvolvedor Backend
("Abilitys:\n- Desenvolvimento de lógica e funcionalidades do servidor.\n- Otimização de consultas e desempenho do servidor.\n- Integração de sistemas e APIs.");
-- Desenvolvedor Full Stack
("Abilitys:\n- Desenvolvimento de sistemas completos, tanto Frontend quanto Backend.\n- Colaboração com equipes multidisciplinares.\n- Solução de problemas em todas as camadas do sistema.");
-- P.O Sênior
("- Ability avançada em liderança e gestão de equipe;\n- Ability em negociação e resolução de conflitos em contextos complexos;\n- Ability em priorização de demandas estratégicas e alinhamento de prazos;\n- Comunicação avançada e engajamento de stakeholders;\n- Ability avançada em prototipação e validação de ideias.\n");
-- Analista de Testes Sênior
("- Capacidade investigativa aprofundada;\n- Visão analítica avançada e critério refinado;\n- Capacidade de observação excepcional dos detalhes;\nDesejável:\n\n- Pós-graduação concluída;\n- Profundo knowledge em programação.");
-- Scrum Master Sênior
("Abilitys avançadas:\n- Facilitação excepcional de reuniões ágeis;\n- Resolução de impedimentos complexos;\n- Garantia da execução eficaz das práticas ágeis;\n- Colaboração eficaz com a equipe e o Product Owner.");
-- Desenvolvedor Frontend Sênior
("Abilitys avançadas:\n- Desenvolvimento excepcional de interfaces de usuário atraentes;\n- Colaboração avançada com a equipe de design;\n- Resolução de problemas complexos de compatibilidade com navegadores.");
-- Desenvolvedor Backend Sênior
("Abilitys avançadas:\n- Desenvolvimento excepcional de lógica e funcionalidades do servidor;\n- Otimização avançada de consultas e desempenho do servidor;\n- Integração de sistemas e APIs complexas.");
-- Desenvolvedor Full Stack Sênior
("Abilitys avançadas:\n- Desenvolvimento de sistemas complexos, tanto Frontend quanto Backend;\n- Colaboração excepcional com equipes multidisciplinares;\n- Resolução de problemas altamente complexos em todas as camadas do sistema.");


INSERT INTO attitude (a_content) VALUES 
--P.O
("- Proatividade e iniciativa;\n- Adaptabilidade e flexibilidade;\n- Foco no cliente e na qualidade do produto;\n- Busca constante por knowledge, inovação e melhoria contínua;\n- Trabalho em equipe e colaboração.");
--Analista de Testes
("- Desenvolver um plano de testes e executá-lo.\n- Identificar erros (bugs) a partir das provas realizadas, reportá-los e fazer o acompanhamento dos mesmos.\n- Fazer o registro de todos os incidentes e não-conformidades encontrados nos testes funcionais e elaborar relatórios.\n- Determinar cenários de testes e casos em que eles foram bem aplicados.\n- Participar dos processos de melhoria contínua.\n- Participar dos processos de automação dos testes.\n- Fazer a manutenção de testes já automatizados.");
-- Scrum Master
("Attitudes:\n- Servir à equipe e proteger contra distrações.\n- Promover a melhoria contínua.\n- Foco na entrega de valor.\n- Comunicação eficaz com todos os envolvidos.");
-- Desenvolvedor Frontend
("Attitudes:\n- Atualização constante sobre as melhores práticas de desenvolvimento Frontend.\n- Foco na usabilidade e experiência do usuário.\n- Trabalho em equipe para integrar Frontend e Back-End.");
-- Desenvolvedor Backend
("Attitudes:\n- Resolução de problemas complexos no servidor.\n- Colaboração com a equipe de Frontend para integração.\n- Manutenção e atualização contínuas do servidor.");
-- Desenvolvedor Full Stack
("Attitudes:\n- Adaptação às mudanças de requisitos.\n- Trabalho em equipe para integrar Frontend e Backend.\n- Solução de problemas em todas as camadas do sistema.");
-- P.O Sênior
("- Proatividade e iniciativa avançadas;\n- Adaptabilidade e flexibilidade em ambientes altamente complexos;\n- Foco no cliente e na qualidade do produto em contextos desafiadores;\n- Busca constante por knowledge, inovação e melhoria contínua em cenários complexos;\n- Excelente trabalho em equipe e colaboração em contextos de alta complexidade.");
-- Analista de Testes Sênior
("- Desenvolvimento de planos de testes avançados e execução deles;\n- Identificação avançada de erros (bugs) a partir das provas realizadas, reporte eficaz e acompanhamento dos mesmos;\n- Registro detalhado de todos os incidentes e não-conformidades encontrados nos testes funcionais e elaboração de relatórios completos;\n- Determinação de cenários de testes complexos e casos em que eles foram bem aplicados;\n- Participação ativa nos processos de melhoria contínua;\n- Participação em processos avançados de automação de testes;\n- Manutenção eficaz de testes já automatizados.");
-- Scrum Master Sênior
("Attitudes avançadas:\n- Liderança excepcional e foco na entrega de valor;\n- Promoção da melhoria contínua em todos os níveis da organização;\n- Ability avançada em remoção de impedimentos e garantia de um ambiente ágil eficaz.");
-- Desenvolvedor Frontend Sênior
("Attitudes avançadas:\n- Desenvolvimento excepcional de interfaces de usuário para garantir a melhor experiência do usuário;\n- Foco aprimorado na usabilidade e design de alta qualidade;\n- Colaboração eficaz com equipes multidisciplinares.");
-- Desenvolvedor Backend Sênior
("Attitudes avançadas:\n- Resolução de problemas altamente complexos e otimização de desempenho do servidor;\n- Foco em integração de sistemas complexos e entrega de soluções robustas.");
-- Desenvolvedor Full Stack Sênior
("Attitudes avançadas:\n- Desenvolvimento de sistemas complexos, tanto Frontend quanto Backend;\n- Resolução de problemas altamente complexos em todas as camadas do sistema;\n- Entrega de soluções completas e de alta qualidade em contextos desafiadores.");


INSERT INTO kaa (knowledge_id, ability_id, attitude_id) VALUES 
-- P.O
(1,1,1);
--Analista de Testes
(2,2,2);
--Scrum Master 
(3,3,3);
-- Desenvolvedor Frontend
(4,4,4);
--Desenvolvedor Backend
(5,5,5);
--Desenvolvedor Full Stack
(6,6,6);
-- P.O Sênior
(7,7,7);
--Analista de Testes Sênior
(8,8,8);
--Scrum Master Sênior
(9,9,9);
-- Desenvolvedor Frontend Sênior
(10,10,10);
--Desenvolvedor Backend Sênior
(11,11,11);
--Desenvolvedor Full Stack Sênior
(12,12,12);

INSERT INTO job (job_title, job_level, job_description, job_status, kaa_id) VALUES 
--P.O
('Product Owner','Pleno','Estamos à procura de um Product Owner habilidoso para se juntar à nossa equipe de desenvolvimento de software. O candidato ideal terá mais de 3 anos de experiência em gerenciamento de produtos e será capaz de liderar efetivamente tanto o planejamento quanto a execução de projetos complexos.','open', 1);--Analista de Testes QA
--Analista de Testes
('Analista de Testes','Pleno','Esse(a) profissional é responsável por criar e executar testes que servirão para analisar se um produto ou um processo está funcionando da melhor maneira possível. Além disso, pode desenvolver a automação de testes que ocorram com frequência para sua análise.\n\nNo caso de produtos digitais, os analistas de QA podem trabalhar com softwares, sites, aplicativos ou jogos. Além disso, podem realizar a automação de testes que ocorram com frequência para sua posterior análise.\n\nÉ importante que o analista registre todas as falhas encontradas e faça a sugestão de melhorias. Para isso, irá trabalhar diretamente com a equipe de desenvolvimento..\n\nBuscamos um perfil bastante detalhista e analítico, pois, em última análise, seu trabalho será parte integrante de nossos esforços para garantir a melhor experiência de uso do nosso aplicativo.',2);
-- Scrum Master
('Scrum Master','Pleno','Estamos à procura de um Scrum Master qualificado para liderar nossas equipes ágeis e garantir a entrega de valor. O candidato ideal deve possuir certificação Scrum Master, experiência em facilitação de reuniões ágeis e remoção de impedimentos, além de promover a melhoria contínua. Se você é apaixonado por metodologias ágeis e tem ability para colaborar com equipes, esta vaga é para você.', 'open', 3);
-- Desenvolvedor Frontend
('Desenvolvedor Frontend','Pleno','Estamos à procura de um Desenvolvedor Frontend talentoso para criar interfaces de usuário atraentes e funcionais. O candidato ideal deve ter experiência em HTML, CSS, JavaScript e frameworks Frontend, além de colaborar com a equipe de design. Se você é apaixonado por desenvolvimento Frontend e focado na usabilidade, esta vaga é para você.', 'open', 4);
-- Desenvolvedor Backend
('Desenvolvedor Backend','Pleno','Estamos à procura de um Desenvolvedor Backend experiente para desenvolver lógica e funcionalidades do servidor. O candidato ideal deve ter knowledge em linguagens de programação para Backend, otimização de consultas e integração de sistemas. Se você é apaixonado por desenvolvimento Backend e resolução de problemas complexos, esta vaga é para você.', 'open', 5);
-- Desenvolvedor Full Stack
('Desenvolvedor Full Stack','Pleno','Estamos à procura de um Desenvolvedor Full Stack experiente para desenvolver sistemas completos, tanto Frontend quanto Backend. O candidato ideal deve ter knowledge em linguagens de programação para ambas as camadas, além de ability para solucionar problemas em todas as partes do sistema. Se você é um desenvolvedor Full Stack apaixonado por trabalhar em projetos desafiadores, esta vaga é para você.', 'open', 6);
-- P.O Sênior
('Product Owner Sênior','Sênior','Estamos à procura de um Product Owner habilidoso e experiente para liderar nossa equipe de desenvolvimento de software em projetos altamente complexos. O candidato ideal possui mais de 5 anos de experiência em gerenciamento de produtos e é capaz de liderar eficazmente tanto o planejamento quanto a execução de projetos altamente desafiadores.','open', 7);
-- Analista de Testes Sênior
('Analista de Testes QA Sênior','Sênior','Este(a) profissional é responsável por criar e executar testes avançados para garantir que nossos produtos atendam aos mais altos padrões de qualidade. Além disso, deve liderar a automação de testes em ambientes complexos e de alto risco. O candidato ideal possui uma ampla experiência em testes e automação e é capaz de conduzir testes em produtos digitais complexos.','open', 8);
-- Scrum Master Sênior
('Scrum Master Sênior','Sênior','Estamos à procura de um Scrum Master altamente qualificado para liderar nossas equipes ágeis em projetos de grande complexidade e alto impacto. O candidato ideal possui certificação Scrum Master avançada, juntamente com anos de experiência em facilitação de reuniões ágeis e remoção de impedimentos complexos. Se você é um especialista em metodologias ágeis e é apaixonado por promover a melhoria contínua, esta é a vaga certa para você.','open', 9);
-- Desenvolvedor Frontend Sênior
('Desenvolvedor Frontend Sênior','Sênior','Estamos em busca de um Desenvolvedor Frontend altamente experiente para criar interfaces de usuário excepcionais e funcionais. O candidato ideal possui experiência substancial em HTML, CSS, JavaScript e frameworks Frontend, bem como um histórico comprovado de colaboração eficaz com equipes de design em projetos complexos.','open', 10);
-- Desenvolvedor Backend Sênior
('Desenvolvedor Backend Sênior','Sênior','Estamos à procura de um Desenvolvedor Backend experiente e altamente qualificado para desenvolver lógica e funcionalidades de servidor de alto desempenho. O candidato ideal possui knowledge avançado em linguagens de programação para Backend, otimização de consultas e integração de sistemas complexos. Se você é apaixonado por resolver desafios técnicos em projetos de grande envergadura, esta é a vaga certa para você.','open', 11);
-- Desenvolvedor Full Stack Sênior
('Desenvolvedor Full Stack Sênior','Sênior','Estamos à procura de um Desenvolvedor Full Stack altamente experiente para liderar o desenvolvimento de sistemas complexos, tanto Frontend quanto Backend. O candidato ideal possui knowledge avançado em linguagens de programação para ambas as camadas, bem como abilitys excepcionais para resolver desafios técnicos em todas as partes do sistema.','open', 12);
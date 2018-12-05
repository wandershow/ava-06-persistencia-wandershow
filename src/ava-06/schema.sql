\c postgres
DROP DATABASE IF EXISTS siamelhorado;
CREATE DATABASE siamelhorado;
\c siamelhorado

DROP TABLE IF EXISTS alunos;
CREATE TABLE alunos (
  id              SERIAL      NOT NULL PRIMARY KEY,
  nome            VARCHAR(50) NOT NULL,
  data_nascimento DATE        NOT NULL,
  estado_civil    INTEGER         NULL,
  genero          CHAR(1)         NULL
);

-- 0:solteiro, 1:casado, 2:divorciado, 3:viuvo, 4:separado
-- genero [m, f, n]
INSERT INTO alunos (
  nome, data_nascimento, estado_civil, genero
) VALUES (
  'Marcio Torres', '1976-10-25', 0, 'm'
);

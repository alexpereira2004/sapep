
INSERT INTO resposta (indicador_id, valor, ano)
(
SELECT * FROM (
    SELECT id, 0 AS 'valor' , 1 AS 'ano' FROM indicador i WHERE i.temporalidade <> 'RE'

    UNION

    SELECT i.id, 0, tmp.ano 
      FROM autoavaliacao a
      INNER JOIN eixo e ON e.autoavaliacao_id = a.id
      INNER JOIN indicador i ON i.eixo_id = e.id
      LEFT JOIN (SELECT 2015 ano UNION SELECT 2016 UNION SELECT 2017 UNION SELECT 2018 UNION SELECT 2019) tmp ON 1=1 
      WHERE i.temporalidade = 'RE' 
    ) tmp
    ORDER BY tmp.id  
);
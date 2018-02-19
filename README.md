# XY Inc.

Empresa especializada na produção de excelentes receptores GPS (Global Positioning System).

# Aplicação

Plataforma criada apra auxiliar as pessoas na localização de Pontos de Interesse (POIs). As telas foram criadas de forma a permitir a navegação e utilização dos recursos previstos pela plataforma.

# Ambiente

A plataforma foi disponibizada na nuvem do Heroku como forma de viabilizar os testes de utilização, no entanto, o ambiente não viabilizou o correto uso do web framework bootstrap presente e disponível nos arquivos do projeto.

http://heroku.com

# Funcionalidades

## Cadastro de Pontos de Interesse

Serviço para cadastrar pontos de interesse com 3 atributos: Nome do POI, Coordenada X (inteiro não negativo) Coordenada Y (inteiro não negativo).

https://xy-inc-gps-client.herokuapp.com/new-poi?

### Atributos do Ponto de Interesse

Nome do Ponto de Interesse, texto, não nulo, 100 caracteres;

Coordenada X, inteiro positivo, não nulo;

Coordenada Y, inteiro positivo, não nulo;

## Pontos de Interesse

Serviço que retornará uma lista com todos os Pontos de Interesse cadastrados.

https://xy-inc-gps-client.herokuapp.com/locations

## Busca POIs por Proximidade

Retorna uma lista com todos os Pontos de Interesse que estejam a uma distância menor ou igual a determinado ponto.

https://xy-inc-gps-client.herokuapp.com/locations

### Atributos para a consulta

Coordenada X, inteiro positivo, não nulo;

Coordenada Y, inteiro positivo, não nulo;

Distância, inteiro positivo, não nulo;

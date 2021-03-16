# StarWarsAPI
<p align="left"> 
 API para cadastro de Planetas. </br>
 Consulta API publica do Star Wars também. </br>
 Todos os Endpoints testados se encontram dentro da coleção na raiz do repositório. </br>
 StarWars.postman_collection.json </br>
 Basta importar no postman e testar. </br>
 </P>
 <p align="left"> 
 Como instalar:</p>
 <p align="left"> 
 Instale o MYSQL, crie um banco chamado starwars sem user nem senha,
 Importe a API para sua IDE e rode ela.
 </p>
 <p align="left"> 
 No postman depois de ter importado as coleções pode testar.
 </p>
 <p align="left"> 
 Comportamento:
 </p>
 <p align="left"> 
 No POST ela vai consultar pelo nome a API publica do Star Wars pra comparar o nome.
 São 60 planetas, então se o nome que colocar for diferente pode demorar um pouco.
 A ideia era recuperar tudo num unico momento e depois só buscar pelo array mas a API só retorna no GET 10 primeiros ou um por um.
 Não achei parametro da API pra poder passar pagina, então o unico modo de percorrer os 60 planetas foi indo um por um.
 </p>
 <p align="left"> 
 Caso ele encontre ele vai colocar a QTDE de filmes da API, caso contrario zero.
 </p></br></br>
 <p align="left"> 
 A consulta por nome pega o parametro de pesquisa da url, exemplo:
 </p>
 http://localhost:8080/starwars/planetapornome/CARACTERES_PARA_PESQUISAR
 http://localhost:8080/starwars/planetapornome/Plan
 
 <p align="left"> </br></br>
O Endpoint da exclusão se chama "estrela da morte", contrariando o padrão, apenas porque sim. Referencias. 
 </p>
 http://localhost:8080/starwars/estreladamorte
 </br></br>
 <p align="left"> 
 O CRUD funciona completo.
</P>

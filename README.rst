========================
Documentação da API REST
========================
Essa API faz parte do projeto da disciplina Desenvolvimento de Aplicações Corporativas 2021/1 da UFF. Fornece os serviços de GET/PUT/POST/DELETE sem autenticação para as entidades VOLUME, ARTIGO e AUTOR definidas na entrega anterior.

VOLUME
----------
==============   ===============
Propriedade      Descrição
==============   ===============
id                Identificador único do volume.
siglaEvento       Sigla representativa do evento/volume.
numeroEvento      Número de edição do evento/volume.
cidadeEvento      Cidade sede do evento/volume.
dataInicio        Data do início do evento/volume
descPt            Descrição em idioma original do volume.
descEn            Descrição em versão inglesa do volume.
artigos           Array com artigos associados ao volume.
==============   ===============

Endpoint
~~~~~~~~~~~~~~~

.. code-block:: text

    /volume/
    
GET
+++++

Retorna uma lista de todos os volumes registrados

.. code-block:: bash

   GET /volume/listar HTTP/1.1
   
.. code-block:: js

                {
                    "id": 1,
                    "siglaEvento": "Semana Acadêmica UFF",
                    "cidadeEvento": "Niterói",
                    "dataInicio": "2020-09-30",
                    "descPt": "Semana de apresentação de projetos da UFF",
                    "descEn": "UFF project presentation week ",
                    "artigos": [],
                    "numeroEvento": 1
                },
                {
                    "id": 2,
                    "siglaEvento": "Semana Acadêmica UFF",
                    "cidadeEvento": "Niterói",
                    "dataInicio": "2021-09-30",
                    "descPt": "Semana de apresentação de projetos da UFF",
                    "descEn": "UFF project presentation week ",
                    "artigos": [],
                    "numeroEvento": 2
                }

GET
+++++

Retorna um volume pelo parâmetro id.

.. code-block:: bash

   GET /volume/listar/{id} HTTP/1.1

.. code-block:: js

                {
                    "id": 2,
                    "siglaEvento": "Semana Acadêmica UFF",
                    "cidadeEvento": "Niterói",
                    "dataInicio": "2021-09-30",
                    "descPt": "Semana de apresentação de projetos da UFF",
                    "descEn": "UFF project presentation week ",
                    "artigos": [],
                    "numeroEvento": 2
                }

POST
+++++

Registra um novo volume e retorna o objeto volume.

==============   ===============
Parâmetro        Descrição
==============   ===============
siglaEvento       Sigla representativa do evento/volume.
numeroEvento      Número de edição do evento/volume.
cidadeEvento      Cidade sede do evento/volume.
dataInicio        Data do início do evento/volume
descPt            Descrição em idioma original do volume.
descEn            Descrição em versão inglesa do volume.
artigos           Array com artigos associados ao volume.
==============   ===============

.. code-block:: bash

   POST /volume/ HTTP/1.1

.. code-block:: js

                {
                    "siglaEvento": "Semana Acadêmica UFRJ",
                    "cidadeEvento": "Rio de Janeiro",
                    "dataInicio": "2021-10-25",
                    "descPt": "Semana de apresentação de projetos da UFRJ",
                    "descEn": "UFRJ project presentation week",
                    "artigos": [],
                    "numeroEvento": 1
                }


PUT
+++++

Atualiza um volume e retorna o objeto volume atualizado.

.. code-block:: bash

   PUT /volume/ HTTP/1.1

.. code-block:: js

                {
	                "id": 11,
                	"siglaEvento": "Semana Acadêmica UFF",
	                "cidadeEvento": "Niterói",
                	"dataInicio": "2021-10-15",
                	"descPt": "Semana de apresentação de projetos da UFF",
                	"descEn": "Week of apresentation of projects from UFF",
                	"numeroEvento": 1
                }

DELETE
+++++

Exclui um volume

==============   ===============
Parâmetro        Descrição
==============   ===============
id                Identificador único do volume.
==============   ===============

.. code-block:: bash

   DELETE /volume/ HTTP/1.1

.. code-block:: js

                {
                	"id": 3
                }

ARTIGO
-------------

==============   ===============
Propriedade      Descrição
==============   ===============
id	         Identificador único do artigo.
ordem            Define a ordem dos artigos no volume.
idioma           Idioma original de publicação do artigo.
titulo	         Título em idioma original do artigo.
tituloEn	 Título em inglês do artigo.
resumo	         Resumo geral do artigo.
resumoEn         Resumo geral do artigo em inglês.
keywords         Palavras-chaves do artigo.
keywordsEn       Palavras-chaves em inglês.
numPaginas       Número de páginas do artigo.
autores          Autores associados ao artigo.
==============   ===============

Endpoint
~~~~~~~~~~~~~~~

.. code-block:: text

    /artigo/
    
GET
+++++

Retorna uma lista de todos os artigos registrados

.. code-block:: bash

   GET /artigo/listar HTTP/1.1
   
.. code-block:: js

                {
                    "id": 1,
                    "ordem": 1,
                    "idioma": "PT",
                    "titulo": "TituloPT",
                    "tituloEn": "TituloEN",
                    "resumo": "ResumoPT",
                    "resumoEn": "ResumoEN",
                    "keywords": "keywordsPT",
                    "keywordsEn": "keywordsEN",
                    "numPaginas": 42,
		    autores: []
                },
                {
                    "id": 2,
                    "ordem": 2,
                    "idioma": "PT",
                    "titulo": "Titulo no idioma original",
                    "tituloEn": "English Title",
                    "resumo": "Resumo do artigo, escrito no idioma do artigo.",
                    "resumoEn": "Article abstract, wrote in english.",
                    "keywords": "palavras-chaves;artigo;portugues;teste;dac;mola",
                    "keywordsEn": "palavras-chaves;artigo;portugues;teste;dac;mola",
                    "numPaginas": 777,
		    autores: []
                }

GET
+++++

Retorna um artigo pelo parâmetro id.

.. code-block:: bash

   GET /artigo/listar/{id} HTTP/1.1

.. code-block:: js

                {
                    "id": 7,
                    "ordem": 3,
                    "idioma": "ES",
                    "titulo": "Titulo de lo articulo",
                    "tituloEn": "English title",
                    "resumo": "Resumo de lo artículo",
                    "resumoEn": "English abstract",
                    "keywords": "articulo;espanol",
                    "keywordsEn": "article;spanish",
                    "numPaginas": 54,
		    autores: []
                }

GET
+++++

Retorna os artigos associados pelo volume através do parâmetro volume_id.

.. code-block:: bash

   GET /artigo/listar/volume/{volume_id} HTTP/1.1

.. code-block:: js

                {
                    "id": 17,
                    "ordem": 2,
                    "idioma": null,
                    "titulo": "",
                    "tituloEn": "Second article",
                    "resumo": "Um artigo simples de teste",
                    "resumoEn": "A simple test article ",
                    "keywords": "artigo;teste",
                    "keywordsEn": "article;test",
                    "numPaginas": 16,
                    "autores": []
                },
		{
		    "id": 18,
                    "ordem": 4,
                    "idioma": "PT",
                    "titulo": "",
                    "tituloEn": "First test article",
                    "resumo": "Um artigo simples de teste",
                    "resumoEn": "A simple test article ",
                    "keywords": "artigo;teste",
                    "keywordsEn": "article;test",
                    "numPaginas": 16,
                    "autores": []
		}
POST
+++++

Registra um novo artigo e retorna o objeto artigo.

==============   ===============
Parâmetro        Descrição
==============   ===============
ordem            Define a ordem dos artigos no volume.
idioma           Idioma original de publicação do artigo.
titulo	         Título em idioma original do artigo.
tituloEn	 Título em inglês do artigo.
resumo	         Resumo geral do artigo.
resumoEn         Resumo geral do artigo em inglês.
keywords         Palavras-chaves do artigo.
keywordsEn       Palavras-chaves em inglês.
numPaginas       Número de páginas do artigo.
autores          Autores associados ao artigo.
==============   ===============

.. code-block:: bash

   POST /artigo/ HTTP/1.1

.. code-block:: js

                {
                    "ordem": 1,
	            "idioma": "PT",
	            "titulo": "Titulo no idioma original",
	            "tituloEn": "English Title",
	            "resumo": "Resumo do artigo, escrito no idioma do artigo.",
	            "resumoEn": "Article abstract, wrote in english.",
        	    "keywords": "palavras-chaves;artigo;portugues;teste;dac;mola",
        	    "keywordsEn": "keywords;article;portuguese;test;spring",
        	    "numPaginas": 42,
                    "volume": {
		            "id": 4
	            }
                }


PUT
+++++

Atualiza um artigo e retorna o objeto artigo atualizado.

.. code-block:: bash

   PUT /artigo/ HTTP/1.1

.. code-block:: js

                {
                    "id":3
		    "ordem": 1,
	            "idioma": "ES",
	            "titulo": "Titulo no idioma original",
	            "tituloEn": "English Title",
	            "resumo": "Resumo do artigo, escrito no idioma do artigo.",
	            "resumoEn": "Article abstract, wrote in english.",
        	    "keywords": "palavras-chaves;artigo;portugues;teste;dac;mola",
        	    "keywordsEn": "keywords;article;portuguese;test;spring",
        	    "numPaginas": 27,
                    "volume": {
		            "id": 7
	            }
                }

DELETE
+++++

Exclui um artigo

==============   ===============
Parâmetro        Descrição
==============   ===============
id               Identificador único do artigo.
==============   ===============

.. code-block:: bash

   DELETE /artigo/ HTTP/1.1

.. code-block:: js

                {
                	"id": 3
                }
		
AUTOR
-------------

==============   ===============
Propriedade      Descrição
==============   ===============
id	         Identificador único do autor.
ordem            Define a ordem dos autores no artigo.
email            E-mail do autor.
nome	         Nome do autor.
nomeMeio	 Nome do meio do autor.
sobrenome	 Sobrenome do autor.
afiliacao        Afiliação do autor.
afiliacaoEn      Afiliação do autor em inglês.
pais             País de origem do autor.
orcId            ORCID do autor.
==============   ===============

Endpoint
~~~~~~~~~~~~~~~

.. code-block:: text

    /autor/
    
GET
+++++

Retorna uma lista de todos os autores registrados

.. code-block:: bash

   GET /autor/listar HTTP/1.1
   
.. code-block:: js

                {
                    "id": 1,
                    "ordem": 1,
                    "email": "johndoe@email.com",
                    "nome": "John",
                    "nomeMeio": "",
                    "sobrenome": "Doe",
                    "afiliacao": "Universidade Teste",
                    "afiliacaoEn": "Test University",
                    "pais": "BR",
                    "orcId": "0123-4567-8901-2345"
                },
                {
                    "id": 2,
                    "ordem": 2,
                    "email": "janedoe@email.com",
                    "nome": "Jane",
                    "nomeMeio": "",
                    "sobrenome": "Doe",
                    "afiliacao": "Universidade Teste",
                    "afiliacaoEn": "Test University",
                    "pais": "BR",
                    "orcId": "2345-4567-8901-0123"
                }

GET
+++++

Retorna um autor pelo parâmetro id.

.. code-block:: bash

   GET /autor/listar/{id} HTTP/1.1

.. code-block:: js

                {
                    "id": 1,
                    "ordem": 1,
                    "email": "johndoe@email.com",
                    "nome": "John",
                    "nomeMeio": "",
                    "sobrenome": "Doe",
                    "afiliacao": "Universidade Teste",
                    "afiliacaoEn": "Test University",
                    "pais": "BR",
                    "orcId": "0123-4567-8901-2345"
                }

GET
+++++

Retorna uma lista de todos os autores associados a um determinado artigo

.. code-block:: bash

   GET /autor/listar/artigo/{artigo_id} HTTP/1.1
   
.. code-block:: js

                [
                  {
                    "id": 15,
                    "ordem": 1,
                    "email": "joaocouves@email.com",
                    "nome": "João",
                    "nomeMeio": "das",
                    "sobrenome": "Couves",
                    "afiliacao": "Faculdade de Agronomia",
                    "afiliacaoEn": "Agronomy College",
                    "pais": "UK",
                    "orcId": "4321-4321-4321-4321"
                  },
                  {
                    "id": 16,
                    "ordem": 2,
                    "email": "joaocebolas@email.com",
                    "nome": "João",
                    "nomeMeio": "das",
                    "sobrenome": "Cebolas",
                    "afiliacao": "Faculdade de Agronomia",
                    "afiliacaoEn": "Agronomy College",
                    "pais": "UK",
                    "orcId": "1234-1234-1234-1234"
                  },
                  {
                    "id": 17,
                    "ordem": 3,
                    "email": "joaobatatas@email.com",
                    "nome": "João",
                    "nomeMeio": "das",
                    "sobrenome": "Batatas",
                    "afiliacao": "Faculdade de Agronomia",
                    "afiliacaoEn": "Agronomy College",
                    "pais": "UK",
                    "orcId": "5197-2486-2358-2186"
                  },
                  {
                    "id": 20,
                    "ordem": 4,
                    "email": "johndoe@email.com",
                    "nome": "João",
                    "nomeMeio": "das",
                    "sobrenome": "Bananas",
                    "afiliacao": "Faculdade de Agronomia",
                    "afiliacaoEn": "Agronomy College",
                    "pais": "UK",
                    "orcId": "6436-3463-3463-4534"
                  }
                ]

POST
+++++

Registra um novo autor e retorna o objeto autor.

==============   ===============
Parâmetro        Descrição
==============   ===============
ordem            Define a ordem dos autores no artigo.
email            Idioma original de publicação do artigo.
nome	         Nome do autor.
nomeMeio	 Nome do meio do autor.
sobrenome	 Sobrenome do autor.
afiliacao        Afiliação do autor.
afiliacaoEn      Afiliação do autor em inglês.
pais             País de origem do autor.
orcId            ORCID do autor.
artigo           Artigos associados ao autor.
==============   ===============

.. code-block:: bash

   POST /autor/ HTTP/1.1

.. code-block:: js

                {
                    "id": 3,
                    "ordem": 1,
                    "email": "josedascouves@email.com",
                    "nome": "José",
                    "nomeMeio": "das",
                    "sobrenome": "Couves",
                    "afiliacao": "Universidade de Agronomia",
                    "afiliacaoEn": "Agronomy College",
                    "pais": "UK",
                    "orcId": "9999-9999-9999-9999"
                }


PUT
+++++

Atualiza um autor e retorna o objeto autor atualizado.

.. code-block:: bash

   PUT /autor/ HTTP/1.1

.. code-block:: js

                {
                    "id": 25,
                    "ordem": 1,
                    "email": "fulano@email.com",
                    "nome": "Fulano",
                    "nomeMeio": "",
                    "sobrenome": "Silva",
                    "afiliacao": "Universidade Estadual do Rio de Janeiro",
                    "afiliacaoEn": "State University of Rio de Janeiro",
                    "pais": "BR",
                    "orcId": "1111-1111-1111-1111"
                }

DELETE
+++++

Exclui um autor

==============   ===============
Parâmetro        Descrição
==============   ===============
id               Identificador único do volume.
email            Endereço de e-mail do autor.
orcId			 Identificador ORCID do autor.
==============   ===============

.. code-block:: bash

   DELETE /autor/ HTTP/1.1

.. code-block:: js

                {
                	"id": 3,
			"email": "johndoe@email.com"
			"orcId": "9999-8888-7777-6666"
                }

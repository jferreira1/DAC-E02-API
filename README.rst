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

.. code-block:: bash

   DELETE /volume/ HTTP/1.1

.. code-block:: js

                {
                	"id": 3
                }




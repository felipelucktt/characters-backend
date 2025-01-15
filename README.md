## Sumário
1. [Sobre o Projeto](#neverians-characters)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Instalação](#instalação)
4. [Uso](#uso)
5. [API Endpoints](#api-endpoints)
6. [Exemplos de Requisição](#exemplos-de-requisição)
7. [Configuração com PostgreSQL](#como-usar-o-projeto-com-o-banco-de-dados-PostgreSql)
# Neverians Characters
Como além de programador, sou escritor nas horas vagas, esse é um projeto que tem como objetivo listar os personagens do livro que estou escrevendo. Além de listar os personagens já existentes na base de dados, é possível adicionar um novo personagem, editar informações de um personagem já existente e deletar um personagem.
## Tecnologias Utilizadas
- Java (17)
- Spring Boot
- JPA / Hibernate
- Maven
- API REST
- Database: H2 (Teste), Postgres (Produção)
## Instalação
1. Clone o repositório utilizando o comando abaixo:
```bash
git clone git@github.com:felipelucktt/characters-backend.git
``` 
2. Instale as dependências do Maven
## Uso
1. Inicie a aplicação utilizando o Maven
2. A API será acessivel no endereço http://localhost:8080
## API Endpoints
```
GET /characters - Fornece uma lista com todos os personagens existentes na base de dados

GET /characters/{id} - Busca um personagem pelo ID

POST /characters - Adiciona um novo personagem

DELETE /characters/{id} - Deleta um personagem pelo ID

PUT - /characters/{id} - Modifica um personagem pelo ID
```
## Exemplos de Requisição
- GET
  ``` Json
  "id": 1,
  "name": "Agner",
  "age": 21,
  "race": "Neveriano",
  "kinship": "Kiara (Irmã), Gil (Pai), Ana (mãe)",
  "abilities": "Criação e manipulação de raios, força e resistência sobre humanas, habilidade com a espada.",
  "description": "Agner e Kiara foram criados por pais neverianos...",
   "img": "http://localhost:8080/images/Agner.png"
  ```
- POST
    ``` Json
    "name": "Matthew",
    "age": 23,
    "race": "Neveriano",
    "kinship": "Sem parentes conhecidos",
    "abilities": "Criação e manipulação de raios solares, força e resistência sobre humanas",
    "description": "Matthew é um dos soldados de elite do reino de Erendil...",
    "img": "http://localhost:8080/images/Matthew.png"
    ```
## Como usar o projeto com o banco de dados PostgreSql
Por padrão, o projeto está configurado para funcionar com o banco de dados H2 por facilidade de instalação. Porém, é possível utilizar o projeto utilizando o banco de dados PostgreSql seguindo os passos abaixo:
1. Ir no arquivo application.properties da aplicação e mudar o perfil de "test" para "prod"
```
spring.profiles.active=${APP_PROFILE:prod}
``` 
2. Criar a base de dados no postgres seguindo os dados que estão alocados no arquivo application-prod.properties ou modificar o arquivo para se adequar a base de dados que você já tem instalada. Por padrão o projeto está com a seguinte configuração:
```
database: neverians
port: 5432
username: postgres
password: 1234567
```
3. Popular o banco de dados com os comandos abaixo:
```
create table characters (age integer, id bigint generated by default as identity, abilities varchar(255), description TEXT, img varchar(255), kinship varchar(255), name varchar(255), race varchar(255), primary key (id));
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Agner', 21, 'Neveriano', 'Kiara (Irmã), Gil (Pai), Ana (mãe)', 'Criação e manipulação de raios, força e resistência sobre humanas, habilidade com a espada.', 'Agner e Kiara foram criados por pais neverianos com muito amor e com muito carinho. Anna e Gil não possuíam muitos recursos, não tendo dinheiro o bastante para contratar um mágico pintor de cabelos ou ir até a capital de Erendil e solicitar por uma pintura gratuita. Por conta disso, não conseguiam esconder os seus cabelos brancos que era o que os identificava como neverianos. Para evitar o preconceito das pessoas comuns com a sua raça, eles viveram com seus filhos em uma cabana isolada, próxima a uma floresta nos limites da cidade murada. Certo dia, quando Agner possuía 12 anos e Kiara 8, membros de uma famosa gangue chegaram à sua casa. Sua mãe, pressentindo o perigo, escondeu seus filhos dentro do piso de madeira de sua casa, e escondidos, em pânico, ouviram seus pais serem assassinados. Por último, os assassinos queimaram a sua casa, fazendo com que Agner e Kiara quase não conseguissem escapar. Por sorte, Finn, um caçador que estivera vivendo com Agner e seus pais nos últimos dias, encontrou tanto o garoto quanto Kiara antes que escurecesse. Antes que as feras aparecessem. Finn acaba decidindo cuidar dos dois e com o tempo, ensina Agner a lutar e mostra a ele o caminho da espada. Finn cuidou dos dois por três anos, até que um novo desastre ocorreu. Durante uma caçada, o caçador acabou sucumbindo e vindo a falecer, fazendo com que Agner e Kiara ficassem sozinhos no mundo novamente. Após o ocorrido, os irmãos vagaram pelo mundo sem rumo, fazendo o possível para sobreviver. Eles acabaram se tornando caçadores não oficiais. Não possuíam os recursos disponibilizados pela organização, mas matavam as feras a noite e vendiam seus olhos, seus ossos e sua essência. Era a única forma que eles conheciam de ganhar dinheiro. Ter que sempre cuidar de Kiara acabou fazendo com que Agner criasse um instinto superprotetor para com a irmã, e por sempre esconder o mal da vista dela, ela acabou crescendo como uma pessoa muito pura e bondosa. Já Agner, por ter que aguentar toda a dureza e injustiça do mundo, se tornou uma pessoa bem amarga e cheia de ódio em seu coração. Ódio pelas pessoas que sempre o olhavam com olhares de nojo ou de medo, como se ele fosse um monstro e não um ser humano normal apenas porque era de uma raça diferente. Quando Agner tinha 21 anos e Kiara 17, eles chegaram até uma vila onde morava uma neveriana chamada Rachel, que era bem aceita pelo resto da vila. Após um primeiro encontro um pouco conturbado, os dois acabaram se estabelecendo na residência de Rachel e criando uma boa amizade para com ela. Depois de muitos anos vagando sem rumo, finalmente ambos tinham uma casa. Com isso, Agner juntou dinheiro para que Kiara pudesse pintar o seu cabelo de loiro, mas ele permaneceu com a sua cor natural, por achar que pintar o seu fosse um desperdício de dinheiro.', 'http://localhost:8080/images/Agner.png');
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Kiara', 17, 'Neveriano', 'Agner (Irmão), Gil (Pai), Ana (mãe)', 'Cura', 'Irmã de Agner, Kiara é uma pessoa totalmente pura, inocente e bondosa. Diferente de seu irmão, que nutre um grande ódio em seu coração pelas pessoas, Kiara não tem nada disso, ela tem um grande amor por todos, não à toa, sua habilidade especial é curar outros seres. Essa personalidade e essa habilidade se devem a sua mãe. Desde sempre Kiara desejou que pudesse ser como Ana, uma mulher gentil que trouxesse luz para a vida das outras pessoas. Sua mãe era justamente assim, bondosa, radiante, com um grande coração. Ela também tinha a habilidade de cura, que foi herdada por sua filha em uma tentativa que vinha do fundo do coração da menina de ser mais parecida com a sua mãe. Kiara só despertou essa habilidade após o falecimento de Ana. Ela sente muita falta de ambos os seus pais e constantemente, quando Agner não está olhando, vê seu rosto de encharcar de lágrimas por ter perdido os dois. Com o passar dos anos, de modo involuntário, ela aprendeu que quando os devoradores morriam, ela conseguia curar a alma desses seres, tirando todo o mal, todo o ódio da alma deles, fazendo assim com que eles fossem capazes de ascenderem ao paraíso. Ela sente um grande carinho por Rachel, que considera a sua melhor amiga.', 'http://localhost:8080/images/Kiara.png');
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Rachel', 19, 'Neveriano', 'Sofia (mãe)', 'Criação e manipulação de fogo, habilidade com o arco', 'Rachel foi criada por sua mãe, Sofia, com muito amor e carinho. Sua mãe resolveu pintar tanto o seu cabelo, quanto o de sua filha, para que elas não sofressem preconceito por serem neverianas. Rachel nunca conheceu o seu pai, e sua mãe mencionou pouco sobre ele. Tudo que ela sabia era que ele não era neveriano e que havia morrido em uma guerra do passado. Rachel nasceu e cresceu na vila de Lestor, onde ela e sua mãe viviam normalmente, mesmo sendo neverianas. Por Lestor ser uma vila afastada da maioria das cidades e pobre, seus moradores não possuíam dinheiro o suficiente para contratar um caçador, o que fazia com que eles não conseguissem plantar nada por conta das feras. Isso mudou quando Sofia se mudou para a vila, ela se encarregou de fazer o trabalho dos caçadores e matar as feras que aterrorizavam a vila a noite. Por ser uma neveriana ela conseguiu fazer isso com êxito e em troca todos de Lestor permitiram que ela e sua filha vivessem normalmente na vila sem qualquer tipo de discriminação. A vida de Rachel sofreu um baque quando a sua mãe contraiu uma doença que não possuía cura. Nos primeiros dias da doença, Sofia já sabia que ela não duraria muito tempo, por isso passou a incluir a sua filha nas caçadas, para que ela aprendesse a lutar e pudesse continuar defendendo a vila e tendo um lar pacífico. Poucas semanas depois de ter contraído a doença, Sofia já não conseguia mais se levantar da cama. Curandeiros da vila a visitavam todos os dias, mas nada conseguiam fazer. A vida de Rachel passou a ser cuidar de sua mãe de dia e sair para caçar a noite, o sono se tornou uma coisa rara para ela. Essa rotina durou apenas três meses, contudo. Após esse tempo, Rachel teve que enterrar a sua própria mãe aos seus 16 anos. Com tão pouca idade, a garota teve que aprender a viver sozinha, a cuidar de si mesma de dia e de todos da vila a noite. Sua vida passou a ser difícil e cheia de solidão, sua única felicidade era tocar seu alaúde na taverna da vila em raros dias da semana. Mas isso mudou aos seus 19 anos, foi quando dois neverianos apareceram em Lestor, Agner e Kiara. A princípio, Rachel desconfiou de ambos e foi hostil, mas não demorou muito para eles se tornarem grandes amigos. Agner passou a ajudá-la nas caçadas, aliviando assim o seu fardo imensamente. Como os dois não possuíam moradia, passaram a viver na casa de Rachel e criar vínculos tão fortes quanto o de uma família.', 'http://localhost:8080/images/.png');
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Alice', 23, 'Neveriano', 'Gregory (pai), Alissa (mãe), Elesis (irmã adotiva)', 'Criação e manipulação de luz, manipulação de magia e habilidade com a espada', 'Alice é a princesa do reino de Erendil, primogênita de Gregory e Alissa. O motivo de seu nascimento como uma neveriana é desconhecido, já que tanto seu pai quanto sua mãe são pessoas comuns. Alice passou a maior parte de sua vida dentro do palácio real, saindo apenas em momentos pontuais e sempre com uma forte escolta junto de si. Todas as vezes que saiu de Estores foram apenas para fins políticos e sempre com um grande exército a sua volta. Essa foi a forma que seu pai encontrou de proteger a sua filha da hostilidade que existe contra neverianos. Alice sempre foi terrivelmente eficiente em tudo o que tentava fazer e sempre se dedicava ao máximo as coisas que fazia. Apesar de seu pai tentar sempre protege-la, ela nunca se contentou em ser uma simples princesa indefesa. Sabia que como uma neveriana, ela poderia ser dotada de um grande poder e por conta disso treinou fortemente na arte da espada com os melhores espadachins do reino e na arte da magia com Otto, o mago da corte. Bondade e justiça sempre foram palavras que acompanharam Alice em todas as suas ações. Ela não suporta corrupção e favorecimento político e luta com todas as suas forças para limpar o seu reino desse tipo de coisa. Ao mesmo tempo, luta fortemente para criar um reino onde todas as pessoas possam dividir e viver em harmonia. Sejam humanos comuns, sejam neverianos. Ela sabe o quão difícil é essa tarefa, mas irá lutar para que as coisas ao menos comecem a mudar em sua era. Ela tem plena ciência que possivelmente não irá conseguir acabar com o ódio e a discriminação existente contra os neverianos, mas irá fazer o possível para diminui-lo ao máximo e torce para que seus futuros herdeiros continuem o que ela começou, para que um dia, Erendil seja um reino que não dívida pessoas comuns de neverianos, mas que todos sejam reconhecidos como simples pessoas. Como princesa, Alice já está profundamente ligada a política de Erendil e ajuda o seu pai na maioria das grandes questões do reino como um modo de já ir preparando-a para ser rainha. Alice nunca viu a sua posição como um fardo e nunca tentou fugir de suas obrigações, pelo contrário, ela sempre abraçou profundamente a sua posição como princesa e se esforça ao máximo para se tornar uma governante justa e competente para o seu povo. De certa forma, ela enxerga isso como o seu propósito de vida, então por mais complicado e desgastante que seja ser governante de um reino, ela jamais fugiria disso, jamais fugiria de seu propósito, ela não é uma covarde. Por ser uma pessoa justa e tentar fazer as coisas certas, Alice atraiu desgosto por parte da maioria dos políticos. Esses políticos espalharam diversos rumores mentirosos sobre a princesa, que dizem que ela é uma pessoa extremamente mimada que não suporta que seus caprichos não sejam atendidos. Esses rumores não são levados a sério pela maioria das pessoas. Devido a sua bondade, senso de justiça e forte iniciativa em colocar as coisas em prática, Alice pode ser definida como a luz para um mundo envolto na escuridão. A salvadora que marcha no cavalo branco trazendo a bandeira da paz. A messias prometida.', 'http://localhost:8080/images/Alice.png');
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Elesis', 20, 'Neveriano', 'Gregory (pai adotivo), Alice (irmã adotiva)', 'Criação e manipulação de escuridão.', 'Elesis é a segunda princesa do reino de Erendil. Ainda que não seja filha biológica de Gregory, é tratada como tal. Elesis foi encontrada pelo rei ainda criança vivendo nas ruas sem ninguém para cuidar dela. Como parte de sua campanha política para a libertação dos neverianos, o rei decidiu adotá-la, para mostrar a seriedade de sua causa. Elesis é o completo oposto de Alice. Ela vive intensamente, aproveitando a vida com festas, bebidas e prazeres carnais. Ela não se importa em ser um exemplo para os outros ou uma inspiração, ela não acredita que valha a pena sacrificar a sua felicidade para se prender a ideais. Como ela teve que viver na miséria quando era criança, passando fome, frio e demais necessidades, agora que ela possui todos os recursos financeiros a sua disposição ela os utiliza para viver intensamente. Quando criança ela fora escrava da miséria, não seria agora escrava da opinião alheia.  Apesar de tal divergência de pontos de vista e de visão de mundo das princesas, ambas se amam profundamente como irmãs e Alice é a luz que mantém Elesis no caminho correto. Elesis não se permite se entregar completamente aos seus prazeres porque não quer desapontar a sua irmã ou perder o brilho dela em sua vida. Por Alice, Elesis tenta ser uma pessoa melhor. Por ser uma neveriana e possuir a habilidade especial de controlar a escuridão, Elesis se tornou também uma guerreira. Diferente de Alice ela não é proficiente com armas, sendo um desastre no uso de espadas, lanças ou arcos. Contudo ela é habilidosa no uso da sua magia de escuridão e a utiliza para subjugar seus oponentes. Devido a ela ser poderosa e ser a segunda princesa, Elesis participou de algumas batalhas envolvendo o exército real, principalmente nas disputas próximas à fronteira de seu reino. Ela é uma arma poderosa do exército de Erendil e para o rei Gregory é um alívio poder utilizá-la dessa forma, uma vez que Alice é preciosa demais para ele para que seja enviada em grandes batalhas. Quando está presente em Estores – Capital do reino — Elesis também serve como o braço direito e protetora de Alice.', 'http://localhost:8080/images/Elesis.png');
INSERT INTO characters (name, age, race, kinship, abilities, description, img) VALUES ('Zeno', 18, 'Humano', 'Satoru (pai), Hana (mãe)', 'Habilidade com a espada', 'Zeno nasceu e cresceu na vila de Nemeria. Por ser filho de Satoru, ele naturalmente será o próximo chefe da vila assim que crescer. Nemeria é uma vila localizada no reino de Erendil, mas que sempre desfrutou de certa independência por conta das histórias e lendas do passado, que diziam que ela foi fundada pelo herói que libertou a humanidade da opressão neveriana no passado. Acredita-se que o líder da vila seja descendente direto desse grande herói. Zeno perdeu o seu pai quando ainda era muito jovem. A vila de Nemeria não utiliza caçadores para lidar com os devoradores que saem a noite para devorar a humanidade. Ao invés disso, são os próprios guerreiros da vila que fazem o trabalho de destruir essas criaturas, essa é uma tradição que dura a décadas. Em uma noite de caçada, Satoru e seus guerreiros se depararam com uma das maiores monstruosidades já vistas. Tal monstruosidade estava atacando um menino neveriano que parecia perdido nos arredores da vila. Satoru e seus homens batalharam contra a criatura para tentar salvar o garoto e nisso a maioria dos guerreiros da vila perderam a sua vida. Satoru saiu vivo do embate, mas quando se aproximou do menino neveriano, foi brutalmente assassinado por ele. Ódio e loucura emanavam do olhar da criança. Após a queda de Satoru e de seus guerreiros, a vila de Nemeria entrou em declínio. Os nemerienses não possuíam muitos recursos financeiros, pois sempre dependeram de suas próprias plantações para sobreviver. Com a queda dos guerreiros da vila, não tardou para que suas plantações fossem destruídas pelos devoradores e seus recursos tomados. O rei Gregory naturalmente ofereceu apoio financeiro para a vila após essa tragédia, o que foi o bastante para que eles conseguissem ao menos contratar um caçador. No entanto, por conta do tamanho da vila, um único caçador não era o bastante para proteger todo o território das plantações. Por conta disso, ainda que os nemerienses não passassem fome, a abundância que conheciam antes fora perdida. Por Zeno ser muito jovem quando seu pai veio a falecer, a sucessão de liderança em Nemeria não foi respeitada e Riki — O único sobrevivente do desastre que matou Satoru e os outros — tomou esse posto para si. Com o seu propósito de vida roubado e com a sua vila sendo apenas uma sombra do que já fora, Zeno decidiu se alistar no exército real em Estores, capital de Erendil, para que sua vida valesse de alguma coisa. Sua mãe foi totalmente contra essa ideia. Ela já havia perdido seu marido, não perderia também o seu filho. Hana não conseguiu simplesmente dissuadir Zeno dessa ideia, contudo. Ela então escreveu uma carta ao rei Gregory, apelando para que ele se lembrasse de como Satoru apoiou a campanha política do rei para a libertação dos neverianos e para que ele se lembrasse da importância da vila de Nemeria. Ela pediu um lugar para seu filho no exército, mas um lugar que não o colocasse na linha de frente do perigo. Gregory ouviu o apelo de Hana e pela enorme confiança e dívida que ele tinha com Satoru, tornou Zeno o guarda costas pessoal da princesa Alice. Assim Zeno teria o propósito que tanto buscava e ficaria longe dos maiores perigos. Estando próximo da política central do reino, Zeno também esperava que um dia conseguisse encontrar o assassino de seu pai. O jovem aceitou ser o guarda costas da princesa, mas não podia deixar de achar cômica essa situação, para não dizer trágica. Após o que ocorreu com o seu pai, ele passou a odiar os neverianos. Era simplesmente irônico que ele tivesse que proteger justamente a princesa Alice, que era uma neveriana.', 'http://localhost:8080/images/Zeno.png');
```
## License
Esse projeto utiliza a licença do MIT. Mais detalhes estão contidos no arquivo [LICENSE](./LICENSE). 
## Termos de Uso do Banco de Dados
O código-fonte deste projeto está disponível sob a licença do MIT, no entanto, os dados presentes no banco de dados não estão cobertos por essa licença. Os dados foram fornecidos exclusivamente para permitir testes e avaliação técnica do projeto. Seu uso é restrito a esse contexto, como parte de um teste ou análise técnica.

Qualquer uso dos dados para fins além da avaliação do projeto ou testes não é permitido sem o meu consentimento explícito.

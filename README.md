# Steam-Games-Dataset

## **Sumário**  
- [Descrição](#descrição)  
- [Pré-requisitos](#pré-requisitos) 
- [Preparando o Ambiente](#preparando-o-ambiente)  
  - [Windows](#Windows)  
  - [Linux](#Linux)
  - [Mac OS](#Mac-OS)
- [Instruções de Uso](#instruções-de-uso)

- [Equipe Envolvida](#equipe-envolvida)s

## Descrição
Este projeto tem como objetivo estudar o desempenho dos algoritmos de ordenação utilizando dados reais do "Steam Games Dataset" obtido no [Kaggle](https://www.kaggle.com/datasets/fronkongames/steam-games-dataset). Para isso, é necessário realizar algumas transformações nos dados brutos, garantindo que estejam no formato adequado para processamento.

Nesta primeira etapa do projeto, o foco está na preparação do dataset e na realização de transformações nos dados extraídos do Kaggle. O objetivo é organizar e adaptar os dados para que possam ser processados pelos algoritmos de ordenação.

### Atividades Realizadas na primeira etapa:

Utilização do arquivo "games.csv" para as transformações.

- Conversão das datas de lançamento (campo Release date) para o formato DD/MM/AAAA.

    - Arquivo gerado: "games_formated_release_data.csv".

- Filtragem dos games compatíveis com Linux (campo Linux) a partir do arquivo gerado na primeira transformação (games_formated_release_data.csv).

    - Arquivo gerado: "games_linux.csv".

- Filtragem dos games que possuem suporte ao idioma português (campo Supported languages) a partir do arquivo gerado na primeira transformação (games_formated_release_data.csv).

    - Arquivo gerado: "portuguese_supported_games.csv".

*Em construção...*

## Pré-Requisitos
- Maven versão: 3.8.7
- Java versão: 21.0.6


*Em construção...*

## Preparando o Ambiente
### Windows
*Em construção...*

### Linux

**1. Instalando o Java Development Kit (JDK):**

- [Como instalar o JDK no Ubuntu](https://www.hostinger.com.br/tutoriais/como-instalar-java-no-ubuntu) (testado)

**2. Instalando a Maven:**
- [Como instalar a Maven no Ubuntu](https://www.hostinger.com.br/tutoriais/install-maven-ubuntu)


**3. Instalando e configurando o Visual Studio Code:**

Instale o [Visual Studio Code](https://code.visualstudio.com/docs/setup/linux#_install-vs-code-on-linux) e adicione o package ["Extension Pack for Java"](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack). Esse package contém todos as extensões fundamentais para desenvolvimento na linguagem Java.

*Em construção...*


### Mac OS
*Em construção...*

## Instruções de Uso
Após instalar Java, Maven e o Visual Studio Code, podemos prosseguir, de fato, para a execução do sistema desenvolvido.

Você pode clonar este repositorio usando o URL `https://github.com/davrzin/steam-games-dataset.git` ou baixá-lo como arquivo zip.

Baixe o aquivo  "games.csv" na página Steam Games Dataset da plataforma Kaggle. [Link](https://www.kaggle.com/datasets/fronkongames/steam-games-dataset)

Descompacte o arquivo "games.csv.zip" e cole no diretorio principal deste repositorio.

Após clonar ou baixar, e descompactar, o repositório, abra-o no Visual Studio Code e execute a classe "Program.Java".

Com isso, o sistema irá efetuar as modificações e devolver os arquivos propostoas na pasta principal.

*Em construção...*



## Equipe Envolvida

*Em Construção...*
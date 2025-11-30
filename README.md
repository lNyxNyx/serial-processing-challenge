# 🚗 Desafio – Processamento de Seriais de Veículos

Este repositório contém minha solução completa para o **Desafio de um Processo Seletivo para uma vaga**, cujo objetivo era **manipular, validar, tratar e gerar relatórios** a partir de arquivos contendo **seriais de veículos**.

A aplicação foi desenvolvida em Java puro, utilizando exclusivamente recursos nativos da linguagem (requisito do desafio), evidenciando domínio de lógica, organização de código, boas práticas e manipulação de arquivos sem dependência de frameworks externos.

---

## 📌 Enunciado do Desafio (Resumo)

O desafio consistia em criar um programa capaz de:

### **1️⃣ Gerar dígito verificador**

* A partir de um arquivo contendo vários números seriais **sem DV** (14 caracteres),
* Calcular o dígito verificador com base na **soma dos valores ASCII** dos caracteres,
* Aplicar módulo 16 sobre o resultado,
* Converter o valor para hexadecimal,
* Gerar um novo arquivo contendo os seriais **com DV**.

### **2️⃣ Validar seriais existentes**

* Ler um arquivo contendo seriais **com DV (16 caracteres)**,
* Extrair os 14 primeiros caracteres, recalcular o DV e comparar,
* Gerar um arquivo de saída indicando **verdadeiro** ou **falso**.

### **3️⃣ Gerar relatório por país**

* A partir de um arquivo contendo seriais variados,
* E outro arquivo com o formato `CODIGO;PAIS`,
* Contar quantos veículos existem por país com base nos códigos presentes nos seriais,
* Ordenar e gravar o resultado em um arquivo final.

---

## 🛠️ Tecnologias Utilizadas

* Java 21
* Programação estruturada 
* Manipulação de arquivos (FileReader / FileWriter / Buffer)
* Boas práticas de organização e responsabilidade única

---

## 📂 Estrutura do Projeto

```
├── src
│   ├── main
|   |   ├── java
│   │   │   └── com
│   │   │       └── sidnei
│   │   │           └── desafio
│   │   │               ├── FileWriterService.java
│   │   │               ├── FileReaderService.java
│   │   │               ├── SerialProcessor.java
│   │   │               ├── SerialValidator.java
│   │   │               └── Main.java
│   │   └── resources
│   |    └── data
│   |        ├── input
│   |        │   ├── paises.txt
│   |        │   ├── serieParaRelatorio.txt
│   |        │   ├── serieParaVerificar.txt
│   |        │   └── serieSemDV.txt
│   |        └── output
│   |            ├── listaTotais.txt
│   |            ├── serieComDV.txt
│   |            └── serieVerificada.txt
│   |            
│   |           
│   |            
│   └── test
│       └── java
|── target
|   ├── classes
|   │   └── com
|   │       └── sidnei
|   │           └── desafio
|   │               ├── FileReaderService.class  → Leitura de arquivos
|   │               ├── FileWriterService.class  → Escrita de arquivos
|   │               ├── SerialProcessor.class → Lógica de negócio (DV, país, ASCII)
|   │               ├── SerialValidator.class  → Validações de tamanho e verificação
|   │               └── Main.class   → Orquestração das etapas
|   └── data
|       ├── input
|       └── output
├── pom.xml
└── README.md

```

---

## 🔍 Como o Algoritmo Funciona (Resumo Técnico)

### ✔ Cálculo do DV
1. Converte cada caractere do serial para ASCII;
2. Soma todos os valores;
3. Aplica módulo 16;
4. Converte para hexadecimal;
5. Anexa ao final do serial no formato:

```
Exemplo de arquivo de entrada “serieSemDV.txt”:
0505INDXXA6198
0303PNGXXM1831
1617SLBXXA1088

Arquivo de saída “serieComDV.txt” gerado para o exemplo acima:
0505INDXXA6198-E
0303PNGXXM1831-5
1617SLBXXA1088-2

```

### ✔ Validação de seriais
Para cada serial:
1. Verifica tamanho (14 ou 16 caracteres);
2. Extrai os 14 primeiros;
3. Recalcula o DV;
4. Compara com o DV original;
5. Gera a saída:

```
Exemplo de arquivo de entrada “serieParaVerificar.txt”:
1920ROUXXA2578-9
0505MEXXXM5282-4
0910AUSXXM2065-A
0102SAUXXC3327-E

Arquivo de saída “serieVerificada.txt” gerado para o exemplo acima:
1920ROUXXA2578-9 verdadeiro
0505MEXXXM5282-4 falso
0910AUSXXM2065-A falso
0102SAUXXC3327-E verdadeiro

```

### ✔ Relatório por país
1. Lê o arquivo `paises.txt` com o formato:
```

COD;PAIS

```
2. Identifica qual código aparece em cada serial;
3. Soma quantidades por país;
4. Ordena alfabeticamente;
5. Gera a lista final no formato:
```

Exemplo de arquivo de entrada “serieParaRelatorio.txt”:
1920ARGXXA1420-E
2122MEXXXA3348-4
1414BOLXXA0777-D
1919BRAXXC7973-6
0506MEXXXA1240-D
1818MEXXXA9234-F
2121BRAXXA4566-1
0606ASMXXA9840-3
1212BRAXXA8831-0
0505MEXXXM5282-2

Arquivo de saída “listaTotais.txt” gerado para o exemplo acima contendo
apenas os automóveis e ordenado por país:
American Samoa-1
Argentina-1
Bolivia (Plurinational State of)-1
Brazil-2
Mexico-3

```
## 🔎 Observação:
Os exemplos acima servem apenas como ilustração. Os arquivos fornecidos com o desafio são diferentes dos demonstrados aqui e também variam entre si.
---

## ▶️ Execução do Programa
A classe `Main` executa automaticamente as 3 etapas do desafio:

### **1️⃣ Gerar seriais com DV**
- Entrada: `serieSemDV.txt`
- Saída: `serieComDV.txt`

### **2️⃣ Verificar seriais**
- Entrada: `serieParaVerificar.txt`
- Saída: `serieVerificada.txt`

### **3️⃣ Relatório total por país**
- Entradas:
  - `serieParaRelatorio.txt`
  - `paises.txt`
- Saída:
  - `listaTotais.txt`

---

## 🚀 Possíveis Evoluções
- Implementar testes unitários (JUnit / Mockito)
- Tratar exceções personalizadas
- Criar logs por etapa

---

## 👨‍💻 Sobre o Autor
**Sidnei Ferreira Jr.**  
Desenvolvedor Full Stack

GitHub: [https://github.com/lNyxNyx](https://github.com/lNyxNyx)
LinkedIn: [https://www.linkedin.com/in/sidnei-ferreira-jr1/](https://www.linkedin.com/in/sidnei-ferreira-jr1/)

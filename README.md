# Gerador de QR Code  

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![Google ZXing](https://img.shields.io/badge/Google%20ZXing-3.5.2-blue)
![Docker](https://img.shields.io/badge/Docker-✓-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

Uma aplicação Spring Boot que gera códigos QR e os armazena na AWS S3. Este projeto demonstra a integração da biblioteca ZXing do Google para geração de QR Codes e da AWS S3 para armazenamento.

---

## 📌 Como Usar
Esta seção fornece instruções detalhadas para configurar e executar a aplicação de Gerador de QR Code.

---

## ✅ Pré-requisitos
- JDK Java 21  
- Maven  
- Docker  
- Conta AWS com acesso ao S3  
- AWS CLI configurado com credenciais apropriadas  

---

## 🔐 Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

AWS_ACCESS_KEY_ID=sua_access_key  
AWS_SECRET_ACCESS_KEY=sua_secret_key  
AWS_REGION=sua_região  
AWS_BUCKET_NAME=nome_do_seu_bucket

---

## 🚀 Executando a Aplicação

### 💻 Desenvolvimento Local

1. Crie o arquivo `.env` como descrito acima  
2. Compile o projeto:

mvn clean package

3. Execute a aplicação:

mvn spring-boot:run

---

### 🐳 Implantação com Docker

1. Construa a imagem Docker:

docker build -t qrcode-generator:X.X .

> Lembre-se de substituir a versão e o nome da imagem, se desejar.

2. Execute o container:

docker run --env-file .env -p 8080:8080 qrcode-generator:X.X

> Substitua o caminho do `.env` caso esteja em outro diretório.

---

## ☁️ Configuração AWS S3

- Crie um bucket S3 na sua conta AWS  
- Atualize a variável `AWS_BUCKET_NAME` no seu `.env` ou no comando Docker  
- Garanta que suas credenciais AWS tenham permissões apropriadas para acesso ao bucket

---


## 📮 Endpoints da API

### POST /qrcode

Gera um QR Code a partir do texto fornecido e o armazena na AWS S3. O QR Code será uma imagem PNG com 200x200 pixels.

#### Parâmetros

Nome: text  
Obrigatório: sim  
Tipo: string  
Descrição: O texto que será codificado no QR Code  

#### Resposta de Sucesso

{
  "url": "https://seu-bucket.s3.sua-região.amazonaws.com/uuid-aleatório"
}

#### Resposta de Erro

Em caso de erro na geração ou upload:

- HTTP 500 Internal Server Error

#### Exemplo de Requisição

curl -X POST http://localhost:8080/qrcode \  
     -H "Content-Type: application/json" \  
     -d '{"text": "https://example.com"}'

---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT.

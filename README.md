// 20240906130633
// http://localhost:8080/v3/api-docs

{
  "openapi": "3.0.1",
  "info": {
    "title": "Documentação da API sobre o Sistema de rastremento de encomendas",
    "description": "Esta documentação apresenta os endpoints responsáveis pelas funcionalidades de Pacotes, Rastreamentos e Endereços ",
    "termsOfService": "http://mytersm.com",
    "license": {
      "name": "Apache 2.0",
      "url": "http://mylicences.com"
    },
    "version": "Version 1 (v1)"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "tags": [
    {
      "name": "Pacote",
      "description": "Endpoint para CRUD de pacotes."
    },
    {
      "name": "Endereco",
      "description": "Endpoint para CRUD de endereços."
    },
    {
      "name": "Rastreamento",
      "description": "Endpoint para rastreamento de pacotes."
    }
  ],
  "paths": {
    "/pacotes/{id}": {
      "get": {
        "tags": [
          "Pacote"
        ],
        "summary": "Busca um pacote por ID.",
        "description": "Retorna um pacote específico gravado no BD.",
        "operationId": "getPacoteById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "302": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          }
        }
      },
      "put": {
        "tags": [
          "Pacote"
        ],
        "summary": "Atualiza um pacote.",
        "description": "Atualiza um pacote específico gravado no BD.",
        "operationId": "updatePacote",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Pacote"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          }
        }
      },
      "delete": {
        "tags": [
          "Pacote"
        ],
        "summary": "Deleta um pacote.",
        "description": "Deleta um pacote específico gravado no BD.",
        "operationId": "deletePacote",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "204": {
            "description": "Sucesso"
          },
          "400": {
            "description": "Bad Request"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not Found"
          },
          "500": {
            "description": "Internal Server Error"
          }
        }
      }
    },
    "/pacotes": {
      "get": {
        "tags": [
          "Pacote"
        ],
        "summary": "Busca todos os pacotes.",
        "description": "Retorna uma lista com todos os pacotes gravados no BD.",
        "operationId": "getAllPacotes",
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "Pacote"
        ],
        "summary": "Cria um novo pacote.",
        "description": "Cria um novo pacote e o grava no BD.",
        "operationId": "createPacote",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Pacote"
              }
            }
          },
          "required": true
        },
        "responses": {
          "201": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Pacote"
                }
              }
            }
          }
        }
      }
    },
    "/enderecos": {
      "get": {
        "tags": [
          "Endereco"
        ],
        "summary": "Busca todos os endereços.",
        "description": "Retorna uma lista com todos os endereços gravados no BD.",
        "operationId": "getAllEnderecos",
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/EnderecoDTO"
                  }
                }
              }
            }
          },
          "400": {
            "description": "Bad Request"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not Found"
          },
          "500": {
            "description": "Internal Server Error"
          }
        }
      },
      "post": {
        "tags": [
          "Endereco"
        ],
        "summary": "Cria um novo endereço.",
        "description": "Cria um novo endereço no BD.",
        "operationId": "createEndereco",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/EnderecoDTO"
              }
            }
          },
          "required": true
        },
        "responses": {
          "201": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/EnderecoDTO"
                }
              }
            }
          },
          "400": {
            "description": "Bad Request"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not Found"
          },
          "500": {
            "description": "Internal Server Error"
          }
        }
      }
    },
    "/rastreamentos/{id}": {
      "get": {
        "tags": [
          "Rastreamento"
        ],
        "summary": "Busca todos os rastreamentos de um pacote.",
        "description": "Retorna uma lista com todos os rastreamentos de um pacote gravados no BD.",
        "operationId": "getRastreamentosPacote",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Rastreamento"
                  }
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Rastreamento"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Rastreamento"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Rastreamento"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/pacotes/status/{status}": {
      "get": {
        "tags": [
          "Pacote"
        ],
        "summary": "Busca pacotes por status.",
        "description": "Retorna uma lista com todos os pacotes gravados no BD com o status informado.",
        "operationId": "getPacotesByStatus",
        "parameters": [
          {
            "name": "status",
            "in": "path",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/pacotes/endereco/{enderecoID}": {
      "get": {
        "tags": [
          "Pacote"
        ],
        "summary": "Busca pacotes por endereço.",
        "description": "Retorna uma lista com todos os pacotes gravados no BD com o endereço informado.",
        "operationId": "getPacotesByEndereco",
        "parameters": [
          {
            "name": "enderecoID",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "400": {
            "description": "Bad Request",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "401": {
            "description": "Unauthorized",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not Found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal Server Error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Pacote"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/enderecos/{id}": {
      "get": {
        "tags": [
          "Endereco"
        ],
        "summary": "Busca um endereço por ID.",
        "description": "Retorna um endereço específico gravado no BD.",
        "operationId": "getById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "302": {
            "description": "Sucesso",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/EnderecoDTO"
                }
              }
            }
          },
          "400": {
            "description": "Bad Request"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not Found"
          },
          "500": {
            "description": "Internal Server Error"
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "Endereco": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "rua": {
            "type": "string"
          },
          "numero": {
            "type": "string"
          },
          "cidade": {
            "type": "string"
          },
          "estado": {
            "type": "string"
          },
          "cep": {
            "type": "string"
          }
        }
      },
      "Pacote": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "idUnico": {
            "type": "string"
          },
          "destinatario": {
            "type": "string"
          },
          "endereco": {
            "$ref": "#/components/schemas/Endereco"
          },
          "status": {
            "type": "string"
          },
          "rastreamentos": {
            "type": "array",
            "items": {
              "$ref": "#/components/schemas/Rastreamento"
            }
          }
        }
      },
      "Rastreamento": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "dataHora": {
            "type": "string",
            "format": "date-time"
          },
          "status": {
            "type": "string"
          },
          "localizacao": {
            "type": "string"
          },
          "resumo": {
            "type": "string"
          }
        }
      },
      "EnderecoDTO": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "rua": {
            "type": "string"
          },
          "numero": {
            "type": "string"
          },
          "cidade": {
            "type": "string"
          },
          "estado": {
            "type": "string"
          },
          "cep": {
            "type": "string"
          }
        }
      }
    }
  }
}

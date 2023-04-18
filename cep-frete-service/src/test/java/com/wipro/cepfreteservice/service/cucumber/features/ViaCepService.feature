Feature: Busca de endereço por CEP

  Scenario: Busca de endereço com sucesso
  Given Um CEP válido
  When O usuário busca o endereço pelo CEP
  Then O endereço é retornado com sucesso

  Scenario: Busca de endereço inválido
  Given Um CEP inválido
  When O usuário busca o endereço pelo CEP
  Then Uma exceção é lançada informando que o CEP não foi encontrado

  Scenario: Erro na requisição para API ViaCEP
  Given Uma URL inválida
  When O usuário busca o endereço pelo CEP
  Then uma exceção é lançada informando que ocorreu um erro na requisição
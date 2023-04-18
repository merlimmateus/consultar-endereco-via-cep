Feature: Frete Service

  Scenario: Calcular o frete para um estado do Sudeste
    Given Um estado "SP"
    When Calcular o frete
    Then O valor do frete deve ser de 7.85

  Scenario: Calcular o frete para um estado inválido
    Given Um estado "XX"
    When Calcular o frete
    Then Deve lançar uma exceção informando que o estado é inválido

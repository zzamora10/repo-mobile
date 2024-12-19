Feature: WhenDo

  @ListCategory @Regression
  Scenario: Create ListCategory
    Given WhenDo App is open
    When I create a new ListCategory
      | tituloList | color    |
      | Compras    | rojo     |
      | Musica     | azul     |
      | Otros      | amarillo |
      | Tarea      | verde    |
    Then the list should be displayed


  @Task @Regression
  Scenario: Create Task in List
    Given WhenDo App is open
    And I save random value in $titulo
    When I create a new task in list
      | task | Tarea 0$titulo      |
      | note | note random $titulo |
      | list | Otros               |
    Then the task "Tarea 0$titulo" should be displayed
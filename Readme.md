<h1 align="center"> Projeto de Circuit-Breaker</h1>
Projeto simples com objetivo didático sobre o padrão de projeto conheço como Circuit-Breaker.

### O que é o Circuit-Breaker?
É um padrão de design de software usado para melhorar a resiliência e estabilidade de sistemas distribuídos.

#### Tipos de estado:
- `Estado Aberto`: O interruptor evita fazer a chamada quando o circuito está aberto.
- `Estado Semi-Aberto`: O interruptor envia algumas chamadas como teste para ver ser o problema foi resolvido.
- `Estado Fechado`: O interruptor envia todas as chamadas e elas retornam com sucesso.

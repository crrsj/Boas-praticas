```
# Hamburgueria API - Engenharia & Infraestrutura

Este projeto foca na resiliência de ambiente e na integridade de regras de negócio complexas em sistemas de pedidos.

## 🛠️ Destaques de Engenharia

### 🐳 Orquestração com Docker (Resiliência)
* **Healthcheck Integrado:** A API Java só inicia após a confirmação de disponibilidade (pg_isready) do PostgreSQL, evitando falhas de conexão no boot.
* **Isolamento de Rede:** Uso de redes dedicadas no Docker Compose para segurança entre serviços.

### 🛡️ Integridade de Domínio
* **Rich Domain Model:** As regras de cálculo financeiro são encapsuladas dentro da própria entidade `Pedido`, garantindo que o objeto nunca esteja em um estado inválido.
* **ID Safety (Blindagem):** Proteção sistemática em métodos de persistência para evitar `ID Spoofing` e inconsistências no Hibernate.

### ⚡ Clean Code & Performance
* **Fail-Fast:** Uso do padrão `buscarOuFalhar` para encerrar execuções inválidas logo no início do fluxo.
* **Aritmética Segura:** Transição lógica de tipos primitivos para `BigDecimal` em pontos críticos de cálculo para evitar erros de ponto flutuante.
```

![bp11](https://github.com/user-attachments/assets/4bfb0448-87c9-46dd-abd9-8d807d780891)
![bp10](https://github.com/user-attachments/assets/0d98b302-fb2a-4ae5-abb0-c6d211ebea60)
![bp9](https://github.com/user-attachments/assets/7a59310c-9ad9-4747-83a1-2ca3f6dc1b72)
![bp8](https://github.com/user-attachments/assets/5ee3beaa-ee0a-4f65-9268-a72a8ca91567)
![bp7](https://github.com/user-attachments/assets/e23a0793-3bd6-4cd0-b75d-fd2d74114c7a)
![bp6](https://github.com/user-attachments/assets/40ef1112-fcae-4715-8068-40fbd93f21bb)
![bp5](https://github.com/user-attachments/assets/f923e513-dc62-493d-8f01-7887e60109bb)
![bp4](https://github.com/user-attachments/assets/fc02b949-0c49-45f4-86ad-bd01db9615c1)
![bp3](https://github.com/user-attachments/assets/f19ede4f-8045-483a-85d5-1ca94bc86933)
![bp2](https://github.com/user-attachments/assets/1b47b824-89af-4000-b4e6-15a2df88f4ab)
![bp1](https://github.com/user-attachments/assets/f237c028-ba58-45b9-8fa1-38a7598ab9d7)

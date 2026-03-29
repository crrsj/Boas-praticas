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

![bp11](https://github.com/user-attachments/assets/903b7540-f68b-4fa1-b9b0-12d21152e071)
![bp10](https://github.com/user-attachments/assets/3d574f2f-ecd1-429d-a4de-adae6645ad19)
![bp9](https://github.com/user-attachments/assets/4a30491e-f6da-40cd-bdbf-f35046dedb0f)
![bp8](https://github.com/user-attachments/assets/f5545db7-08cb-4cad-8dd7-1e254ff434ee)
![bp7](https://github.com/user-attachments/assets/da143103-9eec-44d3-bcd9-c26030b457b4)
![bp6](https://github.com/user-attachments/assets/f232f5b5-c381-4c32-b396-972b712320da)
![bp5](https://github.com/user-attachments/assets/9714690c-e37c-4f25-9f7a-83e58821a755)
![bp4](https://github.com/user-attachments/assets/84fdb57a-6282-4eab-869a-2af9ea9c38d5)
![bp3](https://github.com/user-attachments/assets/ad818dc2-6002-4156-9b13-f9c1cbc7c446)
![bp2](https://github.com/user-attachments/assets/411bff33-e361-4c1e-8531-ca9cfedc9b05)
![bp1](https://github.com/user-attachments/assets/07c4bb33-825a-4b21-93c9-2f2341604c34)

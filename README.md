# FlowTask ✅

> **Organize o dia, uma tarefa por vez.**

FlowTask é um aplicativo Android para gerenciamento de tarefas do dia a dia. Com uma interface limpa e objetiva, permite cadastrar, pesquisar, editar e excluir tarefas, definindo título, descrição, data, hora e nível de prioridade.

---

## 📸 Screenshots

| Splash | Lista de tarefas | Nova tarefa | Edição de tarefa |
|:---:|:---:|:---:|:---:|
| <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/e2b7155d-436b-4877-8216-78f0cbf95756" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/d456b2fe-fd0b-471e-ad6f-5121b9097062" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/3ee135ff-9c40-4ff0-962f-f1905ba49013" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/87603ec8-e5aa-4f8c-9291-6af155cc85d1" /> |


---

## ✨ Funcionalidades

- **Splash screen** com a identidade visual do app.
- **Listagem de tarefas** em cards, exibindo título, descrição, data e prioridade.
- **Busca por nome**: campo de pesquisa para filtrar tarefas pelo título.
- **Cadastro de tarefas** com:
  - Título
  - Descrição
  - Data (com seletor de calendário)
  - Hora
  - Prioridade: **Baixa**, **Média** ou **Alta**
- **Edição de tarefas** existentes (botão *Atualizar Tarefa*).
- **Exclusão de tarefas** (botão *Excluir*).
- **Indicador visual de prioridade** por cor nos cards da lista.
- Botão de ação flutuante (**+ Tarefas**) para criar uma nova tarefa rapidamente.

---

## 🖼️ Telas

### 1. Splash
Tela de abertura em azul com o logo do app (um *check* dentro de um círculo), o nome **FlowTask** e o slogan *"Organize o dia, uma tarefa por vez."*

### 2. Minhas Tarefas
Tela principal com campo de busca ("Pesquisa a tarefa pelo nome") e lista de cards. Cada card mostra o título, a descrição, a data e uma etiqueta colorida com a prioridade. O botão flutuante **+ Tarefas** abre a tela de cadastro; tocar em um card abre a edição.

### 3. Nova Tarefa
Formulário com Título, Descrição, Data, Hora e seleção de Prioridade (Baixa / Média / Alta) por *chips*, finalizado pelo botão **Adicionar Tarefa**.

### 4. Edição de Tarefa
Mesmo formulário preenchido com os dados da tarefa, com os botões **Atualizar Tarefa** e **Excluir**.

---

## 🛠️ Tecnologias

- **Linguagem:** Kotlin
- **Plataforma:** Android (módulo `app`)
- **Build:** Gradle com Kotlin DSL (`.kts`) e catálogo de versões (`libs.versions.toml`)
- **KSP (Kotlin Symbol Processing):** processamento de anotações
- **Design:** Material Design 3 (componentes como FAB estendido, chips de seleção, seletor de data)

> ⚠️ **Confirme/ajuste esta seção:** liste aqui as bibliotecas realmente usadas no `app/build.gradle.kts` (ex.: Room para persistência local, ViewModel, Coroutines/Flow, Navigation, Jetpack Compose ou XML/ViewBinding etc.).

---

## 📂 Estrutura do projeto

```
FlowTask/
├── app/                    # Módulo principal do aplicativo Android
├── gradle/                 # Wrapper e catálogo de versões
├── build.gradle.kts        # Configuração de build (nível raiz)
├── settings.gradle.kts     # Módulos e repositórios
├── gradle.properties       # Propriedades do Gradle
├── gradlew / gradlew.bat   # Gradle Wrapper (Linux/macOS e Windows)
└── README.md
```

---

## 🚀 Como executar

### Pré-requisitos

- [Android Studio](https://developer.android.com/studio) (versão recente)
- JDK 17 ou superior
- Dispositivo físico ou emulador com Android compatível com o `minSdk` definido no projeto

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/antoniojose2023/FlowTask.git

# 2. Entre na pasta do projeto
cd FlowTask
```

3. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.
4. Selecione um emulador ou dispositivo conectado.
5. Clique em **Run ▶** (ou use `Shift + F10`).

Para gerar o APK de debug pela linha de comando:

```bash
./gradlew assembleDebug
```

O APK será gerado em `app/build/outputs/apk/debug/`.

---

## 🗺️ Roadmap / Ideias futuras
- [ ] Marcar tarefas como concluídas
- [ ] Filtros e ordenação por prioridade e data


---

## 🤝 Contribuindo

Contribuições são bem-vindas!

1. Faça um *fork* do projeto
2. Crie uma branch: `git checkout -b feature/minha-feature`
3. Faça o commit: `git commit -m "feat: minha feature"`
4. Envie para o seu fork: `git push origin feature/minha-feature`
5. Abra um *Pull Request*

---

## 👨‍💻 Autor

**Antonio José** — [@antoniojose2023](https://github.com/antoniojose2023)

---

## 📄 Licença

Este projeto ainda não possui licença definida.

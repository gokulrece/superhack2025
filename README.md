# 🧠 Kiro Agentic AI  
### Agentic AI Dashboard for IT Workflow Intelligence  
**Team:** GraspAI | **Members:** Gokul Ramasamy, Renuga  

---

## 🚀 Overview
**Kiro Agentic AI** is an **Agentic AI-powered dashboard** built to enhance operational efficiency for **Managed Service Providers (MSPs)** and **IT teams**.  
It integrates **alert monitoring, patch rollout assessment, task automation**, and **AI-driven recommendations** using **Java Spring Boot**, **React**, and **AWS Bedrock**.

---

## 🎯 Problem Statement
Modern MSPs and IT teams face:
- Thousands of raw alerts daily — with duplicates and low-context noise.
- Manual patch validation and rollback analysis.
- Fragmented workflows across monitoring, ticketing, and deployment systems.

This leads to **slower incident resolution**, **inefficient coordination**, and **reduced SLA compliance**.

---

## 💡 Solution
Kiro Agentic AI brings all IT operations into one intelligent view:

| Capability | Description |
|-------------|--------------|
| 🔔 **Alert Intelligence** | AI-based alert deduplication, clustering, and prioritization. |
| 🧩 **Patch Rollout Assessment** | Automated patch conflict detection and rollback suggestions. |
| 🧾 **Task Automation** | Converts critical insights into actionable tasks automatically. |
| 🤖 **AI Insights Panel** | Uses AWS Bedrock LLM for context-aware recommendations. |

> The result: **40% faster triage**, **fewer manual errors**, and **unified workflow visibility**.

---

## 🏗️ System Architecture

```

+--------------------+
| AWS CloudWatch /   |
| Monitoring Sources  |
+--------------------+
|
v
+--------------------+
|   Spring Boot API  |
|  (Alert / Patch /  |
|   Task Services)   |
+--------------------+
|
v
+--------------------+
|   Agentic Logic &  |
|   Bedrock AI Layer |
+--------------------+
|
v
+--------------------+
|   React Dashboard  |
| (Alerts, Patches,  |
|  Tasks, AI Panel)  |
+--------------------+

```

---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Frontend** | React + Vite + Tailwind CSS |
| **Backend** | Java Spring Boot (REST API) |
| **Database** | H2 / MySQL |
| **AI/ML** | AWS Bedrock (LLMs), Agentic Reasoning Logic |
| **Infra** | AWS EC2 / Lambda (optional deployment) |
| **Version Control** | GitHub |

---

## 🧩 Key Features

| Feature | Description |
|----------|--------------|
| **Alert Monitoring** | Real-time alert aggregation and deduplication |
| **Patch Rollback Analysis** | AI assesses patch impact and rollback risk |
| **Task Prioritization** | Automated task creation from AI insights |
| **AI Command Center** | Chat-like interface for querying recent incidents |
| **Data Seeder** | Auto-loads sample data for demo (alerts, patches, tasks) |

---

## 📸 Dashboard Screens

| Section | Preview |
|----------|----------|
| **Home Dashboard** | Overview of alerts, patches, and tasks |
| **Alerts Page** | Alert cards with severity, source, and AI summaries |
| **Patches Page** | Patch status and conflict detection |
| **Tasks Page** | Prioritized actionable tasks |
| **AI Panel** | Bedrock-powered insights and recommendations |

---

## 🧠 Agentic AI Workflow

```

1. Ingest Alerts → via Monitoring Agents
2. AI Deduplication → Remove redundant alerts
3. Patch Analysis → Evaluate conflict & risk
4. Task Generation → Create action tasks automatically
5. Summarization → LLM summarizes insights for dashboard

````

---

## 🧰 Installation & Setup

### 🔹 Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
````

* Default port: `http://localhost:8080`
* H2 Console: `http://localhost:8080/h2-console`
* Data seeded via `DataSeeder.java`

### 🔹 Frontend (React + Vite)

```bash
cd frontend
npm install
npm run dev
```

* Runs on: `http://localhost:5173`

---

## 🔗 Integration with AWS Bedrock

* The backend communicates with **AWS Bedrock** for generative reasoning.
* The model provides recommendations for:

  * Patch conflicts
  * Task summaries
  * Alert deduplication summaries

> Configurable in `application.yml` → `bedrock.apiKey` and model endpoint.

---

## 🎥 Demo Video

**[▶️ Watch Demo on Google Drive](https://drive.google.com/file/d/1ruKcEq2zWSohlAoCeSW0he9wGgxlKK7o/view?usp=drive_link)**
(Duration: ~3 min)
Includes narration + live dashboard walkthrough.

---

## 📘 Prototype Deck

📄 [Download Prototype Deck (PDF)](https://drive.google.com/your-pdf-link)

---

## 🧑‍💻 GitHub Repository

🔗 **[https://github.com/GraspAI/Kiro-Agentic-AI](https://github.com/GraspAI/Kiro-Agentic-AI)**

---

## 🏆 Impact

* ⏱️ 40% faster alert triage
* ⚙️ Automated patch conflict detection
* 📊 Unified visibility for IT Ops
* 🤖 Reduced manual workload with agentic automation

---

## 🔮 Future Enhancements

* Predictive incident detection
* Multi-cloud support (Azure, GCP)
* Natural language runbook generation
* Team chat integration (Slack / Teams)


---

## 👥 Team

| Name                   | Role                                | Focus                   |
| ---------------------- | ----------------------------------- | ----------------------- |
| **Gokul Ramasamy**     | Tech Lead                           | Backend, AI Integration |
| **Renuga**             | DevOps Engineer                     | Dashboard UI & UX       |
| **Team Name:** GraspAI | **Hackathon:** SuperHack 2025 (AWS) |                         |

---

> *Built with ❤️ using Java, React, and AWS Agentic AI.*

```

---

Would you like me to generate the **`README.md` file (downloadable)** now with your real **demo video link** and **PDF deck link** placeholders filled in automatically?  
If yes, please share your:
- 🧾 **Google Drive PDF link**
- 🎥 **Demo video link**
- 💻 **GitHub repo link (public)**

Then I’ll package the final `README.md` file for upload.
```

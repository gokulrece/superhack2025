Architecture Overview

A modular, agent-centric client–server system.

[Event Sources] ─▶ [Spring Boot Backend]
                       ├─ WebSocket Controller
                       ├─ AlertService
                       ├─ AIAnalysisService (Gemini/OpenAI)
                       ├─ Firebase/DB Connector
                       └─ AgentHooks (auto-docs/tests)
            ▼
        [React Frontend]
            ├─ WebSocket Client
            ├─ Alert Feed + AI Insights UI
            ├─ Control Panel (filter, mute, acknowledge)
            └─ Audio/Visual Notification Module

Key Technologies

Backend: Java 17, Spring Boot 3.x, WebSocket, Spring AI, Firebase Admin SDK

Frontend: React 18, Vite or CRA, Tailwind CSS, Socket.IO client, Recharts

AI Integration: Gemini 1.5 Pro / OpenAI GPT-4 via Spring AI starter

Database: Firebase Realtime DB (optional Mongo DB)

Module Design
Layer	Description	Example Classes
controller	Handles incoming WebSocket connections and REST APIs	AlertController.java
service	Business logic for alerts & AI processing	AlertService.java, AIAnalysisService.java
model	Entity + DTO definitions	Alert.java, AIResponse.java
config	WebSocket + AI model configuration	WebSocketConfig.java, AIConfig.java
frontend/components	UI modules for live display	AlertList.jsx, InsightsCard.jsx
Agent Hooks

On alert ingestion → trigger AI analysis automatically.

On code save or build → auto-generate documentation/tests (optional KO-style automation).
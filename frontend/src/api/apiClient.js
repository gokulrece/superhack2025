import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api"; // adjust if your backend uses another port

// ========== PATCHES ==========
export const getPatches = async () => {
  const res = await axios.get(`${API_BASE_URL}/patches`);
  return res.data;
};

export const addPatch = async (patch) => {
  const res = await axios.post(`${API_BASE_URL}/patches`, patch);
  return res.data;
};

export const updatePatch = async (id, patch) => {
  const res = await axios.put(`${API_BASE_URL}/patches/${id}`, patch);
  return res.data;
};

export const deletePatch = async (id) => {
  const res = await axios.delete(`${API_BASE_URL}/patches/${id}`);
  return res.data;
};

// ========== TASKS ==========
export const getTasks = async () => {
  const res = await axios.get(`${API_BASE_URL}/tasks`);
  return res.data;
};

export const addTask = async (task) => {
  const res = await axios.post(`${API_BASE_URL}/tasks`, task);
  return res.data;
};

export const updateTask = async (id, task) => {
  const res = await axios.put(`${API_BASE_URL}/tasks/${id}`, task);
  return res.data;
};

export const deleteTask = async (id) => {
  const res = await axios.delete(`${API_BASE_URL}/tasks/${id}`);
  return res.data;
};

// ========== AI SUMMARY ==========
export const getAISummary = async (prompt) => {
  const res = await axios.post(`${API_BASE_URL}/ai/summary`, { prompt });
  return res.data;
};


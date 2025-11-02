import React, { useState } from "react";
import { getAISummary } from "../api/apiClient";

const AIPanel = () => {
  const [prompt, setPrompt] = useState("");
  const [result, setResult] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleGenerate = async () => {
    if (!prompt.trim()) {
      setError("Please enter a prompt before generating.");
      return;
    }
    setError("");
    setLoading(true);
    setResult("");

    try {
      const data = await getAISummary(prompt);
      setResult(data || "No response from AI service.");
    } catch (err) {
      console.error("AI Summary Error:", err);
      setError("Failed to generate AI summary. Check backend logs.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="p-6 bg-gray-50 min-h-screen">
      <h2 className="text-2xl font-bold mb-6 text-gray-800">AI Insights Panel</h2>

      <div className="bg-white p-6 rounded-2xl shadow-md border border-gray-200 max-w-3xl mx-auto">
        <textarea
          className="w-full p-4 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
          rows="5"
          placeholder="Enter a prompt to generate insights (e.g. 'Summarize patch conflicts in this dataset')..."
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
        />

        <div className="mt-4 flex justify-end">
          <button
            onClick={handleGenerate}
            disabled={loading}
            className={`px-6 py-2 rounded-lg font-medium text-white transition ${
              loading
                ? "bg-blue-300 cursor-not-allowed"
                : "bg-blue-600 hover:bg-blue-700"
            }`}
          >
            {loading ? "Generating..." : "Generate Summary"}
          </button>
        </div>

        {error && (
          <div className="mt-4 text-red-600 font-semibold">{error}</div>
        )}

        {result && (
          <div className="mt-6 bg-gray-100 p-4 rounded-lg border border-gray-300 whitespace-pre-wrap">
            <h3 className="text-lg font-semibold mb-2 text-gray-800">
              AI Generated Summary:
            </h3>
            <p className="text-gray-700">{result}</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default AIPanel;

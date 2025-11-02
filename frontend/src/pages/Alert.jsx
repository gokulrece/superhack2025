import React, { useState, useEffect } from "react";

const Alert = () => {
  const [alerts, setAlerts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [selectedAlert, setSelectedAlert] = useState(null);

  useEffect(() => {
    const fetchAlerts = async () => {
      try {
        setLoading(true);
        setError("");

        const response = await fetch("http://localhost:8080/api/alerts");
        if (!response.ok) throw new Error("Failed to fetch alerts");
        const data = await response.json();

        const sortedData = data.sort((a, b) => {
          const sevOrder = { Critical: 3, High: 2, Medium: 1, Low: 0 };
          return (
            sevOrder[b.severity] - sevOrder[a.severity] ||
            b.confidence - a.confidence
          );
        });

        setAlerts(sortedData);
      } catch (err) {
        console.error(err);
        setError("Unable to load alerts. Please try again.");
      } finally {
        setLoading(false);
      }
    };

    fetchAlerts();
  }, []);

  const getSeverityColor = (severity) => {
    switch (severity) {
      case "Critical":
        return "bg-red-100 text-red-800";
      case "High":
        return "bg-orange-100 text-orange-800";
      case "Medium":
        return "bg-yellow-100 text-yellow-800";
      case "Low":
        return "bg-green-100 text-green-800";
      default:
        return "bg-gray-100 text-gray-800";
    }
  };

  return (
    <div className="p-6">
      <h2 className="text-xl font-bold mb-4 flex items-center gap-2">
        🚨 Alert Monitoring
      </h2>

      {/* Loading State */}
      {loading && (
        <div className="flex justify-center items-center h-40 text-gray-600">
          <div className="animate-spin rounded-full h-5 w-5 border-b-2 border-gray-500 mr-2"></div>
          Loading alerts...
        </div>
      )}

      {/* Error State */}
      {!loading && error && (
        <div className="text-center text-red-500">
          <p>{error}</p>
          <button
            onClick={() => window.location.reload()}
            className="mt-2 bg-blue-600 text-white px-3 py-1 rounded hover:bg-blue-700"
          >
            Retry
          </button>
        </div>
      )}

      {/* Empty State */}
      {!loading && !error && alerts.length === 0 && (
        <div className="text-center text-gray-400">No active alerts.</div>
      )}

      {/* Alerts List */}
      <div className="grid gap-3">
        {!loading &&
          !error &&
          alerts.map((alert) => (
            <div
              key={alert.id}
              onClick={() => setSelectedAlert(alert)}
              className="border rounded-lg p-4 shadow hover:shadow-lg transition cursor-pointer bg-white"
            >
              <div className="flex justify-between items-center">
                <h3 className="font-semibold text-gray-900">
                  {alert.title || alert.type}
                </h3>
                <span
                  className={`text-xs px-2 py-1 rounded ${getSeverityColor(
                    alert.severity
                  )}`}
                >
                  {alert.severity}
                </span>
              </div>
              <p className="text-sm text-gray-600 mt-1">
                Source: {alert.source || "System"} | Confidence:{" "}
                {alert.confidence}%
              </p>
            </div>
          ))}
      </div>

      {/* Modal */}
      {selectedAlert && (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
          <div className="bg-white rounded-lg shadow-lg p-6 w-96 relative">
            <h3 className="text-lg font-semibold mb-2">
              {selectedAlert.title || selectedAlert.type}
            </h3>
            <p className="text-sm mb-1">
              <strong>Severity:</strong>{" "}
              <span
                className={`px-2 py-1 text-xs rounded ${getSeverityColor(
                  selectedAlert.severity
                )}`}
              >
                {selectedAlert.severity}
              </span>
            </p>
            <p className="text-sm mb-1">
              <strong>Confidence:</strong> {selectedAlert.confidence}%
            </p>
            <p className="text-sm mb-1">
              <strong>Source:</strong> {selectedAlert.source || "System Agent"}
            </p>
            <p className="text-sm mb-2">
              <strong>Time:</strong> {selectedAlert.timestamp || "N/A"}
            </p>
            <p className="text-sm text-gray-700">
              <strong>Description:</strong>{" "}
              {selectedAlert.description || "No details available."}
            </p>
            <button
              onClick={() => setSelectedAlert(null)}
              className="mt-4 w-full bg-gray-800 text-white py-2 rounded hover:bg-gray-900"
            >
              Close
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Alert;

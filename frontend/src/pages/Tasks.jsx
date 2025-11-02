import React, { useEffect, useState } from "react";
import { PlusCircle, RefreshCcw } from "lucide-react";

const Tasks = () => {
  const [tasks, setTasks] = useState([]);       // ✅ start as empty array
  const [loading, setLoading] = useState(true); // ✅ handle loading
  const [error, setError] = useState(null);     // ✅ handle error
  const [newTask, setNewTask] = useState({
    title: "",
    priority: "",
    status: "",
    relatedTo: ""
  });

  // Fetch tasks from backend
  const fetchTasks = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch("http://localhost:8080/api/tasks");
      if (!res.ok) throw new Error(`Server error: ${res.status}`);
      const data = await res.json();
      setTasks(Array.isArray(data) ? data : []); // ✅ safe check
    } catch (err) {
      console.error("Error fetching tasks:", err);
      setError("Failed to fetch tasks. Check if backend is running.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  // Add new task (demo only)
  const handleAddTask = async () => {
    if (!newTask.title) return alert("Task title required!");
    try {
      const res = await fetch("http://localhost:8080/api/tasks", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newTask)
      });
      if (!res.ok) throw new Error("Failed to add task");
      setNewTask({ title: "", priority: "", status: "", relatedTo: "" });
      fetchTasks();
    } catch (err) {
      setError("Failed to add task.");
    }
  };

  return (
    <div className="p-6 bg-gray-50 min-h-screen">
      <div className="flex items-center justify-between mb-6">
        <h1 className="text-2xl font-semibold text-gray-800">
          🧩 Task Automation
        </h1>
        <button
          onClick={fetchTasks}
          className="flex items-center px-3 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
        >
          <RefreshCcw size={16} className="mr-2" /> Refresh
        </button>
      </div>

      {/* Add Task Form */}
      <div className="bg-white p-4 rounded-xl shadow mb-6">
        <h2 className="text-lg font-medium mb-4 text-gray-700">Add Task</h2>
        <div className="grid grid-cols-1 sm:grid-cols-4 gap-4 mb-4">
          <input
            type="text"
            placeholder="Title"
            value={newTask.title}
            onChange={(e) =>
              setNewTask({ ...newTask, title: e.target.value })
            }
            className="border rounded-lg p-2"
          />
          <input
            type="text"
            placeholder="Priority"
            value={newTask.priority}
            onChange={(e) =>
              setNewTask({ ...newTask, priority: e.target.value })
            }
            className="border rounded-lg p-2"
          />
          <input
            type="text"
            placeholder="Status"
            value={newTask.status}
            onChange={(e) =>
              setNewTask({ ...newTask, status: e.target.value })
            }
            className="border rounded-lg p-2"
          />
          <input
            type="text"
            placeholder="Related To"
            value={newTask.relatedTo}
            onChange={(e) =>
              setNewTask({ ...newTask, relatedTo: e.target.value })
            }
            className="border rounded-lg p-2"
          />
        </div>
        <button
          onClick={handleAddTask}
          className="flex items-center px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700"
        >
          <PlusCircle size={18} className="mr-2" /> Add Task
        </button>
      </div>

      {/* Tasks Table */}
      <div className="bg-white p-4 rounded-xl shadow">
        <h2 className="text-lg font-medium mb-3 text-gray-700">Tasks List</h2>

        {loading ? (
          <p className="text-gray-600">Loading tasks...</p>
        ) : error ? (
          <p className="text-red-500">{error}</p>
        ) : tasks.length === 0 ? (
          <p className="text-gray-600">No tasks found. Try adding one!</p>
        ) : (
          <div className="overflow-x-auto">
            <table className="min-w-full border border-gray-200 rounded-lg">
              <thead className="bg-gray-100">
                <tr>
                  <th className="py-2 px-4 border-b text-left">Title</th>
                  <th className="py-2 px-4 border-b text-left">Priority</th>
                  <th className="py-2 px-4 border-b text-left">Status</th>
                  <th className="py-2 px-4 border-b text-left">Related To</th>
                  <th className="py-2 px-4 border-b text-center">Actions</th>
                </tr>
              </thead>
              <tbody>
                {tasks.map((task) => (
                  <tr key={task._id} className="hover:bg-gray-50">
                    <td className="py-2 px-4 border-b">{task.title}</td>
                    <td className="py-2 px-4 border-b">{task.priority}</td>
                    <td className="py-2 px-4 border-b">{task.status}</td>
                    <td className="py-2 px-4 border-b">{task.relatedTo}</td>
                    <td className="py-2 px-4 border-b text-center">
                      <button className="text-blue-600 hover:underline mr-3">
                        Edit
                      </button>
                      <button className="text-red-600 hover:underline">
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
};

export default Tasks;

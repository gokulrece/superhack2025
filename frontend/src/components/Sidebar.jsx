import { NavLink } from "react-router-dom";

export default function Sidebar() {
  return (
    <div className="w-64 bg-gray-900 text-white p-6 space-y-6">
      <h2 className="text-2xl font-bold mb-6">Kiro Agentic AI</h2>

      <nav className="flex flex-col space-y-4">
        <NavLink to="/patches" className={({ isActive }) => isActive ? "text-blue-400" : ""}>
          Patches
        </NavLink>
        <NavLink to="/tasks" className={({ isActive }) => isActive ? "text-blue-400" : ""}>
          Tasks
        </NavLink>
        <NavLink to="/alerts" className={({ isActive }) => isActive ? "text-blue-400" : ""}>
          Alerts
        </NavLink> {/* ✅ Added Alerts */}
        <NavLink to="/ai-panel" className={({ isActive }) => isActive ? "text-blue-400" : ""}>
          AI Panel
        </NavLink>
      </nav>
    </div>
  );
}

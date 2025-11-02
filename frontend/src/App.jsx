import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import Patches from "./pages/Patches";
import Tasks from "./pages/Tasks";
import AIPanel from "./components/AIPanel";
import Alert from "./pages/Alert";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />}>
          <Route path="/alerts" element={<Alert />} />
          <Route path="patches" element={<Patches />} />
          <Route path="tasks" element={<Tasks />} />
          <Route path="ai" element={<AIPanel />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

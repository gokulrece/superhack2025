export default function Navbar() {
  return (
    <div className="bg-white shadow p-4 flex justify-between items-center">
      <h1 className="text-lg font-semibold">Agentic AI Dashboard</h1>
      <div className="flex gap-4 items-center">
        <span className="text-gray-600">Welcome, Admin</span>
      </div>
    </div>
  );
}

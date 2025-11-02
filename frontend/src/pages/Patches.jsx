import React, { useEffect, useState } from "react";
import { getPatches, addPatch, updatePatch, deletePatch } from "../api/apiClient";

const Patches = () => {
  const [patches, setPatches] = useState([]);

  useEffect(() => {
    loadPatches();
  }, []);

  const loadPatches = async () => {
    const data = await getPatches();
    setPatches(data);
  };

  return (
    <div className="p-4">
      <h2 className="text-xl font-semibold mb-2">Patch Rollout Assessment</h2>
      <ul className="bg-white rounded-lg shadow p-4">
        {patches.map((p) => (
          <li key={p.id} className="py-2 border-b">{p.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Patches;

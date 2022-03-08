import { useState } from "react";
import { STATUSES, DEFAULT_ROW } from "../Constants";
import Select from "./Select";

const AddRow = ({ onAdd }) => {
  const [row, setRow] = useState(DEFAULT_ROW);

  const onSumbit = (event) => {
    event.preventDefault();
    onAdd(row);
    setRow(DEFAULT_ROW);
  };

  return (
    <form onSubmit={onSumbit}>
      <input
        type="text"
        placeholder="Test name"
        value={row.name}
        onChange={(e) => setRow({ ...row, name: e.target.value })}
      />
      <Select
        options={STATUSES}
        value={row.status}
        onChange={(e) => setRow({ ...row, status: e.target.value })}
      />
      <input type="submit" value="Create new test" />
    </form>
  );
};

export default AddRow;

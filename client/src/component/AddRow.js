import { useState } from "react";
import { Form, Input, InputGroup, Button } from "reactstrap";
import { STATUSES, DEFAULT_ROW } from "../Constants";
import Select from "./Select";

const AddRow = ({ onAdd }) => {
  const [row, setRow] = useState(DEFAULT_ROW);

  const onSubmit = (event) => {
    event.preventDefault();
    onAdd(row);
    setRow(DEFAULT_ROW);
  };

  return (
    <Form onSubmit={onSubmit}>
      <InputGroup>
        <Input
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
        <Button type="submit">Create new test</Button>
      </InputGroup>
    </Form>
  );
};

export default AddRow;

import { Table } from "reactstrap";
import Row from "./Row";

const RowList = ({ rows, onRowChange }) => {
  return (
    <Table>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((row) => (
          <Row key={row.id} content={row} onChange={onRowChange} />
        ))}
      </tbody>
    </Table>
  );
};

export default RowList;

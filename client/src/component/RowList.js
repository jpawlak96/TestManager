import Row from "./Row";

const RowList = ({ rows, onRowChange }) => {
  return (
    <div>
      {rows.map((row) => (
        <Row key={row.id} content={row} onChange={onRowChange} />
      ))}
    </div>
  );
};

export default RowList;

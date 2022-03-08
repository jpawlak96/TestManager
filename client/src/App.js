import { useState, useEffect } from "react";
import AddRow from "./component/AddRow";
import RowList from "./component/RowList";
import RowService from "./service/RowService";

const App = () => {
  const [content, setContent] = useState([]);

  useEffect(() => {
    RowService.getAllRows()
      .then((res) => setContent(res.data))
      .catch((error) => console.log(error));
  }, []);

  const handleAddRow = (row) => {
    RowService.createRow(row)
      .then((res) => setContent([...content, res.data]))
      .catch((error) => console.log(error));
  };

  const handleRowChange = (row) => {
    RowService.updateRow(row)
      .then((res) => changeRowStatus(res.data))
      .catch((error) => console.log(error));
  };

  const changeRowStatus = (row) => {
    const newContent = content.map((el) => (el.id === row.id ? row : el));
    setContent(newContent);
  };

  return (
    <div className='App'>
      <h1>Test manager</h1>
      <AddRow onAdd={handleAddRow} />
      <RowList rows={content} onRowChange={handleRowChange} />
    </div>
  );
};

export default App;

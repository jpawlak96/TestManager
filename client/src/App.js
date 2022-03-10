import "bootstrap/dist/css/bootstrap.min.css";
import { useState, useEffect } from "react";
import { Navbar, NavbarBrand } from "reactstrap";
import AddRow from "./component/AddRow";
import RowList from "./component/RowList";
import RowService from "./service/RowService";

const App = () => {
  const [content, setContent] = useState([]);

  useEffect(() => {
    RowService.getAll()
      .then((res) => setContent(res.data))
      .catch((error) => console.log(error));
  }, []);

  const handleAddRow = (row) => {
    RowService.create(row)
      .then((res) => setContent([...content, res.data]))
      .catch((error) => console.log(error));
  };

  const handleRowChange = (row) => {
    RowService.update(row)
      .then((res) => changeRowStatus(res.data))
      .catch((error) => console.log(error));
  };

  const changeRowStatus = (row) => {
    const newContent = content.map((el) => (el.id === row.id ? row : el));
    setContent(newContent);
  };

  return (
    <div className="container">
      <Navbar color="light" light fixed="top">
        <NavbarBrand>Test manager</NavbarBrand>
        <AddRow onAdd={handleAddRow} />
      </Navbar>
      <RowList rows={content} onRowChange={handleRowChange} />
    </div>
  );
};

export default App;

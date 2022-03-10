import "bootstrap/dist/css/bootstrap.min.css";
import { useState, useEffect } from "react";
import { Navbar, NavbarBrand, Toast, ToastBody } from "reactstrap";
import RowList from "./component/RowList";
import RowService from "./service/RowService";
import SaveModal from "./component/SaveModal";

const App = () => {
  const [content, setContent] = useState([]);
  const [toast, setToast] = useState({
    visible: false,
  });

  useEffect(() => {
    RowService.getAll()
      .then((res) => setContent(res.data))
      .catch(() => showToast("Server Error", 10000));
  }, []);

  const handleRowAdd = (row, onSuccess) => {
    RowService.create(row)
      .then((res) => {
        setContent([...content, res.data]);
        onSuccess();
        showToast("New test created", 2000);
      })
      .catch(() => showToast("Validation Error", 2000));
  };

  const handleRowChange = (row) => {
    RowService.update(row)
      .then((res) => changeRowStatus(res.data))
      .catch(() => showToast("Server Error", 10000));
  };

  const changeRowStatus = (row) => {
    const newContent = content.map((el) => (el.id === row.id ? row : el));
    setContent(newContent);
  };

  const showToast = (message, time) => {
    setToast({ message, visible: true });
    window.setTimeout(() => {
      setToast({ visible: false });
    }, time);
  };

  return (
    <div className="container">
      <Navbar color="light" light fixed="top">
        <NavbarBrand>Test manager</NavbarBrand>
        <SaveModal onSave={handleRowAdd} />
      </Navbar>
      <RowList rows={content} onRowChange={handleRowChange} />
      <Toast isOpen={toast.visible}>
        <ToastBody>{toast.message}</ToastBody>
      </Toast>
    </div>
  );
};

export default App;

import { useState } from "react";
import {
  Modal,
  Button,
  ModalBody,
  ModalHeader,
  ModalFooter,
  Input,
  FormGroup,
  Label,
  Form,
} from "reactstrap";
import { DEFAULT_ROW, STATUSES } from "../Constants";
import Select from "./Select";

const SaveModal = ({ onSave }) => {
  const [modal, setModal] = useState(false);
  const [row, setRow] = useState(DEFAULT_ROW);

  const toggle = () => {
    setModal(!modal);
    setRow(DEFAULT_ROW);
  };

  return (
    <div>
      <Button onClick={toggle}>Create a new test</Button>
      <Modal isOpen={modal} toggle={toggle}>
        <ModalHeader>Create a new test</ModalHeader>
        <ModalBody>
          <Form>
            <FormGroup>
              <Label for="name">Name</Label>
              <Input
                id="name"
                type="text"
                placeholder="Test name"
                value={row.name}
                onChange={(e) => setRow({ ...row, name: e.target.value })}
              />
            </FormGroup>
            <FormGroup>
              <Label for="status">Status</Label>
              <Select
                id="status"
                options={STATUSES}
                value={row.status}
                onChange={(e) => setRow({ ...row, status: e.target.value })}
              />
            </FormGroup>
          </Form>
        </ModalBody>
        <ModalFooter>
          <Button onClick={() => onSave(row, toggle)}>Save</Button>
          <Button outline onClick={toggle}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </div>
  );
};

export default SaveModal;

import Select from "./Select";
import { STATUSES } from "../Constants";

const Row = ({ content, onChange }) => {
  return (
    <div>
      <span>{content.id}. </span>
      <span>{content.name} </span>
      <Select
        options={STATUSES}
        value={content.status}
        onChange={(event) =>
          onChange({ ...content, status: event.target.value })
        }
      />
    </div>
  );
};

export default Row;

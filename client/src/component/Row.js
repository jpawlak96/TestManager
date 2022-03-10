import Select from "./Select";
import { STATUSES } from "../Constants";

const Row = ({ content, onChange }) => {
  return (
    <tr>
      <th scope="row">{content.id}.</th>
      <td>{content.name}</td>
      <td>
        <Select
          options={STATUSES}
          value={content.status}
          onChange={(event) =>
            onChange({ ...content, status: event.target.value })
          }
        />
      </td>
    </tr>
  );
};

export default Row;

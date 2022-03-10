import { Input } from "reactstrap";

const Select = ({ id, options, value, onChange }) => {
  const capitalizeFirstLetter = (text) =>
    text.charAt(0).toUpperCase() + text.slice(1).toLowerCase();

  return (
    <Input
      type="select"
      className="form-control"
      id={id}
      value={value}
      onChange={onChange}
    >
      {options.map((option) => (
        <option key={option} value={option}>
          {capitalizeFirstLetter(option)}
        </option>
      ))}
    </Input>
  );
};

export default Select;

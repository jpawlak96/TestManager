import { Input } from "reactstrap";

const Select = ({ options, value, onChange }) => {
  const capitalizeFirstLetter = (text) =>
    text.charAt(0).toUpperCase() + text.slice(1).toLowerCase();

  return (
    <Input
      type="select"
      value={value}
      onChange={onChange}
      className="form-control"
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

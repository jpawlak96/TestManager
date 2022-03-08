const Select = ({ options, value, onChange }) => {
  const capitalizeFirstLetter = (text) =>
    text.charAt(0).toUpperCase() + text.slice(1).toLowerCase();

  return (
    <select value={value} onChange={onChange}>
      {options.map((option) => (
        <option key={option} value={option}>
          {capitalizeFirstLetter(option)}
        </option>
      ))}
    </select>
  );
};

export default Select;

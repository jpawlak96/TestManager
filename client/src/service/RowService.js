import axios from "axios";

const API_URL = window.location.href + "api";

class RowService {
  getAllRows() {
    return axios.get(`${API_URL}`);
  }

  createRow(row) {
    return axios.post(`${API_URL}`, row);
  }

  updateRow(row) {
    return axios.put(`${API_URL}/${row.id}`, row);
  }
}

export default new RowService();

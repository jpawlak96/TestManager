import axios from "axios";
import { API_URL } from "../Constants";

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

import axios from "axios";
import { API_URL } from "../Constants";

class RowService {
  getAll() {
    return axios.get(`${API_URL}`);
  }

  create(row) {
    return axios.post(`${API_URL}`, row);
  }

  update(row) {
    return axios.put(`${API_URL}/${row.id}`, row);
  }
}

export default new RowService();

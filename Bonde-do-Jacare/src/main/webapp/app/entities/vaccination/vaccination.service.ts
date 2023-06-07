import axios from 'axios';

import { IVaccination } from '@/shared/model/vaccination.model';

const baseApiUrl = 'api/vaccinations';

export default class VaccinationService {
  public find(id: number): Promise<IVaccination> {
    return new Promise<IVaccination>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}

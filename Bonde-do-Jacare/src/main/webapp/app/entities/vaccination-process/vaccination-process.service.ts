import axios from 'axios';

import { IVaccinationProcess } from '@/shared/model/vaccination-process.model';

const baseApiUrl = 'api/vaccination-processes';

export default class VaccinationProcessService {
  public find(id: number): Promise<IVaccinationProcess> {
    return new Promise<IVaccinationProcess>((resolve, reject) => {
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

  public create(entity: IVaccinationProcess): Promise<IVaccinationProcess> {
    return new Promise<IVaccinationProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}

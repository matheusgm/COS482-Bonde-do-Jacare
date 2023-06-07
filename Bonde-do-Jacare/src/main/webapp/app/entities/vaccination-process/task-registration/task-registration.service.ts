import axios from 'axios';
import { TaskRegistrationContext } from './task-registration.model';

const baseApiUrl = 'api/vaccination-process/task-registration';

export default class TaskRegistrationService {
  public loadContext(taskId: number): Promise<TaskRegistrationContext> {
    return new Promise<TaskRegistrationContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskRegistrationContext> {
    return new Promise<TaskRegistrationContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskRegistrationContext: TaskRegistrationContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRegistrationContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}

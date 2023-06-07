import axios from 'axios';
import { TaskApplicationContext } from './task-application.model';

const baseApiUrl = 'api/vaccination-process/task-application';

export default class TaskApplicationService {
  public loadContext(taskId: number): Promise<TaskApplicationContext> {
    return new Promise<TaskApplicationContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskApplicationContext> {
    return new Promise<TaskApplicationContext>((resolve, reject) => {
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

  public complete(taskApplicationContext: TaskApplicationContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskApplicationContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}

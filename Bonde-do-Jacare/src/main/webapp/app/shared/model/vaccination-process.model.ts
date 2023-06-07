import { IVaccination } from '@/shared/model/vaccination.model';

export interface IVaccinationProcess {
  id?: number;
  processInstance?: any | null;
  vaccination?: IVaccination | null;
}

export class VaccinationProcess implements IVaccinationProcess {
  constructor(public id?: number, public processInstance?: any | null, public vaccination?: IVaccination | null) {}
}

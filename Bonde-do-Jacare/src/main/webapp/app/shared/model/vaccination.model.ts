export interface IVaccination {
  id?: number;
  name?: string | null;
  birthDate?: Date | null;
  job?: string | null;
  phoneNumber?: string | null;
  address?: string | null;
  dateAndTime?: Date | null;
  vaccineType?: string | null;
  applicator?: string | null;
}

export class Vaccination implements IVaccination {
  constructor(
    public id?: number,
    public name?: string | null,
    public birthDate?: Date | null,
    public job?: string | null,
    public phoneNumber?: string | null,
    public address?: string | null,
    public dateAndTime?: Date | null,
    public vaccineType?: string | null,
    public applicator?: string | null
  ) {}
}

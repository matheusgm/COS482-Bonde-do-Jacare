export interface IVaccination {
  id?: number;
  name?: string | null;
  age?: number | null;
  job?: string | null;
  phoneNumber?: string | null;
  address?: string | null;
  dateAndTime?: Date | null;
  vaccineType?: string | null;
  applicator?: string | null;
  endStatus?: string | null;
}

export class Vaccination implements IVaccination {
  constructor(
    public id?: number,
    public name?: string | null,
    public age?: number | null,
    public job?: string | null,
    public phoneNumber?: string | null,
    public address?: string | null,
    public dateAndTime?: Date | null,
    public vaccineType?: string | null,
    public applicator?: string | null,
    public endStatus?: string | null
  ) {}
}

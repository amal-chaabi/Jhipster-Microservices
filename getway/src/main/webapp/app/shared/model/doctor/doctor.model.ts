import { Moment } from 'moment';

export interface IDoctor {
  id?: number;
  nom?: string;
  prenom?: string;
  datenaissance?: Moment;
  tel?: string;
  email?: string;
  specialite?: string;
}

export class Doctor implements IDoctor {
  constructor(
    public id?: number,
    public nom?: string,
    public prenom?: string,
    public datenaissance?: Moment,
    public tel?: string,
    public email?: string,
    public specialite?: string
  ) {}
}

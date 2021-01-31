export interface IHospital {
  id?: number;
  nom?: string;
  adresse?: string;
}

export class Hospital implements IHospital {
  constructor(public id?: number, public nom?: string, public adresse?: string) {}
}

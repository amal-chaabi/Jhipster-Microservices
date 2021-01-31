import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'doctor',
        loadChildren: () => import('./doctor/doctor/doctor.module').then(m => m.DoctorDoctorModule),
      },
      {
        path: 'hospital',
        loadChildren: () => import('./hospital/hospital/hospital.module').then(m => m.HospitalHospitalModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class GetwayEntityModule {}

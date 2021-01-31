import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GetwaySharedModule } from 'app/shared/shared.module';
import { HospitalComponent } from './hospital.component';
import { HospitalDetailComponent } from './hospital-detail.component';
import { HospitalUpdateComponent } from './hospital-update.component';
import { HospitalDeleteDialogComponent } from './hospital-delete-dialog.component';
import { hospitalRoute } from './hospital.route';

@NgModule({
  imports: [GetwaySharedModule, RouterModule.forChild(hospitalRoute)],
  declarations: [HospitalComponent, HospitalDetailComponent, HospitalUpdateComponent, HospitalDeleteDialogComponent],
  entryComponents: [HospitalDeleteDialogComponent],
})
export class HospitalHospitalModule {}

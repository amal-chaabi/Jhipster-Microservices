import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { GetwaySharedModule } from 'app/shared/shared.module';
import { GetwayCoreModule } from 'app/core/core.module';
import { GetwayAppRoutingModule } from './app-routing.module';
import { GetwayHomeModule } from './home/home.module';
import { GetwayEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    GetwaySharedModule,
    GetwayCoreModule,
    GetwayHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    GetwayEntityModule,
    GetwayAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class GetwayAppModule {}

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatProgressBarModule,
  MatSelectModule,
  MatTableModule,
  MatToolbarModule,
  MatTooltipModule
} from '@angular/material';
import {ContactService} from './contact/service/contact-service';
import {HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';
import {ContactListComponent} from './contact/contact-list/contact-list.component';
import {appRoutes} from './routes';
import {RouterModule} from '@angular/router';
import {ContactEditComponent} from './contact/contact-edit/contact-edit.component';
import {DialogComponent} from './common/dialog/dialog.component';
import {DialogService} from './common/service/dialog.service';
import {CategoryResolverService, ContactResolverService} from './contact/service/contact-resolver.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CategoryService} from './contact/service/category-service';


@NgModule({
  declarations: [
    AppComponent,
    ContactListComponent,
    ContactEditComponent,
    DialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    HttpClientModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatProgressBarModule,
    MatInputModule,
    MatFormFieldModule,
    MatTooltipModule,
    ReactiveFormsModule,
    MatListModule,
    MatSelectModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, {enableTracing: false, useHash: false}),
  ],
  providers: [
    ContactService,
    CategoryService,
    DialogService,
    ContactResolverService,
    CategoryResolverService
  ],
  entryComponents: [AppComponent, DialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

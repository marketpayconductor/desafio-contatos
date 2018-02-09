import {Routes} from '@angular/router';
import {ContactListComponent} from './contact/contact-list/contact-list.component';
import {ContactEditComponent} from "./contact/contact-edit/contact-edit.component";
import {CategoryResolverService, ContactResolverService} from "./contact/service/contact-resolver.service";

export const appRoutes: Routes = [
  {
    path: '',
    component: ContactListComponent,
    resolve: {
      categories: CategoryResolverService
    }
  },
  {
    path: 'edit/:id',
    component: ContactEditComponent,
    resolve: {
      entity: ContactResolverService,
      categories: CategoryResolverService
    }
  },
  {
    path: 'new',
    component: ContactEditComponent,
    resolve: {
      categories: CategoryResolverService
    }
  }
];

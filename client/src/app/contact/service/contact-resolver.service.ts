import { Injectable } from '@angular/core';
import {Contact} from '../model/contact';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {ContactService} from './contact-service';
import {CategoryService} from "./category-service";
import {Category} from "../model/category";

@Injectable()
export class ContactResolverService implements Resolve<Contact> {

  constructor(private contactService: ContactService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Contact> {
    return this.contactService.getOne(route.params.id);
  }

}
@Injectable()
export class CategoryResolverService implements Resolve<[Category]> {

  constructor(private categoryService: CategoryService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<[Category]> {
    return this.categoryService.list();
  }

}

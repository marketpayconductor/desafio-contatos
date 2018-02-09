import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Contact} from '../model/contact';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../environments/environment';
import 'rxjs/add/operator/map';

@Injectable()
export class ContactService {

  baseURL;
  constructor(private http: HttpClient) {
    this.baseURL = `${environment.API_URL}/contact`;
  }

  getOne(id: number): Observable<Contact> {
    return this.http.get(`${this.baseURL}/${id}`).map(value => <Contact> value);
  }

  save(contact: Contact): Observable<Contact> {
    if (contact.id) {
      return this.http.put(`${this.baseURL}/${contact.id}`, contact).map(value => <Contact> value);
    } else {
      return this.http.post(`${this.baseURL}`, contact).map(value => <Contact> value);
    }
  }

  list() {
    return this.http.get(`${this.baseURL}/`);
  }

  search(name: string) {
    return this.http.get(`${this.baseURL}/search?name=${name}`);
  }

  category(categoryId: number) {
    return this.http.get(`${this.baseURL}/category/${categoryId}`);
  }

  remove(id: number) {
    return this.http.delete(`${this.baseURL}/${id}`);
  }
}

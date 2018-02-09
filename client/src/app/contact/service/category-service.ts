import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../environments/environment';
import 'rxjs/add/operator/map';
import {Category} from '../model/category';

@Injectable()
export class CategoryService {
  baseURL;

  constructor(private http: HttpClient) {
    this.baseURL = `${environment.API_URL}/category`;
  }

  list(): Observable<[Category]> {
    return this.http.get(this.baseURL)
      .map(value => <[Category]> value);
  }
}

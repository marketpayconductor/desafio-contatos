import { Injectable } from '@angular/core';
import {MatDialog} from '@angular/material';
import {DialogComponent} from '../dialog/dialog.component';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class DialogService {

  constructor(private dialog: MatDialog) { }

  alert({message, title}): Observable<any> {
    return this.dialog.open(DialogComponent, {
      width: '450px',
      data: {message, title}
    }).afterClosed();
  }
}

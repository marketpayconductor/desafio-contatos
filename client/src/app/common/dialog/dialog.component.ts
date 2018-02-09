import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.sass']
})
export class DialogComponent implements OnInit {
  message: string;
  title: string;

  constructor(public dialogRef: MatDialogRef<DialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    this.message = data['message'];
    this.title = data['title'];
  }

  ngOnInit() {
  }


  okClick() {
    console.log('ok');
    this.dialogRef.close(DIALOG_EVENT.OK);
  }

  cancelClick() {
    console.log('cancel');
    this.dialogRef.close(DIALOG_EVENT.CANCEL);
  }
}

export const DIALOG_EVENT = {
  OK: 1,
  CANCEL: 2
};

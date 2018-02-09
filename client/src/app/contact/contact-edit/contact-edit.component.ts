import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Contact} from '../model/contact';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ContactService} from '../service/contact-service';
import 'rxjs/add/operator/finally';
import {Category} from '../model/category';
@Component({
  selector: 'app-contact-edit',
  templateUrl: './contact-edit.component.html',
  styleUrls: ['./contact-edit.component.sass']
})
export class ContactEditComponent implements OnInit {
  contact: Contact;
  form: FormGroup;
  isLoading = false;
  categories: [Category];
  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private contactService: ContactService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.contact = this.activatedRoute.snapshot.data['entity'];
    this.categories = this.activatedRoute.snapshot.data['categories'];
    const all: Category = {id: null, name: 'Nenhuma'};
    this.categories.splice(0, 0, all);

    if (!this.contact) {
      this.contact = new Contact();
    }

    this.form = this.formBuilder.group({
      id: [this.contact.id],
      name: [this.contact.name, [Validators.required]],
      address: [this.contact.address, [Validators.required]],
      phoneNumber: [this.contact.phoneNumber, [Validators.required]],
      category: [this.contact.category || all, [Validators.required]],
    });
  }

  compareSelect(c1: Category, c2: Category): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  submit(event) {
    event.preventDefault();
    if (this.form.invalid) {
      return;
    }

    const contactObject = this.form.getRawValue();
    if (contactObject.category.id === null) {
      contactObject.category = null;
    }
    this.isLoading = true;
    this.contactService.save(contactObject)
      .finally(() => this.isLoading = false)
      .subscribe(value => {
        this.goToList();
      });
  }

  goToList() {
    this.router.navigate(['']);
  }

  cancelClick() {
    this.goToList();
  }
}

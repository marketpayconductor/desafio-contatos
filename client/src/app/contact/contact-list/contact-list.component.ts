import { Component, OnInit } from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact-service';
import {DialogService} from '../../common/service/dialog.service';
import {DIALOG_EVENT} from '../../common/dialog/dialog.component';
import 'rxjs/add/operator/finally';
import {ActivatedRoute, Router} from '@angular/router';
import {Category} from '../model/category';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.sass']
})
export class ContactListComponent implements OnInit {
  displayedColumns = ['name', 'address', 'phoneNumber', 'actions'];
  data: [Contact];
  isLoading = false;
  categories: [Category];
  selectedCategory: Category;

  constructor(private contactService: ContactService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private dialogService: DialogService) {
  }

  ngOnInit() {
    this.categories = this.activatedRoute.snapshot.data['categories'];
    const all: Category = {id: null, name: 'Todos'};
    this.selectedCategory = all;
    this.categories.splice(0, 0, all);
    this.fetchAll();
  }

  categoryFilter(category: Category) {
    this.isLoading = true;
    this.selectedCategory = category;
    if (!category.id) {
      return this.fetchAll();
    }

    this.contactService
      .category(category.id)
      .finally(() => this.isLoading = false)
      .subscribe((value: [Contact]) => {
        this.data = value;
      });
  }

  getSectedColor(category: Category) {
    if (category.id === this.selectedCategory.id) {
      return 'accent';
    }
  }

  applyFilter($event, text: string) {
    $event.preventDefault();
    this.isLoading = true;
    this.contactService.search(text)
      .finally(() => this.isLoading = false)
      .subscribe((value: [Contact]) => {
        this.data = value;
      });
  }

  fetchAll() {
    this.isLoading = true;
    return this.contactService.list()
      .finally(() => this.isLoading = false)
      .subscribe((value: [Contact]) => {
        this.data = value;
      });
  }

  edit(contact: Contact) {
    this.router.navigate(['edit', contact.id]);
  }

  addClick() {
    this.router.navigate(['new']);
  }

  remove(contact: Contact) {
    const config = {message: `Confirma remoção do contato: ${contact.name} ?`, title: 'Remoção'};
    this.dialogService.alert(config).subscribe(value => {
      if (value === DIALOG_EVENT.OK) {
        this.doRemove(contact);
      }
    });
  }

  doRemove(contact: Contact) {
    this.isLoading = true;
    this.contactService.remove(contact.id)
      .finally(() => this.isLoading = false)
      .subscribe(value => {
        this.fetchAll();
      });
  }
}

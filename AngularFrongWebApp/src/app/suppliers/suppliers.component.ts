import { Supplier, SuppliersService } from './../services/suppliers.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.css']
})
export class SuppliersComponent implements OnInit {

  suppliers: any;
  errorMessage: string;
  constructor(
    private suppliersService: SuppliersService
  ) { }

  ngOnInit(): void {
    this.suppliersService
        .getSuppliers()
        .subscribe( data => this.suppliers = data, error =>{ this.errorMessage = error.status + " " + error.error.message; console.error(error) });
  }

}

import { Component, OnInit } from '@angular/core';
import { Company } from '../company.model';
import { CompanyService } from '../services/company.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  //companies: Company[];
  companies: Observable<Company[]>;
  constructor(private companyService: CompanyService) { 
    this.getCompanies();
  }

  ngOnInit() {
    this.getCompanies();
  }

  getCompanies() {
    console.log("getting companies!");
    this.companies = this.companyService.getCompanies();
    console.log( this.companies);
    console.log('CREAT REQUEST>...');
    // var comp = this.companyService.create(new Company(123, "sdfsdf", "sdfasf", null, null, 123, 321, null));
    // console.log('CREAT REQUEST DONE...');
    // console.log(comp);
    // console.log('DONE...');
  }

}

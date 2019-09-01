import { Component, OnInit } from '@angular/core';
import { Company } from './company.model';
import { CompanyService } from './services/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-companies',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompaniesComponent implements OnInit {
  selectedCompany: Company;
  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit() {
    console.log("Companies ts!")
    this.companyService.companySelected.subscribe(
      (company: Company) => {
        this.selectedCompany = company;
      }
    );
  }

}

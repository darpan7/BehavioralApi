import { Company } from "../company.model";
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { CompanyService } from '../services/company.service';
import { Observable } from 'rxjs';
import { DatePipe } from '@angular/common'
import * as moment from 'moment';

@Component({
  selector: 'app-company-edit',
  templateUrl: './company-edit.component.html',
  styleUrls: ['./company-edit.component.css']
})
export class CompanyEditComponent implements OnInit {
  id: number;
  editMode = false;
  companyForm: FormGroup;
  private company: Company = new Company(1, "I'm dummy", null, null, null, 0, 0, null);
  companies: Company[] = [];

  constructor(
    private route: ActivatedRoute,
    private companyService: CompanyService,
    private router: Router,
    private datepipe: DatePipe
  ){}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.editMode = params['id'] != null;
      this.initForm();
    });
  }

  onSubmit() {
    console.log("Edit Mode: " + this.editMode);
    if (this.editMode) {
      this.companyService
        .update(this.id, this.companyForm.value)
        .subscribe(comp => this.companies.push(comp));
    } else {
      this.companyService
        .create(this.companyForm.value)
        .subscribe(comp => this.companies.push(comp));
    }
    this.onCancel();
  }

  onCancel() {
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  private initForm() {
    console.log('now: ' + moment());
    let company_name = '';
    let company_jobTitle = '';
    let company_joinedAt = '';
    let company_leftAt = '';
    let company_startSalary = '';
    let company_endSalary = '';
    let company_imagePath = '';

    if (this.editMode) {
      this.companyService
      .get(this.id)
      .subscribe((data: Company)=> {
        this.company = data;
        company_name = this.company.name;
        company_imagePath = this.company.imagePath;
        company_jobTitle = this.company.jobTitle;
        company_joinedAt = this.datepipe.transform(this.company.joinedAt, 'yyyy-MM-dd');
        company_leftAt = this.datepipe.transform(this.company.leftAt, 'yyyy-MM-dd');
        company_startSalary = this.company.startSalary.toString();
        company_endSalary = this.company.endSalary.toString();
        this.companyForm = new FormGroup({
          name: new FormControl(company_name, Validators.required),
          imagePath: new FormControl(company_imagePath),
          jobTitle: new FormControl(company_jobTitle, Validators.required),
          joinedAt: new FormControl(company_joinedAt),
          leftAt: new FormControl(company_leftAt),
          startSalary: new FormControl(company_startSalary),
          endSalary: new FormControl(company_endSalary)
        });
      });
    }
    this.companyForm = new FormGroup({
      name: new FormControl(company_name, Validators.required),
      imagePath: new FormControl(company_imagePath),
      jobTitle: new FormControl(company_jobTitle, Validators.required),
      joinedAt: new FormControl(company_joinedAt),
      leftAt: new FormControl(company_leftAt),
      startSalary: new FormControl(company_startSalary),
      endSalary: new FormControl(company_endSalary)
    });
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { CompanyService } from '../../services/company.service';
import { Company } from '../../company.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-company-item',
  templateUrl: './company-item.component.html',
  styleUrls: ['./company-item.component.css']
})
export class CompanyItemComponent implements OnInit {
  @Input() company: Company;
  constructor(private companyService: CompanyService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute) {

  }

  ngOnInit() {
  }

  onSelected(){
    //this.router.navigate([this.company.id], {relativeTo: this.activatedRoute});
    this.router.navigate(['/companies', this.company.id]);
    //this.companyService.companySelected.emit(this.company);
  }

}

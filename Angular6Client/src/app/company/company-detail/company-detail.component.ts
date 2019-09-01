import { Component, OnInit, Input } from '@angular/core';
import { Company } from '../company.model';
import { CompanyService } from '../services/company.service';
import { Story } from '../../stories/story.model';
import { StoryService } from '../../stories/services/story.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})

export class CompanyDetailComponent implements OnInit {
  @Input() company: Company;
  private routed_company: Company = new Company(1, "I'm dummy", null, null, null, 0, 0, null);
  stories: Observable<Story[]>;
  id: number;
  constructor(
    private companyService: CompanyService,
    private router: ActivatedRoute,
    private route: Router
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params['id'];
    this.companyService.get(this.router.snapshot.params['id']).subscribe((data: Company)=> {
      this.routed_company = data;
      this.stories = this.companyService.storiesByCompany(this.routed_company.id);
    });
    //this.stories = this.companyService.storiesByCompany(this.routed_company.id);
  }

  onEdit() {
    // this.router.navigate(['edit'], {relativeTo: this.route});
    const url = '/companies/' + this.id + '/edit';
    this.route.navigate([url]);
  }

  onDelete() {
    // this.router.navigate(['edit'], {relativeTo: this.route});
    const url = '/companies/';
    this.companyService.delete(this.id).subscribe(data => {
      this.route.navigate([url]);
    });
  }

  
}

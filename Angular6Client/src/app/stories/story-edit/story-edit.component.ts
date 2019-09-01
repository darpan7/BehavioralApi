import { Story } from "../story.model";
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormGroup, FormControl, FormArray, FormBuilder, Validators } from '@angular/forms';
import { StoryService } from '../services/story.service';
import { Observable, of } from 'rxjs';
import { DatePipe } from '@angular/common'
import { Company } from "src/app/company/company.model";
import { CompanyService } from "src/app/company/services/company.service";
import { Question } from "src/app/questions/question.model";
import { QuestionService } from "src/app/questions/services/question.service";
import { resolve } from "q";

@Component({
  selector: 'app-story-edit',
  templateUrl: './story-edit.component.html',
  styleUrls: ['./story-edit.component.css']
})

export class StoryEditComponent implements OnInit {

  id: number;
  editMode = false;
  storyForm: FormGroup;
  myForm: FormGroup;
  private story: Story = new Story(1, null, null, 0, null, null, null);
  stories: Story[] = [];
  companies: Observable<Company[]>;
  questions: Observable<Question[]>;
  selectedItems = ["user"];
  dropdownList:Array<string> = ["user", "system", "admin"]
  dropdownSettings: Object = {
    singleSelection: false,
    idField: 'id',
    textField: 'question',
    selectAllText: 'Select All',
    unSelectAllText: 'UnSelect All',
    itemsShowLimit: 5,
    allowSearchFilter: true
  }
  hard_qs: Question[] = [];
  emails = [{ email: "email1" }, { email: "email2" }, { email: "email3" }, { email: 'email4' }]
  page = 2;
  selectedCompanies;
  loading = false;
  tags = [
    {id: 1, name: "Myself"},
    {id: 2, name: "epic story"},
    {id: 3, name: "bug"}
  ]
  selectedqs = [];



  constructor(
    private route: ActivatedRoute,
    private storyService: StoryService,
    private companyService: CompanyService,
    private questionService: QuestionService,
    private router: Router,
    private datepipe: DatePipe,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.editMode = params['id'] != null;
      this.initForm();
    });
    if (this.editMode) {
      this.storyService.questionsByStory(this.story.id).subscribe(sqs => {
        sqs.map((q, i) => {
          this.selectedqs.push(q.id);
        });
      });
    }
    this.companies = this.companyService.getCompanies();
    this.questions = this.questionService.getQuestions();
    this.questionService.getQuestions().subscribe(qs => {
      this.hard_qs = qs;
      this.addCheckboxes();
    });
    // this.questionService.getQuestions().subscribe(l1 => this.hard_qs = l1);
    this.selectedItems = [];
    // this.dropdownList = [
    //   { item_id: 1, item_text: 'Mumbai' },
    //   { item_id: 2, item_text: 'Bangaluru' },
    //   { item_id: 3, item_text: 'Pune' },
    //   { item_id: 4, item_text: 'Navsari' },
    //   { item_id: 5, item_text: 'New Delhi' }
    // ];
  }

  addTagPromise(name) {
      let xy =  new Promise((resolve) => {
          this.loading = true;
          // Simulate backend call.
          // make post request with tag name.
          // this.storyService.addTag(name)
              // .toPromise()
              // .then(
              //   res => {
              //     this.console.log(res.json());
              //     resolve();
              //   },
              //   msg => {
              //      reject(msg);
              //   }
              // );

          setTimeout(() => {
              resolve({ id: 5, name: name, valid: true });
              this.loading = false;
          }, 1000);
      })
      console.log('Prmoise.....');
      console.log(xy);
      return xy;
  }

  onSubmit() {
    console.log("Edit Mode: " + this.editMode);
    if (this.editMode) {
      this.storyService
        .update(this.id, this.storyForm.value)
        .subscribe(comp => this.stories.push(comp));
    } else {
      console.log('SAVING:');
      console.log(this.storyForm.value);
      this.storyService
        .create(this.storyForm.value)
        .subscribe(comp => this.stories.push(comp));
    }
    this.onCancel();
  }

  onCancel() {
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

  private addCheckboxes() {
    this.hard_qs.map((o, i) => {
      let control;
      if (this.selectedqs.indexOf(o.id) !== -1){
        control = new FormControl(true);
      }else{
        control = new FormControl(false);
      }
      (this.storyForm.controls.t_qs as FormArray).push(control);
    });
  }
  private initForm() {
    let form_title = null;
    let form_situation = null;
    let form_task = null;
    let form_result = null;
    let form_company = null;
    let selectedComapnyId = null;
    let company_startSalary = '';
    let company_endSalary = '';
    let company_imagePath = '';
    let question_id = new FormArray([]);
    const qst = this.questions;
    let ed_qs = new FormArray([]);
    for (let q of this.dropdownList) {
      console.log('pushing...' + q);
      let fg = new FormGroup({});
      fg.addControl(q, new FormControl(false));
      // question_id.push(new FormControl());
      question_id.push(
        new FormGroup({
          name: new FormControl(q)
        })
      );
    }
    let sc: any[];
    if (this.editMode) {
      this.storyService
      .get(this.id)
      .subscribe((data: Story)=> {
        this.story = data;
        form_title = this.story.title;
        form_situation = this.story.situation;
        form_task = this.story.taskAction;
        form_result = this.story.result;
        let qst = new FormArray([]);
        selectedComapnyId = this.story.company.id;
        let abc = this.storyService.questionsByStory(this.story.id);
        let selectedqs: any[];
        abc.subscribe(qs => {
          for (let tmp of qs){
            ed_qs.push(
              new FormGroup({
                id: new FormControl(tmp.id)
              })
            );
          }
        });
        this.storyForm = new FormGroup({
          title: new FormControl(form_title, Validators.required),
          situation: new FormControl(form_situation),
          taskAction: new FormControl(form_task, Validators.required),
          result: new FormControl(form_result),
          question_id: question_id,
          sc: new FormControl(sc),
          selectedComapnyId: new FormControl(selectedComapnyId),
          questions: new FormArray([]),
          t_qs: ed_qs
        });
      });
    } else{
      console.log('NEW STORY>.....');
      this.questions.subscribe(qs => {
        console.log('QUESTIONS RECEIVED.....');
        for (let tmp of qs){
          ed_qs.push(
            new FormGroup({
              id: new FormControl(tmp.id),
              question: new FormControl(tmp.question)
            })
          );
        }
        this.storyForm = new FormGroup({
          title: new FormControl(form_title, Validators.required),
          situation: new FormControl(form_situation),
          taskAction: new FormControl(form_task),
          result: new FormControl(form_result),
          company: new FormControl(form_company),
          question_id: question_id,
          sc: new FormControl(sc),
          selectedComapnyId: new FormControl(selectedComapnyId),
          questions: new FormArray([]),
          t_qs: ed_qs //new FormArray([])
        });
      });
      console.log('DID NOT WAIT FOR QUESTIONS.....');
      let tmp_qs = new FormArray([]);
      tmp_qs.push(
        new FormGroup({
            id: new FormControl(null),
            question: new FormControl(null)
        })
      )
      this.storyForm = new FormGroup({
        title: new FormControl(form_title, Validators.required),
        situation: new FormControl(form_situation),
        taskAction: new FormControl(form_task),
        result: new FormControl(form_result),
        company: new FormControl(form_company),
        question_id: question_id,
        sc: new FormControl(sc),
        selectedComapnyId: new FormControl(selectedComapnyId),
        questions: new FormArray([]),
        t_qs: tmp_qs
      });
    }

    this.myForm = this.fb.group({
      useremail: this.fb.array([])
    });
  }


  onChange(email: string, isChecked: boolean) {
    const emailFormArray = <FormArray>this.storyForm.controls.questions;

    if (isChecked) {
      emailFormArray.push(new FormControl(email));
    } else {
      let index = emailFormArray.controls.findIndex(x => x.value == email)
      emailFormArray.removeAt(index);
    }
  }

}

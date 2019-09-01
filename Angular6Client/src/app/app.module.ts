import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { NgSelectModule } from '@ng-select/ng-select';

import { AppComponent } from './app.component';
import { StoriesComponent } from './stories/stories.component';
import { StoryListComponent } from './stories/story-list/story-list.component';
import { StoryDetailComponent } from './stories/story-detail/story-detail.component';
import { StoryItemComponent } from './stories/story-list/story-item/story-item.component';
import { StoryService } from './stories/services/story.service';

import { CompaniesComponent } from './company/company.component';
import { CompanyListComponent } from './company/company-list/company-list.component';
import { CompanyDetailComponent } from './company/company-detail/company-detail.component';
import { CompanyItemComponent } from './company/company-list/company-item/company-item.component';
import { CompanyService } from './company/services/company.service';

import { QuestionsComponent } from './questions/questions.component';
import { QuestionListComponent } from './questions/question-list/question-list.component';
import { QuestionDetailComponent } from './questions/question-detail/question-detail.component';
import { QuestionItemComponent } from './questions/question-list/question-item/question-item.component';
import { QuestionService } from './questions/services/question.service';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common'
import { Util } from './common/util.service';
import { CompanyEditComponent } from './company/company-edit/company-edit.component';
import { StoryEditComponent } from './stories/story-edit/story-edit.component';

const appRoutes: Routes = [
  {path: 'stories/new', component: StoryEditComponent},
  {path: 'stories/:id/edit', component: StoryEditComponent},
  {path: 'stories', component: StoriesComponent},
  {path: 'stories/:id', component: StoryDetailComponent},
  {path: 'companies/new', component: CompanyEditComponent},
  {path: 'companies/:id/edit', component: CompanyEditComponent},
  {path: 'companies', component: CompaniesComponent},
  {path: 'companies/:id', component: CompanyDetailComponent},
  {path: 'questions', component: QuestionsComponent},
  {path: 'questions/:id', component: QuestionDetailComponent},
  {path: 'questions/new', component: QuestionItemComponent},
  {path: '', component: StoriesComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    CompanyListComponent,
    CompanyDetailComponent,
    CompanyItemComponent,
    StoriesComponent,
    StoryListComponent,
    StoryDetailComponent,
    StoryItemComponent,
    QuestionsComponent,
    QuestionListComponent,
    QuestionDetailComponent,
    QuestionItemComponent,
    CompanyEditComponent,
    StoryEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    NgMultiSelectDropDownModule,
    ReactiveFormsModule,
    NgSelectModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CompanyService, DatePipe, StoryService, QuestionService, Util],
  bootstrap: [AppComponent]
})
export class AppModule { }

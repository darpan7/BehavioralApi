import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { StoriesComponent } from './stories/stories.component';
import { StoryListComponent } from './stories/story-list/story-list.component';
import { StoryDetailComponent } from './stories/story-detail/story-detail.component';
import { StoryItemComponent } from './stories/story-list/story-item/story-item.component';
import { StoryService } from './stories/services/story.service';
import { QuestionsComponent } from './questions/questions.component';
import { QuestionListComponent } from './questions/question-list/question-list.component';
import { QuestionDetailComponent } from './questions/question-detail/question-detail.component';
import { QuestionItemComponent } from './questions/question-list/question-item/question-item.component';
import { QuestionService } from './questions/services/question.service';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  {path: '', component: StoriesComponent},
  {path: 'stories', component: StoriesComponent},
  {path: 'stories/:id', component: StoryDetailComponent},
  {path: 'questions', component: QuestionsComponent},
  {path: 'questions/:id', component: QuestionDetailComponent},
]
@NgModule({
  declarations: [
    AppComponent,
    StoriesComponent,
    StoryListComponent,
    StoryDetailComponent,
    StoryItemComponent,
    QuestionsComponent,
    QuestionListComponent,
    QuestionDetailComponent,
    QuestionItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [StoryService, QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';
import { Question } from '../question.model';
import { QuestionService } from '../services/question.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {
  questions: Observable<Question[]>;
  constructor(private questionService: QuestionService) { }

  ngOnInit() {
    this.questions = this.questionService.getQuestions();
  }

}

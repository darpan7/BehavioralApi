import { Component, OnInit } from '@angular/core';
import { Question } from './question.model';
import { QuestionService } from './services/question.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  selectedQuestion: Question;
  constructor(private questionService: QuestionService, private router: Router) { }

  ngOnInit() {
    this.questionService.questionSelected.subscribe(
      (question: Question) => {
        this.selectedQuestion = question;
      }
    );
  }
}

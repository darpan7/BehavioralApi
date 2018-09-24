import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../question.model';
import { QuestionService } from '../../services/question.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-question-item',
  templateUrl: './question-item.component.html',
  styleUrls: ['./question-item.component.css']
})
export class QuestionItemComponent implements OnInit {
  @Input() question: Question;
  constructor(private questionService: QuestionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    
  }
  onSelected(){
    this.router.navigate([this.question.id], {relativeTo: this.activatedRoute});
    //this.questionService.questionSelected.emit(this.question);
    //this.router.navigate(['/questions/2']);
  }

}

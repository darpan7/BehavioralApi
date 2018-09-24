import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../question.model';
import { QuestionService } from '../services/question.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Story } from '../../stories/story.model';
import { StoryService } from '../../stories/services/story.service';

@Component({
  selector: 'app-question-detail',
  templateUrl: './question-detail.component.html',
  styleUrls: ['./question-detail.component.css']
})
export class QuestionDetailComponent implements OnInit {
  @Input() question: Question;
  routed_question: Question;
  routed_stories: Story[] = [];
  constructor(private questionService: QuestionService, private router: ActivatedRoute, private storyService: StoryService) { }

  ngOnInit() {
    this.routed_question = this.questionService.get(this.router.snapshot.params['id']);
    this.routed_stories = this.storyService.getByQuestion(this.routed_question.id);

  }

}

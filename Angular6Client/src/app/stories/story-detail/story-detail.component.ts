import { Component, OnInit, Input } from '@angular/core';
import { Story } from '../story.model';
import { StoryService } from '../services/story.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Question } from '../../questions/question.model';
import { QuestionService } from '../../questions/services/question.service';
import { Company } from '../../company/company.model';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
  styleUrls: ['./story-detail.component.css']
})
export class StoryDetailComponent implements OnInit {
  @Input() story: Story;
  private routed_story: Story = new Story(1, "", new Company(2, ""), 2, "", "", "");
  //obsrvd_story: Observable<Object>;
  obsrvd_story: Observable<Story>;
  questions: Observable<Question[]>;
  constructor(private storyService: StoryService, private router: ActivatedRoute, private questionService: QuestionService) { }

  ngOnInit() {
    //this.obsrvd_story = this.storyService.get(this.router.snapshot.params['id']);
    this.storyService.get(this.router.snapshot.params['id']).subscribe((data: Story)=> {
      this.routed_story = data;
      console.log("subscribing...");
    });
    console.log(this.routed_story.title);
    /*this.storyService.get(this.router.snapshot.params['id']).subscribe(object => {
      this.story = object as Story
    });*/
    console.log(this.routed_story);
    console.log("in string: " + this.routed_story);
    //this.obsrvd_story = this.story;
    //this.routed_story = this.story;
    this.questions = this.questionService.questionsByStory(this.routed_story.id);
  }

  
}

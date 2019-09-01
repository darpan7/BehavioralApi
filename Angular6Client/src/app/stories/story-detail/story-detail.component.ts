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
  private routed_story: Story = new Story(1, "", null, 2, "", "", "");
  obsrvd_story: Observable<Story>;
  questions: Observable<Question[]>;
  id: number;
  constructor(
    private storyService: StoryService,
    private router: ActivatedRoute,
    private questionService: QuestionService,
    private route: Router
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params['id'];
    this.storyService.get(this.router.snapshot.params['id']).subscribe((data: Story)=> {
      this.routed_story = data;
      console.log("subscribing...");
      console.log(this.routed_story);
      console.log("in string: ");
      console.log(this.routed_story);
      console.log(this.routed_story.company);
      console.log(this.routed_story.title);
      this.questions = this.storyService.questionsByStory(this.routed_story.id);
    });
    /*this.storyService.get(this.router.snapshot.params['id']).subscribe(object => {
      this.story = object as Story
    });*/
    
  }

  onEdit() {
    // this.router.navigate(['edit'], {relativeTo: this.route});
    const url = '/stories/' + this.id + '/edit';
    this.route.navigate([url]);
  }

  onDelete() {
    const url = '/stories/';
    this.storyService.delete(this.id).subscribe(data => {
      this.route.navigate([url]);
    });
  }
  
}

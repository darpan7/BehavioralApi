import { Component, OnInit, Input } from '@angular/core';
import { Story } from '../story.model';
import { StoryService } from '../services/story.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
  styleUrls: ['./story-detail.component.css']
})
export class StoryDetailComponent implements OnInit {
  @Input() story: Story;
  routed_story: Story;
  constructor(private storyService: StoryService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.routed_story = this.storyService.get(this.router.snapshot.params['id']);
  }

  
}

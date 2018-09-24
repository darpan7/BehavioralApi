import { Component, OnInit } from '@angular/core';
import { Story } from '../story.model';
import { StoryService } from '../services/story.service';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.css']
})
export class StoryListComponent implements OnInit {
  stories: Story[];
  constructor(private storyService: StoryService) { }

  ngOnInit() {
    this.stories = this.storyService.getStories();
  }

}

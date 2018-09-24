import { Component, OnInit } from '@angular/core';
import { Story } from '../story.model';
import { StoryService } from '../services/story.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.css']
})
export class StoryListComponent implements OnInit {
  //stories: Story[];
  stories: Observable<Story[]>;
  constructor(private storyService: StoryService) { }

  ngOnInit() {
    console.log("getting stories!");
    this.stories = this.storyService.getStories();
    console.log("Story 1: ", this.stories[0]);
  }

}

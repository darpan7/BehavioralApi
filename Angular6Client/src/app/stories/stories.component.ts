import { Component, OnInit } from '@angular/core';
import { Story } from './story.model';
import { StoryService } from './services/story.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.css']
})
export class StoriesComponent implements OnInit {
  selectedStory: Story;
  constructor(private storyService: StoryService, private router: Router) { }

  ngOnInit() {
    console.log("Stories ts!")
    this.storyService.storySelected.subscribe(
      (story: Story) => {
        this.selectedStory = story;
      }
    );
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { StoryService } from '../../services/story.service';
import { Story } from '../../story.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-story-item',
  templateUrl: './story-item.component.html',
  styleUrls: ['./story-item.component.css']
})
export class StoryItemComponent implements OnInit {
  @Input() story: Story;
  constructor(private storyService: StoryService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute) {

  }

  ngOnInit() {
  }

  onSelected(){
    this.router.navigate([this.story.id], {relativeTo: this.activatedRoute});
    //this.router.navigate(['/stories', '1']);
    //this.storyService.storySelected.emit(this.story);
  }

}

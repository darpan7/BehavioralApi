import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  styles: [
    `
    :host ::ng-deep .tabset1 a.nav-link {
      color: green;
    }
    
    :host ::ng-deep .tabset1 a.nav-link.active {
      color: red;
      font-weight: bold;
    }
`
  ]
})
export class AppComponent {
  title = 'story-board';
}

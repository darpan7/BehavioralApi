import { Story } from "../story.model";
import { EventEmitter, Injectable } from "@angular/core";
import { Company } from "../../company/company.model";
import { Question } from "../../questions/question.model";
import { QuestionService } from "../../questions/services/question.service";
import { Tag } from "../../Tags/tag.model";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Util } from "../../common/util.service";

@Injectable({
    providedIn: 'root' 
})
export class StoryService {
    storySelected = new EventEmitter<Story>();
    private baseUrl = 'http://localhost:8080/stories';
    private stories: Story[] = [];

    constructor(private questionService: QuestionService, private http: HttpClient, private util: Util){
       
    }
    getByQuestion(id): Story[] {
        let tmp_strs: Story[] = [];
        /*for (let stry of this.stories.slice()){
            for (let q of stry.questions.slice()){
                if(q.id === id){
                    tmp_strs.push(stry);
                    break;
                }
            }
        }*/
        return tmp_strs.slice();
    }
    getStories(): Observable<any> {
        return this.http.get(this.baseUrl);
        //return this.stories.slice();
    }

    sqlAll(): Story[] {
        this.addStory(
            "Monitoring infrastructure modules",
            1,
            "monitor infrastructure modules such as cassandra, kafka, storm:",
            "cassandra: can be monitored by nodetool, jmx, or 3rd party. Finally, I decided to install monitor plugin on each node and generate alarms",
            "Less code. Removed complexity. Took advantage of already running monitoring system.",
            [0,1],
            [1,2]
        );
        return this.stories.slice();
    }

    sqlQuestion(sid: Number): Question[] {
        let qs: Question[] = [
            this.questionService.get(0),
            this.questionService.get(1)
        ];
        return qs.slice();
    }

    addStory(name: string, cid: number, s: string, ta: string, r: string, qs, tgs){
        var c = new Company(cid, "Deutsche Telekom", null, null, null, 0, 0, null); // TO DO: companyService.get(cid);
        var sid = this.util.getRandomInt(0, 100);
        var tmp_stry = new Story(sid, name, c, 0, s, ta, r);

        var qlist = qs; // TO DO: for(qid: qs) qlist.add(questionService.get(qid));
        this.stories.push(tmp_stry); // TO DO save(tmp_stry);

        // TO DO: save sid, [qid] into StoryQuestiont table. JOIN TABLE.
        /*
        var qarr: Question[] = [];
        for(let qid of qs){
            qarr.push(this.questionService.get(qid));
        }
        for(let q of qarr){
            tmp_stry.registerQuestion(q);
        }
        */

        // TO DO: save sid, [tgid] into StoryTag table. JOIN TABLE.
        
        var tarr: Tag[] = [];
        /*for(let tid of tgs){
            tarr.push(this.tagService.get(tid));
        }*/
        
        tarr.push(new Tag(1, "#proud")); 
        tarr.push(new Tag(1, "#challenging")); 
        tarr.push(new Tag(1, "#solved"));

        for(let tg of tarr){
            tmp_stry.registerTag(tg);
        }        
    }

    /*getRandomInt(min, max){
        return Math.floor(Math.random() * (max - min +1)) + min;
    }*/

    get(id: number): Observable<Story> {
        const id_link = this.baseUrl + "/" + id;
        console.log("url: " + id_link);
        return this.http.get<Story>(id_link);
        //return this.stories[0];
    }

    /*addIngredientsToShoppingList(ingredients: Ingredient[]){
        this.shoppingListService.addIngredients(ingredients);
    }*/
    
    questionsByStory(id: Number): Observable<Question[]> {
        const URL = this.baseUrl + "/" + id + "/questions";
        return this.http.get<Question[]>(URL);
    }

    create(story: Story): Observable<Story> {
        console.log('FROM SERVICE');
        console.log(story);
    	return this.http.post<Story>(this.baseUrl, story);
    }

    update(id: number, story: Story): Observable<Story> {
        const id_link = this.baseUrl + "/" + id;
    	return this.http.put<Story>(id_link, story);
    }

    delete(id: number): Observable<Story> {
        return this.http.delete<Story>(this.baseUrl + "/" + id);
    }
}
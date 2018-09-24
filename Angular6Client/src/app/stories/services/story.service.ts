import { Story } from "../story.model";
import { EventEmitter, Injectable } from "@angular/core";
import { Company } from "../../company/company.model";
import { Question } from "../../questions/question.model";
import { QuestionService } from "../../questions/services/question.service";
import { Tag } from "../../Tags/tag.model";

@Injectable()
export class StoryService {
    storySelected = new EventEmitter<Story>();
    private stories: Story[] = [
        /*new Story(
            0,
            'StatsPoller', 
            'Deutsche Telekom', 
            0, 
            'S: reduce poller execution time from 15 minute to 10 minute. T/A: re-balance load among all storm bolts. R: 90% traffic is finished in 10 minutes.'
            ),
        new Story(
            1,
            'DataRetention', 
            'Deutsche Telekom', 
            0, 
            'S: remove customer centric data from cassandra. T/A: used topology file to remove ncs call. R: improved performance.'
        )*/
    ];

    constructor(private questionService: QuestionService){
        let tmp_strs: Story[] = this.sqlAll();
        for (let stry of tmp_strs.slice()){
            let qs: Question[] = this.sqlQuestion(stry.id);
            for(let q of qs){
                stry.registerQuestion(q);
            }
        }
    }
    getByQuestion(id): Story[] {
        let tmp_strs: Story[] = [];
        for (let stry of this.stories.slice()){
            for (let q of stry.questions.slice()){
                if(q.id === id){
                    tmp_strs.push(stry);
                    break;
                }
            }
        }
        return tmp_strs.slice();
    }
    getStories() {
        return this.stories.slice();
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

    addStory(name: String, cid: Number, s: String, ta: String, r: String, qs, tgs){
        var c = new Company(cid, "Deutsche Telekom"); // TO DO: companyService.get(cid);
        var sid = this.getRandomInt(0, 100);
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
        
        tarr.push(new Tag(1, "#proud")); tarr.push(new Tag(1, "#challenging")); tarr.push(new Tag(1, "#solved"));

        for(let tg of tarr){
            tmp_stry.registerTag(tg);
        }
        
    }

    getRandomInt(min, max){
        return Math.floor(Math.random() * (max - min +1)) + min;
    }

    get(id){
        return this.stories[0];
    }

    /*addIngredientsToShoppingList(ingredients: Ingredient[]){
        this.shoppingListService.addIngredients(ingredients);
    }*/
}
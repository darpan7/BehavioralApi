import { Company } from "../company/company.model";
import { Tag } from "../Tags/tag.model";
import { Question } from "../questions/question.model";
import { Util } from "../common/util.service";

export class Story {
    public id: Number;
    public title: String;
    public dateCreated: Date;
    //public dateUpdated: Date;
    public situation: String;        
    public taskAction: String;
    public result: String;
    //public parent_story: Number;
    public company: Company;
    //public tags: Tag[] = [];

    constructor(id: Number, name: String, company: Company, parent_story: Number, s: String, ta: String, r: String) {
        this.id = id;
        this.title = name;
        this.company = company;
        //this.parent_story = parent_story;
        this.dateCreated = new Date();
        this.situation = s;
        this.taskAction = ta;
        this.result = r;
        
        //this.tags.push(new Tag(id, "#tag-1"));
        //this.questions.push(new Question(id, "Question 1", "+ve"));
    }

    registerQuestion(question: Question){
        //this.questions.push(question);
    }

    registerTag(tag: Tag){
        //this.tags.push(tag);
    }
}
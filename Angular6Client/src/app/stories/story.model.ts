import { Company } from "../company/company.model";
import { Tag } from "../Tags/tag.model";
import { Question } from "../questions/question.model";

export class Story {
    public id: Number;
    public name: String;
    public dateCreated: Date;
    public dateUpdated: Date;
    public s: String;        
    public ta: String;
    public r: String;
    public parent_story: Number;
    public company: Company;
    public tags: Tag[] = [];
    public questions: Question[] = [];
    public title: String;

    constructor(id: Number, name: String, company: Company, parent_story: Number, s: String, ta: String, r: String) {
        this.name = name;
        this.company = company;
        this.parent_story = parent_story;
        this.dateCreated = new Date();
        this.s = s;
        this.ta = ta;
        this.r = r;
        this.id = id;
        this.title = name;
        
        //this.tags.push(new Tag(id, "#tag-1"));
        //this.tags.push(new Tag(id, "#tag-2"));

        //this.questions.push(new Question(id, "Question 1", "+ve"));
        //this.questions.push(new Question(id, "Question 2", "-ve"));
        //this.questions.push(new Question(id, "Question 3", "+ve"));
    }

    registerQuestion(question: Question){
        this.questions.push(question);
    }

    registerTag(tag: Tag){
        this.tags.push(tag);
    }
}
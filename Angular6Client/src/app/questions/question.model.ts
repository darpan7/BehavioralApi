import { Story } from "../stories/story.model";

export class Question {
    public id: Number;
    public question: string;
    public dateCreated: Date;
    //public dateUpdated: Date;
    //public type: string;

    constructor(id: Number, name: string, type: string) {
        this.question = name;

        this.dateCreated = new Date();
        //this.type = type;
        this.id = id;
    }
}
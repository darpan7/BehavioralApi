import { Question } from "../question.model";
import { EventEmitter, Injectable } from "@angular/core";

@Injectable()
export class QuestionService {
    questionSelected = new EventEmitter<Question>();
    private questions: Question[] = [
        new Question(
            0,
            'Tell me about yourself.', 
            '+ve'
            ),
        new Question(
            1,
            'Tell me about a time where you failed/missed the deadlines.', 
            '-ve'
            )
    ];

    constructor(){}

    get(id) {
        return this.questions[id];
    }
    getQuestions() {
        return this.questions.slice();
    }
}
import { Question } from "../question.model";
import { EventEmitter, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class QuestionService {
    questionSelected = new EventEmitter<Question>();
    private baseUrl = 'http://localhost:8080/questions';
    private questions: Question[] = [];
    /*[
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
    ];*/

    constructor(private http: HttpClient){}

    get(id) {
        return this.questions[id];
    }
    getQuestions(): Observable<any> {
        //return this.questions.slice();
        return this.http.get(this.baseUrl);
    }

    questionsByStory(id: Number): Observable<Question[]> {
        const url = this.baseUrl + "/story/" + id;
        return this.http.get<Question[]>(url);
    }
}
import { Company } from "../company.model";
import { EventEmitter, Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Story } from "../../stories/story.model";
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from "rxjs";
import { Util } from "../../common/util.service";
import * as moment from 'moment';

@Injectable({
    providedIn: 'root' 
})
export class CompanyService {
    companySelected = new EventEmitter<Company>();
    private baseUrl = 'http://localhost:8080/companies';
    private companies: Company[] = [];
    private company: Company;
    private httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(private http: HttpClient, private util: Util){
        
    }

    getCompanies(): Observable<any> {
    	//console.log(this.http.get(this.baseUrl));
        return this.http.get(this.baseUrl);
    }

    get(id: number): Observable<Company> {
        const id_link = this.baseUrl + "/" + id;
        console.log("url: " + id_link);
        return this.http.get<Company>(id_link);
        //return this.companies[0];
    }

    // getCompany(id: number): Company {
    //     const id_link = this.baseUrl + "/" + id;
    //     return this.http.get<Company>(id_link);
    //     // return this.company;
    //     // return new Company(1, 'Test', null, null, null, 0, 0, null);
    // }
    
    storiesByCompany(id: Number): Observable<Story[]> {
        const URL = this.baseUrl + "/" + id + "/stories";
        return this.http.get<Story[]>(URL);
    }
    
    create(company: Company): Observable<Company> {
    	return this.http.post<Company>(this.baseUrl, company);
    }

    update(id: number, company: Company): Observable<Company> {
        const id_link = this.baseUrl + "/" + id;
    	return this.http.put<Company>(id_link, company);
    }

    delete(id: number): Observable<Company> {
        return this.http.delete<Company>(this.baseUrl + "/" + id);
    }

    handleError(error) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // client-side error
            errorMessage = `Error: ${error.error.message}`;
        } else {
            // server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
    }
}
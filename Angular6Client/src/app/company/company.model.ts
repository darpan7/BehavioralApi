import { Util } from "../common/util.service";

export class Company {
    public id: number;
    public jobTitle: string;
    public name: string;
    public dateCreated: Date;
    public joinedAt: Date;
    public leftAt: Date;
    public startSalary: number;        
    public endSalary: number;
    public imagePath: string;

    constructor(
        id: number,
        name: string,
        jobTitle: string,
        joinedAt: Date,
        leftAt: Date,
        startSalary: number,
        endSalary: number,
        imagePath: string
    ) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateCreated = new Date();
        this.joinedAt = joinedAt;
        this.leftAt = leftAt;
        this.startSalary = startSalary;
        this.endSalary = endSalary;
        this.imagePath = imagePath;
    }
}
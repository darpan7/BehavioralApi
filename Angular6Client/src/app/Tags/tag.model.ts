export class Tag {
    public id: Number;
    public name: string;
    public dateCreated: Date;
    public dateUpdated: Date;

    constructor(id: Number, name: string) {
        this.name = name;
        this.dateCreated = new Date();
        this.id = id;
    }
}
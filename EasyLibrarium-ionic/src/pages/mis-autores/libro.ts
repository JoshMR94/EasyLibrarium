import { Autor } from "./autor";

export class Libro {

    //needed to create the books array in MisAutoresPage

    public id: string;
    public title: string;
    public editorial: string;
    public publicationDate: Date;
    public rate: string;
    public authors: Autor[];
    public isbn: string;

    constructor() {
      
    }

}
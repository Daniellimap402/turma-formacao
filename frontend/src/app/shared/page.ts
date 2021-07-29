export class Page<T> {
    content: T[] = [];
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
    numberOfElements: number;
    sort: string;
    first: boolean;
    last: boolean;
}
